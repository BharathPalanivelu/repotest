package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.PlusCode;

public final class bu extends PlusCode.Builder {

    /* renamed from: a  reason: collision with root package name */
    private String f12419a;

    /* renamed from: b  reason: collision with root package name */
    private String f12420b;

    public final PlusCode.Builder setCompoundCode(String str) {
        this.f12419a = str;
        return this;
    }

    public final PlusCode.Builder setGlobalCode(String str) {
        this.f12420b = str;
        return this;
    }

    public final PlusCode build() {
        return new cu(this.f12419a, this.f12420b);
    }
}
