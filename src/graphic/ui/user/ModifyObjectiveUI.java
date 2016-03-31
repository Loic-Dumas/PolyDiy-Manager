package graphic.ui.user;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import common.facade.FacadeActivityPanel;
import graphic.engine.AbstractUI;
import graphic.engine.UIMessage;

public class ModifyObjectiveUI extends AbstractUI {
	private JTextField title = new JTextField();
	private JButton update = new JButton("Update");
	private JButton delete = new JButton("Delete");
	private JTextArea description = new JTextArea();
	private JTextField category = new JTextField();
	private JTextField deadline = new JTextField();
	
	private FacadeActivityPanel facade = new FacadeActivityPanel();

	public ModifyObjectiveUI(UIMessage communication) throws Exception {
		super(communication);
		
		this.panel.setLayout(null);
		
		facade.loadObjective((int)this.communication.getElement("id_objective"));

		this.title.setBounds(42, 2, 150, 23);
		this.title.setText(facade.getObjective().getTitle());
		this.panel.add(title);

		// add update button
		this.update.setBounds(202 , 2, 150, 23);
		this.panel.add(update);
		this.update.addActionListener(this);
		
		// add delete button
		this.delete.setBounds(360, 2, 150, 23);
		this.panel.add(delete);
		this.delete.addActionListener(this);
		
		this.description.setText(facade.getObjective().getDescription());
		this.description.setBounds(15 , 30, 300, 100);
		this.description.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		this.panel.add(this.description);
		
		this.category.setBounds(320, 30, 150, 23);
		this.category.setText(facade.getObjectiveCategory().getTitle());
		this.panel.add(category);

		this.deadline.setBounds(320, 60, 150, 23);
		this.deadline.setText(facade.getObjective().getDeadline());
		this.panel.add(deadline);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Update")) {
			try {
				this.facade.updateObjective();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if(e.getActionCommand().equals("Delete")) {
			try {
				this.facade.deleteObjective();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

}
