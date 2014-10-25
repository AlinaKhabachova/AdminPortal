package com.alina.dao;

import com.alina.common.User;

import java.util.Collection;
import java.sql.SQLException;

public interface UserDAO
{
    public void addUser(User user) throws SQLException;
    
    public void updateUser(Long user_id, User user) throws SQLException;
    
    public User getUserById(Long user_id) throws SQLException;
    
    public Collection<User> getAllUsers() throws SQLException;
    
    public void deleteUser(User user) throws SQLException;
}
