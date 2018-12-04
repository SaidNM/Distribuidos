package Database;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Session{
	
	private final String password = "saidnm";
	private final String db = "PROD_CAT";
	private final String user = "root";
	private final String url = "jdbc:mysql://localhost/" + db;
	private Connection conn = null;
	
	public Session() throws ClassNotFoundException, SQLException{
		Class.forName( "com.mysql.jdbc.Connection" );
		conn = ( Connection ) DriverManager.getConnection( url, user, password );
		if( conn != null ){
			System.out.println ( "\n\tConnection to " + url + " database... OK." );
		} // End if.
	} // End constructor.
	
	public void reconnect() throws SQLException{
		conn = ( Connection ) DriverManager.getConnection( url, user, password );
		if( conn != null ){
			System.out.println ( "\n\tReconnected to " + url + " database... OK." );
		} // End if.
	} // End method.
	
	public Connection getSession(){
		return conn;
	} // End getter.

} // End class.
