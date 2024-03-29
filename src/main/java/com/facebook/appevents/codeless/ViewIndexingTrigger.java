package com.facebook.appevents.codeless;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

public class ViewIndexingTrigger implements SensorEventListener {
    private static final double SHAKE_THRESHOLD_GRAVITY = 2.299999952316284d;
    private OnShakeListener mListener;

    public interface OnShakeListener {
        void onShake();
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void setOnShakeListener(OnShakeListener onShakeListener) {
        this.mListener = onShakeListener;
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.mListener != null) {
            float f2 = sensorEvent.values[0];
            double d2 = (double) (f2 / 9.80665f);
            double d3 = (double) (sensorEvent.values[1] / 9.80665f);
            double d4 = (double) (sensorEvent.values[2] / 9.80665f);
            Double.isNaN(d2);
            Double.isNaN(d2);
            Double.isNaN(d3);
            Double.isNaN(d3);
            Double.isNaN(d4);
            Double.isNaN(d4);
            if (Math.sqrt((d2 * d2) + (d3 * d3) + (d4 * d4)) > SHAKE_THRESHOLD_GRAVITY) {
                this.mListener.onShake();
            }
        }
    }
}
