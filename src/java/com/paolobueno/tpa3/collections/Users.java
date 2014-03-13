/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paolobueno.tpa3.collections;

import com.paolobueno.tpa3.models.User;
import java.util.HashMap;

/**
 *
 * @author 31239943
 */
public class Users {
    private static Users theInstance;

    private static void seedTestUsers(Users users) {
        users.add("admin", "1234");
        users.add("paolo", "123");
    }
    HashMap<String, User> users = new HashMap<String, User>();
    
    private Users() {
    }
    
    public static Users getInstance() {
        if(theInstance == null) {
            theInstance = new Users();
            seedTestUsers(theInstance);
        }
        return theInstance;
    }
    
    public boolean verify(String username, String password) {
        if(!users.containsKey(username)) return false;
        
        User user = users.get(username);
        return user.getPassword().equals(password);
    }
    
    public boolean add(String username, String password) {
        return this.add(new User(username, password));
    }
    
    public boolean add(User user) {
        if(users.containsKey(user.getUsername())) {
           return false;
        }
        users.put(user.getUsername(), user);
        return true;
    }
    
    public boolean remove(String username) {
        if(users.remove(username) != null) {
            return true;
        }
        return false;
    }
}
