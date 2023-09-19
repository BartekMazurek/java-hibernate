package org.example.one_to_many;

import org.example.model.Comment;
import org.example.model.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class OneToMany {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        Post post = new Post(
                "John Doe",
                "Lorem ipsum ...."
        );

        Comment comment1 = new Comment(
                "Thomas Doe",
                "Comment 1..."
        );

        Comment comment2 = new Comment(
                "Jane Doe",
                "Comment 2..."
        );

        List<Comment> comments = new ArrayList<>();
        comments.add(comment1);
        comments.add(comment2);

        post.setComments(comments);

        Transaction transaction = session.beginTransaction();
        session.persist(post);
        transaction.commit();

        session.close();

        System.out.println("Persisted ...");
    }
}
