package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class f implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    private final d f12537a;

    /* renamed from: b  reason: collision with root package name */
    private final TaskCompletionSource f12538b;

    f(d dVar, TaskCompletionSource taskCompletionSource) {
        this.f12537a = dVar;
        this.f12538b = taskCompletionSource;
    }

    public final Object then(Task task) {
        d dVar = this.f12537a;
        TaskCompletionSource taskCompletionSource = this.f12538b;
        if (task.isComplete()) {
            if (task.isCanceled()) {
                taskCompletionSource.trySetException(new ApiException(new Status(16, "Location request was cancelled. Please try again.")));
            } else if (!task.isSuccessful()) {
                taskCompletionSource.trySetException(new ApiException(new Status(8, task.getException().getMessage())));
            }
        }
        return task;
    }
}
