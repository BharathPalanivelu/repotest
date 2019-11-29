package com.shopee.react.sdk.bridge.protocol.feed;

import com.shopee.navigator.b;

public class PostStatusRequest extends b {
    private String postId;

    public void setPostId(String str) {
        this.postId = str;
    }

    public String getPostId() {
        return this.postId;
    }
}
