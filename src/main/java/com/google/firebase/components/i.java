package com.google.firebase.components;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.a.c;
import com.google.firebase.a.d;
import com.google.firebase.b.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

public class i extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final a<Set<Object>> f6858a = l.b();

    /* renamed from: b  reason: collision with root package name */
    private final Map<b<?>, s<?>> f6859b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, s<?>> f6860c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<?>, s<Set<?>>> f6861d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final q f6862e;

    public /* bridge */ /* synthetic */ Object a(Class cls) {
        return super.a(cls);
    }

    public /* bridge */ /* synthetic */ Set b(Class cls) {
        return super.b(cls);
    }

    public i(Executor executor, Iterable<h> iterable, b<?>... bVarArr) {
        this.f6862e = new q(executor);
        ArrayList<b> arrayList = new ArrayList<>();
        arrayList.add(b.a(this.f6862e, q.class, d.class, c.class));
        for (h components : iterable) {
            arrayList.addAll(components.getComponents());
        }
        Collections.addAll(arrayList, bVarArr);
        m.a((List<b<?>>) arrayList);
        for (b bVar : arrayList) {
            this.f6859b.put(bVar, new s(j.a(this, bVar)));
        }
        a();
        b();
    }

    private void a() {
        for (Map.Entry next : this.f6859b.entrySet()) {
            b bVar = (b) next.getKey();
            if (bVar.g()) {
                s sVar = (s) next.getValue();
                for (Class put : bVar.a()) {
                    this.f6860c.put(put, sVar);
                }
            }
        }
        c();
    }

    private void b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f6859b.entrySet()) {
            b bVar = (b) next.getKey();
            if (!bVar.g()) {
                s sVar = (s) next.getValue();
                for (Class cls : bVar.a()) {
                    if (!hashMap.containsKey(cls)) {
                        hashMap.put(cls, new HashSet());
                    }
                    ((Set) hashMap.get(cls)).add(sVar);
                }
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            this.f6861d.put((Class) entry.getKey(), new s(k.a((Set) entry.getValue())));
        }
    }

    static /* synthetic */ Set a(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(((s) it.next()).a());
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public <T> a<T> c(Class<T> cls) {
        Preconditions.checkNotNull(cls, "Null interface requested.");
        return this.f6860c.get(cls);
    }

    public <T> a<Set<T>> d(Class<T> cls) {
        s sVar = this.f6861d.get(cls);
        if (sVar != null) {
            return sVar;
        }
        return f6858a;
    }

    public void a(boolean z) {
        for (Map.Entry next : this.f6859b.entrySet()) {
            b bVar = (b) next.getKey();
            s sVar = (s) next.getValue();
            if (bVar.e() || (bVar.f() && z)) {
                sVar.a();
            }
        }
        this.f6862e.a();
    }

    private void c() {
        for (b next : this.f6859b.keySet()) {
            Iterator<n> it = next.b().iterator();
            while (true) {
                if (it.hasNext()) {
                    n next2 = it.next();
                    if (next2.b() && !this.f6860c.containsKey(next2.a())) {
                        throw new t(String.format("Unsatisfied dependency for component %s: %s", new Object[]{next, next2.a()}));
                    }
                }
            }
        }
    }
}
