package dao.impl;

import dao.UserDAO;

import com.alina.common.User;

import java.sql.SQLException;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

import com.alina.common.HibernateUtil;

import javax.swing.*;

import org.hibernate.Session;


public class UserDAOImpl implements UserDAO
{
    @Override
    public void addUser(User user) throws SQLException
    {
        Session session = null;
        try {
          session = HibernateUtil.createSessionFactory().openSession();
          session.beginTransaction();
          session.save(user);
          session.getTransaction().commit();
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e.getMessage(), "error inserting", JOptionPane.OK_OPTION);
        } finally {
          if (session != null && session.isOpen()) {

            session.close();
          }
        }
       
    }
    
    @Override
    public void updateUser(Long user_id, User user) throws SQLException
    {
        Session session = null;
        try {
          session = HibernateUtil.createSessionFactory().openSession();
          session.beginTransaction();
          session.update(user);
          session.getTransaction().commit();
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e.getMessage(), "error 'insert'", JOptionPane.OK_OPTION);
        } finally {
          if (session != null && session.isOpen()) {
            session.close();
          }
        }
        
    }
    
    @Override
    public User getUserById(Long user_id) throws SQLException
    {
        Session session = null;
        User user = null;
        try {
          session = HibernateUtil.createSessionFactory().openSession();
          user = (User) session.load(User.class, user_id);
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e.getMessage(), "error 'findById'", JOptionPane.OK_OPTION);
        } finally {
          if (session != null && session.isOpen()) {
            session.close();
          }
        }
        return user;
    }
    
    @Override
    public Collection<User> getAllUsers() throws SQLException
    {
        Session session = null;
        List users = new ArrayList<User>();
        try {
          session = HibernateUtil.createSessionFactory().openSession();
          users = session.createCriteria(User.class).list();
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e.getMessage(), "error 'getAll'", JOptionPane.OK_OPTION);
        } finally {
          if (session != null && session.isOpen()) {
            session.close();
          }
        }
        return users;
    }
    
    @Override
    public void deleteUser(User user) throws SQLException
    {
        Session session = null;
        try {
          session = HibernateUtil.createSessionFactory().openSession();
          session.beginTransaction();
          session.delete(user);
          session.getTransaction().commit();
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e.getMessage(), "error 'delete'", JOptionPane.OK_OPTION);
        } finally {
          if (session != null && session.isOpen()) {
            session.close();
          }
        }
        
    }
}
