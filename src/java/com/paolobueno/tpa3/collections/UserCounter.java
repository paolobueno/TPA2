/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paolobueno.tpa3.collections;

/**
 *
 * @author 31239943
 */
public class UserCounter {
    private static int usersCount = 0;
    
    public static int logIn() {
        return ++usersCount;
    }
    
    public static int logOut() {
        return --usersCount;
    }
    
    public static int getCount() {
        return usersCount;
    }
}
