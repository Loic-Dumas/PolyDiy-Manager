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
import graphic.engine.AbstractUI;
import graphic.engine.FactoryUI;
import graphic.engine.UIMessage;
import logic.facade.FacadeSession;

/**
 * test
 * 
 * @author Pierre Casati - LoicD000
 * @version 1.1
 * @since 2016-03-028
 */

/**
 * Personalize JFrame and implements mechanics of switch between UIs.
 */
public class Application extends JFrame implements Observer{
	private static final long serialVersionUID = 1L;
	
	Map<String, AbstractUI> panels = new HashMap<String, AbstractUI>();

	UIMessage message = new UIMessage();

	/**
	 * Constructor of the application - initialize the window.
	 */
	public Application()
	{
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(800, 700));
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
	
	/**
	 * add an UI in the window
	 * @param ui - label of the UI to build.
	 * @param position - position of the UI in the window, following the BordeLayout manager.
	 */
	public void addUI(String ui, String position) {
		FactoryUI factory = new FactoryUI();
		this.panels.put(ui, factory.build(ui, this.message));
		this.panels.get(ui).addObserver(this);
		this.add(this.panels.get(ui).getPanel(), position);
		this.setVisible(true);
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 * Implement the switch between UIs.
	 */
	@Override
	public void update(Observable o, Object arg) {
		if(arg instanceof UIMessage) {
			this.message = (UIMessage)arg;

			
			switch(message.getTransition()) {
			case "login":
				this.clearUI();
				this.addUI("navBar", BorderLayout.NORTH);
				this.addUI("account_welcome", BorderLayout.CENTER);
				break;
			case "logout":
				this.message = new UIMessage();
				this.clearUI();
				this.addUI("login", BorderLayout.NORTH);
				this.addUI("createAccount", BorderLayout.CENTER);
				break;
			case "edit":
				this.clearUI();
				this.addUI("navBar", BorderLayout.NORTH);
				this.addUI("update", BorderLayout.CENTER);
				//this.addUI("manageShopUI", BorderLayout.CENTER);
				break;
			case "update":
				this.clearUI();
			    this.addUI("edit", BorderLayout.LINE_START);
				this.addUI("logout", BorderLayout.CENTER);
				break;
			case "account":
				this.clearUI();
				this.addUI("navBar", BorderLayout.NORTH);
				this.addUI("account_welcome", BorderLayout.CENTER);
				break;
			case "updateAccount":
				this.clearUI();
				this.addUI("navBar", BorderLayout.NORTH);
				this.addUI("updateAccount", BorderLayout.CENTER);
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
			case "productInShop":
				this.clearUI();
				this.addUI("navBar", BorderLayout.NORTH);
				this.addUI("productInShop", BorderLayout.CENTER);
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
			case "activityPanel":
				this.clearUI();
				this.addUI("navBar", BorderLayout.NORTH);
				this.addUI("activityPanel", BorderLayout.CENTER);
				break;
			case "manage":
				this.clearUI();
				this.addUI("navBar", BorderLayout.NORTH);
				this.addUI("manageShopUI", BorderLayout.CENTER);
				break;
			case "addProduct":
				this.clearUI();
				this.addUI("navBar", BorderLayout.NORTH);
				this.addUI("addProduct", BorderLayout.CENTER);
				break;
			case "modifyActivity":
				this.clearUI();
				this.addUI("navBar", BorderLayout.NORTH);
				this.addUI("modifyActivity", BorderLayout.CENTER);
				break;
			case "modifyTask":
				this.clearUI();
				this.addUI("navBar", BorderLayout.NORTH);
				this.addUI("modifyTask", BorderLayout.CENTER);
				break;
			case "modifyObjective":
				this.clearUI();
				this.addUI("navBar", BorderLayout.NORTH);
				this.addUI("modifyObjective", BorderLayout.CENTER);
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
	
	/**
	 * End the session before closing the application.
	 * @throws Exception Different error to display to user.
	 */
	private void endSession() throws Exception {
		if (this.message != null && this.message.isExisting("id_account")) {
			FacadeSession facade = new FacadeSession();
			try {
				facade.logout((int)this.message.getElement("id_account"));
			} catch (ErrorConnectionException e) {
				System.err.println(e.getMessage());
			}
		}
	}
	
	/**
	 * Remove all the UI from the application.
	 */
	private void clearUI() {
		this.getContentPane().removeAll();
		this.panels.clear();
	}
}
