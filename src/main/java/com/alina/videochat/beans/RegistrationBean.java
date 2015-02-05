package com.alina.videochat.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import org.apache.commons.codec.digest.DigestUtils;

import com.alina.videochat.common.IndexedEntityService;
import com.alina.videochat.entity.User;

@ManagedBean(name = "registrationBean")
@ViewScoped
public class RegistrationBean implements Serializable
{
    private static final long serialVersionUID = 952405654821324694L;
    
    private String            password;
    
    private String            rePassword;
    
    private User              user             = new User();
    
    public void save()
    {
        if (getPassword().equals(getRePassword()))
        {
            user.setPassword(DigestUtils.md5Hex(getPassword()));
            IndexedEntityService.save(getUser());
        }
    }
    
    public void validatePassword(ComponentSystemEvent event)
    {
        UIComponent components = event.getComponent();
   
        UIInput uiInputPassword = (UIInput) components.findComponent("password");
       password = uiInputPassword.getLocalValue() == null ? ""
          : uiInputPassword.getLocalValue().toString();
              
        UIInput uiInputConfirmPassword = (UIInput) components.findComponent("repassword");
        rePassword = uiInputConfirmPassword.getLocalValue() == null ? ""
          : uiInputConfirmPassword.getLocalValue().toString();
        
        
        if (!password.equals(rePassword))
        {   
            FacesMessage msg = new FacesMessage("Password must match confirm password");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null,
                  msg);
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
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
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
