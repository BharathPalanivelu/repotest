package com.airpay.paysdk.common.net.tcp.d;

import com.airpay.paysdk.common.a.a;
import com.tencent.ijk.media.player.IjkMediaPlayer;
import java.io.InputStream;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f4068a;

    public b(InputStream inputStream) {
        this.f4068a = inputStream;
    }

    public InputStream a() {
        return this.f4068a;
    }

    private byte[] a(int i) throws Exception {
        if (i == 0) {
            return null;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (true) {
            int read = this.f4068a.read(bArr, i2, i);
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

    public a b() throws a {
        try {
            int a2 = a(a(4));
            byte[] a3 = a(2);
            return new a((a3[1] & 255) | ((a3[0] & 255) << 8), a(a2 - 2));
        } catch (Exception e2) {
            throw new a((int) IjkMediaPlayer.FFP_PROP_FLOAT_AVDIFF, (Throwable) e2);
        }
    }
}
