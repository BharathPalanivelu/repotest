package com.garena.c.a;

import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import com.facebook.places.model.PlaceFields;
import com.garena.android.gpns.utility.CONSTANT;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class c extends b implements LocationListener {

    /* renamed from: a  reason: collision with root package name */
    protected GoogleApiClient f7803a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f7804b = false;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f7805c = false;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public l f7806d;

    /* renamed from: e  reason: collision with root package name */
    private a f7807e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f7808f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Location f7809g;

    public void a(boolean z) {
        this.f7804b = z;
    }

    public void b(boolean z) {
        this.f7805c = z;
    }

    public boolean a() {
        return GooglePlayServicesUtil.isGooglePlayServicesAvailable(com.garena.android.appkit.tools.a.f6696a) == 0;
    }

    public synchronized void a(l lVar) {
        com.garena.android.appkit.d.a.e("start fused location manager", new Object[0]);
        if (this.f7803a != null) {
            com.garena.android.appkit.d.a.e("location client is not null when fused service is requested, killing it!!", new Object[0]);
            c();
        }
        this.f7806d = lVar;
        this.f7807e = new a();
        this.f7803a = new GoogleApiClient.Builder(com.garena.android.appkit.tools.a.f6696a).addConnectionCallbacks(this.f7807e).addOnConnectionFailedListener(this.f7807e).addApi(LocationServices.API).build();
        this.f7803a.connect();
    }

    public synchronized void c() {
        com.garena.android.appkit.d.a.e("stop fused location manager", new Object[0]);
        if (this.f7803a == null) {
            com.garena.android.appkit.d.a.a("location-attempt to stop a location client which does not exist", new Object[0]);
            this.f7807e = null;
            return;
        }
        if (this.f7803a.isConnected()) {
            try {
                this.f7803a.disconnect();
            } catch (IllegalStateException e2) {
                com.garena.android.appkit.d.a.a(e2);
            }
        }
        if (this.f7807e != null && this.f7803a.isConnectionCallbacksRegistered(this.f7807e)) {
            this.f7803a.unregisterConnectionCallbacks(this.f7807e);
        }
        if (this.f7807e != null && this.f7803a.isConnectionFailedListenerRegistered(this.f7807e)) {
            this.f7803a.unregisterConnectionFailedListener(this.f7807e);
        }
        this.f7807e = null;
        this.f7803a = null;
    }

    private class a implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
        private a() {
        }

        public void onConnectionSuspended(int i) {
            c.this.f7803a.connect();
        }

        public void onConnected(Bundle bundle) {
            com.garena.android.appkit.d.a.e("fused location service connected", new Object[0]);
            Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(c.this.f7803a);
            if (lastLocation != null) {
                Location unused = c.this.f7809g = lastLocation;
            }
            if (c.this.f7809g != null) {
                if (c.this.f7809g.getTime() <= com.garena.android.appkit.tools.a.a.b() - ((long) (c.this.f7805c ? CONSTANT.TIME.MIN_5 : CONSTANT.TIME.MIN_1))) {
                    com.garena.android.appkit.d.a.e("use last available fused location", new Object[0]);
                    c.this.f7806d.a(c.this.f7809g);
                    return;
                }
            }
            LocationRequest priority = LocationRequest.create().setPriority(100);
            if (c.this.f7804b) {
                priority.setPriority(102);
            } else {
                priority.setPriority(100);
            }
            priority.setNumUpdates(2);
            priority.setInterval(2000);
            int unused2 = c.this.f7808f = 2;
            LocationServices.FusedLocationApi.requestLocationUpdates(c.this.f7803a, priority, (LocationListener) c.this);
        }

        public void onConnectionFailed(ConnectionResult connectionResult) {
            com.garena.android.appkit.d.a.e("fused location service connection failure", new Object[0]);
            c.this.f7806d.a(connectionResult.getErrorCode());
        }
    }

    public void onLocationChanged(Location location) {
        this.f7808f--;
        com.garena.android.appkit.d.a.e("fused new location with left attempt %d", Integer.valueOf(this.f7808f));
        if (a(location)) {
            com.garena.android.appkit.d.a.e("a better fused location %s", location);
            this.f7809g = location;
        }
        if (this.f7806d != null) {
            if ((this.f7808f == 0 || this.f7805c) && this.f7809g != null) {
                com.garena.android.appkit.d.a.e("fused final attempt,return the best location", new Object[0]);
                this.f7806d.a(this.f7809g);
            } else if (this.f7808f == 0) {
                com.garena.android.appkit.d.a.e("fail to get location", new Object[0]);
                LocationManager locationManager = (LocationManager) com.garena.android.appkit.tools.a.f6696a.getSystemService(PlaceFields.LOCATION);
                if (locationManager == null) {
                    this.f7806d.a(4097);
                } else if (!locationManager.isProviderEnabled("gps") && !locationManager.isProviderEnabled("network")) {
                    this.f7806d.a(4102);
                } else if (!locationManager.isProviderEnabled("network")) {
                    this.f7806d.a(4100);
                } else if (!locationManager.isProviderEnabled("gps")) {
                    this.f7806d.a(4099);
                } else {
                    this.f7806d.a(4103);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public Location b() {
        return this.f7809g;
    }

    private boolean a(Location location) {
        if (this.f7809g == null) {
            return true;
        }
        long time = location.getTime() - this.f7809g.getTime();
        boolean z = time > 60000;
        boolean z2 = time < -60000;
        boolean z3 = time > 0;
        if (z) {
            return true;
        }
        if (z2) {
            return false;
        }
        int accuracy = (int) (location.getAccuracy() - this.f7809g.getAccuracy());
        boolean z4 = accuracy > 0;
        boolean z5 = accuracy < 0;
        boolean z6 = accuracy > 200;
        boolean a2 = a(location.getProvider(), this.f7809g.getProvider());
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
}
