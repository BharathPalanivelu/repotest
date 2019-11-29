package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.OpeningHours;
import com.google.android.libraries.places.api.model.Period;
import java.util.List;

abstract class bk extends OpeningHours {

    /* renamed from: a  reason: collision with root package name */
    private final List<Period> f12385a;

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f12386b;

    bk(List<Period> list, List<String> list2) {
        if (list != null) {
            this.f12385a = list;
            if (list2 != null) {
                this.f12386b = list2;
                return;
            }
            throw new NullPointerException("Null weekdayText");
        }
        throw new NullPointerException("Null periods");
    }

    public List<Period> getPeriods() {
        return this.f12385a;
    }

    public List<String> getWeekdayText() {
        return this.f12386b;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f12385a);
        String valueOf2 = String.valueOf(this.f12386b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 36 + String.valueOf(valueOf2).length());
        sb.append("OpeningHours{periods=");
        sb.append(valueOf);
        sb.append(", weekdayText=");
        sb.append(valueOf2);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof OpeningHours) {
            OpeningHours openingHours = (OpeningHours) obj;
            return this.f12385a.equals(openingHours.getPeriods()) && this.f12386b.equals(openingHours.getWeekdayText());
        }
    }

    public int hashCode() {
        return ((this.f12385a.hashCode() ^ 1000003) * 1000003) ^ this.f12386b.hashCode();
    }
}
