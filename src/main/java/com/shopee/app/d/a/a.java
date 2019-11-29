package com.shopee.app.d.a;

import com.shopee.protocol.shop.CategoryPath;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a {
    public static List<CategoryPath> a(List<List<Integer>> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (List<Integer> catid : list) {
            arrayList.add(new CategoryPath.Builder().catid(catid).build());
        }
        return arrayList;
    }
}
