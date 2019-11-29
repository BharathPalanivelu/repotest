package com.google.android.libraries.places.internal;

import android.location.Location;
import android.text.TextUtils;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.RectangularBounds;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

public final class ap {

    /* renamed from: a  reason: collision with root package name */
    private static final hd<i, String> f12342a = new he().a(i.NONE, "NONE").a(i.PSK, "WPA_PSK").a(i.EAP, "WPA_EAP").a(i.OTHER, "SECURED_NONE").a();

    public static String a(ha<fu> haVar) {
        ArrayList arrayList = new ArrayList(haVar.size());
        ha haVar2 = haVar;
        int size = haVar2.size();
        hu huVar = null;
        int i = 0;
        while (i < size) {
            Object obj = haVar2.get(i);
            i++;
            fu fuVar = (fu) obj;
            arrayList.add(hj.b(",").a(SimpleComparison.EQUAL_TO_OPERATION).a((Map<?, ?>) new he().a("mac", fuVar.c()).a("strength_dbm", Integer.valueOf(fuVar.d())).a("wifi_auth_type", f12342a.get(fuVar.e())).a("is_connected", Boolean.valueOf(fuVar.f())).a("frequency_mhz", Integer.valueOf(fuVar.g())).a()));
        }
        return hj.b("|").a().a((Iterable<?>) arrayList);
    }

    public static Integer a(Location location) {
        if (location == null) {
            return null;
        }
        float accuracy = location.getAccuracy();
        if (!location.hasAccuracy() || accuracy <= BitmapDescriptorFactory.HUE_RED) {
            return null;
        }
        return Integer.valueOf(Math.round(accuracy * 100.0f));
    }

    public static String b(Location location) {
        if (location == null) {
            return null;
        }
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        return String.format(Locale.US, "%.15f,%.15f", new Object[]{Double.valueOf(latitude), Double.valueOf(longitude)});
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String valueOf = String.valueOf(str);
        return valueOf.length() != 0 ? "country:".concat(valueOf) : new String("country:");
    }

    public static String a(LocationBias locationBias) {
        if (locationBias == null) {
            return null;
        }
        if (locationBias instanceof RectangularBounds) {
            return a((RectangularBounds) locationBias);
        }
        throw new AssertionError("Unknown LocationBias type.");
    }

    public static String a(LocationRestriction locationRestriction) {
        if (locationRestriction == null) {
            return null;
        }
        if (locationRestriction instanceof RectangularBounds) {
            return a((RectangularBounds) locationRestriction);
        }
        throw new AssertionError("Unknown LocationRestriction type.");
    }

    private static String a(RectangularBounds rectangularBounds) {
        LatLng southwest = rectangularBounds.getSouthwest();
        double d2 = southwest.latitude;
        double d3 = southwest.longitude;
        LatLng northeast = rectangularBounds.getNortheast();
        double d4 = northeast.latitude;
        double d5 = northeast.longitude;
        return String.format(Locale.US, "rectangle:%.15f,%.15f|%.15f,%.15f", new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5)});
    }
}
