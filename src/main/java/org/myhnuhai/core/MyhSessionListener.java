package org.myhnuhai.core;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Administrator on 14-1-16.
 */
public class MyhSessionListener implements HttpSessionListener {

    private final static Logger logger = Logger.getLogger(MyhSessionListener.class);
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        logger.info(httpSessionEvent.getSession().getAttribute("UID")+"--Login");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        logger.info(httpSessionEvent.getSession().getAttribute("UID")+"--LogOut");
    }
}
