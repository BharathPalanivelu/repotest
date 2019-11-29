package com.yanzhenjie.zbar;

import java.util.AbstractCollection;
import java.util.Iterator;

public class SymbolSet extends AbstractCollection<Symbol> {
    private long peer;

    private native void destroy(long j);

    private native long firstSymbol(long j);

    private static native void init();

    public native int size();

    static {
        System.loadLibrary("zbar");
        init();
    }

    SymbolSet(long j) {
        this.peer = j;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        destroy();
    }

    public synchronized void destroy() {
        if (this.peer != 0) {
            destroy(this.peer);
            this.peer = 0;
        }
    }

    public Iterator<Symbol> iterator() {
        long firstSymbol = firstSymbol(this.peer);
        if (firstSymbol == 0) {
            return new a((Symbol) null);
        }
        return new a(new Symbol(firstSymbol));
    }
}
