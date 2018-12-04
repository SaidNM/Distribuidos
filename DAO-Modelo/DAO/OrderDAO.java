package DAO;

import Entidad.Orders;
import Principal.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderDAO {
    private static final String INSERT_SQL="insert into orders values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
    public int InsertOrd(Orders orden, Connection cnn){
        PreparedStatement ps=null;
        cnn=Conexion.getConexion();
        int ejecucion=0;
        try {
            ps=cnn.prepareStatement(INSERT_SQL);
            ps.setInt(1, orden.getOrderID());
            ps.setDate(2, (Date) orden.getOrderDate());
            ps.setDate(3, (Date) orden.getRequiredDate());
            ps.setDate(4, (Date) orden.getShippedDate());
            ps.setInt(5, orden.getShipVia());
            ps.setDouble(6, orden.getFreight());
            ps.setString(7, orden.getShipName());
            ps.setString(8, orden.getShipAddress());
            ps.setString(9, orden.getShipCity());
            ps.setString(10, orden.getShipRegion());
            ps.setString(11, orden.getShipPostalCode());
            ps.setString(12, orden.getShipCountry());
            ps.setInt(13, orden.getEmployeeID());
            ps.setString(14, orden.getCustomerID());
            ejecucion=ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            Conexion.cerrarPrepSt(ps);
            Conexion.cerrarC(cnn);
        }
        if(ejecucion!=0)
            return 1;
        else
            return 0;
    }
}
