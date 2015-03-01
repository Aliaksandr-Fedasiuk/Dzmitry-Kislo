package com.epam.cdp;

import com.epam.cdp.events.Event;
import com.epam.cdp.msg.MessageProducer;
import com.epam.cdp.msg.socket.MessageProducerSocketImpl;
import com.google.gson.Gson;

import java.io.IOException;

/**
 * Created by dima on 2.3.15.
 */
public class SocketEventDispatcher {

    private MessageProducer messageProducer;
    private Gson gson;

    public SocketEventDispatcher() throws IOException {
        this.gson = new Gson();
        this.messageProducer = MessageProducerSocketImpl.getMessageProducer();
    }
    public void dispatch(Event event) {
        String message = gson.toJson(event);
        try {
            messageProducer.send(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
