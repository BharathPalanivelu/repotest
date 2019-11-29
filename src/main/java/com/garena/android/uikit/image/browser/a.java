package com.garena.android.uikit.image.browser;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.garena.android.uikit.image.browser.GImageBrowserView;
import java.util.List;

public abstract class a<T> implements GImageBrowserView.a {

    /* renamed from: a  reason: collision with root package name */
    private List<T> f7772a;

    public View a(Context context, T t, int i) {
        return null;
    }

    public abstract List<T> a();

    public abstract void a(com.garena.android.uikit.image.c.a aVar, T t, int i);

    public void c(View view, View view2, int i) {
    }

    public int b() {
        List<T> list = this.f7772a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public View a(Context context, int i) {
        if (i < 0 || i >= this.f7772a.size()) {
            return null;
        }
        return a(context, this.f7772a.get(i), i);
    }

    public View b(Context context, int i) {
        com.garena.android.uikit.image.c.a aVar = new com.garena.android.uikit.image.c.a(context);
        a(aVar, this.f7772a.get(i), i);
        return aVar;
    }

    public void c() {
        this.f7772a = a();
    }

    public void a(View view, View view2, int i) {
        com.garena.android.uikit.image.c.a aVar = (com.garena.android.uikit.image.c.a) view;
        aVar.d();
        aVar.setImageBitmap((Bitmap) null);
    }

    public void b(View view, View view2, int i) {
        ((com.garena.android.uikit.image.c.a) view).e();
    }
}
