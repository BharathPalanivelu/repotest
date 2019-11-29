package com.salesforce.android.service.common.utilities.control;

import com.salesforce.android.service.common.utilities.functional.Function;

public interface Async<T> {

    public interface CancellationHandler {
        void handleCancel(Async<?> async);
    }

    public interface CompletionHandler {
        void handleComplete(Async<?> async);
    }

    public interface ErrorHandler {
        void handleError(Async<?> async, Throwable th);
    }

    public interface Handler<T> extends CompletionHandler, ErrorHandler, ResultHandler<T> {
    }

    public interface ResultHandler<T> {
        void handleResult(Async<?> async, T t);
    }

    <S extends ResultHandler<? super T> & ErrorHandler & CompletionHandler> Async<T> addHandler(S s);

    void cancel();

    <S> Async<S> chain(Function<? super T, ? extends Async<? extends S>> function);

    boolean hasFailed();

    boolean inProgress();

    boolean isCancelled();

    boolean isComplete();

    <S> Async<S> map(Function<? super T, ? extends S> function);

    Async<T> onCancelled(CancellationHandler cancellationHandler);

    Async<T> onComplete(CompletionHandler completionHandler);

    Async<T> onError(ErrorHandler errorHandler);

    Async<T> onResult(ResultHandler<? super T> resultHandler);

    Async<T> pipe(ResultReceiver<? super T> resultReceiver);

    Async<T> removeCancellationHandler(CancellationHandler cancellationHandler);

    Async<T> removeCompletionHandler(CompletionHandler completionHandler);

    Async<T> removeErrorHandler(ErrorHandler errorHandler);

    <S extends ResultHandler<? super T> & ErrorHandler & CompletionHandler> Async<T> removeHandler(S s);

    Async<T> removeResultHandler(ResultHandler<? super T> resultHandler);
}
