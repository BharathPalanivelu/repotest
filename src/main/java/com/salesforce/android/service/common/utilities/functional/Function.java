package com.salesforce.android.service.common.utilities.functional;

public interface Function<T, S> {
    S apply(T t);
}
