package com.kd.pack.rest;

import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;

/**
 * Created by dima on 7.12.14.
 */
public abstract class SpringAwareResource {
    @Context
    public void setContext(ServletContext sc) {
        autowire(sc);
    }

    public void autowire(ServletContext sc) {
        autowire(sc, this);
    }

    public static void autowire(ServletContext sc, Object target) {
        XmlWebApplicationContext context = (XmlWebApplicationContext) WebApplicationContextUtils.getWebApplicationContext(sc);
        context.getBeanFactory().autowireBean(target);
    }
}
