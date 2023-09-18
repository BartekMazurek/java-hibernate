package org.example.crud;

import org.example.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Delete {
    public static void deleteProduct(Session session, int id) {

        Transaction transaction = session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.delete(product);
        transaction.commit();

        System.out.println("Deleted product with id: " + id);
    }
}
