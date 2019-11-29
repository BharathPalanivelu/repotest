package com.shopee.app.ui.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class aa<T> extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    protected List<T> f19176a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final s<T> f19177b;

    public long getItemId(int i) {
        return (long) i;
    }

    public aa(s<T> sVar) {
        this.f19177b = sVar;
    }

    public void a(List<T> list) {
        this.f19176a = list;
    }

    public int getCount() {
        return this.f19176a.size();
    }

    public int getItemViewType(int i) {
        return this.f19177b.a(getItem(i), i);
    }

    public int getViewTypeCount() {
        return this.f19177b.a();
    }

    public T getItem(int i) {
        return this.f19176a.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Object item = getItem(i);
        if (view == null) {
            view = this.f19177b.a(viewGroup.getContext(), getItemViewType(i));
        }
        view.setTag(R.id.view_position, Integer.valueOf(i));
        if (view instanceof n) {
            ((n) view).a(item);
        }
        return view;
    }
}
