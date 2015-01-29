package com.alina.videochat.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.codec.digest.DigestUtils;

import com.alina.videochat.common.IndexedEntityService;
import com.alina.videochat.entity.User;

@ManagedBean(name = "registrationBean")
@ViewScoped
public class RegistrationBean
{
    private String rePassword;
    
    private User   user = new User();
    
    public void save()
    {
        if (!"".equals(user.getPassword()))
        {
            if (user.getPassword().equals(rePassword))
            {
                user.setPassword(DigestUtils.md5Hex(user.getPassword()));
                IndexedEntityService.add(user);
            }
        }
        else
        {
            System.out.println("wrong password");
        }
        
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
