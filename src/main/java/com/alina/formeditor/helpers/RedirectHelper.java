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
            ExternalContext ec = FacesContext.getCurrentInstance()
                    .getExternalContext();
            HttpServletRequest req = (HttpServletRequest) ec.getRequest();
            String urlRequest = req.getRequestURL().substring(0, req.getRequestURL().indexOf(req.getRequestURI()));
            urlRequest = urlRequest.concat("/formeditor/" + page.toString());
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect(urlRequest);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
