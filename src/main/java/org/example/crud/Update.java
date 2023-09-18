package org.example.crud;

import org.example.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Update {

    public static void updateProduct(Session session, Product product) {

        try {
            Transaction transaction = session.beginTransaction();
            session.update(product);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //session.close();
        }
    }

}
