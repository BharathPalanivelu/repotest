package com.shopee.app.ui.product.add.wholesale;

import com.shopee.app.g.e;
import com.shopee.app.util.af;
import com.shopee.app.web.protocol.WholesaleTier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class h {
    public List<WholesaleTier> a(List<WholesaleTierModel> list) {
        if (af.a(list)) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (WholesaleTierModel next : list) {
            Long a2 = e.a(next.f24172c, "IDR");
            arrayList.add(new WholesaleTier(a(next.f24170a), a(next.f24171b), a2 != null ? a2.longValue() : 0));
        }
        return arrayList;
    }

    private static int a(String str) {
        try {
            return Integer.valueOf(str).intValue();
        } catch (NumberFormatException unused) {
            return -1;
        }
    }
}
