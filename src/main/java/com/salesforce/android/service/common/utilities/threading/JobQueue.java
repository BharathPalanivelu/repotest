package com.salesforce.android.service.common.utilities.threading;

import android.os.Handler;
import android.os.Looper;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.control.ResultReceiver;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class JobQueue {
    private static final Executor DEFAULT_EXECUTOR = Executors.newCachedThreadPool(PriorityThreadFactory.background());
    public static Executor EXECUTOR_OVERRIDE;
    private final Executor mExecutor;
    private final HandlerFactory mHandlerFactory;

    public JobQueue() {
        this(DEFAULT_EXECUTOR, new HandlerFactory());
    }

    public JobQueue(Executor executor) {
        this(executor, new HandlerFactory());
    }

    JobQueue(Executor executor, HandlerFactory handlerFactory) {
        Executor executor2 = EXECUTOR_OVERRIDE;
        this.mExecutor = executor2 != null ? executor2 : executor;
        this.mHandlerFactory = handlerFactory;
    }

    public <T> Async<T> add(Job<T> job) {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            return add(job, myLooper);
        }
        throw new IllegalStateException("Cannot add jobs on a thread without a looper");
    }

    public <T> Async<T> add(Job<T> job, Looper looper) {
        return add(job, this.mHandlerFactory.createHandler(looper));
    }

    public <T> Async<T> add(Job<T> job, Handler handler) {
        JobAsync jobAsync = new JobAsync(handler);
        this.mExecutor.execute(new JobRunner(job, jobAsync));
        return jobAsync;
    }

    public void add(Runnable runnable) {
        this.mExecutor.execute(runnable);
    }

    static class JobRunner<T> implements Runnable {
        final Job<T> mJob;
        final ResultReceiver<T> mResultReceiver;

        JobRunner(Job<T> job, ResultReceiver<T> resultReceiver) {
            this.mJob = job;
            this.mResultReceiver = resultReceiver;
        }

        public void run() {
            try {
                this.mJob.execute(this.mResultReceiver);
            } catch (Throwable th) {
                this.mResultReceiver.setError(th);
            }
        }
    }

    static class JobAsync<T> extends BasicAsync<T> {
        final Handler mHandler;

        JobAsync(Handler handler) {
            this.mHandler = handler;
        }

        public BasicAsync<T> setResult(final T t) {
            if (this.mHandler.getLooper().equals(Looper.myLooper())) {
                super.setResult(t);
            } else {
                this.mHandler.post(new Runnable() {
                    public void run() {
                        BasicAsync unused = JobAsync.super.setResult(t);
                    }
                });
            }
            return this;
        }

        public BasicAsync<T> setError(final Throwable th) {
            if (this.mHandler.getLooper().equals(Looper.myLooper())) {
                super.setError(th);
            } else {
                this.mHandler.post(new Runnable() {
                    public void run() {
                        BasicAsync unused = JobAsync.super.setError(th);
                    }
                });
            }
            return this;
        }

        public BasicAsync<T> complete() {
            if (this.mHandler.getLooper().equals(Looper.myLooper())) {
                super.complete();
            } else {
                this.mHandler.post(new Runnable() {
                    public void run() {
                        BasicAsync unused = JobAsync.super.complete();
                    }
                });
            }
            return this;
        }
    }

    public static class HandlerFactory {
        public Handler createHandler(Looper looper) {
            return new Handler(looper);
        }
    }
}
