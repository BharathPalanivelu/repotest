package com.shopee.live.livestreaming.network.executor;

public interface Executor {
    void closeExcutor();

    <T, C> void execute(AbstractInteractor<T, C> abstractInteractor, T t, C c2);
}
