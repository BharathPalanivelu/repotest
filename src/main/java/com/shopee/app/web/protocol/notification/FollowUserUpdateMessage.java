package com.shopee.app.web.protocol.notification;

public class FollowUserUpdateMessage {
    private int followed;
    private int shopID;

    public int getShopId() {
        return this.shopID;
    }

    public boolean isFollowed() {
        return this.followed == 1;
    }
}
