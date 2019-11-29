package com.shopee.live.livestreaming.network.executor;

import android.os.Handler;

public class RetryTask extends AbstractInteractor<RetryTask.Data, RetryTask.Callback> {
    private static final long RETRY_TIMEOUT = 6000;
    private static final int RETRY_TIMES = 3;
    private Callback callback;
    private Handler handler;
    private int tryCount;

    public interface Callback {
        void onFailed();

        void onSuccess();
    }

    public RetryTask() {
        this(ThreadExecutor.getInstance());
    }

    public RetryTask(Executor executor) {
        super(executor);
        this.handler = new Handler();
        this.tryCount = 3;
    }

    public boolean handleResult(boolean z) {
        if (z) {
            this.handler.removeCallbacksAndMessages((Object) null);
            int i = this.tryCount;
            if (i <= 0) {
                this.tryCount = i - 1;
            } else {
                this.tryCount = 0;
            }
        } else {
            this.tryCount--;
        }
        if (this.tryCount == 0) {
            Callback callback2 = this.callback;
            if (callback2 != null) {
                if (z) {
                    callback2.onSuccess();
                    return true;
                }
                callback2.onFailed();
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void run(final Data data, Callback callback2) {
        final AbstractInteractor<T, C> abstractInteractor = data.task;
        if (abstractInteractor != null) {
            this.callback = callback2;
            for (int i = 0; i < 3; i++) {
                this.handler.postDelayed(new Runnable() {
                    public void run() {
                        try {
                            abstractInteractor.execute(data.t, data.f28796c);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }, ((long) i) * 6000);
            }
        }
    }

    public static class Data<T, C> {

        /* renamed from: c  reason: collision with root package name */
        C f28796c;
        T t;
        AbstractInteractor<T, C> task;

        public Data(AbstractInteractor<T, C> abstractInteractor, T t2, C c2) {
            this.task = abstractInteractor;
            this.t = t2;
            this.f28796c = c2;
        }
    }
}
