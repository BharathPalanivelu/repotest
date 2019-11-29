package com.bca.xco.widget.d.a;

import com.bca.xco.widget.d.a.a.c;
import com.bca.xco.widget.d.b.a;
import java.nio.charset.Charset;

public abstract class y {
    public abstract u a();

    public abstract void a(a aVar);

    public long b() {
        return -1;
    }

    public static y a(u uVar, String str) {
        Charset charset = c.f4797c;
        if (uVar != null) {
            charset = uVar.a();
            if (charset == null) {
                charset = c.f4797c;
                uVar = u.a(uVar + "; charset=utf-8");
            }
        }
        return a(uVar, str.getBytes(charset));
    }

    public static y a(u uVar, byte[] bArr) {
        return a(uVar, bArr, 0, bArr.length);
    }

    public static y a(final u uVar, final byte[] bArr, final int i, final int i2) {
        if (bArr != null) {
            c.a((long) bArr.length, (long) i, (long) i2);
            return new y() {
                public u a() {
                    return uVar;
                }

                public long b() {
                    return (long) i2;
                }

                public void a(a aVar) {
                    aVar.a(bArr, i, i2);
                }
            };
        }
        throw new NullPointerException("content == null");
    }
}
