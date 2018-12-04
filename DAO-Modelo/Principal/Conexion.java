package Principal;

import java.sql.*;
public class Conexion{
    private static final String url="jdbc:mysql://localhost:5000/compras?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String user="root";
    private static final String password="saidnm";
    public static synchronized Connection getConexion(){
        Connection cn=null;
        try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                cn=DriverManager.getConnection(url,user,password);
        } catch (Exception e){
                System.out.println(e);
        } finally {
                return cn;
        }
    }
    public static synchronized void cerrarCallSt(CallableStatement cs){
        try{
                cs.close();
        } catch (Exception e){
               System.out.println(e);
        }
    }
        public static synchronized void cerrarPrepSt(PreparedStatement ps){
        try{
                ps.close();
        } catch (Exception e){
               System.out.println(e);
        }
    }
    public static synchronized void cerrarR(ResultSet rs){
        try{
                rs.close();
        } catch (Exception e){
               System.out.println(e);
        }
    }
    public static synchronized void cerrarC(Connection cn){
        try{
                cn.close();
        } catch(Exception e)
        {
                System.out.println(e);
        }
    }
    public static synchronized void deshacerCambios(Connection cn){
        try{
                cn.rollback();
        } catch(Exception e){
                System.out.println(e);
        }
    }
}
