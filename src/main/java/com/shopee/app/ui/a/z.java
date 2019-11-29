package com.shopee.app.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

public abstract class z<T> extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    List<T> f19257a = new ArrayList();

    /* access modifiers changed from: protected */
    public abstract n<T> a(Context context, int i);

    public long getItemId(int i) {
        return (long) i;
    }

    protected z() {
    }

    public void a(List<T> list) {
        this.f19257a = list;
    }

    public int getCount() {
        return this.f19257a.size();
    }

    public T getItem(int i) {
        return this.f19257a.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        n nVar;
        if (view == null) {
            nVar = a(viewGroup.getContext(), i);
        } else {
            nVar = (n) view;
        }
        nVar.a(getItem(i));
        return (View) nVar;
    }
}
