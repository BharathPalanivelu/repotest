package com.garena.c.a;

import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import com.facebook.places.model.PlaceFields;
import com.garena.android.appkit.d.a;
import com.garena.android.appkit.f.f;
import com.garena.c.a.f;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private static i f7825a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public f f7826b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Location f7827c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f7828d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f7829e = false;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public CopyOnWriteArraySet<j> f7830f = new CopyOnWriteArraySet<>();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public b f7831g;
    /* access modifiers changed from: private */
    public Location h;
    private Runnable i = new Runnable() {
        public synchronized void run() {
            int i;
            if (i.this.f7829e) {
                a.a("location - failed to get the location", new Object[0]);
                int i2 = 4096;
                int i3 = 14000;
                Location location = null;
                if (i.this.f7831g != null) {
                    Location b2 = i.this.f7831g.b();
                    LocationManager locationManager = (LocationManager) com.garena.android.appkit.tools.a.f6696a.getSystemService(PlaceFields.LOCATION);
                    if (b2 == null && locationManager != null) {
                        for (String lastKnownLocation : locationManager.getAllProviders()) {
                            b2 = locationManager.getLastKnownLocation(lastKnownLocation);
                            if (b2 != null) {
                                if (!i.this.a(b2)) {
                                    break;
                                }
                                b2 = null;
                            }
                        }
                    }
                    location = b2;
                    if (location == null) {
                        if (locationManager == null) {
                            i2 = 4097;
                        } else {
                            i2 = (locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network")) ? !locationManager.isProviderEnabled("network") ? 4100 : !locationManager.isProviderEnabled("gps") ? 4099 : 4103 : 4102;
                        }
                    }
                    com.garena.android.appkit.f.a unused = i.this.j = new com.garena.android.appkit.f.a() {
                        /* access modifiers changed from: protected */
                        public void a() {
                            if (i.this.f7831g != null) {
                                i.this.f7831g.c();
                                b unused = i.this.f7831g = null;
                            }
                        }
                    };
                    f.a().a(i.this.j, Build.VERSION.SDK_INT >= 10 ? 14000 : 54000);
                }
                if (i.this.f7826b != null) {
                    location = i.this.f7826b.a();
                    if (!i.this.f7826b.b() && !i.this.f7826b.c()) {
                        i = 4102;
                    } else if (!i.this.f7826b.c()) {
                        i = 4099;
                    } else {
                        i = !i.this.f7826b.b() ? 4100 : 4103;
                    }
                    com.garena.android.appkit.f.a unused2 = i.this.k = new com.garena.android.appkit.f.a() {
                        /* access modifiers changed from: protected */
                        public void a() {
                            if (i.this.f7826b != null) {
                                i.this.f7826b.d();
                                f unused = i.this.f7826b = null;
                            }
                        }
                    };
                    f a2 = f.a();
                    com.garena.android.appkit.f.a g2 = i.this.k;
                    if (Build.VERSION.SDK_INT < 10) {
                        i3 = 54000;
                    }
                    a2.a(g2, i3);
                }
                if (location != null) {
                    Iterator it = i.this.f7830f.iterator();
                    while (it.hasNext()) {
                        ((j) it.next()).a(location);
                    }
                } else {
                    Iterator it2 = i.this.f7830f.iterator();
                    while (it2.hasNext()) {
                        ((j) it2.next()).a(i);
                    }
                }
                i.this.i();
                boolean unused3 = i.this.f7829e = false;
            }
        }
    };
    /* access modifiers changed from: private */
    public com.garena.android.appkit.f.a j;
    /* access modifiers changed from: private */
    public com.garena.android.appkit.f.a k;
    private boolean l = false;
    private boolean m = false;

    public static i a() {
        if (f7825a == null) {
            f7825a = new i();
        }
        return f7825a;
    }

    private i() {
    }

    private void f() {
        this.f7831g.a(this.l);
        this.f7831g.b(this.m);
        this.f7829e = true;
        f.a().b(this.j);
        this.f7831g.a((l) new l() {
            public void a(Location location) {
                boolean unused = i.this.f7829e = false;
                Location unused2 = i.this.f7827c = location;
                Location unused3 = i.this.h = location;
                int unused4 = i.this.f7828d = com.garena.android.appkit.tools.a.a.a();
                if (i.this.f7831g != null) {
                    f.a().a(new Runnable() {
                        public void run() {
                            if (i.this.f7831g != null) {
                                i.this.f7831g.c();
                                b unused = i.this.f7831g = null;
                            }
                        }
                    });
                }
                Iterator it = i.this.f7830f.iterator();
                while (it.hasNext()) {
                    ((j) it.next()).a(location);
                }
                i.this.i();
            }

            public void a(int i) {
                boolean unused = i.this.f7829e = false;
                if (i.this.f7831g != null) {
                    i.this.f7831g.c();
                }
                b unused2 = i.this.f7831g = null;
                Iterator it = i.this.f7830f.iterator();
                while (it.hasNext()) {
                    ((j) it.next()).a(i);
                }
                i.this.i();
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x007b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.location.Location b() {
        /*
            r5 = this;
            android.location.Location r0 = r5.h
            if (r0 == 0) goto L_0x000d
            boolean r0 = r5.a((android.location.Location) r0)
            if (r0 != 0) goto L_0x000d
            android.location.Location r0 = r5.h
            return r0
        L_0x000d:
            android.app.Application r0 = com.garena.android.appkit.tools.a.f6696a
            java.lang.String r1 = "location"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.location.LocationManager r0 = (android.location.LocationManager) r0
            r1 = 0
            if (r0 == 0) goto L_0x0076
            java.lang.String r2 = "network"
            android.location.Location r2 = r0.getLastKnownLocation(r2)     // Catch:{ Exception -> 0x0064 }
            java.lang.String r3 = "gps"
            android.location.Location r3 = r0.getLastKnownLocation(r3)     // Catch:{ Exception -> 0x0064 }
            if (r2 == 0) goto L_0x002b
            if (r3 != 0) goto L_0x002b
            return r2
        L_0x002b:
            if (r3 == 0) goto L_0x0030
            if (r2 != 0) goto L_0x0030
            return r3
        L_0x0030:
            if (r2 == 0) goto L_0x0046
            if (r3 == 0) goto L_0x0046
            android.location.Location r2 = r5.a((android.location.Location) r3, (android.location.Location) r2)     // Catch:{ Exception -> 0x0064 }
            boolean r3 = r5.a((android.location.Location) r2)     // Catch:{ Exception -> 0x0064 }
            if (r3 != 0) goto L_0x003f
            return r2
        L_0x003f:
            android.location.Location r2 = r5.h     // Catch:{ Exception -> 0x0064 }
            if (r2 == 0) goto L_0x0046
            android.location.Location r0 = r5.h     // Catch:{ Exception -> 0x0064 }
            return r0
        L_0x0046:
            java.util.List r2 = r0.getAllProviders()     // Catch:{ Exception -> 0x0064 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0064 }
            r3 = r1
        L_0x004f:
            boolean r4 = r2.hasNext()     // Catch:{ Exception -> 0x0062 }
            if (r4 == 0) goto L_0x0077
            java.lang.Object r4 = r2.next()     // Catch:{ Exception -> 0x0062 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0062 }
            android.location.Location r3 = r0.getLastKnownLocation(r4)     // Catch:{ Exception -> 0x0062 }
            if (r3 == 0) goto L_0x004f
            return r3
        L_0x0062:
            r0 = move-exception
            goto L_0x0066
        L_0x0064:
            r0 = move-exception
            r3 = r1
        L_0x0066:
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r4 = 0
            java.lang.String r0 = r0.getMessage()
            r2[r4] = r0
            java.lang.String r0 = "%s"
            com.garena.android.appkit.d.a.a(r0, r2)
            goto L_0x0077
        L_0x0076:
            r3 = r1
        L_0x0077:
            android.location.Location r0 = r5.f7827c
            if (r0 == 0) goto L_0x007c
            return r0
        L_0x007c:
            if (r3 == 0) goto L_0x007f
            return r3
        L_0x007f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.garena.c.a.i.b():android.location.Location");
    }

    private Location a(Location location, Location location2) {
        long time = location.getTime() - location2.getTime();
        boolean z = true;
        boolean z2 = time > 60000;
        boolean z3 = time < -60000;
        if (z2) {
            return location;
        }
        if (z3) {
            return location2;
        }
        if (((int) (location.getAccuracy() - location2.getAccuracy())) >= 0) {
            z = false;
        }
        return z ? location : location2;
    }

    public boolean c() {
        LocationManager locationManager = (LocationManager) com.garena.android.appkit.tools.a.f6696a.getSystemService(PlaceFields.LOCATION);
        if (locationManager == null) {
            return false;
        }
        if (locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network")) {
            return true;
        }
        return false;
    }

    public boolean d() {
        LocationManager locationManager = (LocationManager) com.garena.android.appkit.tools.a.f6696a.getSystemService(PlaceFields.LOCATION);
        if (locationManager != null && locationManager.isProviderEnabled("gps") && locationManager.isProviderEnabled("network")) {
            return true;
        }
        return false;
    }

    private void a(int i2) {
        g();
        f.a().a(this.i, i2);
    }

    private void g() {
        f.a().b(this.i);
    }

    public boolean e() {
        return ((LocationManager) com.garena.android.appkit.tools.a.f6696a.getApplicationContext().getSystemService(PlaceFields.LOCATION)) != null;
    }

    public void a(j jVar) {
        if (jVar != null) {
            if (this.f7831g == null) {
                this.f7831g = g.a();
            }
            a(6000);
            if (!h()) {
                Location location = this.f7827c;
                if (location != null) {
                    jVar.a(location);
                    return;
                }
            }
            this.f7830f.add(jVar);
            if (!this.f7829e) {
                this.f7829e = true;
                if (this.f7831g.a()) {
                    a.e("used fused location service", new Object[0]);
                    f();
                } else if (!c()) {
                    this.f7829e = false;
                    int i2 = !e() ? 4097 : 4102;
                    Iterator<j> it = this.f7830f.iterator();
                    while (it.hasNext()) {
                        it.next().a(i2);
                    }
                    f fVar = this.f7826b;
                    if (fVar != null) {
                        fVar.d();
                    }
                    this.f7826b = null;
                    i();
                } else {
                    f.a().b(this.k);
                    f fVar2 = this.f7826b;
                    if (fVar2 != null) {
                        fVar2.d();
                    }
                    this.f7826b = new f();
                    this.f7826b.a(this.l);
                    this.f7826b.b(this.m);
                    this.f7826b.a((f.a) new f.a() {
                        public void a(Location location) {
                            boolean unused = i.this.f7829e = false;
                            Location unused2 = i.this.f7827c = location;
                            int unused3 = i.this.f7828d = com.garena.android.appkit.tools.a.a.a();
                            Iterator it = i.this.f7830f.iterator();
                            while (it.hasNext()) {
                                ((j) it.next()).a(location);
                            }
                            if (i.this.f7826b != null) {
                                i.this.f7826b.d();
                            }
                            f unused4 = i.this.f7826b = null;
                            i.this.i();
                        }

                        public void a(int i) {
                            int i2;
                            boolean z = false;
                            boolean unused = i.this.f7829e = false;
                            switch (i) {
                                case 4097:
                                    i2 = 4099;
                                    break;
                                case 4098:
                                    z = true;
                                    i2 = 4097;
                                    break;
                                case 4099:
                                    i2 = 4100;
                                    break;
                                default:
                                    i2 = 4096;
                                    break;
                            }
                            Iterator it = i.this.f7830f.iterator();
                            while (it.hasNext()) {
                                ((j) it.next()).a(i2);
                            }
                            if (z) {
                                if (i.this.f7826b != null) {
                                    i.this.f7826b.d();
                                }
                                f unused2 = i.this.f7826b = null;
                                i.this.i();
                            }
                        }
                    });
                }
            }
        }
    }

    private boolean h() {
        return com.garena.android.appkit.tools.a.a.a() - this.f7828d > (this.m ? 300 : 120);
    }

    /* access modifiers changed from: private */
    public boolean a(Location location) {
        return location == null || com.garena.android.appkit.tools.a.a.b() - location.getTime() > 1800000;
    }

    public void a(boolean z) {
        this.l = z;
    }

    public void b(boolean z) {
        this.m = z;
    }

    /* access modifiers changed from: private */
    public void i() {
        g();
        this.f7830f.clear();
    }

    public void b(j jVar) {
        this.f7830f.remove(jVar);
    }
}
