package com.google.android.gms.internal.icing;

import android.content.Context;
import android.net.Uri;

public final class zzbp {
    private final String zzdd;
    /* access modifiers changed from: private */
    public final Uri zzde;
    /* access modifiers changed from: private */
    public final String zzdf;
    /* access modifiers changed from: private */
    public final String zzdg;
    private final boolean zzdh;
    private final boolean zzdi;
    private final boolean zzdj;
    private final boolean zzdk;
    private final zzbt<Context, Boolean> zzdl;

    public zzbp(Uri uri) {
        this((String) null, uri, "", "", false, false, false, false, (zzbt<Context, Boolean>) null);
    }

    private zzbp(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, zzbt<Context, Boolean> zzbt) {
        this.zzdd = null;
        this.zzde = uri;
        this.zzdf = str2;
        this.zzdg = str3;
        this.zzdh = false;
        this.zzdi = false;
        this.zzdj = false;
        this.zzdk = false;
        this.zzdl = null;
    }

    public final zzbo<Boolean> zza(String str, boolean z) {
        return zzbo.zza(this, str, z);
    }
}
