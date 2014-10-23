package dao;

import dao.UserDAO;
import dao.impl.UserDAOImpl;

public class Factory
{
    private static UserDAO  userDao  = null;
    private static Factory instance = null;
    
    public static synchronized Factory getInstance()
    {
        if (instance == null)
        {
            instance = new Factory();
        }
        return instance;
    }
    
    public UserDAO getUserDao()
    {
        if (userDao == null)
        {
            userDao = new UserDAOImpl();
        }
        return userDao;
    }
}
