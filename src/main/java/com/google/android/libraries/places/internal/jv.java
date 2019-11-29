package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.ju;
import com.google.android.libraries.places.internal.jv;

public abstract class jv<MessageType extends ju<MessageType, BuilderType>, BuilderType extends jv<MessageType, BuilderType>> implements mb {
    /* renamed from: a */
    public abstract BuilderType clone();

    /* access modifiers changed from: protected */
    public abstract BuilderType a(MessageType messagetype);

    public final /* synthetic */ mb a(ma maVar) {
        if (k().getClass().isInstance(maVar)) {
            return a((ju) maVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
