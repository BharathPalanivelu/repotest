package com.shopee.app.ui.home.me.control;

import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.f;
import com.garena.android.appkit.b.g;
import com.shopee.app.d.c.bb;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.n;

public class a extends q<MeControlView> {

    /* renamed from: a  reason: collision with root package name */
    private final n f22288a;

    /* renamed from: c  reason: collision with root package name */
    private final bb f22289c;

    /* renamed from: d  reason: collision with root package name */
    private e f22290d = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            int[] iArr = (int[]) aVar.data;
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private e f22291e = new f() {
        public void a(com.garena.android.appkit.b.a aVar) {
            a.this.e();
        }
    };

    /* access modifiers changed from: private */
    public void e() {
    }

    public a(n nVar, bb bbVar) {
        this.f22288a = nVar;
        this.f22289c = bbVar;
    }

    public void a() {
        this.f22288a.a("ME_BADGE_LOAD", this.f22290d);
        this.f22288a.a("ORDER_UPDATE_NOTIFICATION", this.f22291e);
    }

    public void b() {
        this.f22288a.b("ME_BADGE_LOAD", this.f22290d);
        this.f22288a.b("ORDER_UPDATE_NOTIFICATION", this.f22291e);
    }
}
