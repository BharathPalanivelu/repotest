package com.google.android.libraries.places.internal;

import android.os.ParcelUuid;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;

abstract class bh extends AutocompleteSessionToken {

    /* renamed from: a  reason: collision with root package name */
    private final ParcelUuid f12380a;

    bh(ParcelUuid parcelUuid) {
        if (parcelUuid != null) {
            this.f12380a = parcelUuid;
            return;
        }
        throw new NullPointerException("Null UUID");
    }

    /* access modifiers changed from: package-private */
    public final ParcelUuid a() {
        return this.f12380a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutocompleteSessionToken) {
            return this.f12380a.equals(((AutocompleteSessionToken) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.f12380a.hashCode() ^ 1000003;
    }
}
