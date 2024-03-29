package com.facebook.imagepipeline.producers;

import com.facebook.common.logging.FLog;

public abstract class BaseConsumer<T> implements Consumer<T> {
    private boolean mIsFinished = false;

    public static boolean isLast(int i) {
        return (i & 1) == 1;
    }

    public static int simpleStatusForIsLast(boolean z) {
        return z ? 1 : 0;
    }

    public static boolean statusHasAnyFlag(int i, int i2) {
        return (i & i2) != 0;
    }

    public static boolean statusHasFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    public static int turnOffStatusFlag(int i, int i2) {
        return i & (i2 ^ -1);
    }

    public static int turnOnStatusFlag(int i, int i2) {
        return i | i2;
    }

    /* access modifiers changed from: protected */
    public abstract void onCancellationImpl();

    /* access modifiers changed from: protected */
    public abstract void onFailureImpl(Throwable th);

    /* access modifiers changed from: protected */
    public abstract void onNewResultImpl(T t, int i);

    /* access modifiers changed from: protected */
    public void onProgressUpdateImpl(float f2) {
    }

    public static boolean isNotLast(int i) {
        return !isLast(i);
    }

    public synchronized void onNewResult(T t, int i) {
        if (!this.mIsFinished) {
            this.mIsFinished = isLast(i);
            try {
                onNewResultImpl(t, i);
            } catch (Exception e2) {
                onUnhandledException(e2);
            }
        } else {
            return;
        }
        return;
    }

    public synchronized void onFailure(Throwable th) {
        if (!this.mIsFinished) {
            this.mIsFinished = true;
            try {
                onFailureImpl(th);
            } catch (Exception e2) {
                onUnhandledException(e2);
            }
        } else {
            return;
        }
        return;
    }

    public synchronized void onCancellation() {
        if (!this.mIsFinished) {
            this.mIsFinished = true;
            try {
                onCancellationImpl();
            } catch (Exception e2) {
                onUnhandledException(e2);
            }
        } else {
            return;
        }
        return;
    }

    public synchronized void onProgressUpdate(float f2) {
        if (!this.mIsFinished) {
            try {
                onProgressUpdateImpl(f2);
            } catch (Exception e2) {
                onUnhandledException(e2);
            }
        } else {
            return;
        }
    }

    /* access modifiers changed from: protected */
    public void onUnhandledException(Exception exc) {
        FLog.wtf(getClass(), "unhandled exception", (Throwable) exc);
    }
}
