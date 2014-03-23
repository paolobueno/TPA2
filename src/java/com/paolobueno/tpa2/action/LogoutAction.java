/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.paolobueno.tpa2.action;

import com.opensymphony.xwork2.ActionSupport;
import com.paolobueno.tpa2.collections.UserManager;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Paolo
 */
public class LogoutAction extends ActionSupport {
    @Override
    public String execute(){
        HttpSession session = ServletActionContext.getRequest().getSession();
        UserManager.logOut((String) session.getAttribute("usuario"));
        session.invalidate();
        return SUCCESS;
    }
}

    