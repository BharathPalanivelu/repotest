package com.shopee.arcatch.c.g;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private float f26899a = BitmapDescriptorFactory.HUE_RED;

    /* renamed from: b  reason: collision with root package name */
    private float f26900b = Float.MAX_VALUE;

    /* renamed from: c  reason: collision with root package name */
    private int f26901c = 0;

    /* renamed from: d  reason: collision with root package name */
    private float f26902d = BitmapDescriptorFactory.HUE_RED;

    /* renamed from: e  reason: collision with root package name */
    private String f26903e;

    public i(String str) {
        this.f26903e = str;
    }

    public void a(float f2) {
        this.f26901c++;
        if (f2 > this.f26899a) {
            this.f26899a = f2;
        }
        if (f2 < this.f26900b) {
            this.f26900b = f2;
        }
        this.f26902d += f2;
    }

    public float a() {
        return this.f26899a;
    }

    public float b() {
        return this.f26900b;
    }

    public float c() {
        int i = this.f26901c;
        return i != 0 ? this.f26902d / ((float) i) : BitmapDescriptorFactory.HUE_RED;
    }

    public String d() {
        return this.f26903e;
    }
}
