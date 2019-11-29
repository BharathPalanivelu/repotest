package androidx.g.a;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.g.a.a;
import androidx.g.b.c;
import androidx.lifecycle.h;
import androidx.lifecycle.m;
import androidx.lifecycle.n;
import androidx.lifecycle.q;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class b extends a {

    /* renamed from: a  reason: collision with root package name */
    static boolean f2296a = false;

    /* renamed from: b  reason: collision with root package name */
    private final h f2297b;

    /* renamed from: c  reason: collision with root package name */
    private final c f2298c;

    public static class a<D> extends m<D> implements c.C0052c<D> {

        /* renamed from: e  reason: collision with root package name */
        private final int f2299e;

        /* renamed from: f  reason: collision with root package name */
        private final Bundle f2300f;

        /* renamed from: g  reason: collision with root package name */
        private final androidx.g.b.c<D> f2301g;
        private h h;
        private C0050b<D> i;
        private androidx.g.b.c<D> j;

        a(int i2, Bundle bundle, androidx.g.b.c<D> cVar, androidx.g.b.c<D> cVar2) {
            this.f2299e = i2;
            this.f2300f = bundle;
            this.f2301g = cVar;
            this.j = cVar2;
            this.f2301g.a(i2, this);
        }

        /* access modifiers changed from: package-private */
        public androidx.g.b.c<D> e() {
            return this.f2301g;
        }

        /* access modifiers changed from: protected */
        public void b() {
            if (b.f2296a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.f2301g.q();
        }

        /* access modifiers changed from: protected */
        public void c() {
            if (b.f2296a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f2301g.t();
        }

        /* access modifiers changed from: package-private */
        public androidx.g.b.c<D> a(h hVar, a.C0049a<D> aVar) {
            C0050b<D> bVar = new C0050b<>(this.f2301g, aVar);
            a(hVar, bVar);
            C0050b<D> bVar2 = this.i;
            if (bVar2 != null) {
                a(bVar2);
            }
            this.h = hVar;
            this.i = bVar;
            return this.f2301g;
        }

        /* access modifiers changed from: package-private */
        public void f() {
            h hVar = this.h;
            C0050b<D> bVar = this.i;
            if (hVar != null && bVar != null) {
                super.a(bVar);
                a(hVar, bVar);
            }
        }

        public void a(n<? super D> nVar) {
            super.a(nVar);
            this.h = null;
            this.i = null;
        }

        /* access modifiers changed from: package-private */
        public androidx.g.b.c<D> a(boolean z) {
            if (b.f2296a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f2301g.r();
            this.f2301g.u();
            C0050b<D> bVar = this.i;
            if (bVar != null) {
                a(bVar);
                if (z) {
                    bVar.b();
                }
            }
            this.f2301g.a(this);
            if ((bVar == null || bVar.a()) && !z) {
                return this.f2301g;
            }
            this.f2301g.w();
            return this.j;
        }

        public void a(androidx.g.b.c<D> cVar, D d2) {
            if (b.f2296a) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                b(d2);
                return;
            }
            if (b.f2296a) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            a(d2);
        }

        public void b(D d2) {
            super.b(d2);
            androidx.g.b.c<D> cVar = this.j;
            if (cVar != null) {
                cVar.w();
                this.j = null;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f2299e);
            sb.append(" : ");
            androidx.core.util.a.a(this.f2301g, sb);
            sb.append("}}");
            return sb.toString();
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f2299e);
            printWriter.print(" mArgs=");
            printWriter.println(this.f2300f);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f2301g);
            androidx.g.b.c<D> cVar = this.f2301g;
            cVar.a(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.i != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.i);
                C0050b<D> bVar = this.i;
                bVar.a(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(e().c(a()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(d());
        }
    }

    /* renamed from: androidx.g.a.b$b  reason: collision with other inner class name */
    static class C0050b<D> implements n<D> {

        /* renamed from: a  reason: collision with root package name */
        private final androidx.g.b.c<D> f2302a;

        /* renamed from: b  reason: collision with root package name */
        private final a.C0049a<D> f2303b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f2304c = false;

        C0050b(androidx.g.b.c<D> cVar, a.C0049a<D> aVar) {
            this.f2302a = cVar;
            this.f2303b = aVar;
        }

        public void a(D d2) {
            if (b.f2296a) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f2302a + ": " + this.f2302a.c(d2));
            }
            this.f2303b.a(this.f2302a, d2);
            this.f2304c = true;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f2304c;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (this.f2304c) {
                if (b.f2296a) {
                    Log.v("LoaderManager", "  Resetting: " + this.f2302a);
                }
                this.f2303b.a(this.f2302a);
            }
        }

        public String toString() {
            return this.f2303b.toString();
        }

        public void a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f2304c);
        }
    }

    static class c extends q {

        /* renamed from: a  reason: collision with root package name */
        private static final r.a f2305a = new r.a() {
            public <T extends q> T a(Class<T> cls) {
                return new c();
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private androidx.b.h<a> f2306b = new androidx.b.h<>();

        /* renamed from: c  reason: collision with root package name */
        private boolean f2307c = false;

        c() {
        }

        static c a(s sVar) {
            return (c) new r(sVar, f2305a).a(c.class);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f2307c = true;
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            return this.f2307c;
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f2307c = false;
        }

        /* access modifiers changed from: package-private */
        public void a(int i, a aVar) {
            this.f2306b.b(i, aVar);
        }

        /* access modifiers changed from: package-private */
        public <D> a<D> a(int i) {
            return this.f2306b.a(i);
        }

        /* access modifiers changed from: package-private */
        public void f() {
            int b2 = this.f2306b.b();
            for (int i = 0; i < b2; i++) {
                this.f2306b.d(i).f();
            }
        }

        /* access modifiers changed from: protected */
        public void a() {
            super.a();
            int b2 = this.f2306b.b();
            for (int i = 0; i < b2; i++) {
                this.f2306b.d(i).a(true);
            }
            this.f2306b.c();
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f2306b.b() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.f2306b.b(); i++) {
                    a d2 = this.f2306b.d(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f2306b.c(i));
                    printWriter.print(": ");
                    printWriter.println(d2.toString());
                    d2.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    b(h hVar, s sVar) {
        this.f2297b = hVar;
        this.f2298c = c.a(sVar);
    }

    /* JADX INFO: finally extract failed */
    private <D> androidx.g.b.c<D> a(int i, Bundle bundle, a.C0049a<D> aVar, androidx.g.b.c<D> cVar) {
        try {
            this.f2298c.b();
            androidx.g.b.c<D> a2 = aVar.a(i, bundle);
            if (a2 != null) {
                if (a2.getClass().isMemberClass()) {
                    if (!Modifier.isStatic(a2.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + a2);
                    }
                }
                a aVar2 = new a(i, bundle, a2, cVar);
                if (f2296a) {
                    Log.v("LoaderManager", "  Created new loader " + aVar2);
                }
                this.f2298c.a(i, aVar2);
                this.f2298c.e();
                return aVar2.a(this.f2297b, aVar);
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        } catch (Throwable th) {
            this.f2298c.e();
            throw th;
        }
    }

    public <D> androidx.g.b.c<D> a(int i, Bundle bundle, a.C0049a<D> aVar) {
        if (this.f2298c.c()) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            a a2 = this.f2298c.a(i);
            if (f2296a) {
                Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
            }
            if (a2 == null) {
                return a(i, bundle, aVar, (androidx.g.b.c) null);
            }
            if (f2296a) {
                Log.v("LoaderManager", "  Re-using existing loader " + a2);
            }
            return a2.a(this.f2297b, aVar);
        } else {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
    }

    public void a() {
        this.f2298c.f();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        androidx.core.util.a.a(this.f2297b, sb);
        sb.append("}}");
        return sb.toString();
    }

    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f2298c.a(str, fileDescriptor, printWriter, strArr);
    }
}
