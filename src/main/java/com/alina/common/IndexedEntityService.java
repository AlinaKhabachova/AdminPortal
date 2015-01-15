package com.alina.common;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class IndexedEntityService
{
    
    public EntityManager em = Persistence.createEntityManagerFactory(
                                    "adminportal").createEntityManager();
    
    public IndexedEntity add(User user)
    {
        em.getTransaction().begin();
        User userFromDB = em.merge(user);
        em.getTransaction().commit();
        return userFromDB;
    }
    
    public void update(IndexedEntity iE)
    {
        em.getTransaction().begin();
        em.merge(iE);
        em.getTransaction().commit();
    }
    
    public IndexedEntity getById(Long id)
    {
        return em.find(IndexedEntity.class, id);
    }
    
    public void delete(IndexedEntity iE)
    {
        em.getTransaction().begin();
        em.remove(iE);
        em.getTransaction().commit();
    }
    
    public List<IndexedEntity> getAll()
    {
        return null;
    }
    
}