package graphic.ui.user.list;

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
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import common.exception.wishListAlreadyExistException;
import common.facade.list.FacadeManageSetWishList;
import graphic.dataTable.DataModelSetWishList;
import graphic.engine.AbstractUI;
import graphic.engine.UIMessage;
import persistent.list.WishList;

public class WishListsUI extends AbstractUI {
	private JButton backUser = new JButton();
	private JButton wishLists = new JButton();
	private JButton cart = new JButton();
	private JButton addNewWishListButton = new JButton();
	private JLabel wishListLabel = new JLabel();
	private JLabel labelNewWishList = new JLabel();
	private JTextField newWishList = new JTextField();
	private JTable table = new JTable();
	private JPanel tablePanel = new JPanel();
	
	private FacadeManageSetWishList facadeList = new FacadeManageSetWishList();

	public WishListsUI(UIMessage communication) {
		super(communication);
		this.facadeList.createAndGetSetWishList((int)this.communication.getElement("id_user"));

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

		// add new WishList
		this.labelNewWishList.setText("Name of the wishList : ");
		this.labelNewWishList.setBounds(2, 470, 150, 23);
		this.panel.add(labelNewWishList);

		this.newWishList.setBounds(130, 470, 302, 23);
		this.panel.add(newWishList);

		this.addNewWishListButton.setText("Add");
		this.addNewWishListButton.setBounds(442, 470, 60, 23);
		this.panel.add(this.addNewWishListButton);
		this.addNewWishListButton.addActionListener(this);

		// Table :
		int nbOfRow = this.facadeList.createAndGetSetWishList((int)this.communication.getElement("id_user")).count();
		int nbOfColumn = 2;
		String[] title = { "WishList Name", "ID", "Remove", "number of products" };
		Object[][] data = new Object[nbOfRow][nbOfColumn];

		int j = 0;
		for (Iterator<String> i = this.facadeList.getListIDWishList().iterator(); i.hasNext();) {
			String key = i.next();
			WishList wishList = this.facadeList.createAndGetSetWishList((int)this.communication.getElement("id_user")).getElementByKey(key);
			Object[] newLine = { wishList.getLabel(), wishList.getID(), "Remove wish list",
					this.facadeList.getNumberOfProductsInWishList(wishList.getID()) };
			data[j] = newLine;
			j++;
		}

		// prepare the tablePanel
		this.tablePanel.setBounds(2, 60, 500, 400);
		this.tablePanel.setLayout(new BorderLayout());
		// prepare the JTable
		TableModel dataModel = new DataModelSetWishList(data, title);
		this.table.setModel(dataModel);
		tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);
		this.panel.add(this.tablePanel);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					JTable target = (JTable) e.getSource();
					int row = target.getSelectedRow();
					int column = target.getSelectedColumn();
					if (column == 2) {
						deteteWishListActionPerformed((int) table.getValueAt(row, 1));
					} else {
						stringActionPerformed((int)table.getValueAt(row, 1));
					}
				}
			}
		});

	}

	/**
	 * This method is an equivalent to actionPerformed, but with a String and
	 * not an ActionEvent. Specially created for when we click on a product in
	 * the wishList.
	 * 
	 * @author loicd_000
	 * @param event
	 */
	public void stringActionPerformed(int event) {
		try {
			this.communication.shareElement("id_wishlist", event);
			this.setChanged();
			this.notifyObservers("wishList");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * This method is an equivalent to actionPerformed, but delete a wishlist
	 * and refresh the page
	 * 
	 * @author loicd_000
	 * @param IDWishlist
	 *            - int : IDWishList to delete
	 */
	public void deteteWishListActionPerformed(int IDWishList) {
		this.communication.shareElement("IDWishList", IDWishList);
		
		try {
			this.facadeList.deleteWishList(IDWishList);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			this.setChanged();
			this.notifyObservers("wishLists");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// first we treat the change of UI
		String result = "";
		if (arg0.getActionCommand().equals("Back to User")) {
			result = "user";
		} else if (arg0.getActionCommand().equals("Wish Lists")) {
			result = "wishLists";
		} else if (arg0.getActionCommand().equals("Cart")) {
			result = "cart";
		} else if (arg0.getActionCommand().equals("Add")) {
			try {
				this.facadeList.createWishList((int)this.communication.getElement("id_user"), this.newWishList.getText());
				result = "wishLists";
			} catch (wishListAlreadyExistException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				result = "nothing changes";
			}
		}

		// now if there are a change of UI, we notifyObservers
		if (result.equals("nothing changes")) {
			// nothing to do
		} else if (!result.equals("")) {
			try {
				this.setChanged();
				this.notifyObservers(result);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}

		// If we arrive here, there is a mistake.
		else {
			System.err.println("Button action not catch.");
		}
	}

}
