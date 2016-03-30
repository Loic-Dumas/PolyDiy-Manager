package graphic.ui.user;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
import persistent.Session;
import persistent.list.WishList;

public class PDMShopUI extends AbstractUI {
	private JButton searchProductButton = new JButton();
	
	private JLabel welcome = new JLabel();
	
	private JTextField searchProductFiekd = new JTextField();
	
	private JComboBox<String> selectCategory = new JComboBox<String>();
	
	private JTable table = new JTable();
	private JPanel tablePanel = new JPanel();

	private Session session = null;
	private FacadeManageSetWishList facadeList = new FacadeManageSetWishList();

	public PDMShopUI(UIMessage communication) {
		super(communication);
		this.facadeList.createAndGetSetWishList((int)this.communication.getElement("id_user"));

		this.panel.setLayout(null);

		// welcome textField
		this.welcome.setText("Welcome to the PDM Shop !");
		this.welcome.setBounds(2, 2, 300, 23);
		this.panel.add(welcome);

		// searchProductFiekd textField
		this.searchProductFiekd.setBounds(1, 30, 145, 23);
		this.panel.add(searchProductFiekd);
		
		// searchProductButton button
		this.searchProductButton.setText("Search");
		this.searchProductButton.setBounds(150, 30, 80, 23);
		this.panel.add(searchProductButton);
		this.searchProductButton.addActionListener(this);
		
		this.selectCategory.setBounds(260, 30, 150, 23);
		this.selectCategory.addItem("cat1");
		this.selectCategory.addItem("Peluche");
		this.selectCategory.addItem("Drogue");

		// Table :
		int nbOfRow = 4;//this.facadeList.createAndGetSetWishList(IDUser).count();
		int nbOfColumn = 2;
		String[] title = { "Product", "ID", "Price" };
		Object[][] data = new Object[nbOfRow][nbOfColumn];

		for (int i = 0 ; i < nbOfRow ; i++) {
			Object[] newLine = { "Lama " + i, "24", "15 €"};
			data[i] = newLine;

		}
//		
//		int j = 0;
//		for (Iterator<String> i = this.facadeList.getListIDWishList().iterator(); i.hasNext();) {
//			String key = i.next();
//			WishList wishList = this.facadeList.createAndGetSetWishList(IDUser).getElementByKey(key);
//			Object[] newLine = { wishList.getLabel(), wishList.getID(), "Remove wish list",
//					this.facadeList.getNumberOfProductsInWishList(wishList.getID()) };
//			data[j] = newLine;
//			j++;
//		}

		// prepare the tablePanel
		this.tablePanel.setBounds(2, 60, 500, 400);
		this.tablePanel.setLayout(new BorderLayout());
		// prepare the JTable
		TableModel dataModel = new DataModelSetWishList(data, title);
		this.table.setModel(dataModel);
		tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);
		this.panel.add(this.tablePanel);

//		table.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				if (e.getClickCount() == 1) {
//					JTable target = (JTable) e.getSource();
//					int row = target.getSelectedRow();
//					int column = target.getSelectedColumn();
//					if (column == 2) {
//						deteteWishListActionPerformed((int) table.getValueAt(row, 1));
//					} else {
//						stringActionPerformed("wishList selected : " + table.getValueAt(row, 1));
//					}
//				}
//			}
//		});

	}

	/**
	 * This method is an equivalent to actionPerformed, but with a String and
	 * not an ActionEvent. Specially created for when we click on a product in
	 * the wishList.
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

	/**
	 * This method is an equivalent to actionPerformed, but delete a wishlist
	 * and refresh the page
	 * 
	 * @author loicd_000
	 * @param IDWishlist
	 *            - int : IDWishList to delete
	 */
	public void deteteWishListActionPerformed(int IDWishList) {
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
//		} else if (arg0.getActionCommand().equals("Add")) {
//			try {
//				this.facadeList.createWishList(this.session.getIDUser(), this.newWishList.getText());
//				result = "wishLists";
//			} catch (wishListAlreadyExistException e) {
//				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//				result = "nothing changes";
//			}
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
