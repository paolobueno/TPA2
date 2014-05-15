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
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

public class MessagesAction extends ActionSupport {
    private String message = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    @Override
    public String execute() {
        if (getMessage() != null) {
            // Eh POST, devemos criar nova mensagem
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
        
        return SUCCESS;
    }

    private static MessagesDAO getDAO() {
        return new MessagesSqliteDAO();
    }
    
    public Collection<Message> getMessages() {
        MessagesDAO collection = getDAO();
        return collection.findAll();
    }
}
