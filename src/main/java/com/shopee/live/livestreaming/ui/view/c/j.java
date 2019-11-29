package com.shopee.live.livestreaming.ui.view.c;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.util.d;

public class j extends b {

    /* renamed from: g  reason: collision with root package name */
    private View f29293g;
    private View h;
    private TextView i;
    private ImageView j;

    /* access modifiers changed from: protected */
    public void g() {
    }

    public j(Activity activity) {
        super(activity);
    }

    public void c() {
        super.c();
    }

    /* access modifiers changed from: protected */
    public View d() {
        this.f29293g = LayoutInflater.from(this.f29253b).inflate(c.f.live_streaming_layout_popup_weak_net, (ViewGroup) null);
        this.i = (TextView) this.f29293g.findViewById(c.e.tv_popup_symbol);
        this.j = (ImageView) this.f29293g.findViewById(c.e.iv_popup_symbol);
        return this.f29293g;
    }

    /* access modifiers changed from: protected */
    public View e() {
        this.h = this.f29293g.findViewById(c.e.popup_window_view);
        return this.h;
    }

    /* access modifiers changed from: protected */
    public View f() {
        return this.f29293g.findViewById(c.e.shadow_view);
    }

    public void a(int i2, String str) {
        if (!d.a(str)) {
            this.i.setText(str);
        }
        this.i.setText(str);
        this.h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                d.a(j.this.f29253b);
            }
        });
    }
}
