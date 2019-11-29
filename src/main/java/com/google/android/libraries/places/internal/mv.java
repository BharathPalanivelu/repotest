package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.Map;

final class mv extends nb {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ ms f12994a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    mv(ms msVar) {
        super(msVar);
        this.f12994a = msVar;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new mu(this.f12994a);
    }
}
