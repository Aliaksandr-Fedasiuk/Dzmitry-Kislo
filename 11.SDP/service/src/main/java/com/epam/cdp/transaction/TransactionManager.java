package com.epam.cdp.transaction;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by dima on 15.2.15.
 */
public class TransactionManager {

    private ConcurrentHashMap<Long, Transaction> transactions = new ConcurrentHashMap<>();

    public Transaction getTransaction(Long id) {
        return transactions.get(id);
    }

    public Long startTransaction() {
        final Transaction transaction = new TransactionImpl();
        Long id = transaction.beginTransaction();
        transactions.put(id, transaction);
        return id;
    }
}
