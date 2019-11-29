package com.google.android.gms.internal.firebase_remote_config;

import com.appsflyer.share.Constants;
import com.tencent.qcloud.core.util.IOUtils;

enum zzak {
    PLUS('+', "", ",", false, true),
    HASH('#', "#", ",", false, true),
    DOT('.', ".", ".", false, false),
    FORWARD_SLASH(Character.valueOf(IOUtils.DIR_SEPARATOR_UNIX), Constants.URL_PATH_DELIMITER, Constants.URL_PATH_DELIMITER, false, false),
    SEMI_COLON(';', ";", ";", true, false),
    QUERY('?', "?", "&", true, false),
    AMP('&', "&", "&", true, false),
    SIMPLE((String) null, "", ",", false, false);
    
    private final Character zzcl;
    private final String zzcm;
    private final String zzcn;
    private final boolean zzco;
    private final boolean zzcp;

    private zzak(Character ch, String str, String str2, boolean z, boolean z2) {
        this.zzcl = ch;
        this.zzcm = (String) zzdt.checkNotNull(str);
        this.zzcn = (String) zzdt.checkNotNull(str2);
        this.zzco = z;
        this.zzcp = z2;
        if (ch != null) {
            zzal.zzcr.put(ch, this);
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzak() {
        return this.zzcm;
    }

    /* access modifiers changed from: package-private */
    public final String zzal() {
        return this.zzcn;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzam() {
        return this.zzco;
    }

    /* access modifiers changed from: package-private */
    public final int zzan() {
        return this.zzcl == null ? 0 : 1;
    }

    /* access modifiers changed from: package-private */
    public final String zzaa(String str) {
        if (this.zzcp) {
            return zzcs.zzaj(str);
        }
        return zzcs.zzah(str);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzao() {
        return this.zzcp;
    }
}
