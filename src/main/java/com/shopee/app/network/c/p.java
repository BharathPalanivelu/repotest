package com.shopee.app.network.c;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import java.io.IOException;

public class p extends c {
    public int a() {
        return 236;
    }

    public void c(byte[] bArr, int i) throws IOException {
        b.a("TCP_DISCONNECTED", new a(), b.a.NETWORK_BUS);
    }
}
