package com.shopee.app.network.b;

import com.shopee.d.a.c;
import okhttp3.Call;
import okhttp3.EventListener;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static EventListener.Factory f17775a = $$Lambda$a$cOp3cWQySdvAp75dcsWEXevX6s.INSTANCE;

    /* access modifiers changed from: private */
    public static /* synthetic */ EventListener a(Call call) {
        try {
            return c.f27127a.create(call);
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            com.garena.b.a.a.a("Shopee Network EventListener", (Throwable) e2);
            return EventListener.NONE;
        }
    }
}
