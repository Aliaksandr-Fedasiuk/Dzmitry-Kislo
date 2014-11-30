package com.epam.cdp.service;

import com.epam.cdp.entity.Book;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by dima on 30.11.14.
 */
@Local
public interface BookManager {
    List<Book> findAll();
    void create(final Book book);
}
