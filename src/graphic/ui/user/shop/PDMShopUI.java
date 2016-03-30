package graphic.ui.user.shop;

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

import common.facade.shop.FacadePDMShop;
import graphic.dataTable.DataModelSetWishList;
import graphic.engine.AbstractUI;
import graphic.engine.UIMessage;
import persistent.Product;

public class PDMShopUI extends AbstractUI {
	private JButton searchProductButton = new JButton();
	private JLabel welcome = new JLabel();
	private JTextField searchProductFiekd = new JTextField();
	private JComboBox<String> selectCategory = new JComboBox<String>();
	private JTable table = new JTable();
	private JPanel tablePanel = new JPanel();

	private FacadePDMShop facadeList = new FacadePDMShop();

	public PDMShopUI(UIMessage communication) {
		super(communication);

		this.facadeList.createAndGetExistingSetProduct();

		this.panel.setLayout(null);

		// welcome textField
		this.welcome.setText("Welcome to the PDM Shop !");
		this.welcome.setBounds(2, 2, 300, 23);
		this.panel.add(welcome);

		// searchProductFiekd textField
		this.searchProductFiekd.setBounds(1, 30, 250, 23);
		this.panel.add(searchProductFiekd);

		// searchProductButton button
		this.searchProductButton.setText("Search");
		this.searchProductButton.setBounds(255, 30, 80, 23);
		this.panel.add(searchProductButton);
		this.searchProductButton.addActionListener(this);

		this.selectCategory.setBounds(350, 30, 150, 23);
		this.selectCategory.addItem("cat1");
		this.selectCategory.addItem("Peluche");
		this.selectCategory.addItem("Drogue");
		this.panel.add(this.selectCategory);

		// Table :
		int nbOfRow = this.facadeList.createAndGetExistingSetProduct().count();
		int nbOfColumn = 2;
		String[] title = { "Product", "Price", " Stock", "ID" };
		Object[][] data = new Object[nbOfRow][nbOfColumn];

		int j = 0;
		for (Iterator<String> i = this.facadeList.getListID().iterator(); i.hasNext();) {
			String key = i.next();
			Product product = this.facadeList.createAndGetExistingSetProduct().getElementByKey(key);
			Object[] newLine = { product.getName(), "" + product.getUnitPrice() + " €",
					inStock(product.getStockQuantity()), product.getIDProduct() };
			System.out.println("J'ai le produit " + product.getName() + " - " + product.getUnitPrice() + " -  "
					+ inStock(product.getStockQuantity()) + " - " + product.getIDProduct());
			data[j] = newLine;
			j++;
		}

		//

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
					
					System.out.println("click on : row : " + row  +" column : " + column + " ID : " + table.getValueAt(row, 3));
					stringActionPerformed((int) table.getValueAt(row, 3));

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
		this.communication.shareElement("id_product", event);
		try {
			this.setChanged();
			this.notifyObservers("productInShop");
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

	public String inStock(int stock) {
		String result = "Not available";
		if (stock > 0) {
			result = "Available";
		}
		return result;
	}

}
