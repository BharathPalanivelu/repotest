package com.garena.f.a;

import com.garena.f.a;
import com.garena.f.e;
import com.garena.f.j;
import com.garena.h.a.d;
import com.garena.h.b;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;

public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private final ScheduledExecutorService f7944a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, b> f7945b = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<a> f7946c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public List<e> f7947d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public h f7948e;

    public c(ScheduledExecutorService scheduledExecutorService, List<e> list, List<a> list2, h hVar) {
        this.f7948e = hVar;
        this.f7944a = scheduledExecutorService;
        this.f7947d = list;
        this.f7946c = list2;
    }

    public void a(final d dVar, final boolean z) {
        this.f7944a.execute(new Runnable() {
            public void run() {
                if (c.this.f7946c != null) {
                    for (a a2 : c.this.f7946c) {
                        a2.a(dVar);
                    }
                }
                for (b a3 : c.this.f7945b.values()) {
                    a3.a(dVar);
                }
                if (z) {
                    c.this.f7948e.a(dVar);
                }
            }
        });
    }

    public void a(String str, d dVar) {
        a(dVar, true);
    }

    public void a(final com.garena.h.e eVar) {
        this.f7944a.execute(new Runnable() {
            public void run() {
                String a2 = eVar.a();
                if (c.this.f7945b.containsKey(a2)) {
                    ((b) c.this.f7945b.get(a2)).a(d.SENDING_FAILED);
                }
            }
        });
    }

    public void b(final com.garena.h.e eVar) {
        this.f7944a.execute(new Runnable() {
            public void run() {
                String a2 = eVar.a();
                if (c.this.f7945b.containsKey(a2)) {
                    ((b) c.this.f7945b.get(a2)).a(eVar);
                    return;
                }
                e eVar = new e(new j(eVar));
                for (e a3 : c.this.f7947d) {
                    eVar = a3.a(eVar);
                }
            }
        });
    }

    public void a(String str) {
        a(d.CONNECTION_DROPPED, true);
    }

    public void b(String str) {
        this.f7944a.execute(new Runnable() {
            public void run() {
                if (c.this.f7946c != null) {
                    for (a a2 : c.this.f7946c) {
                        a2.a();
                    }
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void a(String str, b bVar) {
        this.f7945b.put(str, bVar);
    }

    /* access modifiers changed from: package-private */
    public void c(String str) {
        this.f7945b.remove(str);
    }
}
