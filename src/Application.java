import java.awt.BorderLayout;
import java.awt.Dimension;
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
import graphic.engine.UIMessage;

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
	
	UIMessage message = new UIMessage();
	
	public Application()
	{
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(1366, 700));
		//this.setResizable(false);
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
	
	public void addUI(String ui, String position) {
		FactoryUI factory = new FactoryUI();
		this.panels.put(ui, factory.build(ui, this.message));
		this.panels.get(ui).addObserver(this);
		this.add(this.panels.get(ui).getPanel(), position);
		this.setVisible(true);
	}
	
	/*public void addUI(String ui, String position)
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
	}*/

	@Override
	public void update(Observable o, Object arg) {
		if(arg instanceof UIMessage) {
			this.message = (UIMessage)arg;

			
			switch(message.getTransition()) {
			case "login":
				this.clearUI();
				this.addUI("navBar", BorderLayout.NORTH);
				this.addUI("account", BorderLayout.CENTER);
				break;
			case "logout":
				this.message = new UIMessage();
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
			case "PDMShop":
				this.clearUI();
				this.addUI("navBar", BorderLayout.NORTH);
				this.addUI("PDMShop", BorderLayout.CENTER);
				break;
			case "wishLists":
				this.clearUI();
				this.addUI("navBar", BorderLayout.NORTH);
				this.addUI("wishLists", BorderLayout.CENTER);
				break;
			case "wishList":
				this.clearUI();
				this.addUI("navBar", BorderLayout.NORTH);
				this.addUI("wishList", BorderLayout.CENTER);
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
			this.pack();
		} else {
			System.err.println("UIMessage not send by the UI to application");
		}
	}
	
	private void endSession() throws Exception {
		if (this.message != null) {
			FacadeSession facade = new FacadeSession();
			try {
				facade.logout((int)this.message.getElement("id_account"));
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
