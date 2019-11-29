package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.DayOfWeek;
import com.google.android.libraries.places.api.model.LocalTime;
import com.google.android.libraries.places.api.model.TimeOfWeek;

abstract class bx extends TimeOfWeek {

    /* renamed from: a  reason: collision with root package name */
    private final DayOfWeek f12425a;

    /* renamed from: b  reason: collision with root package name */
    private final LocalTime f12426b;

    bx(DayOfWeek dayOfWeek, LocalTime localTime) {
        if (dayOfWeek != null) {
            this.f12425a = dayOfWeek;
            if (localTime != null) {
                this.f12426b = localTime;
                return;
            }
            throw new NullPointerException("Null time");
        }
        throw new NullPointerException("Null day");
    }

    public DayOfWeek getDay() {
        return this.f12425a;
    }

    public LocalTime getTime() {
        return this.f12426b;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f12425a);
        String valueOf2 = String.valueOf(this.f12426b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23 + String.valueOf(valueOf2).length());
        sb.append("TimeOfWeek{day=");
        sb.append(valueOf);
        sb.append(", time=");
        sb.append(valueOf2);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TimeOfWeek) {
            TimeOfWeek timeOfWeek = (TimeOfWeek) obj;
            return this.f12425a.equals(timeOfWeek.getDay()) && this.f12426b.equals(timeOfWeek.getTime());
        }
    }

    public int hashCode() {
        return ((this.f12425a.hashCode() ^ 1000003) * 1000003) ^ this.f12426b.hashCode();
    }
}
