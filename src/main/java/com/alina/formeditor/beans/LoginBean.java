package com.alina.formeditor.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

@ManagedBean(name = "loginBean")
@ViewScoped
public class LoginBean extends BaseBean
{
    private String password;

    private String login;

    public void redirectTo(String namePage) throws IOException
    {
        FacesContext.getCurrentInstance().getExternalContext().redirect("formeditor/"+ namePage);
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
