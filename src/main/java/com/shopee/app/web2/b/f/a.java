package com.shopee.app.web2.b.f;

import android.app.Activity;
import android.content.Context;
import com.facebook.react.bridge.UiThreadUtil;
import com.shopee.app.ui.sharing.base.b;
import com.shopee.web.sdk.bridge.protocol.sharing.ShareDataRequest;
import com.shopee.web.sdk.bridge.protocol.sharing.ShareDataResponse;
import d.d.b.j;
import d.m;

public final class a extends com.shopee.web.sdk.bridge.a.g.a implements b {

    /* renamed from: a  reason: collision with root package name */
    private com.shopee.app.ui.sharing.base.a<?> f26653a;

    public void onPreProcessingData() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        j.b(context, "context");
    }

    /* access modifiers changed from: protected */
    public void a(ShareDataRequest shareDataRequest) {
        if (shareDataRequest != null) {
            com.shopee.app.ui.sharing.base.a<?> aVar = this.f26653a;
            if (aVar != null) {
                aVar.c();
            }
            Context f2 = f();
            if (f2 != null) {
                String sharingAppID = shareDataRequest.getSharingAppID();
                String lVar = shareDataRequest.getSharingData().toString();
                j.a((Object) lVar, "request.sharingData.toString()");
                this.f26653a = com.shopee.app.ui.sharing.b.a((Activity) f2, sharingAppID, lVar, this);
                return;
            }
            throw new m("null cannot be cast to non-null type android.app.Activity");
        }
    }

    /* renamed from: com.shopee.app.web2.b.f.a$a  reason: collision with other inner class name */
    static final class C0414a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f26654a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.ui.sharing.base.data.a f26655b;

        C0414a(a aVar, com.shopee.app.ui.sharing.base.data.a aVar2) {
            this.f26654a = aVar;
            this.f26655b = aVar2;
        }

        public final void run() {
            this.f26654a.b(new ShareDataResponse(this.f26655b.a(), this.f26655b.b()));
        }
    }

    public void onResult(com.shopee.app.ui.sharing.base.data.a aVar) {
        j.b(aVar, "shareResult");
        UiThreadUtil.runOnUiThread(new C0414a(this, aVar));
    }

    public void b() {
        super.b();
        com.shopee.app.ui.sharing.base.a<?> aVar = this.f26653a;
        if (aVar != null) {
            aVar.c();
        }
    }
}
