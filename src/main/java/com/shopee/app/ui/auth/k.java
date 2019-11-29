package com.shopee.app.ui.auth;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.h.r;
import com.shopee.app.line.LineAuthProxyActivity;
import com.shopee.app.network.d.f.g;
import com.shopee.app.util.ak;
import com.shopee.app.util.n;
import com.shopee.id.R;
import com.shopee.protocol.action.ResponseCommon;
import d.d.b.j;
import d.m;
import d.q;
import java.io.Serializable;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    private final i f19547a;

    /* renamed from: b  reason: collision with root package name */
    private com.shopee.app.line.a f19548b;

    /* renamed from: c  reason: collision with root package name */
    private String f19549c;

    /* renamed from: d  reason: collision with root package name */
    private a f19550d = a.login;

    /* renamed from: e  reason: collision with root package name */
    private final Activity f19551e;

    /* renamed from: f  reason: collision with root package name */
    private final n f19552f;

    /* renamed from: g  reason: collision with root package name */
    private final ak f19553g;

    private enum a {
        login,
        register
    }

    public k(Activity activity, n nVar, ak akVar) {
        j.b(activity, "activity");
        j.b(nVar, "eventBus");
        j.b(akVar, "navigator");
        this.f19551e = activity;
        this.f19552f = nVar;
        this.f19553g = akVar;
        i a2 = b.a(this);
        j.a((Object) a2, "EventHandler.get(this)");
        this.f19547a = a2;
    }

    public final void a() {
        this.f19550d = a.login;
        LineAuthProxyActivity.f17768a.a(this.f19551e);
    }

    public final void b() {
        this.f19550d = a.register;
        LineAuthProxyActivity.f17768a.a(this.f19551e);
    }

    public final void c() {
        this.f19547a.a();
    }

    public final void d() {
        this.f19547a.b();
    }

    public final void e() {
        com.shopee.app.line.a aVar = this.f19548b;
        if (aVar != null) {
            this.f19553g.a(aVar);
        } else {
            r.a().a(com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error));
        }
    }

    public final void a(ResponseCommon responseCommon) {
        j.b(responseCommon, "response");
        if (!(!j.a((Object) responseCommon.requestid, (Object) this.f19549c))) {
            boolean z = this.f19551e instanceof b;
            if (!q.f32715a || z) {
                Activity activity = this.f19551e;
                if (activity != null) {
                    ((b) activity).a("line");
                    return;
                }
                throw new m("null cannot be cast to non-null type com.shopee.app.ui.auth.AuthTabActivity");
            }
            throw new AssertionError("Assertion failed");
        }
    }

    public final void a(com.shopee.app.network.c.d.a aVar) {
        j.b(aVar, "response");
        if (!(!j.a((Object) aVar.f17894c.requestid, (Object) this.f19549c))) {
            int i = aVar.f17892a;
            if (i == 9) {
                com.shopee.app.ui.dialog.a.a((Context) this.f19551e, this.f19553g);
            } else if (i != 12) {
                f();
            } else {
                r.a().a(com.garena.android.appkit.tools.b.e(R.string.sp_line_login_error_country_restricted));
            }
        }
    }

    public final void b(com.shopee.app.network.c.d.a aVar) {
        j.b(aVar, "response");
        if (!(!j.a((Object) aVar.f17894c.requestid, (Object) this.f19549c))) {
            if (aVar.f17892a == -100) {
                r.a().a(com.garena.android.appkit.tools.b.e(R.string.sp_network_error));
            } else {
                r.a().a(com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error));
            }
        }
    }

    public final void a(com.shopee.app.line.a aVar) {
        j.b(aVar, "lineAuthData");
        this.f19548b = aVar;
        b(aVar);
    }

    public final void f() {
        r.a().a(com.garena.android.appkit.tools.b.e(R.string.sp_label_line_login_error));
    }

    private final void b(com.shopee.app.line.a aVar) {
        g gVar = new g();
        gVar.a(aVar.a());
        gVar.g();
        this.f19549c = gVar.i().a();
    }

    public final Parcelable a(Parcelable parcelable) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("connectTarget", this.f19550d);
        bundle.putString("requestId", this.f19549c);
        bundle.putParcelable("outState", parcelable);
        return bundle;
    }

    public final Parcelable b(Parcelable parcelable) {
        j.b(parcelable, "parcelable");
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            if (bundle.containsKey("connectTarget")) {
                Serializable serializable = bundle.getSerializable("connectTarget");
                if (serializable != null) {
                    this.f19550d = (a) serializable;
                    this.f19549c = bundle.getString("requestId");
                    Parcelable parcelable2 = bundle.getParcelable("outState");
                    j.a((Object) parcelable2, "parcelable.getParcelable(\"outState\")");
                    return parcelable2;
                }
                throw new m("null cannot be cast to non-null type com.shopee.app.ui.auth.LineAuthHelper.Target");
            }
        }
        return parcelable;
    }
}
