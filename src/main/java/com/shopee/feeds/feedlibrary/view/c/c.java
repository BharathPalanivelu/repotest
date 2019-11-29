package com.shopee.feeds.feedlibrary.view.c;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.shopee.feeds.feedlibrary.c;

public class c extends a {

    /* renamed from: f  reason: collision with root package name */
    private View f28567f;

    /* renamed from: g  reason: collision with root package name */
    private View f28568g;
    private TextView h;
    private TextView i;
    private TextView j;

    public c(Activity activity) {
        super(activity);
    }

    /* access modifiers changed from: protected */
    public View c() {
        this.f28567f = LayoutInflater.from(this.f28555b).inflate(c.f.feeds_popup_select_voucher_tips, (ViewGroup) null);
        this.h = (TextView) this.f28567f.findViewById(c.e.tv_confirm);
        this.i = (TextView) this.f28567f.findViewById(c.e.tv_tip_1);
        this.j = (TextView) this.f28567f.findViewById(c.e.tv_title);
        this.h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                c.this.b();
            }
        });
        this.j.setText(b.e(c.g.feeds_voucher_eligible_alert_title));
        this.i.setText(b.e(c.g.feeds_voucher_eligible_alert_message));
        this.h.setText(b.e(c.g.feeds_button_ok));
        return this.f28567f;
    }

    /* access modifiers changed from: protected */
    public View d() {
        this.f28568g = this.f28567f.findViewById(c.e.popup_window_view);
        return this.f28568g;
    }

    /* access modifiers changed from: protected */
    public View e() {
        return this.f28567f.findViewById(c.e.shadow_view);
    }
}
