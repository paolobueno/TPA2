/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paolobueno.tpa2.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author 31227848
 */
public class Message {
    private String message;
    private String userName;
    private Date date;
    private int id;

    public Message(String username, String message, Date date) {
        this.setUserName(username);
        this.setMessage(message);
        this.setDate(date);
    }

    public Message(ResultSet rs) throws SQLException {
        this.setUserName(rs.getString("username"));
        this.setMessage(rs.getString("message"));
        this.setDate(rs.getTimestamp("date"));
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
