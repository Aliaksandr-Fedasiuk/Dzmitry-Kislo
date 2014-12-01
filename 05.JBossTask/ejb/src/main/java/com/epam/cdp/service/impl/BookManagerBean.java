package com.epam.cdp.service.impl;

import com.epam.cdp.entity.Book;
import com.epam.cdp.service.BookManager;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by dima on 30.11.14.
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class BookManagerBean implements BookManager {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Book> findAll() {
        return em.createNamedQuery(Book.Query.FIND_ALL, Book.class).getResultList();
    }

    @Override
    public void create(Book book) {
        book.setId(UUID.randomUUID().toString().toUpperCase());
        book.setPublished(new Date());
        em.persist(book);
    }
}
