package com.epam.cdp.port;


import com.epam.cdp.events.BuyTicketInitEvent;
import com.epam.cdp.msg.MessageConsumer;
import com.epam.cdp.msg.socket.MessageConsumerSocketImpl;
import com.epam.cdp.service.TicketService;
import com.google.gson.Gson;

import java.io.IOException;

/**
 * Created by dima on 2.3.15.
 */
public class BuyTicketListener {

    private MessageConsumer messageConsumer;
    private Gson gson = new Gson();
    private TicketService ticketService = new TicketService();

    public BuyTicketListener() throws IOException {
        this.messageConsumer = MessageConsumerSocketImpl.getMessageConsumer();
    }

    public void readMessage() throws InterruptedException {
        final String message = messageConsumer.receiveMessage();
        ticketService.buyTicket(gson.fromJson(message, BuyTicketInitEvent.class));
    }
}
