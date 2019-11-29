package com.shopee.app.react.modules.app.data;

import com.google.a.l;
import com.google.a.o;
import com.shopee.app.react.protocol.RNBundleInfo;
import com.shopee.app.util.n;
import com.shopee.app.web.WebRegister;
import d.d.b.j;

public final class k implements i {

    /* renamed from: a  reason: collision with root package name */
    private RNBundleInfo f18756a = new RNBundleInfo(new o());

    /* renamed from: b  reason: collision with root package name */
    private final String f18757b = "fullScreenAndroid";

    /* renamed from: c  reason: collision with root package name */
    private n f18758c;

    public k(n nVar) {
        j.b(nVar, "mDataEventBus");
        this.f18758c = nVar;
    }

    public boolean a(String str) {
        j.b(str, "key");
        return j.a((Object) "rnBundleInfo", (Object) str);
    }

    public String c(String str) {
        Object a2 = WebRegister.GSON.a(str, RNBundleInfo.class);
        j.a(a2, "WebRegister.GSON.fromJso…RNBundleInfo::class.java)");
        this.f18756a = (RNBundleInfo) a2;
        this.f18758c.a().aE.a();
        return "";
    }

    private final o g() {
        return this.f18756a.getFeatures();
    }

    public final boolean a() {
        if (!g().b("newWallet")) {
            return false;
        }
        l c2 = g().c("newWallet");
        j.a((Object) c2, "getFeatures().get(\"newWallet\")");
        return c2.h();
    }

    public final boolean b() {
        if (!g().b("dataPointPopup")) {
            return false;
        }
        l c2 = g().c("dataPointPopup");
        j.a((Object) c2, "getFeatures().get(\"dataPointPopup\")");
        return c2.h();
    }

    public final boolean c() {
        if (!g().b("csLiveChatFeedbackPopup")) {
            return false;
        }
        l c2 = g().c("csLiveChatFeedbackPopup");
        j.a((Object) c2, "getFeatures().get(\"csLiveChatFeedbackPopup\")");
        return c2.h();
    }

    public final boolean d() {
        if (!g().b("cart")) {
            return false;
        }
        l c2 = g().c("cart");
        j.a((Object) c2, "getFeatures().get(\"cart\")");
        return c2.h();
    }

    public final boolean e() {
        if (!g().b("shopeeBuddy")) {
            return false;
        }
        l c2 = g().c("shopeeBuddy");
        j.a((Object) c2, "getFeatures().get(\"shopeeBuddy\")");
        return c2.h();
    }

    public final boolean f() {
        if (!g().b("jkoPay")) {
            return false;
        }
        l c2 = g().c("jkoPay");
        j.a((Object) c2, "getFeatures().get(\"jkoPay\")");
        return c2.h();
    }
}
