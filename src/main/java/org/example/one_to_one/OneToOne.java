package org.example.one_to_one;

import org.example.model.Destination;
import org.example.model.Shipment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class OneToOne {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();


        Destination destination = new Destination("Destination 1");

        Shipment shipment = new Shipment("Shipment 1");
        shipment.setDestination(destination);

        Transaction transaction = session.beginTransaction();
        session.save(shipment);
        transaction.commit();

        session.close();

        System.out.println("Persisted ...");
    }
}
