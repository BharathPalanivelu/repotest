package com.shopee.protocol.action;

import cn.tongdun.android.shell.settings.Constants;
import com.squareup.wire.ProtoEnum;

public enum ChatMsgSrc implements ProtoEnum {
    MSG_SRC_OLD_WEBCHAT(1000),
    MSG_SRC_NEW_WEBCHAT(2000),
    MSG_SRC_IOS(Constants.DEFAULT_WAIT_TIME),
    MSG_SRC_ANDROID(4000),
    MSG_SRC_PUSH(5000),
    MSG_SRC_CRM(6000);
    
    private final int value;

    private ChatMsgSrc(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
