package com.google.android.gms.internal.firebase_remote_config;

import com.tencent.qcloud.core.util.IOUtils;

public abstract class zzdj {
    public static zzdj zza(char c2) {
        return new zzdl(',');
    }

    public abstract boolean zzb(char c2);

    protected zzdj() {
    }

    public int zza(CharSequence charSequence, int i) {
        int length = charSequence.length();
        zzdt.zza(i, length, "index");
        while (i < length) {
            if (zzb(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static String zzc(char c2) {
        char[] cArr = {IOUtils.DIR_SEPARATOR_WINDOWS, 'u', 0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c2 & 15);
            c2 = (char) (c2 >> 4);
        }
        return String.copyValueOf(cArr);
    }
}
