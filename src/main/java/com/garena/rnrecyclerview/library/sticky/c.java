package com.garena.rnrecyclerview.library.sticky;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.scroll.OnScrollDispatchHelper;
import com.garena.rnrecyclerview.library.ReactRecyclerViewModule;
import com.garena.rnrecyclerview.library.a;
import com.garena.rnrecyclerview.library.sticky.views.InternalRecyclerView;
import eu.davidea.flexibleadapter.b;
import eu.davidea.flexibleadapter.b.f;
import eu.davidea.flexibleadapter.b.g;
import java.util.ArrayList;
import java.util.List;

public class c extends FrameLayout implements b.k {

    /* renamed from: a  reason: collision with root package name */
    public boolean f8625a = false;

    /* renamed from: b  reason: collision with root package name */
    public Runnable f8626b = new Runnable() {
        public void run() {
            c.this.j.a(c.this.k);
            c cVar = c.this;
            cVar.f8625a = false;
            for (f fVar : cVar.k) {
                if (fVar instanceof com.garena.rnrecyclerview.library.sticky.a.a) {
                    com.garena.rnrecyclerview.library.sticky.a.a aVar = (com.garena.rnrecyclerview.library.sticky.a.a) fVar;
                    Log.d("ITEM_NATIVE2", "pos:" + 0 + " id:" + aVar.f8614a + " type:" + aVar.f8615b.f8565a);
                } else if (fVar instanceof com.garena.rnrecyclerview.library.sticky.a.b) {
                    com.garena.rnrecyclerview.library.sticky.a.b bVar = (com.garena.rnrecyclerview.library.sticky.a.b) fVar;
                    Log.d("ITEM_NATIVE2", "pos:" + 0 + " id:" + bVar.f8617a + " type:" + bVar.f8618b.f8565a);
                }
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final LinearLayoutManager f8627c;

    /* renamed from: d  reason: collision with root package name */
    private EventDispatcher f8628d = ((UIManagerModule) ((ReactContext) getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher();

    /* renamed from: e  reason: collision with root package name */
    private ReactRecyclerViewModule f8629e = ((ReactRecyclerViewModule) ((ReactContext) getContext()).getNativeModule(ReactRecyclerViewModule.class));

    /* renamed from: f  reason: collision with root package name */
    private com.garena.rnrecyclerview.library.d.c f8630f;

    /* renamed from: g  reason: collision with root package name */
    private b f8631g;
    /* access modifiers changed from: private */
    public InternalRecyclerView h;
    /* access modifiers changed from: private */
    public final OnScrollDispatchHelper i = new OnScrollDispatchHelper();
    /* access modifiers changed from: private */
    public final b<f> j;
    /* access modifiers changed from: private */
    public List<f> k;
    private a l;
    private final Runnable m = new Runnable() {
        public void run() {
            c cVar = c.this;
            cVar.measure(View.MeasureSpec.makeMeasureSpec(cVar.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(c.this.getHeight(), 1073741824));
            c cVar2 = c.this;
            cVar2.layout(cVar2.getLeft(), c.this.getTop(), c.this.getRight(), c.this.getBottom());
        }
    };

    public c(Context context) {
        super(context);
        this.h = (InternalRecyclerView) inflate(context, a.C0147a.sticky_recycler_view, (ViewGroup) null);
        this.h.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.h.a((RecyclerView.n) new a());
        addView(this.h);
        this.f8630f = new com.garena.rnrecyclerview.library.d.c();
        this.k = new ArrayList();
        this.l = new a(this.f8630f);
        this.j = new b<>((List) null, this, true);
        b.c(false);
        this.f8627c = new LinearLayoutManager(getContext());
        this.h.setLayoutManager(this.f8627c);
    }

    public void setId(int i2) {
        super.setId(i2);
        b();
    }

    public void requestLayout() {
        super.requestLayout();
        post(this.m);
    }

    public void a(View view) {
        if (view instanceof b) {
            this.f8631g = (b) view;
            addView(this.f8631g);
            this.j.b(true).d();
            this.h.setAdapter(this.j);
            return;
        }
        com.garena.rnrecyclerview.library.view.a aVar = (com.garena.rnrecyclerview.library.view.a) view;
        this.f8630f.a(aVar.getViewType(), aVar);
    }

    public void a() {
        this.f8630f.a();
    }

    public void setDataSource(List<f> list) {
        this.k = list;
        if (!this.f8625a) {
            this.f8625a = true;
            postDelayed(this.f8626b, 600);
        }
    }

    public com.garena.rnrecyclerview.library.d.c getViewCache() {
        return this.f8630f;
    }

    public a getTransformer() {
        return this.l;
    }

    public void a(int i2) {
        this.f8631g.a();
        g e2 = this.j.e(i2);
        if (e2 == null || !(e2 instanceof com.garena.rnrecyclerview.library.sticky.a.a)) {
            this.f8628d.dispatchEvent(new com.garena.rnrecyclerview.library.c.c(getId(), -1, "", ""));
            return;
        }
        com.garena.rnrecyclerview.library.sticky.a.a aVar = (com.garena.rnrecyclerview.library.sticky.a.a) e2;
        this.f8628d.dispatchEvent(new com.garena.rnrecyclerview.library.c.c(getId(), i2, aVar.f8614a, aVar.f8615b.f8565a));
    }

    public void a(int i2, boolean z) {
        if (z) {
            this.f8627c.b(i2, 0);
        } else {
            this.f8627c.b(i2, 0);
        }
    }

    public void a(int i2, double d2, boolean z) {
        if (z) {
            this.f8627c.b(i2, ((int) PixelUtil.toPixelFromDIP(d2)) * -1);
        } else {
            this.f8627c.b(i2, ((int) PixelUtil.toPixelFromDIP(d2)) * -1);
        }
    }

    /* access modifiers changed from: private */
    public void a(ViewGroup viewGroup, int i2, int i3) {
        this.f8628d.dispatchEvent(com.garena.rnrecyclerview.library.c.b.a(getId(), "didStickyScroll", i2, i3));
    }

    public void b() {
        this.f8629e.registerLayoutManager(getId(), this.f8627c);
    }

    public void c() {
        this.f8629e.unregisterLayoutManager(getId());
    }

    private class a extends RecyclerView.n {
        private a() {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int computeVerticalScrollOffset = c.this.h.computeVerticalScrollOffset();
            super.onScrolled(recyclerView, i, i2);
            if (c.this.i.onScrollChanged(i, i2)) {
                c.this.a((ViewGroup) recyclerView, i2, computeVerticalScrollOffset);
            }
        }
    }
}
