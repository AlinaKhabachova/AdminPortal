package com.alina.formeditor.helpers;

import com.alina.formeditor.enums.Pages;

import javax.faces.context.FacesContext;
import java.io.IOException;

public class RedirectHelper
{
    public static void redirectTo(Pages page)
    {
        try
        {
            FacesContext.getCurrentInstance().getExternalContext().redirect("formeditor/"+ page.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
