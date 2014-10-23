package main;

import java.sql.SQLException;
import java.util.List;

import com.alina.common.User;

import dao.Factory;

public class Main
{
    
    public static void main(String[] args) throws SQLException
    {
        User u1 = new User();
        
        u1.setFirstName("Donna");
        u1.setLastName("Madonna");
        u1.setPassword("1111");
        u1.setRole("admin");
        
        Factory.getInstance().getUserDao().addUser(u1);
        
        List<User> users = (List<User>) Factory.getInstance().getUserDao()
                .getAllUsers();
        System.out.println("Users");
        for (int i = 0; i < users.size(); ++i)
        {
            System.out.println("User name: " + users.get(i).getFirstName()
                    + ",  id : " + users.get(i).getId());
        }
    }
}