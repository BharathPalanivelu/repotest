package com.shopee.app.util.k;

import android.util.Pair;
import com.shopee.app.data.store.ba;
import com.shopee.app.util.af;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public final ba f26412a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, Pair<g, f>> f26413b = new HashMap();

    public h(ba baVar) {
        this.f26412a = baVar;
    }

    public synchronized g a() {
        List<g> a2 = this.f26412a.a();
        if (af.a(a2)) {
            return null;
        }
        return a2.get(0);
    }

    public synchronized void a(g gVar, f fVar) {
        this.f26413b.put(gVar.requestId, new Pair(gVar, fVar));
    }

    public synchronized Pair<g, f> b() {
        g a2 = a();
        if (a2 == null) {
            return null;
        }
        return this.f26413b.get(a2.requestId);
    }

    public void a(g gVar) {
        this.f26413b.remove(gVar.requestId);
    }
}
