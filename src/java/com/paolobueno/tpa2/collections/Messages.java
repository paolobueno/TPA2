/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paolobueno.tpa2.collections;

import com.paolobueno.tpa2.models.Message;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author 31227848
 */
public class Messages implements MessagesDAO {

    // Singleton
    private static Messages theInstance;

    private Messages() {
    }

    public static Messages getInstance() {
        if (theInstance == null) {
            theInstance = new Messages();
            theInstance.seed();
        }
        return theInstance;
    }

    private final LinkedList<Message> messages = new LinkedList<Message>();

    
    @Override
    public boolean add(Message entity) {
        return messages.add(entity);
    }

    
    @Override
    public boolean remove(Message entity) {
        return messages.remove(entity);
    }
    
    @Override
    public Collection<Message> findAll() {
        return (Collection<Message>)messages.clone();
    }
    
    @Override
    public Collection<Message> findByUser(String username){
        LinkedList<Message> result = new LinkedList<Message>();
        for(Message m : messages){
            if (m.getUserName().equals(username)) {
                result.add(m);
            }
        }
        return result;
    }

    private void seed() {
        this.add(new Message("paolo", "hello world", new Date()));
        this.add(new Message("admin", "lorem ipsum dolor sit amet", new Date()));
    }

}
