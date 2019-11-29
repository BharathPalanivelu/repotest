package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

final /* synthetic */ class l implements SuccessContinuation {

    /* renamed from: a  reason: collision with root package name */
    private final a f14362a;

    l(a aVar) {
        this.f14362a = aVar;
    }

    public final Task then(Object obj) {
        return this.f14362a.c();
    }
}
