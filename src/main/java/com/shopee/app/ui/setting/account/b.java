package com.shopee.app.ui.setting.account;

import android.text.TextUtils;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.network.d.d;
import com.shopee.app.network.d.f.a;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.n;
import com.shopee.id.R;
import com.shopee.protocol.action.ResponseCommon;

public class b extends q<d> {

    /* renamed from: a  reason: collision with root package name */
    a f25157a;

    /* renamed from: c  reason: collision with root package name */
    private final n f25158c;

    /* renamed from: d  reason: collision with root package name */
    private final i f25159d;

    /* renamed from: e  reason: collision with root package name */
    private e f25160e = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((d) b.this.f19220b).e();
            ((d) b.this.f19220b).g();
        }
    };

    public b(n nVar) {
        this.f25158c = nVar;
        this.f25159d = com.garena.a.a.a.b.a(this);
    }

    public void a() {
        this.f25159d.a();
        this.f25158c.a("BIND_ACCOUNT_SUCCESS", this.f25160e);
    }

    public void b() {
        this.f25159d.b();
        this.f25158c.b("BIND_ACCOUNT_SUCCESS", this.f25160e);
    }

    public void a(String str) {
        ((d) this.f19220b).d();
        this.f25157a = new a();
        this.f25157a.b(str);
    }

    /* access modifiers changed from: package-private */
    public void a(ResponseCommon responseCommon) {
        if (b(responseCommon)) {
            ((d) this.f19220b).e();
            ((d) this.f19220b).f();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(ResponseCommon responseCommon) {
        a aVar = this.f25157a;
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
                if (i == 4) {
                    ((d) this.f19220b).b();
                    return;
                } else if (i == -100) {
                    str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
                } else if (i != 1) {
                    str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
                } else {
                    str = com.garena.android.appkit.tools.b.e(R.string.sp_invalid_email_format);
                }
            }
            ((d) this.f19220b).e();
            ((d) this.f19220b).a(str);
        }
    }

    public void b(String str) {
        new d().a(str);
    }

    /* access modifiers changed from: package-private */
    public void b(com.shopee.app.network.c.d.a aVar) {
        String str;
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else {
            int i = aVar.f17892a;
            if (i == -100) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
            } else if (i != 1) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
            } else {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_invalid_email_format);
            }
        }
        ((d) this.f19220b).e();
        ((d) this.f19220b).a(str);
    }
}
