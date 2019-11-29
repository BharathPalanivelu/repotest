package io.b.b;

import com.litesuits.orm.db.assit.SQLBuilder;

final class e extends d<Runnable> {
    private static final long serialVersionUID = -8219729196779211169L;

    e(Runnable runnable) {
        super(runnable);
    }

    /* access modifiers changed from: protected */
    public void a(Runnable runnable) {
        runnable.run();
    }

    public String toString() {
        return "RunnableDisposable(disposed=" + isDisposed() + ", " + get() + SQLBuilder.PARENTHESES_RIGHT;
    }
}
