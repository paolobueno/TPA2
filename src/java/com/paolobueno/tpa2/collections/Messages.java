/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paolobueno.tpa2.collections;

import com.paolobueno.tpa2.models.Grouping;
import com.paolobueno.tpa2.models.Message;
import com.paolobueno.tpa2.models.User;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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

    private final LinkedList<Message> messages = new LinkedList<>();

    
    @Override
    public boolean add(Message entity) {
        return messages.add(entity);
    }

    
    @Override
    public boolean remove(Message entity) {
        return messages.remove(entity);
    }
    
    @Override
    public List<Message> findAll() {
        return (List<Message>)messages.clone();
    }
    
    @Override
    public List<Message> findByUser(String username){
        LinkedList<Message> result = new LinkedList<>();
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

    @Override
    public List<Grouping<String, Message>> groupByUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
