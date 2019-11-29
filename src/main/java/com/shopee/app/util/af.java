package com.shopee.app.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class af {

    public interface a<T> {
        boolean shouldInclude(T t);
    }

    public interface b<T, K> {
        T map(K k);
    }

    public static <T, K> List<T> a(List<K> list, b<T, K> bVar) {
        ArrayList arrayList = new ArrayList();
        if (!a(list)) {
            for (K map : list) {
                arrayList.add(bVar.map(map));
            }
        }
        return arrayList;
    }

    public static <T> List<T> a(List<T> list, a<T> aVar) {
        ArrayList arrayList = new ArrayList();
        for (T next : list) {
            if (aVar.shouldInclude(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static <T> boolean a(List<T> list) {
        return list == null || list.isEmpty();
    }

    public static <T> List<List<T>> a(List<T> list, int i) {
        if (list.size() < i) {
            return Collections.singletonList(new ArrayList(list));
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size() / i;
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = i2 * i;
            arrayList.add(list.subList(i3, i3 + i));
        }
        if (list.size() % i > 0) {
            arrayList.add(list.subList(size * i, list.size()));
        }
        return arrayList;
    }
}
