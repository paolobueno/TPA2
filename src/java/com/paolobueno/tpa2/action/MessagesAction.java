/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.paolobueno.tpa2.action;

import com.opensymphony.xwork2.ActionSupport;
import com.paolobueno.tpa2.collections.Messages;
import com.paolobueno.tpa2.collections.MessagesDAO;
import com.paolobueno.tpa2.collections.db.MessagesSqliteDAO;
import com.paolobueno.tpa2.models.Message;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

public class MessagesAction extends ActionSupport {
    private String message = null;
    private String order = "asc";
    private List<Message> messages;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getOrder() {
        return this.order;
    }
    
    public void setOrder(String order) {
        this.order = order;
    }
    
    @Override
    public String execute() {
        if (getMessage() != null) {
            // POST, devemos criar nova mensagem
            if (getMessage().length() > 255) {
                addFieldError("message", "Quantidade de caracteres maior do que 255");
                return INPUT;
            }
            MessagesDAO collection = getDAO();
            HttpSession sessao = ServletActionContext.getRequest().getSession();
            
            collection.add(new Message(
                (String) sessao.getAttribute("usuario"),
                getMessage(),
                new Date()
            ));
        }
        
        // GET
        MessagesDAO collection = getDAO();
        List<Message> messages = collection.findAll();
        if ("desc".equals(getOrder())) {
            Collections.reverse(messages);
        }
        this.setMessages(messages);
        
        return SUCCESS;
    }

    private static MessagesDAO getDAO() {
        return new MessagesSqliteDAO();
    }
    
    
    public List<Message> getMessages() {
        return this.messages;
    }

    private void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
