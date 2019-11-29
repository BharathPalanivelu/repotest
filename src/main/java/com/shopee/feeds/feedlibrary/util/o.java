package com.shopee.feeds.feedlibrary.util;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.devspark.robototextview.widget.RobotoTextView;
import com.shopee.feeds.feedlibrary.b;
import com.shopee.feeds.feedlibrary.c;

public class o {

    /* renamed from: a  reason: collision with root package name */
    com.shopee.sdk.ui.a f28354a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f28355b;

    /* renamed from: c  reason: collision with root package name */
    private a f28356c = new a();

    /* renamed from: d  reason: collision with root package name */
    private int f28357d;

    /* renamed from: e  reason: collision with root package name */
    private RobotoTextView f28358e;

    static /* synthetic */ int a(o oVar) {
        int i = oVar.f28357d;
        oVar.f28357d = i + 1;
        return i;
    }

    class a extends Handler {
        a() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 123) {
                o.a(o.this);
                sendEmptyMessageDelayed(123, 1000);
                o.this.e();
            }
        }
    }

    public o(Activity activity, RobotoTextView robotoTextView) {
        this.f28355b = activity;
        this.f28354a = new com.shopee.sdk.ui.a(activity);
        this.f28358e = robotoTextView;
    }

    public void a(boolean z) {
        com.shopee.sdk.ui.a aVar = this.f28354a;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    public void a() {
        if (this.f28354a != null) {
            this.f28358e.setTextColor(b.b().f27287b.getResources().getColor(c.b.grey_400));
            this.f28358e.setEnabled(false);
            this.f28354a.a();
            this.f28357d = 0;
            c();
        }
    }

    public void b() {
        if (this.f28354a != null) {
            this.f28358e.setTextColor(b.b().f27287b.getResources().getColor(c.b.main_color));
            this.f28358e.setEnabled(true);
            this.f28354a.b();
            d();
        }
    }

    public void c() {
        this.f28356c.sendEmptyMessageDelayed(123, 1000);
    }

    /* access modifiers changed from: private */
    public void e() {
        if (this.f28357d >= 15) {
            b();
            u.a(this.f28355b, "Server error, please try again.");
            d();
        }
    }

    public void d() {
        a aVar = this.f28356c;
        if (aVar != null) {
            aVar.removeCallbacksAndMessages((Object) null);
        }
    }
}
