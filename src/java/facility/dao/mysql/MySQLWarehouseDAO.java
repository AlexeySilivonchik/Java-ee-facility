package facility.dao.mysql;

import facility.connector.MySQLConnector;
import facility.entity.Warehouse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLWarehouseDAO {

    public List<Warehouse> listWarehouses() {

        Connection cn = MySQLConnector.connect();

        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Warehouse> warehouses = new ArrayList();

        try {
            ps = cn.prepareStatement("Select * from warehouse;");
            rs = ps.executeQuery();

            while (rs.next()) {
                Warehouse warehouse = new Warehouse();
                warehouse.setId(rs.getInt("warehouse_id"));
                warehouse.setName(rs.getString("name"));
                warehouse.setCategory(rs.getString("category"));
                warehouse.setArea(rs.getInt("area"));
                warehouses.add(warehouse);
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
        return warehouses;
    }

    public void deleteWarehouse(int id) {

        Connection cn = MySQLConnector.connect();

        PreparedStatement ps;

        try {
            ps = cn.prepareStatement("delete from warehouse where warehouse_id=?;");
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

    public void editWarehouse(int id, String name, String category, int iarea) {
        Connection cn = MySQLConnector.connect();

        PreparedStatement ps;

        try {
            ps = cn.prepareStatement("UPDATE warehouse SET warehouse.`name`=?,warehouse.category=?,warehouse.area=? where warehouse_id=?;");
            ps.setString(1, name);
            ps.setString(2, category);
            ps.setInt(3, iarea);
            ps.setInt(4, id);
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

    public void addWarehouse(String name, String category, int area) {

        Connection cn = MySQLConnector.connect();

        PreparedStatement ps;

        try {
            ps = cn.prepareStatement("INSERT INTO warehouse (name,category,area) VALUES (?, ?, ?);");
            ps.setString(1, name);
            ps.setString(2, category);
            ps.setInt(3, area);
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

    public Warehouse getWarehouse(int id) {

        Connection cn = MySQLConnector.connect();

        PreparedStatement ps;
        ResultSet rs = null;

        Warehouse warehouse = new Warehouse();

        try {
            ps = cn.prepareStatement("select * from warehouse where warehouse_id=?;");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                warehouse.setId(rs.getInt("warehouse_id"));
                warehouse.setName(rs.getString("name"));
                warehouse.setCategory(rs.getString("category"));
                warehouse.setArea(rs.getInt("area"));
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
        return warehouse;
    }
    
    public Warehouse getByName(String name) {

        Connection cn = MySQLConnector.connect();

        PreparedStatement ps;
        ResultSet rs = null;

        Warehouse warehouse = new Warehouse();

        try {
            ps = cn.prepareStatement("select * from warehouse where name=?;");
            ps.setString(1, name);
            rs = ps.executeQuery();

            while (rs.next()) {
                warehouse.setId(rs.getInt("warehouse_id"));
                warehouse.setName(rs.getString("name"));
                warehouse.setCategory(rs.getString("category"));
                warehouse.setArea(rs.getInt("area"));
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
        return warehouse;
    }
}
