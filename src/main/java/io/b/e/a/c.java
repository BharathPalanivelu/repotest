package io.b.e.a;

import io.b.b.b;
import io.b.e.c.a;
import io.b.h;
import io.b.o;
import io.b.s;

public enum c implements a<Object> {
    INSTANCE,
    NEVER;

    public void clear() {
    }

    public void dispose() {
    }

    public boolean isEmpty() {
        return true;
    }

    public Object poll() throws Exception {
        return null;
    }

    public int requestFusion(int i) {
        return i & 2;
    }

    public boolean isDisposed() {
        return this == INSTANCE;
    }

    public static void complete(o<?> oVar) {
        oVar.a((b) INSTANCE);
        oVar.a();
    }

    public static void complete(h<?> hVar) {
        hVar.a((b) INSTANCE);
        hVar.a();
    }

    public static void error(Throwable th, o<?> oVar) {
        oVar.a((b) INSTANCE);
        oVar.a(th);
    }

    public static void complete(io.b.c cVar) {
        cVar.a((b) INSTANCE);
        cVar.a();
    }

    public static void error(Throwable th, io.b.c cVar) {
        cVar.a((b) INSTANCE);
        cVar.a(th);
    }

    public static void error(Throwable th, s<?> sVar) {
        sVar.a((b) INSTANCE);
        sVar.a(th);
    }

    public static void error(Throwable th, h<?> hVar) {
        hVar.a((b) INSTANCE);
        hVar.a(th);
    }

    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
