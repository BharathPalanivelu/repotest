package com.salesforce.android.service.common.utilities.control;

public interface ResultReceiver<T> {
    ResultReceiver<T> complete();

    ResultReceiver<T> setError(Throwable th);

    ResultReceiver<T> setResult(T t);
}
