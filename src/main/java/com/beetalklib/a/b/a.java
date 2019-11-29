package com.beetalklib.a.b;

import com.android.b.d;
import com.android.b.i;
import com.android.b.l;
import com.android.b.n;

public class a extends l<com.beetalklib.a.a.a> {

    /* renamed from: a  reason: collision with root package name */
    private n.b<com.beetalklib.a.a.a> f5483a;

    public a(int i, String str, n.b<com.beetalklib.a.a.a> bVar, n.a aVar) {
        super(i, str, aVar);
        this.f5483a = bVar;
        setRetryPolicy(new d(2500, 2, 1.0f));
    }

    /* access modifiers changed from: protected */
    public n<com.beetalklib.a.a.a> parseNetworkResponse(i iVar) {
        return n.a(new com.beetalklib.a.a.a(iVar.f4613b), getCacheEntry());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void deliverResponse(com.beetalklib.a.a.a aVar) {
        this.f5483a.onResponse(aVar);
    }
}
