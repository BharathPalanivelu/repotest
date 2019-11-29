package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p000firebaseperf.zzbt;
import com.google.firebase.perf.internal.a;
import java.lang.ref.WeakReference;

public class b implements a.C0235a {
    private a zzcj;
    private zzbt zzck;
    private boolean zzcl;
    private WeakReference<a.C0235a> zzcm;

    protected b() {
        this(a.a());
    }

    protected b(a aVar) {
        this.zzck = zzbt.APPLICATION_PROCESS_STATE_UNKNOWN;
        this.zzcl = false;
        this.zzcj = aVar;
        this.zzcm = new WeakReference<>(this);
    }

    /* access modifiers changed from: protected */
    public final void zzay() {
        if (!this.zzcl) {
            this.zzck = this.zzcj.c();
            this.zzcj.a(this.zzcm);
            this.zzcl = true;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzaz() {
        if (this.zzcl) {
            this.zzcj.b(this.zzcm);
            this.zzcl = false;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzc(int i) {
        this.zzcj.a(1);
    }

    public void zza(zzbt zzbt) {
        if (this.zzck == zzbt.APPLICATION_PROCESS_STATE_UNKNOWN) {
            this.zzck = zzbt;
        } else if (this.zzck != zzbt && zzbt != zzbt.APPLICATION_PROCESS_STATE_UNKNOWN) {
            this.zzck = zzbt.FOREGROUND_BACKGROUND;
        }
    }

    public final zzbt zzal() {
        return this.zzck;
    }
}
