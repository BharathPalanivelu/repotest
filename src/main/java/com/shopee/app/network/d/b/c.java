package com.shopee.app.network.d.b;

import com.beetalklib.network.d.f;
import com.shopee.app.application.ar;
import com.shopee.app.network.d.az;
import com.shopee.protocol.action.ChatReady;

public class c extends az {
    /* access modifiers changed from: protected */
    public f a() {
        ChatReady.Builder builder = new ChatReady.Builder();
        builder.inapp_timestamp(Integer.valueOf(ar.f().e().uiStatusStore().w())).last_msgid(Long.valueOf(ar.f().e().chatBadgeStore().getMaxLastReceived())).requestid(i().a());
        return new f(74, builder.build().toByteArray());
    }
}
