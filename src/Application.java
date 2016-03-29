import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import common.exception.ErrorConnectionException;
import common.facade.FacadeSession;
import graphic.engine.AbstractUI;
import graphic.engine.FactoryUI;
import graphic.ui.LoginUI;
import graphic.ui.EditProfilUI;
import persistent.Session;

/**
 * 
 * 
 * @author Pierre Casati
 * @version 1.0
 * @since 2016-03-03
 */

public class Application extends JFrame implements Observer{
	private static final long serialVersionUID = 1L;
	
	Map<String, AbstractUI> panels = new HashMap<String, AbstractUI>();
	
	Session session = null;
	
	public Application()
	{
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1366, 700);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		
		this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try {
					endSession();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
            }
        });
	}
	
	public void addUI(String ui, String position)
	{
		FactoryUI factory = new FactoryUI();
		switch(ui) {
		case "login":
			this.panels.put(ui, factory.buildLoginUI());
			break;
		case "logout":
			this.panels.put(ui, factory.buildLogoutUI(this.session));
			break;
		case "advertisement":
			this.panels.put(ui, factory.buildAdvertisementUI());
			break;
		case "createAccount":
			this.panels.put(ui, factory.buildCreateAccountUI());
			break;
		case "edit":
			this.panels.put(ui, factory.buildEditProfilUI(this.session));
			break;
		case "update":
			this.panels.put(ui, factory.buildUpdateUI(session));
			break;
		default:
			break;
		}
		this.panels.get(ui).addObserver(this);
		this.add(this.panels.get(ui).getPanel(), position);
		this.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(arg instanceof String) {
			switch((String)arg) {
			case "login":
				LoginUI login = (LoginUI)this.panels.get("login");
				this.session = login.getSession();
				this.clearUI();
				this.addUI("logout", BorderLayout.CENTER);
				this.addUI("edit", BorderLayout.LINE_START);
				break;
			case "logout":
				this.session = null;
				this.clearUI();
				this.addUI("login", BorderLayout.CENTER);
				this.addUI("createAccount", BorderLayout.EAST);
				this.addUI("advertisement", BorderLayout.SOUTH);
				break;
			case "edit":
				this.clearUI();
				this.addUI("update", BorderLayout.CENTER);
				break;
			case "update":
				this.clearUI();
			    this.addUI("edit", BorderLayout.LINE_START);
				this.addUI("logout", BorderLayout.CENTER);
				break;
				
			default:
				System.err.println("problème de cas");
				break;
			}
			this.getContentPane().validate();
			this.repaint();
		} else {
			System.err.println("Problème d'observable");
		}
	}
	
	private void endSession() throws Exception {
		if (this.session != null) {
			FacadeSession facade = new FacadeSession();
			try {
				facade.logout(this.session.getID());
			} catch (ErrorConnectionException e) {
				System.err.println(e.getMessage());
			}
		}
	}
	
	private void clearUI() {
		this.getContentPane().removeAll();
		this.panels.clear();
	}
}
