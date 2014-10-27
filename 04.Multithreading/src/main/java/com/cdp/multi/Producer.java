package com.cdp.multi;

import org.apache.log4j.Logger;

/**
 * Created by dima on 27.10.14.
 */
public class Producer implements Runnable {
    static final Logger logger = Logger.getLogger(Producer.class);
    private final int id;
    private int startValue;
    private final int period;
    private final ElementBuffer elementBuffer;

    public Producer(int id, int period, ElementBuffer elementBuffer, int startValue) {
        this.id = id;
        this.period = period;
        this.elementBuffer = elementBuffer;
        this.startValue = startValue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                logger.info("Producer" + id + ": write to file.");
                elementBuffer.put("Producer" + id + " : Info value...:" + startValue++);
                Thread.sleep(period);
            } catch (InterruptedException e) {
                logger.error(Thread.currentThread().getName() + "stopped");
                break;
            }
        }
    }
}
