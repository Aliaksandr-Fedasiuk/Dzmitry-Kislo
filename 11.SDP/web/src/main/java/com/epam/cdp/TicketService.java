package com.epam.cdp;

import com.epam.cdp.events.BuyTicketInitEvent;
import com.epam.cdp.events.Event;
import java.io.IOException;

/**
 * Created by dima on 2.3.15.
 */
public class TicketService {

    private SocketEventDispatcher dispatcher;

    public TicketService() {
        try {
            this.dispatcher = new SocketEventDispatcher();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void buyTicket(final String name, final String password, int place) {
        final Event event = new BuyTicketInitEvent(name, password, place);
        dispatcher.dispatch(event);
    }
}
