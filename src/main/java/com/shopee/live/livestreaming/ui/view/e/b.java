package com.shopee.live.livestreaming.ui.view.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.data.entity.SessionProductEntity;
import com.shopee.live.livestreaming.util.d;
import com.shopee.live.livestreaming.util.f;

public class b extends c {
    public static b a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new b(b(layoutInflater, viewGroup));
    }

    private b(View view) {
        super(view);
        this.f29320c.setText(com.garena.android.appkit.tools.b.e(c.g.live_streaming_viewer_product_btn_buy_now));
    }

    public void a(int i, SessionProductEntity.ProductItem productItem) {
        super.a(i, productItem);
        if (d.a(com.shopee.live.livestreaming.b.b().c()) == 1) {
            d();
        } else if (f.a().r()) {
            e();
        } else {
            d();
        }
    }

    public View a() {
        return this.f29320c;
    }

    public View b() {
        return this.f29319b;
    }

    public View c() {
        return this.f29322e;
    }

    private void d() {
        this.f29321d.setVisibility(8);
        this.f29320c.setVisibility(0);
        this.f29323f.setVisibility(8);
        this.f29322e.setVisibility(8);
    }

    private void e() {
        this.f29321d.setVisibility(8);
        this.f29320c.setVisibility(8);
        this.f29323f.setVisibility(8);
        this.f29322e.setVisibility(0);
    }
}
