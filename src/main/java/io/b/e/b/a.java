package io.b.e.b;

import com.facebook.common.time.Clock;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final io.b.d.g<Object, Object> f33327a = new i();

    /* renamed from: b  reason: collision with root package name */
    public static final Runnable f33328b = new f();

    /* renamed from: c  reason: collision with root package name */
    public static final io.b.d.a f33329c = new c();

    /* renamed from: d  reason: collision with root package name */
    static final io.b.d.f<Object> f33330d = new d();

    /* renamed from: e  reason: collision with root package name */
    public static final io.b.d.f<Throwable> f33331e = new g();

    /* renamed from: f  reason: collision with root package name */
    public static final io.b.d.f<Throwable> f33332f = new n();

    /* renamed from: g  reason: collision with root package name */
    public static final io.b.d.i f33333g = new e();
    static final io.b.d.j<Object> h = new o();
    static final io.b.d.j<Object> i = new h();
    static final Callable<Object> j = new m();
    static final Comparator<Object> k = new l();
    public static final io.b.d.f<org.e.b> l = new k();

    public static <T1, T2, T3, R> io.b.d.g<Object[], R> a(io.b.d.h<T1, T2, T3, R> hVar) {
        b.a(hVar, "f is null");
        return new C0516a(hVar);
    }

    public static <T> io.b.d.g<T, T> a() {
        return f33327a;
    }

    public static <T> io.b.d.f<T> b() {
        return f33330d;
    }

    static final class j<T, U> implements io.b.d.g<T, U>, Callable<U> {

        /* renamed from: a  reason: collision with root package name */
        final U f33336a;

        j(U u) {
            this.f33336a = u;
        }

        public U call() throws Exception {
            return this.f33336a;
        }

        public U apply(T t) throws Exception {
            return this.f33336a;
        }
    }

    public static <T, U> io.b.d.g<T, U> a(U u) {
        return new j(u);
    }

    static final class b<T> implements Callable<List<T>> {

        /* renamed from: a  reason: collision with root package name */
        final int f33335a;

        b(int i) {
            this.f33335a = i;
        }

        /* renamed from: a */
        public List<T> call() throws Exception {
            return new ArrayList(this.f33335a);
        }
    }

    public static <T> Callable<List<T>> a(int i2) {
        return new b(i2);
    }

    /* renamed from: io.b.e.b.a$a  reason: collision with other inner class name */
    static final class C0516a<T1, T2, T3, R> implements io.b.d.g<Object[], R> {

        /* renamed from: a  reason: collision with root package name */
        final io.b.d.h<T1, T2, T3, R> f33334a;

        C0516a(io.b.d.h<T1, T2, T3, R> hVar) {
            this.f33334a = hVar;
        }

        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 3) {
                return this.f33334a.a(objArr[0], objArr[1], objArr[2]);
            }
            throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
        }
    }

    static final class i implements io.b.d.g<Object, Object> {
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }

        i() {
        }
    }

    static final class f implements Runnable {
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }

        f() {
        }
    }

    static final class c implements io.b.d.a {
        public void a() {
        }

        public String toString() {
            return "EmptyAction";
        }

        c() {
        }
    }

    static final class d implements io.b.d.f<Object> {
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }

        d() {
        }
    }

    static final class g implements io.b.d.f<Throwable> {
        g() {
        }

        /* renamed from: a */
        public void accept(Throwable th) {
            io.b.g.a.a(th);
        }
    }

    static final class n implements io.b.d.f<Throwable> {
        n() {
        }

        /* renamed from: a */
        public void accept(Throwable th) {
            io.b.g.a.a((Throwable) new io.b.c.d(th));
        }
    }

    static final class e implements io.b.d.i {
        e() {
        }
    }

    static final class o implements io.b.d.j<Object> {
        public boolean a(Object obj) {
            return true;
        }

        o() {
        }
    }

    static final class h implements io.b.d.j<Object> {
        public boolean a(Object obj) {
            return false;
        }

        h() {
        }
    }

    static final class m implements Callable<Object> {
        public Object call() {
            return null;
        }

        m() {
        }
    }

    static final class l implements Comparator<Object> {
        l() {
        }

        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    static final class k implements io.b.d.f<org.e.b> {
        k() {
        }

        /* renamed from: a */
        public void accept(org.e.b bVar) throws Exception {
            bVar.a(Clock.MAX_TIME);
        }
    }
}
