package com.garena.pay.android.d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class d {

    /* renamed from: a  reason: collision with root package name */
    Map<String, g> f8211a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    Map<String, e> f8212b = new HashMap();

    d() {
    }

    public e a(String str) {
        return this.f8212b.get(str);
    }

    public List<String> a() {
        return new ArrayList(this.f8212b.keySet());
    }

    /* access modifiers changed from: package-private */
    public List<String> b(String str) {
        ArrayList arrayList = new ArrayList();
        for (e next : this.f8212b.values()) {
            if (next.a().equals(str)) {
                arrayList.add(next.c());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public void a(g gVar) {
        this.f8211a.put(gVar.a(), gVar);
    }

    /* access modifiers changed from: package-private */
    public void a(e eVar) {
        this.f8212b.put(eVar.c(), eVar);
    }
}
