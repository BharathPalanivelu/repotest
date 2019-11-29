package com.google.firebase.iid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;

final class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final long f14088a;

    /* renamed from: b  reason: collision with root package name */
    private final PowerManager.WakeLock f14089b = ((PowerManager) a().getSystemService("power")).newWakeLock(1, "fiid-sync");

    /* renamed from: c  reason: collision with root package name */
    private final FirebaseInstanceId f14090c;

    /* renamed from: d  reason: collision with root package name */
    private final ac f14091d;

    @VisibleForTesting
    aa(FirebaseInstanceId firebaseInstanceId, q qVar, ac acVar, long j) {
        this.f14090c = firebaseInstanceId;
        this.f14091d = acVar;
        this.f14088a = j;
        this.f14089b.setReferenceCounted(false);
    }

    @SuppressLint({"Wakelock"})
    public final void run() {
        try {
            if (z.a().a(a())) {
                this.f14089b.acquire();
            }
            this.f14090c.a(true);
            if (!this.f14090c.f()) {
                this.f14090c.a(false);
            } else if (!z.a().b(a()) || b()) {
                if (!c() || !this.f14091d.a(this.f14090c)) {
                    this.f14090c.a(this.f14088a);
                } else {
                    this.f14090c.a(false);
                }
                if (z.a().a(a())) {
                    this.f14089b.release();
                }
            } else {
                new ae(this).a();
                if (z.a().a(a())) {
                    this.f14089b.release();
                }
            }
        } finally {
            if (z.a().a(a())) {
                this.f14089b.release();
            }
        }
    }

    @VisibleForTesting
    private final boolean c() {
        ab b2 = this.f14090c.b();
        if (!this.f14090c.h() && !this.f14090c.a(b2)) {
            return true;
        }
        try {
            String c2 = this.f14090c.c();
            if (c2 == null) {
                Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                return false;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Token successfully retrieved");
            }
            if (b2 == null || (b2 != null && !c2.equals(b2.f14093a))) {
                Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
                intent.putExtra("token", c2);
                Context a2 = a();
                Intent intent2 = new Intent(a2, FirebaseInstanceIdReceiver.class);
                intent2.setAction("com.google.firebase.MESSAGING_EVENT");
                intent2.putExtra("wrapped_intent", intent);
                a2.sendBroadcast(intent2);
            }
            return true;
        } catch (IOException | SecurityException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.e("FirebaseInstanceId", valueOf.length() != 0 ? "Token retrieval failed: ".concat(valueOf) : new String("Token retrieval failed: "));
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final Context a() {
        return this.f14090c.a().a();
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        ConnectivityManager connectivityManager = (ConnectivityManager) a().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
