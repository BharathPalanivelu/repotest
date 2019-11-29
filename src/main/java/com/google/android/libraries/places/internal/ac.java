package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import java.util.concurrent.atomic.AtomicLong;

final /* synthetic */ class ac implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    private final u f12329a;

    /* renamed from: b  reason: collision with root package name */
    private final FindCurrentPlaceRequest f12330b;

    /* renamed from: c  reason: collision with root package name */
    private final long f12331c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicLong f12332d;

    ac(u uVar, FindCurrentPlaceRequest findCurrentPlaceRequest, long j, AtomicLong atomicLong) {
        this.f12329a = uVar;
        this.f12330b = findCurrentPlaceRequest;
        this.f12331c = j;
        this.f12332d = atomicLong;
    }

    public final Object then(Task task) {
        u uVar = this.f12329a;
        FindCurrentPlaceRequest findCurrentPlaceRequest = this.f12330b;
        long j = this.f12331c;
        AtomicLong atomicLong = this.f12332d;
        if (!task.isCanceled()) {
            long a2 = uVar.f13069d.a();
            uVar.f13068c.a(findCurrentPlaceRequest, task, j, atomicLong.get(), a2);
        }
        return task;
    }
}
