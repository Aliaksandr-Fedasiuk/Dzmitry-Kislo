package com.epam.cdp.transaction;

import com.epam.cdp.db.DBEmulation;
import com.epam.cdp.model.User;
import com.epam.cdp.model.UserWrapper;

import java.util.Objects;

/**
 * Created by dima on 15.2.15.
 */
public class TransactionImpl implements Transaction {
    private static Long transactionId = 0L;

    private Long id;
    private UserWrapper savepoint;
    private Status status;

    @Override
    public void abort() {
        status = Status.aborted;
        if (savepoint != null) {
            if (savepoint.getCost() != null) {
                User user = DBEmulation.getUserById(savepoint.getId());
                user.setBalance(user.getBalance() + savepoint.getCost());
            }
        }
    }

    @Override
    public void commit() {
        status = Status.completed;
    }

    @Override
    public Long beginTransaction() {
        transactionId++;
        id = transactionId;
        status = Status.started;
        return id;
    }

    @Override
    public void createSavepoint(final User user, Double cost) {
        UserWrapper newUserWrapper = convertUserToWrapper(user, cost);
        if (savepoint == null) {
            savepoint = newUserWrapper;
        } else {
            if (savepoint.getId() == null) {
                savepoint.setId(newUserWrapper.getId());
            } else {
                if (!Objects.equals(newUserWrapper.getId(), savepoint.getId())) {
                    throw new TransactionException(
                            "Cannot create savepoint. Objects ids are not equals");
                }
            }

            if (newUserWrapper.getCost() != null) {
                savepoint.setCost(newUserWrapper.getCost());
            }

            if (newUserWrapper.getPlaces() != null
                    && newUserWrapper.getPlaces().isEmpty()) {
                savepoint.setPlaces(newUserWrapper.getPlaces());
            }
        }
    }

    @Override
    public Status getStatus() {
        return status;
    }

    public UserWrapper convertUserToWrapper(User user, Double cost) {
        UserWrapper userWrapper = new UserWrapper();
        userWrapper.setId(user.getId());
        userWrapper.setCost(cost);
        return userWrapper;
    }
}
