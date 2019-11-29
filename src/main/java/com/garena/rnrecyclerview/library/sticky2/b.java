package com.garena.rnrecyclerview.library.sticky2;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.garena.rnrecyclerview.library.c.c;

public class b extends FrameLayout implements a {

    /* renamed from: a  reason: collision with root package name */
    private com.garena.rnrecyclerview.library.sticky.b f8637a;

    /* renamed from: b  reason: collision with root package name */
    private View f8638b;

    /* renamed from: c  reason: collision with root package name */
    private EventDispatcher f8639c;

    /* renamed from: d  reason: collision with root package name */
    private int f8640d = ((int) PixelUtil.toPixelFromDIP(220.0f));

    /* renamed from: e  reason: collision with root package name */
    private int f8641e = this.f8640d;

    /* renamed from: f  reason: collision with root package name */
    private final Runnable f8642f = new Runnable() {
        public void run() {
            b bVar = b.this;
            bVar.measure(View.MeasureSpec.makeMeasureSpec(bVar.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(b.this.getHeight(), 1073741824));
            b bVar2 = b.this;
            bVar2.layout(bVar2.getLeft(), b.this.getTop(), b.this.getRight(), b.this.getBottom());
        }
    };

    public b(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        this.f8639c = ((UIManagerModule) ((ReactContext) getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher();
    }

    public void a(View view) {
        this.f8637a = (com.garena.rnrecyclerview.library.sticky.b) view;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f8641e);
        layoutParams.gravity = 48;
        addView(view, layoutParams);
        a();
    }

    public void b(View view) {
        addView(view, new FrameLayout.LayoutParams(-1, -1));
        this.f8638b = view;
        a();
    }

    private void a() {
        if (this.f8638b != null && this.f8637a != null) {
            RecyclerView b2 = b();
            b2.a((RecyclerView.n) new c(b2, this.f8637a, this));
        }
    }

    private RecyclerView b() {
        View view = this.f8638b;
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        return null;
    }

    public void a(int i, String str, String str2) {
        this.f8639c.dispatchEvent(new c(getId(), i, str, str2));
    }
}
