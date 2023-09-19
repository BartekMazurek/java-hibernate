package org.example.many_to_many;

import org.example.model.Article;
import org.example.model.Tag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ManyToMany {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        Article article = new Article("John Doe", "Article content ...");

        Tag tag1 = new Tag("Tag 1");
        Tag tag2 = new Tag("Tag 2");

        article.addTag(tag1);
        article.addTag(tag2);

        Transaction transaction = session.beginTransaction();
        session.save(article);
        transaction.commit();

        session.close();

        System.out.println("Persisted ...");
    }
}
