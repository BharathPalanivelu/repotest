package androidx.d.a;

import androidx.d.a.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    double f1964a = Math.sqrt(1500.0d);

    /* renamed from: b  reason: collision with root package name */
    double f1965b = 0.5d;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1966c = false;

    /* renamed from: d  reason: collision with root package name */
    private double f1967d;

    /* renamed from: e  reason: collision with root package name */
    private double f1968e;

    /* renamed from: f  reason: collision with root package name */
    private double f1969f;

    /* renamed from: g  reason: collision with root package name */
    private double f1970g;
    private double h;
    private double i = Double.MAX_VALUE;
    private final b.a j = new b.a();

    public e() {
    }

    public e(float f2) {
        this.i = (double) f2;
    }

    public e a(float f2) {
        if (f2 > BitmapDescriptorFactory.HUE_RED) {
            this.f1964a = Math.sqrt((double) f2);
            this.f1966c = false;
            return this;
        }
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    public e b(float f2) {
        if (f2 >= BitmapDescriptorFactory.HUE_RED) {
            this.f1965b = (double) f2;
            this.f1966c = false;
            return this;
        }
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public e c(float f2) {
        this.i = (double) f2;
        return this;
    }

    public float a() {
        return (float) this.i;
    }

    public boolean a(float f2, float f3) {
        return ((double) Math.abs(f3)) < this.f1968e && ((double) Math.abs(f2 - a())) < this.f1967d;
    }

    private void b() {
        if (!this.f1966c) {
            if (this.i != Double.MAX_VALUE) {
                double d2 = this.f1965b;
                if (d2 > 1.0d) {
                    double d3 = this.f1964a;
                    this.f1969f = ((-d2) * d3) + (d3 * Math.sqrt((d2 * d2) - 1.0d));
                    double d4 = this.f1965b;
                    double d5 = this.f1964a;
                    this.f1970g = ((-d4) * d5) - (d5 * Math.sqrt((d4 * d4) - 1.0d));
                } else if (d2 >= 0.0d && d2 < 1.0d) {
                    this.h = this.f1964a * Math.sqrt(1.0d - (d2 * d2));
                }
                this.f1966c = true;
                return;
            }
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
    }

    /* access modifiers changed from: package-private */
    public b.a a(double d2, double d3, long j2) {
        double d4;
        double d5;
        b();
        double d6 = (double) j2;
        Double.isNaN(d6);
        double d7 = d6 / 1000.0d;
        double d8 = d2 - this.i;
        double d9 = this.f1965b;
        if (d9 > 1.0d) {
            double d10 = this.f1970g;
            double d11 = this.f1969f;
            double d12 = d8 - (((d10 * d8) - d3) / (d10 - d11));
            double d13 = ((d8 * d10) - d3) / (d10 - d11);
            d5 = (Math.pow(2.718281828459045d, d10 * d7) * d12) + (Math.pow(2.718281828459045d, this.f1969f * d7) * d13);
            double d14 = this.f1970g;
            double pow = d12 * d14 * Math.pow(2.718281828459045d, d14 * d7);
            double d15 = this.f1969f;
            d4 = pow + (d13 * d15 * Math.pow(2.718281828459045d, d15 * d7));
        } else if (d9 == 1.0d) {
            double d16 = this.f1964a;
            double d17 = d3 + (d16 * d8);
            double d18 = d8 + (d17 * d7);
            d5 = Math.pow(2.718281828459045d, (-d16) * d7) * d18;
            double pow2 = d18 * Math.pow(2.718281828459045d, (-this.f1964a) * d7);
            double d19 = this.f1964a;
            d4 = (d17 * Math.pow(2.718281828459045d, (-d19) * d7)) + (pow2 * (-d19));
        } else {
            double d20 = 1.0d / this.h;
            double d21 = this.f1964a;
            double d22 = d20 * ((d9 * d21 * d8) + d3);
            double pow3 = Math.pow(2.718281828459045d, (-d9) * d21 * d7) * ((Math.cos(this.h * d7) * d8) + (Math.sin(this.h * d7) * d22));
            double d23 = this.f1964a;
            double d24 = this.f1965b;
            double d25 = (-d23) * pow3 * d24;
            double pow4 = Math.pow(2.718281828459045d, (-d24) * d23 * d7);
            double d26 = this.h;
            double d27 = pow3;
            double sin = (-d26) * d8 * Math.sin(d26 * d7);
            double d28 = this.h;
            d4 = d25 + (pow4 * (sin + (d22 * d28 * Math.cos(d28 * d7))));
            d5 = d27;
        }
        b.a aVar = this.j;
        aVar.f1961a = (float) (d5 + this.i);
        aVar.f1962b = (float) d4;
        return aVar;
    }

    /* access modifiers changed from: package-private */
    public void a(double d2) {
        this.f1967d = Math.abs(d2);
        this.f1968e = this.f1967d * 62.5d;
    }
}
