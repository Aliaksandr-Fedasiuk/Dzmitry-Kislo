package com.epam.cdp;

import com.epam.cdp.event.BuyTicketEventSubscriber;
import com.epam.cdp.event.DomainEventPublisher;
import com.epam.cdp.port.BuyTicketListener;

import java.io.IOException;

/**
 * Created by dima on 2.3.15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        DomainEventPublisher.getInstance().subscribe(new BuyTicketEventSubscriber());
        BuyTicketListener buyTicketListener = new BuyTicketListener();

        while (true) {
            try {
                buyTicketListener.readMessage();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
