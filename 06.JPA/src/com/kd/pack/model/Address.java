package com.kd.pack.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by dima on 7.12.14.
 */
@Embeddable
public class Address implements Serializable {
    String city;

    public Address() {
    }

    public Address(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (city != null ? !city.equals(address.city) : address.city != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return city != null ? city.hashCode() : 0;
    }
}
