package Server;

import Server.DataAccessObject.Implementation.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.ServerSocket;
import java.sql.SQLException;
import Server.Model.Category;
import Server.Model.Product;
import java.io.IOException;
import java.sql.Connection;
import Database.Session;
import java.net.Socket;

public class Servidor{
	
	private static Session sqlSession = null;
	private static ServerSocket ss = null;
	private static final int PORT = 8000;
	public static Connection conn = null;
	public static Socket client = null;
	
	public void productQueries( String operation, String aux ){
		ProductDaoImpl pdi = new ProductDaoImpl();
		String[] tmp = aux.split( "," );
		Product p = new Product( tmp[ 0 ], tmp[ 1 ], tmp[ 2 ], tmp[ 3 ] );
		if( operation.equalsIgnoreCase( "CREATE PRODUCT" ) ){
			pdi.createProduct( p );
		}else if( operation.equalsIgnoreCase( "READ PRODUCT BY CATEGORY ID" ) ){
			pdi.findProductByCategory( p.getIdCategory() );
		}else if( operation.equalsIgnoreCase( "READ PRODUCT BY ID" ) ){
			pdi.findByIdProduct( p.getIdProduct() );
		}else if( operation.equalsIgnoreCase( "READ ALL PRODUCTS" ) ){
			pdi.findAllProducts();
		}else if( operation.equalsIgnoreCase( "UPDATE PRODUCT" ) ){
			pdi.updateProduct( p );
		}else{
			pdi.deleteProduct( p.getIdProduct() );
		} // End nested if-else-if.
	} // End method.
	
	public void categoryQueries( String operation, String aux ){
		CategoryDaoImpl cdi = new CategoryDaoImpl();
		String[] tmp = aux.split( "," );
		Category c = new Category( tmp[ 0 ], tmp[ 1 ], tmp[ 2 ] );
		if( operation.equalsIgnoreCase( "CREATE CATEGORY" ) ){
			cdi.createCategory( c );
		}else if( operation.equalsIgnoreCase( "READ BY CATEGORY ID" ) ){
			cdi.findByIdCategory( c.getIdCategory() );
		}else if( operation.equalsIgnoreCase( "READ ALL CATEGORIES" ) ){
			cdi.findAllCategories();
		}else if( operation.equalsIgnoreCase( "UPDATE CATEGORY" ) ){
			cdi.updateCategory( c );
		}else{
			cdi.deleteCategory( c.getIdCategory() );
		} // End nested if-else-if
	} // End method.
	
	public static void establishCommunication( Socket client ){
		Servidor s = new Servidor();
		for( ; ; ){
			String[] request;
			try {
				BufferedReader input = new BufferedReader( new InputStreamReader( client.getInputStream() ) );
				request = input.readLine().split( ":" );
				if( request[ 0 ].equalsIgnoreCase( "PRODUCT" ) ){
					s.productQueries( request[ 1 ], request[ 2 ] );
				}else{
					s.categoryQueries( request[ 1 ], request[ 2 ] );
				} // End if-else.
			}catch( IOException e ) {
				Thread.currentThread().interrupt();
			} // End try-catch.
		} // End forever.
	} // End method.
	
	public static void main( String[] args ) throws IOException, ClassNotFoundException, SQLException{
		sqlSession = new Session();
		ss = new ServerSocket( PORT );
		conn = sqlSession.getSession();
		System.out.println( "\nServer initialized." );
		for( ; ; ){
			client = ss.accept();
			System.out.println( "\n\tClient connected from: " + client.getInetAddress().toString() + ":" + client.getPort() );
			Runnable t = ( ) -> { establishCommunication ( client ); };
			new Thread( t ).start();
		} // End forever.
	} // End main.
	
} // End class.
