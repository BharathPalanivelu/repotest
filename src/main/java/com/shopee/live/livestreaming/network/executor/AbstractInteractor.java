package com.shopee.live.livestreaming.network.executor;

import com.garena.android.appkit.f.f;

public abstract class AbstractInteractor<T, C> {
    protected Executor mThreadExecutor;

    /* access modifiers changed from: protected */
    public abstract void run(T t, C c2);

    public AbstractInteractor(Executor executor) {
        this.mThreadExecutor = executor;
    }

    public void execute(T t, C c2) {
        this.mThreadExecutor.execute(this, t, c2);
    }

    /* access modifiers changed from: protected */
    public void notify(final Runnable runnable) {
        f.a().a(new Runnable() {
            public void run() {
                runnable.run();
            }
        });
    }

    public void closeExecutor() {
        Executor executor = this.mThreadExecutor;
        if (executor != null) {
            executor.closeExcutor();
        }
    }
}
