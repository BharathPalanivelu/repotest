package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.LocalTime;

abstract class bi extends LocalTime {

    /* renamed from: a  reason: collision with root package name */
    private final int f12381a;

    /* renamed from: b  reason: collision with root package name */
    private final int f12382b;

    bi(int i, int i2) {
        this.f12381a = i;
        this.f12382b = i2;
    }

    public int getHours() {
        return this.f12381a;
    }

    public int getMinutes() {
        return this.f12382b;
    }

    public String toString() {
        int i = this.f12381a;
        int i2 = this.f12382b;
        StringBuilder sb = new StringBuilder(49);
        sb.append("LocalTime{hours=");
        sb.append(i);
        sb.append(", minutes=");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LocalTime) {
            LocalTime localTime = (LocalTime) obj;
            return this.f12381a == localTime.getHours() && this.f12382b == localTime.getMinutes();
        }
    }

    public int hashCode() {
        return ((this.f12381a ^ 1000003) * 1000003) ^ this.f12382b;
    }
}
