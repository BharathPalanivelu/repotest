package com.shopee.live.livestreaming.data.entity.share;

import com.shopee.sdk.b.a;

public class ShareBean extends a {
    public ShareImage image;
    public String text;

    public ShareBean(String str, ShareImage shareImage) {
        this.text = str;
        this.image = shareImage;
    }
}
