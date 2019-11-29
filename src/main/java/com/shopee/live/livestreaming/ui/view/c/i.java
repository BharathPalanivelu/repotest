package com.shopee.live.livestreaming.ui.view.c;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.util.d;

public class i extends b {

    /* renamed from: g  reason: collision with root package name */
    private View f29287g;
    private View h;
    private TextView i;
    private TextView j;
    private TextView k;

    public interface a {
        void a(i iVar);

        void b(i iVar);
    }

    /* access modifiers changed from: protected */
    public void g() {
    }

    public i(Activity activity) {
        super(activity);
    }

    public void c() {
        super.c();
    }

    /* access modifiers changed from: protected */
    public View d() {
        this.f29287g = LayoutInflater.from(this.f29253b).inflate(c.f.live_streaming_layout_popup_retry, (ViewGroup) null);
        this.i = (TextView) this.f29287g.findViewById(c.e.tv_content);
        this.j = (TextView) this.f29287g.findViewById(c.e.tv_close_live);
        this.k = (TextView) this.f29287g.findViewById(c.e.tv_reconnect);
        this.i.setText(b.e(c.g.live_streaming_host_no_internet_alert_view_title));
        this.j.setText(b.e(c.g.live_streaming_host_no_internet_alert_view_btn_close));
        this.k.setText(b.e(c.g.live_streaming_host_no_internet_alert_view_btn_try_again));
        return this.f29287g;
    }

    /* access modifiers changed from: protected */
    public View e() {
        this.h = this.f29287g.findViewById(c.e.popup_window_view);
        return this.h;
    }

    /* access modifiers changed from: protected */
    public View f() {
        return this.f29287g.findViewById(c.e.shadow_view);
    }

    public void a(String str) {
        if (!d.a(str)) {
            this.k.setText(str);
        }
    }

    public void a(int i2) {
        this.k.setTextColor(i2);
    }

    public void b(boolean z) {
        if (z) {
            this.k.setEnabled(true);
        } else {
            this.k.setEnabled(false);
        }
    }

    public void a(String str, final a aVar) {
        if (!d.a(str)) {
            this.i.setText(str);
        }
        this.h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                d.a(i.this.f29253b);
            }
        });
        this.j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                a aVar = aVar;
                if (aVar != null) {
                    aVar.a(i.this);
                }
            }
        });
        this.k.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                a aVar = aVar;
                if (aVar != null) {
                    aVar.b(i.this);
                }
            }
        });
    }
}
