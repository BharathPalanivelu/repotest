package com.shopee.app.ui.auth.signup.phone;

import android.text.TextUtils;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.d.c.eh;
import com.shopee.app.h.o;
import com.shopee.app.h.r;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.f.k;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.n;
import com.shopee.id.R;
import com.shopee.protocol.action.ResponseCommon;

public class b extends q<d> {

    /* renamed from: a  reason: collision with root package name */
    private final n f19895a;

    /* renamed from: c  reason: collision with root package name */
    private final eh f19896c;

    /* renamed from: d  reason: collision with root package name */
    private final i f19897d;

    /* renamed from: e  reason: collision with root package name */
    private e f19898e = new g() {
        public void onEvent(a aVar) {
            r.a().b((int) R.string.sp_unable_to_load_image);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private e f19899f = new g() {
        public void onEvent(a aVar) {
            ((d) b.this.f19220b).b(((ResponseCommon) aVar.data).userid.intValue(), "phone");
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private e f19900g = new g() {
        public void onEvent(a aVar) {
            ((d) b.this.f19220b).setAvatar((String) aVar.data);
        }
    };

    public b(n nVar, eh ehVar) {
        this.f19895a = nVar;
        this.f19896c = ehVar;
        this.f19897d = com.garena.a.a.a.b.a(this);
    }

    public void a() {
        this.f19897d.a();
        this.f19895a.a("REGISTER_SUCCESS", this.f19899f);
        this.f19895a.a("AVATAR_SELECTED", this.f19900g);
        this.f19895a.a("AVATAR_SELECTED_FAIL", this.f19898e);
    }

    public void b() {
        this.f19897d.b();
        this.f19895a.b("REGISTER_SUCCESS", this.f19899f);
        this.f19895a.b("AVATAR_SELECTED", this.f19900g);
        this.f19895a.b("AVATAR_SELECTED_FAIL", this.f19898e);
    }

    /* access modifiers changed from: package-private */
    public void a(com.shopee.app.network.c.d.a aVar) {
        String str;
        int i;
        ((d) this.f19220b).f();
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
            i = -1;
        } else {
            i = aVar.f17892a;
            if (i == -100) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
            } else if (i == 1) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_error_user_name_format);
            } else if (i == 5) {
                ((d) this.f19220b).g();
                return;
            } else if (i != 11) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
            } else {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_duplicate_user_name);
            }
        }
        ((d) this.f19220b).a(i, str);
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        k kVar = new k(str, str4, str3, str2, str5, str2);
        o.a().a((az) kVar);
        kVar.g();
        ((d) this.f19220b).e();
    }

    public void a(String str) {
        this.f19896c.a(str);
    }
}
