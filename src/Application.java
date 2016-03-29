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
import persistent.Session;

/**
 * 
 * 
 * @author Pierre Casati - LoicD000
 * @version 1.1
 * @since 2016-03-028
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
		case "navBar":
			this.panels.put(ui, factory.buildNavBarUI(this.session));
			break;
		case "account":
			this.panels.put(ui, factory.buildAccountUI(this.session));
			break;
		case "user":
			this.panels.put(ui, factory.buildUserUI(this.session));
			break;
		case "seller":
			this.panels.put(ui, factory.buildSellerUI(this.session));
			break;
		case "admin":
			this.panels.put(ui, factory.buildAdminUI(this.session));
			break;
		case "wishLists":
			this.panels.put(ui, factory.buildWishListsUI(this.session, 1));
			break;
		case "cart":
			this.panels.put(ui, factory.buildCartUI(this.session, 1));
			break;
		default:
			
			if (ui.contains("wishList selected : ")) {
				this.panels.put(ui, factory.buildWishListUI(this.session, Integer.valueOf(ui.replaceAll("wishList selected : ", ""))));	
			} else {
				System.err.println("No panel to add");
			}
			
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
				this.addUI("navBar", BorderLayout.NORTH);
				this.addUI("account", BorderLayout.CENTER);
				break;
			case "logout":
				this.session = null;
				this.clearUI();
				this.addUI("login", BorderLayout.CENTER);
				this.addUI("createAccount", BorderLayout.EAST);
				this.addUI("advertisement", BorderLayout.SOUTH);
				break;
			case "account":
				this.clearUI();
				this.addUI("navBar", BorderLayout.NORTH);
				this.addUI("account", BorderLayout.CENTER);
				break;
			case "user":
				this.clearUI();
				this.addUI("navBar", BorderLayout.NORTH);
				this.addUI("user", BorderLayout.CENTER);
				break;
			case "seller":
				this.clearUI();
				this.addUI("navBar", BorderLayout.NORTH);
				this.addUI("seller", BorderLayout.CENTER);
				break;
			case "admin":
				this.clearUI();
				this.addUI("navBar", BorderLayout.NORTH);
				this.addUI("admin", BorderLayout.CENTER);
				break;
			case "back to logout":
				this.clearUI();
				this.addUI("navBar", BorderLayout.NORTH);
				this.addUI("logout", BorderLayout.CENTER);
				break;
			case "wishLists":
				this.clearUI();
				this.addUI("navBar", BorderLayout.NORTH);
				this.addUI("wishLists", BorderLayout.CENTER);
				break;
			case "cart":
				this.clearUI();
				this.addUI("navBar", BorderLayout.NORTH);
				this.addUI("cart", BorderLayout.CENTER);
				break;
			default:
				if (((String) arg).contains("wishList selected :")) {
					this.clearUI();
					this.addUI("navBar", BorderLayout.NORTH);
					this.addUI(((String) arg), BorderLayout.CENTER);
				} else {
					System.err.println("problème de cas");
				}
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
