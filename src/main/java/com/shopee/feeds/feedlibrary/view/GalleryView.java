package com.shopee.feeds.feedlibrary.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.shopee.feeds.feedlibrary.adapter.SelectorPictureAdapter;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.picture.LocalMedia;
import com.shopee.feeds.feedlibrary.util.s;
import com.squareup.a.w;
import java.util.ArrayList;
import java.util.List;

public class GalleryView extends FrameLayout implements SelectorPictureAdapter.a {

    /* renamed from: a  reason: collision with root package name */
    View f28435a;

    /* renamed from: b  reason: collision with root package name */
    RecyclerView f28436b;

    /* renamed from: c  reason: collision with root package name */
    SelectorPictureAdapter f28437c;

    /* renamed from: d  reason: collision with root package name */
    ArrayList<LocalMedia> f28438d;

    /* renamed from: e  reason: collision with root package name */
    a f28439e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f28440f;

    /* renamed from: g  reason: collision with root package name */
    private int f28441g;

    public interface a {
        void a(int i, LocalMedia localMedia);

        void b(int i, LocalMedia localMedia);
    }

    public void a(List<LocalMedia> list) {
    }

    public GalleryView(Context context) {
        this(context, (AttributeSet) null);
    }

    public GalleryView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GalleryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28438d = new ArrayList<>();
        a();
    }

    private void a() {
        this.f28435a = LayoutInflater.from(getContext()).inflate(c.f.feeds_layout_gallery, this, true);
        this.f28436b = (RecyclerView) this.f28435a.findViewById(c.e.rv_gallery);
        this.f28436b.a((RecyclerView.h) new a(4, s.a(getContext(), 1.2f), false));
        this.f28436b.setLayoutManager(new GridLayoutManager(getContext(), 4));
        this.f28436b.a((RecyclerView.n) new RecyclerView.n() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                w a2 = w.a(GalleryView.this.getContext());
                if (i == 0) {
                    a2.b((Object) "PhotoTag");
                } else {
                    a2.a((Object) "PhotoTag");
                }
            }
        });
        this.f28437c = new SelectorPictureAdapter(getContext());
        this.f28437c.a((SelectorPictureAdapter.a) this);
        this.f28436b.setAdapter(this.f28437c);
    }

    public void setLocalMediaList(ArrayList<LocalMedia> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            this.f28438d.clear();
            this.f28438d.addAll(arrayList);
            this.f28437c.a(this.f28438d);
        }
    }

    public void setMode(int i) {
        this.f28437c.a(i);
    }

    public void a(LocalMedia localMedia, int i) {
        a aVar = this.f28439e;
        if (aVar != null) {
            aVar.a(i, localMedia);
        }
    }

    public void b(LocalMedia localMedia, int i) {
        this.f28439e.b(i, localMedia);
    }

    public void a(LocalMedia localMedia) {
        this.f28437c.a(localMedia);
    }

    public void a(int i) {
        RecyclerView recyclerView = this.f28436b;
        int g2 = recyclerView.g(recyclerView.getChildAt(0));
        RecyclerView recyclerView2 = this.f28436b;
        int g3 = recyclerView2.g(recyclerView2.getChildAt(recyclerView2.getChildCount() - 1));
        if (i < g2) {
            this.f28436b.d(i);
        } else if (i <= g3) {
            int i2 = i - g2;
            if (i2 >= 0 && i2 < this.f28436b.getChildCount()) {
                this.f28436b.a(0, this.f28436b.getChildAt(i2).getTop());
            }
        } else {
            this.f28436b.d(i);
            this.f28441g = i;
            this.f28440f = true;
        }
    }

    public void setGalleryImageSelectedListener(a aVar) {
        this.f28439e = aVar;
    }
}
