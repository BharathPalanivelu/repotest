package com.facebook.react.uimanager.layoutanimation;

import android.view.animation.Interpolator;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;

class SimpleSpringInterpolator implements Interpolator {
    private static final float FACTOR = 0.5f;
    public static final String PARAM_SPRING_DAMPING = "springDamping";
    private final float mSpringDamping;

    public static float getSpringDamping(ReadableMap readableMap) {
        return readableMap.getType(PARAM_SPRING_DAMPING).equals(ReadableType.Number) ? (float) readableMap.getDouble(PARAM_SPRING_DAMPING) : FACTOR;
    }

    public SimpleSpringInterpolator() {
        this.mSpringDamping = FACTOR;
    }

    public SimpleSpringInterpolator(float f2) {
        this.mSpringDamping = f2;
    }

    public float getInterpolation(float f2) {
        double pow = Math.pow(2.0d, (double) (-10.0f * f2));
        float f3 = this.mSpringDamping;
        double d2 = (double) (f2 - (f3 / 4.0f));
        Double.isNaN(d2);
        double d3 = (double) f3;
        Double.isNaN(d3);
        return (float) ((pow * Math.sin(((d2 * 3.141592653589793d) * 2.0d) / d3)) + 1.0d);
    }
}
