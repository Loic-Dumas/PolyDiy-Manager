package graphic.ui.user.shop;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import common.facade.list.FacadeSetInfoWishList;
import common.facade.shop.FacadeProductInShop;
import graphic.engine.AbstractUI;
import graphic.engine.UIMessage;
import persistent.Product;

public class ProductInShopUI extends AbstractUI {
	private JButton backUser = new JButton();
	private JButton backShop = new JButton();
	private JButton addCart = new JButton();
	private JButton addWishList = new JButton();
	private JLabel nameProduct = new JLabel();
	private JLabel availableProduct = new JLabel();
	private JTextArea descriptionProduct = new JTextArea();
	private JLabel unitPriceProduct = new JLabel();
	private JLabel sellerProduct = new JLabel();
	private JComboBox<String> selectWishList = new JComboBox<String>();
	private JLabel quantity = new JLabel();
	private JTextField quantityTextField = new JTextField();

	private FacadeProductInShop facadeProduct = new FacadeProductInShop();
	private FacadeSetInfoWishList facadeSetInfoWishList = new FacadeSetInfoWishList();

	Border border = BorderFactory.createLineBorder(Color.black, 1);

	public ProductInShopUI(UIMessage communication) {
		super(communication);
		
		int IDProduct = (int) this.communication.getElement("id_product");
		int IDUser = (int) this.communication.getElement("id_user");
		Product product = this.facadeProduct.createAndGetProduct(IDProduct);
		
		this.facadeSetInfoWishList.createAndGetExistingWishList(IDUser);
		

		this.panel.setLayout(null);

		// user button
		this.backUser.setText("Back to User");
		this.backUser.setBounds(2 , 2, 150, 23);
		this.panel.add(backUser);
		this.backUser.addActionListener(this);
		
		// Shop button
		this.backShop.setText("Back to PDM shop");
		this.backShop.setBounds(160, 2, 150, 23);
		this.panel.add(backShop);
		this.backShop.addActionListener(this);

		// Labels
		this.nameProduct.setText("Product : " + product.getName());
		this.nameProduct.setBounds(15, 50, 270, 23);
		this.panel.add(this.nameProduct);

		this.unitPriceProduct.setText("Price  : " + product.getUnitPrice() + " €");
		this.unitPriceProduct.setBounds(15, 80, 150, 23);
		this.panel.add(this.unitPriceProduct);

		this.descriptionProduct.setText(" Description : \n " + product.getDescription());
		this.descriptionProduct.setBounds(15, 110, 450, 100);
		this.descriptionProduct.setBorder(border);
		this.panel.add(this.descriptionProduct);

		this.sellerProduct.setText("Seller  : " + product.getIDSeller());
		this.sellerProduct.setBounds(280, 50, 300, 23);
		this.panel.add(this.sellerProduct);

		this.availableProduct.setText(this.inStock(product.getStockQuantity()));
		this.availableProduct.setBounds(280, 80, 150, 23);
		this.panel.add(this.availableProduct);

		this.quantity.setText("Quantity  : ");
		this.quantity.setBounds(80, 245, 120, 23);
		this.panel.add(this.quantity);
		
		this.quantityTextField.setText("1");
		this.quantityTextField.setBounds(200, 245, 60, 23);
		this.panel.add(this.quantityTextField);

		this.addCart.setText("Add to cart");
		this.addCart.setBounds(270, 230, 150, 23);
		this.panel.add(addCart);
		this.addCart.addActionListener(this);
		
		//wishlist
		this.selectWishList.setBounds(270, 260, 150, 23);
		for(Iterator<String> i = this.facadeSetInfoWishList.getListID().iterator() ; i.hasNext(); ) {
		    String key = i.next();
			this.selectWishList.addItem(key);		    
		}
		this.panel.add(this.selectWishList);
		

		this.addWishList.setText("Add to wish list");
		this.addWishList.setBounds(270, 290, 150, 23);
		this.panel.add(addWishList);
		this.addWishList.addActionListener(this);
		
		
		

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String result = "";
		if (arg0.getActionCommand().equals("Back to PDM shop")) {
			result = "PDMShop";
		} else if (arg0.getActionCommand().equals("Back to User")) {
			result = "user";
		} else if (arg0.getActionCommand().equals("Add to cart")) {
			Boolean isANumber = false ;
			try {
			     Integer.parseInt(this.quantityTextField.getText()); // to check this is a number or not
			     isANumber = true;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Need a number", "Error", JOptionPane.ERROR_MESSAGE);
				this.quantityTextField.setText("1");
				result = "nothing changes";
			}
			if (isANumber) {
				result = "PDMShop";
				
				int IDProduct = (int) this.communication.getElement("id_product");
				int IDUser = (int) this.communication.getElement("id_user");
				Product product = this.facadeProduct.createAndGetProduct(IDProduct);
				
				this.facadeProduct.addToCart(product.getIDProduct(), product.getUnitPrice(), 
						Integer.parseInt(this.quantityTextField.getText()), IDUser);			
			}
		}else if (arg0.getActionCommand().equals("Add to wish list")) {
			//System.out.println(this.selectWishList.getSelectedItem());
			Boolean isANumber = false ;
			try {
			     Integer.parseInt(this.quantityTextField.getText()); // to check this is a number or not
			     isANumber = true;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Need a number", "Error", JOptionPane.ERROR_MESSAGE);
				this.quantityTextField.setText("1");
				result = "nothing changes";
			}
			if (isANumber) {
				result = "wishLists";
				
				int IDProduct = (int) this.communication.getElement("id_product");
				Product product = this.facadeProduct.createAndGetProduct(IDProduct);
				
//				this.facadeProduct.addToCart(product.getIDProduct(), product.getUnitPrice(), 
//						Integer.parseInt(this.quantityTextField.getText()), IDUser);
				
				this.facadeProduct.addToWishList(IDProduct, product.getUnitPrice(), 
						Integer.parseInt(this.quantityTextField.getText()), 
						this.facadeSetInfoWishList.getIDWishList((String) this.selectWishList.getSelectedItem()));
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

	/**
	 * 
	 * @param stock
	 * @return Available if the product is in Stock or not.
	 */
	public String inStock(int stock) {
		String result = "Not available";
		if (stock > 0) {
			result = "Available";
		}
		return result;
	}

}
