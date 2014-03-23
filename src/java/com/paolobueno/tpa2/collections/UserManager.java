/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paolobueno.tpa2.collections;

import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 31239943
 */
public class UserManager {
    private static int usersCount = 0;
    private static Set<String> loggedUsers = new HashSet<String>();
    
    public static boolean logIn(String username) {
        return loggedUsers.add(username);
    }
    
    public static boolean logOut(String username) {
        return loggedUsers.remove(username);
    }
    
    public static int getCount() {
        return loggedUsers.size();
    }
    
    public static boolean isLoggedIn(HttpSession session) {
        return session.getAttribute("usuario") != null;
    }
}
