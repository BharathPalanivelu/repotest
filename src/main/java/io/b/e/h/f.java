package io.b.e.h;

import java.util.concurrent.atomic.AtomicReference;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final Throwable f33557a = new a();

    public static RuntimeException a(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        } else if (th instanceof RuntimeException) {
            return (RuntimeException) th;
        } else {
            return new RuntimeException(th);
        }
    }

    public static <T> boolean a(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable th2;
        Throwable th3;
        do {
            th2 = atomicReference.get();
            if (th2 == f33557a) {
                return false;
            }
            if (th2 == null) {
                th3 = th;
            } else {
                th3 = new io.b.c.a(th2, th);
            }
        } while (!atomicReference.compareAndSet(th2, th3));
        return true;
    }

    public static <T> Throwable a(AtomicReference<Throwable> atomicReference) {
        Throwable th = atomicReference.get();
        Throwable th2 = f33557a;
        return th != th2 ? atomicReference.getAndSet(th2) : th;
    }

    static final class a extends Throwable {
        private static final long serialVersionUID = -4649703670690200604L;

        public Throwable fillInStackTrace() {
            return this;
        }

        a() {
            super("No further exceptions");
        }
    }
}
