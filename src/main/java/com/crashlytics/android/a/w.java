package com.crashlytics.android.a;

import io.a.a.a.a.c.a.a;
import java.util.Random;

class w implements a {

    /* renamed from: a  reason: collision with root package name */
    final a f6364a;

    /* renamed from: b  reason: collision with root package name */
    final Random f6365b;

    /* renamed from: c  reason: collision with root package name */
    final double f6366c;

    public w(a aVar, double d2) {
        this(aVar, d2, new Random());
    }

    public w(a aVar, double d2, Random random) {
        if (d2 < 0.0d || d2 > 1.0d) {
            throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
        } else if (aVar == null) {
            throw new NullPointerException("backoff must not be null");
        } else if (random != null) {
            this.f6364a = aVar;
            this.f6366c = d2;
            this.f6365b = random;
        } else {
            throw new NullPointerException("random must not be null");
        }
    }

    public long a(int i) {
        double a2 = a();
        double a3 = (double) this.f6364a.a(i);
        Double.isNaN(a3);
        return (long) (a2 * a3);
    }

    /* access modifiers changed from: package-private */
    public double a() {
        double d2 = this.f6366c;
        double d3 = 1.0d - d2;
        return d3 + (((d2 + 1.0d) - d3) * this.f6365b.nextDouble());
    }
}
