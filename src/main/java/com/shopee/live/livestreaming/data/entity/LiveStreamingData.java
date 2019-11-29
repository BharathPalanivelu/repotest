package com.shopee.live.livestreaming.data.entity;

import com.shopee.sdk.b.a;

public class LiveStreamingData extends a {
    private int id = ((int) (Math.random() * 100.0d));

    public String getId() {
        return String.valueOf(this.id);
    }
}
