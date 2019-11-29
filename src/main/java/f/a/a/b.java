package f.a.a;

import f.d;
import f.m;
import io.b.j;
import io.b.o;

final class b<T> extends j<m<T>> {

    /* renamed from: a  reason: collision with root package name */
    private final f.b<T> f32870a;

    b(f.b<T> bVar) {
        this.f32870a = bVar;
    }

    /* access modifiers changed from: protected */
    public void b(o<? super m<T>> oVar) {
        f.b<T> d2 = this.f32870a.d();
        a aVar = new a(d2, oVar);
        oVar.a((io.b.b.b) aVar);
        d2.a(aVar);
    }

    private static final class a<T> implements d<T>, io.b.b.b {

        /* renamed from: a  reason: collision with root package name */
        boolean f32871a = false;

        /* renamed from: b  reason: collision with root package name */
        private final f.b<?> f32872b;

        /* renamed from: c  reason: collision with root package name */
        private final o<? super m<T>> f32873c;

        a(f.b<?> bVar, o<? super m<T>> oVar) {
            this.f32872b = bVar;
            this.f32873c = oVar;
        }

        public void onResponse(f.b<T> bVar, m<T> mVar) {
            if (!bVar.c()) {
                try {
                    this.f32873c.a(mVar);
                    if (!bVar.c()) {
                        this.f32871a = true;
                        this.f32873c.a();
                    }
                } catch (Throwable th) {
                    io.b.c.b.b(th);
                    io.b.g.a.a((Throwable) new io.b.c.a(th, th));
                }
            }
        }

        public void onFailure(f.b<T> bVar, Throwable th) {
            if (!bVar.c()) {
                try {
                    this.f32873c.a(th);
                } catch (Throwable th2) {
                    io.b.c.b.b(th2);
                    io.b.g.a.a((Throwable) new io.b.c.a(th, th2));
                }
            }
        }

        public void dispose() {
            this.f32872b.b();
        }

        public boolean isDisposed() {
            return this.f32872b.c();
        }
    }
}
