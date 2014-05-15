package com.paolobueno.tpa2.action;

import com.paolobueno.tpa2.collections.Users;
import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.paolobueno.tpa2.collections.UserManager;
import com.paolobueno.tpa2.collections.UsersDAO;
import com.paolobueno.tpa2.collections.db.UsersSqliteDAO;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

public class LoginAction extends ActionSupport {

    private String login;
    private String senha;

    @Override
    public String execute() throws Exception {
        UsersDAO users = getDAO();
        if (users.verify(getLogin(), getSenha())) {
            // criando a sessao
            HttpSession sessao = ServletActionContext.getRequest().getSession();
            sessao.setAttribute("usuario", getLogin());
            sessao.setAttribute("mensagem", "");
            UserManager.logIn(getLogin());
            return LOGIN;
        } else {
            addActionError(getText("login.senhaInvalida"));
            return INPUT;
        }
    }

    private static UsersDAO getDAO() {
        return new UsersSqliteDAO();
    }
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