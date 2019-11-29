package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private boolean f539a;

    /* renamed from: b  reason: collision with root package name */
    private CopyOnWriteArrayList<a> f540b = new CopyOnWriteArrayList<>();

    public abstract void c();

    public c(boolean z) {
        this.f539a = z;
    }

    public final void a(boolean z) {
        this.f539a = z;
    }

    public final boolean a() {
        return this.f539a;
    }

    public final void b() {
        Iterator<a> it = this.f540b.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        this.f540b.add(aVar);
    }

    /* access modifiers changed from: package-private */
    public void b(a aVar) {
        this.f540b.remove(aVar);
    }
}
