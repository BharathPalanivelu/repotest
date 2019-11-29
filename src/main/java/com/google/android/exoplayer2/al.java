package com.google.android.exoplayer2;

public final class al {

    /* renamed from: a  reason: collision with root package name */
    public static final al f9108a = new al(1.0f, 1.0f);

    /* renamed from: b  reason: collision with root package name */
    public final float f9109b;

    /* renamed from: c  reason: collision with root package name */
    public final float f9110c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9111d;

    public al(float f2, float f3) {
        this.f9109b = f2;
        this.f9110c = f3;
        this.f9111d = Math.round(f2 * 1000.0f);
    }

    public long a(long j) {
        return j * ((long) this.f9111d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        al alVar = (al) obj;
        if (this.f9109b == alVar.f9109b && this.f9110c == alVar.f9110c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((527 + Float.floatToRawIntBits(this.f9109b)) * 31) + Float.floatToRawIntBits(this.f9110c);
    }
}
