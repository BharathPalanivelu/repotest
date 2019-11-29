package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.Period;
import com.google.android.libraries.places.api.model.TimeOfWeek;

public final class bn extends Period.Builder {

    /* renamed from: a  reason: collision with root package name */
    private TimeOfWeek f12391a;

    /* renamed from: b  reason: collision with root package name */
    private TimeOfWeek f12392b;

    public final Period.Builder setOpen(TimeOfWeek timeOfWeek) {
        this.f12391a = timeOfWeek;
        return this;
    }

    public final Period.Builder setClose(TimeOfWeek timeOfWeek) {
        this.f12392b = timeOfWeek;
        return this;
    }

    public final Period build() {
        return new cm(this.f12391a, this.f12392b);
    }
}
