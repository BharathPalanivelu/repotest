package io.b.h;

import io.b.e.g.k;
import io.b.e.g.l;
import io.b.p;
import java.util.concurrent.Callable;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final p f33579a = io.b.g.a.d(new h());

    /* renamed from: b  reason: collision with root package name */
    static final p f33580b = io.b.g.a.a((Callable<p>) new b());

    /* renamed from: c  reason: collision with root package name */
    static final p f33581c = io.b.g.a.b((Callable<p>) new c());

    /* renamed from: d  reason: collision with root package name */
    static final p f33582d = l.c();

    /* renamed from: e  reason: collision with root package name */
    static final p f33583e = io.b.g.a.c((Callable<p>) new f());

    /* renamed from: io.b.h.a$a  reason: collision with other inner class name */
    static final class C0524a {

        /* renamed from: a  reason: collision with root package name */
        static final p f33584a = new io.b.e.g.b();
    }

    static final class d {

        /* renamed from: a  reason: collision with root package name */
        static final p f33585a = new io.b.e.g.c();
    }

    static final class e {

        /* renamed from: a  reason: collision with root package name */
        static final p f33586a = new io.b.e.g.d();
    }

    static final class g {

        /* renamed from: a  reason: collision with root package name */
        static final p f33587a = new k();
    }

    public static p a() {
        return io.b.g.a.a(f33580b);
    }

    public static p b() {
        return io.b.g.a.b(f33581c);
    }

    static final class c implements Callable<p> {
        c() {
        }

        /* renamed from: a */
        public p call() throws Exception {
            return d.f33585a;
        }
    }

    static final class f implements Callable<p> {
        f() {
        }

        /* renamed from: a */
        public p call() throws Exception {
            return e.f33586a;
        }
    }

    static final class h implements Callable<p> {
        h() {
        }

        /* renamed from: a */
        public p call() throws Exception {
            return g.f33587a;
        }
    }

    static final class b implements Callable<p> {
        b() {
        }

        /* renamed from: a */
        public p call() throws Exception {
            return C0524a.f33584a;
        }
    }
}
