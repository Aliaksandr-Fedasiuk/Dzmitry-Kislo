package com.epam.cdp.web;

import com.epam.cdp.domain.User;
import com.epam.cdp.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by dima on 11.1.15.
 */
@Controller
public class UserController {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String init() {
        return "index";
    }

    @RequestMapping("/usersList")
    public ModelAndView getListUsersView() {
        List<User> users = userService.getAllUserService();
        LOGGER.debug("users.size = " + users.size());
        ModelAndView view = new ModelAndView("usersList", "users", users);
        return view;
    }
}
