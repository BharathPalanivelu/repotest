package com.threatmetrix.TrustDefenderMobile;

import android.location.Location;
import android.location.LocationManager;

class z {

    /* renamed from: a  reason: collision with root package name */
    private static final String f32634a = "com.threatmetrix.TrustDefenderMobile.z";

    /* renamed from: b  reason: collision with root package name */
    private Location f32635b;

    /* renamed from: c  reason: collision with root package name */
    private LocationManager f32636c;

    /* renamed from: d  reason: collision with root package name */
    private y f32637d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f32638e = false;

    z() {
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return (this.f32636c == null || this.f32637d == null) ? false : true;
    }

    public void b() {
        if (a()) {
            this.f32636c.removeUpdates(this.f32637d);
        }
    }

    public Location c() {
        Location location = this.f32635b;
        if (location != null) {
            return location;
        }
        y yVar = this.f32637d;
        return yVar != null ? yVar.a() : location;
    }
}
