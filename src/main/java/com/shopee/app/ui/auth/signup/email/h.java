package com.shopee.app.ui.auth.signup.email;

import android.text.TextUtils;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.d.c.eh;
import com.shopee.app.h.o;
import com.shopee.app.h.r;
import com.shopee.app.network.d.az;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.n;
import com.shopee.id.R;
import com.shopee.protocol.action.ResponseCommon;

public class h extends q<j> {

    /* renamed from: a  reason: collision with root package name */
    private final n f19856a;

    /* renamed from: c  reason: collision with root package name */
    private final eh f19857c;

    /* renamed from: d  reason: collision with root package name */
    private final i f19858d;

    /* renamed from: e  reason: collision with root package name */
    private e f19859e = new g() {
        public void onEvent(a aVar) {
            r.a().b((int) R.string.sp_unable_to_load_image);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private e f19860f = new g() {
        public void onEvent(a aVar) {
            ((j) h.this.f19220b).a(((ResponseCommon) aVar.data).userid.intValue(), "email");
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private e f19861g = new g() {
        public void onEvent(a aVar) {
            ((j) h.this.f19220b).setAvatar((String) aVar.data);
        }
    };

    public h(n nVar, eh ehVar) {
        this.f19856a = nVar;
        this.f19857c = ehVar;
        this.f19858d = b.a(this);
    }

    public void a() {
        this.f19858d.a();
        this.f19856a.a("REGISTER_SUCCESS", this.f19860f);
        this.f19856a.a("AVATAR_SELECTED", this.f19861g);
        this.f19856a.a("AVATAR_SELECTED_FAIL", this.f19859e);
    }

    public void b() {
        this.f19858d.b();
        this.f19856a.b("REGISTER_SUCCESS", this.f19860f);
        this.f19856a.b("AVATAR_SELECTED", this.f19861g);
        this.f19856a.b("AVATAR_SELECTED_FAIL", this.f19859e);
    }

    /* access modifiers changed from: package-private */
    public void a(com.shopee.app.network.c.d.a aVar) {
        String str;
        int i;
        ((j) this.f19220b).e();
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
            i = -1;
        } else {
            i = aVar.f17892a;
            if (i == -100) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
            } else if (i == 1) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_invalid_email_format);
            } else if (i == 5) {
                ((j) this.f19220b).f();
                return;
            } else if (i == 7) {
                ((j) this.f19220b).g();
                return;
            } else if (i != 11) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
            } else {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_duplicate_user_name);
            }
        }
        ((j) this.f19220b).b(i, str);
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        com.shopee.app.network.d.f.e eVar = new com.shopee.app.network.d.f.e(str, str2, str3, str4, str3, str5);
        o.a().a((az) eVar);
        eVar.g();
        ((j) this.f19220b).d();
    }

    public void a(String str) {
        this.f19857c.a(str);
    }
}
