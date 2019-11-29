package androidx.activity;

import androidx.lifecycle.e;
import androidx.lifecycle.f;
import androidx.lifecycle.h;
import java.util.ArrayDeque;
import java.util.Iterator;

public final class OnBackPressedDispatcher {

    /* renamed from: a  reason: collision with root package name */
    final ArrayDeque<c> f528a;

    /* renamed from: b  reason: collision with root package name */
    private final Runnable f529b;

    public OnBackPressedDispatcher() {
        this((Runnable) null);
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f528a = new ArrayDeque<>();
        this.f529b = runnable;
    }

    /* access modifiers changed from: package-private */
    public a a(c cVar) {
        this.f528a.add(cVar);
        a aVar = new a(cVar);
        cVar.a((a) aVar);
        return aVar;
    }

    public void a(h hVar, c cVar) {
        e lifecycle = hVar.getLifecycle();
        if (lifecycle.a() != e.b.DESTROYED) {
            cVar.a((a) new LifecycleOnBackPressedCancellable(lifecycle, cVar));
        }
    }

    public void a() {
        Iterator<c> descendingIterator = this.f528a.descendingIterator();
        while (descendingIterator.hasNext()) {
            c next = descendingIterator.next();
            if (next.a()) {
                next.c();
                return;
            }
        }
        Runnable runnable = this.f529b;
        if (runnable != null) {
            runnable.run();
        }
    }

    private class a implements a {

        /* renamed from: b  reason: collision with root package name */
        private final c f535b;

        a(c cVar) {
            this.f535b = cVar;
        }

        public void a() {
            OnBackPressedDispatcher.this.f528a.remove(this.f535b);
            this.f535b.b(this);
        }
    }

    private class LifecycleOnBackPressedCancellable implements a, f {

        /* renamed from: b  reason: collision with root package name */
        private final e f531b;

        /* renamed from: c  reason: collision with root package name */
        private final c f532c;

        /* renamed from: d  reason: collision with root package name */
        private a f533d;

        LifecycleOnBackPressedCancellable(e eVar, c cVar) {
            this.f531b = eVar;
            this.f532c = cVar;
            eVar.a(this);
        }

        public void onStateChanged(h hVar, e.a aVar) {
            if (aVar == e.a.ON_START) {
                this.f533d = OnBackPressedDispatcher.this.a(this.f532c);
            } else if (aVar == e.a.ON_STOP) {
                a aVar2 = this.f533d;
                if (aVar2 != null) {
                    aVar2.a();
                }
            } else if (aVar == e.a.ON_DESTROY) {
                a();
            }
        }

        public void a() {
            this.f531b.b(this);
            this.f532c.b(this);
            a aVar = this.f533d;
            if (aVar != null) {
                aVar.a();
                this.f533d = null;
            }
        }
    }
}
