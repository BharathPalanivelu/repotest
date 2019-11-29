package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class au implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    private final fv f12349a;

    /* renamed from: b  reason: collision with root package name */
    private final TaskCompletionSource f12350b;

    public au(fv fvVar, TaskCompletionSource taskCompletionSource) {
        this.f12349a = fvVar;
        this.f12350b = taskCompletionSource;
    }

    public final void onComplete(Task task) {
        this.f12349a.b(this.f12350b);
    }
}
