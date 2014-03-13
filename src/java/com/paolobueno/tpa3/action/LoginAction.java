package com.paolobueno.tpa3.action;

import com.paolobueno.tpa3.collections.Users;
import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

public class LoginAction extends ActionSupport {

    private String login;
    private String senha;

    @Override
    public String execute() throws Exception {
        Users users = Users.getInstance();
        if (users.verify(getLogin(), getSenha())) {
            // criando a sessao
            HttpSession sessao = ServletActionContext.getRequest().getSession();
            sessao.setAttribute("usuario", getLogin());
            sessao.setAttribute("mensagem", "");
            return SUCCESS;
        } else {
            addActionError(getText("login.senhaInvalida"));
            return INPUT;
        }
    }

    /*
     @Override
     public void validate() {
     if (getLogin().equals("")) {
     addActionError(getText("login.loginObrigatorio"));
     }
     else if (getSenha().equals("")) {
     addActionError(getText("login.senhaObrigatoria"));
     }
     }*/
    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
}