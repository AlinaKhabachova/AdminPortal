package com.alina.videochat.common;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.alina.videochat.entity.IndexedEntity;

public class IndexedEntityService
{
    
    public static EntityManager em = Persistence.createEntityManagerFactory(
                                           "videochat").createEntityManager();
    
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