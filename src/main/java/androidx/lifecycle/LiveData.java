package androidx.lifecycle;

import androidx.a.a.b.b;
import androidx.lifecycle.e;
import java.util.Map;

public abstract class LiveData<T> {

    /* renamed from: b  reason: collision with root package name */
    static final Object f2551b = new Object();

    /* renamed from: a  reason: collision with root package name */
    final Object f2552a = new Object();

    /* renamed from: c  reason: collision with root package name */
    int f2553c = 0;

    /* renamed from: d  reason: collision with root package name */
    volatile Object f2554d;

    /* renamed from: e  reason: collision with root package name */
    private b<n<? super T>, LiveData<T>.a> f2555e = new b<>();

    /* renamed from: f  reason: collision with root package name */
    private volatile Object f2556f;

    /* renamed from: g  reason: collision with root package name */
    private int f2557g;
    private boolean h;
    private boolean i;
    private final Runnable j;

    /* access modifiers changed from: protected */
    public void b() {
    }

    /* access modifiers changed from: protected */
    public void c() {
    }

    public LiveData() {
        Object obj = f2551b;
        this.f2556f = obj;
        this.f2554d = obj;
        this.f2557g = -1;
        this.j = new Runnable() {
            public void run() {
                Object obj;
                synchronized (LiveData.this.f2552a) {
                    obj = LiveData.this.f2554d;
                    LiveData.this.f2554d = LiveData.f2551b;
                }
                LiveData.this.b(obj);
            }
        };
    }

    private void b(LiveData<T>.a aVar) {
        if (aVar.f2562d) {
            if (!aVar.a()) {
                aVar.a(false);
                return;
            }
            int i2 = aVar.f2563e;
            int i3 = this.f2557g;
            if (i2 < i3) {
                aVar.f2563e = i3;
                aVar.f2561c.a(this.f2556f);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(LiveData<T>.a aVar) {
        if (this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            this.i = false;
            if (aVar == null) {
                b<K, V>.d c2 = this.f2555e.c();
                while (c2.hasNext()) {
                    b((LiveData<T>.a) (a) ((Map.Entry) c2.next()).getValue());
                    if (this.i) {
                        break;
                    }
                }
            } else {
                b(aVar);
                aVar = null;
            }
        } while (this.i);
        this.h = false;
    }

    public void a(h hVar, n<? super T> nVar) {
        a("observe");
        if (hVar.getLifecycle().a() != e.b.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(hVar, nVar);
            a a2 = this.f2555e.a(nVar, lifecycleBoundObserver);
            if (a2 != null && !a2.a(hVar)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (a2 == null) {
                hVar.getLifecycle().a(lifecycleBoundObserver);
            }
        }
    }

    public void a(n<? super T> nVar) {
        a("removeObserver");
        a b2 = this.f2555e.b(nVar);
        if (b2 != null) {
            b2.b();
            b2.a(false);
        }
    }

    /* access modifiers changed from: protected */
    public void a(T t) {
        boolean z;
        synchronized (this.f2552a) {
            z = this.f2554d == f2551b;
            this.f2554d = t;
        }
        if (z) {
            androidx.a.a.a.a.a().b(this.j);
        }
    }

    /* access modifiers changed from: protected */
    public void b(T t) {
        a("setValue");
        this.f2557g++;
        this.f2556f = t;
        a((LiveData<T>.a) null);
    }

    public T a() {
        T t = this.f2556f;
        if (t != f2551b) {
            return t;
        }
        return null;
    }

    public boolean d() {
        return this.f2553c > 0;
    }

    class LifecycleBoundObserver extends LiveData<T>.a implements d {

        /* renamed from: a  reason: collision with root package name */
        final h f2559a;

        LifecycleBoundObserver(h hVar, n<? super T> nVar) {
            super(nVar);
            this.f2559a = hVar;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f2559a.getLifecycle().a().isAtLeast(e.b.STARTED);
        }

        public void onStateChanged(h hVar, e.a aVar) {
            if (this.f2559a.getLifecycle().a() == e.b.DESTROYED) {
                LiveData.this.a(this.f2561c);
            } else {
                a(a());
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a(h hVar) {
            return this.f2559a == hVar;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f2559a.getLifecycle().b(this);
        }
    }

    private abstract class a {

        /* renamed from: c  reason: collision with root package name */
        final n<? super T> f2561c;

        /* renamed from: d  reason: collision with root package name */
        boolean f2562d;

        /* renamed from: e  reason: collision with root package name */
        int f2563e = -1;

        /* access modifiers changed from: package-private */
        public abstract boolean a();

        /* access modifiers changed from: package-private */
        public boolean a(h hVar) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void b() {
        }

        a(n<? super T> nVar) {
            this.f2561c = nVar;
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z) {
            if (z != this.f2562d) {
                this.f2562d = z;
                int i = 1;
                boolean z2 = LiveData.this.f2553c == 0;
                LiveData liveData = LiveData.this;
                int i2 = liveData.f2553c;
                if (!this.f2562d) {
                    i = -1;
                }
                liveData.f2553c = i2 + i;
                if (z2 && this.f2562d) {
                    LiveData.this.b();
                }
                if (LiveData.this.f2553c == 0 && !this.f2562d) {
                    LiveData.this.c();
                }
                if (this.f2562d) {
                    LiveData.this.a((LiveData<T>.a) this);
                }
            }
        }
    }

    private static void a(String str) {
        if (!androidx.a.a.a.a.a().b()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background" + " thread");
        }
    }
}
