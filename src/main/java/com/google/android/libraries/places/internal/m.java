package com.google.android.libraries.places.internal;

import com.android.b.n;
import com.android.b.s;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class m implements n.a {

    /* renamed from: a  reason: collision with root package name */
    private final TaskCompletionSource f12954a;

    public m(TaskCompletionSource taskCompletionSource) {
        this.f12954a = taskCompletionSource;
    }

    public final void onErrorResponse(s sVar) {
        gg.a(this.f12954a, sVar);
    }
}
