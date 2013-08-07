package facility.dao.mysql;

import facility.connector.MySQLConnector;
import facility.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLUserDAO {

    public User getUser(String login, String password) {
        Connection cn = MySQLConnector.connect();
        PreparedStatement ps;
        ResultSet rs;
        User user = null;

        try {
            ps = cn.prepareStatement("Select * from user where login=? and password=?;");
            ps.setString(1, login);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("user_id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
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
        return user;
    }
    
    public void addUser(String login, String password) {

        Connection cn = MySQLConnector.connect();

        PreparedStatement ps;

        try {
            ps = cn.prepareStatement("INSERT INTO user (login,password) VALUES (?, ?);");
            ps.setString(1, login);
            ps.setString(2, password);
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
}
