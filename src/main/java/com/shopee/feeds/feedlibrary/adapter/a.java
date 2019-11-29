package com.shopee.feeds.feedlibrary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public abstract class a<T> extends RecyclerView.a {

    /* renamed from: a  reason: collision with root package name */
    protected Context f27557a;

    /* renamed from: b  reason: collision with root package name */
    protected List<T> f27558b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    protected LayoutInflater f27559c;

    /* renamed from: d  reason: collision with root package name */
    protected C0422a f27560d;

    /* renamed from: com.shopee.feeds.feedlibrary.adapter.a$a  reason: collision with other inner class name */
    public interface C0422a {
        void a(int i, Object obj, View view);
    }

    public void a(C0422a aVar) {
        this.f27560d = aVar;
    }

    public a(Context context) {
        this.f27557a = context;
        this.f27559c = LayoutInflater.from(context);
    }

    public int getItemCount() {
        List<T> list = this.f27558b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void a(List<T> list) {
        if (list != null) {
            List<T> list2 = this.f27558b;
            if (list2 == null) {
                this.f27558b = new ArrayList(list.size());
            } else {
                list2.clear();
            }
            this.f27558b.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void b(List<T> list) {
        if (list != null) {
            if (this.f27558b == null) {
                this.f27558b = new ArrayList(list.size());
            }
            this.f27558b.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void a() {
        List<T> list = this.f27558b;
        if (list != null && list.size() > 0) {
            this.f27558b.clear();
            notifyDataSetChanged();
        }
    }

    public List<T> b() {
        List<T> list = this.f27558b;
        return list == null ? new ArrayList() : list;
    }
}
