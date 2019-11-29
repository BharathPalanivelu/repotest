package io.b.e.c;

import java.util.concurrent.Callable;

public interface c<T> extends Callable<T> {
    T call();
}
