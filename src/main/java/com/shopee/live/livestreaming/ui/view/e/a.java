package com.shopee.live.livestreaming.ui.view.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.garena.android.appkit.tools.b;
import com.shopee.live.livestreaming.c;

public class a extends c {
    public static a a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new a(b(layoutInflater, viewGroup));
    }

    private a(View view) {
        super(view);
        this.f29320c.setText(b.e(c.g.live_streaming_host_related_products_btn_show));
        this.f29321d.setText(b.e(c.g.live_streaming_host_related_products_btn_showing));
    }

    public void a() {
        this.f29321d.setVisibility(8);
        this.f29320c.setVisibility(0);
        this.f29323f.setVisibility(8);
        this.f29322e.setVisibility(8);
    }

    public void b() {
        this.f29321d.setVisibility(8);
        this.f29320c.setVisibility(8);
        this.f29323f.setVisibility(0);
        this.f29322e.setVisibility(8);
    }

    public void c() {
        this.f29321d.setVisibility(0);
        this.f29320c.setVisibility(8);
        this.f29323f.setVisibility(8);
        this.f29322e.setVisibility(8);
    }

    public View d() {
        return this.f29320c;
    }

    public void a(View.OnClickListener onClickListener) {
        this.f29320c.setOnClickListener(onClickListener);
    }
}
