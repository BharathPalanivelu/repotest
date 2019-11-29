package com.shopee.app.ui.auth.signup.email;

import android.text.TextUtils;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.d.c.eh;
import com.shopee.app.h.r;
import com.shopee.app.network.d.f.c;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.n;
import com.shopee.id.R;

public class b extends q<d> {

    /* renamed from: a  reason: collision with root package name */
    private final n f19829a;

    /* renamed from: c  reason: collision with root package name */
    private final eh f19830c;

    /* renamed from: d  reason: collision with root package name */
    private final i f19831d;

    /* renamed from: e  reason: collision with root package name */
    private e f19832e = new g() {
        public void onEvent(a aVar) {
            r.a().b((int) R.string.sp_unable_to_load_image);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private e f19833f = new g() {
        public void onEvent(a aVar) {
            ((d) b.this.f19220b).d();
        }
    };

    public b(n nVar, eh ehVar) {
        this.f19829a = nVar;
        this.f19830c = ehVar;
        this.f19831d = com.garena.a.a.a.b.a(this);
    }

    /* access modifiers changed from: package-private */
    public void a(String str, String str2, String str3) {
        ((d) this.f19220b).c();
        new c(str, str2, str3).g();
    }

    public void a() {
        this.f19831d.a();
        this.f19829a.a("REGISTER_SUCCESS", this.f19833f);
        this.f19829a.a("AVATAR_SELECTED_FAIL", this.f19832e);
    }

    public void b() {
        this.f19831d.b();
        this.f19829a.b("REGISTER_SUCCESS", this.f19833f);
        this.f19829a.b("AVATAR_SELECTED_FAIL", this.f19832e);
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        ((d) this.f19220b).d();
        ((d) this.f19220b).a(str);
    }

    /* access modifiers changed from: package-private */
    public void a(com.shopee.app.network.c.d.a aVar) {
        String str;
        int i;
        ((d) this.f19220b).d();
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
            i = -1;
        } else {
            i = aVar.f17892a;
            if (i == -100) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
            } else if (i == 5) {
                ((d) this.f19220b).g();
                return;
            } else if (i == 11) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_duplicate_user_name);
            } else if (i == 1) {
                ((d) this.f19220b).e();
                return;
            } else if (i != 2) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
            } else {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_captcha_error_wrong);
            }
        }
        ((d) this.f19220b).a(i, str);
    }
}
