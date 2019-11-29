package com.shopee.app.ui.product.add.wholesale;

import com.garena.android.appkit.d.a;
import com.shopee.app.g.e;
import com.shopee.app.util.af;
import com.shopee.protocol.shop.WholesaleTier;
import java.util.ArrayList;
import java.util.List;

public class j {
    public static List<WholesaleTier> a(List<WholesaleTierModel> list) {
        ArrayList arrayList = new ArrayList();
        if (!af.a(list)) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                WholesaleTierModel wholesaleTierModel = list.get(i);
                WholesaleTier.Builder price = new WholesaleTier.Builder().min_count(Integer.valueOf(a(wholesaleTierModel.f24170a))).price(e.a(wholesaleTierModel.f24172c, "IDR"));
                int a2 = a(wholesaleTierModel.f24171b);
                if (a2 != -1) {
                    price.max_count(Integer.valueOf(a2));
                }
                arrayList.add(price.build());
            }
        }
        return arrayList;
    }

    public static List<WholesaleTierModel> b(List<WholesaleTier> list) {
        ArrayList arrayList = new ArrayList();
        if (!af.a(list)) {
            for (WholesaleTier next : list) {
                arrayList.add(WholesaleTierModel.c().a(a(next.min_count)).b(a(next.max_count)).c(e.a(next.price.longValue(), "IDR", true)).a());
            }
        }
        return arrayList;
    }

    private static int a(String str) {
        try {
            return Integer.valueOf(str).intValue();
        } catch (NumberFormatException e2) {
            a.a(e2);
            return -1;
        }
    }

    private static String a(Integer num) {
        return num == null ? "" : String.valueOf(num);
    }
}
