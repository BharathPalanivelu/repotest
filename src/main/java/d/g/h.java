package d.g;

import d.d.a.b;
import d.d.b.j;
import java.util.Iterator;

public final class h<T, R> implements a<R> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a<T> f32684a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final b<T, R> f32685b;

    public static final class a implements Iterator<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f32686a;

        /* renamed from: b  reason: collision with root package name */
        private final Iterator<T> f32687b;

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a(h hVar) {
            this.f32686a = hVar;
            this.f32687b = hVar.f32684a.a();
        }

        public R next() {
            return this.f32686a.f32685b.a(this.f32687b.next());
        }

        public boolean hasNext() {
            return this.f32687b.hasNext();
        }
    }

    public h(a<? extends T> aVar, b<? super T, ? extends R> bVar) {
        j.b(aVar, "sequence");
        j.b(bVar, "transformer");
        this.f32684a = aVar;
        this.f32685b = bVar;
    }

    public Iterator<R> a() {
        return new a(this);
    }
}
