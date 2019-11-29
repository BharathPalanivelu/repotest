package com.shopee.react.sdk.bridge.protocol.feed;

import com.shopee.navigator.b;
import java.util.ArrayList;

public class FeedPostStatusQueryData extends b {
    private ArrayList<FeedsPostData> post_list;

    public void setPost_list(ArrayList<FeedsPostData> arrayList) {
        this.post_list = arrayList;
    }

    public ArrayList<FeedsPostData> getPost_list() {
        return this.post_list;
    }
}
