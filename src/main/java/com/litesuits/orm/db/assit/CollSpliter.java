package com.litesuits.orm.db.assit;

import java.util.ArrayList;
import java.util.Collection;

public class CollSpliter {

    public interface Spliter<T> {
        int oneSplit(ArrayList<T> arrayList) throws Exception;
    }

    public static <T> int split(Collection<T> collection, int i, Spliter<T> spliter) throws Exception {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        if (collection.size() <= i) {
            arrayList.addAll(collection);
            return spliter.oneSplit(arrayList) + 0;
        }
        int i3 = 1;
        int i4 = 0;
        for (T next : collection) {
            if (i2 < i3 * i) {
                arrayList.add(next);
            } else {
                i4 += spliter.oneSplit(arrayList);
                i3++;
                arrayList.clear();
                arrayList.add(next);
            }
            i2++;
        }
        return arrayList.size() > 0 ? spliter.oneSplit(arrayList) + i4 : i4;
    }
}
