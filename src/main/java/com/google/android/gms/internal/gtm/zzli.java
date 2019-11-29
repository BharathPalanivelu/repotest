package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import com.salesforce.android.service.common.utilities.hashing.Hash;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class zzli extends zzhb {
    /* access modifiers changed from: protected */
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        String str;
        byte[] bArr;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length > 0);
        if (zzoaArr[0] == zzog.zzaum) {
            return zzog.zzaum;
        }
        String zzd = zzha.zzd(zzoaArr[0]);
        int length = zzoaArr.length;
        String str2 = Hash.ALGORITHM_MD5;
        if (length > 1 && zzoaArr[1] != zzog.zzaum) {
            str2 = zzha.zzd(zzoaArr[1]);
        }
        if (zzoaArr.length <= 2 || zzoaArr[2] == zzog.zzaum) {
            str = "text";
        } else {
            str = zzha.zzd(zzoaArr[2]);
        }
        if ("text".equals(str)) {
            bArr = zzd.getBytes();
        } else if ("base16".equals(str)) {
            bArr = zzdp.decode(zzd);
        } else {
            String valueOf = String.valueOf(str);
            throw new RuntimeException(valueOf.length() != 0 ? "Hash: Unknown input format: ".concat(valueOf) : new String("Hash: Unknown input format: "));
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(str2);
            instance.update(bArr);
            return new zzom(zzdp.encode(instance.digest()));
        } catch (NoSuchAlgorithmException e2) {
            String valueOf2 = String.valueOf(str2);
            throw new RuntimeException(valueOf2.length() != 0 ? "Hash: Unknown algorithm: ".concat(valueOf2) : new String("Hash: Unknown algorithm: "), e2);
        }
    }
}
