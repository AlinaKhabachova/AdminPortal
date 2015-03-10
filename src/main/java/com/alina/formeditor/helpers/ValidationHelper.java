package com.alina.formeditor.helpers;

import com.alina.formeditor.entity.IndexedEntity;

import java.util.Collection;

public class ValidationHelper
{
    public static boolean isNullOrEmpty(Object... args)
    {
        for (Object obj : args)
        {
            if (obj == null)
            {
                return true;
            }
            else
            {
                if (obj instanceof String)
                {
                    String str = (String) obj;
                    if (str.trim().isEmpty())
                    {
                        return true;
                    }
                }
                if (obj instanceof Collection)
                {
                    Collection coll = (Collection) obj;
                    if (coll.isEmpty())
                    {
                        return true;
                    }
                }
                if (obj instanceof IndexedEntity)
                {
                    IndexedEntity indexedEntity = (IndexedEntity) obj;
                    if (indexedEntity.getId() == null || indexedEntity.getId()
                            .equals(0L))
                    {
                        return true;
                    }
                }
                if (obj instanceof Long)
                {
                    Long lng = (Long) obj;
                    if (lng.equals(0L))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
