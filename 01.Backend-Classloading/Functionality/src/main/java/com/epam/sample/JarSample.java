package com.epam.sample;

/**
 * Created by dima on 3.10.14.
 */
public interface JarSample {
    public static StringBuffer counter = new StringBuffer(""); //should be: new StringBuffer()
    int increment();
    String toString(); //should be deleted
}
