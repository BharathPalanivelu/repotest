package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;

final /* synthetic */ class ag implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ah f14103a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f14104b;

    ag(ah ahVar, Intent intent) {
        this.f14103a = ahVar;
        this.f14104b = intent;
    }

    public final void run() {
        ah ahVar = this.f14103a;
        String action = this.f14104b.getAction();
        StringBuilder sb = new StringBuilder(String.valueOf(action).length() + 61);
        sb.append("Service took too long to process intent: ");
        sb.append(action);
        sb.append(" App may get closed.");
        Log.w("EnhancedIntentService", sb.toString());
        ahVar.a();
    }
}
