package graphic.ui.seller;
/**
 * 
 * @author nassim vachor
 * @version 1.0
 * @since 2016-03-21
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import common.facade.FacadeProduct;
import graphic.dataTable.DataModelSetWishList;
import graphic.engine.AbstractUI;
import graphic.engine.UIMessage;
import persistent.Product;

public class ManageShopUI extends AbstractUI {
		private JTable table;
		private JPanel tablePanel;
		private FacadeProduct facade =  new FacadeProduct((int)this.communication.getElement("id_seller"));
	public ManageShopUI(UIMessage communication) {
		super(communication);
		 table = new JTable();
		 tablePanel = new JPanel();
		 this.facade.createAndGetExistingSetProduct((int)this.communication.getElement("id_seller"));		
		 this.panel.setLayout(null);
		 
			// Table :
			int nbOfRow = this.facade.createAndGetExistingSetProduct((int)this.communication.getElement("id_seller")).count();
			int nbOfColumn = 4;
			String[] title = { "Product", "Price", " Stock", "IDProduct" };
			Object[][] data = new Object[nbOfRow][nbOfColumn];

			int j = 0;
			for (Iterator<String> i = this.facade.getListID().iterator(); i.hasNext();) {
				String key = i.next();
				Product product = this.facade.createAndGetExistingSetProduct((int)this.communication.getElement("id_seller")).getElementByKey(key);
				System.out.println("manage shopUI"+ product.getIDProduct());
				Object[] newLine = { product.getName(), "" + product.getUnitPrice() + " €", inStock(product.getStockQuantity()), product.getIDProduct() };
				System.out.println("J'ai le produit " + product.getName() + " - " + product.getUnitPrice() + " -  "
						+ inStock(product.getStockQuantity()) + " - " + product.getIDProduct());
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
	
	
			
	}
			public String inStock(int stock) {
				String result = "not in stock";
				if (stock > 0) {
					result = "in stock";
				}
				return result;
			}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

}
