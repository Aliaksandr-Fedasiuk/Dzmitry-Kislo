package com.epam.cdp.service.impl;

import com.epam.cdp.dao.UserDao;
import com.epam.cdp.domain.User;
import com.epam.cdp.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dima on 11.1.15.
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUserService() {
        LOGGER.debug("get users()");
        return userDao.getAllUser();
    }
}
