package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final /* synthetic */ class w implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    private final u f13074a;

    w(u uVar) {
        this.f13074a = uVar;
    }

    public final Object then(Task task) {
        u uVar = this.f13074a;
        return u.a(task);
    }
}
