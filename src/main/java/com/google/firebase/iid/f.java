package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.firebase_messaging.zza;
import com.google.android.gms.internal.firebase_messaging.zzf;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledExecutorService;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static f f14148a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Context f14149b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final ScheduledExecutorService f14150c;

    /* renamed from: d  reason: collision with root package name */
    private h f14151d = new h(this);

    /* renamed from: e  reason: collision with root package name */
    private int f14152e = 1;

    public static synchronized f a(Context context) {
        f fVar;
        synchronized (f.class) {
            if (f14148a == null) {
                f14148a = new f(context, zza.zza().zza(1, new NamedThreadFactory("MessengerIpcClient"), zzf.zze));
            }
            fVar = f14148a;
        }
        return fVar;
    }

    private f(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f14150c = scheduledExecutorService;
        this.f14149b = context.getApplicationContext();
    }

    public final Task<Void> a(int i, Bundle bundle) {
        return a(new n(a(), 2, bundle));
    }

    public final Task<Bundle> b(int i, Bundle bundle) {
        return a(new o(a(), 1, bundle));
    }

    private final synchronized <T> Task<T> a(m<T> mVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(mVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 9);
            sb.append("Queueing ");
            sb.append(valueOf);
            Log.d("MessengerIpcClient", sb.toString());
        }
        if (!this.f14151d.a((m) mVar)) {
            this.f14151d = new h(this);
            this.f14151d.a((m) mVar);
        }
        return mVar.f14167b.getTask();
    }

    private final synchronized int a() {
        int i;
        i = this.f14152e;
        this.f14152e = i + 1;
        return i;
    }
}
