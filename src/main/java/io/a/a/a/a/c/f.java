package io.a.a.a.a.c;

import io.a.a.a.a.c.a;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public abstract class f<Params, Progress, Result> extends a<Params, Progress, Result> implements b<l>, i, l {

    /* renamed from: a  reason: collision with root package name */
    private final j f33138a = new j();

    public final void a(ExecutorService executorService, Params... paramsArr) {
        super.a((Executor) new a(executorService, this), paramsArr);
    }

    public int compareTo(Object obj) {
        return e.a(this, obj);
    }

    /* renamed from: a */
    public void c(l lVar) {
        if (G_() == a.d.PENDING) {
            ((b) ((i) g())).c(lVar);
            return;
        }
        throw new IllegalStateException("Must not add Dependency after task is running");
    }

    public Collection<l> c() {
        return ((b) ((i) g())).c();
    }

    public boolean d() {
        return ((b) ((i) g())).d();
    }

    public e b() {
        return ((i) g()).b();
    }

    public void b(boolean z) {
        ((l) ((i) g())).b(z);
    }

    public boolean f() {
        return ((l) ((i) g())).f();
    }

    public void a(Throwable th) {
        ((l) ((i) g())).a(th);
    }

    public <T extends b<l> & i & l> T g() {
        return this.f33138a;
    }

    private static class a<Result> implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private final Executor f33139a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final f f33140b;

        public a(Executor executor, f fVar) {
            this.f33139a = executor;
            this.f33140b = fVar;
        }

        public void execute(Runnable runnable) {
            this.f33139a.execute(new h<Result>(runnable, (Object) null) {
                public <T extends b<l> & i & l> T a() {
                    return a.this.f33140b;
                }
            });
        }
    }
}
