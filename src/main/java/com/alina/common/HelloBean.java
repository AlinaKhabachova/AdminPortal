package com.alina.common;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
 
@ManagedBean
(name = "helloBean")
@SessionScoped
public class HelloBean implements Serializable {
      
    private static final long serialVersionUID = 3642598894525500326L;
    private String name;
 
    public String getName() 
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
}