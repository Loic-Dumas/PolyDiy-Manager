import common.JDBConnection;

public class Main {

	public static void main(String[] args) {

		try {
				JDBConnection connection = JDBConnection.getInstance();
		         
		    } catch (Exception e) {
		      e.printStackTrace();
		    }      
	}

}


