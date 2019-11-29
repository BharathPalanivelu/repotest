package io.b.e.g;

import io.b.b.b;
import io.b.e.a.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class i extends AtomicReferenceArray<Object> implements b, Runnable, Callable<Object> {

    /* renamed from: a  reason: collision with root package name */
    static final Object f33522a = new Object();

    /* renamed from: b  reason: collision with root package name */
    static final Object f33523b = new Object();

    /* renamed from: c  reason: collision with root package name */
    static final Object f33524c = new Object();

    /* renamed from: d  reason: collision with root package name */
    static final Object f33525d = new Object();
    private static final long serialVersionUID = -6120223772001106981L;
    final Runnable actual;

    public i(Runnable runnable, a aVar) {
        super(3);
        this.actual = runnable;
        lazySet(0, aVar);
    }

    public Object call() {
        run();
        return null;
    }

    public void run() {
        Object obj;
        Object obj2;
        lazySet(2, Thread.currentThread());
        try {
            this.actual.run();
        } catch (Throwable th) {
            lazySet(2, (Object) null);
            Object obj3 = get(0);
            if (!(obj3 == f33522a || !compareAndSet(0, obj3, f33525d) || obj3 == null)) {
                ((a) obj3).c(this);
            }
            do {
                obj2 = get(1);
                if (obj2 == f33523b || obj2 == f33524c) {
                    throw th;
                }
            } while (!compareAndSet(1, obj2, f33525d));
            throw th;
        }
        lazySet(2, (Object) null);
        Object obj4 = get(0);
        if (!(obj4 == f33522a || !compareAndSet(0, obj4, f33525d) || obj4 == null)) {
            ((a) obj4).c(this);
        }
        do {
            obj = get(1);
            if (obj == f33523b || obj == f33524c) {
                return;
            }
        } while (!compareAndSet(1, obj, f33525d));
    }

    public void a(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj != f33525d) {
                if (obj == f33523b) {
                    future.cancel(false);
                    return;
                } else if (obj == f33524c) {
                    future.cancel(true);
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispose() {
        /*
            r5 = this;
        L_0x0000:
            r0 = 1
            java.lang.Object r1 = r5.get(r0)
            java.lang.Object r2 = f33525d
            r3 = 0
            if (r1 == r2) goto L_0x0035
            java.lang.Object r2 = f33523b
            if (r1 == r2) goto L_0x0035
            java.lang.Object r2 = f33524c
            if (r1 != r2) goto L_0x0013
            goto L_0x0035
        L_0x0013:
            r2 = 2
            java.lang.Object r2 = r5.get(r2)
            java.lang.Thread r4 = java.lang.Thread.currentThread()
            if (r2 == r4) goto L_0x0020
            r2 = 1
            goto L_0x0021
        L_0x0020:
            r2 = 0
        L_0x0021:
            if (r2 == 0) goto L_0x0026
            java.lang.Object r4 = f33524c
            goto L_0x0028
        L_0x0026:
            java.lang.Object r4 = f33523b
        L_0x0028:
            boolean r0 = r5.compareAndSet(r0, r1, r4)
            if (r0 == 0) goto L_0x0000
            if (r1 == 0) goto L_0x0035
            java.util.concurrent.Future r1 = (java.util.concurrent.Future) r1
            r1.cancel(r2)
        L_0x0035:
            java.lang.Object r0 = r5.get(r3)
            java.lang.Object r1 = f33525d
            if (r0 == r1) goto L_0x004f
            java.lang.Object r1 = f33522a
            if (r0 == r1) goto L_0x004f
            if (r0 != 0) goto L_0x0044
            goto L_0x004f
        L_0x0044:
            boolean r1 = r5.compareAndSet(r3, r0, r1)
            if (r1 == 0) goto L_0x0035
            io.b.e.a.a r0 = (io.b.e.a.a) r0
            r0.c(r5)
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.b.e.g.i.dispose():void");
    }

    public boolean isDisposed() {
        Object obj = get(0);
        if (obj == f33522a || obj == f33525d) {
            return true;
        }
        return false;
    }
}
