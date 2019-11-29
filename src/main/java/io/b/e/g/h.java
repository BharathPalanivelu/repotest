package io.b.e.g;

import java.util.concurrent.Callable;

public final class h extends a implements Callable<Void> {
    private static final long serialVersionUID = 1811839108042568751L;

    public h(Runnable runnable) {
        super(runnable);
    }

    /* renamed from: a */
    public Void call() throws Exception {
        this.runner = Thread.currentThread();
        try {
            this.runnable.run();
            return null;
        } finally {
            lazySet(f33485a);
            this.runner = null;
        }
    }
}
