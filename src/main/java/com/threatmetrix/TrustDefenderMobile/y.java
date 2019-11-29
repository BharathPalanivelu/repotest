package com.threatmetrix.TrustDefenderMobile;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

class y implements LocationListener {

    /* renamed from: b  reason: collision with root package name */
    private static final String f32632b = "com.threatmetrix.TrustDefenderMobile.y";

    /* renamed from: a  reason: collision with root package name */
    private Location f32633a = null;

    public void onLocationChanged(Location location) {
        String str = f32632b;
        Log.d(str, "onLocationChanged() : " + location.getProvider() + ":" + location.getLatitude() + ":" + location.getLongitude() + ":" + location.getAccuracy());
        if (a(location, this.f32633a)) {
            this.f32633a = location;
        }
    }

    public void onProviderDisabled(String str) {
        String str2 = f32632b;
        Log.d(str2, "onProviderDisabled: " + str);
    }

    public void onProviderEnabled(String str) {
        String str2 = f32632b;
        Log.d(str2, "onProviderEnabled: " + str);
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
        String str2 = f32632b;
        StringBuilder sb = new StringBuilder();
        sb.append("onStatusChanged: ");
        sb.append(str);
        sb.append(" status: ");
        sb.append(i == 2 ? "available " : i == 1 ? "temporarily unavailable" : i == 0 ? "Out of Service" : "unknown");
        Log.d(str2, sb.toString());
    }

    /* access modifiers changed from: package-private */
    public boolean a(Location location, Location location2) {
        if (location2 == null) {
            return true;
        }
        long time = location.getTime() - location2.getTime();
        boolean z = time > 120000;
        boolean z2 = time < -120000;
        boolean z3 = time > 0;
        if (z) {
            return true;
        }
        if (z2) {
            return false;
        }
        int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
        boolean z4 = accuracy > 0;
        boolean z5 = accuracy < 0;
        boolean z6 = accuracy > 200;
        boolean a2 = a(location.getProvider(), location2.getProvider());
        if (z5) {
            return true;
        }
        if (z3 && !z4) {
            return true;
        }
        if (!z3 || z6 || !a2) {
            return false;
        }
        return true;
    }

    private boolean a(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    public Location a() {
        Location location = this.f32633a;
        if (location != null) {
            return new Location(location);
        }
        return null;
    }
}
