package com.alina.formeditor.helpers;

import com.alina.formeditor.enums.Pages;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RedirectHelper
{
    public static void redirectTo(Pages page)
    {
        try
        {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            HttpServletRequest req = (HttpServletRequest) ec.getRequest();
            req.getRequestURL().substring(0,req.getRequestURL().indexOf(req.getContextPath()));
            req.getRequestURL().append(page.toString());
            FacesContext.getCurrentInstance().getExternalContext().redirect("formeditor/"+ page.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
