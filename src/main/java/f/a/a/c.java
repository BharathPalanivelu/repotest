package f.a.a;

import f.b;
import f.m;
import io.b.j;
import io.b.o;

final class c<T> extends j<m<T>> {

    /* renamed from: a  reason: collision with root package name */
    private final b<T> f32874a;

    c(b<T> bVar) {
        this.f32874a = bVar;
    }

    /* access modifiers changed from: protected */
    public void b(o<? super m<T>> oVar) {
        boolean z;
        b<T> d2 = this.f32874a.d();
        oVar.a((io.b.b.b) new a(d2));
        try {
            m<T> a2 = d2.a();
            if (!d2.c()) {
                oVar.a(a2);
            }
            if (!d2.c()) {
                try {
                    oVar.a();
                } catch (Throwable th) {
                    th = th;
                    z = true;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
            io.b.c.b.b(th);
            if (z) {
                io.b.g.a.a(th);
            } else if (!d2.c()) {
                try {
                    oVar.a(th);
                } catch (Throwable th3) {
                    io.b.c.b.b(th3);
                    io.b.g.a.a((Throwable) new io.b.c.a(th, th3));
                }
            }
        }
    }

    private static final class a implements io.b.b.b {

        /* renamed from: a  reason: collision with root package name */
        private final b<?> f32875a;

        a(b<?> bVar) {
            this.f32875a = bVar;
        }

        public void dispose() {
            this.f32875a.b();
        }

        public boolean isDisposed() {
            return this.f32875a.c();
        }
    }
}
