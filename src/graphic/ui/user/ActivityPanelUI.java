package graphic.ui.user;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import graphic.dataTable.DataModelSetWishList;
import graphic.engine.AbstractUI;
import graphic.engine.UIMessage;
import logic.facade.FacadeActivityPanel;
import persistent.abstractclass.Activity;
import persistent.abstractclass.Objective;
import persistent.abstractclass.Task;

public class ActivityPanelUI extends AbstractUI{
	private JButton addActivity = new JButton("+ Activity");
	private JButton addTask = new JButton("+ Task");
	private JButton addObjective = new JButton("+ Objective");
	private JTable activities = new JTable();
	private JPanel activitiesPanel = new JPanel();
	private JTable tasks = new JTable();
	private JPanel tasksPanel = new JPanel();
	private JTable objectives = new JTable();
	private JPanel objectivesPanel = new JPanel();

	public ActivityPanelUI(UIMessage communication) {
		super(communication);
		
		this.panel.setLayout(null);


		// add activity button
		this.addActivity.setBounds(2 , 2, 150, 23);
		this.panel.add(addActivity);
		this.addActivity.addActionListener(this);
		
		// add task button
		this.addTask.setBounds(160, 2, 150, 23);
		this.panel.add(addTask);
		this.addTask.addActionListener(this);
		
		// add objective button
		this.addObjective.setBounds(318, 2, 150, 23);
		this.panel.add(addObjective);
		this.addObjective.addActionListener(this);
		

		FacadeActivityPanel facade = new FacadeActivityPanel();
		// add activities list
		try {
			facade.loadActivities((int)this.communication.getElement("id_user"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		int nbOfRowActivity = facade.getNumberOfActivites();
		String[] titleActivity = {"Activities", "ID"};
		Object[][] dataActivity = new Object[nbOfRowActivity][2];

		int jActivity = 0;
		Collection<Activity> activitiesObj = facade.getActivities();
		for (Activity element : activitiesObj) {
			dataActivity[jActivity][0] = element.getTitle();
			dataActivity[jActivity][1] = element.getIdActivity();
			jActivity++;
		}

		// prepare the activitiesPanel
		this.activitiesPanel.setBounds(2, 60, 500, 150);
		this.activitiesPanel.setLayout(new BorderLayout());
		// prepare the activitiesTable
		this.activities.setModel(new DataModelSetWishList(dataActivity, titleActivity));
		this.activitiesPanel.add(new JScrollPane(this.activities), BorderLayout.CENTER);
		this.panel.add(this.activitiesPanel);
		
		this.activities.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					JTable target = (JTable) e.getSource();
					int row = target.getSelectedRow();
					//int column = target.getSelectedColumn();
					
					communication.shareElement("id_activity", activities.getValueAt(row, 1));
					actionPerformed(new ActionEvent(activitiesPanel, 0, "activity"));
				}
			}
		});
		
		// add tasks list
		try {
			facade.loadTasks((int)this.communication.getElement("id_user"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		int nbOfRowTasks = facade.getNumberOfTasks();
		String[] titleTasks = {"Tasks", "ID"};
		Object[][] dataTasks = new Object[nbOfRowTasks][2];

		int jTasks = 0;
		Collection<Task> tasksObj = facade.getTasks();
		for (Task element : tasksObj) {
			dataTasks[jTasks][0] = element.getTitle();
			dataTasks[jTasks][1] = element.getIdActivity();
			jTasks++;
		}

		// prepare the activitiesPanel
		this.tasksPanel.setBounds(2, 220, 500, 150);
		this.tasksPanel.setLayout(new BorderLayout());
		// prepare the activitiesTable
		this.tasks.setModel(new DataModelSetWishList(dataTasks, titleTasks));
		this.tasksPanel.add(new JScrollPane(this.tasks), BorderLayout.CENTER);
		this.panel.add(this.tasksPanel);
		
		this.tasks.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					JTable target = (JTable) e.getSource();
					int row = target.getSelectedRow();
					//int column = target.getSelectedColumn();
					
					communication.shareElement("id_task", tasks.getValueAt(row, 1));
					actionPerformed(new ActionEvent(tasksPanel, 0, "task"));
				}
			}
		});
		
		// add objectives list
		try {
			facade.loadObjectives((int)this.communication.getElement("id_user"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		int nbOfRowObjectives = facade.getNumberOfObjectives();
		String[] titleObjectives = {"Objectives", "ID"};
		Object[][] dataObjectives = new Object[nbOfRowObjectives][2];

		int jObjectives = 0;
		Collection<Objective> objectivesObj = facade.getObjectives();
		for (Objective element : objectivesObj) {
			dataObjectives[jObjectives][0] = element.getTitle();
			dataObjectives[jObjectives][1] = element.getIdObjective();
			jObjectives++;
		}

		// prepare the activitiesPanel
		this.objectivesPanel.setBounds(2, 380, 500, 150);
		this.objectivesPanel.setLayout(new BorderLayout());
		// prepare the activitiesTable
		this.objectives.setModel(new DataModelSetWishList(dataObjectives, titleObjectives));
		this.objectivesPanel.add(new JScrollPane(this.objectives), BorderLayout.CENTER);
		this.panel.add(this.objectivesPanel);
		
		this.objectives.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					JTable target = (JTable) e.getSource();
					int row = target.getSelectedRow();
					//int column = target.getSelectedColumn();
					
					communication.shareElement("id_objective", objectives.getValueAt(row, 1));
					actionPerformed(new ActionEvent(objectivesPanel, 0, "objective"));
				}
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch(arg0.getActionCommand()) {
		case "+ Activity":
			communication.shareElement("id_activity", -1);
			this.setChanged();
			this.notifyObservers("modifyActivity");
			break;
		case "+ Task":
			communication.shareElement("id_task", -1);
			this.setChanged();
			this.notifyObservers("modifyTask");
			break;
		case "+ Objective":
			communication.shareElement("id_objective", -1);
			this.setChanged();
			this.notifyObservers("modifyObjective");
			break;
		case "activity":
			this.setChanged();
			this.notifyObservers("modifyActivity");
			break;
		case "task":
			this.setChanged();
			this.notifyObservers("modifyTask");
			break;
		case "objective":
			this.setChanged();
			this.notifyObservers("modifyObjective");
			break;
		default:
			break;
		}
	}

}
