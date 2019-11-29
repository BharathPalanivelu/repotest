package com.google.firebase.appindexing;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f6789a;

    private a(Uri uri) {
        this.f6789a = uri;
    }

    public static a a(Uri uri) {
        a aVar = new a(uri);
        if (!"android-app".equals(aVar.f6789a.getScheme())) {
            throw new IllegalArgumentException("android-app scheme is required.");
        } else if (!TextUtils.isEmpty(aVar.a())) {
            return aVar;
        } else {
            throw new IllegalArgumentException("Package name is empty.");
        }
    }

    public final String a() {
        return this.f6789a.getAuthority();
    }

    public final String toString() {
        return this.f6789a.toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.f6789a.equals(((a) obj).f6789a);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f6789a);
    }
}
