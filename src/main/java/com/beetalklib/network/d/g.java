package com.beetalklib.network.d;

import com.beetalklib.network.b.c;
import com.beetalklib.network.c.a;
import java.io.InputStream;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f5524a;

    public g(InputStream inputStream) {
        this.f5524a = inputStream;
    }

    private byte[] a(int i) throws Exception {
        if (i == 0) {
            return null;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (true) {
            int read = this.f5524a.read(bArr, i2, i);
            if (read <= 0) {
                return null;
            }
            if (read >= i) {
                return bArr;
            }
            i2 += read;
            i -= read;
        }
    }

    private static int a(byte[] bArr) {
        return ((bArr[3] & 255) << 24) | (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
    }

    public f a() throws c {
        try {
            int a2 = a(a(4));
            byte[] a3 = a(1);
            a.b("read data bytes %d %d", Integer.valueOf(a3[0] & 255), Integer.valueOf(a2));
            return new f(a3[0] & 255, a(a2 - 1));
        } catch (Exception e2) {
            a.a(e2);
            throw new c(e2);
        }
    }
}
