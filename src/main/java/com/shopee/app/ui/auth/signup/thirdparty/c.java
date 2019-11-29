package com.shopee.app.ui.auth.signup.thirdparty;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.shopee.app.d.c.dc;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.n;
import java.io.Serializable;

public abstract class c extends q<d> {

    /* renamed from: a  reason: collision with root package name */
    private final dc f19932a;

    /* renamed from: c  reason: collision with root package name */
    private final n f19933c;

    /* renamed from: d  reason: collision with root package name */
    private e f19934d = new g() {
        public void onEvent(a aVar) {
            ((d) c.this.f19220b).d((String) aVar.data);
        }
    };

    public void a(Serializable serializable) {
    }

    public abstract void a(String str);

    public abstract void a(String str, String str2, String str3, String str4);

    public abstract void e();

    public c(n nVar, dc dcVar) {
        this.f19932a = dcVar;
        this.f19933c = nVar;
    }

    public void a() {
        this.f19933c.a("IMAGE_PROCESSED", this.f19934d);
    }

    public void b() {
        this.f19933c.b("IMAGE_PROCESSED", this.f19934d);
    }

    public void b(String str) {
        this.f19932a.a(str);
    }
}
