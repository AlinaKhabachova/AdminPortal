package com.alina.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.alina.common.IndexedEntityService;
import com.alina.entity.User;

@ManagedBean(name = "registrationBean")
@ViewScoped
public class RegistrationBean
{
    private String rePassword;
    
    private User user = new User();
    
    public void save()
    {
        if(user.getPassword().equals(rePassword))
            IndexedEntityService.add(user);
        else
            System.out.println("wrong password");
        
    }
    
    public User getUser()
    {
        return user;
    }    
    
    public void setUser(User user)
    {
        this.user = user;
    }

    public String getRePassword()
    {
        return rePassword;
    }

    public void setRePassword(String rePassword)
    {
        this.rePassword = rePassword;
    }
}
