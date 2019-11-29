package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
final class ae extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private aa f14102a;

    public ae(aa aaVar) {
        this.f14102a = aaVar;
    }

    public final void a() {
        if (FirebaseInstanceId.d()) {
            Log.d("FirebaseInstanceId", "Connectivity change received registered");
        }
        this.f14102a.a().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public final void onReceive(Context context, Intent intent) {
        aa aaVar = this.f14102a;
        if (aaVar != null && aaVar.b()) {
            if (FirebaseInstanceId.d()) {
                Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
            }
            FirebaseInstanceId.a((Runnable) this.f14102a, 0);
            this.f14102a.a().unregisterReceiver(this);
            this.f14102a = null;
        }
    }
}
