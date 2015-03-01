package com.epam.cdp.event;

import com.epam.cdp.events.Event;

/**
 * Created by dima on 2.3.15.
 */
public interface Subscriber {
    public void handleEvent(Event event);

    public Class subscribedToEventType();
}
