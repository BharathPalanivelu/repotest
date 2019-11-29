package com.google.firebase.perf.internal;

import com.google.android.gms.tasks.OnFailureListener;

final /* synthetic */ class w implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    private final RemoteConfigManager f14284a;

    w(RemoteConfigManager remoteConfigManager) {
        this.f14284a = remoteConfigManager;
    }

    public final void onFailure(Exception exc) {
        this.f14284a.zza(exc);
    }
}
