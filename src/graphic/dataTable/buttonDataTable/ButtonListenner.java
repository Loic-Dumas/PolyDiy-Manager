package graphic.dataTable.buttonDataTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import graphic.ui.list.WishListUI;
import persistent.list.WishList;

class ButtonListener implements ActionListener {

	private int column, row;
	private JTable table;
	private int nbre = 0;
	private JButton button;

	public void setColumn(int col) {
		this.column = col;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getButton() {
		return this.button;
	}

	public void actionPerformed(ActionEvent event) {
		
		System.out.println("coucou, le bouton marche !");
		
		System.out.println("coucou du bouton : " + ((JButton) event.getSource()).getText());
			
		
		//this.button = ((JButton) event.getSource());
	}
}
