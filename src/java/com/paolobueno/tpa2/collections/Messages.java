/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paolobueno.tpa2.collections;

import com.paolobueno.tpa2.models.Message;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author 31227848
 */
public class Messages {

    // Singleton
    private static Messages theInstance;

    private Messages() {
    }

    public static Messages getInstance() {
        if (theInstance == null) {
            theInstance = new Messages();
        }
        return theInstance;
    }

    private final LinkedList<Message> messages = new LinkedList<Message>();

    
    public boolean add(Message entity) {
        return messages.add(entity);
    }

    
    public boolean remove(Message entity) {
        return messages.remove(entity);
    }
    
    public Collection<Message> findByUser(String username){
        LinkedList<Message> result = new LinkedList<Message>();
        for(Message m : messages){
            if (m.getUserName().equals(username)) {
                result.add(m);
            }
        }
        return result;
    }

}
