package com.android.b;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class m {

    /* renamed from: a  reason: collision with root package name */
    private AtomicInteger f4619a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Queue<l<?>>> f4620b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<l<?>> f4621c;

    /* renamed from: d  reason: collision with root package name */
    private final PriorityBlockingQueue<l<?>> f4622d;

    /* renamed from: e  reason: collision with root package name */
    private final PriorityBlockingQueue<l<?>> f4623e;

    /* renamed from: f  reason: collision with root package name */
    private final b f4624f;

    /* renamed from: g  reason: collision with root package name */
    private final f f4625g;
    private final o h;
    private g[] i;
    private c j;

    public m(b bVar, f fVar, int i2, o oVar) {
        this.f4619a = new AtomicInteger();
        this.f4620b = new HashMap();
        this.f4621c = new HashSet();
        this.f4622d = new PriorityBlockingQueue<>();
        this.f4623e = new PriorityBlockingQueue<>();
        this.f4624f = bVar;
        this.f4625g = fVar;
        this.i = new g[i2];
        this.h = oVar;
    }

    public m(b bVar, f fVar, int i2) {
        this(bVar, fVar, i2, new e(new Handler(Looper.getMainLooper())));
    }

    public m(b bVar, f fVar) {
        this(bVar, fVar, 4);
    }

    public void a() {
        b();
        this.j = new c(this.f4622d, this.f4623e, this.f4624f, this.h);
        this.j.start();
        for (int i2 = 0; i2 < this.i.length; i2++) {
            g gVar = new g(this.f4623e, this.f4625g, this.f4624f, this.h);
            this.i[i2] = gVar;
            gVar.start();
        }
    }

    public void b() {
        c cVar = this.j;
        if (cVar != null) {
            cVar.a();
        }
        int i2 = 0;
        while (true) {
            g[] gVarArr = this.i;
            if (i2 < gVarArr.length) {
                if (gVarArr[i2] != null) {
                    gVarArr[i2].a();
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public int c() {
        return this.f4619a.incrementAndGet();
    }

    public <T> l<T> a(l<T> lVar) {
        lVar.setRequestQueue(this);
        synchronized (this.f4621c) {
            this.f4621c.add(lVar);
        }
        lVar.setSequence(c());
        lVar.addMarker("add-to-queue");
        if (!lVar.shouldCache()) {
            this.f4623e.add(lVar);
            return lVar;
        }
        synchronized (this.f4620b) {
            String cacheKey = lVar.getCacheKey();
            if (this.f4620b.containsKey(cacheKey)) {
                Queue queue = this.f4620b.get(cacheKey);
                if (queue == null) {
                    queue = new LinkedList();
                }
                queue.add(lVar);
                this.f4620b.put(cacheKey, queue);
                if (t.f4631b) {
                    t.a("Request for cacheKey=%s is in flight, putting on hold.", cacheKey);
                }
            } else {
                this.f4620b.put(cacheKey, (Object) null);
                this.f4622d.add(lVar);
            }
        }
        return lVar;
    }

    /* access modifiers changed from: package-private */
    public void b(l<?> lVar) {
        synchronized (this.f4621c) {
            this.f4621c.remove(lVar);
        }
        if (lVar.shouldCache()) {
            synchronized (this.f4620b) {
                String cacheKey = lVar.getCacheKey();
                Queue remove = this.f4620b.remove(cacheKey);
                if (remove != null) {
                    if (t.f4631b) {
                        t.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), cacheKey);
                    }
                    this.f4622d.addAll(remove);
                }
            }
        }
    }
}
