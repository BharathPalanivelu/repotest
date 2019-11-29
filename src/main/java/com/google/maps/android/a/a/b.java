package com.google.maps.android.a.a;

import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

public class b extends com.google.maps.android.a.b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    private final String f14373a;

    /* renamed from: b  reason: collision with root package name */
    private final LatLngBounds f14374b;

    /* renamed from: c  reason: collision with root package name */
    private j f14375c;

    /* renamed from: d  reason: collision with root package name */
    private e f14376d;

    /* renamed from: e  reason: collision with root package name */
    private l f14377e;

    public j e() {
        return this.f14375c;
    }

    public void a(j jVar) {
        if (jVar != null) {
            j jVar2 = this.f14375c;
            if (jVar2 != null) {
                jVar2.deleteObserver(this);
            }
            this.f14375c = jVar;
            this.f14375c.addObserver(this);
            a((m) this.f14375c);
            return;
        }
        throw new IllegalArgumentException("Point style cannot be null");
    }

    public e f() {
        return this.f14376d;
    }

    public void a(e eVar) {
        if (eVar != null) {
            e eVar2 = this.f14376d;
            if (eVar2 != null) {
                eVar2.deleteObserver(this);
            }
            this.f14376d = eVar;
            this.f14376d.addObserver(this);
            a((m) this.f14376d);
            return;
        }
        throw new IllegalArgumentException("Line string style cannot be null");
    }

    public l g() {
        return this.f14377e;
    }

    public void a(l lVar) {
        if (lVar != null) {
            l lVar2 = this.f14377e;
            if (lVar2 != null) {
                lVar2.deleteObserver(this);
            }
            this.f14377e = lVar;
            this.f14377e.addObserver(this);
            a((m) this.f14377e);
            return;
        }
        throw new IllegalArgumentException("Polygon style cannot be null");
    }

    public PolygonOptions h() {
        return this.f14377e.i();
    }

    public MarkerOptions i() {
        return this.f14375c.m();
    }

    public PolylineOptions j() {
        return this.f14376d.i();
    }

    private void a(m mVar) {
        if (d() && Arrays.asList(mVar.b()).contains(c().c())) {
            setChanged();
            notifyObservers();
        }
    }

    public String toString() {
        return "Feature{" + "\n bounding box=" + this.f14374b + ",\n geometry=" + c() + ",\n point style=" + this.f14375c + ",\n line string style=" + this.f14376d + ",\n polygon style=" + this.f14377e + ",\n id=" + this.f14373a + ",\n properties=" + a() + "\n}\n";
    }

    public void update(Observable observable, Object obj) {
        if (observable instanceof m) {
            a((m) observable);
        }
    }
}
