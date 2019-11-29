package io.b.e.e.d;

import io.b.d.g;
import io.b.e.a.c;
import io.b.j;
import io.b.m;
import io.b.o;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public final class q {
    public static <T, R> boolean a(m<T> mVar, o<? super R> oVar, g<? super T, ? extends m<? extends R>> gVar) {
        if (!(mVar instanceof Callable)) {
            return false;
        }
        try {
            Object call = ((Callable) mVar).call();
            if (call == null) {
                c.complete((o<?>) oVar);
                return true;
            }
            try {
                m mVar2 = (m) io.b.e.b.b.a(gVar.apply(call), "The mapper returned a null ObservableSource");
                if (mVar2 instanceof Callable) {
                    try {
                        Object call2 = ((Callable) mVar2).call();
                        if (call2 == null) {
                            c.complete((o<?>) oVar);
                            return true;
                        }
                        a aVar = new a(oVar, call2);
                        oVar.a((io.b.b.b) aVar);
                        aVar.run();
                    } catch (Throwable th) {
                        io.b.c.b.b(th);
                        c.error(th, (o<?>) oVar);
                        return true;
                    }
                } else {
                    mVar2.a(oVar);
                }
                return true;
            } catch (Throwable th2) {
                io.b.c.b.b(th2);
                c.error(th2, (o<?>) oVar);
                return true;
            }
        } catch (Throwable th3) {
            io.b.c.b.b(th3);
            c.error(th3, (o<?>) oVar);
            return true;
        }
    }

    public static <T, U> j<U> a(T t, g<? super T, ? extends m<? extends U>> gVar) {
        return io.b.g.a.a(new b(t, gVar));
    }

    static final class b<T, R> extends j<R> {

        /* renamed from: a  reason: collision with root package name */
        final T f33435a;

        /* renamed from: b  reason: collision with root package name */
        final g<? super T, ? extends m<? extends R>> f33436b;

        b(T t, g<? super T, ? extends m<? extends R>> gVar) {
            this.f33435a = t;
            this.f33436b = gVar;
        }

        public void b(o<? super R> oVar) {
            try {
                m mVar = (m) io.b.e.b.b.a(this.f33436b.apply(this.f33435a), "The mapper returned a null ObservableSource");
                if (mVar instanceof Callable) {
                    try {
                        Object call = ((Callable) mVar).call();
                        if (call == null) {
                            c.complete((o<?>) oVar);
                            return;
                        }
                        a aVar = new a(oVar, call);
                        oVar.a((io.b.b.b) aVar);
                        aVar.run();
                    } catch (Throwable th) {
                        io.b.c.b.b(th);
                        c.error(th, (o<?>) oVar);
                    }
                } else {
                    mVar.a(oVar);
                }
            } catch (Throwable th2) {
                c.error(th2, (o<?>) oVar);
            }
        }
    }

    public static final class a<T> extends AtomicInteger implements io.b.e.c.a<T>, Runnable {
        private static final long serialVersionUID = 3880992722410194083L;
        final o<? super T> observer;
        final T value;

        public a(o<? super T> oVar, T t) {
            this.observer = oVar;
            this.value = t;
        }

        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        public T poll() throws Exception {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.value;
        }

        public boolean isEmpty() {
            return get() != 1;
        }

        public void clear() {
            lazySet(3);
        }

        public void dispose() {
            set(3);
        }

        public boolean isDisposed() {
            return get() == 3;
        }

        public int requestFusion(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            lazySet(1);
            return 1;
        }

        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.observer.a(this.value);
                if (get() == 2) {
                    lazySet(3);
                    this.observer.a();
                }
            }
        }
    }
}
