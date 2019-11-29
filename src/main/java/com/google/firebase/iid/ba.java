package com.google.firebase.iid;

import android.util.Base64;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.util.VisibleForTesting;
import java.security.KeyPair;

final class ba {

    /* renamed from: a  reason: collision with root package name */
    private final KeyPair f14146a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final long f14147b;

    @VisibleForTesting
    ba(KeyPair keyPair, long j) {
        this.f14146a = keyPair;
        this.f14147b = j;
    }

    /* access modifiers changed from: package-private */
    public final KeyPair a() {
        return this.f14146a;
    }

    /* access modifiers changed from: package-private */
    public final long b() {
        return this.f14147b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ba)) {
            return false;
        }
        ba baVar = (ba) obj;
        if (this.f14147b != baVar.f14147b || !this.f14146a.getPublic().equals(baVar.f14146a.getPublic()) || !this.f14146a.getPrivate().equals(baVar.f14146a.getPrivate())) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f14146a.getPublic(), this.f14146a.getPrivate(), Long.valueOf(this.f14147b));
    }

    /* access modifiers changed from: private */
    public final String c() {
        return Base64.encodeToString(this.f14146a.getPublic().getEncoded(), 11);
    }

    /* access modifiers changed from: private */
    public final String d() {
        return Base64.encodeToString(this.f14146a.getPrivate().getEncoded(), 11);
    }
}
