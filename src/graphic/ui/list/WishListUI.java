package graphic.ui.list;

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

import common.facade.list.FacadeManageWishList;
import graphic.dataTable.DataModelSetWishList;
import graphic.engine.AbstractUI;
import persistent.Session;
import persistent.list.ProductWishList;

public class WishListUI extends AbstractUI {
	private JButton logout = new JButton();
	private JButton backUser = new JButton();
	private JButton backWishLists = new JButton();
	private JLabel wishListLabel = new JLabel();
	private JLabel wishListTotalPriceLabel = new JLabel();
	private JTable table = new JTable();
    private JPanel tablePanel = new JPanel(); 
	
	private Session session = null;
	private FacadeManageWishList facadeList = new FacadeManageWishList(); 

	
	public WishListUI(Session session, int IDWishList) {
		this.session = session;
		this.facadeList.createAndGetWishList(IDWishList);
		
		this.panel.setLayout(null);

		// logout button
		this.logout.setText("Back to logout");
		this.logout.setBounds(2, 2, 150, 23);
		this.panel.add(logout);
		this.logout.addActionListener(this);

		// user button
		this.backUser.setText("Back to User");
		this.backUser.setBounds(160 , 2, 150, 23);
		this.panel.add(backUser);
		this.backUser.addActionListener(this);
		
		// wish lists button
		this.backWishLists.setText("Back to WishLists");
		this.backWishLists.setBounds(2 , 60, 150, 23);
		this.panel.add(backWishLists);
		this.backWishLists.addActionListener(this);

		this.wishListLabel.setText("WishList : " + this.facadeList.getNameWishList());
		this.wishListLabel.setBounds(2, 30, 300, 23);
		this.panel.add(wishListLabel);

		this.wishListTotalPriceLabel.setText("Total Price  : " + this.facadeList.getTotalPriceWishList() + " €");
		this.wishListTotalPriceLabel.setBounds(200, 500, 300, 23);
		this.panel.add(wishListTotalPriceLabel);

		
		//Table : 
		int nbOfRow = this.facadeList.createAndGetWishList(IDWishList).count();
		int nbOfColumn = 4; // the name, the quantity and the unitPrice
		String[] title = { "Product Name", "Quantity", "Price"};
		Object[][] data = new Object[nbOfRow][nbOfColumn];
		
		int j = 0;
		for(Iterator<String> i = this.facadeList.getListIDProduct().iterator() ; i.hasNext(); ) {
		    String key = i.next();
		    ProductWishList product = this.facadeList.createAndGetWishList(IDWishList).getElementByKey(key);
		    Object[] newLine = {product.getName() , product.getQuantity() , product.getUnitPrice()}; 
			data[j] = newLine;
			j ++;
		}
		
	    this.tablePanel.setBounds(2, 90, 500, 400);
	    this.tablePanel.setLayout(new BorderLayout());
	    //prepare the JTable
		TableModel dataModel = new DataModelSetWishList(data, title);
		this.table.setModel(dataModel);
		tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);
		this.panel.add(this.tablePanel);	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if (arg0.getActionCommand().equals("Back to User")) {
			//System.out.println("UserUI - actionPerformed - case user");
			try {
				this.setChanged();
				this.notifyObservers("user");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		} 

		
		else if (arg0.getActionCommand().equals("Back to logout")) {
			//System.out.println("logoutUI - actionPerformed - case logout");
			try {
				this.setChanged();
				this.notifyObservers("back to logout");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		

		
		else if (arg0.getActionCommand().equals("Back to WishLists")) {
			try {
				this.setChanged();
				this.notifyObservers("wishLists");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
