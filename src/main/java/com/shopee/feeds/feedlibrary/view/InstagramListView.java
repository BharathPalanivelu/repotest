package com.shopee.feeds.feedlibrary.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.shopee.feeds.feedlibrary.adapter.PickInsPicAdapter;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.FeedsInstagramData;
import com.shopee.feeds.feedlibrary.util.s;
import com.squareup.a.w;
import java.util.ArrayList;
import java.util.List;

public class InstagramListView extends FrameLayout implements PickInsPicAdapter.a {

    /* renamed from: a  reason: collision with root package name */
    View f28460a;

    /* renamed from: b  reason: collision with root package name */
    RecyclerView f28461b;

    /* renamed from: c  reason: collision with root package name */
    PickInsPicAdapter f28462c;

    /* renamed from: d  reason: collision with root package name */
    ArrayList<FeedsInstagramData> f28463d;

    /* renamed from: e  reason: collision with root package name */
    a f28464e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f28465f;

    /* renamed from: g  reason: collision with root package name */
    private int f28466g;

    public interface a {
        void a(int i, FeedsInstagramData feedsInstagramData);

        void b(int i, FeedsInstagramData feedsInstagramData);
    }

    public void a(List<FeedsInstagramData> list) {
    }

    public InstagramListView(Context context) {
        this(context, (AttributeSet) null);
    }

    public InstagramListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InstagramListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28463d = new ArrayList<>();
        a();
    }

    private void a() {
        this.f28460a = LayoutInflater.from(getContext()).inflate(c.f.feeds_layout_gallery, this, true);
        this.f28461b = (RecyclerView) this.f28460a.findViewById(c.e.rv_gallery);
        this.f28461b.a((RecyclerView.h) new a(4, s.a(getContext(), 1.2f), false));
        this.f28461b.setLayoutManager(new GridLayoutManager(getContext(), 4));
        this.f28461b.a((RecyclerView.n) new RecyclerView.n() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                w a2 = w.a(InstagramListView.this.getContext());
                if (i == 0) {
                    a2.b((Object) "instagram");
                } else {
                    a2.a((Object) "instagram");
                }
            }
        });
        this.f28462c = new PickInsPicAdapter(getContext());
        this.f28462c.a((PickInsPicAdapter.a) this);
        this.f28461b.setAdapter(this.f28462c);
    }

    public void setLocalMediaList(ArrayList<FeedsInstagramData> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            this.f28463d.clear();
            this.f28463d.addAll(arrayList);
            this.f28462c.a(this.f28463d);
        }
    }

    public void setMode(int i) {
        this.f28462c.a(i);
    }

    public void a(FeedsInstagramData feedsInstagramData) {
        this.f28462c.a(feedsInstagramData);
    }

    public void a(int i) {
        RecyclerView recyclerView = this.f28461b;
        int g2 = recyclerView.g(recyclerView.getChildAt(0));
        RecyclerView recyclerView2 = this.f28461b;
        int g3 = recyclerView2.g(recyclerView2.getChildAt(recyclerView2.getChildCount() - 1));
        if (i < g2) {
            this.f28461b.d(i);
        } else if (i <= g3) {
            int i2 = i - g2;
            if (i2 >= 0 && i2 < this.f28461b.getChildCount()) {
                this.f28461b.a(0, this.f28461b.getChildAt(i2).getTop());
            }
        } else {
            this.f28461b.d(i);
            this.f28466g = i;
            this.f28465f = true;
        }
    }

    public void setGalleryImageSelectedListener(a aVar) {
        this.f28464e = aVar;
    }

    public void a(FeedsInstagramData feedsInstagramData, int i) {
        a aVar = this.f28464e;
        if (aVar != null) {
            aVar.a(i, feedsInstagramData);
        }
    }

    public void b(FeedsInstagramData feedsInstagramData, int i) {
        this.f28464e.b(i, feedsInstagramData);
    }
}
