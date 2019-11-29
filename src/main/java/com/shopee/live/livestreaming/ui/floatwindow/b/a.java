package com.shopee.live.livestreaming.ui.floatwindow.b;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.garena.android.appkit.tools.b;
import com.shopee.live.livestreaming.c;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private b f29059a;

    /* renamed from: b  reason: collision with root package name */
    private WindowManager f29060b;

    /* renamed from: c  reason: collision with root package name */
    private WindowManager.LayoutParams f29061c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f29062d;

    /* renamed from: e  reason: collision with root package name */
    private int f29063e;

    /* renamed from: f  reason: collision with root package name */
    private int f29064f;

    public void a(Context context) {
        this.f29061c = new WindowManager.LayoutParams();
        this.f29060b = b(context);
        this.f29059a = new b(context);
        if (Build.VERSION.SDK_INT >= 26) {
            this.f29061c.type = 2038;
        } else if (Build.VERSION.SDK_INT >= 24) {
            this.f29061c.type = 2002;
        } else {
            if (context.getPackageManager().checkPermission("android.permission.SYSTEM_ALERT_WINDOW", context.getPackageName()) == 0) {
                this.f29061c.type = 2002;
            } else {
                this.f29061c.type = 2005;
            }
        }
        WindowManager.LayoutParams layoutParams = this.f29061c;
        layoutParams.format = 1;
        layoutParams.flags = 8;
        layoutParams.gravity = 8388659;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f29060b.getDefaultDisplay().getMetrics(displayMetrics);
        this.f29063e = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        this.f29064f = Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels);
        WindowManager.LayoutParams layoutParams2 = this.f29061c;
        layoutParams2.x = this.f29063e;
        layoutParams2.y = (this.f29064f - b.d(c.C0439c.live_streaming_float_window_height)) - b.d(c.C0439c.live_streaming_float_window_margin_bottom);
        WindowManager.LayoutParams layoutParams3 = this.f29061c;
        layoutParams3.width = -2;
        layoutParams3.height = -2;
        this.f29059a.setParams(layoutParams3);
    }

    public void a(boolean z, float f2) {
        if (z) {
            WindowManager.LayoutParams layoutParams = this.f29061c;
            layoutParams.x = this.f29063e;
            layoutParams.y = (this.f29064f - b.d(c.C0439c.live_streaming_float_window_width)) - b.d(c.C0439c.live_streaming_float_window_margin_bottom);
        } else {
            WindowManager.LayoutParams layoutParams2 = this.f29061c;
            layoutParams2.x = this.f29063e;
            layoutParams2.y = (this.f29064f - b.d(c.C0439c.live_streaming_float_window_height)) - b.d(c.C0439c.live_streaming_float_window_margin_bottom);
        }
        this.f29059a.a(z, f2);
    }

    public void a(String str) {
        this.f29059a.setBackground(str);
    }

    private WindowManager b(Context context) {
        if (this.f29060b == null) {
            this.f29060b = (WindowManager) context.getSystemService("window");
        }
        return this.f29060b;
    }

    public void a() {
        if (!this.f29062d) {
            this.f29060b.addView(this.f29059a, this.f29061c);
            this.f29059a.getVideoLayout().a();
            this.f29062d = true;
        }
    }

    public void b() {
        boolean isAttachedToWindow = Build.VERSION.SDK_INT >= 19 ? this.f29059a.isAttachedToWindow() : true;
        if (this.f29062d && isAttachedToWindow) {
            WindowManager windowManager = this.f29060b;
            if (windowManager != null) {
                windowManager.removeView(this.f29059a);
            }
        }
        this.f29062d = false;
    }

    public void a(com.shopee.live.livestreaming.ui.floatwindow.service.b bVar) {
        this.f29059a.setFloatWindow(bVar);
    }
}
