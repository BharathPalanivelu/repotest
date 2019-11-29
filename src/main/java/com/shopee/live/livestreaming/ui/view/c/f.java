package com.shopee.live.livestreaming.ui.view.c;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.util.d;

public class f extends b {

    /* renamed from: g  reason: collision with root package name */
    Handler f29279g;
    private View h;
    private View i;
    private TextView j;
    private ImageView k;
    /* access modifiers changed from: private */
    public int l = 5;

    static /* synthetic */ int a(f fVar) {
        int i2 = fVar.l;
        fVar.l = i2 - 1;
        return i2;
    }

    public f(Activity activity) {
        super(activity);
    }

    public void c() {
        super.c();
    }

    /* access modifiers changed from: protected */
    public View d() {
        this.h = LayoutInflater.from(this.f29253b).inflate(c.f.live_streaming_layout_popup_weak_net, (ViewGroup) null);
        this.j = (TextView) this.h.findViewById(c.e.tv_popup_symbol);
        this.k = (ImageView) this.h.findViewById(c.e.iv_popup_symbol);
        this.f29279g = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 10) {
                    f.a(f.this);
                    f.this.k();
                    if (f.this.l > 0) {
                        sendEmptyMessageDelayed(10, 1000);
                    }
                }
            }
        };
        return this.h;
    }

    /* access modifiers changed from: protected */
    public View e() {
        this.i = this.h.findViewById(c.e.popup_window_view);
        return this.i;
    }

    /* access modifiers changed from: protected */
    public View f() {
        return this.h.findViewById(c.e.shadow_view);
    }

    /* access modifiers changed from: protected */
    public void g() {
        this.f29279g.sendEmptyMessageDelayed(10, 1000);
    }

    /* access modifiers changed from: private */
    public void k() {
        if (this.l <= 0) {
            c();
        }
    }

    public void a(String str) {
        this.l = 5;
        this.k.setImageResource(c.d.live_streaming_out_rule);
        if (!d.a(str)) {
            this.j.setText(str);
        }
        k();
    }
}
