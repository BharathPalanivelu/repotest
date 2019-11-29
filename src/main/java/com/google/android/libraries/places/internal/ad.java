package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final /* synthetic */ class ad implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    private final u f12333a;

    ad(u uVar) {
        this.f12333a = uVar;
    }

    public final Object then(Task task) {
        u uVar = this.f12333a;
        return u.a(task);
    }
}
