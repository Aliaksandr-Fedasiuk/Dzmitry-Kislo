package com.epam.cdp.event;

import com.epam.cdp.events.BuyTicketCompleteEvent;
import com.epam.cdp.events.Event;

/**
 * Created by dima on 2.3.15.
 */
public class BuyTicketEventSubscriber implements Subscriber {

    @Override
    public void handleEvent(Event event) {
        BuyTicketCompleteEvent buyTicketCompleteEvent = (BuyTicketCompleteEvent) event;
        System.out.println(buyTicketCompleteEvent.getFullDescription());
    }

    @Override
    public Class subscribedToEventType() {
        return BuyTicketCompleteEvent.class;
    }
}
