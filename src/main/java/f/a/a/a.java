package f.a.a;

import f.m;
import io.b.b.b;
import io.b.j;
import io.b.o;

final class a<T> extends j<T> {

    /* renamed from: a  reason: collision with root package name */
    private final j<m<T>> f32867a;

    a(j<m<T>> jVar) {
        this.f32867a = jVar;
    }

    /* access modifiers changed from: protected */
    public void b(o<? super T> oVar) {
        this.f32867a.a(new C0505a(oVar));
    }

    /* renamed from: f.a.a.a$a  reason: collision with other inner class name */
    private static class C0505a<R> implements o<m<R>> {

        /* renamed from: a  reason: collision with root package name */
        private final o<? super R> f32868a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f32869b;

        C0505a(o<? super R> oVar) {
            this.f32868a = oVar;
        }

        public void a(b bVar) {
            this.f32868a.a(bVar);
        }

        public void a(m<R> mVar) {
            if (mVar.d()) {
                this.f32868a.a(mVar.e());
                return;
            }
            this.f32869b = true;
            d dVar = new d(mVar);
            try {
                this.f32868a.a((Throwable) dVar);
            } catch (Throwable th) {
                io.b.c.b.b(th);
                io.b.g.a.a((Throwable) new io.b.c.a(dVar, th));
            }
        }

        public void a() {
            if (!this.f32869b) {
                this.f32868a.a();
            }
        }

        public void a(Throwable th) {
            if (!this.f32869b) {
                this.f32868a.a(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th);
            io.b.g.a.a((Throwable) assertionError);
        }
    }
}
