package org.example.crud;

import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class Get {

    public static List getProducts(Session session) {

        String hql = "FROM Product";
        Query query = session.createQuery(hql);

        List results = query.getResultList();

        return results;
    }
}
