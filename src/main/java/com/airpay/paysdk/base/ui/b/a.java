package com.airpay.paysdk.base.ui.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.util.LinkedList;
import java.util.List;

public abstract class a<I, V extends View> extends androidx.viewpager.widget.a {

    /* renamed from: a  reason: collision with root package name */
    private LinkedList<V> f3847a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    private Context f3848b;

    /* renamed from: c  reason: collision with root package name */
    private List<I> f3849c;

    public abstract V a(Context context);

    public abstract void a(Context context, V v, I i, int i2);

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public a(Context context, List<I> list) {
        this.f3848b = context;
        this.f3849c = list;
    }

    public int getCount() {
        List<I> list = this.f3849c;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        viewGroup.removeView(view);
        this.f3847a.add(view);
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = (View) this.f3847a.poll();
        if (view == null) {
            view = a(this.f3848b);
        }
        a(this.f3848b, view, this.f3849c.get(i), i);
        viewGroup.addView(view);
        return view;
    }
}
