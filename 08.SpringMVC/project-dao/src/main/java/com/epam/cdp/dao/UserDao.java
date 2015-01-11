package com.epam.cdp.dao;

import com.epam.cdp.domain.User;

import java.util.List;

/**
 * Created by dima on 11.1.15.
 */
public interface UserDao {

    public List<User> getAllUser();
}
