package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final /* synthetic */ class k implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    private final a f14361a;

    k(a aVar) {
        this.f14361a = aVar;
    }

    public final Object then(Task task) {
        return Boolean.valueOf(this.f14361a.b(task));
    }
}
