package com.shopee.live.livestreaming.ui.view.c;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.shopee.live.livestreaming.c;

public class d extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    RelativeLayout f29268a;

    /* renamed from: b  reason: collision with root package name */
    TextView f29269b;

    /* renamed from: c  reason: collision with root package name */
    TextView f29270c;

    /* renamed from: d  reason: collision with root package name */
    View f29271d;

    /* renamed from: e  reason: collision with root package name */
    a f29272e;

    public interface a {
        void a(int i);
    }

    public d(Context context) {
        super(context);
        setHeight(-2);
        setWidth(-2);
        setOutsideTouchable(true);
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        View inflate = LayoutInflater.from(context).inflate(c.f.live_streaming_layout_popup_menu, (ViewGroup) null, false);
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f29268a = (RelativeLayout) inflate.findViewById(c.e.rl_popup_tag);
        this.f29269b = (TextView) inflate.findViewById(c.e.menu_a);
        this.f29270c = (TextView) inflate.findViewById(c.e.menu_b);
        this.f29271d = inflate.findViewById(c.e.divider);
        this.f29269b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (d.this.f29272e != null) {
                    d.this.f29272e.a(0);
                }
            }
        });
        this.f29270c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (d.this.f29272e != null) {
                    d.this.f29272e.a(1);
                }
            }
        });
        this.f29269b.setText(b.e(c.g.live_streaming_clean_mode));
        this.f29270c.setText(b.e(c.g.live_streaming_viewer_btn_report));
        setContentView(inflate);
    }

    public void a(a aVar) {
        this.f29272e = aVar;
    }

    public void a(int i, String str) {
        if (i == 0) {
            this.f29269b.setText(str);
            this.f29269b.setVisibility(0);
        } else if (i == 1) {
            this.f29270c.setText(str);
            this.f29270c.setVisibility(0);
        }
        if (this.f29270c.getVisibility() == 0 && this.f29269b.getVisibility() == 0) {
            this.f29271d.setVisibility(0);
        } else {
            this.f29271d.setVisibility(8);
        }
    }
}
