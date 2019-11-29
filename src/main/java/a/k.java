package a;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class k<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public static final ExecutorService f376a = d.a();

    /* renamed from: b  reason: collision with root package name */
    public static final Executor f377b = a.b();

    /* renamed from: c  reason: collision with root package name */
    private static final Executor f378c = d.c();

    /* renamed from: d  reason: collision with root package name */
    private static volatile b f379d;
    private static k<?> m = new k<>((Object) null);
    private static k<Boolean> n = new k<>(true);
    private static k<Boolean> o = new k<>(false);
    private static k<?> p = new k<>(true);

    /* renamed from: e  reason: collision with root package name */
    private final Object f380e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private boolean f381f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f382g;
    private TResult h;
    private Exception i;
    private boolean j;
    private m k;
    private List<h<TResult, Void>> l = new ArrayList();

    public interface b {
        void a(k<?> kVar, n nVar);
    }

    public static b a() {
        return f379d;
    }

    k() {
    }

    private k(TResult tresult) {
        b(tresult);
    }

    private k(boolean z) {
        if (z) {
            j();
        } else {
            b((Object) null);
        }
    }

    public static <TResult> k<TResult>.a b() {
        k kVar = new k();
        kVar.getClass();
        return new a();
    }

    public boolean c() {
        boolean z;
        synchronized (this.f380e) {
            z = this.f381f;
        }
        return z;
    }

    public boolean d() {
        boolean z;
        synchronized (this.f380e) {
            z = this.f382g;
        }
        return z;
    }

    public boolean e() {
        boolean z;
        synchronized (this.f380e) {
            z = g() != null;
        }
        return z;
    }

    public TResult f() {
        TResult tresult;
        synchronized (this.f380e) {
            tresult = this.h;
        }
        return tresult;
    }

    public Exception g() {
        Exception exc;
        synchronized (this.f380e) {
            if (this.i != null) {
                this.j = true;
                if (this.k != null) {
                    this.k.a();
                    this.k = null;
                }
            }
            exc = this.i;
        }
        return exc;
    }

    public void h() throws InterruptedException {
        synchronized (this.f380e) {
            if (!c()) {
                this.f380e.wait();
            }
        }
    }

    public static <TResult> k<TResult> a(TResult tresult) {
        if (tresult == null) {
            return m;
        }
        if (tresult instanceof Boolean) {
            return ((Boolean) tresult).booleanValue() ? n : o;
        }
        l lVar = new l();
        lVar.b(tresult);
        return lVar.a();
    }

    public static <TResult> k<TResult> a(Exception exc) {
        l lVar = new l();
        lVar.b(exc);
        return lVar.a();
    }

    public static <TResult> k<TResult> i() {
        return p;
    }

    public static <TResult> k<TResult> a(Callable<TResult> callable) {
        return a(callable, (Executor) f376a, (e) null);
    }

    public static <TResult> k<TResult> a(Callable<TResult> callable, Executor executor) {
        return a(callable, executor, (e) null);
    }

    public static <TResult> k<TResult> a(final Callable<TResult> callable, Executor executor, final e eVar) {
        final l lVar = new l();
        try {
            executor.execute(new Runnable() {
                public void run() {
                    e eVar = eVar;
                    if (eVar == null || !eVar.a()) {
                        try {
                            lVar.b(callable.call());
                        } catch (CancellationException unused) {
                            lVar.c();
                        } catch (Exception e2) {
                            lVar.b(e2);
                        }
                    } else {
                        lVar.c();
                    }
                }
            });
        } catch (Exception e2) {
            lVar.b((Exception) new i(e2));
        }
        return lVar.a();
    }

    public static <TResult> k<TResult> b(Callable<TResult> callable) {
        return a(callable, f378c, (e) null);
    }

    public <TContinuationResult> k<TContinuationResult> a(h<TResult, TContinuationResult> hVar, Executor executor) {
        return a(hVar, executor, (e) null);
    }

    public <TContinuationResult> k<TContinuationResult> a(h<TResult, TContinuationResult> hVar, Executor executor, e eVar) {
        boolean c2;
        l lVar = new l();
        synchronized (this.f380e) {
            c2 = c();
            if (!c2) {
                final l lVar2 = lVar;
                final h<TResult, TContinuationResult> hVar2 = hVar;
                final Executor executor2 = executor;
                final e eVar2 = eVar;
                this.l.add(new h<TResult, Void>() {
                    /* renamed from: a */
                    public Void then(k<TResult> kVar) {
                        k.c(lVar2, hVar2, kVar, executor2, eVar2);
                        return null;
                    }
                });
            }
        }
        if (c2) {
            c(lVar, hVar, this, executor, eVar);
        }
        return lVar.a();
    }

    public <TContinuationResult> k<TContinuationResult> a(h<TResult, TContinuationResult> hVar) {
        return a(hVar, f378c, (e) null);
    }

    public <TContinuationResult> k<TContinuationResult> b(h<TResult, k<TContinuationResult>> hVar, Executor executor) {
        return b(hVar, executor, (e) null);
    }

    public <TContinuationResult> k<TContinuationResult> b(h<TResult, k<TContinuationResult>> hVar, Executor executor, e eVar) {
        boolean c2;
        l lVar = new l();
        synchronized (this.f380e) {
            c2 = c();
            if (!c2) {
                final l lVar2 = lVar;
                final h<TResult, k<TContinuationResult>> hVar2 = hVar;
                final Executor executor2 = executor;
                final e eVar2 = eVar;
                this.l.add(new h<TResult, Void>() {
                    /* renamed from: a */
                    public Void then(k<TResult> kVar) {
                        k.d(lVar2, hVar2, kVar, executor2, eVar2);
                        return null;
                    }
                });
            }
        }
        if (c2) {
            d(lVar, hVar, this, executor, eVar);
        }
        return lVar.a();
    }

    public <TContinuationResult> k<TContinuationResult> b(h<TResult, k<TContinuationResult>> hVar) {
        return b(hVar, f378c, (e) null);
    }

    public <TContinuationResult> k<TContinuationResult> c(final h<TResult, TContinuationResult> hVar, Executor executor, final e eVar) {
        return b(new h<TResult, k<TContinuationResult>>() {
            /* renamed from: a */
            public k<TContinuationResult> then(k<TResult> kVar) {
                e eVar = eVar;
                if (eVar != null && eVar.a()) {
                    return k.i();
                }
                if (kVar.e()) {
                    return k.a(kVar.g());
                }
                if (kVar.d()) {
                    return k.i();
                }
                return kVar.a((h<TResult, TContinuationResult>) hVar);
            }
        }, executor);
    }

    public <TContinuationResult> k<TContinuationResult> c(h<TResult, TContinuationResult> hVar) {
        return c(hVar, f378c, (e) null);
    }

    /* access modifiers changed from: private */
    public static <TContinuationResult, TResult> void c(final l<TContinuationResult> lVar, final h<TResult, TContinuationResult> hVar, final k<TResult> kVar, Executor executor, final e eVar) {
        try {
            executor.execute(new Runnable() {
                public void run() {
                    e eVar = eVar;
                    if (eVar == null || !eVar.a()) {
                        try {
                            lVar.b(hVar.then(kVar));
                        } catch (CancellationException unused) {
                            lVar.c();
                        } catch (Exception e2) {
                            lVar.b(e2);
                        }
                    } else {
                        lVar.c();
                    }
                }
            });
        } catch (Exception e2) {
            lVar.b((Exception) new i(e2));
        }
    }

    /* access modifiers changed from: private */
    public static <TContinuationResult, TResult> void d(final l<TContinuationResult> lVar, final h<TResult, k<TContinuationResult>> hVar, final k<TResult> kVar, Executor executor, final e eVar) {
        try {
            executor.execute(new Runnable() {
                public void run() {
                    e eVar = eVar;
                    if (eVar == null || !eVar.a()) {
                        try {
                            k kVar = (k) hVar.then(kVar);
                            if (kVar == null) {
                                lVar.b(null);
                            } else {
                                kVar.a(new h<TContinuationResult, Void>() {
                                    /* renamed from: a */
                                    public Void then(k<TContinuationResult> kVar) {
                                        if (eVar == null || !eVar.a()) {
                                            if (kVar.d()) {
                                                lVar.c();
                                            } else if (kVar.e()) {
                                                lVar.b(kVar.g());
                                            } else {
                                                lVar.b(kVar.f());
                                            }
                                            return null;
                                        }
                                        lVar.c();
                                        return null;
                                    }
                                });
                            }
                        } catch (CancellationException unused) {
                            lVar.c();
                        } catch (Exception e2) {
                            lVar.b(e2);
                        }
                    } else {
                        lVar.c();
                    }
                }
            });
        } catch (Exception e2) {
            lVar.b((Exception) new i(e2));
        }
    }

    private void k() {
        synchronized (this.f380e) {
            for (h then : this.l) {
                try {
                    then.then(this);
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
            this.l = null;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        synchronized (this.f380e) {
            if (this.f381f) {
                return false;
            }
            this.f381f = true;
            this.f382g = true;
            this.f380e.notifyAll();
            k();
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(TResult tresult) {
        synchronized (this.f380e) {
            if (this.f381f) {
                return false;
            }
            this.f381f = true;
            this.h = tresult;
            this.f380e.notifyAll();
            k();
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(java.lang.Exception r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f380e
            monitor-enter(r0)
            boolean r1 = r3.f381f     // Catch:{ all -> 0x002c }
            r2 = 0
            if (r1 == 0) goto L_0x000a
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
            return r2
        L_0x000a:
            r1 = 1
            r3.f381f = r1     // Catch:{ all -> 0x002c }
            r3.i = r4     // Catch:{ all -> 0x002c }
            r3.j = r2     // Catch:{ all -> 0x002c }
            java.lang.Object r4 = r3.f380e     // Catch:{ all -> 0x002c }
            r4.notifyAll()     // Catch:{ all -> 0x002c }
            r3.k()     // Catch:{ all -> 0x002c }
            boolean r4 = r3.j     // Catch:{ all -> 0x002c }
            if (r4 != 0) goto L_0x002a
            a.k$b r4 = a()     // Catch:{ all -> 0x002c }
            if (r4 == 0) goto L_0x002a
            a.m r4 = new a.m     // Catch:{ all -> 0x002c }
            r4.<init>(r3)     // Catch:{ all -> 0x002c }
            r3.k = r4     // Catch:{ all -> 0x002c }
        L_0x002a:
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
            return r1
        L_0x002c:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a.k.b(java.lang.Exception):boolean");
    }

    public class a extends l<TResult> {
        a() {
        }
    }
}
