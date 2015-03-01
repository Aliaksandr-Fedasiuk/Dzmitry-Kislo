package com.epam.cdp.model;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by dima on 15.2.15.
 */
public class PictureShow {
    private static Long pictureShowCounter = 0L;
    private static Integer DEFAULT_SEATS_COUNT = 100;

    private Long id;
    private String name;
    private double cost;
    private CopyOnWriteArrayList<Integer> busySeats;
    private int maxSeatsCount = DEFAULT_SEATS_COUNT;

    public PictureShow() {
        pictureShowCounter++;
        id = pictureShowCounter;
        busySeats = new CopyOnWriteArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public CopyOnWriteArrayList<Integer> getBusySeats() {
        return busySeats;
    }

    public void setBusySeats(CopyOnWriteArrayList<Integer> busySeats) {
        this.busySeats = busySeats;
    }

    public int getMaxSeatsCount() {
        return maxSeatsCount;
    }

    public void setMaxSeatsCount(int maxSeatsCount) {
        this.maxSeatsCount = maxSeatsCount;
    }
}
