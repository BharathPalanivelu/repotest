package androidx.d.a;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import androidx.b.g;
import java.util.ArrayList;

class a {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal<a> f1938a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<b> f1939b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    long f1940c = 0;

    /* renamed from: d  reason: collision with root package name */
    private final g<b, Long> f1941d = new g<>();

    /* renamed from: e  reason: collision with root package name */
    private final C0040a f1942e = new C0040a();

    /* renamed from: f  reason: collision with root package name */
    private c f1943f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1944g = false;

    interface b {
        boolean a(long j);
    }

    a() {
    }

    /* renamed from: androidx.d.a.a$a  reason: collision with other inner class name */
    class C0040a {
        C0040a() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            a.this.f1940c = SystemClock.uptimeMillis();
            a aVar = a.this;
            aVar.a(aVar.f1940c);
            if (a.this.f1939b.size() > 0) {
                a.this.b().a();
            }
        }
    }

    public static a a() {
        if (f1938a.get() == null) {
            f1938a.set(new a());
        }
        return f1938a.get();
    }

    /* access modifiers changed from: package-private */
    public c b() {
        if (this.f1943f == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.f1943f = new e(this.f1942e);
            } else {
                this.f1943f = new d(this.f1942e);
            }
        }
        return this.f1943f;
    }

    public void a(b bVar, long j) {
        if (this.f1939b.size() == 0) {
            b().a();
        }
        if (!this.f1939b.contains(bVar)) {
            this.f1939b.add(bVar);
        }
        if (j > 0) {
            this.f1941d.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j));
        }
    }

    public void a(b bVar) {
        this.f1941d.remove(bVar);
        int indexOf = this.f1939b.indexOf(bVar);
        if (indexOf >= 0) {
            this.f1939b.set(indexOf, (Object) null);
            this.f1944g = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(long j) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i = 0; i < this.f1939b.size(); i++) {
            b bVar = this.f1939b.get(i);
            if (bVar != null && b(bVar, uptimeMillis)) {
                bVar.a(j);
            }
        }
        c();
    }

    private boolean b(b bVar, long j) {
        Long l = this.f1941d.get(bVar);
        if (l == null) {
            return true;
        }
        if (l.longValue() >= j) {
            return false;
        }
        this.f1941d.remove(bVar);
        return true;
    }

    private void c() {
        if (this.f1944g) {
            for (int size = this.f1939b.size() - 1; size >= 0; size--) {
                if (this.f1939b.get(size) == null) {
                    this.f1939b.remove(size);
                }
            }
            this.f1944g = false;
        }
    }

    private static class e extends c {

        /* renamed from: b  reason: collision with root package name */
        private final Choreographer f1951b = Choreographer.getInstance();

        /* renamed from: c  reason: collision with root package name */
        private final Choreographer.FrameCallback f1952c = new Choreographer.FrameCallback() {
            public void doFrame(long j) {
                e.this.f1946a.a();
            }
        };

        e(C0040a aVar) {
            super(aVar);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f1951b.postFrameCallback(this.f1952c);
        }
    }

    private static class d extends c {

        /* renamed from: b  reason: collision with root package name */
        long f1947b = -1;

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f1948c = new Runnable() {
            public void run() {
                d.this.f1947b = SystemClock.uptimeMillis();
                d.this.f1946a.a();
            }
        };

        /* renamed from: d  reason: collision with root package name */
        private final Handler f1949d = new Handler(Looper.myLooper());

        d(C0040a aVar) {
            super(aVar);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f1949d.postDelayed(this.f1948c, Math.max(10 - (SystemClock.uptimeMillis() - this.f1947b), 0));
        }
    }

    static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        final C0040a f1946a;

        /* access modifiers changed from: package-private */
        public abstract void a();

        c(C0040a aVar) {
            this.f1946a = aVar;
        }
    }
}
