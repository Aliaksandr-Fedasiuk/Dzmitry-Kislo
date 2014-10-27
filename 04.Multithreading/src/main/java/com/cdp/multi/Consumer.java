package com.cdp.multi;

import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by dima on 27.10.14.
 */
public class Consumer implements Runnable {
    static final Logger logger = Logger.getLogger(Consumer.class);
    private final int id;
    private final int period;
    private final ElementBuffer elementBuffer;

    public Consumer(int id, int period, ElementBuffer elementBuffer) {
        this.id = id;
        this.period = period;
        this.elementBuffer = elementBuffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                List<String> elements = elementBuffer.get();
                logger.info("Consumer" + id + ": read from file.");
                for (String s : elements) {
                    logger.info("\t" + s);
                }
                Thread.sleep(period);
            } catch (InterruptedException e) {
                logger.error(Thread.currentThread().getName() + " stopped.");
                return;
            }
        }
    }
}
