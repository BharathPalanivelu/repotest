package com.shopee.app.ui.home.me.v3.feature;

import android.content.Context;
import android.view.View;
import com.shopee.app.ui.a.s;
import d.d.b.j;
import java.util.ArrayList;
import java.util.List;

public abstract class o<T> implements s<T> {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f22643a = new ArrayList();

    public abstract View a(Context context, String str);

    public abstract String b(T t, int i);

    public View a(Context context, int i) {
        j.b(context, "context");
        return a(context, this.f22643a.get(i));
    }

    public int a(T t, int i) {
        String b2 = b(t, i);
        if (this.f22643a.contains(b2)) {
            return this.f22643a.indexOf(b2);
        }
        this.f22643a.add(b2);
        return this.f22643a.size() - 1;
    }

    public int a() {
        return this.f22643a.size();
    }
}
