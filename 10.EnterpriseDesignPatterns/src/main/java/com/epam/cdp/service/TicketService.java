package com.epam.cdp.service;



import com.epam.cdp.db.DBEmulation;
import com.epam.cdp.model.PictureShow;
import com.epam.cdp.model.User;
import com.epam.cdp.transaction.Transaction;
import com.epam.cdp.transaction.TransactionManager;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by dima on 15.2.15.
 */
public class TicketService {
    public static final double DEFAULT_BALANCE = 10000d;
    private TransactionManager transactionManager = new TransactionManager();

    public Long registerUser(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setBalance(DEFAULT_BALANCE);
        DBEmulation.addUser(user);
        return user.getId();
    }

    public void buyTickets(long userId, int place) {
        Long trId = transactionManager.startTransaction();
        Transaction transaction = transactionManager.getTransaction(trId);
        try {
            User user = DBEmulation.getUserById(userId);
            // Get the first showTime
            PictureShow pictureShow = DBEmulation.getPictureShow(0L);
            double cost = pictureShow.getCost();
            user.setBalance(user.getBalance() - cost);
            transaction.createSavepoint(user, cost);
            addPlace(pictureShow, place);
            transaction.commit();
        } catch (Exception ex) {
            transaction.abort();
        }

    }

    private void addPlace(PictureShow pictureShow, int place) throws Exception {
        if (Math.random() < 0.5) {
            throw new Exception("Dummy exception");
        }
        CopyOnWriteArrayList<Integer> busySeats = pictureShow.getBusySeats();
        busySeats.add(place);
    }


}
