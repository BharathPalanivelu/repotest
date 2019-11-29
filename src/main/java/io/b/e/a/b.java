package io.b.e.a;

import io.b.c.e;
import io.b.g.a;
import java.util.concurrent.atomic.AtomicReference;

public enum b implements io.b.b.b {
    DISPOSED;

    public void dispose() {
    }

    public boolean isDisposed() {
        return true;
    }

    public static boolean isDisposed(io.b.b.b bVar) {
        return bVar == DISPOSED;
    }

    public static boolean set(AtomicReference<io.b.b.b> atomicReference, io.b.b.b bVar) {
        io.b.b.b bVar2;
        do {
            bVar2 = atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar == null) {
                    return false;
                }
                bVar.dispose();
                return false;
            }
        } while (!atomicReference.compareAndSet(bVar2, bVar));
        if (bVar2 == null) {
            return true;
        }
        bVar2.dispose();
        return true;
    }

    public static boolean setOnce(AtomicReference<io.b.b.b> atomicReference, io.b.b.b bVar) {
        io.b.e.b.b.a(bVar, "d is null");
        if (atomicReference.compareAndSet((Object) null, bVar)) {
            return true;
        }
        bVar.dispose();
        if (atomicReference.get() == DISPOSED) {
            return false;
        }
        reportDisposableSet();
        return false;
    }

    public static boolean replace(AtomicReference<io.b.b.b> atomicReference, io.b.b.b bVar) {
        io.b.b.b bVar2;
        do {
            bVar2 = atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar == null) {
                    return false;
                }
                bVar.dispose();
                return false;
            }
        } while (!atomicReference.compareAndSet(bVar2, bVar));
        return true;
    }

    public static boolean dispose(AtomicReference<io.b.b.b> atomicReference) {
        io.b.b.b bVar = atomicReference.get();
        b bVar2 = DISPOSED;
        if (bVar == bVar2) {
            return false;
        }
        io.b.b.b andSet = atomicReference.getAndSet(bVar2);
        if (andSet == bVar2) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.dispose();
        return true;
    }

    public static boolean validate(io.b.b.b bVar, io.b.b.b bVar2) {
        if (bVar2 == null) {
            a.a((Throwable) new NullPointerException("next is null"));
            return false;
        } else if (bVar == null) {
            return true;
        } else {
            bVar2.dispose();
            reportDisposableSet();
            return false;
        }
    }

    public static void reportDisposableSet() {
        a.a((Throwable) new e("Disposable already set!"));
    }

    public static boolean trySet(AtomicReference<io.b.b.b> atomicReference, io.b.b.b bVar) {
        if (atomicReference.compareAndSet((Object) null, bVar)) {
            return true;
        }
        if (atomicReference.get() != DISPOSED) {
            return false;
        }
        bVar.dispose();
        return false;
    }
}
