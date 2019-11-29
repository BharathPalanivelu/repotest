package com.google.android.gms.internal.firebase_remote_config;

import com.g.a.a.g;

final class zzki {
    /* access modifiers changed from: private */
    public static boolean zzd(byte b2) {
        return b2 >= 0;
    }

    /* access modifiers changed from: private */
    public static boolean zze(byte b2) {
        return b2 < -32;
    }

    /* access modifiers changed from: private */
    public static boolean zzf(byte b2) {
        return b2 < -16;
    }

    private static boolean zzg(byte b2) {
        return b2 > -65;
    }

    /* access modifiers changed from: private */
    public static void zza(byte b2, char[] cArr, int i) {
        cArr[i] = (char) b2;
    }

    /* access modifiers changed from: private */
    public static void zza(byte b2, byte b3, char[] cArr, int i) throws zzhq {
        if (b2 < -62 || zzg(b3)) {
            throw zzhq.zzhm();
        }
        cArr[i] = (char) (((b2 & 31) << 6) | (b3 & 63));
    }

    /* access modifiers changed from: private */
    public static void zza(byte b2, byte b3, byte b4, char[] cArr, int i) throws zzhq {
        if (zzg(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || zzg(b4)))) {
            throw zzhq.zzhm();
        }
        cArr[i] = (char) (((b2 & 15) << g.ZERO_TAG) | ((b3 & 63) << 6) | (b4 & 63));
    }

    /* access modifiers changed from: private */
    public static void zza(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i) throws zzhq {
        if (zzg(b3) || (((b2 << 28) + (b3 + 112)) >> 30) != 0 || zzg(b4) || zzg(b5)) {
            throw zzhq.zzhm();
        }
        byte b6 = ((b2 & 7) << 18) | ((b3 & 63) << g.ZERO_TAG) | ((b4 & 63) << 6) | (b5 & 63);
        cArr[i] = (char) ((b6 >>> 10) + 55232);
        cArr[i + 1] = (char) ((b6 & 1023) + g.BYTE);
    }
}
