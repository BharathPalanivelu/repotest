package com.modiface.mfemakeupkit.utils;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class t {

    /* renamed from: a  reason: collision with root package name */
    public float f15396a;

    /* renamed from: b  reason: collision with root package name */
    public float f15397b;

    public t(float f2, float f3) {
        this.f15396a = f2;
        this.f15397b = f3;
    }

    public boolean a(float f2, float f3) {
        return this.f15396a == f2 && this.f15397b == f3;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj == null || !(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return a(tVar.f15396a, tVar.f15397b);
    }

    public t() {
        this(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
    }
}
