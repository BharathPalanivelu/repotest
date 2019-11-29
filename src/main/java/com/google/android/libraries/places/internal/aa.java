package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final /* synthetic */ class aa implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    private final u f12325a;

    aa(u uVar) {
        this.f12325a = uVar;
    }

    public final Object then(Task task) {
        u uVar = this.f12325a;
        return u.a(task);
    }
}
