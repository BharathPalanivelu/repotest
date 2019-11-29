package io.b.e.e.d;

import io.b.b.b;
import io.b.e.d.c;
import io.b.o;

public final class j<T> extends io.b.j<T> {

    /* renamed from: a  reason: collision with root package name */
    final T[] f33412a;

    public j(T[] tArr) {
        this.f33412a = tArr;
    }

    public void b(o<? super T> oVar) {
        a aVar = new a(oVar, this.f33412a);
        oVar.a((b) aVar);
        if (!aVar.f33416d) {
            aVar.a();
        }
    }

    static final class a<T> extends c<T> {

        /* renamed from: a  reason: collision with root package name */
        final o<? super T> f33413a;

        /* renamed from: b  reason: collision with root package name */
        final T[] f33414b;

        /* renamed from: c  reason: collision with root package name */
        int f33415c;

        /* renamed from: d  reason: collision with root package name */
        boolean f33416d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f33417e;

        a(o<? super T> oVar, T[] tArr) {
            this.f33413a = oVar;
            this.f33414b = tArr;
        }

        public int requestFusion(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            this.f33416d = true;
            return 1;
        }

        public T poll() {
            int i = this.f33415c;
            T[] tArr = this.f33414b;
            if (i == tArr.length) {
                return null;
            }
            this.f33415c = i + 1;
            return io.b.e.b.b.a(tArr[i], "The array element is null");
        }

        public boolean isEmpty() {
            return this.f33415c == this.f33414b.length;
        }

        public void clear() {
            this.f33415c = this.f33414b.length;
        }

        public void dispose() {
            this.f33417e = true;
        }

        public boolean isDisposed() {
            return this.f33417e;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            T[] tArr = this.f33414b;
            int length = tArr.length;
            for (int i = 0; i < length && !isDisposed(); i++) {
                T t = tArr[i];
                if (t == null) {
                    o<? super T> oVar = this.f33413a;
                    oVar.a((Throwable) new NullPointerException("The " + i + "th element is null"));
                    return;
                }
                this.f33413a.a(t);
            }
            if (!isDisposed()) {
                this.f33413a.a();
            }
        }
    }
}
