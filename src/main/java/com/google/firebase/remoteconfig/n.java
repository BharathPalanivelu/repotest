package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final /* synthetic */ class n implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    private final a f14364a;

    /* renamed from: b  reason: collision with root package name */
    private final Task f14365b;

    /* renamed from: c  reason: collision with root package name */
    private final Task f14366c;

    n(a aVar, Task task, Task task2) {
        this.f14364a = aVar;
        this.f14365b = task;
        this.f14366c = task2;
    }

    public final Object then(Task task) {
        return this.f14364a.a(this.f14365b, this.f14366c, task);
    }
}
