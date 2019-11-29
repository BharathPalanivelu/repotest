package com.airbnb.android.react.maps;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class n {
    public static boolean a(LatLngBounds latLngBounds, LatLngBounds latLngBounds2) {
        LatLngBounds latLngBounds3 = latLngBounds;
        LatLngBounds latLngBounds4 = latLngBounds2;
        LatLng center = latLngBounds.getCenter();
        double d2 = center.latitude;
        double d3 = center.longitude;
        double d4 = latLngBounds3.northeast.latitude - latLngBounds3.southwest.latitude;
        double d5 = latLngBounds3.northeast.longitude - latLngBounds3.southwest.longitude;
        LatLng center2 = latLngBounds2.getCenter();
        double d6 = center2.latitude;
        double d7 = center2.longitude;
        double d8 = d4;
        double d9 = latLngBounds4.northeast.latitude - latLngBounds4.southwest.latitude;
        double d10 = latLngBounds4.northeast.longitude - latLngBounds4.southwest.longitude;
        double b2 = b(latLngBounds, latLngBounds2);
        double c2 = c(latLngBounds, latLngBounds2);
        return a(d2, d6, b2) || a(d3, d7, c2) || a(d8, d9, b2) || a(d5, d10, c2);
    }

    private static boolean a(double d2, double d3, double d4) {
        return Math.abs(d2 - d3) > d4;
    }

    private static double b(LatLngBounds latLngBounds, LatLngBounds latLngBounds2) {
        return Math.min(Math.abs(latLngBounds.northeast.latitude - latLngBounds.southwest.latitude), Math.abs(latLngBounds2.northeast.latitude - latLngBounds2.southwest.latitude)) / 2560.0d;
    }

    private static double c(LatLngBounds latLngBounds, LatLngBounds latLngBounds2) {
        return Math.min(Math.abs(latLngBounds.northeast.longitude - latLngBounds.southwest.longitude), Math.abs(latLngBounds2.northeast.longitude - latLngBounds2.southwest.longitude)) / 2560.0d;
    }
}
