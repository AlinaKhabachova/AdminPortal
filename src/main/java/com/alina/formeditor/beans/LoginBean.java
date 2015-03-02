package com.alina.formeditor.beans;

import com.alina.formeditor.common.IndexedEntityService;
import com.alina.formeditor.entity.User;
import com.alina.formeditor.enums.Pages;
import com.alina.formeditor.helpers.RedirectHelper;

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

    private User user = new User();

    public void goToRegistration()
    {
        RedirectHelper.redirectTo(Pages.REGISTRATION);
    }


    public void login()
    {
        setUser((User)IndexedEntityService.findByLogin(login));

        if(user!=null&&user.getPassword().equals(getPassword()))
        {
            RedirectHelper.redirectTo(Pages.HI);
        }
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
