package distribuidos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class SQLConexion extends Thread{
	protected Socket socketCliente;
	   protected BufferedReader entrada;
	   protected PrintStream salida;
	   protected String consulta;
	   
	   
	    public SQLConexion(Socket socketCliente){
	       this.socketCliente = socketCliente;
	       try{
	           this.entrada = new BufferedReader(new InputStreamReader(this.socketCliente.getInputStream()));
	           this.salida =  new PrintStream(this.socketCliente.getOutputStream());
	           start();
	           salida.flush();
	       }
	       catch(IOException e){
	           System.err.println(e);
	           try{
	               this.socketCliente.close();
	           }
	           catch(IOException e2){
	               e2.printStackTrace();
	           }
	       }
	   }
	    
	    @Override
	    public void run(){
	        try{
	            this.consulta = entrada.readLine();
	            System.out.println("Consulta a ejecutar: " + consulta + ";");
	            ejecutaSQL();
	        }
	        catch(IOException e){
	            e.printStackTrace();
	        }
	        finally{
	            try{
	                socketCliente.close();
	            }
	            catch(IOException e){
	                e.printStackTrace();
	            }
	        }
	    }
	    
	    public void ejecutaSQL(){
	        Connection conn;
	        Statement st;
	        ResultSet rs;
	        ResultSetMetaData resultSetMetaData;
	        boolean existenMasFilas;
	        String driver = "com.mysql.jdbc.Driver";
	        String usuario = "root", password = "saidnm", registro;
	        int numColumnas, i;
	        
	        try{
	            Class.forName(driver);
	            conn = DriverManager.getConnection("jdbc:mysql://localhost/test", usuario, password);
	            st = conn.createStatement();
	            rs = st.executeQuery(consulta);
	            existenMasFilas = rs.next();
	            if(!existenMasFilas){
	                salida.println("No hay mas filas");
	                return;
	            }
	            resultSetMetaData = rs.getMetaData();
	            numColumnas = resultSetMetaData.getColumnCount();
	            System.out.println("Hay: " + numColumnas  + " columnas en el resultado");
	            
	            while(existenMasFilas){
	                registro = "";
	                for( i=1; i <= numColumnas; i++){
	                    registro = registro.concat(rs.getString(i) + "  ");
	                }
	                salida.println(registro);
	                System.out.println(registro);
	                existenMasFilas = rs.next();
	            }
	            salida.println("-1");
	            rs.close();
	            st.close();
	            conn.close();
	        }
	        catch(Exception e){
	            System.out.println(e.toString());
	        }
	     }

}
