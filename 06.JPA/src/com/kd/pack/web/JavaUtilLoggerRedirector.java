package com.kd.pack.web;

import org.slf4j.bridge.SLF4JBridgeHandler;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by dima on 6.12.14.
 */
public class JavaUtilLoggerRedirector implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //remove default handlers
        Logger rootLogger = LogManager.getLogManager().getLogger("");
        for(Handler handler : rootLogger.getHandlers()) {
            rootLogger.removeHandler(handler);
        }

        //install redirect handler
        SLF4JBridgeHandler.install();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
