package com.shopee.app.d.b.a.d;

import com.shopee.app.d.b.a.a;
import com.shopee.app.d.b.a.b.c.b;
import com.shopee.app.d.b.a.b.c.c;
import com.shopee.app.d.b.a.b.c.d;
import com.shopee.app.d.b.a.b.c.e;
import com.shopee.app.d.b.a.b.c.f;
import com.shopee.app.d.b.a.b.c.g;
import com.shopee.app.d.b.a.b.c.h;
import com.shopee.app.d.b.a.b.c.i;
import com.shopee.app.d.b.a.b.c.j;
import com.shopee.app.data.viewmodel.order.ReturnItem;

public class l {
    public static a a(ReturnItem returnItem) {
        if (returnItem.isSelling()) {
            return b(returnItem);
        }
        return c(returnItem);
    }

    private static a b(ReturnItem returnItem) {
        switch (returnItem.getStatus()) {
            case 1:
                return new h(returnItem);
            case 2:
                return new b(returnItem);
            case 3:
                return new c(returnItem);
            case 4:
                return new f(returnItem);
            case 5:
                return new j(returnItem);
            case 6:
                return new d(returnItem);
            case 7:
                return new i(returnItem);
            case 8:
                return new e(returnItem);
            default:
                return new g(returnItem);
        }
    }

    private static a c(ReturnItem returnItem) {
        switch (returnItem.getStatus()) {
            case 1:
                return new com.shopee.app.d.b.a.a.c.h(returnItem);
            case 2:
                return new com.shopee.app.d.b.a.a.c.b(returnItem);
            case 3:
                return new com.shopee.app.d.b.a.a.c.c(returnItem);
            case 4:
                return new com.shopee.app.d.b.a.a.c.f(returnItem);
            case 5:
                return new com.shopee.app.d.b.a.a.c.j(returnItem);
            case 6:
                return new com.shopee.app.d.b.a.a.c.d(returnItem);
            case 7:
                return new com.shopee.app.d.b.a.a.c.i(returnItem);
            case 8:
                return new com.shopee.app.d.b.a.a.c.e(returnItem);
            default:
                return new com.shopee.app.d.b.a.a.c.g(returnItem);
        }
    }
}
