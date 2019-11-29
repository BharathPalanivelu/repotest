package com.google.firebase.iid;

import java.util.concurrent.ThreadFactory;

final /* synthetic */ class an implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    static final ThreadFactory f14120a = new an();

    private an() {
    }

    public final Thread newThread(Runnable runnable) {
        return ak.a(runnable);
    }
}
