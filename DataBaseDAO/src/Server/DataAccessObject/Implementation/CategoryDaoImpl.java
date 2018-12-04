package Server.DataAccessObject.Implementation;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.ResultSetMetaData;
import Server.DataAccessObject.CategoryDao;
import Server.Model.Category;

public class CategoryDaoImpl implements CategoryDao{
	
	Connection conn = Server.Servidor.conn;
	CallableStatement cs = null;
	boolean response;
	
	@Override
	public void createCategory( Category c ) {
		try {
			conn.setAutoCommit( false );
			cs = ( CallableStatement ) conn.prepareCall( "{call spInsertarC(?,?)}" );
			cs.setString( 1, c.getName() );
			cs.setString( 2, c.getDescription() );
			response = cs.executeUpdate() == 1 ? true : false;
			if( response ){
				conn.commit();
			}
		}catch( SQLException e ) {
			e.printStackTrace();
		} // End try-catch.
	} // End implementation.

	@Override
	public void updateCategory( Category c ) {
		try {
			conn.setAutoCommit( false );
			cs = ( CallableStatement ) conn.prepareCall( "{call spActualizarC(?,?,?)}" );
			cs.setString( 1, c.getName() );
			cs.setString( 2, c.getDescription() );
			cs.setInt( 3, c.getIdCategory() );
			response = cs.executeUpdate() == 1 ? true : false;
			if( response ){
				conn.commit();
			}
		}catch( SQLException e ) {
			e.printStackTrace();
		} // End try-catch.
	}

	@Override
	public void deleteCategory( Integer idCategory ) {
		try {
			conn.setAutoCommit( false );
			cs = ( CallableStatement ) conn.prepareCall( "{call spDeleteC(?)}" );
			cs.setInt( 1, idCategory );
			response = cs.executeUpdate() == 1 ? true : false;
			if( response ){
				conn.commit();
			}
		}catch( SQLException e ) {
			e.printStackTrace();
		} // End try-catch.
	}

	@Override
	public Category findByIdCategory( Integer idCategory ) {
		try{
			PrintStream output = new PrintStream( Server.Servidor.client.getOutputStream() );
			cs = ( CallableStatement ) conn.prepareCall( "{call spSelectOneC(?)}" );
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
	}

	@Override
	public List<Category> findAllCategories() {
		try{
			PrintStream output = new PrintStream( Server.Servidor.client.getOutputStream() );
			cs = ( CallableStatement ) conn.prepareCall( "{call spSelectAllC()}" );
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
	}

} // End class.
