package facility.dao.mysql;

import facility.connector.MySQLConnector;
import facility.entity.Distributor;
import facility.entity.Production;
import facility.entity.Warehouse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLProductionDAO {

    public List<Production> listProduction() {

        Connection cn = MySQLConnector.connect();

        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Production> listProduction = new ArrayList();

        try {
            ps = cn.prepareStatement("Select * from production;");
            rs = ps.executeQuery();

            while (rs.next()) {
                Production production = new Production();
                production.setId(rs.getInt("production_id"));
                production.setName(rs.getString("name"));
                production.setRetailPrice(rs.getInt("retail_price"));
                production.setBatchSize(rs.getInt("batch_size"));
                production.setBatchPrice(rs.getInt("batch_price"));
                production.setAmount(rs.getInt("amount"));

                int warehouseId = rs.getInt("warehouse_id");
                Warehouse warehouse = getWarehouse(warehouseId, cn);
                production.setWarehouse(warehouse);

                int distributorId = rs.getInt("distributor_id");
                Distributor distributor = getDistributor(distributorId, cn);
                production.setDistributor(distributor);
                
                listProduction.add(production);
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
        return listProduction;
    }

    public Warehouse getWarehouse(int id, Connection cn) {

        PreparedStatement ps = null;
        ResultSet rs = null;

        Warehouse warehouse = null;
        try {
            ps = cn.prepareStatement("Select * from warehouse where warehouse_id=?;");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                warehouse = new Warehouse();
                warehouse.setId(rs.getInt("warehouse_id"));
                warehouse.setName(rs.getString("name"));
                warehouse.setCategory(rs.getString("category"));
                warehouse.setArea(rs.getInt("area"));
            }
        } catch (SQLException e) {
            Logger.getLogger(MySQLWarehouseDAO.class.getName()).log(Level.SEVERE, null, e);
        } 
        
        return warehouse;
    }

    public Distributor getDistributor(int id, Connection cn) {

        PreparedStatement ps = null;
        ResultSet rs = null;

        Distributor distributor = null;
        try {
            ps = cn.prepareStatement("Select * from distributor where distributor_id=?;");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                distributor = new Distributor();
                distributor.setId(rs.getInt("distributor_id"));
                distributor.setName(rs.getString("name"));
                distributor.setAddress(rs.getString("address"));
            }
        } catch (SQLException e) {
            Logger.getLogger(MySQLWarehouseDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return distributor;
    }
    
    public void deleteProduction(int id) {

        Connection cn = MySQLConnector.connect();

        PreparedStatement ps;

        try {
            ps = cn.prepareStatement("delete from production where production_id=?;");
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
    
    public void addProduction(String name,int iretailPrice,int ibatchSize,
            int ibatchPrice,int iamount,int iwarehouseId,int idistributorId) {

        Connection cn = MySQLConnector.connect();

        PreparedStatement ps;

        try {
            ps = cn.prepareStatement("INSERT INTO production (name,retail_price,batch_size,batch_price,amount,warehouse_id,distributor_id) VALUES (?, ?, ?, ?, ?, ?, ?);");
            ps.setString(1, name);
            ps.setInt(2, iretailPrice);
            ps.setInt(3, ibatchSize);
            ps.setInt(4, ibatchPrice);
            ps.setInt(5, iamount);
            ps.setInt(6, iwarehouseId);
            ps.setInt(7, idistributorId);
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
    
    public void editProduction(int productionId, String name, int iretailPrice, 
            int ibatchSize, int ibatchPrice, int iamount, int iwarehouseId, int idistributorId) {
        Connection cn = MySQLConnector.connect();

        PreparedStatement ps;

        try {
            ps = cn.prepareStatement("UPDATE production SET production.`name`=?, production.retail_price=?, production.batch_size=?, production.batch_price=?, production.amount=?, production.warehouse_id=?, production.distributor_id=? where production_id=?;");
            ps.setString(1, name);
            ps.setInt(2, iretailPrice);
            ps.setInt(3, ibatchSize);
            ps.setInt(4, ibatchPrice);
            ps.setInt(5, iamount);
            ps.setInt(6, iwarehouseId);
            ps.setInt(7, idistributorId);
            ps.setInt(8, productionId);
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
    
    public Production getProduction(int id) {

        Connection cn = MySQLConnector.connect();

        PreparedStatement ps;
        ResultSet rs = null;

        Production production = new Production();

        try {
            ps = cn.prepareStatement("select * from production where production_id=?;");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                production.setId(rs.getInt("production_id"));
                production.setName(rs.getString("name"));
                production.setRetailPrice(rs.getInt("retail_price"));
                production.setBatchSize(rs.getInt("batch_size"));
                production.setBatchPrice(rs.getInt("batch_price"));
                production.setAmount(rs.getInt("amount"));

                int warehouseId = rs.getInt("warehouse_id");
                Warehouse warehouse = getWarehouse(warehouseId, cn);
                production.setWarehouse(warehouse);

                int distributorId = rs.getInt("distributor_id");
                Distributor distributor = getDistributor(distributorId, cn);
                production.setDistributor(distributor);
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
        return production;
    }
    
    public Production getByName(String name) {

        Connection cn = MySQLConnector.connect();

        PreparedStatement ps;
        ResultSet rs = null;

        Production production = new Production();

        try {
            ps = cn.prepareStatement("select * from production where name=?;");
            ps.setString(1, name);
            rs = ps.executeQuery();

            while (rs.next()) {
                production.setId(rs.getInt("production_id"));
                production.setName(rs.getString("name"));
                production.setRetailPrice(rs.getInt("retail_price"));
                production.setBatchSize(rs.getInt("batch_size"));
                production.setBatchPrice(rs.getInt("batch_price"));
                production.setAmount(rs.getInt("amount"));

                int warehouseId = rs.getInt("warehouse_id");
                Warehouse warehouse = getWarehouse(warehouseId, cn);
                production.setWarehouse(warehouse);

                int distributorId = rs.getInt("distributor_id");
                Distributor distributor = getDistributor(distributorId, cn);
                production.setDistributor(distributor);
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
        return production;
    }
}
