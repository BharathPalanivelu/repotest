package com.modiface.mfemakeupkit.utils;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class MFEFaceRotation {
    public float pitch;
    public float roll;
    public float yaw;

    public MFEFaceRotation(float f2, float f3, float f4) {
        this.pitch = f2;
        this.yaw = f3;
        this.roll = f4;
    }

    public MFEFaceRotation() {
        this(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
    }
}
