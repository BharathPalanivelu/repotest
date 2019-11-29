package com.shopee.feeds.feedlibrary.view.widget;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.tencent.rtmp.TXLivePushConfig;

public class a {

    /* renamed from: b  reason: collision with root package name */
    private static final String f28714b = (a.class.getSimpleName() + "%s");

    /* renamed from: a  reason: collision with root package name */
    Runnable f28715a = new Runnable() {
        public void run() {
            a aVar = a.this;
            int unused = aVar.f28719f = aVar.f28719f + 5;
            a aVar2 = a.this;
            aVar2.a(aVar2.f28719f);
            if (a.this.h <= 5) {
                int unused2 = a.this.i = TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE;
            } else if (a.this.h > 5) {
                int unused3 = a.this.i = 6000;
            } else if (a.this.h > 8) {
                int unused4 = a.this.i = 12000;
            } else {
                int unused5 = a.this.i = 15000;
            }
            a.this.a();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private Activity f28716c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f28717d = false;

    /* renamed from: e  reason: collision with root package name */
    private CircleProgressView f28718e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f28719f = 5;

    /* renamed from: g  reason: collision with root package name */
    private boolean f28720g = true;
    /* access modifiers changed from: private */
    public long h = 0;
    /* access modifiers changed from: private */
    public int i = TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE;
    private Handler j = new Handler(Looper.myLooper());

    public a(Activity activity) {
        this.f28716c = activity;
    }

    /* access modifiers changed from: private */
    public void a() {
        if (!this.f28717d) {
            if (this.f28719f >= 90) {
                a(96);
                return;
            }
            this.h++;
            this.j.postDelayed(this.f28715a, (long) this.i);
        }
    }

    public void a(int i2) {
        CircleProgressView circleProgressView = this.f28718e;
        if (circleProgressView != null && !this.f28717d && i2 >= this.f28719f) {
            this.f28719f = i2;
            circleProgressView.setProgressNotInUiThread(i2);
        }
    }
}
