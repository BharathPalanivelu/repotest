package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final /* synthetic */ class y implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    private final u f13078a;

    y(u uVar) {
        this.f13078a = uVar;
    }

    public final Object then(Task task) {
        u uVar = this.f13078a;
        return u.a(task);
    }
}
