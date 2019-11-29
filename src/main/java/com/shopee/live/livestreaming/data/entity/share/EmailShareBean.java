package com.shopee.live.livestreaming.data.entity.share;

import com.shopee.sdk.b.a;

public class EmailShareBean extends a {
    public String content;
    public ShareImage image;
    public String title;

    public EmailShareBean(ShareImage shareImage, String str, String str2) {
        this.image = shareImage;
        this.title = str;
        this.content = str2;
    }
}
