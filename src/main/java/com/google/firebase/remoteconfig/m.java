package com.google.firebase.remoteconfig;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

final /* synthetic */ class m implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    private final a f14363a;

    m(a aVar) {
        this.f14363a = aVar;
    }

    public final void onComplete(Task task) {
        this.f14363a.a(task);
    }
}
