package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;

final /* synthetic */ class z implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    private final u f13079a;

    /* renamed from: b  reason: collision with root package name */
    private final FetchPlaceRequest f13080b;

    /* renamed from: c  reason: collision with root package name */
    private final long f13081c;

    z(u uVar, FetchPlaceRequest fetchPlaceRequest, long j) {
        this.f13079a = uVar;
        this.f13080b = fetchPlaceRequest;
        this.f13081c = j;
    }

    public final Object then(Task task) {
        u uVar = this.f13079a;
        FetchPlaceRequest fetchPlaceRequest = this.f13080b;
        long j = this.f13081c;
        if (!task.isCanceled()) {
            uVar.f13068c.a(fetchPlaceRequest, (Task<FetchPlaceResponse>) task, j, uVar.f13069d.a());
        }
        return task;
    }
}
