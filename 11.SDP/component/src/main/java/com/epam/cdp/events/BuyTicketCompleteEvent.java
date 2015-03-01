package com.epam.cdp.events;

/**
 * Created by dima on 2.3.15.
 */
public class BuyTicketCompleteEvent implements Event {

    private String name;
    private Integer place;
    private String status;

    public BuyTicketCompleteEvent(String name, Integer place, String status) {
        this.name = name;
        this.place = place;
        this.status = status;
    }

    public String getFullDescription() {
        return "Transaction is finished with status: " + status;
    }
}
