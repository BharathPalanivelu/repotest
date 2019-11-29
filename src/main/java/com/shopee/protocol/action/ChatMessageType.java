package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum ChatMessageType implements ProtoEnum {
    MSG_TYPE_TEXT(0),
    MSG_TYPE_IMAGE(1),
    MSG_TYPE_URL(2),
    MSG_TYPE_OFFER(3),
    MSG_TYPE_PRODUCT(4),
    MSG_TYPE_ORDER(5),
    MSG_TYPE_STICKER(6),
    MSG_TYPE_BUYER_CHANGE_ADDRESS(7),
    MSG_TYPE_WEBVIEW(8),
    MSG_TYPE_NOTIFICATION(9),
    MSG_TYPE_FAQ(10),
    MSG_TYPE_FAQ_QUESTION(11),
    MSG_TYPE_FAQ_FEEDBACK_PROMPT(12),
    MSG_TYPE_FAQ_FEEDBACK(13),
    MSG_TYPE_FAQ_UNSUPPORTED_INPUT(14),
    MSG_TYPE_LIVE_AGENT_PROMPT(15),
    MSG_TYPE_LIVE_AGENT(16);
    
    private final int value;

    private ChatMessageType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
