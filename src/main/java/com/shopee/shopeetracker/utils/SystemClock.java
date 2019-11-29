package com.shopee.shopeetracker.utils;

public class SystemClock implements Clock {
    public long currentTime() {
        return System.currentTimeMillis();
    }
}
