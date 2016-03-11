import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import common.exception.ErrorConnectionException;
import common.facade.FacadeSession;
import graphic.engine.AbstractUI;
import graphic.engine.FactoryUI;
import graphic.ui.LoginUI;

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
	
	String token = null;
	
	public Application()
	{
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 250);
		
		this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                endSession();
            }
        });
	}
	
	public void addUI(String ui)
	{
		FactoryUI factory = new FactoryUI();
		switch(ui) {
		case "login":
			this.panels.put(ui, factory.buildLoginUI());
			break;
		case "logout":
			this.panels.put(ui, factory.buildLogoutUI(this.token));
		default:
			break;
		}
		this.panels.get(ui).addObserver(this);
		this.setContentPane(this.panels.get(ui).getPanel());
		this.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(arg instanceof String) {
			switch((String)arg) {
			case "login":
				LoginUI login = (LoginUI)this.panels.get("login");
				this.token = login.getToken();
				this.panels.remove("login");
				this.addUI("logout");
				break;
			case "logout":
				this.token = null;
				this.panels.remove("logout");
				this.addUI("login");
			default:
				System.err.println("problème de cas");
				break;
			}
		} else {
			System.err.println("Problème d'observable");
		}
	}
	
	private void endSession() {
		FacadeSession facade = new FacadeSession();
		try {
			facade.logout(this.token);
		} catch (ErrorConnectionException e) {
			System.err.println(e.getMessage());
		}
	}
}
