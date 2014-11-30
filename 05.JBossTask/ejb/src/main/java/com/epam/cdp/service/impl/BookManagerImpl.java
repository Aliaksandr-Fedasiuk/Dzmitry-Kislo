package com.epam.cdp.service.impl;

import com.epam.cdp.entity.Book;
import com.epam.cdp.service.BookManager;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

/**
 * Created by dima on 30.11.14.
 */
@Stateless
public class BookManagerImpl implements BookManager {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Book> findAll() {
        return entityManager.createNamedQuery(Book.Query.FIND_ALL, Book.class).getResultList();
    }

    @Override
    public void create(Book book) {
        book.setId(UUID.randomUUID().toString().toUpperCase());
        entityManager.persist(book);
    }
}
