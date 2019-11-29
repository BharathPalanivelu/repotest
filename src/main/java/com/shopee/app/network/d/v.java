package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.protocol.action.GetChatQuickReply;

public class v extends az {
    /* access modifiers changed from: protected */
    public f a() {
        GetChatQuickReply.Builder builder = new GetChatQuickReply.Builder();
        builder.requestid(i().a()).build();
        return new f(125, builder.build().toByteArray());
    }
}
