package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;

final /* synthetic */ class v implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    private final u f13071a;

    /* renamed from: b  reason: collision with root package name */
    private final FindAutocompletePredictionsRequest f13072b;

    /* renamed from: c  reason: collision with root package name */
    private final long f13073c;

    v(u uVar, FindAutocompletePredictionsRequest findAutocompletePredictionsRequest, long j) {
        this.f13071a = uVar;
        this.f13072b = findAutocompletePredictionsRequest;
        this.f13073c = j;
    }

    public final Object then(Task task) {
        u uVar = this.f13071a;
        FindAutocompletePredictionsRequest findAutocompletePredictionsRequest = this.f13072b;
        long j = this.f13073c;
        if (!task.isCanceled()) {
            uVar.f13068c.a(findAutocompletePredictionsRequest, (Task<FindAutocompletePredictionsResponse>) task, j, uVar.f13069d.a());
        }
        return task;
    }
}
