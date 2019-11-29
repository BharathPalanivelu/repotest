package com.shopee.live.livestreaming.data.entity.share;

import com.shopee.sdk.b.a;

public class FacebookShareBean extends a {
    public String contentUrl;
    public String hashTag;
    public String quote;

    public FacebookShareBean(String str, String str2, String str3) {
        this.contentUrl = str2;
        this.quote = str;
        this.hashTag = str3;
    }
}
