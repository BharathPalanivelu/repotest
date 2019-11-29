package com.otaliastudios.cameraview;

import android.hardware.Camera;

public class m {

    /* renamed from: a  reason: collision with root package name */
    private float f15658a;

    /* renamed from: b  reason: collision with root package name */
    private float f15659b;

    m(Camera.Parameters parameters) {
        this.f15658a = parameters.getVerticalViewAngle();
        this.f15659b = parameters.getHorizontalViewAngle();
    }
}
