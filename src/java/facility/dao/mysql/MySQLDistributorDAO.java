package facility.dao.mysql;

import facility.connector.MySQLConnector;
import facility.connector.MySQLDAO;
import facility.entity.Distributor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLDistributorDAO implements MySQLDAO{

    public List<Distributor> listDistributors() {

        Connection cn = MySQLConnector.connect();

        PreparedStatement ps=null;
        ResultSet rs=null;

        List<Distributor> distributors = new ArrayList();

        try {
            ps = cn.prepareStatement("Select * from distributor;");
            rs = ps.executeQuery();

            while (rs.next()) {
                Distributor distributor = new Distributor();
                distributor.setId(rs.getInt("distributor_id"));
                distributor.setName(rs.getString("name"));
                distributor.setAddress(rs.getString("address"));
                distributors.add(distributor);
            }

        } catch (SQLException e) {
            Logger.getLogger(MySQLWarehouseDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(MySQLWarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return distributors;
    }
    
    public void deleteDistributor(int id) {

        Connection cn = MySQLConnector.connect();

        PreparedStatement ps;

        try {
            ps = cn.prepareStatement("delete from distributor where distributor_id=?;");
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(MySQLWarehouseDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(MySQLWarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void editDistributor(int id, String name, String address) {
        Connection cn = MySQLConnector.connect();

        PreparedStatement ps;

        try {
            ps = cn.prepareStatement("UPDATE distributor SET distributor.`name`=?,distributor.address=? where distributor_id=?;");
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setInt(3, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(MySQLWarehouseDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(MySQLWarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void addDistributor(String name, String address) {

        Connection cn = MySQLConnector.connect();

        PreparedStatement ps;

        try {
            ps = cn.prepareStatement("INSERT INTO distributor (name,address) VALUES (?, ?);");
            ps.setString(1, name);
            ps.setString(2, address);
            ps.executeUpdate();

        } catch (SQLException e) {
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(MySQLWarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Distributor getDistributor(int id) {

        Connection cn = MySQLConnector.connect();

        PreparedStatement ps;
        ResultSet rs = null;

        Distributor distributor = new Distributor();

        try {
            ps = cn.prepareStatement("select * from distributor where distributor_id=?;");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                distributor.setId(rs.getInt("distributor_id"));
                distributor.setName(rs.getString("name"));
                distributor.setAddress(rs.getString("address"));
            }

        } catch (SQLException e) {
            Logger.getLogger(MySQLWarehouseDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(MySQLWarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return distributor;
    }
    
    public Distributor getByName(String name) {

        Connection cn = MySQLConnector.connect();

        PreparedStatement ps;
        ResultSet rs = null;

        Distributor distributor = new Distributor();

        try {
            ps = cn.prepareStatement("select * from distributor where name=?;");
            ps.setString(1, name);
            rs = ps.executeQuery();

            while (rs.next()) {
                distributor.setId(rs.getInt("distributor_id"));
                distributor.setName(rs.getString("name"));
                distributor.setAddress(rs.getString("address"));
            }

        } catch (SQLException e) {
            Logger.getLogger(MySQLWarehouseDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(MySQLWarehouseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return distributor;
    }
}
