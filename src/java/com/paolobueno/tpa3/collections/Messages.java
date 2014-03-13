/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paolobueno.tpa3.collections;

import com.paolobueno.tpa3.models.Message;
import java.util.HashMap;

    
/**
 *
 * @author 31227848
 */
public class Messages implements KeyedRepository<Integer, Message> {

    // Singleton
    private static Messages theInstance;
    private Messages() {
    }
    public static Messages getInstance() {
        if(theInstance == null) theInstance = new Messages();
        return theInstance;
    }
    
    private HashMap<Integer, Message> messages = new HashMap<Integer, Message>();
    
    @Override
    public boolean add(Message entity) {
        return messages.put(Message.getId(), entity) != null;
    }

    @Override
    public boolean remove(Integer Entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Message find(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    }
}
