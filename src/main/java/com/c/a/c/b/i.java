package com.c.a.c.b;

import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import androidx.core.util.Pools;
import com.c.a.c.b.b.a;
import com.c.a.c.b.b.h;
import com.c.a.c.b.f;
import com.c.a.c.b.n;
import com.c.a.c.j;
import com.c.a.c.m;
import com.c.a.g;
import com.c.a.i.a.a;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class i implements h.a, k, n.a {

    /* renamed from: a  reason: collision with root package name */
    private final Map<com.c.a.c.h, j<?>> f5812a;

    /* renamed from: b  reason: collision with root package name */
    private final m f5813b;

    /* renamed from: c  reason: collision with root package name */
    private final h f5814c;

    /* renamed from: d  reason: collision with root package name */
    private final b f5815d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<com.c.a.c.h, WeakReference<n<?>>> f5816e;

    /* renamed from: f  reason: collision with root package name */
    private final v f5817f;

    /* renamed from: g  reason: collision with root package name */
    private final c f5818g;
    private final a h;
    private ReferenceQueue<n<?>> i;

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private final j<?> f5832a;

        /* renamed from: b  reason: collision with root package name */
        private final com.c.a.g.h f5833b;

        public d(com.c.a.g.h hVar, j<?> jVar) {
            this.f5833b = hVar;
            this.f5832a = jVar;
        }

        public void a() {
            this.f5832a.b(this.f5833b);
        }
    }

    public i(h hVar, a.C0099a aVar, com.c.a.c.b.c.a aVar2, com.c.a.c.b.c.a aVar3, com.c.a.c.b.c.a aVar4, com.c.a.c.b.c.a aVar5) {
        this(hVar, aVar, aVar2, aVar3, aVar4, aVar5, (Map<com.c.a.c.h, j<?>>) null, (m) null, (Map<com.c.a.c.h, WeakReference<n<?>>>) null, (b) null, (a) null, (v) null);
    }

    i(h hVar, a.C0099a aVar, com.c.a.c.b.c.a aVar2, com.c.a.c.b.c.a aVar3, com.c.a.c.b.c.a aVar4, com.c.a.c.b.c.a aVar5, Map<com.c.a.c.h, j<?>> map, m mVar, Map<com.c.a.c.h, WeakReference<n<?>>> map2, b bVar, a aVar6, v vVar) {
        this.f5814c = hVar;
        a.C0099a aVar7 = aVar;
        this.f5818g = new c(aVar);
        this.f5816e = map2 == null ? new HashMap<>() : map2;
        this.f5813b = mVar == null ? new m() : mVar;
        this.f5812a = map == null ? new HashMap<>() : map;
        this.f5815d = bVar == null ? new b(aVar2, aVar3, aVar4, aVar5, this) : bVar;
        this.h = aVar6 == null ? new a(this.f5818g) : aVar6;
        this.f5817f = vVar == null ? new v() : vVar;
        hVar.a((h.a) this);
    }

    public <R> d a(com.c.a.e eVar, Object obj, com.c.a.c.h hVar, int i2, int i3, Class<?> cls, Class<R> cls2, g gVar, h hVar2, Map<Class<?>, m<?>> map, boolean z, boolean z2, j jVar, boolean z3, boolean z4, boolean z5, boolean z6, com.c.a.g.h hVar3) {
        boolean z7 = z3;
        com.c.a.g.h hVar4 = hVar3;
        com.c.a.i.i.a();
        long a2 = com.c.a.i.d.a();
        l a3 = this.f5813b.a(obj, hVar, i2, i3, map, cls, cls2, jVar);
        n<?> b2 = b((com.c.a.c.h) a3, z7);
        if (b2 != null) {
            hVar4.a(b2, com.c.a.c.a.MEMORY_CACHE);
            if (Log.isLoggable("Engine", 2)) {
                a("Loaded resource from cache", a2, a3);
            }
            return null;
        }
        n<?> a4 = a((com.c.a.c.h) a3, z7);
        if (a4 != null) {
            hVar4.a(a4, com.c.a.c.a.MEMORY_CACHE);
            if (Log.isLoggable("Engine", 2)) {
                a("Loaded resource from active resources", a2, a3);
            }
            return null;
        }
        j jVar2 = this.f5812a.get(a3);
        if (jVar2 != null) {
            jVar2.a(hVar4);
            if (Log.isLoggable("Engine", 2)) {
                a("Added to existing load", a2, a3);
            }
            return new d(hVar4, jVar2);
        }
        j a5 = this.f5815d.a(a3, z7, z4, z5);
        long j = a2;
        f<R> a6 = this.h.a(eVar, obj, a3, hVar, i2, i3, cls, cls2, gVar, hVar2, map, z, z2, z6, jVar, a5);
        this.f5812a.put(a3, a5);
        a5.a(hVar4);
        a5.b(a6);
        if (Log.isLoggable("Engine", 2)) {
            a("Started new load", j, a3);
        }
        return new d(hVar4, a5);
    }

    private static void a(String str, long j, com.c.a.c.h hVar) {
        Log.v("Engine", str + " in " + com.c.a.i.d.a(j) + "ms, key: " + hVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.c.a.c.b.n<?>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.c.a.c.b.n<?> a(com.c.a.c.h r2, boolean r3) {
        /*
            r1 = this;
            r0 = 0
            if (r3 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.util.Map<com.c.a.c.h, java.lang.ref.WeakReference<com.c.a.c.b.n<?>>> r3 = r1.f5816e
            java.lang.Object r3 = r3.get(r2)
            java.lang.ref.WeakReference r3 = (java.lang.ref.WeakReference) r3
            if (r3 == 0) goto L_0x0020
            java.lang.Object r3 = r3.get()
            r0 = r3
            com.c.a.c.b.n r0 = (com.c.a.c.b.n) r0
            if (r0 == 0) goto L_0x001b
            r0.f()
            goto L_0x0020
        L_0x001b:
            java.util.Map<com.c.a.c.h, java.lang.ref.WeakReference<com.c.a.c.b.n<?>>> r3 = r1.f5816e
            r3.remove(r2)
        L_0x0020:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.c.b.i.a(com.c.a.c.h, boolean):com.c.a.c.b.n");
    }

    private n<?> b(com.c.a.c.h hVar, boolean z) {
        if (!z) {
            return null;
        }
        n<?> a2 = a(hVar);
        if (a2 != null) {
            a2.f();
            this.f5816e.put(hVar, new f(hVar, a2, a()));
        }
        return a2;
    }

    private n<?> a(com.c.a.c.h hVar) {
        s<?> a2 = this.f5814c.a(hVar);
        if (a2 == null) {
            return null;
        }
        if (a2 instanceof n) {
            return (n) a2;
        }
        return new n<>(a2, true);
    }

    public void a(s<?> sVar) {
        com.c.a.i.i.a();
        if (sVar instanceof n) {
            ((n) sVar).g();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    public void a(com.c.a.c.h hVar, n<?> nVar) {
        com.c.a.i.i.a();
        if (nVar != null) {
            nVar.a(hVar, this);
            if (nVar.a()) {
                this.f5816e.put(hVar, new f(hVar, nVar, a()));
            }
        }
        this.f5812a.remove(hVar);
    }

    public void a(j jVar, com.c.a.c.h hVar) {
        com.c.a.i.i.a();
        if (jVar.equals(this.f5812a.get(hVar))) {
            this.f5812a.remove(hVar);
        }
    }

    public void b(s<?> sVar) {
        com.c.a.i.i.a();
        this.f5817f.a(sVar);
    }

    public void b(com.c.a.c.h hVar, n nVar) {
        com.c.a.i.i.a();
        this.f5816e.remove(hVar);
        if (nVar.a()) {
            this.f5814c.b(hVar, nVar);
        } else {
            this.f5817f.a(nVar);
        }
    }

    private ReferenceQueue<n<?>> a() {
        if (this.i == null) {
            this.i = new ReferenceQueue<>();
            Looper.myQueue().addIdleHandler(new e(this.f5816e, this.i));
        }
        return this.i;
    }

    private static class c implements f.d {

        /* renamed from: a  reason: collision with root package name */
        private final a.C0099a f5830a;

        /* renamed from: b  reason: collision with root package name */
        private volatile com.c.a.c.b.b.a f5831b;

        public c(a.C0099a aVar) {
            this.f5830a = aVar;
        }

        public com.c.a.c.b.b.a a() {
            if (this.f5831b == null) {
                synchronized (this) {
                    if (this.f5831b == null) {
                        this.f5831b = this.f5830a.a();
                    }
                    if (this.f5831b == null) {
                        this.f5831b = new com.c.a.c.b.b.b();
                    }
                }
            }
            return this.f5831b;
        }
    }

    private static class f extends WeakReference<n<?>> {

        /* renamed from: a  reason: collision with root package name */
        final com.c.a.c.h f5836a;

        public f(com.c.a.c.h hVar, n<?> nVar, ReferenceQueue<? super n<?>> referenceQueue) {
            super(nVar, referenceQueue);
            this.f5836a = hVar;
        }
    }

    private static class e implements MessageQueue.IdleHandler {

        /* renamed from: a  reason: collision with root package name */
        private final Map<com.c.a.c.h, WeakReference<n<?>>> f5834a;

        /* renamed from: b  reason: collision with root package name */
        private final ReferenceQueue<n<?>> f5835b;

        public e(Map<com.c.a.c.h, WeakReference<n<?>>> map, ReferenceQueue<n<?>> referenceQueue) {
            this.f5834a = map;
            this.f5835b = referenceQueue;
        }

        public boolean queueIdle() {
            f fVar = (f) this.f5835b.poll();
            if (fVar == null) {
                return true;
            }
            this.f5834a.remove(fVar.f5836a);
            return true;
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final f.d f5819a;

        /* renamed from: b  reason: collision with root package name */
        final Pools.a<f<?>> f5820b = com.c.a.i.a.a.a(150, new a.C0112a<f<?>>() {
            /* renamed from: a */
            public f<?> b() {
                return new f<>(a.this.f5819a, a.this.f5820b);
            }
        });

        /* renamed from: c  reason: collision with root package name */
        private int f5821c;

        a(f.d dVar) {
            this.f5819a = dVar;
        }

        /* access modifiers changed from: package-private */
        public <R> f<R> a(com.c.a.e eVar, Object obj, l lVar, com.c.a.c.h hVar, int i, int i2, Class<?> cls, Class<R> cls2, g gVar, h hVar2, Map<Class<?>, m<?>> map, boolean z, boolean z2, boolean z3, j jVar, f.a<R> aVar) {
            f acquire = this.f5820b.acquire();
            int i3 = this.f5821c;
            int i4 = i3;
            this.f5821c = i3 + 1;
            return acquire.a(eVar, obj, lVar, hVar, i, i2, cls, cls2, gVar, hVar2, map, z, z2, z3, jVar, aVar, i4);
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        final com.c.a.c.b.c.a f5823a;

        /* renamed from: b  reason: collision with root package name */
        final com.c.a.c.b.c.a f5824b;

        /* renamed from: c  reason: collision with root package name */
        final com.c.a.c.b.c.a f5825c;

        /* renamed from: d  reason: collision with root package name */
        final com.c.a.c.b.c.a f5826d;

        /* renamed from: e  reason: collision with root package name */
        final k f5827e;

        /* renamed from: f  reason: collision with root package name */
        final Pools.a<j<?>> f5828f = com.c.a.i.a.a.a(150, new a.C0112a<j<?>>() {
            /* renamed from: a */
            public j<?> b() {
                return new j(b.this.f5823a, b.this.f5824b, b.this.f5825c, b.this.f5826d, b.this.f5827e, b.this.f5828f);
            }
        });

        b(com.c.a.c.b.c.a aVar, com.c.a.c.b.c.a aVar2, com.c.a.c.b.c.a aVar3, com.c.a.c.b.c.a aVar4, k kVar) {
            this.f5823a = aVar;
            this.f5824b = aVar2;
            this.f5825c = aVar3;
            this.f5826d = aVar4;
            this.f5827e = kVar;
        }

        /* access modifiers changed from: package-private */
        public <R> j<R> a(com.c.a.c.h hVar, boolean z, boolean z2, boolean z3) {
            return this.f5828f.acquire().a(hVar, z, z2, z3);
        }
    }
}
