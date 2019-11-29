package f.a.a;

import f.m;
import io.b.b.b;
import io.b.j;
import io.b.o;

final class f<T> extends j<e<T>> {

    /* renamed from: a  reason: collision with root package name */
    private final j<m<T>> f32878a;

    f(j<m<T>> jVar) {
        this.f32878a = jVar;
    }

    /* access modifiers changed from: protected */
    public void b(o<? super e<T>> oVar) {
        this.f32878a.a(new a(oVar));
    }

    private static class a<R> implements o<m<R>> {

        /* renamed from: a  reason: collision with root package name */
        private final o<? super e<R>> f32879a;

        a(o<? super e<R>> oVar) {
            this.f32879a = oVar;
        }

        public void a(b bVar) {
            this.f32879a.a(bVar);
        }

        public void a(m<R> mVar) {
            this.f32879a.a(e.a(mVar));
        }

        public void a(Throwable th) {
            try {
                this.f32879a.a(e.a(th));
                this.f32879a.a();
            } catch (Throwable th2) {
                io.b.c.b.b(th2);
                io.b.g.a.a((Throwable) new io.b.c.a(th, th2));
            }
        }

        public void a() {
            this.f32879a.a();
        }
    }
}
