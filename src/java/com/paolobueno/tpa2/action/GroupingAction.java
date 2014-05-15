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
import com.paolobueno.tpa2.models.Grouping;
import com.paolobueno.tpa2.models.Message;
import com.paolobueno.tpa2.models.User;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

public class GroupingAction extends ActionSupport {
    private List<Grouping<String,Message>> groups;

    
    @Override
    public String execute() {
        this.groups = getDAO().groupByUser();
        return SUCCESS;
    }
    
    public List<Grouping<String,Message>> getGroups () {
        return this.groups;
    }

    private static MessagesDAO getDAO() {
        return new MessagesSqliteDAO();
    }
}
