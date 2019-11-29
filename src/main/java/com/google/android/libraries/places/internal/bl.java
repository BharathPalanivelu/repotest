package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.OpeningHours;
import com.google.android.libraries.places.api.model.Period;
import java.util.List;

public final class bl extends OpeningHours.Builder {

    /* renamed from: a  reason: collision with root package name */
    private List<Period> f12387a;

    /* renamed from: b  reason: collision with root package name */
    private List<String> f12388b;

    public final OpeningHours.Builder setPeriods(List<Period> list) {
        if (list != null) {
            this.f12387a = list;
            return this;
        }
        throw new NullPointerException("Null periods");
    }

    public final OpeningHours.Builder setWeekdayText(List<String> list) {
        if (list != null) {
            this.f12388b = list;
            return this;
        }
        throw new NullPointerException("Null weekdayText");
    }

    /* access modifiers changed from: package-private */
    public final OpeningHours a() {
        String str = "";
        if (this.f12387a == null) {
            str = str.concat(" periods");
        }
        if (this.f12388b == null) {
            str = String.valueOf(str).concat(" weekdayText");
        }
        if (str.isEmpty()) {
            return new ck(this.f12387a, this.f12388b);
        }
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? "Missing required properties:".concat(valueOf) : new String("Missing required properties:"));
    }
}
