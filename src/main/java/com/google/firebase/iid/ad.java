package com.google.firebase.iid;

import android.content.Intent;

final class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Intent f14099a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Intent f14100b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ af f14101c;

    ad(af afVar, Intent intent, Intent intent2) {
        this.f14101c = afVar;
        this.f14099a = intent;
        this.f14100b = intent2;
    }

    public final void run() {
        this.f14101c.zzd(this.f14099a);
        this.f14101c.zza(this.f14100b);
    }
}
