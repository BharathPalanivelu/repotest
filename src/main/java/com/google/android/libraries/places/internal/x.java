package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;

final /* synthetic */ class x implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    private final u f13075a;

    /* renamed from: b  reason: collision with root package name */
    private final FetchPhotoRequest f13076b;

    /* renamed from: c  reason: collision with root package name */
    private final long f13077c;

    x(u uVar, FetchPhotoRequest fetchPhotoRequest, long j) {
        this.f13075a = uVar;
        this.f13076b = fetchPhotoRequest;
        this.f13077c = j;
    }

    public final Object then(Task task) {
        u uVar = this.f13075a;
        FetchPhotoRequest fetchPhotoRequest = this.f13076b;
        long j = this.f13077c;
        if (!task.isCanceled()) {
            uVar.f13068c.a(task, j, uVar.f13069d.a());
        }
        return task;
    }
}
