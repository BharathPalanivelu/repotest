package com.google.firebase.perf.internal;

import android.annotation.SuppressLint;
import androidx.annotation.Keep;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.p000firebaseperf.zzbt;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Keep
public class SessionManager extends b {
    @SuppressLint({"StaticFieldLeak"})
    private static final SessionManager zzfi = new SessionManager();
    private final GaugeManager zzbl;
    private final a zzcx;
    private final Set<WeakReference<y>> zzfj;
    private zzq zzfk;

    public static SessionManager zzcf() {
        return zzfi;
    }

    public final zzq zzcg() {
        return this.zzfk;
    }

    private SessionManager() {
        this(GaugeManager.zzbf(), zzq.a(), a.a());
    }

    @VisibleForTesting
    private SessionManager(GaugeManager gaugeManager, zzq zzq, a aVar) {
        this.zzfj = new HashSet();
        this.zzbl = gaugeManager;
        this.zzfk = zzq;
        this.zzcx = aVar;
        zzay();
    }

    public final void zza(zzbt zzbt) {
        super.zza(zzbt);
        if (!this.zzcx.b()) {
            if (zzbt == zzbt.FOREGROUND) {
                zzc(zzbt);
            } else if (!zzch()) {
                zzd(zzbt);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzch() {
        if (!this.zzfk.d()) {
            return false;
        }
        zzc(this.zzcx.c());
        return true;
    }

    public final void zzc(zzbt zzbt) {
        this.zzfk = zzq.a();
        synchronized (this.zzfj) {
            Iterator<WeakReference<y>> it = this.zzfj.iterator();
            while (it.hasNext()) {
                y yVar = (y) it.next().get();
                if (yVar != null) {
                    yVar.zza(this.zzfk);
                } else {
                    it.remove();
                }
            }
        }
        if (this.zzfk.c()) {
            this.zzbl.zzc(this.zzfk.b(), zzbt);
        }
        zzd(zzbt);
    }

    public final void zzc(WeakReference<y> weakReference) {
        synchronized (this.zzfj) {
            this.zzfj.add(weakReference);
        }
    }

    public final void zzd(WeakReference<y> weakReference) {
        synchronized (this.zzfj) {
            this.zzfj.remove(weakReference);
        }
    }

    private final void zzd(zzbt zzbt) {
        if (this.zzfk.c()) {
            this.zzbl.zza(this.zzfk.b(), zzbt);
        } else {
            this.zzbl.zzbg();
        }
    }
}
