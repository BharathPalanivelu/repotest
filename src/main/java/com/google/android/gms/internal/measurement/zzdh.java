package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzdf;
import com.google.android.gms.internal.measurement.zzdh;
import java.io.IOException;

public abstract class zzdh<MessageType extends zzdf<MessageType, BuilderType>, BuilderType extends zzdh<MessageType, BuilderType>> implements zzgh {
    /* access modifiers changed from: protected */
    public abstract BuilderType zza(MessageType messagetype);

    public abstract BuilderType zza(zzeb zzeb, zzel zzel) throws IOException;

    /* renamed from: zzru */
    public abstract BuilderType clone();

    public final BuilderType zzf(byte[] bArr, zzel zzel) throws zzfi {
        return zza(bArr, 0, bArr.length, zzel);
    }

    public BuilderType zza(byte[] bArr, int i, int i2, zzel zzel) throws zzfi {
        try {
            zzeb zza = zzeb.zza(bArr, 0, i2, false);
            zza(zza, zzel);
            zza.zzat(0);
            return this;
        } catch (zzfi e2) {
            throw e2;
        } catch (IOException e3) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 60 + "byte array".length());
            sb.append("Reading ");
            sb.append(name);
            sb.append(" from a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e3);
        }
    }

    public final /* synthetic */ zzgh zza(zzgi zzgi) {
        if (zzuh().getClass().isInstance(zzgi)) {
            return zza((zzdf) zzgi);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
