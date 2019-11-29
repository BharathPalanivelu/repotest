package com.shopee.app.util.c;

import android.view.View;
import android.widget.FrameLayout;
import com.shopee.app.data.viewmodel.CoinInfo;
import com.shopee.app.network.d.w;
import com.shopee.app.util.c.b;

public class a implements View.OnClickListener, b.a {

    /* renamed from: a  reason: collision with root package name */
    private FrameLayout f26272a;

    /* renamed from: b  reason: collision with root package name */
    private b f26273b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f26274c = false;

    /* renamed from: d  reason: collision with root package name */
    private b.a f26275d;

    public a() {
    }

    public a(b.a aVar) {
        this.f26275d = aVar;
    }

    public void a(FrameLayout frameLayout, long j, long j2, CoinInfo coinInfo) {
        this.f26272a = frameLayout;
        this.f26273b = c.a(this.f26272a.getContext());
        this.f26273b.setOnCollectListener(this);
        this.f26273b.a(j, j + j2, coinInfo);
        this.f26273b.setOnAnimationFinishListener(this);
        this.f26272a.addView(this.f26273b);
    }

    public void onClick(View view) {
        b();
        this.f26274c = true;
    }

    private void b() {
        if (!this.f26274c) {
            this.f26273b.d();
            new w().g();
        }
    }

    public void a() {
        this.f26272a.removeView(this.f26273b);
        b.a aVar = this.f26275d;
        if (aVar != null) {
            aVar.a();
        }
    }
}
