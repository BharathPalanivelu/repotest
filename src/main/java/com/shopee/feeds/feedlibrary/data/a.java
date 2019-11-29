package com.shopee.feeds.feedlibrary.data;

import com.google.a.d.c;
import com.google.a.f;
import com.google.a.l;
import com.google.a.o;
import com.google.a.p;
import com.google.a.r;
import com.google.a.w;
import com.google.a.x;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public final class a<T> implements x {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Class<?> f27652a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f27653b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Class<?>> f27654c = new LinkedHashMap();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Map<Class<?>, String> f27655d = new LinkedHashMap();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final boolean f27656e;

    private a(Class<?> cls, String str, boolean z) {
        if (str == null || cls == null) {
            throw new NullPointerException();
        }
        this.f27652a = cls;
        this.f27653b = str;
        this.f27656e = z;
    }

    public static <T> a<T> a(Class<T> cls, String str) {
        return new a<>(cls, str, false);
    }

    public a<T> b(Class<? extends T> cls, String str) {
        if (cls == null || str == null) {
            throw new NullPointerException();
        } else if (this.f27655d.containsKey(cls) || this.f27654c.containsKey(str)) {
            throw new IllegalArgumentException("types and labels must be unique");
        } else {
            this.f27654c.put(str, cls);
            this.f27655d.put(cls, str);
            return this;
        }
    }

    public <R> w<R> create(f fVar, com.google.a.c.a<R> aVar) {
        if (aVar.getRawType() != this.f27652a) {
            return null;
        }
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        final LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry next : this.f27654c.entrySet()) {
            w a2 = fVar.a((x) this, com.google.a.c.a.get((Class) next.getValue()));
            linkedHashMap.put(next.getKey(), a2);
            linkedHashMap2.put(next.getValue(), a2);
        }
        return new w<R>() {
            public R read(com.google.a.d.a aVar) throws IOException {
                l lVar;
                l a2 = com.google.a.b.l.a(aVar);
                if (a.this.f27656e) {
                    lVar = a2.m().c(a.this.f27653b);
                } else {
                    lVar = a2.m().a(a.this.f27653b);
                }
                if (lVar != null) {
                    String c2 = lVar.c();
                    w wVar = (w) linkedHashMap.get(c2);
                    if (wVar != null) {
                        return wVar.fromJsonTree(a2);
                    }
                    throw new p("cannot deserialize " + a.this.f27652a + " subtype named " + c2 + "; did you forget to register a subtype?");
                }
                throw new p("cannot deserialize " + a.this.f27652a + " because it does not define a field named " + a.this.f27653b);
            }

            public void write(c cVar, R r) throws IOException {
                Class<?> cls = r.getClass();
                String str = (String) a.this.f27655d.get(cls);
                w wVar = (w) linkedHashMap2.get(cls);
                if (wVar != null) {
                    o m = wVar.toJsonTree(r).m();
                    if (a.this.f27656e) {
                        com.google.a.b.l.a(m, cVar);
                        return;
                    }
                    o oVar = new o();
                    if (!m.b(a.this.f27653b)) {
                        oVar.a(a.this.f27653b, (l) new r(str));
                        for (Map.Entry next : m.a()) {
                            oVar.a((String) next.getKey(), (l) next.getValue());
                        }
                        com.google.a.b.l.a(oVar, cVar);
                        return;
                    }
                    throw new p("cannot serialize " + cls.getName() + " because it already defines a field named " + a.this.f27653b);
                }
                throw new p("cannot serialize " + cls.getName() + "; did you forget to register a subtype?");
            }
        }.nullSafe();
    }
}
