package com.shopee.app.ui.auth.password;

import android.text.TextUtils;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.network.d.j;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.n;
import com.shopee.id.R;

public class b extends q<d> {

    /* renamed from: a  reason: collision with root package name */
    private final n f19593a;

    /* renamed from: c  reason: collision with root package name */
    private final i f19594c;

    /* renamed from: d  reason: collision with root package name */
    private e f19595d = new g() {
        public void onEvent(a aVar) {
            ((d) b.this.f19220b).e();
            ((d) b.this.f19220b).c();
        }
    };

    public b(n nVar) {
        this.f19593a = nVar;
        this.f19594c = com.garena.a.a.a.b.a(this);
    }

    public void a() {
        this.f19594c.a();
        this.f19593a.a("CHECK_PASSWORD_SUCCESS", this.f19595d);
    }

    public void b() {
        this.f19594c.b();
        this.f19593a.b("CHECK_PASSWORD_SUCCESS", this.f19595d);
    }

    public void a(String str) {
        ((d) this.f19220b).d();
        new j().a(str);
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
            } else if (i != 2) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
            } else {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_verify_password_incorrect_error);
            }
        }
        ((d) this.f19220b).e();
        ((d) this.f19220b).a(str);
    }
}
