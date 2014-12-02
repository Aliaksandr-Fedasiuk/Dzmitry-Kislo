package com.epam.cdp.service.impl;

import com.epam.cdp.entity.Book;
import com.epam.cdp.service.BookManager;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by dima on 30.11.14.
 */
@Stateless
@DeclareRoles("bean")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class BookManagerBean implements BookManager {

    @PersistenceContext(unitName = "unit")
    private EntityManager em;

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Book> findAll() {
        return em.createNamedQuery(Book.Query.FIND_ALL, Book.class).getResultList();
    }

    @Override
    @RolesAllowed("bean")
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void create(Book book) {
        book.setPublished(new Date());
        em.persist(book);
    }
}
