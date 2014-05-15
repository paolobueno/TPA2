/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.paolobueno.tpa2.collections;

import com.paolobueno.tpa2.models.User;

/**
 *
 * @author Paolo
 */
public interface UsersDAO {

    boolean add(String username, String password);

    boolean add(User user);

    User find(String username);

    boolean remove(String username);

    boolean verify(String username, String password);
    
}
