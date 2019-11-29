package com.shopee.sdk.e.a;

import android.content.SharedPreferences;
import com.shopee.sdk.f.a;
import java.util.List;

public class b<T> extends d<List<T>> {
    public b(SharedPreferences sharedPreferences, String str, Class<T> cls) {
        super(sharedPreferences, str, a.f30359c, (com.google.a.c.a) com.google.a.c.a.getParameterized(List.class, cls));
    }

    public int a() {
        return ((List) super.c()).size();
    }

    public void a(T t) {
        List list = (List) super.c();
        list.add(t);
        super.b(list);
    }

    public T a(int i) {
        return ((List) super.c()).get(i);
    }
}
