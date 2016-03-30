package graphic.ui.user.list;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import common.facade.list.FacadeManageCart;
import graphic.dataTable.DataModelSetWishList;
import graphic.engine.AbstractUI;
import persistent.Session;
import persistent.list.ProductWishList;

public class CartUI extends AbstractUI {
	private JButton backUser = new JButton();
	private JButton wishLists = new JButton();
	private JButton cart = new JButton();
	private JLabel wishListLabel = new JLabel();
	private JLabel cartTotalPriceLabel = new JLabel();
	private JTable table = new JTable();
    private JPanel tablePanel = new JPanel(); 
	
	private Session session = null;
	private FacadeManageCart facadeList = new FacadeManageCart(); 

	
	public CartUI(Session session, int IDUser) {
		this.session = session;
		this.facadeList.createAndGetCart(IDUser);
		
		this.panel.setLayout(null);

		// user button
		this.backUser.setText("Back to User");
		this.backUser.setBounds(2, 2, 150, 23);
		this.panel.add(backUser);
		this.backUser.addActionListener(this);

		// wish lists button
		this.wishLists.setText("Wish Lists");
		this.wishLists.setBounds(160, 2, 150, 23);
		this.panel.add(wishLists);
		this.wishLists.addActionListener(this);

		// Cart button
		this.cart.setText("Cart");
		this.cart.setBounds(320, 2, 150, 23);
		this.panel.add(cart);
		this.cart.addActionListener(this);

		this.wishListLabel.setText("Your wish lists :");
		this.wishListLabel.setBounds(2, 30, 300, 23);
		this.panel.add(wishListLabel);
		
		this.cartTotalPriceLabel.setText("Total Price  : " + this.facadeList.getTotalPriceCart() + " €");
		this.cartTotalPriceLabel.setBounds(200, 470, 300, 23);
		this.panel.add(cartTotalPriceLabel);

		
		//Table : 
		int nbOfRow = this.facadeList.createAndGetCart(IDUser).count();
		int nbOfColumn = 4; // the name, the quantity and the unitPrice
		String[] title = { "Product Name", "Quantity", "Price"};
		Object[][] data = new Object[nbOfRow][nbOfColumn];
		
		int j = 0;
		for(Iterator<String> i = this.facadeList.getListIDCart().iterator() ; i.hasNext(); ) {
		    String key = i.next();
		    ProductWishList product = this.facadeList.createAndGetCart(IDUser).getElementByKey(key);
		    Object[] newLine = {product.getName() , product.getQuantity() , "" + product.getUnitPrice() + " €"}; 
			data[j] = newLine;
			j ++;
		}
		
	    this.tablePanel.setBounds(2, 60, 500, 400);
	    this.tablePanel.setLayout(new BorderLayout());
	    //prepare the JTable
		TableModel dataModel = new DataModelSetWishList(data, title);
		this.table.setModel(dataModel);
		tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);
		this.panel.add(this.tablePanel);	
	}
	
	/**
	 * This method is an equivalent to actionPerformed, but with a String and not an ActionEvent.
	 * Specially created for when we click on a product in the wishList.
	 * 
	 * @author loicd_000
	 * @param event
	 */
	public void stringActionPerformed(String event) {
		try {
			this.setChanged();
			this.notifyObservers(event);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//FacadeSession facade = new FacadeSession();
		
		if (arg0.getActionCommand().equals("Back to User")) {
			try {
				this.setChanged();
				this.notifyObservers("user");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		} 
		
		else if (arg0.getActionCommand().equals("Wish Lists")) {
			try {
				this.setChanged();
				this.notifyObservers("wishLists");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		
		else if (arg0.getActionCommand().equals("Cart")) {
			try {
				this.setChanged();
				this.notifyObservers("cart");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}  else {
			System.err.println("Button action not catch.");
		}
	}

}
