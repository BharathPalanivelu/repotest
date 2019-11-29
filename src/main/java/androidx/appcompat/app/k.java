package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.core.content.c;
import com.facebook.places.model.PlaceFields;
import java.util.Calendar;

class k {

    /* renamed from: a  reason: collision with root package name */
    private static k f672a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f673b;

    /* renamed from: c  reason: collision with root package name */
    private final LocationManager f674c;

    /* renamed from: d  reason: collision with root package name */
    private final a f675d = new a();

    static k a(Context context) {
        if (f672a == null) {
            Context applicationContext = context.getApplicationContext();
            f672a = new k(applicationContext, (LocationManager) applicationContext.getSystemService(PlaceFields.LOCATION));
        }
        return f672a;
    }

    k(Context context, LocationManager locationManager) {
        this.f673b = context;
        this.f674c = locationManager;
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        a aVar = this.f675d;
        if (c()) {
            return aVar.f676a;
        }
        Location b2 = b();
        if (b2 != null) {
            a(b2);
            return aVar.f676a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location location = null;
        Location a2 = c.a(this.f673b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? a("network") : null;
        if (c.a(this.f673b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = a("gps");
        }
        return (location == null || a2 == null) ? location != null ? location : a2 : location.getTime() > a2.getTime() ? location : a2;
    }

    private Location a(String str) {
        try {
            if (this.f674c.isProviderEnabled(str)) {
                return this.f674c.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e2) {
            Log.d("TwilightManager", "Failed to get last known location", e2);
            return null;
        }
    }

    private boolean c() {
        return this.f675d.f681f > System.currentTimeMillis();
    }

    private void a(Location location) {
        long j;
        a aVar = this.f675d;
        long currentTimeMillis = System.currentTimeMillis();
        j a2 = j.a();
        j jVar = a2;
        jVar.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = a2.f669a;
        jVar.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a2.f671c == 1;
        long j3 = a2.f670b;
        long j4 = j2;
        long j5 = a2.f669a;
        long j6 = j3;
        boolean z2 = z;
        a2.a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j7 = a2.f670b;
        if (j6 == -1 || j5 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = (currentTimeMillis > j5 ? 0 + j7 : currentTimeMillis > j6 ? 0 + j5 : 0 + j6) + 60000;
        }
        aVar.f676a = z2;
        aVar.f677b = j4;
        aVar.f678c = j6;
        aVar.f679d = j5;
        aVar.f680e = j7;
        aVar.f681f = j;
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f676a;

        /* renamed from: b  reason: collision with root package name */
        long f677b;

        /* renamed from: c  reason: collision with root package name */
        long f678c;

        /* renamed from: d  reason: collision with root package name */
        long f679d;

        /* renamed from: e  reason: collision with root package name */
        long f680e;

        /* renamed from: f  reason: collision with root package name */
        long f681f;

        a() {
        }
    }
}
