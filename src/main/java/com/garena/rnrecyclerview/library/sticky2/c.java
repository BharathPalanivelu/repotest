package com.garena.rnrecyclerview.library.sticky2;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.garena.rnrecyclerview.library.recycler.a;
import com.garena.rnrecyclerview.library.recycler.d;
import com.garena.rnrecyclerview.library.sticky.b;
import java.util.HashMap;

public class c extends RecyclerView.n {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayoutManager f8644a;

    /* renamed from: b  reason: collision with root package name */
    private final a f8645b;

    /* renamed from: c  reason: collision with root package name */
    private b f8646c;

    /* renamed from: d  reason: collision with root package name */
    private final a f8647d;

    /* renamed from: e  reason: collision with root package name */
    private int f8648e = -1;

    /* renamed from: f  reason: collision with root package name */
    private HashMap<Integer, d> f8649f;

    /* renamed from: g  reason: collision with root package name */
    private int f8650g = -1;
    private int h = 200;

    public c(RecyclerView recyclerView, b bVar, a aVar) {
        this.f8646c = bVar;
        this.f8644a = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.f8647d = (a) recyclerView.getAdapter();
        this.f8645b = aVar;
        this.f8649f = new HashMap<>();
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        int a2 = a(this.f8644a.n());
        if (a2 != this.f8648e || i2 == 0) {
            if (a2 != this.f8648e) {
                a aVar = this.f8645b;
                if (aVar != null) {
                    if (a2 == -1) {
                        aVar.a(a2, "", "");
                    } else {
                        com.garena.rnrecyclerview.library.recycler.c b2 = this.f8647d.b(a2);
                        this.f8645b.a(a2, b2.f8602c, b2.f8601b);
                    }
                }
            }
            if (a2 == -1) {
                a();
            } else {
                int itemViewType = this.f8647d.getItemViewType(a2);
                if (itemViewType != this.f8650g) {
                    this.f8646c.removeAllViews();
                    this.f8650g = itemViewType;
                    if (!this.f8649f.containsKey(Integer.valueOf(itemViewType))) {
                        d a3 = this.f8647d.onCreateViewHolder((ViewGroup) recyclerView, itemViewType);
                        this.f8646c.addView(a3.itemView);
                        this.f8649f.put(Integer.valueOf(itemViewType), a3);
                    } else {
                        this.f8646c.addView(this.f8649f.get(Integer.valueOf(itemViewType)).itemView);
                    }
                }
                this.f8647d.onBindViewHolder(this.f8649f.get(Integer.valueOf(itemViewType)), a2);
                b();
            }
            this.f8648e = a2;
        }
    }

    private int a(int i) {
        return this.f8647d.a(i);
    }

    private void a() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 2);
        layoutParams.gravity = 48;
        this.f8646c.setLayoutParams(layoutParams);
        this.f8646c.setFocusable(false);
        this.f8646c.setFocusableInTouchMode(false);
        this.f8646c.setEnabled(false);
        this.f8646c.setVisibility(4);
    }

    private void b() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f8646c.getRowHeight());
        layoutParams.gravity = 48;
        this.f8646c.setLayoutParams(layoutParams);
        this.f8646c.setVisibility(0);
    }
}
