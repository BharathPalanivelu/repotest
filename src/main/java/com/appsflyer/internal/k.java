package com.appsflyer.internal;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class k implements SensorEventListener {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final int f176;

    /* renamed from: ʼ  reason: contains not printable characters */
    private double f177;

    /* renamed from: ʽ  reason: contains not printable characters */
    private long f178;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final float[][] f179 = new float[2][];

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f180;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f181;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final long[] f182 = new long[2];

    /* renamed from: ॱ  reason: contains not printable characters */
    private final int f183;

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    private k(int i, String str, String str2) {
        this.f183 = i;
        this.f180 = str == null ? "" : str;
        this.f181 = str2 == null ? "" : str2;
        this.f176 = ((((i + 31) * 31) + this.f180.hashCode()) * 31) + this.f181.hashCode();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    static k m157(Sensor sensor) {
        return new k(sensor.getType(), sensor.getName(), sensor.getVendor());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static double m154(float[] fArr, float[] fArr2) {
        int min = Math.min(fArr.length, fArr2.length);
        double d2 = 0.0d;
        for (int i = 0; i < min; i++) {
            d2 += StrictMath.pow((double) (fArr[i] - fArr2[i]), 2.0d);
        }
        return Math.sqrt(d2);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static List<Float> m155(float[] fArr) {
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float valueOf : fArr) {
            arrayList.add(Float.valueOf(valueOf));
        }
        return arrayList;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent != null && sensorEvent.values != null) {
            Sensor sensor = sensorEvent.sensor;
            if ((sensor == null || sensor.getName() == null || sensor.getVendor() == null) ? false : true) {
                int type = sensorEvent.sensor.getType();
                String name = sensorEvent.sensor.getName();
                String vendor = sensorEvent.sensor.getVendor();
                long j = sensorEvent.timestamp;
                float[] fArr = sensorEvent.values;
                if (m156(type, name, vendor)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    float[][] fArr2 = this.f179;
                    float[] fArr3 = fArr2[0];
                    if (fArr3 == null) {
                        fArr2[0] = Arrays.copyOf(fArr, fArr.length);
                        this.f182[0] = currentTimeMillis;
                        return;
                    }
                    float[] fArr4 = fArr2[1];
                    if (fArr4 == null) {
                        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
                        this.f179[1] = copyOf;
                        this.f182[1] = currentTimeMillis;
                        this.f177 = m154(fArr3, copyOf);
                    } else if (50000000 <= j - this.f178) {
                        this.f178 = j;
                        if (Arrays.equals(fArr4, fArr)) {
                            this.f182[1] = currentTimeMillis;
                            return;
                        }
                        double r0 = m154(fArr3, fArr);
                        if (r0 > this.f177) {
                            this.f179[1] = Arrays.copyOf(fArr, fArr.length);
                            this.f182[1] = currentTimeMillis;
                            this.f177 = r0;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean m156(int i, String str, String str2) {
        return this.f183 == i && this.f180.equals(str) && this.f181.equals(str2);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private Map<String, Object> m158() {
        HashMap hashMap = new HashMap(7);
        hashMap.put("sT", Integer.valueOf(this.f183));
        hashMap.put("sN", this.f180);
        hashMap.put("sV", this.f181);
        float[] fArr = this.f179[0];
        if (fArr != null) {
            hashMap.put("sVS", m155(fArr));
        }
        float[] fArr2 = this.f179[1];
        if (fArr2 != null) {
            hashMap.put("sVE", m155(fArr2));
        }
        return hashMap;
    }

    public final int hashCode() {
        return this.f176;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return m156(kVar.f183, kVar.f180, kVar.f181);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m159(Map<k, Map<String, Object>> map, boolean z) {
        if (this.f179[0] != null) {
            map.put(this, m158());
            if (z) {
                for (int i = 0; i < 2; i++) {
                    this.f179[i] = null;
                }
                for (int i2 = 0; i2 < 2; i2++) {
                    this.f182[i2] = 0;
                }
                this.f177 = 0.0d;
                this.f178 = 0;
            }
        } else if (!map.containsKey(this)) {
            map.put(this, m158());
        }
    }
}
