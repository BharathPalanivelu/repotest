package com.shopee.live.livestreaming.ui.view.c;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.util.d;
import com.shopee.live.livestreaming.util.f;

public class e extends b {

    /* renamed from: g  reason: collision with root package name */
    private View f29275g;
    private View h;
    private TextView i;
    private TextView j;

    public interface a {
        void a(e eVar);
    }

    /* access modifiers changed from: protected */
    public void g() {
    }

    public e(Activity activity) {
        super(activity);
    }

    public void c() {
        super.c();
        f.a().c(false);
    }

    /* access modifiers changed from: protected */
    public View d() {
        this.f29275g = LayoutInflater.from(this.f29253b).inflate(c.f.live_streaming_layout_popup_one_btn, (ViewGroup) null);
        this.i = (TextView) this.f29275g.findViewById(c.e.tv_content_one_btn);
        this.i.setText(c.g.live_streaming_host_live_show_expired);
        this.j = (TextView) this.f29275g.findViewById(c.e.tv_close_live_one_btn);
        this.j.setText(b.e(c.g.live_streaming_host_no_internet_alert_view_btn_close));
        return this.f29275g;
    }

    /* access modifiers changed from: protected */
    public View e() {
        this.h = this.f29275g.findViewById(c.e.popup_window_view_one_btn);
        return this.h;
    }

    public void k() {
        this.f29252a.setFocusable(true);
        this.f29252a.setOutsideTouchable(true);
        a(false);
        this.f29252a.a(false);
    }

    /* access modifiers changed from: protected */
    public View f() {
        return this.f29275g.findViewById(c.e.shadow_view_one_btn);
    }

    public void a(String str, String str2, final a aVar) {
        if (!d.a(str)) {
            this.i.setText(str);
        }
        if (!d.a(str2)) {
            this.j.setText(str2);
        }
        this.h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                d.a(e.this.f29253b);
            }
        });
        this.j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                a aVar = aVar;
                if (aVar != null) {
                    aVar.a(e.this);
                }
            }
        });
    }
}
