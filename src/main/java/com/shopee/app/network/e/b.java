package com.shopee.app.network.e;

import android.util.Pair;
import com.garena.h.a.c;
import com.garena.h.e;
import com.garena.h.f;
import com.shopee.app.network.a.a;
import com.squareup.wire.Message;
import java.io.IOException;
import java.io.InputStream;

public class b implements f {

    /* renamed from: a  reason: collision with root package name */
    private InputStream f18485a;

    public void a(InputStream inputStream) {
        this.f18485a = inputStream;
    }

    private byte[] a(int i) throws Exception {
        if (i == 0) {
            return null;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (true) {
            int read = this.f18485a.read(bArr, i2, i);
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

    private int a(byte[] bArr) {
        return ((bArr[3] & 255) << 24) | (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
    }

    public e a() throws c {
        try {
            int a2 = a(a(4));
            byte[] a3 = a(1);
            byte[] a4 = a(a2 - 1);
            byte b2 = a3[0] & 255;
            com.beetalklib.network.d.f fVar = new com.beetalklib.network.d.f(b2, a4);
            a a5 = com.shopee.app.network.f.a((int) b2);
            a aVar = null;
            if (a5 != null) {
                try {
                    Pair a6 = a5.a(a4);
                    aVar = new a((String) a6.first, (Message) a6.second, fVar);
                } catch (IOException unused) {
                }
            }
            return aVar == null ? new a(fVar) : aVar;
        } catch (Exception e2) {
            com.beetalklib.network.c.a.a(e2);
            throw new c(e2);
        }
    }
}
