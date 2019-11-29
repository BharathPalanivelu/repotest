package com.shopee.app.util.q;

import com.facebook.react.uimanager.events.TouchesHelper;
import com.shopee.app.util.q.d;
import com.shopee.app.util.q.e;
import d.d.b.j;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private final Map<e.C0408e, f> f26483a = new LinkedHashMap();

    /* renamed from: b  reason: collision with root package name */
    private final c f26484b;

    /* access modifiers changed from: protected */
    public abstract List<e.C0408e> a();

    public a(c cVar) {
        j.b(cVar, "messageSupplier");
        this.f26484b = cVar;
    }

    public final void a(List<? extends f> list) {
        j.b(list, "validators");
        for (f fVar : list) {
            this.f26483a.put(fVar.a(), fVar);
        }
    }

    public final g a(e.C0408e eVar) {
        j.b(eVar, "targetType");
        if (!this.f26483a.containsKey(eVar)) {
            return null;
        }
        f fVar = this.f26483a.get(eVar);
        if (fVar == null) {
            j.a();
        }
        return fVar.b();
    }

    public static /* synthetic */ d a(a aVar, e eVar, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            return aVar.a(eVar, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: validate");
    }

    public final d a(e eVar, boolean z) {
        j.b(eVar, TouchesHelper.TARGET_KEY);
        if (!this.f26483a.containsKey(eVar.a())) {
            return d.b.f26486a;
        }
        f fVar = this.f26483a.get(eVar.a());
        if (fVar == null) {
            j.a();
        }
        return fVar.b(eVar, this.f26484b, z);
    }
}
