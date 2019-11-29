package cn.tongdun.android.core.oo0ooo0o00o0xo;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import cn.tongdun.android.core.x0000xo0x0oooooo0.ooxo0o0xxxooxo00;

final class xxx00xo0xoxxooxo implements SensorEventListener {
    final /* synthetic */ ooxo0o0xxxooxo00 o00xxox0x0xoox;
    final /* synthetic */ SensorManager oo0ooo0o00o0xo;

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (sensorEvent.sensor.getType() == 4) {
            this.o00xxox0x0xoox.o00xxox0x0xoox(fArr[0], fArr[1], fArr[2]);
        }
        this.oo0ooo0o00o0xo.unregisterListener(this);
    }
}
