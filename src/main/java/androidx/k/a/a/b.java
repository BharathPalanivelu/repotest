package androidx.k.a.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class b extends c {
    public static b a(ByteBuffer byteBuffer) {
        return a(byteBuffer, new b());
    }

    public static b a(ByteBuffer byteBuffer, b bVar) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return bVar.b(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void a(int i, ByteBuffer byteBuffer) {
        this.f2408b = i;
        this.f2409c = byteBuffer;
    }

    public b b(int i, ByteBuffer byteBuffer) {
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

    public a a(a aVar, int i) {
        int b2 = b(6);
        if (b2 != 0) {
            return aVar.b(c(e(b2) + (i * 4)), this.f2409c);
        }
        return null;
    }

    public int b() {
        int b2 = b(6);
        if (b2 != 0) {
            return d(b2);
        }
        return 0;
    }
}
