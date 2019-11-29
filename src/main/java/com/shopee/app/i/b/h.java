package com.shopee.app.i.b;

import android.app.Activity;
import com.google.a.o;
import com.shopee.app.ui.sharing.base.a;
import com.shopee.app.ui.sharing.d;
import com.shopee.sdk.modules.ui.d.b;
import com.shopee.sdk.modules.ui.d.c;

public class h implements b {

    /* renamed from: a  reason: collision with root package name */
    private a f17724a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public com.shopee.sdk.f.b<Integer> f17725b;

    /* renamed from: c  reason: collision with root package name */
    private com.shopee.app.ui.sharing.base.b f17726c = new com.shopee.app.ui.sharing.base.b() {
        public void onPreProcessingData() {
        }

        public void onResult(com.shopee.app.ui.sharing.base.data.a aVar) {
            if (h.this.f17725b != null) {
                if (aVar.a() == 0) {
                    h.this.f17725b.b(0);
                } else {
                    h.this.f17725b.b(aVar.a(), aVar.b());
                }
                com.shopee.sdk.f.b unused = h.this.f17725b = null;
            }
        }
    };

    public void a(Activity activity, c cVar, final com.shopee.sdk.f.b<o> bVar) {
        try {
            new com.shopee.app.ui.sharing.c(activity).a(cVar.a(), cVar.b(), Boolean.valueOf(cVar.c()), cVar.d(), cVar.e(), new d() {
                public void onSelectApp(String str, boolean z) {
                    o oVar = new o();
                    oVar.a("status", (Number) 1);
                    oVar.a("sharingAppID", str);
                    oVar.a("isAppAvailable", Boolean.valueOf(z));
                    bVar.b(oVar);
                }

                public void onDismiss() {
                    o oVar = new o();
                    oVar.a("status", (Number) 0);
                    bVar.b(oVar);
                }
            });
        } catch (Exception e2) {
            bVar.b(-1, e2.toString());
        }
    }

    public void a(Activity activity, com.shopee.sdk.modules.ui.d.a aVar, com.shopee.sdk.f.b<Integer> bVar) {
        try {
            if (this.f17724a != null) {
                this.f17724a.c();
            }
            this.f17725b = bVar;
            this.f17724a = com.shopee.app.ui.sharing.b.a(activity, aVar.a(), aVar.b() != null ? aVar.b().toString() : "", this.f17726c);
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            bVar.b(-1, e2.toString());
            this.f17725b = null;
        }
    }
}
