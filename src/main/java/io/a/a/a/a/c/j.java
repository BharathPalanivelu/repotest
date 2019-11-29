package io.a.a.a.a.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class j implements b<l>, i, l {

    /* renamed from: a  reason: collision with root package name */
    private final List<l> f33143a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f33144b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    private final AtomicReference<Throwable> f33145c = new AtomicReference<>((Object) null);

    public synchronized Collection<l> c() {
        return Collections.unmodifiableCollection(this.f33143a);
    }

    /* renamed from: a */
    public synchronized void c(l lVar) {
        this.f33143a.add(lVar);
    }

    public boolean d() {
        for (l f2 : c()) {
            if (!f2.f()) {
                return false;
            }
        }
        return true;
    }

    public synchronized void b(boolean z) {
        this.f33144b.set(z);
    }

    public boolean f() {
        return this.f33144b.get();
    }

    public e b() {
        return e.NORMAL;
    }

    public void a(Throwable th) {
        this.f33145c.set(th);
    }

    public int compareTo(Object obj) {
        return e.a(this, obj);
    }

    public static boolean a(Object obj) {
        try {
            b bVar = (b) obj;
            l lVar = (l) obj;
            i iVar = (i) obj;
            if (bVar == null || lVar == null || iVar == null) {
                return false;
            }
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }
}
