package com.shopee.app.react.modules.app.sms;

import android.app.Activity;
import com.facebook.react.bridge.Promise;
import com.garena.android.appkit.b.i;
import com.google.a.o;
import com.shopee.app.react.c;
import com.shopee.app.react.modules.base.b;
import com.shopee.app.ui.auth.phone.SmsOtpReceiver;
import d.d.b.j;

public final class a extends b implements com.shopee.app.react.util.a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0284a f18784a = new C0284a((g) null);

    /* renamed from: b  reason: collision with root package name */
    private final i f18785b = com.garena.a.a.a.b.a(this);

    /* renamed from: c  reason: collision with root package name */
    private Promise f18786c;

    /* renamed from: d  reason: collision with root package name */
    private final c f18787d;

    public void b() {
    }

    public void c() {
    }

    public a(c cVar) {
        this.f18787d = cVar;
    }

    public void a() {
        this.f18785b.a();
    }

    public void d() {
        this.f18785b.b();
    }

    public final void a(Promise promise) {
        this.f18786c = promise;
        c cVar = this.f18787d;
        if (cVar != null) {
            SmsOtpReceiver.a aVar = SmsOtpReceiver.f19679a;
            Activity a2 = cVar.a();
            j.a((Object) a2, "this.context");
            aVar.a(a2);
        }
    }

    public final void a(String str) {
        j.b(str, "otp");
        Promise promise = this.f18786c;
        if (promise != null) {
            promise.resolve(b(str));
        }
    }

    private final String b(String str) {
        o oVar = new o();
        oVar.a("error", (Number) 0);
        oVar.a("code", str);
        String oVar2 = oVar.toString();
        j.a((Object) oVar2, "JsonObject().apply {\n   …otp)\n        }.toString()");
        return oVar2;
    }

    /* renamed from: com.shopee.app.react.modules.app.sms.a$a  reason: collision with other inner class name */
    public static final class C0284a {
        private C0284a() {
        }

        public /* synthetic */ C0284a(g gVar) {
            this();
        }
    }
}
