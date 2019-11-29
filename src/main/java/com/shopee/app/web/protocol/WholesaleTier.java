package com.shopee.app.web.protocol;

public class WholesaleTier {
    public final int max;
    public final int min;
    public final long price;

    public WholesaleTier(int i, int i2, long j) {
        this.min = i;
        this.max = i2;
        this.price = j;
    }
}
