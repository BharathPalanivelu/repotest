package com.google.maps.android;

import com.google.android.gms.maps.model.LatLng;

public class b {
    public static LatLng a(LatLng latLng, double d2, double d3) {
        double d4 = d2 / 6371009.0d;
        double radians = Math.toRadians(d3);
        double radians2 = Math.toRadians(latLng.latitude);
        double radians3 = Math.toRadians(latLng.longitude);
        double cos = Math.cos(d4);
        double sin = Math.sin(d4);
        double sin2 = Math.sin(radians2);
        double cos2 = sin * Math.cos(radians2);
        double cos3 = (cos * sin2) + (Math.cos(radians) * cos2);
        return new LatLng(Math.toDegrees(Math.asin(cos3)), Math.toDegrees(radians3 + Math.atan2(cos2 * Math.sin(radians), cos - (sin2 * cos3))));
    }
}
