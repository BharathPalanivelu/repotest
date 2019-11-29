package com.google.firebase.iid;

import android.util.Pair;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final /* synthetic */ class v implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    private final t f14179a;

    /* renamed from: b  reason: collision with root package name */
    private final Pair f14180b;

    v(t tVar, Pair pair) {
        this.f14179a = tVar;
        this.f14180b = pair;
    }

    public final Object then(Task task) {
        return this.f14179a.a(this.f14180b, task);
    }
}
