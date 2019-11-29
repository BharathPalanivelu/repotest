package com.google.android.gms.internal.gtm;

import android.util.Base64;
import com.google.android.gms.common.internal.Preconditions;

public final class zzle extends zzhb {
    /* access modifiers changed from: protected */
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        String str;
        String str2;
        byte[] bArr;
        String str3;
        boolean z = true;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length > 0);
        String zzd = zzha.zzd(zzoaArr[0]);
        if (zzoaArr.length > 1) {
            str = zzha.zzd(zzoaArr[1]);
        } else {
            str = "text";
        }
        int i = 2;
        if (zzoaArr.length > 2) {
            str2 = zzha.zzd(zzoaArr[2]);
        } else {
            str2 = "base16";
        }
        if (zzoaArr.length <= 3 || !zzha.zza(zzoaArr[3])) {
            z = false;
        }
        if (z) {
            i = 3;
        }
        try {
            if ("text".equals(str)) {
                bArr = zzd.getBytes();
            } else if ("base16".equals(str)) {
                bArr = zzdp.decode(zzd);
            } else if ("base64".equals(str)) {
                bArr = Base64.decode(zzd, i);
            } else if ("base64url".equals(str)) {
                bArr = Base64.decode(zzd, i | 8);
            } else {
                String valueOf = String.valueOf(str);
                throw new UnsupportedOperationException(valueOf.length() != 0 ? "Encode: unknown input format: ".concat(valueOf) : new String("Encode: unknown input format: "));
            }
            if ("base16".equals(str2)) {
                str3 = zzdp.encode(bArr);
            } else if ("base64".equals(str2)) {
                str3 = Base64.encodeToString(bArr, i);
            } else if ("base64url".equals(str2)) {
                str3 = Base64.encodeToString(bArr, i | 8);
            } else {
                String valueOf2 = String.valueOf(str2);
                throw new RuntimeException(valueOf2.length() != 0 ? "Encode: unknown output format: ".concat(valueOf2) : new String("Encode: unknown output format: "));
            }
            return new zzom(str3);
        } catch (IllegalArgumentException unused) {
            String valueOf3 = String.valueOf(str);
            throw new RuntimeException(valueOf3.length() != 0 ? "Encode: invalid input:".concat(valueOf3) : new String("Encode: invalid input:"));
        }
    }
}
