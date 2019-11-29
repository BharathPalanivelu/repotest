package com.garena.c.a;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.facebook.places.model.PlaceFields;
import com.garena.android.appkit.d.a;
import com.garena.android.gpns.utility.CONSTANT;

public class k implements LocationListener {

    /* renamed from: a  reason: collision with root package name */
    private e f7838a;

    /* renamed from: b  reason: collision with root package name */
    private Location f7839b;

    /* renamed from: c  reason: collision with root package name */
    private LocationManager f7840c;

    public void onLocationChanged(Location location) {
        a.e("legacy location service :onLocationChanged:%s", location);
        if (location != null) {
            if (a(location)) {
                a.a("GPS:find the  better location", new Object[0]);
                this.f7839b = location;
                e eVar = this.f7838a;
                if (eVar != null) {
                    eVar.a();
                    return;
                }
                return;
            }
            a.e("legacy location service:find the not nice location", new Object[0]);
        }
    }

    public Location a() {
        return this.f7839b;
    }

    private boolean a(Location location) {
        if (this.f7839b == null) {
            return true;
        }
        long time = location.getTime() - this.f7839b.getTime();
        boolean z = time > 60000;
        boolean z2 = time < -60000;
        boolean z3 = time > 0;
        if (z) {
            return true;
        }
        if (z2) {
            return false;
        }
        int accuracy = (int) (location.getAccuracy() - this.f7839b.getAccuracy());
        boolean z4 = accuracy > 0;
        boolean z5 = accuracy < 0;
        boolean z6 = accuracy > 200;
        boolean a2 = a(location.getProvider(), this.f7839b.getProvider());
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

    public void onStatusChanged(String str, int i, Bundle bundle) {
        a.e("GPS:onStatusChanged:%s", str);
    }

    public void onProviderEnabled(String str) {
        a.e("GPS:onProviderEnabled:%s", str);
    }

    public void onProviderDisabled(String str) {
        a.a("GPS:onProviderDisabled:%s", str);
    }

    public int a(boolean z, boolean z2, e eVar) {
        this.f7838a = eVar;
        if (this.f7840c == null) {
            this.f7840c = (LocationManager) com.garena.android.appkit.tools.a.f6696a.getApplicationContext().getSystemService(PlaceFields.LOCATION);
        }
        LocationManager locationManager = this.f7840c;
        if (locationManager == null) {
            a.a("legacy location service: can not get the location manager.", new Object[0]);
            e eVar2 = this.f7838a;
            if (eVar2 != null) {
                eVar2.a(4098);
            }
            return 4098;
        }
        if (!(z ? locationManager.isProviderEnabled("gps") : locationManager.isProviderEnabled("network"))) {
            a.a("legacy location service: required service is disabled", new Object[0]);
            return z ? 4097 : 4099;
        }
        int i = CONSTANT.TIME.MIN_5;
        if (z) {
            this.f7839b = this.f7840c.getLastKnownLocation("gps");
            Location location = this.f7839b;
            if (location != null) {
                long time = location.getTime();
                long b2 = com.garena.android.appkit.tools.a.a.b();
                if (!z2) {
                    i = CONSTANT.TIME.MIN_1;
                }
                if (time <= b2 - ((long) i)) {
                    e eVar3 = this.f7838a;
                    if (eVar3 != null) {
                        eVar3.a();
                    }
                }
            }
            this.f7840c.requestLocationUpdates("gps", 2000, 100.0f, this);
        } else {
            this.f7839b = this.f7840c.getLastKnownLocation("network");
            Location location2 = this.f7839b;
            if (location2 != null) {
                long time2 = location2.getTime();
                long b3 = com.garena.android.appkit.tools.a.a.b();
                if (!z2) {
                    i = CONSTANT.TIME.MIN_1;
                }
                if (time2 <= b3 - ((long) i)) {
                    e eVar4 = this.f7838a;
                    if (eVar4 != null) {
                        eVar4.a();
                    }
                }
            }
            this.f7840c.requestLocationUpdates("network", 2000, 500.0f, this);
        }
        return 0;
    }

    public void b() {
        LocationManager locationManager = this.f7840c;
        if (locationManager != null) {
            locationManager.removeUpdates(this);
            this.f7840c = null;
        }
    }
}
