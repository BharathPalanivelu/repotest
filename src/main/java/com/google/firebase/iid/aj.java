package com.google.firebase.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;

public final class aj extends Binder {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final af f14111a;

    aj(af afVar) {
        this.f14111a = afVar;
    }

    public final void a(ah ahVar) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "service received new intent via bind strategy");
            }
            if (this.f14111a.zzc(ahVar.f14105a)) {
                ahVar.a();
                return;
            }
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "intent being queued for bg execution");
            }
            this.f14111a.zzt.execute(new ai(this, ahVar));
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
