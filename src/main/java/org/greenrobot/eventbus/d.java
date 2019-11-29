package org.greenrobot.eventbus;

import android.os.Looper;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.a.b;
import org.greenrobot.eventbus.g;
import org.greenrobot.eventbus.h;

public class d {
    private static final ExecutorService m = Executors.newCachedThreadPool();

    /* renamed from: a  reason: collision with root package name */
    boolean f34001a = true;

    /* renamed from: b  reason: collision with root package name */
    boolean f34002b = true;

    /* renamed from: c  reason: collision with root package name */
    boolean f34003c = true;

    /* renamed from: d  reason: collision with root package name */
    boolean f34004d = true;

    /* renamed from: e  reason: collision with root package name */
    boolean f34005e;

    /* renamed from: f  reason: collision with root package name */
    boolean f34006f = true;

    /* renamed from: g  reason: collision with root package name */
    boolean f34007g;
    boolean h;
    ExecutorService i = m;
    List<b> j;
    g k;
    h l;

    d() {
    }

    /* access modifiers changed from: package-private */
    public g a() {
        g gVar = this.k;
        if (gVar != null) {
            return gVar;
        }
        return (!g.a.a() || c() == null) ? new g.b() : new g.a("EventBus");
    }

    /* access modifiers changed from: package-private */
    public h b() {
        h hVar = this.l;
        if (hVar != null) {
            return hVar;
        }
        if (!g.a.a()) {
            return null;
        }
        Object c2 = c();
        if (c2 == null) {
            return null;
        }
        return new h.a((Looper) c2);
    }

    /* access modifiers changed from: package-private */
    public Object c() {
        try {
            return Looper.getMainLooper();
        } catch (RuntimeException unused) {
            return null;
        }
    }
}
