package com.c.a;

import androidx.core.util.Pools;
import com.c.a.c.a.c;
import com.c.a.c.b.g;
import com.c.a.c.b.q;
import com.c.a.c.b.s;
import com.c.a.c.c.n;
import com.c.a.c.c.o;
import com.c.a.c.c.p;
import com.c.a.c.k;
import com.c.a.c.l;
import com.c.a.f.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private final p f6212a = new p(this.j);

    /* renamed from: b  reason: collision with root package name */
    private final com.c.a.f.a f6213b = new com.c.a.f.a();

    /* renamed from: c  reason: collision with root package name */
    private final com.c.a.f.e f6214c = new com.c.a.f.e();

    /* renamed from: d  reason: collision with root package name */
    private final f f6215d = new f();

    /* renamed from: e  reason: collision with root package name */
    private final com.c.a.c.a.d f6216e = new com.c.a.c.a.d();

    /* renamed from: f  reason: collision with root package name */
    private final com.c.a.c.d.f.e f6217f = new com.c.a.c.d.f.e();

    /* renamed from: g  reason: collision with root package name */
    private final com.c.a.f.b f6218g = new com.c.a.f.b();
    private final com.c.a.f.d h = new com.c.a.f.d();
    private final com.c.a.f.c i = new com.c.a.f.c();
    private final Pools.a<List<Throwable>> j = com.c.a.i.a.a.a();

    public h() {
        a((List<String>) Arrays.asList(new String[]{"Gif", "Bitmap", "BitmapDrawable"}));
    }

    public <Data> h a(Class<Data> cls, com.c.a.c.d<Data> dVar) {
        this.f6213b.a(cls, dVar);
        return this;
    }

    public <Data, TResource> h a(Class<Data> cls, Class<TResource> cls2, k<Data, TResource> kVar) {
        a("legacy_append", cls, cls2, kVar);
        return this;
    }

    public <Data, TResource> h a(String str, Class<Data> cls, Class<TResource> cls2, k<Data, TResource> kVar) {
        this.f6214c.a(str, kVar, cls, cls2);
        return this;
    }

    public final h a(List<String> list) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.f6214c.a((List<String>) arrayList);
        return this;
    }

    public <TResource> h a(Class<TResource> cls, l<TResource> lVar) {
        this.f6215d.a(cls, lVar);
        return this;
    }

    public h a(c.a aVar) {
        this.f6216e.a((c.a<?>) aVar);
        return this;
    }

    public <TResource, Transcode> h a(Class<TResource> cls, Class<Transcode> cls2, com.c.a.c.d.f.d<TResource, Transcode> dVar) {
        this.f6217f.a(cls, cls2, dVar);
        return this;
    }

    public h a(com.c.a.c.f fVar) {
        this.f6218g.a(fVar);
        return this;
    }

    public <Model, Data> h a(Class<Model> cls, Class<Data> cls2, o<Model, Data> oVar) {
        this.f6212a.a(cls, cls2, oVar);
        return this;
    }

    public <Data, TResource, Transcode> q<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        q<Data, TResource, Transcode> b2 = this.i.b(cls, cls2, cls3);
        if (b2 == null && !this.i.a(cls, cls2, cls3)) {
            List<g<Data, TResource, Transcode>> c2 = c(cls, cls2, cls3);
            if (c2.isEmpty()) {
                b2 = null;
            } else {
                b2 = new q<>(cls, cls2, cls3, c2, this.j);
            }
            this.i.a(cls, cls2, cls3, b2);
        }
        return b2;
    }

    private <Data, TResource, Transcode> List<g<Data, TResource, Transcode>> c(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class next : this.f6214c.b(cls, cls2)) {
            for (Class next2 : this.f6217f.b(next, cls3)) {
                arrayList.add(new g(cls, next, next2, this.f6214c.a(cls, next), this.f6217f.a(next, next2), this.j));
            }
        }
        return arrayList;
    }

    public <Model, TResource, Transcode> List<Class<?>> b(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        List<Class<?>> a2 = this.h.a(cls, cls2);
        if (a2 == null) {
            a2 = new ArrayList<>();
            for (Class<?> b2 : this.f6212a.a((Class<?>) cls)) {
                for (Class next : this.f6214c.b(b2, cls2)) {
                    if (!this.f6217f.b(next, cls3).isEmpty() && !a2.contains(next)) {
                        a2.add(next);
                    }
                }
            }
            this.h.a(cls, cls2, Collections.unmodifiableList(a2));
        }
        return a2;
    }

    public boolean a(s<?> sVar) {
        return this.f6215d.a(sVar.b()) != null;
    }

    public <X> l<X> b(s<X> sVar) throws d {
        l<X> a2 = this.f6215d.a(sVar.b());
        if (a2 != null) {
            return a2;
        }
        throw new d(sVar.b());
    }

    public <X> com.c.a.c.d<X> a(X x) throws e {
        com.c.a.c.d<X> a2 = this.f6213b.a(x.getClass());
        if (a2 != null) {
            return a2;
        }
        throw new e(x.getClass());
    }

    public <X> com.c.a.c.a.c<X> b(X x) {
        return this.f6216e.a(x);
    }

    public <Model> List<n<Model, ?>> c(Model model) {
        List<n<Model, ?>> a2 = this.f6212a.a(model);
        if (!a2.isEmpty()) {
            return a2;
        }
        throw new c(model);
    }

    public List<com.c.a.c.f> a() {
        List<com.c.a.c.f> a2 = this.f6218g.a();
        if (!a2.isEmpty()) {
            return a2;
        }
        throw new b();
    }

    public static class c extends a {
        public c(Object obj) {
            super("Failed to find any ModelLoaders for model: " + obj);
        }

        public c(Class<?> cls, Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    public static class d extends a {
        public d(Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls);
        }
    }

    public static class e extends a {
        public e(Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    public static final class b extends a {
        public b() {
            super("Failed to find image header parser.");
        }
    }
}
