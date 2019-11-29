package androidx.k.a.a;

import java.nio.ByteBuffer;

public final class a extends c {
    public void a(int i, ByteBuffer byteBuffer) {
        this.f2408b = i;
        this.f2409c = byteBuffer;
    }

    public a b(int i, ByteBuffer byteBuffer) {
        a(i, byteBuffer);
        return this;
    }

    public int a() {
        int b2 = b(4);
        if (b2 != 0) {
            return this.f2409c.getInt(b2 + this.f2408b);
        }
        return 0;
    }

    public boolean b() {
        int b2 = b(6);
        if (b2 == 0 || this.f2409c.get(b2 + this.f2408b) == 0) {
            return false;
        }
        return true;
    }

    public short c() {
        int b2 = b(8);
        if (b2 != 0) {
            return this.f2409c.getShort(b2 + this.f2408b);
        }
        return 0;
    }

    public short d() {
        int b2 = b(12);
        if (b2 != 0) {
            return this.f2409c.getShort(b2 + this.f2408b);
        }
        return 0;
    }

    public short e() {
        int b2 = b(14);
        if (b2 != 0) {
            return this.f2409c.getShort(b2 + this.f2408b);
        }
        return 0;
    }

    public int a(int i) {
        int b2 = b(16);
        if (b2 != 0) {
            return this.f2409c.getInt(e(b2) + (i * 4));
        }
        return 0;
    }

    public int f() {
        int b2 = b(16);
        if (b2 != 0) {
            return d(b2);
        }
        return 0;
    }
}
