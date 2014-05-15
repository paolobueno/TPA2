/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.paolobueno.tpa2.collections.db;

import com.paolobueno.tpa2.collections.UsersDAO;
import com.paolobueno.tpa2.data.ConnectionFactory;
import com.paolobueno.tpa2.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paolo
 */
public class UsersSqliteDAO implements UsersDAO {
    
    private static Connection getConnection() throws SQLException {
        return ConnectionFactory.getConnection(ConnectionFactory.SQLITE);
    }
    
    @Override
    public boolean add(String username, String password) {
        User u = new User(username, password);
        return this.add(u);
    }

    @Override
    public boolean add(User user) {
        try (Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("INSERT INTO Users (username, password) VALUES (?,?)");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersSqliteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public User find(String username) {
        try(Connection c = getConnection()) {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM Users WHERE username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs);
            } else return null;
        } catch (SQLException ex) {
            Logger.getLogger(UsersSqliteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean remove(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verify(String username, String password) {
        User u = this.find(username);
        if (u == null) return false;
        
        return u.getPassword().equals(password);
    }
    
}
