package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.PhotoMetadata;

public final class bp extends PhotoMetadata.Builder {

    /* renamed from: a  reason: collision with root package name */
    private String f12397a;

    /* renamed from: b  reason: collision with root package name */
    private Integer f12398b;

    /* renamed from: c  reason: collision with root package name */
    private Integer f12399c;

    /* renamed from: d  reason: collision with root package name */
    private String f12400d;

    public final PhotoMetadata.Builder setAttributions(String str) {
        if (str != null) {
            this.f12397a = str;
            return this;
        }
        throw new NullPointerException("Null attributions");
    }

    public final PhotoMetadata.Builder setHeight(int i) {
        this.f12398b = Integer.valueOf(i);
        return this;
    }

    public final PhotoMetadata.Builder setWidth(int i) {
        this.f12399c = Integer.valueOf(i);
        return this;
    }

    /* access modifiers changed from: package-private */
    public final PhotoMetadata.Builder a(String str) {
        if (str != null) {
            this.f12400d = str;
            return this;
        }
        throw new NullPointerException("Null photoReference");
    }

    /* access modifiers changed from: package-private */
    public final PhotoMetadata a() {
        String str = "";
        if (this.f12397a == null) {
            str = str.concat(" attributions");
        }
        if (this.f12398b == null) {
            str = String.valueOf(str).concat(" height");
        }
        if (this.f12399c == null) {
            str = String.valueOf(str).concat(" width");
        }
        if (this.f12400d == null) {
            str = String.valueOf(str).concat(" photoReference");
        }
        if (str.isEmpty()) {
            return new co(this.f12397a, this.f12398b.intValue(), this.f12399c.intValue(), this.f12400d);
        }
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? "Missing required properties:".concat(valueOf) : new String("Missing required properties:"));
    }
}
