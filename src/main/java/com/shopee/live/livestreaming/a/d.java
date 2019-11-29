package com.shopee.live.livestreaming.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public abstract class d<T> extends RecyclerView.a {
    /* access modifiers changed from: protected */

    /* renamed from: a  reason: collision with root package name */
    public Context f28751a;

    /* renamed from: b  reason: collision with root package name */
    protected List<T> f28752b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    protected LayoutInflater f28753c;

    /* renamed from: d  reason: collision with root package name */
    protected a f28754d;

    public interface a {
        void a(int i, Object obj, View view);
    }

    public void a(a aVar) {
        this.f28754d = aVar;
    }

    public d(Context context) {
        this.f28751a = context;
        this.f28753c = LayoutInflater.from(context);
    }

    public int getItemCount() {
        List<T> list = this.f28752b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void a(List<T> list) {
        if (list != null) {
            List<T> list2 = this.f28752b;
            if (list2 == null) {
                this.f28752b = new ArrayList(list.size());
            } else {
                list2.clear();
            }
            this.f28752b.addAll(list);
            notifyDataSetChanged();
        }
    }

    public Object a(int i) {
        List<T> list = this.f28752b;
        if (list == null || list.size() <= i) {
            return null;
        }
        return this.f28752b.get(i);
    }

    public void a(T t) {
        if (this.f28752b == null) {
            this.f28752b = new ArrayList();
        }
        this.f28752b.add(t);
        notifyItemInserted(this.f28752b.size() - 1);
    }
}
