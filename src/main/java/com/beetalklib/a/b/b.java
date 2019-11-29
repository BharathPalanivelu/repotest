package com.beetalklib.a.b;

import com.android.b.a.f;
import com.android.b.a.g;
import com.android.b.a.j;
import com.android.b.h;
import com.android.b.m;
import com.android.b.n;
import com.android.b.q;
import com.android.b.r;
import com.android.b.s;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f5484a;

    /* renamed from: b  reason: collision with root package name */
    private final f f5485b = new g();

    /* renamed from: c  reason: collision with root package name */
    private m f5486c = new m(new j(), new com.android.b.a.a(this.f5485b), 6);

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f5484a == null) {
                f5484a = new b();
            }
            bVar = f5484a;
        }
        return bVar;
    }

    private b() {
        this.f5486c.a();
    }

    private static class a implements n.a, n.b<com.beetalklib.a.a.a> {

        /* renamed from: a  reason: collision with root package name */
        private com.beetalklib.a.a.b f5487a;

        public a(com.beetalklib.a.a.b bVar) {
            this.f5487a = bVar;
        }

        /* renamed from: a */
        public void onResponse(com.beetalklib.a.a.a aVar) {
            if (aVar == null || aVar.a() == null || aVar.a().length <= 0) {
                this.f5487a.onError(500);
            } else {
                this.f5487a.onFinish(aVar.a(), aVar.a().length);
            }
        }

        public void onErrorResponse(s sVar) {
            com.beetalklib.a.a.b bVar = this.f5487a;
            if (bVar == null) {
                return;
            }
            if (sVar == null) {
                bVar.onError(1000);
            } else if (sVar instanceof com.android.b.j) {
                bVar.onError(1001);
            } else if (sVar instanceof r) {
                bVar.onError(1002);
            } else if (!(sVar instanceof h) && !(sVar instanceof q)) {
                bVar.onError(1000);
            } else if (sVar.networkResponse != null) {
                this.f5487a.onError(sVar.networkResponse.f4612a);
            } else {
                this.f5487a.onError(1000);
            }
        }
    }

    public synchronized int a(String str, com.beetalklib.a.a.b bVar) {
        a aVar = new a(bVar);
        a aVar2 = new a(0, str, aVar, aVar);
        aVar2.setShouldCache(false);
        this.f5486c.a(aVar2);
        return 1;
    }
}
