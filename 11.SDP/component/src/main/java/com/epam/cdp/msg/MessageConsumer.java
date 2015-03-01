package com.epam.cdp.msg;

/**
 * Created by dima on 2.3.15.
 */
public interface MessageConsumer {

    public String receiveMessage() throws InterruptedException;
}
