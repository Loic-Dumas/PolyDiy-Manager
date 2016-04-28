package graphic.ui.user;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JTextField;

import graphic.engine.AbstractUI;
import graphic.engine.UIMessage;
import logic.facade.FacadeActivityPanel;

public class ModifyTaskUI extends AbstractUI {
	private JTextField title = new JTextField();
	private JButton update = new JButton("Update");
	private JButton delete = new JButton("Delete");
	private JTextField category = new JTextField();
	
	private FacadeActivityPanel facade = new FacadeActivityPanel();

	public ModifyTaskUI(UIMessage communication) throws Exception {
		super(communication);
		
		this.panel.setLayout(null);

		facade.loadTask((int)this.communication.getElement("id_task"));

		this.title.setBounds(42, 2, 150, 23);
		this.title.setText(facade.getTask().getTitle());
		this.panel.add(title);
		
		// add update button
		this.update.setBounds(202 , 2, 150, 23);
		this.panel.add(update);
		this.update.addActionListener(this);
		
		// add delete button
		this.delete.setBounds(360, 2, 150, 23);
		this.panel.add(delete);
		this.delete.addActionListener(this);

		this.category.setBounds(320, 30, 150, 23);
		this.category.setText(facade.getTaskCategory().getTitle());
		this.panel.add(category);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("Update")) {
			try {
				this.facade.updateTask();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if(arg0.getActionCommand().equals("Delete")) {
			try {
				this.facade.deleteTask();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

}
