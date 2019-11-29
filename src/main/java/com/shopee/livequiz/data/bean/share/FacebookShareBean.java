package com.shopee.livequiz.data.bean.share;

import com.shopee.sdk.b.a;

public class FacebookShareBean extends a {
    public String contentUrl;
    public String hashTag;
    public String quote;

    public FacebookShareBean(String str, String str2, String str3) {
        this.contentUrl = str;
        this.quote = str2;
        this.hashTag = str3;
    }
}
