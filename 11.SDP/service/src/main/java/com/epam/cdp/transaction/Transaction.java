package com.epam.cdp.transaction;

import com.epam.cdp.model.User;

/**
 * Created by dima on 15.2.15.
 */
public interface Transaction {

    public void abort();

    public void commit();

    public Long beginTransaction();

    public void createSavepoint(final User user, Double cost);

    public Status getStatus();
}
