package com.shopee.app.web2.b.f;

import android.app.Activity;
import android.content.Context;
import com.facebook.react.bridge.UiThreadUtil;
import com.shopee.app.ui.sharing.d;
import com.shopee.web.sdk.bridge.protocol.sharing.ShowSharingPanelRequest;
import com.shopee.web.sdk.bridge.protocol.sharing.ShowSharingPanelResponse;
import d.d.b.j;
import d.d.b.k;
import d.d.b.m;
import d.d.b.n;
import d.d.b.p;
import d.f;
import d.f.e;

public final class b extends com.shopee.web.sdk.bridge.a.g.b implements d {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ e[] f26656a = {p.a((m) new n(p.a(b.class), "sharingPanel", "getSharingPanel()Lcom/shopee/app/ui/sharing/SharingPanel;"))};

    /* renamed from: b  reason: collision with root package name */
    private final d.e f26657b;

    private final com.shopee.app.ui.sharing.c i() {
        d.e eVar = this.f26657b;
        e eVar2 = f26656a[0];
        return (com.shopee.app.ui.sharing.c) eVar.a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        j.b(context, "context");
        this.f26657b = f.a(new c(context));
    }

    static final class c extends k implements d.d.a.a<com.shopee.app.ui.sharing.c> {
        final /* synthetic */ Context $context;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Context context) {
            super(0);
            this.$context = context;
        }

        /* renamed from: a */
        public final com.shopee.app.ui.sharing.c invoke() {
            Context context = this.$context;
            if (context != null) {
                return new com.shopee.app.ui.sharing.c((Activity) context);
            }
            throw new d.m("null cannot be cast to non-null type android.app.Activity");
        }
    }

    /* access modifiers changed from: protected */
    public void a(ShowSharingPanelRequest showSharingPanelRequest) {
        if (showSharingPanelRequest != null) {
            i().a(showSharingPanelRequest.getTitle(), showSharingPanelRequest.getSubTitle(), Boolean.valueOf(showSharingPanelRequest.isAutoDismissForUnavailablePlatform()), showSharingPanelRequest.getSharingAppIDsTop(), showSharingPanelRequest.getSharingAppIDsBottom(), this);
        }
    }

    /* renamed from: com.shopee.app.web2.b.f.b$b  reason: collision with other inner class name */
    static final class C0415b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f26659a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f26660b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f26661c;

        C0415b(b bVar, String str, boolean z) {
            this.f26659a = bVar;
            this.f26660b = str;
            this.f26661c = z;
        }

        public final void run() {
            this.f26659a.b(new ShowSharingPanelResponse(1, this.f26660b, this.f26661c));
        }
    }

    public void onSelectApp(String str, boolean z) {
        j.b(str, "appId");
        UiThreadUtil.runOnUiThread(new C0415b(this, str, z));
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f26658a;

        a(b bVar) {
            this.f26658a = bVar;
        }

        public final void run() {
            this.f26658a.b(new ShowSharingPanelResponse(0));
        }
    }

    public void onDismiss() {
        UiThreadUtil.runOnUiThread(new a(this));
    }
}
