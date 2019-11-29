package com.shopee.live.livestreaming.data.entity.require;

import java.io.Serializable;

public class JoinLiveEntity implements Serializable {
    private String avatar;
    private String uuid;

    public JoinLiveEntity(String str, String str2) {
        this.uuid = str;
        this.avatar = str2;
    }
}
