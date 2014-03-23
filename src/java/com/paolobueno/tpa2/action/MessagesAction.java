/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.paolobueno.tpa2.action;

import com.opensymphony.xwork2.ActionSupport;
import com.paolobueno.tpa2.collections.Messages;
import com.paolobueno.tpa2.models.Message;
import java.util.Collection;

/**
 *
 * @author Paolo
 */
public class MessagesAction extends ActionSupport {
    @Override
    public String execute() {
        return SUCCESS;
    }
    
    public Collection<Message> getMessages() {
        return Messages.getInstance().findAll();
    }
}
