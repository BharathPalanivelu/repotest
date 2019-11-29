package com.garena.rnrecyclerview.library.recycler;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import com.facebook.react.views.scroll.OnScrollDispatchHelper;
import com.garena.rnrecyclerview.library.ReactRecyclerViewModule;
import com.garena.rnrecyclerview.library.c.b;
import com.garena.rnrecyclerview.library.d.c;
import com.garena.rnrecyclerview.library.d.f;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import java.util.ArrayList;
import java.util.List;

public class ReactRecyclerView extends RecyclerView {
    private c M;
    private f N;
    private com.garena.rnrecyclerview.library.b.a O;
    private EventDispatcher P;
    private ReactRecyclerViewModule Q;
    private List<View> R;
    private a S;
    private List<c> T;
    /* access modifiers changed from: private */
    public final OnScrollDispatchHelper U = new OnScrollDispatchHelper();
    private LinearLayoutManager V;
    private boolean W = false;
    private com.garena.rnrecyclerview.library.d.a aa;
    /* access modifiers changed from: private */
    public boolean ab = false;
    /* access modifiers changed from: private */
    public boolean ac = false;

    public ReactRecyclerView(Context context) {
        super(context);
        a(context);
    }

    public ReactRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ReactRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        this.P = ((UIManagerModule) ((ReactContext) getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher();
        this.Q = (ReactRecyclerViewModule) ((ReactContext) getContext()).getNativeModule(ReactRecyclerViewModule.class);
        this.T = new ArrayList();
        this.M = new c();
        this.R = new ArrayList();
        this.N = new f();
        this.V = new LinearLayoutManager(context);
        setLayoutManager(this.V);
        a((RecyclerView.n) new a());
        this.O = new com.garena.rnrecyclerview.library.b.a(this.N);
        this.S = new a(this.M, this.N);
        setItemAnimator((RecyclerView.f) null);
        this.S.registerAdapterDataObserver(new RecyclerView.c() {
            public void a() {
                ReactRecyclerView.this.forceLayout();
            }

            public void a(int i, int i2) {
                ReactRecyclerView.this.forceLayout();
            }

            public void a(int i, int i2, Object obj) {
                ReactRecyclerView.this.forceLayout();
            }

            public void b(int i, int i2) {
                ReactRecyclerView.this.forceLayout();
            }

            public void c(int i, int i2) {
                ReactRecyclerView.this.forceLayout();
            }

            public void a(int i, int i2, int i3) {
                ReactRecyclerView.this.forceLayout();
            }
        });
        setAdapter(this.S);
    }

    public void setId(int i) {
        super.setId(i);
        z();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(View.MeasureSpec.makeMeasureSpec(i, RNCartPanelDataEntity.NULL_VALUE)), View.MeasureSpec.getSize(View.MeasureSpec.makeMeasureSpec(i2, RNCartPanelDataEntity.NULL_VALUE)));
    }

    public void setDataSource(List<c> list) {
        this.W = true;
        new b(this, this.S, this.T, list).execute(new Void[0]);
        this.T = list;
    }

    public void b(int i, boolean z) {
        if (z) {
            this.V.b(i, 0);
        } else {
            this.V.b(i, 0);
        }
        forceLayout();
    }

    public void a(int i, double d2, boolean z) {
        if (z) {
            this.V.b(i, ((int) PixelUtil.toPixelFromDIP(d2)) * -1);
        } else {
            this.V.b(i, ((int) PixelUtil.toPixelFromDIP(d2)) * -1);
        }
        forceLayout();
    }

    public com.garena.rnrecyclerview.library.b.a getDataSourceMapper() {
        return this.O;
    }

    public void n(View view) {
        if (view instanceof com.garena.rnrecyclerview.library.view.a) {
            this.M.a(((com.garena.rnrecyclerview.library.view.a) view).getViewType(), view);
            this.ab = false;
        }
    }

    public void y() {
        this.ab = true;
        this.W = false;
        this.M.a();
    }

    public List<View> getViewList() {
        return this.R;
    }

    public com.garena.rnrecyclerview.library.d.a getBatchExecutor() {
        if (this.aa == null) {
            this.aa = new com.garena.rnrecyclerview.library.d.a(this);
        }
        return this.aa;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!super.onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        NativeGestureUtil.notifyNativeGestureStarted(this, motionEvent);
        return true;
    }

    /* access modifiers changed from: private */
    public void a(ViewGroup viewGroup, int i, int i2) {
        this.P.dispatchEvent(b.a(getId(), "didScroll", i, i2));
    }

    public void z() {
        this.Q.registerLayoutManager(getId(), this.V);
    }

    public void A() {
        this.R.clear();
        this.ab = true;
        this.W = false;
        this.Q.unregisterLayoutManager(getId());
    }

    public boolean B() {
        return this.ab;
    }

    private class a extends RecyclerView.n {
        private a() {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (ReactRecyclerView.this.U.onScrollChanged(i, i2)) {
                ReactRecyclerView reactRecyclerView = ReactRecyclerView.this;
                reactRecyclerView.a((ViewGroup) recyclerView, i2, reactRecyclerView.computeVerticalScrollOffset());
            }
        }
    }

    public void requestLayout() {
        if (!this.ac) {
            this.ac = true;
            post(new Runnable() {
                public void run() {
                    boolean unused = ReactRecyclerView.this.ac = false;
                    if (!ReactRecyclerView.this.ab) {
                        ReactRecyclerView reactRecyclerView = ReactRecyclerView.this;
                        reactRecyclerView.onLayout(false, reactRecyclerView.getLeft(), ReactRecyclerView.this.getTop(), ReactRecyclerView.this.getRight(), ReactRecyclerView.this.getBottom());
                    }
                }
            });
        }
    }
}
