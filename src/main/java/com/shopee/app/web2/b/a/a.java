package com.shopee.app.web2.b.a;

import android.content.Context;
import com.shopee.web.sdk.bridge.protocol.configurepage.ConfigurePageRequest;
import d.d.b.j;
import d.m;

public final class a extends com.shopee.web.sdk.bridge.a.a.a {
    public String a() {
        return "configurePage";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        j.b(context, "context");
    }

    /* access modifiers changed from: protected */
    public void a(ConfigurePageRequest configurePageRequest) {
        if (configurePageRequest != null && (f() instanceof com.shopee.app.web2.a)) {
            Context f2 = f();
            if (f2 != null) {
                com.shopee.app.web2.a aVar = (com.shopee.app.web2.a) f2;
                ConfigurePageRequest.ConfigMessage config = configurePageRequest.getConfig();
                if (config != null) {
                    aVar.runOnUiThread(new C0412a(config, aVar));
                }
                ConfigurePageRequest.NavbarMessage navbar = configurePageRequest.getNavbar();
                if (navbar != null) {
                    aVar.runOnUiThread(new b(navbar, aVar));
                    return;
                }
                return;
            }
            throw new m("null cannot be cast to non-null type com.shopee.app.web2.WebPageActivity2");
        }
    }

    /* renamed from: com.shopee.app.web2.b.a.a$a  reason: collision with other inner class name */
    static final class C0412a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ConfigurePageRequest.ConfigMessage f26639a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.web2.a f26640b;

        C0412a(ConfigurePageRequest.ConfigMessage configMessage, com.shopee.app.web2.a aVar) {
            this.f26639a = configMessage;
            this.f26640b = aVar;
        }

        public final void run() {
            this.f26640b.a(this.f26639a);
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ConfigurePageRequest.NavbarMessage f26641a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.web2.a f26642b;

        b(ConfigurePageRequest.NavbarMessage navbarMessage, com.shopee.app.web2.a aVar) {
            this.f26641a = navbarMessage;
            this.f26642b = aVar;
        }

        public final void run() {
            this.f26642b.a(com.shopee.web.sdk.bridge.internal.a.f30470a.b((Object) this.f26641a));
        }
    }
}
