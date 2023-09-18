package org.example.crud;

import org.example.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Create {
    public static Integer saveProduct(Session session, Product product) {

        try {
            Transaction transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //session.close();
        }

        return product.getId();
    }
}
