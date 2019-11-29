package com.shopee.app.network.d.d;

import com.beetalklib.network.d.f;
import com.shopee.app.network.a.b;
import com.shopee.app.network.d.az;
import com.shopee.app.network.e;
import com.squareup.wire.Message;

public abstract class a extends az implements b {
    /* access modifiers changed from: protected */
    public abstract int c();

    /* access modifiers changed from: protected */
    public void f() {
        Message q_ = q_();
        e.c().a(new f(255, a(q_.toByteArray())), getClass().getSimpleName(), i().a(), q_);
    }

    private byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[(bArr.length + 2)];
        bArr2[0] = (byte) c();
        bArr2[1] = (byte) b();
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i + 2] = bArr[i];
        }
        return bArr2;
    }
}
