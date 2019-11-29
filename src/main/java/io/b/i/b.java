package io.b.i;

import io.b.o;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class b<T> extends c<T> {

    /* renamed from: a  reason: collision with root package name */
    static final a[] f33602a = new a[0];

    /* renamed from: b  reason: collision with root package name */
    static final a[] f33603b = new a[0];

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<a<T>[]> f33604c = new AtomicReference<>(f33603b);

    /* renamed from: d  reason: collision with root package name */
    Throwable f33605d;

    public static <T> b<T> j() {
        return new b<>();
    }

    b() {
    }

    /* access modifiers changed from: protected */
    public void b(o<? super T> oVar) {
        a aVar = new a(oVar, this);
        oVar.a((io.b.b.b) aVar);
        if (!a(aVar)) {
            Throwable th = this.f33605d;
            if (th != null) {
                oVar.a(th);
            } else {
                oVar.a();
            }
        } else if (aVar.isDisposed()) {
            b(aVar);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(a<T> aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = (a[]) this.f33604c.get();
            if (aVarArr == f33602a) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[(length + 1)];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f33604c.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void b(a<T> aVar) {
        a<T>[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = (a[]) this.f33604c.get();
            if (aVarArr != f33602a && aVarArr != f33603b) {
                int length = aVarArr.length;
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (aVarArr[i2] == aVar) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        aVarArr2 = f33603b;
                    } else {
                        a[] aVarArr3 = new a[(length - 1)];
                        System.arraycopy(aVarArr, 0, aVarArr3, 0, i);
                        System.arraycopy(aVarArr, i + 1, aVarArr3, i, (length - i) - 1);
                        aVarArr2 = aVarArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f33604c.compareAndSet(aVarArr, aVarArr2));
    }

    public void a(io.b.b.b bVar) {
        if (this.f33604c.get() == f33602a) {
            bVar.dispose();
        }
    }

    public void a(T t) {
        io.b.e.b.b.a(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (a a2 : (a[]) this.f33604c.get()) {
            a2.a(t);
        }
    }

    public void a(Throwable th) {
        io.b.e.b.b.a(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        a<T>[] aVarArr = this.f33604c.get();
        a<T>[] aVarArr2 = f33602a;
        if (aVarArr == aVarArr2) {
            io.b.g.a.a(th);
            return;
        }
        this.f33605d = th;
        for (a a2 : (a[]) this.f33604c.getAndSet(aVarArr2)) {
            a2.a(th);
        }
    }

    public void a() {
        a<T>[] aVarArr = this.f33604c.get();
        a<T>[] aVarArr2 = f33602a;
        if (aVarArr != aVarArr2) {
            for (a a2 : (a[]) this.f33604c.getAndSet(aVarArr2)) {
                a2.a();
            }
        }
    }

    static final class a<T> extends AtomicBoolean implements io.b.b.b {
        private static final long serialVersionUID = 3562861878281475070L;
        final o<? super T> actual;
        final b<T> parent;

        a(o<? super T> oVar, b<T> bVar) {
            this.actual = oVar;
            this.parent = bVar;
        }

        public void a(T t) {
            if (!get()) {
                this.actual.a(t);
            }
        }

        public void a(Throwable th) {
            if (get()) {
                io.b.g.a.a(th);
            } else {
                this.actual.a(th);
            }
        }

        public void a() {
            if (!get()) {
                this.actual.a();
            }
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.b(this);
            }
        }

        public boolean isDisposed() {
            return get();
        }
    }
}
