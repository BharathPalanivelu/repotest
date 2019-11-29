package com.shopee.live.livestreaming.data.entity;

import com.shopee.sdk.b.a;

public class LiveStreamingSetting extends a {
    private int id = ((int) (Math.random() * 100.0d));
    private String name;

    public LiveStreamingSetting(String str) {
        this.name = str;
    }
}
