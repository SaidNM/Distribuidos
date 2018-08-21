package distribuidos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
			salida.flush();
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String cadena = "";
			
			while(!cadena.equals("-1")) {
				cadena = entrada.readLine();
				if(!cadena.equals("-1"))
					System.out.println(cadena);
			}
			entrada.close();
			salida.close();
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
