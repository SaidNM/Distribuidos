package Server.DataAccessObject.Implementation;

import Server.DataAccessObject.ProductDao;
import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.ResultSetMetaData;
import java.sql.SQLException;
import Server.Model.Product;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class ProductDaoImpl implements ProductDao{

	Connection conn = Server.Servidor.conn;
	CallableStatement cs = null;
	boolean response;
	
	public synchronized void createProduct( Product p ){
		try {
			conn.setAutoCommit( false );
			cs = ( CallableStatement ) conn.prepareCall( "{call spInsertarP(?,?,?)}" );
			cs.setString( 1, p.getName() );
			cs.setDouble( 2, p.getPrice() );
			cs.setInt( 3, p.getIdCategory() );
			response = cs.executeUpdate() == 1 ? true : false;
			if( response ){
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} // End try-catch.
	} // End implementation.

	@Override
	public synchronized void updateProduct( Product p ){
		try {
			conn.setAutoCommit( false );
			cs = ( CallableStatement ) conn.prepareCall( "{call spActualizarP(?,?,?,?)}" );
			cs.setString( 1, p.getName() );
			cs.setDouble( 2, p.getPrice() );
			cs.setInt( 3,p.getIdCategory() );
			cs.setInt( 4, p.getIdProduct() );
			response = cs.executeUpdate() == 1 ? true : false;
			if( response ){
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} // End try-catch.
	} // End implementation.

	@Override
	public synchronized void deleteProduct( Integer idProduct ){
		try {
			conn.setAutoCommit( false );
			cs = ( CallableStatement ) conn.prepareCall( "{call spDeleteP(?)}" );
			cs.setInt( 1, idProduct );
			response = cs.executeUpdate() == 1 ? true : false;
			if( response ){
				conn.commit();
			}
		}catch( SQLException e ) {
			e.printStackTrace();
		} // End try-catch.
	} // End implementation.

	@Override
	public synchronized Product findByIdProduct( Integer idProduct ){
		try{
			PrintStream output = new PrintStream( Server.Servidor.client.getOutputStream() );
			cs = ( CallableStatement ) conn.prepareCall( "{call spSelectOneP(?)}" );
			cs.setInt( 1, idProduct );
			ResultSet rs = cs.executeQuery();
			ResultSetMetaData rsmd = ( ResultSetMetaData ) rs.getMetaData();
			boolean rows = rs.next();
			String resultSet = "";
			for( int i = 1 ; i < rsmd.getColumnCount() + 1 ; i++ ){
				resultSet += rsmd.getColumnLabel( i ) + ",";
			} // End for.
			output.println( resultSet );
			while( rows ){
				resultSet = "";
				for( int i = 1 ; i <= rsmd.getColumnCount() ; i++ ){
					resultSet = resultSet.concat( rs.getString( i ) + "," );
				} // End for.
				System.out.println( resultSet );
				output.println( resultSet );
				rows = rs.next();
			} // End while.
			output.println( "-1" );
		}catch( Exception e ) {
			e.printStackTrace();
		} // End try-catch.
		return null;
	} // End implementation.

	@Override
	public synchronized List<Product> findProductByCategory( Integer idCategory ){
		try{
			PrintStream output = new PrintStream( Server.Servidor.client.getOutputStream() );
			cs = ( CallableStatement ) conn.prepareCall( "{call spSelectAllProductsByCategory(?)}" );
			cs.setInt( 1, idCategory );
			ResultSet rs = cs.executeQuery();
			ResultSetMetaData rsmd = ( ResultSetMetaData ) rs.getMetaData();
			boolean rows = rs.next();
			String resultSet = "";
			for( int i = 1 ; i < rsmd.getColumnCount() + 1 ; i++ ){
				resultSet += rsmd.getColumnLabel( i ) + ",";
			} // End for.
			output.println( resultSet );
			while( rows ){
				resultSet = "";
				for( int i = 1 ; i <= rsmd.getColumnCount() ; i++ ){
					resultSet = resultSet.concat( rs.getString( i ) + "," );
				} // End for.
				System.out.println( resultSet );
				output.println( resultSet );
				rows = rs.next();
			} // End while.
			output.println( "-1" );
		}catch( Exception e ) {
			e.printStackTrace();
		} // End try-catch.
		return null;
	} // End implementation.

	@Override
	public synchronized List<Product> findAllProducts(){
		try{
			PrintStream output = new PrintStream( Server.Servidor.client.getOutputStream() );
			cs = ( CallableStatement ) conn.prepareCall( "{call spSelectAllP()}" );
			ResultSet rs = cs.executeQuery();
			ResultSetMetaData rsmd = ( ResultSetMetaData ) rs.getMetaData();
			boolean rows = rs.next();
			String resultSet = "";
			for( int i = 1 ; i < rsmd.getColumnCount() + 1 ; i++ ){
				resultSet += rsmd.getColumnLabel( i ) + ",";
			} // End for.
			output.println( resultSet );
			while( rows ){
				resultSet = "";
				for( int i = 1 ; i <= rsmd.getColumnCount() ; i++ ){
					resultSet = resultSet.concat( rs.getString( i ) + "," );
				} // End for.
				System.out.println( resultSet );
				output.println( resultSet );
				rows = rs.next();
			} // End while.
			output.println( "-1" );
		}catch( Exception e ) {
			e.printStackTrace();
		} // End try-catch.
		return null;
	} // End implementation.

} // End class.
