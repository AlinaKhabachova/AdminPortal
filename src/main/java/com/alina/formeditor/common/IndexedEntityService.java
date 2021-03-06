package com.alina.formeditor.common;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.alina.formeditor.entity.IndexedEntity;
import com.alina.formeditor.entity.User;

public class IndexedEntityService
{
    
    public static EntityManager em = Persistence.createEntityManagerFactory(
                                           "formeditor").createEntityManager();

    public static void save(IndexedEntity indexedEntity)
    {
        em.getTransaction().begin();
        em.merge(indexedEntity);
        em.getTransaction().commit();
    }
    
    public static void delete(IndexedEntity indexedEntity)
    {
        em.getTransaction().begin();
        em.remove(indexedEntity);
        em.getTransaction().commit();
    }
}