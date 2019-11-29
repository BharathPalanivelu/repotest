package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum ChatMsgOpt implements ProtoEnum {
    MSG_OPT_NORMAL(0),
    MSG_OPT_AUTO_REPLY(1),
    MSG_OPT_BLOCKED(2),
    MSG_OPT_USER_CHAT(4),
    MSG_OPT_WEB_CHAT(8),
    MSG_OPT_CENSORED_BLACKLIST(16),
    MSG_OPT_CENSORED_WHITELIST(32),
    MSG_OPT_IGNORE_UNREAD_FOR_RECEIVER(64),
    MSG_OPT_IGNORE_UNREAD_FOR_SENDER(128),
    MSG_OPT_INVISIBLE_FOR_RECEIVER(256),
    MSG_OPT_INVISIBLE_FOR_SENDER(512),
    MSG_OPT_ADS(1024),
    MSG_OPT_FAQ_SESSION(2048),
    MSG_OPT_TRIGGER_FAQ(4096);
    
    private final int value;

    private ChatMsgOpt(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
