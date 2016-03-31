package graphic.ui.seller;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import graphic.engine.AbstractUI;
import graphic.engine.UIMessage;
import logic.facade.FacadeProduct;
                                                       
public class AddProductUI extends AbstractUI{
	private JTextField name;
	 private JLabel label;
	 private JTextField description; 
	 private JLabel label1; 
	 JTextField unitPrice; 
	 private JLabel label2;
	 JTextField stockQuantity; 
	 private JLabel label3;
	 JTextField categoryName; 
	 private JLabel label4;
	 JButton cancel = new JButton();
	 JButton addP = new JButton();
	 private FacadeProduct facade =  new FacadeProduct((int)this.communication.getElement("id_seller"));
	 public AddProductUI(UIMessage communication){
		super(communication);
			//this.nameShop.setPreferredSize(new Dimension(150, 30));
		this.panel.setLayout(null);
		label = new JLabel("Name of Produc");
		this.label.setBounds(123, 80, 100, 14);
		this.panel.add(label);
		name = new JTextField();
		this.name.setBounds(219, 80, 182, 20);
		this.panel.add(name);
		//this.description.setPreferredSize(new Dimension(150, 30));
		description = new JTextField();
		this.description.setBounds(219, 120, 182, 20);
		label1 = new JLabel("Description"); 
		this.label1.setBounds(123, 120, 100, 14);
		this.panel.add(this.label1);
		this.panel.add(this.description);
		//this.siret.setPreferredSize(new Dimension(150, 30));
		unitPrice = new JTextField();
		this.unitPrice.setBounds(219, 160, 182, 20);
		label2 = new JLabel("Unit Price");
		this.label2.setBounds(123,160,100, 14);
		this.panel.add(this.label2);
		this.panel.add(this.unitPrice);
		//this.website.setPreferredSize(new Dimension(150, 30));
		stockQuantity = new JTextField();
		this.stockQuantity.setBounds(219, 200, 182, 20);
		label3 = new JLabel("stock Quantity");
		this.label3.setBounds(123,200,100, 14);
		this.panel.add(this.label3);
		this.panel.add(this.stockQuantity);
		
		categoryName = new JTextField();
		this.categoryName.setBounds(219, 240, 182, 20);
		label4 = new JLabel("Category Name");
		this.label4.setBounds(123,240,100, 14);
		this.panel.add(this.label4);
		this.panel.add(this.categoryName);
		
		 this.addP.setBounds(143, 280, 120, 30);
		 this.addP.setText("Add to Shop");
		 this.panel.add(this.addP);		
		 this.addP.addActionListener(this);
		
		//this.cancel.setPreferredSize(new Dimension(150, 30));
		this.cancel.setBounds(340, 280, 120, 30);
		 this.cancel.setText("Cancel");
		 this.panel.add(this.cancel);
		 this.cancel.addActionListener(this);
		 this.panel.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		/*if (arg0.getActionCommand()== "Add to Shop"){
			this.facade.addProduct(1, this.name.getText(), this.description.getText(), this.unitPrice.getText(), this.stockQuantity.getText(), (int)this.communication.getElement("id_seller"), 1,"Cuisine");
			this.setChanged();
			this.notifyObservers("seller");
			}*/
		if (arg0.getSource()== cancel){
			this.setChanged();
			this.notifyObservers("manage");
			
		}
	}
	 

}
