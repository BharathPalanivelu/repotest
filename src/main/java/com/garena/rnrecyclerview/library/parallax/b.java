package com.garena.rnrecyclerview.library.parallax;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.garena.rnrecyclerview.library.c.a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class b extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private View f8578a;

    /* renamed from: b  reason: collision with root package name */
    private View f8579b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public View f8580c = null;

    /* renamed from: d  reason: collision with root package name */
    private EventDispatcher f8581d;

    /* renamed from: e  reason: collision with root package name */
    private int f8582e = ((int) PixelUtil.toPixelFromDIP(220.0f));

    /* renamed from: f  reason: collision with root package name */
    private int f8583f = ((int) PixelUtil.toPixelFromDIP(113.0f));

    /* renamed from: g  reason: collision with root package name */
    private int f8584g = this.f8582e;
    private int h = this.f8583f;
    private boolean i = false;
    private float j = 1.0f;

    public b(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        this.f8581d = ((UIManagerModule) ((ReactContext) getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher();
    }

    public void a(View view) {
        this.f8578a = view;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f8584g);
        layoutParams.gravity = 48;
        addView(view, layoutParams);
        b();
    }

    public void b(View view) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = this.h;
        addView(view, layoutParams);
        this.f8579b = view;
        b();
    }

    private void b() {
        if (this.f8579b != null && this.f8578a != null) {
            RecyclerView c2 = c();
            final a aVar = new a(c2, this.f8578a, this.f8584g, this.h, this.i, this.j);
            c2.a((RecyclerView.n) new RecyclerView.n() {
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    if (b.this.f8580c == null) {
                        View unused = b.this.f8580c = recyclerView.getLayoutManager().i(0);
                    }
                    float a2 = aVar.a(i2, Math.min(b.this.f8580c.getTop(), recyclerView.computeVerticalScrollOffset() * -1));
                    if (a2 != -1.0f) {
                        b.this.a((int) a2);
                    }
                }
            });
            c2.getAdapter().registerAdapterDataObserver(new RecyclerView.c() {
                public void a() {
                    super.a();
                }
            });
        }
    }

    private RecyclerView c() {
        View view = this.f8579b;
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        if (!(view instanceof ViewGroup) || !(((ViewGroup) view).getChildAt(0) instanceof RecyclerView)) {
            return null;
        }
        return (RecyclerView) ((ViewGroup) this.f8579b).getChildAt(0);
    }

    public void setHeaderHeight(int i2) {
        this.f8584g = i2;
    }

    public void setStopY(int i2) {
        this.h = i2;
    }

    public void setQuickReturn(boolean z) {
        this.i = z;
    }

    public void setSpeedRatio(double d2) {
        this.j = (float) d2;
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        this.f8581d.dispatchEvent(new a(getId(), i2));
    }

    public void a() {
        this.f8578a.setTranslationY(BitmapDescriptorFactory.HUE_RED);
    }
}
