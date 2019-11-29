package com.shopee.app.util.c;

import android.content.Context;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;

public final class c extends b implements a, b {
    private boolean l = false;
    private final org.a.a.b.c m = new org.a.a.b.c();

    public c(Context context) {
        super(context);
        f();
    }

    public static b a(Context context) {
        c cVar = new c(context);
        cVar.onFinishInflate();
        return cVar;
    }

    public void onFinishInflate() {
        if (!this.l) {
            this.l = true;
            inflate(getContext(), R.layout.coin_overlay_view, this);
            this.m.a((a) this);
        }
        super.onFinishInflate();
    }

    private void f() {
        org.a.a.b.c a2 = org.a.a.b.c.a(this.m);
        org.a.a.b.c.a((b) this);
        this.h = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_from_up);
        this.i = AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_from_top);
        this.j = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in_animation);
        this.k = AnimationUtils.loadAnimation(getContext(), R.anim.fade_out_animation);
        org.a.a.b.c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f26276a = (Button) aVar.internalFindViewById(R.id.collect_btn);
        this.f26277b = (ImageView) aVar.internalFindViewById(R.id.coin_icon_big);
        this.f26278c = (TextView) aVar.internalFindViewById(R.id.coin_amount);
        this.f26279d = (ImageView) aVar.internalFindViewById(R.id.icon);
        this.f26280e = aVar.internalFindViewById(R.id.popup);
        this.f26281f = aVar.internalFindViewById(R.id.bar_overlay);
        this.f26282g = (TextView) aVar.internalFindViewById(R.id.coin_balance);
        a();
    }
}
