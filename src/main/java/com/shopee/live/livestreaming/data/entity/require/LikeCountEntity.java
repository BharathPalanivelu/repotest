package com.shopee.live.livestreaming.data.entity.require;

import java.io.Serializable;

public class LikeCountEntity implements Serializable {
    private int like_cnt;

    public LikeCountEntity(int i) {
        this.like_cnt = i;
    }
}
