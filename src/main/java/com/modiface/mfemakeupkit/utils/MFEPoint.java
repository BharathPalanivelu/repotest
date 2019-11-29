package com.modiface.mfemakeupkit.utils;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class MFEPoint {
    public float x;
    public float y;

    public MFEPoint(float f2, float f3) {
        this.x = f2;
        this.y = f3;
    }

    public String toString() {
        return this.x + ", " + this.y;
    }

    public MFEPoint() {
        this(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
    }
}
