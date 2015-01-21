package com.alina.common;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class IndexedEntityService
{
    
    public static EntityManager em = Persistence.createEntityManagerFactory(
                                    "adminportal").createEntityManager();
    
    public static IndexedEntity add(User user)
    {
        em.getTransaction().begin();
        User userFromDB = em.merge(user);
        em.getTransaction().commit();
        return userFromDB;
    }
    
    public static void update(IndexedEntity indexedEntity)
    {
        em.getTransaction().begin();
        em.merge(indexedEntity);
        em.getTransaction().commit();
    }
    
    public static IndexedEntity getById(Long id)
    {
        return em.find(IndexedEntity.class, id);
    }
    
    public static void delete(IndexedEntity indexedEntity)
    {
        em.getTransaction().begin();
        em.remove(indexedEntity);
        em.getTransaction().commit();
    }
    
    public static List<IndexedEntity> getAll()
    {
        return null;
    }
    
}