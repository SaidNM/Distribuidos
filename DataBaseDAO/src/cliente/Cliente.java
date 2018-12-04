package cliente;

import java.util.ArrayList;
import java.net.Socket;

public class Cliente{
	
	protected static ArrayList<String[]> al = new ArrayList<String[]>();
	protected static final String LOCALHOST = "127.0.0.1";
	protected static final int PORT = 8000;
	protected static String[][] data;
	public static Socket client;
	
	public static void main( String[] args ){
		try{
			client = new Socket( LOCALHOST, PORT );
			UserInterface gui = new UserInterface();
			gui.init();
		}catch( Exception e ){
			e.printStackTrace();
		}
	} // End main.

} // End class.
