package com.google.firebase.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class m {

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Class<?> f6870a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final boolean f6871b;

        private b(Class<?> cls, boolean z) {
            this.f6870a = cls;
            this.f6871b = z;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!bVar.f6870a.equals(this.f6870a) || bVar.f6871b != this.f6871b) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return ((this.f6870a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f6871b).hashCode();
        }
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private final b<?> f6867a;

        /* renamed from: b  reason: collision with root package name */
        private final Set<a> f6868b = new HashSet();

        /* renamed from: c  reason: collision with root package name */
        private final Set<a> f6869c = new HashSet();

        a(b<?> bVar) {
            this.f6867a = bVar;
        }

        /* access modifiers changed from: package-private */
        public void a(a aVar) {
            this.f6868b.add(aVar);
        }

        /* access modifiers changed from: package-private */
        public void b(a aVar) {
            this.f6869c.add(aVar);
        }

        /* access modifiers changed from: package-private */
        public Set<a> a() {
            return this.f6868b;
        }

        /* access modifiers changed from: package-private */
        public void c(a aVar) {
            this.f6869c.remove(aVar);
        }

        /* access modifiers changed from: package-private */
        public b<?> b() {
            return this.f6867a;
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            return this.f6869c.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            return this.f6868b.isEmpty();
        }
    }

    static void a(List<b<?>> list) {
        Set<a> b2 = b(list);
        Set<a> a2 = a(b2);
        int i = 0;
        while (!a2.isEmpty()) {
            a next = a2.iterator().next();
            a2.remove(next);
            i++;
            for (a next2 : next.a()) {
                next2.c(next);
                if (next2.c()) {
                    a2.add(next2);
                }
            }
        }
        if (i != list.size()) {
            ArrayList arrayList = new ArrayList();
            for (a next3 : b2) {
                if (!next3.c() && !next3.d()) {
                    arrayList.add(next3.b());
                }
            }
            throw new o(arrayList);
        }
    }

    private static Set<a> b(List<b<?>> list) {
        HashMap hashMap = new HashMap(list.size());
        for (b next : list) {
            a aVar = new a(next);
            Iterator it = next.a().iterator();
            while (true) {
                if (it.hasNext()) {
                    Class cls = (Class) it.next();
                    b bVar = new b(cls, !next.g());
                    if (!hashMap.containsKey(bVar)) {
                        hashMap.put(bVar, new HashSet());
                    }
                    Set set = (Set) hashMap.get(bVar);
                    if (set.isEmpty() || bVar.f6871b) {
                        set.add(aVar);
                    } else {
                        throw new IllegalArgumentException(String.format("Multiple components provide %s.", new Object[]{cls}));
                    }
                }
            }
        }
        for (Set<a> it2 : hashMap.values()) {
            for (a aVar2 : it2) {
                for (n next2 : aVar2.b().b()) {
                    if (next2.d()) {
                        Set<a> set2 = (Set) hashMap.get(new b(next2.a(), next2.c()));
                        if (set2 != null) {
                            for (a aVar3 : set2) {
                                aVar2.a(aVar3);
                                aVar3.b(aVar2);
                            }
                        }
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Set addAll : hashMap.values()) {
            hashSet.addAll(addAll);
        }
        return hashSet;
    }

    private static Set<a> a(Set<a> set) {
        HashSet hashSet = new HashSet();
        for (a next : set) {
            if (next.c()) {
                hashSet.add(next);
            }
        }
        return hashSet;
    }
}
