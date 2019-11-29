package com.google.firebase.iid;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class at implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final au f14134a;

    /* renamed from: b  reason: collision with root package name */
    private final Bundle f14135b;

    /* renamed from: c  reason: collision with root package name */
    private final TaskCompletionSource f14136c;

    at(au auVar, Bundle bundle, TaskCompletionSource taskCompletionSource) {
        this.f14134a = auVar;
        this.f14135b = bundle;
        this.f14136c = taskCompletionSource;
    }

    public final void run() {
        this.f14134a.a(this.f14135b, this.f14136c);
    }
}
