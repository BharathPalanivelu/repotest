package com.shopee.app.util.j;

import android.content.SharedPreferences;
import com.google.a.c.a;
import com.shopee.app.util.ad;
import java.util.ArrayList;
import java.util.List;

public class b<T> extends ad<List<T>> {
    public b(SharedPreferences sharedPreferences, String str, a aVar) {
        super(sharedPreferences, str, "[]", aVar);
    }

    public void b(T t) {
        List list = (List) super.a();
        list.add(t);
        super.a(list);
    }

    public void a(List<T> list) {
        List list2 = (List) super.a();
        list2.addAll(list);
        super.a(list2);
    }

    public void b(List<T> list) {
        List list2 = (List) super.a();
        for (T next : list) {
            if (!list2.contains(next)) {
                list2.add(next);
            }
        }
        super.a(list2);
    }

    public void c() {
        super.a(new ArrayList());
    }

    public void c(T t) {
        List list = (List) super.a();
        list.remove(t);
        super.a(list);
    }
}
