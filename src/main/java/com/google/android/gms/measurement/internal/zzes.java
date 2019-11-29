package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.facebook.common.time.Clock;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzes {
    private final /* synthetic */ zzeo zzmj;
    @VisibleForTesting
    private final String zzmk;
    private final String zzml;
    private final String zzmm;
    private final long zzmn;

    private zzes(zzeo zzeo, String str, long j) {
        this.zzmj = zzeo;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkArgument(j > 0);
        this.zzmk = String.valueOf(str).concat(":start");
        this.zzml = String.valueOf(str).concat(":count");
        this.zzmm = String.valueOf(str).concat(":value");
        this.zzmn = j;
    }

    private final void zzhk() {
        this.zzmj.zzo();
        long currentTimeMillis = this.zzmj.zzx().currentTimeMillis();
        SharedPreferences.Editor edit = this.zzmj.zzhb().edit();
        edit.remove(this.zzml);
        edit.remove(this.zzmm);
        edit.putLong(this.zzmk, currentTimeMillis);
        edit.apply();
    }

    public final void zzc(String str, long j) {
        this.zzmj.zzo();
        if (zzhm() == 0) {
            zzhk();
        }
        if (str == null) {
            str = "";
        }
        long j2 = this.zzmj.zzhb().getLong(this.zzml, 0);
        if (j2 <= 0) {
            SharedPreferences.Editor edit = this.zzmj.zzhb().edit();
            edit.putString(this.zzmm, str);
            edit.putLong(this.zzml, 1);
            edit.apply();
            return;
        }
        long j3 = j2 + 1;
        boolean z = (this.zzmj.zzz().zzjw().nextLong() & Clock.MAX_TIME) < Clock.MAX_TIME / j3;
        SharedPreferences.Editor edit2 = this.zzmj.zzhb().edit();
        if (z) {
            edit2.putString(this.zzmm, str);
        }
        edit2.putLong(this.zzml, j3);
        edit2.apply();
    }

    public final Pair<String, Long> zzhl() {
        long j;
        this.zzmj.zzo();
        this.zzmj.zzo();
        long zzhm = zzhm();
        if (zzhm == 0) {
            zzhk();
            j = 0;
        } else {
            j = Math.abs(zzhm - this.zzmj.zzx().currentTimeMillis());
        }
        long j2 = this.zzmn;
        if (j < j2) {
            return null;
        }
        if (j > (j2 << 1)) {
            zzhk();
            return null;
        }
        String string = this.zzmj.zzhb().getString(this.zzmm, (String) null);
        long j3 = this.zzmj.zzhb().getLong(this.zzml, 0);
        zzhk();
        if (string == null || j3 <= 0) {
            return zzeo.zzlg;
        }
        return new Pair<>(string, Long.valueOf(j3));
    }

    private final long zzhm() {
        return this.zzmj.zzhb().getLong(this.zzmk, 0);
    }
}
