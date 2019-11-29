package androidx.g.b;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.d.c;
import androidx.core.util.f;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public abstract class a<D> extends c<D> {

    /* renamed from: a  reason: collision with root package name */
    volatile a<D>.a f2308a;

    /* renamed from: b  reason: collision with root package name */
    volatile a<D>.a f2309b;

    /* renamed from: c  reason: collision with root package name */
    long f2310c;

    /* renamed from: d  reason: collision with root package name */
    long f2311d;

    /* renamed from: e  reason: collision with root package name */
    Handler f2312e;

    /* renamed from: f  reason: collision with root package name */
    private final Executor f2313f;

    public void a(D d2) {
    }

    public abstract D d();

    public void f() {
    }

    /* renamed from: androidx.g.b.a$a  reason: collision with other inner class name */
    final class C0051a extends d<Void, Void, D> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        boolean f2314a;

        /* renamed from: f  reason: collision with root package name */
        private final CountDownLatch f2316f = new CountDownLatch(1);

        C0051a() {
        }

        /* access modifiers changed from: protected */
        public D a(Void... voidArr) {
            try {
                return a.this.e();
            } catch (c e2) {
                if (c()) {
                    return null;
                }
                throw e2;
            }
        }

        /* access modifiers changed from: protected */
        public void a(D d2) {
            try {
                a.this.b(this, d2);
            } finally {
                this.f2316f.countDown();
            }
        }

        /* access modifiers changed from: protected */
        public void b(D d2) {
            try {
                a.this.a(this, d2);
            } finally {
                this.f2316f.countDown();
            }
        }

        public void run() {
            this.f2314a = false;
            a.this.c();
        }
    }

    public a(Context context) {
        this(context, d.f2322c);
    }

    private a(Context context, Executor executor) {
        super(context);
        this.f2311d = -10000;
        this.f2313f = executor;
    }

    /* access modifiers changed from: protected */
    public void a() {
        super.a();
        r();
        this.f2308a = new C0051a();
        c();
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        if (this.f2308a == null) {
            return false;
        }
        if (!this.r) {
            this.u = true;
        }
        if (this.f2309b != null) {
            if (this.f2308a.f2314a) {
                this.f2308a.f2314a = false;
                this.f2312e.removeCallbacks(this.f2308a);
            }
            this.f2308a = null;
            return false;
        } else if (this.f2308a.f2314a) {
            this.f2308a.f2314a = false;
            this.f2312e.removeCallbacks(this.f2308a);
            this.f2308a = null;
            return false;
        } else {
            boolean a2 = this.f2308a.a(false);
            if (a2) {
                this.f2309b = this.f2308a;
                f();
            }
            this.f2308a = null;
            return a2;
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.f2309b == null && this.f2308a != null) {
            if (this.f2308a.f2314a) {
                this.f2308a.f2314a = false;
                this.f2312e.removeCallbacks(this.f2308a);
            }
            if (this.f2310c <= 0 || SystemClock.uptimeMillis() >= this.f2311d + this.f2310c) {
                this.f2308a.a(this.f2313f, (Params[]) null);
                return;
            }
            this.f2308a.f2314a = true;
            this.f2312e.postAtTime(this.f2308a, this.f2311d + this.f2310c);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(a<D>.a aVar, D d2) {
        a(d2);
        if (this.f2309b == aVar) {
            z();
            this.f2311d = SystemClock.uptimeMillis();
            this.f2309b = null;
            l();
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public void b(a<D>.a aVar, D d2) {
        if (this.f2308a != aVar) {
            a(aVar, d2);
        } else if (o()) {
            a(d2);
        } else {
            y();
            this.f2311d = SystemClock.uptimeMillis();
            this.f2308a = null;
            b(d2);
        }
    }

    /* access modifiers changed from: protected */
    public D e() {
        return d();
    }

    public boolean g() {
        return this.f2309b != null;
    }

    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.a(str, fileDescriptor, printWriter, strArr);
        if (this.f2308a != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f2308a);
            printWriter.print(" waiting=");
            printWriter.println(this.f2308a.f2314a);
        }
        if (this.f2309b != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f2309b);
            printWriter.print(" waiting=");
            printWriter.println(this.f2309b.f2314a);
        }
        if (this.f2310c != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            f.a(this.f2310c, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            f.a(this.f2311d, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }
}
