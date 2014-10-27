package com.cdp.multi;

import java.io.IOException;

/**
 * Created by dima on 27.10.14.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ElementBuffer elementBuffer = new ElementBuffer();
        new Thread(new Producer(1, 200, elementBuffer, 1)).start();
        new Thread(new Consumer(1,1000, elementBuffer)).start();
    }
}
