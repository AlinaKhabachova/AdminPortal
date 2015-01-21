package com.alina.common;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.alina.common.User;
import com.alina.common.IndexedEntityService;

@ManagedBean(name = "registrationBean")
@ViewScoped
public class RegistrationBean
{
    private IndexedEntityService service = new IndexedEntityService();
    
    private User                 user    = new User();
    
    public User getUser()
    {
        return user;
    }
    
    public void setUser(User user)
    {
        this.user = user;
    }
    
    public IndexedEntityService getService()
    {
        return service;
    }
    
    public void setService(IndexedEntityService service)
    {
        this.service = service;
    }
    
    public void save()
    {
        service.add(user);
    }
}
