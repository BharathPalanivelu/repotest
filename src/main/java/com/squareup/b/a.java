package com.squareup.b;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class a implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    private int f30612a = 13;

    /* renamed from: b  reason: collision with root package name */
    private final d f30613b = new d();

    /* renamed from: c  reason: collision with root package name */
    private final C0478a f30614c;

    /* renamed from: d  reason: collision with root package name */
    private SensorManager f30615d;

    /* renamed from: e  reason: collision with root package name */
    private Sensor f30616e;

    /* renamed from: com.squareup.b.a$a  reason: collision with other inner class name */
    public interface C0478a {
        void b();
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public a(C0478a aVar) {
        this.f30614c = aVar;
    }

    public boolean a(SensorManager sensorManager) {
        if (this.f30616e != null) {
            return true;
        }
        this.f30616e = sensorManager.getDefaultSensor(1);
        Sensor sensor = this.f30616e;
        if (sensor != null) {
            this.f30615d = sensorManager;
            sensorManager.registerListener(this, sensor, 0);
        }
        if (this.f30616e != null) {
            return true;
        }
        return false;
    }

    public void a() {
        Sensor sensor = this.f30616e;
        if (sensor != null) {
            this.f30615d.unregisterListener(this, sensor);
            this.f30615d = null;
            this.f30616e = null;
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        boolean a2 = a(sensorEvent);
        this.f30613b.a(sensorEvent.timestamp, a2);
        if (this.f30613b.b()) {
            this.f30613b.a();
            this.f30614c.b();
        }
    }

    private boolean a(SensorEvent sensorEvent) {
        float f2 = sensorEvent.values[0];
        float f3 = sensorEvent.values[1];
        float f4 = sensorEvent.values[2];
        int i = this.f30612a;
        if (((double) ((f2 * f2) + (f3 * f3) + (f4 * f4))) > ((double) (i * i))) {
            return true;
        }
        return false;
    }

    public void a(int i) {
        this.f30612a = i;
    }

    static class d {

        /* renamed from: a  reason: collision with root package name */
        private final c f30621a = new c();

        /* renamed from: b  reason: collision with root package name */
        private b f30622b;

        /* renamed from: c  reason: collision with root package name */
        private b f30623c;

        /* renamed from: d  reason: collision with root package name */
        private int f30624d;

        /* renamed from: e  reason: collision with root package name */
        private int f30625e;

        d() {
        }

        /* access modifiers changed from: package-private */
        public void a(long j, boolean z) {
            a(j - 500000000);
            b a2 = this.f30621a.a();
            a2.f30617a = j;
            a2.f30618b = z;
            a2.f30619c = null;
            b bVar = this.f30623c;
            if (bVar != null) {
                bVar.f30619c = a2;
            }
            this.f30623c = a2;
            if (this.f30622b == null) {
                this.f30622b = a2;
            }
            this.f30624d++;
            if (z) {
                this.f30625e++;
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            while (true) {
                b bVar = this.f30622b;
                if (bVar != null) {
                    this.f30622b = bVar.f30619c;
                    this.f30621a.a(bVar);
                } else {
                    this.f30623c = null;
                    this.f30624d = 0;
                    this.f30625e = 0;
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(long j) {
            while (this.f30624d >= 4) {
                b bVar = this.f30622b;
                if (bVar != null && j - bVar.f30617a > 0) {
                    b bVar2 = this.f30622b;
                    if (bVar2.f30618b) {
                        this.f30625e--;
                    }
                    this.f30624d--;
                    this.f30622b = bVar2.f30619c;
                    if (this.f30622b == null) {
                        this.f30623c = null;
                    }
                    this.f30621a.a(bVar2);
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            b bVar = this.f30623c;
            if (!(bVar == null || this.f30622b == null || bVar.f30617a - this.f30622b.f30617a < 250000000)) {
                int i = this.f30625e;
                int i2 = this.f30624d;
                if (i >= (i2 >> 1) + (i2 >> 2)) {
                    return true;
                }
            }
            return false;
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        long f30617a;

        /* renamed from: b  reason: collision with root package name */
        boolean f30618b;

        /* renamed from: c  reason: collision with root package name */
        b f30619c;

        b() {
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        private b f30620a;

        c() {
        }

        /* access modifiers changed from: package-private */
        public b a() {
            b bVar = this.f30620a;
            if (bVar == null) {
                return new b();
            }
            this.f30620a = bVar.f30619c;
            return bVar;
        }

        /* access modifiers changed from: package-private */
        public void a(b bVar) {
            bVar.f30619c = this.f30620a;
            this.f30620a = bVar;
        }
    }
}
