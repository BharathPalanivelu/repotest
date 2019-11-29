package org.a.a.a;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import java.io.Serializable;
import org.a.a.a.c;

public abstract class c<I extends c<I>> extends b {

    /* renamed from: b  reason: collision with root package name */
    protected final Context f7169b;

    /* renamed from: c  reason: collision with root package name */
    protected final Intent f7170c;

    public c(Context context, Class<?> cls) {
        this(context, new Intent(context, cls));
    }

    public c(Context context, Intent intent) {
        this.f7169b = context;
        this.f7170c = intent;
    }

    public Intent b() {
        return this.f7170c;
    }

    public I k(int i) {
        this.f7170c.setFlags(i);
        return this;
    }

    public I a(String str, boolean z) {
        this.f7170c.putExtra(str, z);
        return this;
    }

    public I a(String str, int i) {
        this.f7170c.putExtra(str, i);
        return this;
    }

    public I a(String str, long j) {
        this.f7170c.putExtra(str, j);
        return this;
    }

    public I a(String str, double d2) {
        this.f7170c.putExtra(str, d2);
        return this;
    }

    public I a(String str, String str2) {
        this.f7170c.putExtra(str, str2);
        return this;
    }

    public I a(String str, Parcelable parcelable) {
        this.f7170c.putExtra(str, parcelable);
        return this;
    }

    public I a(String str, Serializable serializable) {
        this.f7170c.putExtra(str, serializable);
        return this;
    }

    public I a(String str, byte[] bArr) {
        this.f7170c.putExtra(str, bArr);
        return this;
    }
}
