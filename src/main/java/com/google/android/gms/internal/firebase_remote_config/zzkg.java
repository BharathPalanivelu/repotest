package com.google.android.gms.internal.firebase_remote_config;

import com.tencent.ijk.media.player.IjkMediaMeta;

final class zzkg {
    private static final zzkh zzyh;

    /* access modifiers changed from: private */
    public static int zzbo(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    /* access modifiers changed from: private */
    public static int zzc(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    public static boolean zze(byte[] bArr) {
        return zzyh.zze(bArr, 0, bArr.length);
    }

    /* access modifiers changed from: private */
    public static int zzs(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    public static boolean zze(byte[] bArr, int i, int i2) {
        return zzyh.zze(bArr, i, i2);
    }

    /* access modifiers changed from: private */
    public static int zzf(byte[] bArr, int i, int i2) {
        byte b2 = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 == 0) {
            return zzbo(b2);
        }
        if (i3 == 1) {
            return zzs(b2, bArr[i]);
        }
        if (i3 == 2) {
            return zzc(b2, bArr[i], bArr[i + 1]);
        }
        throw new AssertionError();
    }

    static int zzb(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) >= 65536) {
                                i2++;
                            } else {
                                throw new zzkj(i2, length2);
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        long j = ((long) i3) + IjkMediaMeta.AV_CH_WIDE_RIGHT;
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    static int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return zzyh.zzb(charSequence, bArr, i, i2);
    }

    static String zzg(byte[] bArr, int i, int i2) throws zzhq {
        return zzyh.zzg(bArr, i, i2);
    }

    static {
        zzkh zzkh;
        if (!(zzkd.zzjd() && zzkd.zzje()) || zzfu.zzeu()) {
            zzkh = new zzkk();
        } else {
            zzkh = new zzkm();
        }
        zzyh = zzkh;
    }
}
