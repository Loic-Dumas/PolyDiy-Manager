package graphic.ui.list;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import common.facade.list.FacadeManageSetWishList;
import graphic.dataTable.DataModelSetWishList;
import graphic.engine.AbstractUI;
import persistent.Session;
import persistent.list.WishList;

public class WishListsUI extends AbstractUI {
	private JButton logout = new JButton();
	private JButton backUser = new JButton();
	private JButton wishLists = new JButton();
	private JButton cart = new JButton();
	private JLabel wishListLabel = new JLabel();
	private JTable table = new JTable();
    private JPanel tablePanel = new JPanel(); 
	
	private Session session = null;
	private FacadeManageSetWishList facadeList = new FacadeManageSetWishList(); 

	
	public WishListsUI(Session session, int IDUser) {
		this.session = session;
		this.facadeList.createAndGetSetWishList(IDUser);
		
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
		this.wishLists.setText("Wish Lists");
		this.wishLists.setBounds(2, 30, 150, 23);
		this.panel.add(wishLists);
		this.wishLists.addActionListener(this);

		// Cart button
		this.cart.setText("Cart");
		this.cart.setBounds(160 , 30, 150, 23);
		this.panel.add(cart);
		this.cart.addActionListener(this);

		this.wishListLabel.setText("Your wish lists :");
		this.wishListLabel.setBounds(2, 60, 300, 23);
		this.panel.add(wishListLabel);

		
		//Table : 
		int nbOfRow = this.facadeList.createAndGetSetWishList(IDUser).count();
		int nbOfColumn = 2; 
		String[] title = { "WishList Name", "Accés"};
		Object[][] data = new Object[nbOfRow][nbOfColumn];
		
		int j = 0;
		for(Iterator<String> i = this.facadeList.getListIDWishList().iterator() ; i.hasNext(); ) {
		    String key = i.next();
		    WishList whisList = this.facadeList.createAndGetSetWishList(IDUser).getElementByKey(key);
		    Object[] newLine = {whisList.getLabel() , whisList.getID()}; 
			data[j] = newLine;
			j ++;
		}
		
		//prepare the tablePanel
	    this.tablePanel.setBounds(2, 90, 500, 400);
	    this.tablePanel.setLayout(new BorderLayout());
	    //prepare the JTable
		TableModel dataModel = new DataModelSetWishList(data, title);
		this.table.setModel(dataModel);
		tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);
		this.panel.add(this.tablePanel);
		
		table.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(MouseEvent e) {
			    if (e.getClickCount() == 1) {
			      JTable target = (JTable)e.getSource();
			      int row = target.getSelectedRow();
			      int column = target.getSelectedColumn();
			      System.out.println("cliked in : " + row + " : " + column + " -> " +  table.getValueAt(row, column));
			      stringActionPerformed("wishList selected : " + table.getValueAt(row, 1));
			    }
			  }
			});
		
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

		else if (arg0.getActionCommand().equals("Back to logout")) {
			try {
				this.setChanged();
				this.notifyObservers("back to logout");
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
		}
	}

}
