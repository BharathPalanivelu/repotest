package com.shopee.app.ui.auth;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.tools.b;
import com.shopee.app.h.r;
import com.shopee.app.network.d.f.f;
import com.shopee.app.util.ak;
import com.shopee.app.util.n;
import com.shopee.id.R;
import com.shopee.protocol.action.ResponseCommon;

public class g {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static com.shopee.app.network.g f19525d;

    /* renamed from: a  reason: collision with root package name */
    private final n f19526a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ak f19527b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Activity f19528c;

    /* renamed from: e  reason: collision with root package name */
    private e f19529e = new com.garena.android.appkit.b.g() {
        public void onEvent(a aVar) {
            ResponseCommon responseCommon = ((com.shopee.app.network.c.d.a) aVar.data).f17894c;
            if (responseCommon.requestid.equals(g.f19525d.a())) {
                if (responseCommon.errcode.intValue() == 9) {
                    com.shopee.app.ui.dialog.a.a((Context) g.this.f19528c, g.this.f19527b);
                } else {
                    r.a().a(b.e(R.string.sp_facebook_error));
                }
            }
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private e f19530f = new com.garena.android.appkit.b.g() {
        public void onEvent(a aVar) {
            if (((ResponseCommon) aVar.data).requestid.equals(g.f19525d.a())) {
                g.this.f19527b.c();
            }
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private e f19531g = new com.garena.android.appkit.b.g() {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ boolean f19534a = (!g.class.desiredAssertionStatus());

        public void onEvent(a aVar) {
            if (((ResponseCommon) aVar.data).requestid.equals(g.f19525d.a())) {
                if (f19534a || (g.this.f19528c instanceof b)) {
                    ((b) g.this.f19528c).a("facebook");
                    return;
                }
                throw new AssertionError();
            }
        }
    };

    public g(n nVar, ak akVar, Activity activity) {
        this.f19526a = nVar;
        this.f19527b = akVar;
        this.f19528c = activity;
    }

    public Parcelable a(Parcelable parcelable) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", parcelable);
        com.shopee.app.network.g gVar = f19525d;
        if (gVar != null) {
            bundle.putString("fbRequestID", gVar.a());
        }
        return bundle;
    }

    public Parcelable b(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            return parcelable;
        }
        Bundle bundle = (Bundle) parcelable;
        if (bundle.containsKey("fbRequestID")) {
            f19525d = new com.shopee.app.network.g(bundle.getString("fbRequestID"));
        }
        return bundle.getParcelable("superState");
    }

    public void a() {
        this.f19526a.a("FACEBOOK_LOGIN_FAIL", this.f19529e);
        this.f19526a.a("FACEBOOK_LOGIN_SUCCESS", this.f19531g);
        this.f19526a.a("FACEBOOK_LOGIN_REGISTER", this.f19530f);
    }

    public void b() {
        this.f19526a.b("FACEBOOK_LOGIN_FAIL", this.f19529e);
        this.f19526a.b("FACEBOOK_LOGIN_REGISTER", this.f19530f);
        this.f19526a.b("FACEBOOK_LOGIN_SUCCESS", this.f19531g);
    }

    public void c() {
        f fVar = new f();
        f19525d = new com.shopee.app.network.g(fVar.i().a());
        fVar.a(com.shopee.app.f.a.a().d());
        fVar.g();
    }
}
