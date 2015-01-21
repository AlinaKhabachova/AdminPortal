package com.alina.common;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.alina.common.User;
import com.alina.common.IndexedEntityService;

@ManagedBean(name = "registrationBean")
@ViewScoped
public class RegistrationBean
{
    private User user = new User();
    
    public void save()
    {
        IndexedEntityService.add(user);
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
