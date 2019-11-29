package com.c.a.c.b.a;

import com.c.a.c.b.a.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class h<K extends m, V> {

    /* renamed from: a  reason: collision with root package name */
    private final a<K, V> f5690a = new a<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<K, a<K, V>> f5691b = new HashMap();

    h() {
    }

    public void a(K k, V v) {
        a aVar = this.f5691b.get(k);
        if (aVar == null) {
            aVar = new a(k);
            b(aVar);
            this.f5691b.put(k, aVar);
        } else {
            k.a();
        }
        aVar.a(v);
    }

    public V a(K k) {
        a aVar = this.f5691b.get(k);
        if (aVar == null) {
            aVar = new a(k);
            this.f5691b.put(k, aVar);
        } else {
            k.a();
        }
        a(aVar);
        return aVar.a();
    }

    public V a() {
        for (a<K, V> aVar = this.f5690a.f5694c; !aVar.equals(this.f5690a); aVar = aVar.f5694c) {
            V a2 = aVar.a();
            if (a2 != null) {
                return a2;
            }
            d(aVar);
            this.f5691b.remove(aVar.f5692a);
            ((m) aVar.f5692a).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a<K, V> aVar = this.f5690a.f5693b; !aVar.equals(this.f5690a); aVar = aVar.f5693b) {
            z = true;
            sb.append('{');
            sb.append(aVar.f5692a);
            sb.append(':');
            sb.append(aVar.b());
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }

    private void a(a<K, V> aVar) {
        d(aVar);
        a<K, V> aVar2 = this.f5690a;
        aVar.f5694c = aVar2;
        aVar.f5693b = aVar2.f5693b;
        c(aVar);
    }

    private void b(a<K, V> aVar) {
        d(aVar);
        aVar.f5694c = this.f5690a.f5694c;
        aVar.f5693b = this.f5690a;
        c(aVar);
    }

    private static <K, V> void c(a<K, V> aVar) {
        aVar.f5693b.f5694c = aVar;
        aVar.f5694c.f5693b = aVar;
    }

    private static <K, V> void d(a<K, V> aVar) {
        aVar.f5694c.f5693b = aVar.f5693b;
        aVar.f5693b.f5694c = aVar.f5694c;
    }

    private static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f5692a;

        /* renamed from: b  reason: collision with root package name */
        a<K, V> f5693b;

        /* renamed from: c  reason: collision with root package name */
        a<K, V> f5694c;

        /* renamed from: d  reason: collision with root package name */
        private List<V> f5695d;

        public a() {
            this((Object) null);
        }

        public a(K k) {
            this.f5694c = this;
            this.f5693b = this;
            this.f5692a = k;
        }

        public V a() {
            int b2 = b();
            if (b2 > 0) {
                return this.f5695d.remove(b2 - 1);
            }
            return null;
        }

        public int b() {
            List<V> list = this.f5695d;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public void a(V v) {
            if (this.f5695d == null) {
                this.f5695d = new ArrayList();
            }
            this.f5695d.add(v);
        }
    }
}
