package com.shopee.app.network.c;

import com.shopee.app.application.ar;
import com.shopee.app.network.c.k.f;
import com.shopee.app.network.f;
import com.shopee.protocol.action.ResponseCheckoutList;
import java.io.IOException;

public class z extends c {
    public int a() {
        return 121;
    }

    public void c(byte[] bArr, int i) throws IOException {
        c().a((ResponseCheckoutList) f.f18486a.parseFrom(bArr, 0, i, ResponseCheckoutList.class));
    }

    private f.a c() {
        return ar.f().e().checkoutListProcessor();
    }
}
