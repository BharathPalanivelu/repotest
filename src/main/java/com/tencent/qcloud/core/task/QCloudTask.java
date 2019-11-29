package com.tencent.qcloud.core.task;

import a.g;
import a.h;
import a.k;
import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.common.QCloudProgressListener;
import com.tencent.qcloud.core.common.QCloudResultListener;
import com.tencent.qcloud.core.common.QCloudServiceException;
import com.tencent.qcloud.core.logger.QCloudLogger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class QCloudTask<T> implements Callable<T> {
    private final String identifier;
    private g mCancellationTokenSource;
    private AtomicBoolean mIsExecuting = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public Set<QCloudProgressListener> mProgressListeners = new HashSet(2);
    private Set<QCloudResultListener<T>> mResultListeners = new HashSet(2);
    private k<T> mTask;
    /* access modifiers changed from: private */
    public Executor observerExecutor;
    private final Object tag;
    private TaskManager taskManager;
    /* access modifiers changed from: private */
    public Executor workerExecutor;

    /* access modifiers changed from: protected */
    public abstract T execute() throws QCloudClientException, QCloudServiceException;

    public QCloudTask(String str, Object obj) {
        this.identifier = str;
        this.tag = obj;
        this.taskManager = TaskManager.getInstance();
    }

    public final k<T> cast() {
        return this.mTask;
    }

    public final T executeNow() throws QCloudClientException, QCloudServiceException {
        executeNowSilently();
        Exception exception = getException();
        if (exception instanceof QCloudClientException) {
            throw ((QCloudClientException) exception);
        } else if (!(exception instanceof QCloudServiceException)) {
            return getResult();
        } else {
            throw ((QCloudServiceException) exception);
        }
    }

    public final void executeNowSilently() {
        this.taskManager.add(this);
        this.mTask = k.b(this);
    }

    /* access modifiers changed from: protected */
    public QCloudTask<T> scheduleOn(Executor executor) {
        return scheduleOn(executor, (g) null);
    }

    /* access modifiers changed from: protected */
    public QCloudTask<T> scheduleOn(Executor executor, g gVar) {
        this.taskManager.add(this);
        this.workerExecutor = executor;
        this.mCancellationTokenSource = gVar;
        g gVar2 = this.mCancellationTokenSource;
        this.mTask = k.a(this, executor, gVar2 != null ? gVar2.b() : null);
        this.mTask.b(new h<T, k<Void>>() {
            public k<Void> then(k<T> kVar) throws Exception {
                Executor access$000 = QCloudTask.this.observerExecutor != null ? QCloudTask.this.observerExecutor : QCloudTask.this.workerExecutor;
                return (kVar.e() || kVar.d()) ? k.a(new Callable<Void>() {
                    public Void call() throws Exception {
                        QCloudTask.this.onFailure();
                        return null;
                    }
                }, access$000) : k.a(new Callable<Void>() {
                    public Void call() throws Exception {
                        QCloudTask.this.onSuccess();
                        return null;
                    }
                }, access$000);
            }
        });
        return this;
    }

    public void cancel() {
        QCloudLogger.d("QCloudTask", "[Call] %s cancel", this);
        g gVar = this.mCancellationTokenSource;
        if (gVar != null) {
            gVar.c();
        }
    }

    public final boolean isCanceled() {
        g gVar = this.mCancellationTokenSource;
        return gVar != null && gVar.a();
    }

    public final boolean isExecuting() {
        return this.mTask != null && this.mIsExecuting.get();
    }

    public final boolean isCompleted() {
        k<T> kVar = this.mTask;
        return kVar != null && kVar.c();
    }

    public T call() throws Exception {
        try {
            QCloudLogger.d("QCloudTask", "[Task] %s start execute", getIdentifier());
            this.mIsExecuting.compareAndSet(false, true);
            return execute();
        } finally {
            QCloudLogger.d("QCloudTask", "[Task] %s complete", getIdentifier());
            this.taskManager.remove(this);
        }
    }

    public final QCloudTask<T> observeOn(Executor executor) {
        this.observerExecutor = executor;
        return this;
    }

    public final QCloudTask<T> addResultListener(QCloudResultListener<T> qCloudResultListener) {
        if (qCloudResultListener != null) {
            this.mResultListeners.add(qCloudResultListener);
        }
        return this;
    }

    public final QCloudTask<T> addResultListeners(List<QCloudResultListener<T>> list) {
        if (list != null) {
            this.mResultListeners.addAll(list);
        }
        return this;
    }

    public final QCloudTask<T> removeResultListener(QCloudResultListener<T> qCloudResultListener) {
        if (qCloudResultListener != null) {
            this.mResultListeners.remove(qCloudResultListener);
        }
        return this;
    }

    public final void removeAllListeners() {
        this.mResultListeners.clear();
        this.mProgressListeners.clear();
    }

    public final List<QCloudResultListener<T>> getAllResultListeners() {
        return new ArrayList(this.mResultListeners);
    }

    public final List<QCloudProgressListener> getAllProgressListeners() {
        return new ArrayList(this.mProgressListeners);
    }

    public final QCloudTask<T> addProgressListener(QCloudProgressListener qCloudProgressListener) {
        if (qCloudProgressListener != null) {
            this.mProgressListeners.add(qCloudProgressListener);
        }
        return this;
    }

    public final QCloudTask<T> addProgressListeners(List<QCloudProgressListener> list) {
        if (list != null) {
            this.mProgressListeners.addAll(list);
        }
        return this;
    }

    public final QCloudTask<T> removeProgressListener(QCloudProgressListener qCloudProgressListener) {
        if (qCloudProgressListener != null) {
            this.mProgressListeners.remove(qCloudProgressListener);
        }
        return this;
    }

    public T getResult() {
        return this.mTask.f();
    }

    public Exception getException() {
        if (this.mTask.e()) {
            return this.mTask.g();
        }
        if (this.mTask.d()) {
            return new QCloudClientException("canceled");
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onSuccess() {
        if (this.mResultListeners.size() > 0) {
            for (QCloudResultListener onSuccess : new ArrayList(this.mResultListeners)) {
                onSuccess.onSuccess(getResult());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFailure() {
        Exception exception = getException();
        if (exception != null && this.mResultListeners.size() > 0) {
            for (QCloudResultListener qCloudResultListener : new ArrayList(this.mResultListeners)) {
                if (exception instanceof QCloudClientException) {
                    qCloudResultListener.onFailure((QCloudClientException) exception, (QCloudServiceException) null);
                } else {
                    qCloudResultListener.onFailure((QCloudClientException) null, (QCloudServiceException) exception);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onProgress(long j, long j2) {
        if (this.mProgressListeners.size() > 0) {
            final long j3 = j;
            final long j4 = j2;
            executeListener(new Runnable() {
                public void run() {
                    for (QCloudProgressListener onProgress : new ArrayList(QCloudTask.this.mProgressListeners)) {
                        onProgress.onProgress(j3, j4);
                    }
                }
            });
        }
    }

    private void executeListener(Runnable runnable) {
        Executor executor = this.observerExecutor;
        if (executor != null) {
            executor.execute(runnable);
        } else {
            runnable.run();
        }
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final Object getTag() {
        return this.tag;
    }
}
