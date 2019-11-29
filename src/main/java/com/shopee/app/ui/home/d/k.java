package com.shopee.app.ui.home.d;

import com.facebook.internal.NativeProtocol;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.shopee.app.ui.home.c;
import com.shopee.app.ui.product.newsearch.SearchTabActivity_;
import com.shopee.app.util.bi;

public class k extends b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f22190a = false;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final c f22191b;

    /* renamed from: c  reason: collision with root package name */
    private final bi f22192c;

    /* renamed from: d  reason: collision with root package name */
    private e f22193d = new g() {
        public void onEvent(a aVar) {
            if (!((Boolean) aVar.data).booleanValue()) {
                k.f22190a = true;
                ((SearchTabActivity_.a) SearchTabActivity_.a(k.this.f22191b).k(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST)).a(10029);
            }
        }
    };

    public k(c cVar, bi biVar) {
        this.f22191b = cVar;
        this.f22192c = biVar;
    }

    public void a(String str, int i, int i2, String str2, int i3, int i4, String str3, String str4) {
        if (this.f22191b.p() == null) {
        }
    }

    public void c() {
        f22190a = false;
        this.f22192c.a("SEARCH", this.f22193d);
    }

    public void b() {
        this.f22192c.b("SEARCH", this.f22193d);
    }
}
