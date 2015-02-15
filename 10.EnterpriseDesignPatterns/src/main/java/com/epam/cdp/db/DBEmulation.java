package com.epam.cdp.db;

import com.epam.cdp.model.Order;
import com.epam.cdp.model.PictureShow;
import com.epam.cdp.model.User;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by dima on 15.2.15.
 */
public class DBEmulation {
    private static ConcurrentHashMap<Long, User> users;
    private static ConcurrentHashMap<Long, Order> orders;
    private static ConcurrentHashMap<Long, PictureShow> pictureShow;

    static {
        users = new ConcurrentHashMap<>();
        orders = new ConcurrentHashMap<>();
        pictureShow = new ConcurrentHashMap<>();
        PictureShow defaultPictureShow = new PictureShow();
        defaultPictureShow.setName("Batman");
        defaultPictureShow.setCost(10D);
        defaultPictureShow.setMaxSeatsCount(100);
        defaultPictureShow.setBusySeats(new CopyOnWriteArrayList<Integer>());
        pictureShow.put(0L, defaultPictureShow);
    }

    public static User getUserById(Long id) {
        return users.get(id);
    }

    public static void addUser(User user) {
        users.put(user.getId(), user);
    }

    public static PictureShow getPictureShow(Long id) {
        return pictureShow.get(id);
    }
}
