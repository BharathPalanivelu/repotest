package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.zzdg;
import com.google.android.gms.internal.p000firebaseperf.zzdi;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzdi  reason: invalid package */
public abstract class zzdi<MessageType extends zzdg<MessageType, BuilderType>, BuilderType extends zzdi<MessageType, BuilderType>> implements zzfz {
    /* access modifiers changed from: protected */
    public abstract BuilderType zza(MessageType messagetype);

    /* renamed from: zzgb */
    public abstract BuilderType clone();

    public final /* synthetic */ zzfz zza(zzga zzga) {
        if (zzhl().getClass().isInstance(zzga)) {
            return zza((zzdg) zzga);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
