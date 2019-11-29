package com.shopee.app.ui.auth;

import android.text.TextUtils;
import android.util.Pair;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.network.d.f.a;
import com.shopee.app.network.d.f.m;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.n;
import com.shopee.id.R;
import com.shopee.protocol.action.ResponseCommon;

public class p extends q<r> {

    /* renamed from: a  reason: collision with root package name */
    private final n f19578a;

    /* renamed from: c  reason: collision with root package name */
    private final i f19579c = b.a(this);

    /* renamed from: d  reason: collision with root package name */
    private a f19580d;

    /* renamed from: e  reason: collision with root package name */
    private String f19581e;

    /* renamed from: f  reason: collision with root package name */
    private m f19582f;

    public p(n nVar) {
        this.f19578a = nVar;
    }

    public void a() {
        this.f19579c.a();
    }

    public void c() {
        this.f19579c.c();
    }

    public void d() {
        this.f19579c.d();
    }

    public void b() {
        this.f19579c.b();
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        this.f19581e = str;
        ((r) this.f19220b).j();
        this.f19582f = new m(this.f19581e, "seed_signup", 1, true);
        this.f19582f.a("", false, false);
    }

    /* access modifiers changed from: package-private */
    public void e() {
        ((r) this.f19220b).j();
        this.f19582f = new m(this.f19581e, "seed_signup", 1, true);
        this.f19582f.a("", true, false);
    }

    /* access modifiers changed from: package-private */
    public void a(ResponseCommon responseCommon) {
        if (b(responseCommon)) {
            ((r) this.f19220b).k();
            ((r) this.f19220b).h();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(ResponseCommon responseCommon) {
        a aVar = this.f19580d;
        return aVar != null && aVar.i().a().equals(responseCommon.requestid);
    }

    /* access modifiers changed from: package-private */
    public void a(com.shopee.app.network.c.d.a aVar) {
        String str;
        if (b(aVar.f17894c)) {
            if (!TextUtils.isEmpty(aVar.f17893b)) {
                str = aVar.f17893b;
            } else {
                int i = aVar.f17892a;
                if (i == 4 || i == 16) {
                    ((r) this.f19220b).k();
                    a(this.f19581e);
                    return;
                } else if (i == -100) {
                    str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
                } else if (i != 1) {
                    str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
                } else {
                    str = com.garena.android.appkit.tools.b.e(R.string.sp_invalid_phone_format);
                }
            }
            ((r) this.f19220b).k();
            ((r) this.f19220b).a(str);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Pair<String, Boolean> pair) {
        m mVar = this.f19582f;
        if (mVar != null && mVar.i().a().equals(pair.first)) {
            ((r) this.f19220b).k();
            ((r) this.f19220b).a(((Boolean) pair.second).booleanValue());
        }
    }

    /* access modifiers changed from: package-private */
    public void b(com.shopee.app.network.c.d.a aVar) {
        String str;
        m mVar = this.f19582f;
        if (mVar != null && mVar.i().a().equals(aVar.f17894c.requestid)) {
            ((r) this.f19220b).k();
            if (!TextUtils.isEmpty(aVar.f17893b)) {
                str = aVar.f17893b;
            } else {
                int i = aVar.f17892a;
                if (i == -100) {
                    str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
                } else if (i == 1) {
                    ((r) this.f19220b).i();
                    return;
                } else if (i == 5) {
                    ((r) this.f19220b).h();
                    return;
                } else if (i != 38) {
                    str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
                } else {
                    ((r) this.f19220b).g();
                    return;
                }
            }
            ((r) this.f19220b).a(str);
        }
    }
}
