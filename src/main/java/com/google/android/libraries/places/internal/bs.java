package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.PlaceLikelihood;

abstract class bs extends PlaceLikelihood {

    /* renamed from: a  reason: collision with root package name */
    private final Place f12415a;

    /* renamed from: b  reason: collision with root package name */
    private final double f12416b;

    bs(Place place, double d2) {
        if (place != null) {
            this.f12415a = place;
            this.f12416b = d2;
            return;
        }
        throw new NullPointerException("Null place");
    }

    public Place getPlace() {
        return this.f12415a;
    }

    public double getLikelihood() {
        return this.f12416b;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f12415a);
        double d2 = this.f12416b;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 60);
        sb.append("PlaceLikelihood{place=");
        sb.append(valueOf);
        sb.append(", likelihood=");
        sb.append(d2);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PlaceLikelihood) {
            PlaceLikelihood placeLikelihood = (PlaceLikelihood) obj;
            return this.f12415a.equals(placeLikelihood.getPlace()) && Double.doubleToLongBits(this.f12416b) == Double.doubleToLongBits(placeLikelihood.getLikelihood());
        }
    }

    public int hashCode() {
        return ((this.f12415a.hashCode() ^ 1000003) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.f12416b) >>> 32) ^ Double.doubleToLongBits(this.f12416b)));
    }
}
