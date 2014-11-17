package com.alina.common;

import com.alina.common.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.util.List;
 
public class UserService {
 
    public EntityManager em = Persistence.createEntityManagerFactory("adminportal").createEntityManager();
 
    public User add(User user){
        em.getTransaction().begin();
        User userFromDB = em.merge(user);
        em.getTransaction().commit();
        return userFromDB;
    }
    
    public void updateUser(User user){
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }
    
    public User getUserbyId(Long id){
        return em.find(User.class, id);
    }
 
    public void delete(Long id){
        em.getTransaction().begin();
        em.remove(getUserbyId(id));
        em.getTransaction().commit();
    } 
 
    public List<User> getAll(){
        TypedQuery<User> namedQuery = em.createNamedQuery("User.getAll", User.class);
        return namedQuery.getResultList();
    }
 
}