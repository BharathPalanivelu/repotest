package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class at implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    private final fv f12347a;

    /* renamed from: b  reason: collision with root package name */
    private final TaskCompletionSource f12348b;

    public at(fv fvVar, TaskCompletionSource taskCompletionSource) {
        this.f12347a = fvVar;
        this.f12348b = taskCompletionSource;
    }

    public final Object then(Task task) {
        return this.f12347a.b(this.f12348b, task);
    }
}
