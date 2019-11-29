package com.google.android.gms.internal.icing;

import com.google.android.gms.internal.icing.zzcd;
import com.google.android.gms.internal.icing.zzcf;

public abstract class zzcf<MessageType extends zzcd<MessageType, BuilderType>, BuilderType extends zzcf<MessageType, BuilderType>> implements zzew {
    /* access modifiers changed from: protected */
    public abstract BuilderType zza(MessageType messagetype);

    /* renamed from: zzad */
    public abstract BuilderType clone();

    public final /* synthetic */ zzew zza(zzex zzex) {
        if (zzbr().getClass().isInstance(zzex)) {
            return zza((zzcd) zzex);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
