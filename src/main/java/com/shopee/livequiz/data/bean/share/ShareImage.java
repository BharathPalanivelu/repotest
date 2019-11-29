package com.shopee.livequiz.data.bean.share;

import com.shopee.sdk.b.a;

public class ShareImage extends a {
    public String imageBase64;
    public String imageUrl;

    public ShareImage(String str, String str2) {
        this.imageUrl = str;
        this.imageBase64 = str2;
    }
}
