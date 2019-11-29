package com.google.a.b.a;

import com.google.a.b.b;
import com.google.a.b.c;
import com.google.a.b.i;
import com.google.a.f;
import com.google.a.l;
import com.google.a.r;
import com.google.a.u;
import com.google.a.w;
import com.google.a.x;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public final class g implements x {

    /* renamed from: a  reason: collision with root package name */
    final boolean f8757a;

    /* renamed from: b  reason: collision with root package name */
    private final c f8758b;

    public g(c cVar, boolean z) {
        this.f8758b = cVar;
        this.f8757a = z;
    }

    public <T> w<T> create(f fVar, com.google.a.c.a<T> aVar) {
        Type type = aVar.getType();
        if (!Map.class.isAssignableFrom(aVar.getRawType())) {
            return null;
        }
        Type[] b2 = b.b(type, b.e(type));
        return new a(fVar, b2[0], a(fVar, b2[0]), b2[1], fVar.a(com.google.a.c.a.get(b2[1])), this.f8758b.a(aVar));
    }

    private w<?> a(f fVar, Type type) {
        if (type == Boolean.TYPE || type == Boolean.class) {
            return n.f8805f;
        }
        return fVar.a(com.google.a.c.a.get(type));
    }

    private final class a<K, V> extends w<Map<K, V>> {

        /* renamed from: b  reason: collision with root package name */
        private final w<K> f8760b;

        /* renamed from: c  reason: collision with root package name */
        private final w<V> f8761c;

        /* renamed from: d  reason: collision with root package name */
        private final i<? extends Map<K, V>> f8762d;

        public a(f fVar, Type type, w<K> wVar, Type type2, w<V> wVar2, i<? extends Map<K, V>> iVar) {
            this.f8760b = new m(fVar, wVar, type);
            this.f8761c = new m(fVar, wVar2, type2);
            this.f8762d = iVar;
        }

        /* renamed from: a */
        public Map<K, V> read(com.google.a.d.a aVar) throws IOException {
            com.google.a.d.b f2 = aVar.f();
            if (f2 == com.google.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            Map<K, V> map = (Map) this.f8762d.a();
            if (f2 == com.google.a.d.b.BEGIN_ARRAY) {
                aVar.a();
                while (aVar.e()) {
                    aVar.a();
                    K read = this.f8760b.read(aVar);
                    if (map.put(read, this.f8761c.read(aVar)) == null) {
                        aVar.b();
                    } else {
                        throw new u("duplicate key: " + read);
                    }
                }
                aVar.b();
            } else {
                aVar.c();
                while (aVar.e()) {
                    com.google.a.b.f.f8870a.a(aVar);
                    K read2 = this.f8760b.read(aVar);
                    if (map.put(read2, this.f8761c.read(aVar)) != null) {
                        throw new u("duplicate key: " + read2);
                    }
                }
                aVar.d();
            }
            return map;
        }

        /* renamed from: a */
        public void write(com.google.a.d.c cVar, Map<K, V> map) throws IOException {
            if (map == null) {
                cVar.f();
            } else if (!g.this.f8757a) {
                cVar.d();
                for (Map.Entry next : map.entrySet()) {
                    cVar.a(String.valueOf(next.getKey()));
                    this.f8761c.write(cVar, next.getValue());
                }
                cVar.e();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i = 0;
                boolean z = false;
                for (Map.Entry next2 : map.entrySet()) {
                    l jsonTree = this.f8760b.toJsonTree(next2.getKey());
                    arrayList.add(jsonTree);
                    arrayList2.add(next2.getValue());
                    z |= jsonTree.i() || jsonTree.j();
                }
                if (z) {
                    cVar.b();
                    int size = arrayList.size();
                    while (i < size) {
                        cVar.b();
                        com.google.a.b.l.a((l) arrayList.get(i), cVar);
                        this.f8761c.write(cVar, arrayList2.get(i));
                        cVar.c();
                        i++;
                    }
                    cVar.c();
                    return;
                }
                cVar.d();
                int size2 = arrayList.size();
                while (i < size2) {
                    cVar.a(a((l) arrayList.get(i)));
                    this.f8761c.write(cVar, arrayList2.get(i));
                    i++;
                }
                cVar.e();
            }
        }

        private String a(l lVar) {
            if (lVar.k()) {
                r o = lVar.o();
                if (o.q()) {
                    return String.valueOf(o.b());
                }
                if (o.a()) {
                    return Boolean.toString(o.h());
                }
                if (o.r()) {
                    return o.c();
                }
                throw new AssertionError();
            } else if (lVar.l()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }
}
