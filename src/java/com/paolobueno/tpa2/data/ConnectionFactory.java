/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.paolobueno.tpa2.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
    public static final int SQLITE = 1;
    public static Connection getConnection(int databaseId) throws SQLException {
        switch(databaseId) {
            case SQLITE:
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
            return DriverManager.getConnection("jdbc:sqlite:../../../../../../../database.db");
            default:
                throw new IllegalArgumentException("No available database for this id");
        }
    }
    
    public static Statement getStatement(int databaseId) throws SQLException{
        Connection c = getConnection(databaseId);
        return c.createStatement();
    }
}
