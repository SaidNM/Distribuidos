package distribuidos;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Cliente {
	private static final int PUERTO = 6666;

	public static void main (String[] args) {
		Socket socket = null;
		String query = JOptionPane.showInputDialog(null,"Query");
		try {
			socket = new Socket("localhost",PUERTO);
			PrintStream salida = new PrintStream(socket.getOutputStream());
			salida.println(query);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				socket.close();
			}catch(IOException ee) {
				ee.printStackTrace();
			}
		}
	}

}
