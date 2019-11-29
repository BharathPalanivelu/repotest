package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.Period;
import com.google.android.libraries.places.api.model.TimeOfWeek;

abstract class bm extends Period {

    /* renamed from: a  reason: collision with root package name */
    private final TimeOfWeek f12389a;

    /* renamed from: b  reason: collision with root package name */
    private final TimeOfWeek f12390b;

    bm(TimeOfWeek timeOfWeek, TimeOfWeek timeOfWeek2) {
        this.f12389a = timeOfWeek;
        this.f12390b = timeOfWeek2;
    }

    public TimeOfWeek getOpen() {
        return this.f12389a;
    }

    public TimeOfWeek getClose() {
        return this.f12390b;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f12389a);
        String valueOf2 = String.valueOf(this.f12390b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 21 + String.valueOf(valueOf2).length());
        sb.append("Period{open=");
        sb.append(valueOf);
        sb.append(", close=");
        sb.append(valueOf2);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Period) {
            Period period = (Period) obj;
            TimeOfWeek timeOfWeek = this.f12389a;
            if (timeOfWeek != null ? timeOfWeek.equals(period.getOpen()) : period.getOpen() == null) {
                TimeOfWeek timeOfWeek2 = this.f12390b;
                return timeOfWeek2 != null ? timeOfWeek2.equals(period.getClose()) : period.getClose() == null;
            }
        }
    }

    public int hashCode() {
        TimeOfWeek timeOfWeek = this.f12389a;
        int i = 0;
        int hashCode = ((timeOfWeek == null ? 0 : timeOfWeek.hashCode()) ^ 1000003) * 1000003;
        TimeOfWeek timeOfWeek2 = this.f12390b;
        if (timeOfWeek2 != null) {
            i = timeOfWeek2.hashCode();
        }
        return hashCode ^ i;
    }
}
