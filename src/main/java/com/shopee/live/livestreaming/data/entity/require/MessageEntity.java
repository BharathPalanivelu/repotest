package com.shopee.live.livestreaming.data.entity.require;

import java.io.Serializable;

public class MessageEntity implements Serializable {
    private String content;
    private String usersig;
    private String uuid;

    public MessageEntity(String str, String str2, String str3) {
        this.uuid = str;
        this.content = str2;
        this.usersig = str3;
    }
}
