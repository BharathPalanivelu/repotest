package com.otaliastudios.cameraview;

import android.hardware.Camera;
import com.otaliastudios.cameraview.y;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private Set<ao> f15636a = new HashSet(5);

    /* renamed from: b  reason: collision with root package name */
    private Set<n> f15637b = new HashSet(2);

    /* renamed from: c  reason: collision with root package name */
    private Set<o> f15638c = new HashSet(4);

    /* renamed from: d  reason: collision with root package name */
    private Set<x> f15639d = new HashSet(2);

    /* renamed from: e  reason: collision with root package name */
    private Set<af> f15640e = new HashSet(15);

    /* renamed from: f  reason: collision with root package name */
    private Set<a> f15641f = new HashSet(4);

    /* renamed from: g  reason: collision with root package name */
    private boolean f15642g;
    private boolean h;
    private boolean i;
    private float j;
    private float k;
    private boolean l;

    h(Camera.Parameters parameters, boolean z) {
        y.a aVar = new y.a();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        boolean z2 = false;
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            n b2 = aVar.b(Integer.valueOf(cameraInfo.facing));
            if (b2 != null) {
                this.f15637b.add(b2);
            }
        }
        List<String> supportedWhiteBalance = parameters.getSupportedWhiteBalance();
        if (supportedWhiteBalance != null) {
            for (String c2 : supportedWhiteBalance) {
                ao c3 = aVar.c(c2);
                if (c3 != null) {
                    this.f15636a.add(c3);
                }
            }
        }
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (supportedFlashModes != null) {
            for (String a2 : supportedFlashModes) {
                o a3 = aVar.a(a2);
                if (a3 != null) {
                    this.f15638c.add(a3);
                }
            }
        }
        List<String> supportedSceneModes = parameters.getSupportedSceneModes();
        if (supportedSceneModes != null) {
            for (String d2 : supportedSceneModes) {
                x d3 = aVar.d(d2);
                if (d3 != null) {
                    this.f15639d.add(d3);
                }
            }
        }
        this.f15642g = parameters.isZoomSupported();
        this.h = parameters.isVideoSnapshotSupported();
        this.l = parameters.getSupportedFocusModes().contains("auto");
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        this.j = ((float) parameters.getMinExposureCompensation()) * exposureCompensationStep;
        this.k = ((float) parameters.getMaxExposureCompensation()) * exposureCompensationStep;
        this.i = (parameters.getMinExposureCompensation() == 0 && parameters.getMaxExposureCompensation() == 0) ? z2 : true;
        for (Camera.Size next : parameters.getSupportedPictureSizes()) {
            int i3 = z ? next.height : next.width;
            int i4 = z ? next.width : next.height;
            this.f15640e.add(new af(i3, i4));
            this.f15641f.add(a.a(i3, i4));
        }
    }

    public boolean a(k kVar) {
        return a(kVar.getClass()).contains(kVar);
    }

    public <T extends k> Collection<T> a(Class<T> cls) {
        if (cls.equals(b.class)) {
            return Arrays.asList(b.values());
        }
        if (cls.equals(n.class)) {
            return b();
        }
        if (cls.equals(o.class)) {
            return c();
        }
        if (cls.equals(v.class)) {
            return Arrays.asList(v.values());
        }
        if (cls.equals(x.class)) {
            return e();
        }
        if (cls.equals(ae.class)) {
            return Arrays.asList(ae.values());
        }
        if (cls.equals(an.class)) {
            return Arrays.asList(an.values());
        }
        if (cls.equals(ao.class)) {
            return d();
        }
        return Collections.emptyList();
    }

    public Set<af> a() {
        return Collections.unmodifiableSet(this.f15640e);
    }

    public Set<n> b() {
        return Collections.unmodifiableSet(this.f15637b);
    }

    public Set<o> c() {
        return Collections.unmodifiableSet(this.f15638c);
    }

    public Set<ao> d() {
        return Collections.unmodifiableSet(this.f15636a);
    }

    public Set<x> e() {
        return Collections.unmodifiableSet(this.f15639d);
    }

    public boolean f() {
        return this.f15642g;
    }

    public boolean g() {
        return this.h;
    }

    public boolean h() {
        return this.l;
    }

    public boolean i() {
        return this.i;
    }

    public float j() {
        return this.j;
    }

    public float k() {
        return this.k;
    }
}
