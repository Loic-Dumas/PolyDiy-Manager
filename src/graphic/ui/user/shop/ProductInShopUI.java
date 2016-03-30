package graphic.ui.user.shop;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import common.facade.shop.FacadeProductInShop;
import graphic.engine.AbstractUI;
import graphic.engine.UIMessage;
import persistent.Product;

public class ProductInShopUI extends AbstractUI {
	private JButton backShop = new JButton();
	private JButton order = new JButton();
	private JLabel nameProduct = new JLabel();
	private JLabel availableProduct = new JLabel();
	private JTextArea descriptionProduct = new JTextArea();
	private JLabel unitPriceProduct = new JLabel();
	private JLabel sellerProduct = new JLabel();
	private JLabel quantity = new JLabel();
	private JTextField quantityTextField = new JTextField();
	
	
//	JScrollPane areaScrollPane = new JScrollPane(textArea);
//	areaScrollPane.setVerticalScrollBarPolicy(
//	                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//	areaScrollPane.setPreferredSize(new Dimension(250, 250));
	
	private FacadeProductInShop facadeProduct = new FacadeProductInShop();
	
	Border border = BorderFactory.createLineBorder(Color.black, 1);
	
	public ProductInShopUI(UIMessage communication) {
		super(communication);
		
		System.out.println("Je commence à contruire l'ui");
		
		int IDProduct = (int)this.communication.getElement("id_product");
		
		System.out.println("Pour le produit : " + IDProduct);
		
		Product product = this.facadeProduct.createAndGetProduct(IDProduct);

		System.out.println("UI : J'ai construit le produit");
		System.out.println("UI : C'est le produit : " + product.getName());
		
		this.panel.setLayout(null);


		// Shop button
		this.backShop.setText("Back to PDM shop");
		this.backShop.setBounds(2 , 2, 150, 23);
		this.panel.add(backShop);
		this.backShop.addActionListener(this);
		
		// Labels
		this.nameProduct.setText("Product : " +  product.getName());
		this.nameProduct.setBounds(15 , 50, 270, 23);
		this.panel.add(this.nameProduct);

		this.unitPriceProduct.setText("Price  : " +  product.getUnitPrice() + " €");
		this.unitPriceProduct.setBounds(15 , 80, 150, 23);
		this.panel.add(this.unitPriceProduct);

		this.descriptionProduct.setText(" Description : \n " +  product.getDescription());
		this.descriptionProduct.setBounds(15 , 110, 300, 100);
		this.descriptionProduct.setBorder(border);
		this.panel.add(this.descriptionProduct);
		
		this.sellerProduct.setText("Seller  : " +  product.getIDSeller());
		this.sellerProduct.setBounds(280 , 50, 300, 23);
		this.panel.add(this.sellerProduct);

		this.availableProduct.setText(this.inStock(product.getStockQuantity()));
		this.availableProduct.setBounds(280 , 80, 150, 23);
		this.panel.add(this.availableProduct);

		this.quantity.setText("Quantity  : ");
		this.quantity.setBounds(80 , 230, 120, 23);
		this.panel.add(this.quantity);

		this.quantityTextField.setBounds(200 , 230, 60, 23);
		this.panel.add(this.quantityTextField);

		this.order.setText("Order");
		this.order.setBounds(270 , 230, 80, 23);
		this.panel.add(order);
		this.order.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// FacadeSession facade = new FacadeSession();


		String result = "";
		if (arg0.getActionCommand().equals("Back to PDM shop")) {
			result = "PDMShop";
		} 

		// now if there are a change of UI, we notifyObservers
		if (!result.equals("")) {
			try {
				this.setChanged();
				this.notifyObservers(result);
			} catch (Exception e) {
				e.printStackTrace();
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
