/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.paolobueno.tpa2.collections.db;

import com.paolobueno.tpa2.collections.MessagesDAO;
import com.paolobueno.tpa2.data.ConnectionFactory;
import com.paolobueno.tpa2.models.Grouping;
import com.paolobueno.tpa2.models.Message;
import com.paolobueno.tpa2.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paolo
 */
public class MessagesSqliteDAO implements MessagesDAO {

    private static Connection getConnection() throws SQLException {
        return ConnectionFactory.getConnection(ConnectionFactory.SQLITE);
    }
    
    @Override
    public boolean add(Message entity) {
        try(Connection c = getConnection()){
            PreparedStatement ps = c.prepareStatement("INSERT INTO Messages (message, date, username) VALUES (?,?,?)");
            ps.setString(1, entity.getMessage());
            
            Date now = new Date();
            entity.setDate(now);
            ps.setTimestamp(2, new Timestamp(now.getTime()));
            
            ps.setString(3, entity.getUserName());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MessagesSqliteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Message> findAll() {
        return findAll(null);
    }
    
    public List<Message> findAll(String where) {
        LinkedList<Message> result = null;
        
        try (Connection c = getConnection()) {
            PreparedStatement s = c.prepareStatement("SELECT * FROM Messages " + 
                    (where == null ? "" : "WHERE " + where));
            ResultSet rs = s.executeQuery();
            result = new LinkedList<>();
            while(rs.next()) {
                result.add(new Message(rs));
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(MessagesSqliteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return result;
        }
    }

    @Override
    public List<Message> findByUser(String username) {
        return findAll("username = " + username);
    }

    @Override
    public boolean remove(Message entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Grouping<String, Message>> groupByUser() {
        LinkedList<Grouping<String,Message>> result = null;
        
        try (Connection c = getConnection()) {
            PreparedStatement s = c.prepareStatement("SELECT * FROM Messages ORDER BY username");
            ResultSet rs = s.executeQuery();
            result = new LinkedList<>();
            Grouping<String, Message> g = new Grouping<>();
            
            while(rs.next()) {
                if(g.getKey() != null
                        && !g.getKey().equals(rs.getString("username")))
                {
                    // new user
                    result.add(g);
                    g = new Grouping<>();
                }
                g.addItem(new Message(rs));
                g.setKey(rs.getString("username"));
            }
            
            // add last user
            result.add(g);
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(MessagesSqliteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return result;
        }
    }
    
}
