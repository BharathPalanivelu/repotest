package com.firebase.jobdispatcher;

import android.net.Uri;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f7257a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7258b;

    public w(Uri uri, int i) {
        if (uri != null) {
            this.f7257a = uri;
            this.f7258b = i;
            return;
        }
        throw new IllegalArgumentException("URI must not be null.");
    }

    public Uri a() {
        return this.f7257a;
    }

    public int b() {
        return this.f7258b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        if (this.f7258b != wVar.f7258b || !this.f7257a.equals(wVar.f7257a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f7257a.hashCode() ^ this.f7258b;
    }
}
