package com.shopee.app.ui.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

public abstract class i<T> extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    List<T> f19205a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    List<m> f19206b = new ArrayList();

    /* access modifiers changed from: protected */
    public abstract int a();

    /* access modifiers changed from: protected */
    public abstract List<m> b(List<T> list);

    public long getItemId(int i) {
        return (long) i;
    }

    public void a(List<T> list) {
        this.f19205a = list;
        this.f19206b = b(this.f19205a);
    }

    public int getCount() {
        return this.f19206b.size();
    }

    public int getItemViewType(int i) {
        return this.f19206b.get(i).b();
    }

    public int getViewTypeCount() {
        return a();
    }

    /* renamed from: a */
    public m getItem(int i) {
        return this.f19206b.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        m a2 = getItem(i);
        if (view == null) {
            view = a2.a(viewGroup.getContext(), a2.c(), i);
        }
        a2.a(view, a2.c());
        return view;
    }
}
