package com.shopee.app.d.c.b;

import com.shopee.app.data.store.m;
import com.shopee.app.data.viewmodel.category.CategoryNode;
import com.shopee.app.database.orm.bean.DBCategory;
import com.shopee.app.util.af;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Map<Integer, CategoryNode> f16543a;

    public a(m mVar) {
        a(mVar);
    }

    static List<CategoryNode> a(final int i, List<DBCategory> list) {
        List<T> a2 = af.a(list, new af.a<DBCategory>() {
            /* renamed from: a */
            public boolean shouldInclude(DBCategory dBCategory) {
                return dBCategory.d() == i;
            }
        });
        if (af.a(a2)) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (T t : a2) {
            CategoryNode categoryNode = new CategoryNode();
            categoryNode.setCategoryId(t.a());
            categoryNode.setName(t.c());
            categoryNode.setIsDefault(t.e());
            categoryNode.setParent(i);
            categoryNode.setChildren(a(categoryNode.getCategoryId(), list));
            categoryNode.setStatus(t.b());
            arrayList.add(categoryNode);
            f16543a.put(Integer.valueOf(categoryNode.getCategoryId()), categoryNode);
        }
        return arrayList;
    }

    public static synchronized void a(m mVar) {
        synchronized (a.class) {
            if (f16543a == null) {
                f16543a = new ConcurrentHashMap();
                a(0, mVar.a());
            }
        }
    }

    public List<Integer> a(int i) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = i; f16543a.containsKey(Integer.valueOf(i2)); i2 = f16543a.get(Integer.valueOf(i2)).getParentId()) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }

    public List<List<Integer>> a(List<Integer> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Integer intValue : list) {
            List<Integer> a2 = a(intValue.intValue());
            ArrayList arrayList2 = new ArrayList();
            for (Integer next : a2) {
                CategoryNode categoryNode = f16543a.get(next);
                if (categoryNode != null && !categoryNode.isInvalid()) {
                    arrayList2.add(next);
                }
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }
}
