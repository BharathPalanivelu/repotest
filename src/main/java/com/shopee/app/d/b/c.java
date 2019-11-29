package com.shopee.app.d.b;

import com.garena.android.appkit.d.a;
import com.shopee.app.network.f;
import com.shopee.protocol.action.OrderInfo;
import com.shopee.protocol.shop.OrderExtInfo;
import java.io.IOException;

public class c {
    public static OrderExtInfo a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return (OrderExtInfo) f.f18486a.parseFrom(bArr, 0, bArr.length, OrderExtInfo.class);
        } catch (IOException e2) {
            a.a(e2);
            return null;
        }
    }

    public static OrderInfo b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return (OrderInfo) f.f18486a.parseFrom(bArr, 0, bArr.length, OrderInfo.class);
        } catch (IOException e2) {
            a.a(e2);
            return null;
        }
    }
}
