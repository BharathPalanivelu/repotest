package com.shopee.app.b.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.a.o;
import com.shopee.app.b.a.c;
import com.shopee.app.util.sfchat.ui.SFChatProxyActivity_;
import com.shopee.navigator.c.a;
import com.shopee.navigator.c.b;
import d.d.b.j;

public final class d extends b {
    /* renamed from: c */
    public c a() {
        return new c("SALESFORCE_CS_CHAT");
    }

    public Class<SFChatProxyActivity_> b() {
        return SFChatProxyActivity_.class;
    }

    public Intent a(Activity activity, a aVar, o oVar, boolean z) {
        Intent b2 = SFChatProxyActivity_.a((Context) activity).a(String.valueOf(oVar)).b();
        j.a((Object) b2, "SFChatProxyActivity_.int…))\n                .get()");
        return b2;
    }
}
