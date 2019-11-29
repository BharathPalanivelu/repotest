package com.facebook.react.common;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.facebook.infer.annotation.Assertions;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.concurrent.TimeUnit;

public class ShakeDetector implements SensorEventListener {
    private static final long MIN_TIME_BETWEEN_SAMPLES_NS = TimeUnit.NANOSECONDS.convert(20, TimeUnit.MILLISECONDS);
    private static final float REQUIRED_FORCE = 13.042845f;
    private static final float SHAKING_WINDOW_NS = ((float) TimeUnit.NANOSECONDS.convert(3, TimeUnit.SECONDS));
    private float mAccelerationX;
    private float mAccelerationY;
    private float mAccelerationZ;
    private long mLastShakeTimestamp;
    private long mLastTimestamp;
    private int mMinNumShakes;
    private int mNumShakes;
    private SensorManager mSensorManager;
    private final ShakeListener mShakeListener;

    public interface ShakeListener {
        void onShake();
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public ShakeDetector(ShakeListener shakeListener) {
        this(shakeListener, 1);
    }

    public ShakeDetector(ShakeListener shakeListener, int i) {
        this.mShakeListener = shakeListener;
        this.mMinNumShakes = i;
    }

    public void start(SensorManager sensorManager) {
        Assertions.assertNotNull(sensorManager);
        Sensor defaultSensor = sensorManager.getDefaultSensor(1);
        if (defaultSensor != null) {
            this.mSensorManager = sensorManager;
            this.mLastTimestamp = -1;
            this.mSensorManager.registerListener(this, defaultSensor, 2);
            this.mLastShakeTimestamp = MIN_TIME_BETWEEN_SAMPLES_NS;
            reset();
        }
    }

    public void stop() {
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
            this.mSensorManager = null;
        }
    }

    private void reset() {
        this.mNumShakes = 0;
        this.mAccelerationX = BitmapDescriptorFactory.HUE_RED;
        this.mAccelerationY = BitmapDescriptorFactory.HUE_RED;
        this.mAccelerationZ = BitmapDescriptorFactory.HUE_RED;
    }

    private boolean atLeastRequiredForce(float f2) {
        return Math.abs(f2) > REQUIRED_FORCE;
    }

    private void recordShake(long j) {
        this.mLastShakeTimestamp = j;
        this.mNumShakes++;
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.timestamp - this.mLastTimestamp >= MIN_TIME_BETWEEN_SAMPLES_NS) {
            float f2 = sensorEvent.values[0];
            float f3 = sensorEvent.values[1];
            float f4 = sensorEvent.values[2] - 9.80665f;
            this.mLastTimestamp = sensorEvent.timestamp;
            if (atLeastRequiredForce(f2) && this.mAccelerationX * f2 <= BitmapDescriptorFactory.HUE_RED) {
                recordShake(sensorEvent.timestamp);
                this.mAccelerationX = f2;
            } else if (atLeastRequiredForce(f3) && this.mAccelerationY * f3 <= BitmapDescriptorFactory.HUE_RED) {
                recordShake(sensorEvent.timestamp);
                this.mAccelerationY = f3;
            } else if (atLeastRequiredForce(f4) && this.mAccelerationZ * f4 <= BitmapDescriptorFactory.HUE_RED) {
                recordShake(sensorEvent.timestamp);
                this.mAccelerationZ = f4;
            }
            maybeDispatchShake(sensorEvent.timestamp);
        }
    }

    private void maybeDispatchShake(long j) {
        if (this.mNumShakes >= this.mMinNumShakes * 8) {
            reset();
            this.mShakeListener.onShake();
        }
        if (((float) (j - this.mLastShakeTimestamp)) > SHAKING_WINDOW_NS) {
            reset();
        }
    }
}
