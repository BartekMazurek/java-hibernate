package org.example.crud;

import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class Get2 {

    public static List getProduct(Session session, int id) {

        String hql = "FROM Product P WHERE P.id = " + id;
        Query query = session.createQuery(hql);

        List results = query.getResultList();

        return results;
    }

}
