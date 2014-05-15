/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paolobueno.tpa2.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 31239943
 */
public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(ResultSet rs) throws SQLException {
        this.username = rs.getString("username");
        this.password = rs.getString("password");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
