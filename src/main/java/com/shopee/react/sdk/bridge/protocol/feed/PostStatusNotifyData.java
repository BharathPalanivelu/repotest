package com.shopee.react.sdk.bridge.protocol.feed;

import com.shopee.navigator.b;

public class PostStatusNotifyData extends b {
    private String errorMsg;
    private int msgType;
    private FeedsPostData payload;

    public void setMsgType(int i) {
        this.msgType = i;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setPayload(FeedsPostData feedsPostData) {
        this.payload = feedsPostData;
    }

    public FeedsPostData getPayload() {
        return this.payload;
    }
}
