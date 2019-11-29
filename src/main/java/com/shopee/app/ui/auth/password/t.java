package com.shopee.app.ui.auth.password;

import android.text.TextUtils;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.network.d.bd;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.n;
import com.shopee.id.R;
import com.shopee.protocol.action.ResponseCommon;

public class t extends q<v> {

    /* renamed from: a  reason: collision with root package name */
    private final n f19656a;

    /* renamed from: c  reason: collision with root package name */
    private final i f19657c;

    /* renamed from: d  reason: collision with root package name */
    private e f19658d = new g() {
        public void onEvent(a aVar) {
            ((v) t.this.f19220b).a((ResponseCommon) aVar.data);
        }
    };

    public t(n nVar) {
        this.f19656a = nVar;
        this.f19657c = b.a(this);
    }

    public void a() {
        this.f19657c.a();
        this.f19656a.a("BIND_ACCOUNT_SUCCESS", this.f19658d);
        this.f19656a.a("RESET_PASSWORD_SUCCESS", this.f19658d);
    }

    public void b() {
        this.f19657c.b();
        this.f19656a.b("BIND_ACCOUNT_SUCCESS", this.f19658d);
        this.f19656a.b("RESET_PASSWORD_SUCCESS", this.f19658d);
    }

    /* access modifiers changed from: package-private */
    public void a(com.shopee.app.network.c.d.a aVar) {
        String str;
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else {
            int i = aVar.f17892a;
            if (i == -100) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
            } else if (i != 5) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
            } else {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_server_error);
            }
        }
        ((v) this.f19220b).a(str);
        ((v) this.f19220b).d();
    }

    public void a(String str, String str2, String str3, String str4) {
        new bd().a(str, str2, str3, str4);
        ((v) this.f19220b).c();
    }

    public void b(String str, String str2, String str3, String str4) {
        new bd().a(str, str2, str3, str4);
        ((v) this.f19220b).c();
    }
}
