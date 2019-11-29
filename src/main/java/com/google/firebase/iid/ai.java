package com.google.firebase.iid;

import android.util.Log;

final class ai implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ ah f14109a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ aj f14110b;

    ai(aj ajVar, ah ahVar) {
        this.f14110b = ajVar;
        this.f14109a = ahVar;
    }

    public final void run() {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "bg processing of the intent starting now");
        }
        this.f14110b.f14111a.zzd(this.f14109a.f14105a);
        this.f14109a.a();
    }
}
