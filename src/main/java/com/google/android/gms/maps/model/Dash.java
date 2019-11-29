package com.google.android.gms.maps.model;

public final class Dash extends PatternItem {
    public final float length;

    public Dash(float f2) {
        super(0, Float.valueOf(Math.max(f2, BitmapDescriptorFactory.HUE_RED)));
        this.length = Math.max(f2, BitmapDescriptorFactory.HUE_RED);
    }

    public final String toString() {
        float f2 = this.length;
        StringBuilder sb = new StringBuilder(30);
        sb.append("[Dash: length=");
        sb.append(f2);
        sb.append("]");
        return sb.toString();
    }
}
