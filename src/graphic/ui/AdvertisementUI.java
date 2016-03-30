package graphic.ui;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import graphic.engine.AbstractUI;
import graphic.engine.UIMessage;

public class AdvertisementUI extends AbstractUI{
	private JLabel image;
	
	public AdvertisementUI(UIMessage communication) {
		super(communication);
		this.image = new JLabel( new ImageIcon( "LogoFinal.PNG"));
		this.panel.add(image);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO AdvertisementUI Auto-generated method stub
		
	}

}
