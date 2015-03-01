package com.epam.cdp.msg;

import java.io.IOException;

/**
 * Created by dima on 2.3.15.
 */
public interface MessageProducer {

    public void send(final String message) throws IOException;
}
