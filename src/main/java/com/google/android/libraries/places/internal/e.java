package com.google.android.libraries.places.internal;

import android.location.Location;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class e implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    private final d f12487a;

    /* renamed from: b  reason: collision with root package name */
    private final CancellationToken f12488b;

    public e(d dVar, CancellationToken cancellationToken) {
        this.f12487a = dVar;
        this.f12488b = cancellationToken;
    }

    public final Object then(Task task) {
        TaskCompletionSource taskCompletionSource;
        d dVar = this.f12487a;
        CancellationToken cancellationToken = this.f12488b;
        if (task.isSuccessful()) {
            Location location = (Location) task.getResult();
            boolean z = false;
            if (location != null && (Build.VERSION.SDK_INT < 17 || SystemClock.elapsedRealtimeNanos() - location.getElapsedRealtimeNanos() <= d.f12428b)) {
                z = true;
            }
            if (z) {
                return task;
            }
        }
        if (cancellationToken != null) {
            taskCompletionSource = new TaskCompletionSource(cancellationToken);
        } else {
            taskCompletionSource = new TaskCompletionSource();
        }
        LocationRequest numUpdates = LocationRequest.create().setPriority(100).setExpirationDuration(d.f12427a).setInterval(d.f12429c).setFastestInterval(10).setNumUpdates(1);
        h hVar = new h(taskCompletionSource);
        dVar.f12430d.requestLocationUpdates(numUpdates, hVar, Looper.getMainLooper()).continueWithTask(new f(dVar, taskCompletionSource));
        dVar.f12431e.a(taskCompletionSource, d.f12427a, "Location timeout.");
        taskCompletionSource.getTask().addOnCompleteListener(new g(dVar, hVar, taskCompletionSource));
        return taskCompletionSource.getTask();
    }
}
