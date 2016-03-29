package graphic.dataTable.buttonDataTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;

class ButtonListener implements ActionListener {

	private int column;
	private int  row;
	@SuppressWarnings("unused")
	private JTable table;
	
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
		System.out.println("coucou du bouton : " + ((JButton) event.getSource()).getText());
		System.out.println("Info : " + column + " - " + row );
			
		
		//this.button = ((JButton) event.getSource());
	}
}
