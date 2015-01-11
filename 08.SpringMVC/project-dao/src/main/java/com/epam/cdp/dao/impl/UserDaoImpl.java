package com.epam.cdp.dao.impl;

import com.epam.cdp.dao.UserDao;
import com.epam.cdp.domain.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by dima on 11.1.15.
 */
@Component
public class UserDaoImpl implements UserDao {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public List<User> getAllUser() {
        LOGGER.debug("get users()");
        return asList(new User(1L, "login", "name"));
    }
}
