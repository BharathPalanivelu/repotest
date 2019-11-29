package com.shopee.app.ui.auth.signup.a;

import android.text.TextUtils;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.d.c.ao;
import com.shopee.app.d.c.dc;
import com.shopee.app.d.c.o;
import com.shopee.app.h.f;
import com.shopee.app.ui.auth.signup.thirdparty.c;
import com.shopee.app.ui.auth.signup.thirdparty.d;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import com.shopee.id.R;
import com.shopee.protocol.action.ResponseCommon;

public class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private final n f19791a;

    /* renamed from: c  reason: collision with root package name */
    private final bi f19792c;

    /* renamed from: d  reason: collision with root package name */
    private final o f19793d;

    /* renamed from: e  reason: collision with root package name */
    private final ao f19794e;

    /* renamed from: f  reason: collision with root package name */
    private final dc f19795f;

    /* renamed from: g  reason: collision with root package name */
    private final i f19796g;
    private e h = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            final com.shopee.app.h.c.a aVar2 = (com.shopee.app.h.c.a) aVar;
            ((d) a.this.f19220b).a(aVar2.f17639b, aVar2.f17641d, aVar2.f17642e, aVar2.f17643f);
            com.shopee.app.h.b.a.a().a(aVar2.f17638a, aVar2.f17640c, new Runnable() {
                public void run() {
                    a.this.b("file:///" + f.a().b(aVar2.f17640c));
                }
            });
        }
    };
    private e i = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((d) a.this.f19220b).a(((ResponseCommon) aVar.data).userid.intValue(), "facebook");
        }
    };
    private e j = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((d) a.this.f19220b).setCoverId((String) aVar.data);
        }
    };

    public a(n nVar, bi biVar, o oVar, ao aoVar, dc dcVar) {
        super(nVar, dcVar);
        this.f19791a = nVar;
        this.f19792c = biVar;
        this.f19794e = aoVar;
        this.f19793d = oVar;
        this.f19795f = dcVar;
        this.f19796g = b.a(this);
    }

    public void d() {
        this.f19792c.b("FACEBOOK_ME_INFO", this.h);
    }

    public void c() {
        this.f19792c.a("FACEBOOK_ME_INFO", this.h);
    }

    public void a() {
        super.a();
        this.f19796g.a();
        this.f19791a.a("FACEBOOK_LOGIN_SUCCESS", this.i);
        this.f19791a.a("FACEBOOK_COVER_GRABBED", this.j);
    }

    public void b() {
        super.b();
        this.f19796g.b();
        this.f19791a.b("FACEBOOK_LOGIN_SUCCESS", this.i);
        this.f19791a.b("FACEBOOK_COVER_GRABBED", this.j);
    }

    public void a(String str) {
        this.f19794e.a();
    }

    public void b(String str) {
        this.f19795f.a(str);
    }

    /* access modifiers changed from: package-private */
    public void a(com.shopee.app.network.c.d.a aVar) {
        String str;
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else {
            str = aVar.f17892a != 11 ? com.garena.android.appkit.tools.b.e(R.string.sp_facebook_error) : null;
        }
        if (!TextUtils.isEmpty(str)) {
            ((d) this.f19220b).b(str);
        }
    }

    public void e() {
        this.f19793d.a(com.shopee.app.f.a.a().d());
    }

    public void a(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(com.shopee.app.f.a.a().d())) {
            com.shopee.app.network.d.f.f fVar = new com.shopee.app.network.d.f.f(com.shopee.app.f.a.a().d(), str);
            if (!TextUtils.isEmpty(str2)) {
                fVar.b(str2);
            }
            if (!TextUtils.isEmpty(str4)) {
                fVar.c(str4);
            }
            if (!TextUtils.isEmpty(str3)) {
                fVar.d(str3);
            }
            fVar.g();
            return;
        }
        ((d) this.f19220b).c(com.garena.android.appkit.tools.b.e(R.string.sp_facebook_token_error));
    }
}
