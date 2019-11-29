package com.shopee.live.livestreaming.ui.view.c_widget;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.garena.android.appkit.tools.b;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.ui.view.c_widget.c.a;
import com.shopee.live.livestreaming.util.d;
import com.shopee.live.livestreaming.util.f;

public class c extends com.shopee.live.livestreaming.ui.view.c.b {

    /* renamed from: g  reason: collision with root package name */
    private View f29262g;
    private View h;
    private TextView i;
    private TextView j;
    private TextView k;

    public interface a {
        void a(c.c cVar);

        void b(c.c cVar);
    }

    /* access modifiers changed from: protected */
    public void g() {
    }

    public c(Activity activity) {
        super(activity);
    }

    public void c() {
        super.c();
        f.a().c(false);
    }

    /* access modifiers changed from: protected */
    public View d() {
        this.f29262g = LayoutInflater.from(this.f29253b).inflate(c.c.f.live_streaming_layout_popup_retry, (ViewGroup) null);
        this.i = (TextView) this.f29262g.findViewById(c.c.e.tv_content);
        this.j = (TextView) this.f29262g.findViewById(c.c.e.tv_close_live);
        this.k = (TextView) this.f29262g.findViewById(c.c.e.tv_reconnect);
        this.j.setText(b.e(c.c.g.live_streaming_floating_window_permission_btn_no));
        this.k.setText(b.e(c.c.g.live_streaming_floating_window_permission_btn_yes));
        return this.f29262g;
    }

    /* access modifiers changed from: protected */
    public View e() {
        this.h = this.f29262g.findViewById(c.c.e.popup_window_view);
        return this.h;
    }

    public void k() {
        this.f29252a.setFocusable(false);
        this.f29252a.setOutsideTouchable(false);
        a(false);
    }

    /* access modifiers changed from: protected */
    public View f() {
        return this.f29262g.findViewById(c.c.e.shadow_view);
    }

    public void a(String str, final a aVar) {
        if (!d.a(str)) {
            this.i.setText(str);
        }
        this.h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                d.a(c.c.this.f29253b);
            }
        });
        this.j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                a aVar = aVar;
                if (aVar != null) {
                    aVar.a(c.c.this);
                }
            }
        });
        this.k.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                a aVar = aVar;
                if (aVar != null) {
                    aVar.b(c.c.this);
                }
            }
        });
    }
}
