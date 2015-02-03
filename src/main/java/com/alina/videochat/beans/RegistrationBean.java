package com.alina.videochat.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.codec.digest.DigestUtils;

import com.alina.videochat.common.IndexedEntityService;
import com.alina.videochat.entity.User;

@ManagedBean(name = "registrationBean")
@ViewScoped
public class RegistrationBean implements Serializable
{
    private static final long serialVersionUID = 952405654821324694L;
    
    private String            rePassword;
    
    private String            password;
    
    private User              user             = new User();
    
    public void save()
    {
        if (password.equals(rePassword))
        {
            user.setPassword(DigestUtils.md5Hex(password));
            IndexedEntityService.save(user);
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
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
}
