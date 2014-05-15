/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.paolobueno.tpa2.collections;

import com.paolobueno.tpa2.models.Message;
import java.util.Collection;

/**
 *
 * @author Paolo
 */
public interface MessagesDAO {

    boolean add(Message entity);

    Collection<Message> findAll();

    Collection<Message> findByUser(String username);

    boolean remove(Message entity);
    
}
