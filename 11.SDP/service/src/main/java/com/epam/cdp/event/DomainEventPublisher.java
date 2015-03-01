package com.epam.cdp.event;

import com.epam.cdp.events.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 2.3.15.
 */
public class DomainEventPublisher {

    private static final DomainEventPublisher publisher = new DomainEventPublisher();

    private List<Subscriber> subscribers;

    private DomainEventPublisher() {
        this.subscribers = new ArrayList<>();
    }

    public void subscribe(Subscriber subscriber) {
        if (subscribers == null) {
            subscribers = new ArrayList<>();
        }
        subscribers.add(subscriber);
    }

    public void publish(Event event) {
        for (Subscriber subscriber : subscribers) {
            if (subscriber.subscribedToEventType() == event.getClass()) {
                subscriber.handleEvent(event);
            }
        }
    }

    public static DomainEventPublisher getInstance() {
        return publisher;
    }
}
