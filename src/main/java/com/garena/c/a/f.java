package com.garena.c.a;

import android.location.Location;
import android.location.LocationManager;
import com.facebook.places.model.PlaceFields;

public class f {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public k f7815a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public k f7816b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public com.garena.android.appkit.f.a f7817c = new com.garena.android.appkit.f.a() {
        /* access modifiers changed from: protected */
        public void a() {
            f.this.e();
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private boolean f7818d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7819e = false;

    /* renamed from: f  reason: collision with root package name */
    private int f7820f = 0;

    /* renamed from: g  reason: collision with root package name */
    private e f7821g = new e() {
        public void a() {
            Location a2 = f.this.f7816b != null ? f.this.f7816b.a() : null;
            if (a2 == null && f.this.f7815a != null) {
                a2 = f.this.f7815a.a();
            }
            if (a2 != null) {
                f.this.i.a(a2);
                if (f.this.f7817c != null) {
                    f.this.f7817c.b();
                }
            }
        }

        public void a(int i) {
            if (i == 4098) {
                f.this.i.a(i);
            }
        }
    };
    private e h = new e() {
        public void a() {
            Location a2 = f.this.f7816b != null ? f.this.f7816b.a() : null;
            if (a2 == null && f.this.f7815a != null) {
                a2 = f.this.f7815a.a();
            }
            if (a2 != null) {
                f.this.i.a(a2);
                if (f.this.f7817c != null) {
                    f.this.f7817c.b();
                }
            }
        }

        public void a(int i) {
            if (i == 4098) {
                f.this.f7817c.b();
                f.this.i.a(i);
            }
        }
    };
    /* access modifiers changed from: private */
    public a i;
    private boolean j = true;
    private boolean k = true;

    public interface a {
        void a(int i);

        void a(Location location);
    }

    private boolean a(Location location) {
        return location == null || com.garena.android.appkit.tools.a.a.b() - location.getTime() > 1800000;
    }

    public Location a() {
        if (this.f7816b == null) {
            this.f7816b = new k();
        }
        Location a2 = this.f7816b.a();
        if (a2 == null) {
            if (this.f7815a == null) {
                this.f7815a = new k();
            }
            a2 = this.f7815a.a();
        }
        if (a2 == null) {
            LocationManager locationManager = (LocationManager) com.garena.android.appkit.tools.a.f6696a.getSystemService(PlaceFields.LOCATION);
            if (locationManager != null) {
                for (String lastKnownLocation : locationManager.getAllProviders()) {
                    a2 = locationManager.getLastKnownLocation(lastKnownLocation);
                    if (a2 != null) {
                        if (!a(a2)) {
                            break;
                        }
                        a2 = null;
                    }
                }
            }
        }
        return a2;
    }

    public void a(boolean z) {
        this.f7818d = z;
    }

    public void b(boolean z) {
        this.f7819e = z;
    }

    public boolean b() {
        return this.j;
    }

    public boolean c() {
        return this.k;
    }

    public void a(a aVar) {
        this.i = aVar;
        if (this.f7815a == null) {
            this.f7815a = new k();
        }
        this.f7820f = this.f7815a.a(false, this.f7819e, this.h);
        boolean z = true;
        this.j = this.f7820f != 4099;
        if (!this.f7818d) {
            if (this.f7816b == null) {
                this.f7816b = new k();
            }
            this.f7820f = this.f7816b.a(true, this.f7819e, this.f7821g);
            if (this.f7820f == 4097) {
                z = false;
            }
            this.k = z;
            if (!this.k) {
                this.i.a(4099);
                return;
            }
        } else if (!this.j) {
            this.i.a(4100);
            return;
        }
        com.garena.android.appkit.f.f.a().a(this.f7817c, 6000);
    }

    /* access modifiers changed from: private */
    public void e() {
        k kVar = this.f7816b;
        Location a2 = kVar != null ? kVar.a() : null;
        if (a2 == null) {
            k kVar2 = this.f7815a;
            if (kVar2 != null) {
                a2 = kVar2.a();
            }
        }
        if (a2 == null) {
            LocationManager locationManager = (LocationManager) com.garena.android.appkit.tools.a.f6696a.getSystemService(PlaceFields.LOCATION);
            if (locationManager != null) {
                for (String lastKnownLocation : locationManager.getAllProviders()) {
                    a2 = locationManager.getLastKnownLocation(lastKnownLocation);
                    if (a2 != null) {
                        break;
                    }
                }
            }
        }
        if (a2 != null) {
            this.i.a(a2);
        } else if (!this.j) {
            this.i.a(4099);
        } else if (!this.k) {
            this.i.a(4097);
        } else {
            this.i.a(4100);
        }
    }

    public void d() {
        k kVar = this.f7815a;
        if (kVar != null) {
            kVar.b();
            this.f7815a = null;
        }
        k kVar2 = this.f7816b;
        if (kVar2 != null) {
            kVar2.b();
            this.f7816b = null;
        }
        com.garena.android.appkit.f.a aVar = this.f7817c;
        if (aVar != null) {
            aVar.b();
            this.f7817c = null;
        }
    }
}
