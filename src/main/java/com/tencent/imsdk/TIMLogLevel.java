package com.tencent.imsdk;

public enum TIMLogLevel {
    OFF("OFF"),
    ERROR("ERROR"),
    WARN("WARN"),
    INFO("INFO"),
    DEBUG("DEBUG");
    
    private String descr;

    private TIMLogLevel(String str) {
        this.descr = "INFO";
        this.descr = str;
    }

    public final String getDescr() {
        return this.descr;
    }

    public final int getIntLevel() {
        if (this.descr.equals("OFF")) {
            return 1;
        }
        if (this.descr.equals("ERROR")) {
            return 2;
        }
        if (this.descr.equals("WARN")) {
            return 3;
        }
        return this.descr.equals("DEBUG") ? 5 : 4;
    }
}
