package com.alina.formeditor.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import org.apache.commons.codec.digest.DigestUtils;

import com.alina.formeditor.common.IndexedEntityService;
import com.alina.formeditor.entity.User;

@ManagedBean(name = "registrationBean")
@ViewScoped
public class RegistrationBean extends BaseBean
{
    private static final long serialVersionUID = -7655683315469674417L;

    private String            password;
    
    private String            rePassword;
    
    private User              user             = new User();
    
    private boolean           confirmPassword;

    public void save()
    {
        if (isConfirmPassword())
        {
            user.setPassword(DigestUtils.md5Hex(getPassword()));
            IndexedEntityService.save(getUser());
        }
    }
    
    public void validatePassword(ComponentSystemEvent event)
    {
        UIComponent components = event.getComponent();
        
        UIInput uiInputPassword = (UIInput) components
                .findComponent("password");
        password = uiInputPassword.getLocalValue() == null ? ""
                : uiInputPassword.getLocalValue().toString();
        
        UIInput uiInputConfirmPassword = (UIInput) components
                .findComponent("repassword");
        rePassword = uiInputConfirmPassword.getLocalValue() == null ? ""
                : uiInputConfirmPassword.getLocalValue().toString();
        
        if (!getPassword().equals(getRePassword()))
        {
            FacesMessage msg = new FacesMessage(
                    "Password must match Re password");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        else
        {
            setConfirmPassword(true);
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
    
    public boolean isConfirmPassword()
    {
        return confirmPassword;
    }
    
    public void setConfirmPassword(boolean confirmPassword)
    {
        this.confirmPassword = confirmPassword;
    }
}
