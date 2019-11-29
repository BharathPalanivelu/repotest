package com.shopee.app.web2.b.d;

import android.content.Context;
import com.shopee.app.ui.home.HomeActivity_;
import com.shopee.app.util.x;
import com.shopee.navigator.e;
import com.shopee.web.sdk.bridge.protocol.navigation.JumpRequest;
import d.d.b.j;
import d.m;

public final class a extends com.shopee.web.sdk.bridge.a.e.a {

    /* renamed from: a  reason: collision with root package name */
    public e f26647a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        j.b(context, "context");
        Object b2 = ((x) context).b();
        if (b2 != null) {
            ((com.shopee.app.web2.b.a) b2).a(this);
            return;
        }
        throw new m("null cannot be cast to non-null type com.shopee.app.web2.bridge.WebBridgeSdkInjector");
    }

    /* access modifiers changed from: protected */
    public void a(JumpRequest jumpRequest) {
        if (jumpRequest != null) {
            ((HomeActivity_.a) HomeActivity_.a(f()).k(67108864)).a(jumpRequest.getPath()).a();
        }
    }
}
