package com.google.android.gms.internal.icing;

import android.content.SharedPreferences;

final /* synthetic */ class zzbr implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final zzbs zzdm;

    zzbr(zzbs zzbs) {
        this.zzdm = zzbs;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        this.zzdm.zza(sharedPreferences, str);
    }
}
