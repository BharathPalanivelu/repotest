package com.shopee.app.ui.video;

import android.app.Activity;
import android.content.Context;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class f extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    Activity f25775a;

    /* renamed from: b  reason: collision with root package name */
    ImageButton f25776b;

    /* renamed from: c  reason: collision with root package name */
    VideoViewerView f25777c;

    /* renamed from: d  reason: collision with root package name */
    RelativeLayout f25778d;

    /* renamed from: e  reason: collision with root package name */
    Animation f25779e;

    /* renamed from: f  reason: collision with root package name */
    Animation f25780f;

    /* renamed from: g  reason: collision with root package name */
    private String f25781g;

    public f(Context context, String str) {
        super(context);
        this.f25781g = str;
        ((e) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f25777c.setId(R.id.content_container);
        this.f25777c.a(this.f25781g, false);
        this.f25777c.setTopBarStatusListener(new b() {
            public void a(boolean z) {
                if (z) {
                    f.this.f25778d.setVisibility(0);
                    f.this.f25778d.startAnimation(f.this.f25780f);
                    return;
                }
                f.this.f25778d.setVisibility(8);
                f.this.f25778d.startAnimation(f.this.f25779e);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f25775a.onBackPressed();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f25777c.d();
    }
}
