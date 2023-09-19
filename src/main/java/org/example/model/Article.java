package org.example.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String author;

    @Column
    private String content;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "article_tags", // MAPPING TABLE NAME
        joinColumns = @JoinColumn(name = "article_id"), // ARTICLES RELATION COLUMN NAME
        inverseJoinColumns = @JoinColumn(name = "tag_id") // TAGS RELATION COLUMN NAME
    )
    private Set<Tag> tags = new HashSet<>();

    public Article(String author, String content) {
        this.author = author;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }
}
