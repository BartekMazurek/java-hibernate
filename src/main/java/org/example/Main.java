package org.example;

import org.example.crud.*;
import org.example.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        // CREATE
        Product product1 = new Product();
        product1.setName("Product 1");
        product1.setPrice(1000);

        Product product2 = new Product();
        product2.setName("Product 2");
        product2.setPrice(1500);

        Integer id1 = Create.saveProduct(session, product1);
        Integer id2 = Create.saveProduct(session, product2);

        System.out.println("Created product with id: " + id1);
        System.out.println("Created product with id: " + id2);

        // GET DATA - ALL PRODUCTS
        List<Product> results = Get.getProducts(session);
        System.out.println("All products:");
        for(Object p: results) {
            Product product = (Product)p;
            System.out.println("Product id: " + product.getId() + ", name: " + product.getName());
        }

        // GET DATA - SPECIFIED PRODUCT
        List productResult = Get2.getProduct(session, results.get(0).getId());
        System.out.println("Specified product:");
        for(Object pr: productResult) {
            Product product = (Product)pr;
            System.out.println("Product id: " + product.getId() + ", name: " + product.getName());
        }

        // UPDATE SPECIFIED PRODUCT
        Product productToUpdate = (Product)productResult.get(0);
        productToUpdate.setName("Updated product name");
        Update.updateProduct(session, productToUpdate);
        System.out.println("Updated product with id: " + productToUpdate.getId());

        // DELETE SPECIFIED PRODUCT
        Delete.deleteProduct(session, results.get(1).getId());

    }
}