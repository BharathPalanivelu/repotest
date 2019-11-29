package com.shopee.live.livestreaming.data.entity.require;

import java.io.Serializable;

public class ExitLiveEntity implements Serializable {
    private String usersig;
    private String uuid;

    public ExitLiveEntity(String str, String str2) {
        this.uuid = str;
        this.usersig = str2;
    }
}
