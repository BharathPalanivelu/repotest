package com.google.zxing;

public abstract class n {

    /* renamed from: a  reason: collision with root package name */
    private final int f14771a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14772b;

    public abstract byte[] a();

    public abstract byte[] a(int i, byte[] bArr);

    public boolean d() {
        return false;
    }

    protected n(int i, int i2) {
        this.f14771a = i;
        this.f14772b = i2;
    }

    public final int b() {
        return this.f14771a;
    }

    public final int c() {
        return this.f14772b;
    }

    public n e() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        int i = this.f14771a;
        StringBuilder sb = new StringBuilder(this.f14772b * (i + 1));
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < this.f14772b; i2++) {
            bArr = a(i2, bArr);
            for (int i3 = 0; i3 < this.f14771a; i3++) {
                byte b2 = bArr[i3] & 255;
                sb.append(b2 < 64 ? '#' : b2 < 128 ? '+' : b2 < 192 ? '.' : ' ');
            }
            sb.append(10);
        }
        return sb.toString();
    }
}
