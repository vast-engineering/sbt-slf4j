package com.vast.sbtlogger;

public enum LogLevels {
    TRACE(0),
    DEBUG(1),
    INFO(2),
    WARN(3),
    ERROR(4);

    public final int level;
    LogLevels(int level) {
        this.level = level;
    }

}
