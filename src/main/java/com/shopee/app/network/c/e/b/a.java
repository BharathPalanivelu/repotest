package com.shopee.app.network.c.e.b;

import android.util.Pair;
import com.shopee.app.application.ar;
import com.shopee.app.h.o;
import com.shopee.app.network.c.e.b;
import com.shopee.app.network.d.az;
import com.shopee.app.network.f;
import com.shopee.protocol.search.action.ResponseSearchItem;
import java.io.IOException;

public class a implements b<ResponseSearchItem> {
    public int a() {
        return 1;
    }

    public int b() {
        return 101;
    }

    public void a(String str, ResponseSearchItem responseSearchItem) {
        az f2 = o.a().f(str);
        if (f2 instanceof com.shopee.app.network.d.d.a.a) {
            ar.f().e().searchProductInShopProcessor().a((com.shopee.app.network.d.d.a.a) f2, responseSearchItem);
        }
    }

    public Pair<String, ResponseSearchItem> a(byte[] bArr) throws IOException {
        ResponseSearchItem responseSearchItem = (ResponseSearchItem) f.f18486a.parseFrom(bArr, 0, bArr.length, ResponseSearchItem.class);
        return new Pair<>(responseSearchItem.header.requestid, responseSearchItem);
    }
}
