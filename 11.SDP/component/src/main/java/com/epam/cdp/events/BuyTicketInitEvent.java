package com.epam.cdp.events;

/**
 * Created by dima on 2.3.15.
 */
public class BuyTicketInitEvent implements Event {

    private String name;
    private String password;
    private Integer place;

    public BuyTicketInitEvent(String name, String password, Integer place) {
        this.name = name;
        this.password = password;
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Integer getPlace() {
        return place;
    }

}
