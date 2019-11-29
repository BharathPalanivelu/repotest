package com.firebase.jobdispatcher;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.firebase.jobdispatcher.m;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class t implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final Map<q, Boolean> f7249a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final l f7250b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f7251c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7252d = false;

    /* renamed from: e  reason: collision with root package name */
    private m f7253e;

    t(l lVar, Context context) {
        this.f7250b = lVar;
        this.f7251c = context;
    }

    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (a()) {
            Log.w("FJD.ExternalReceiver", "Connection have been used already.");
            return;
        }
        this.f7253e = m.a.a(iBinder);
        HashSet<q> hashSet = new HashSet<>();
        for (Map.Entry next : this.f7249a.entrySet()) {
            if (Boolean.FALSE.equals(next.getValue())) {
                try {
                    this.f7253e.a(a((r) next.getKey()), this.f7250b);
                    hashSet.add(next.getKey());
                } catch (RemoteException e2) {
                    Log.e("FJD.ExternalReceiver", "Failed to start job " + next.getKey(), e2);
                    c();
                    return;
                }
            }
        }
        for (q put : hashSet) {
            this.f7249a.put(put, true);
        }
    }

    public synchronized void onServiceDisconnected(ComponentName componentName) {
        c();
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean a() {
        return this.f7252d;
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean b() {
        return this.f7253e != null;
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(q qVar, boolean z) {
        if (!a()) {
            if (Boolean.TRUE.equals(this.f7249a.remove(qVar)) && b()) {
                a(z, qVar);
            }
            if (!z && this.f7249a.isEmpty()) {
                c();
            }
        } else {
            Log.w("FJD.ExternalReceiver", "Can't send stop request because service was unbound.");
        }
    }

    private synchronized void a(boolean z, q qVar) {
        try {
            this.f7253e.a(a((r) qVar), z);
        } catch (RemoteException e2) {
            Log.e("FJD.ExternalReceiver", "Failed to stop a job", e2);
            c();
        }
        return;
    }

    /* access modifiers changed from: package-private */
    public synchronized void c() {
        if (!a()) {
            this.f7253e = null;
            this.f7252d = true;
            try {
                this.f7251c.unbindService(this);
            } catch (IllegalArgumentException e2) {
                Log.w("FJD.ExternalReceiver", "Error unbinding service: " + e2.getMessage());
            }
        }
        return;
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(q qVar) {
        this.f7249a.remove(qVar);
        if (this.f7249a.isEmpty()) {
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean b(q qVar) {
        boolean b2;
        b2 = b();
        if (b2) {
            if (Boolean.TRUE.equals(this.f7249a.get(qVar))) {
                Log.w("FJD.ExternalReceiver", "Received an execution request for already running job " + qVar);
                a(false, qVar);
            }
            try {
                this.f7253e.a(a((r) qVar), this.f7250b);
            } catch (RemoteException e2) {
                Log.e("FJD.ExternalReceiver", "Failed to start the job " + qVar, e2);
                c();
                return false;
            }
        }
        this.f7249a.put(qVar, Boolean.valueOf(b2));
        return b2;
    }

    private static Bundle a(r rVar) {
        return GooglePlayReceiver.b().a(rVar, new Bundle());
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean c(q qVar) {
        return this.f7249a.containsKey(qVar);
    }
}
