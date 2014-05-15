/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.paolobueno.tpa2.collections;

import com.paolobueno.tpa2.models.Grouping;
import com.paolobueno.tpa2.models.Message;
import com.paolobueno.tpa2.models.User;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Paolo
 */
public interface MessagesDAO {

    boolean add(Message entity);

    List<Message> findAll();

    List<Message> findByUser(String username);
    
    List<Grouping<String,Message>> groupByUser();

    boolean remove(Message entity);
    
}
