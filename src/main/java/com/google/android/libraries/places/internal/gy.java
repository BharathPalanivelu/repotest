package com.google.android.libraries.places.internal;

import com.appsflyer.share.Constants;
import java.lang.Comparable;

final class gy<C extends Comparable> extends gu<C> {
    public static final long serialVersionUID = 0;

    gy(C c2) {
        super((Comparable) go.a(c2));
    }

    /* access modifiers changed from: package-private */
    public final boolean a(C c2) {
        return hk.b(this.f6711a, (Comparable) c2) <= 0;
    }

    /* access modifiers changed from: package-private */
    public final void a(StringBuilder sb) {
        sb.append('[');
        sb.append(this.f6711a);
    }

    /* access modifiers changed from: package-private */
    public final void b(StringBuilder sb) {
        sb.append(this.f6711a);
        sb.append(')');
    }

    public final int hashCode() {
        return this.f6711a.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f6711a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 2);
        sb.append("\\");
        sb.append(valueOf);
        sb.append(Constants.URL_PATH_DELIMITER);
        return sb.toString();
    }
}
