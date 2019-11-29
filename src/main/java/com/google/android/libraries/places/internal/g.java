package com.google.android.libraries.places.internal;

import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class g implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    private final d f12601a;

    /* renamed from: b  reason: collision with root package name */
    private final LocationCallback f12602b;

    /* renamed from: c  reason: collision with root package name */
    private final TaskCompletionSource f12603c;

    g(d dVar, LocationCallback locationCallback, TaskCompletionSource taskCompletionSource) {
        this.f12601a = dVar;
        this.f12602b = locationCallback;
        this.f12603c = taskCompletionSource;
    }

    public final void onComplete(Task task) {
        d dVar = this.f12601a;
        LocationCallback locationCallback = this.f12602b;
        TaskCompletionSource taskCompletionSource = this.f12603c;
        dVar.f12430d.removeLocationUpdates(locationCallback);
        dVar.f12431e.b((TaskCompletionSource<?>) taskCompletionSource);
    }
}
