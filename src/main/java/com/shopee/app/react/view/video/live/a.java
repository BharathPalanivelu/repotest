package com.shopee.app.react.view.video.live;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.a.q;
import com.shopee.live.livestreaming.b.b;
import com.shopee.live.livestreaming.b.c;

public class a extends FrameLayout implements LifecycleEventListener, b.a {

    /* renamed from: a  reason: collision with root package name */
    final EventDispatcher f19133a;

    /* renamed from: b  reason: collision with root package name */
    private final ThemedReactContext f19134b;

    /* renamed from: c  reason: collision with root package name */
    private View f19135c;

    /* renamed from: d  reason: collision with root package name */
    private b f19136d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f19137e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f19138f;

    /* renamed from: g  reason: collision with root package name */
    private final Runnable f19139g = new Runnable() {
        public void run() {
            a aVar = a.this;
            aVar.measure(View.MeasureSpec.makeMeasureSpec(aVar.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(a.this.getHeight(), 1073741824));
            a aVar2 = a.this;
            aVar2.layout(aVar2.getLeft(), a.this.getTop(), a.this.getRight(), a.this.getBottom());
        }
    };

    public a(ThemedReactContext themedReactContext) {
        super(themedReactContext);
        this.f19134b = themedReactContext;
        this.f19136d = new c();
        this.f19135c = this.f19136d.a((Context) themedReactContext);
        this.f19136d.a((b.a) this);
        addView(this.f19135c, new FrameLayout.LayoutParams(-1, -1));
        this.f19133a = ((UIManagerModule) ((ReactContext) getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher();
    }

    public ThemedReactContext getReactContext() {
        return this.f19134b;
    }

    public void requestLayout() {
        super.requestLayout();
        post(this.f19139g);
    }

    public void setSource(String str) {
        try {
            this.f19136d.a(new q().a(str).m());
        } catch (Exception unused) {
        }
    }

    public void a() {
        b bVar = this.f19136d;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void b() {
        b bVar = this.f19136d;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void a(int i) {
        b bVar = this.f19136d;
        if (bVar != null) {
            bVar.a(i);
        }
    }

    public void setMuted(boolean z) {
        this.f19138f = z;
        b bVar = this.f19136d;
        if (bVar != null) {
            bVar.a(z);
        }
    }

    public void b(int i) {
        this.f19133a.dispatchEvent(new com.shopee.app.react.view.video.a.b(getId(), i));
    }

    public void a(int i, String str, boolean z, int i2, boolean z2, int i3, int i4) {
        this.f19133a.dispatchEvent(new com.shopee.app.react.view.video.a.a(getId(), str, z, i, i2, z2, i3, i4));
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        b();
        return super.onSaveInstanceState();
    }

    public void c() {
        this.f19137e = true;
        this.f19136d.a((b.a) null);
        this.f19136d.e();
    }

    public void a(b.C0438b bVar) {
        a(bVar.c() * 1000, bVar.a(), bVar.b(), bVar.d() * 1000, bVar.e(), bVar.f(), bVar.g());
    }

    public void c(int i) {
        b(i);
    }

    public void onHostResume() {
        b bVar = this.f19136d;
        if (bVar != null) {
            bVar.c();
        }
    }

    public void onHostPause() {
        b bVar = this.f19136d;
        if (bVar != null) {
            bVar.d();
        }
    }

    public void onHostDestroy() {
        if (!this.f19137e) {
            c();
        }
    }
}
