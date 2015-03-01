package com.epam.cdp.model;

import java.util.List;

/**
 * Created by dima on 15.2.15.
 */
public class UserWrapper {
    private Long id;
    private Double cost;
    private List<Integer> places;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public List<Integer> getPlaces() {
        return places;
    }

    public void setPlaces(List<Integer> places) {
        this.places = places;
    }
}
