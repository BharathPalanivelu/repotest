package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class as implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TaskCompletionSource f12345a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12346b;

    public as(TaskCompletionSource taskCompletionSource, String str) {
        this.f12345a = taskCompletionSource;
        this.f12346b = str;
    }

    public final void run() {
        this.f12345a.trySetException(new ApiException(new Status(15, this.f12346b)));
    }
}
