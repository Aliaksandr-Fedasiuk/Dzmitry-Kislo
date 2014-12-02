package com.epam.cdp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Created by dima on 30.11.14.
 */
@Entity
@Table(name = "book")
@NamedQueries(@NamedQuery(name = Book.Query.FIND_ALL, query = "SELECT b FROM Book b ORDER BY b.title"))
public class Book implements Serializable {
    public static class Query {
        public static final String FIND_ALL = "Book.findAll";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    private Date published;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(final Date published) {
        this.published = published;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", published=" + published + "]";
    }
}
