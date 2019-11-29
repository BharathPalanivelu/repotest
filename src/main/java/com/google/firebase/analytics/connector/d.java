package com.google.firebase.analytics.connector;

import java.util.concurrent.Executor;

final /* synthetic */ class d implements Executor {

    /* renamed from: a  reason: collision with root package name */
    static final Executor f6781a = new d();

    private d() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
