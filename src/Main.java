import java.awt.BorderLayout;

/**
 * Generate the application with default screen.
 */
public class Main {

	public static void main(String[] args) throws Exception {
		Application app = new Application();
		app.addUI("login", BorderLayout.NORTH);
		app.addUI("createAccount", BorderLayout.CENTER);
	}
}