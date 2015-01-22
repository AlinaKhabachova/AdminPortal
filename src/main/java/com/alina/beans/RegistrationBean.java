package com.alina.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.alina.common.IndexedEntityService;
import com.alina.entity.User;

@ManagedBean(name = "registrationBean")
@ViewScoped
public class RegistrationBean
{
    private User user = new User();
    
    public void save()
    {
        System.out.println(user.toString());
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
