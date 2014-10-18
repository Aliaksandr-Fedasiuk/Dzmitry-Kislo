package com.cdp.mem;

import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 18.10.14.
 */
public class Main {
    static final Logger logger = Logger.getLogger(Main.class);

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        int x = 0;
        int[] arr = {20};
        f(x, arr);
        logger.info("Invoke method f(x, arr):");
        logger.info("x=" + x + "; arr[0]=" + arr[0]);
        g(x, arr);
        logger.info("Invoke method g(x, arr):");
        logger.info("x=" + x + "; arr[0]=" + arr[0]);
        x = h(x, j(x, arr));
        logger.info("Invoke method h(x, j(x, arr)):");
        logger.info("x=" + x + "; arr[0]=" + arr[0]);
        try {
            stackOverflow();
        } catch (StackOverflowError e) {
            logger.info("Invoke method stackOverflow():");
            logger.info("The number of calls this method: " + counter);
        }

        try {
            outOfMemory();
        } catch (OutOfMemoryError e) {
            logger.info("Invoke method outOfMemory():");
            logger.error(e);
        }
    }

    private static void f(int x, int[] arr) {
        x += 30;
        arr[0] = 40;
    }

    private static void g(int x, int[] arr) {
        x = 50;
        arr = new int[]{60};
    }

    private static int h(int x, int[] arr) {
        x += 30;
        arr[0] = 50;
        return 42;
    }

    private static int[] j(int x, int[] arr) {
        x += 80;
        arr = new int[]{17};
        return arr;
    }

    private static void stackOverflow() {
        long l1 = 0;
        long l2 = 0;
        long l3 = 0;
        long l4 = 0;
        long l5 = 0;
        long l6 = 0;
        long l7 = 0;
        long l8 = 0;
        long l9 = 0;
        long l10 = 0;
        counter++;
        stackOverflow();
    }

    private static void outOfMemory() throws OutOfMemoryError{
        List list = new ArrayList();
        while (true) {
            list.add(new Object());
        }
    }


}
