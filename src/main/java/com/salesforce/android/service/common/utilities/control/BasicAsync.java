package com.salesforce.android.service.common.utilities.control;

import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.functional.Function;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class BasicAsync<T> implements Async<T>, ResultReceiver<T> {
    private Set<Async.CancellationHandler> mCancellationHandlers = Collections.newSetFromMap(new ConcurrentHashMap());
    private boolean mCancelled;
    private boolean mComplete;
    private Set<Async.CompletionHandler> mCompletionHandlers = Collections.newSetFromMap(new ConcurrentHashMap());
    private Throwable mError;
    private Set<Async.ErrorHandler> mErrorHandlers = Collections.newSetFromMap(new ConcurrentHashMap());
    private T mResult;
    private Set<Async.ResultHandler<? super T>> mResultHandlers = Collections.newSetFromMap(new ConcurrentHashMap());

    public static <T> BasicAsync<T> create() {
        return new BasicAsync<>();
    }

    public static <T> BasicAsync<T> error(Throwable th) {
        return new BasicAsync().setError(th);
    }

    public static <T> BasicAsync<T> immediate(T t) {
        return new BasicAsync().setResult(t).complete();
    }

    public static <T> BasicAsync<T> immediate() {
        return new BasicAsync().complete();
    }

    @SafeVarargs
    public static <T> BasicAsync<T> all(Async<T>... asyncArr) {
        return new WaitForAllAsync(Arrays.asList(asyncArr));
    }

    public static <T> BasicAsync<T> all(List<Async<T>> list) {
        return new WaitForAllAsync(list);
    }

    public Async<T> onResult(Async.ResultHandler<? super T> resultHandler) {
        if (!this.mCancelled && this.mError == null) {
            T t = this.mResult;
            if (t != null) {
                resultHandler.handleResult(this, t);
            }
            if (!this.mComplete) {
                this.mResultHandlers.add(resultHandler);
            }
        }
        return this;
    }

    public Async<T> onError(Async.ErrorHandler errorHandler) {
        if (!this.mCancelled && !this.mComplete) {
            Throwable th = this.mError;
            if (th != null) {
                errorHandler.handleError(this, th);
            } else {
                this.mErrorHandlers.add(errorHandler);
            }
        }
        return this;
    }

    public Async<T> onComplete(Async.CompletionHandler completionHandler) {
        if (!this.mCancelled && this.mError == null) {
            if (this.mComplete) {
                completionHandler.handleComplete(this);
            } else {
                this.mCompletionHandlers.add(completionHandler);
            }
        }
        return this;
    }

    public Async<T> onCancelled(Async.CancellationHandler cancellationHandler) {
        if (!this.mComplete && this.mError == null) {
            if (this.mCancelled) {
                cancellationHandler.handleCancel(this);
            } else {
                this.mCancellationHandlers.add(cancellationHandler);
            }
        }
        return this;
    }

    public <S extends Async.ResultHandler<? super T> & Async.ErrorHandler & Async.CompletionHandler> Async<T> addHandler(S s) {
        onResult(s);
        onError((Async.ErrorHandler) s);
        onComplete((Async.CompletionHandler) s);
        return this;
    }

    public void cancel() {
        if (inProgress()) {
            this.mCancelled = true;
            for (Async.CancellationHandler handleCancel : this.mCancellationHandlers) {
                handleCancel.handleCancel(this);
            }
            this.mResultHandlers.clear();
            this.mErrorHandlers.clear();
            this.mCancellationHandlers.clear();
        }
    }

    public Async<T> removeResultHandler(Async.ResultHandler<? super T> resultHandler) {
        this.mResultHandlers.remove(resultHandler);
        return this;
    }

    public Async<T> removeErrorHandler(Async.ErrorHandler errorHandler) {
        this.mErrorHandlers.remove(errorHandler);
        return this;
    }

    public Async<T> removeCompletionHandler(Async.CompletionHandler completionHandler) {
        this.mCompletionHandlers.remove(completionHandler);
        return this;
    }

    public Async<T> removeCancellationHandler(Async.CancellationHandler cancellationHandler) {
        this.mCancellationHandlers.remove(cancellationHandler);
        return this;
    }

    public <S extends Async.ResultHandler<? super T> & Async.ErrorHandler & Async.CompletionHandler> Async<T> removeHandler(S s) {
        removeResultHandler(s);
        removeErrorHandler((Async.ErrorHandler) s);
        removeCompletionHandler((Async.CompletionHandler) s);
        return this;
    }

    public boolean isCancelled() {
        return this.mCancelled;
    }

    public boolean isComplete() {
        return this.mComplete;
    }

    public boolean hasFailed() {
        return this.mError != null;
    }

    public boolean inProgress() {
        return !isCancelled() && !isComplete() && !hasFailed();
    }

    public <S> BasicAsync<S> map(Function<? super T, ? extends S> function) {
        return new MappedAsync(this, function);
    }

    public <S> BasicAsync<S> chain(Function<? super T, ? extends Async<? extends S>> function) {
        return new ChainedAsync(this, function);
    }

    public Async<T> pipe(final ResultReceiver<? super T> resultReceiver) {
        if (resultReceiver == this) {
            return this;
        }
        addHandler(new Async.Handler<T>() {
            public void handleResult(Async<?> async, T t) {
                resultReceiver.setResult(t);
            }

            public void handleError(Async<?> async, Throwable th) {
                resultReceiver.setError(th);
            }

            public void handleComplete(Async<?> async) {
                resultReceiver.complete();
            }
        });
        return this;
    }

    public BasicAsync<T> setResult(T t) {
        if (inProgress() && t != null) {
            this.mResult = t;
            for (Async.ResultHandler<? super T> handleResult : this.mResultHandlers) {
                handleResult.handleResult(this, t);
            }
        }
        return this;
    }

    public BasicAsync<T> setError(Throwable th) {
        if (!inProgress()) {
            return this;
        }
        this.mError = th;
        for (Async.ErrorHandler handleError : this.mErrorHandlers) {
            handleError.handleError(this, th);
        }
        this.mResultHandlers.clear();
        this.mErrorHandlers.clear();
        this.mCompletionHandlers.clear();
        this.mCancellationHandlers.clear();
        return this;
    }

    public BasicAsync<T> complete() {
        if (!inProgress()) {
            return this;
        }
        this.mComplete = true;
        for (Async.CompletionHandler handleComplete : this.mCompletionHandlers) {
            handleComplete.handleComplete(this);
        }
        this.mResultHandlers.clear();
        this.mErrorHandlers.clear();
        this.mCompletionHandlers.clear();
        this.mCancellationHandlers.clear();
        return this;
    }

    private static class MappedAsync<T, S> extends BasicAsync<S> implements Async.CompletionHandler, Async.ErrorHandler, Async.ResultHandler<T> {
        private final Function<? super T, ? extends S> mFunction;
        private final BasicAsync<T> mOriginalOperation;

        public /* bridge */ /* synthetic */ Async chain(Function function) {
            return BasicAsync.super.chain(function);
        }

        public /* bridge */ /* synthetic */ ResultReceiver complete() {
            return BasicAsync.super.complete();
        }

        public /* bridge */ /* synthetic */ Async map(Function function) {
            return BasicAsync.super.map(function);
        }

        public /* bridge */ /* synthetic */ ResultReceiver setError(Throwable th) {
            return BasicAsync.super.setError(th);
        }

        public /* bridge */ /* synthetic */ ResultReceiver setResult(Object obj) {
            return BasicAsync.super.setResult(obj);
        }

        MappedAsync(BasicAsync<T> basicAsync, Function<? super T, ? extends S> function) {
            this.mOriginalOperation = basicAsync;
            this.mFunction = function;
            basicAsync.addHandler(this);
        }

        public void cancel() {
            BasicAsync.super.cancel();
            this.mOriginalOperation.cancel();
        }

        public void handleError(Async<?> async, Throwable th) {
            setError(th);
        }

        public void handleResult(Async<?> async, T t) {
            try {
                setResult(this.mFunction.apply(t));
            } catch (Throwable th) {
                setError(th);
            }
        }

        public void handleComplete(Async<?> async) {
            complete();
        }
    }

    private static class ChainedAsync<T, S> extends BasicAsync<S> implements Async.ErrorHandler, Async.ResultHandler<T> {
        private Async<? extends S> mChainedOperation;
        private final Function<? super T, ? extends Async<? extends S>> mFunction;
        private final BasicAsync<T> mOriginalOperation;

        public /* bridge */ /* synthetic */ Async chain(Function function) {
            return BasicAsync.super.chain(function);
        }

        public /* bridge */ /* synthetic */ ResultReceiver complete() {
            return BasicAsync.super.complete();
        }

        public /* bridge */ /* synthetic */ Async map(Function function) {
            return BasicAsync.super.map(function);
        }

        public /* bridge */ /* synthetic */ ResultReceiver setError(Throwable th) {
            return BasicAsync.super.setError(th);
        }

        public /* bridge */ /* synthetic */ ResultReceiver setResult(Object obj) {
            return BasicAsync.super.setResult(obj);
        }

        ChainedAsync(BasicAsync<T> basicAsync, Function<? super T, ? extends Async<? extends S>> function) {
            this.mOriginalOperation = basicAsync;
            this.mFunction = function;
            this.mOriginalOperation.onError(this);
            this.mOriginalOperation.onResult(this);
        }

        public void cancel() {
            BasicAsync.super.cancel();
            this.mOriginalOperation.cancel();
            Async<? extends S> async = this.mChainedOperation;
            if (async != null) {
                async.cancel();
            }
        }

        public void handleError(Async<?> async, Throwable th) {
            setError(th);
        }

        public void handleResult(Async<?> async, T t) {
            try {
                this.mChainedOperation = (Async) this.mFunction.apply(t);
                this.mChainedOperation.pipe(this);
            } catch (Throwable th) {
                setError(th);
            }
        }
    }

    private static class WaitForAllAsync<T> extends BasicAsync<T> implements Async.CancellationHandler, Async.CompletionHandler, Async.ErrorHandler {
        private final AtomicInteger mCompletionCount;
        private final Set<Async<?>> mOperations = new LinkedHashSet();

        public /* bridge */ /* synthetic */ Async chain(Function function) {
            return BasicAsync.super.chain(function);
        }

        public /* bridge */ /* synthetic */ ResultReceiver complete() {
            return BasicAsync.super.complete();
        }

        public /* bridge */ /* synthetic */ Async map(Function function) {
            return BasicAsync.super.map(function);
        }

        public /* bridge */ /* synthetic */ ResultReceiver setError(Throwable th) {
            return BasicAsync.super.setError(th);
        }

        public /* bridge */ /* synthetic */ ResultReceiver setResult(Object obj) {
            return BasicAsync.super.setResult(obj);
        }

        WaitForAllAsync(List<Async<T>> list) {
            this.mCompletionCount = new AtomicInteger(list.size());
            registerOps(list);
        }

        public void cancel() {
            BasicAsync.super.cancel();
            cancelAllOps();
        }

        public void handleComplete(Async<?> async) {
            if (isAllComplete()) {
                complete();
            }
        }

        public void handleError(Async<?> async, Throwable th) {
            setError(th);
            cancelAllOps();
        }

        public void handleCancel(Async<?> async) {
            cancel();
        }

        private void registerOps(List<Async<T>> list) {
            if (list.isEmpty()) {
                complete();
                return;
            }
            for (Async next : list) {
                next.onComplete(this);
                next.onError(this);
                next.onCancelled(this);
                this.mOperations.add(next);
                if (next.isComplete()) {
                    this.mCompletionCount.decrementAndGet();
                }
            }
        }

        private void cancelAllOps() {
            for (Async<?> cancel : this.mOperations) {
                cancel.cancel();
            }
        }

        private boolean isAllComplete() {
            int i = 0;
            for (Async<?> isComplete : this.mOperations) {
                if (isComplete.isComplete()) {
                    i++;
                }
            }
            if (i == this.mOperations.size()) {
                return true;
            }
            return false;
        }
    }
}
