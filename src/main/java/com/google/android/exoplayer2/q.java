package com.google.android.exoplayer2;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public static final q f11236a = new q(1.0f, 1.0f);

    /* renamed from: b  reason: collision with root package name */
    public final float f11237b;

    /* renamed from: c  reason: collision with root package name */
    public final float f11238c;

    /* renamed from: d  reason: collision with root package name */
    private final int f11239d;

    public q(float f2, float f3) {
        this.f11237b = f2;
        this.f11238c = f3;
        this.f11239d = Math.round(f2 * 1000.0f);
    }

    public long a(long j) {
        return j * ((long) this.f11239d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        q qVar = (q) obj;
        if (this.f11237b == qVar.f11237b && this.f11238c == qVar.f11238c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((527 + Float.floatToRawIntBits(this.f11237b)) * 31) + Float.floatToRawIntBits(this.f11238c);
    }
}
