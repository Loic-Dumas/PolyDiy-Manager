import java.awt.BorderLayout;

public class Main {

	public static void main(String[] args) throws Exception {
		Application app = new Application();
		app.addUI("login", BorderLayout.CENTER);
		app.addUI("createAccount", BorderLayout.EAST);
		app.addUI("advertisement", BorderLayout.SOUTH);
	}
}


