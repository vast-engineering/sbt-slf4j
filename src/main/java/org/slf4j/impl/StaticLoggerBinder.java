package org.slf4j.impl;


import org.slf4j.ILoggerFactory;
//import org.slf4j.spi.LoggerFactoryBinder;

public class StaticLoggerBinder {
    public static String REQUESTED_API_VERSION = "1.7"; // !final

    private static final StaticLoggerBinder SINGLETON = new StaticLoggerBinder();

    private final ILoggerFactory loggerFactory;

    private StaticLoggerBinder(){
        loggerFactory = new SbtLoggerFactory();
    }

    public ILoggerFactory getLoggerFactory() {
        return loggerFactory;
    }

    public String getLoggerFactoryClassStr() {
        return SbtLoggerFactory.class.getName();
    }

    public static StaticLoggerBinder getSingleton(){
        return SINGLETON;
    }
}