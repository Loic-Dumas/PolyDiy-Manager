import javax.swing.JFrame;

import login.LoginUI;

public class Main {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(400, 100);
		window.setTitle("PolyDIY Manager");
		
		LoginUI loginUI = new LoginUI();
		window.setContentPane(loginUI);
		window.setVisible(true);
	}
}


