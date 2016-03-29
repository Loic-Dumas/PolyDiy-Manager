package graphic.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import graphic.engine.AbstractUI;
import persistent.Session;

public class EditProfilUI extends AbstractUI {
	JButton edit = new JButton();
    Session session =null;
	
	public EditProfilUI(Session session) {
		this.session = session;
		this.edit.setText("Edit Profil");
		//this.edit.setPreferredSize(new Dimension(150, 30));
		this.edit.setBounds(146, 240, 89, 23);
		this.panel.add(this.edit);
		this.edit.addActionListener(this);
		/*this.cancel.setText("Cancel");
		this.cancel.setPreferredSize(new Dimension(150, 30));
		this.cancel.add(this.cancel);
		this.cancel.addActionListener(this);*/
		this.panel.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//FacadeEditProfil facade = new FacadeEditProfil(session);
		try {
			this.notifyObservers("edit");
			this.setChanged();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		}

}

