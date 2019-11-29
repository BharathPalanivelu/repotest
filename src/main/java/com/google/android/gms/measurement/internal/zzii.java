package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzp;
import java.util.ArrayList;

final class zzii implements Runnable {
    private final /* synthetic */ String zzas;
    private final /* synthetic */ zzp zzdi;
    private final /* synthetic */ zzn zzpg;
    private final /* synthetic */ zzhv zzrd;
    private final /* synthetic */ String zzx;

    zzii(zzhv zzhv, String str, String str2, zzn zzn, zzp zzp) {
        this.zzrd = zzhv;
        this.zzx = str;
        this.zzas = str2;
        this.zzpg = zzn;
        this.zzdi = zzp;
    }

    public final void run() {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            zzdx zzd = this.zzrd.zzrf;
            if (zzd == null) {
                this.zzrd.zzab().zzgk().zza("Failed to get conditional properties", this.zzx, this.zzas);
                return;
            }
            arrayList = zzjs.zzd(zzd.zza(this.zzx, this.zzas, this.zzpg));
            this.zzrd.zzir();
            this.zzrd.zzz().zza(this.zzdi, arrayList);
        } catch (RemoteException e2) {
            this.zzrd.zzab().zzgk().zza("Failed to get conditional properties", this.zzx, this.zzas, e2);
        } finally {
            this.zzrd.zzz().zza(this.zzdi, arrayList);
        }
    }
}
