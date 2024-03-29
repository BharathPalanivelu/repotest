package com.shopee.live.livestreaming.ui.floatwindow.b;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;
import com.garena.android.appkit.tools.b;
import com.shopee.live.livestreaming.c;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private com.shopee.live.livestreaming.ui.floatwindow.b.b f29059a;

    /* renamed from: b  reason: collision with root package name */
    private WindowManager windowManager;

    /* renamed from: c  reason: collision with root package name */
    private WindowManager.LayoutParams layoutParams;

    /* renamed from: d  reason: collision with root package name */
    private boolean f29062d;

    /* renamed from: e  reason: collision with root package name */
    private int f29063e;

    /* renamed from: f  reason: collision with root package name */
    private int f29064f;

    public void a(Context context) {
        this.layoutParams = new WindowManager.LayoutParams();
        this.windowManager = b(context); // ambil window manager
        this.f29059a = new com.shopee.live.livestreaming.ui.floatwindow.b.b(context);// ini custome viewnya
        if (Build.VERSION.SDK_INT >= 26) {
            this.layoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;//2038
        } else if (Build.VERSION.SDK_INT >= 24) {
            this.layoutParams.type = WindowManager.LayoutParams.TYPE_PHONE;//2002
        } else {
            if (context.getPackageManager().checkPermission("android.permission.SYSTEM_ALERT_WINDOW", context.getPackageName()) == 0) {
                this.layoutParams.type = WindowManager.LayoutParams.TYPE_PHONE;// 2002
            } else {
                this.layoutParams.type = WindowManager.LayoutParams.TYPE_TOAST;//2005
            }
        }
        WindowManager.LayoutParams layoutParams = this.layoutParams;
        layoutParams.format = WindowManager.LayoutParams.FLAG_ALLOW_LOCK_WHILE_SCREEN_ON; //1;
        layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE; // 8;
        layoutParams.gravity = Gravity.TOP | Gravity.START; // 8388659;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        this.f29063e = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        this.f29064f = Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels);
        WindowManager.LayoutParams layoutParams2 = this.layoutParams;
        layoutParams2.x = this.f29063e;
        layoutParams2.y = (this.f29064f - b.d(c.C0439c.live_streaming_float_window_height)) - b.d(c.C0439c.live_streaming_float_window_margin_bottom);
        WindowManager.LayoutParams layoutParams3 = this.layoutParams;
        layoutParams3.width = -2;
        layoutParams3.height = -2;
        this.f29059a.setParams(layoutParams3);
    }

    public void a(boolean z, float f2) {
        if (z) {
            WindowManager.LayoutParams layoutParams = this.layoutParams;
            layoutParams.x = this.f29063e;
            layoutParams.y = (this.f29064f - b.d(c.C0439c.live_streaming_float_window_width)) - b.d(c.C0439c.live_streaming_float_window_margin_bottom);
        } else {
            WindowManager.LayoutParams layoutParams2 = this.layoutParams;
            layoutParams2.x = this.f29063e;
            layoutParams2.y = (this.f29064f - b.d(c.C0439c.live_streaming_float_window_height)) - b.d(c.C0439c.live_streaming_float_window_margin_bottom);
        }
        this.f29059a.a(z, f2);
    }

    public void a(String str) {
        this.f29059a.setBackground(str);
    }

    private WindowManager b(Context context) {
        if (this.windowManager == null) {
            this.windowManager = (WindowManager) context.getSystemService("window");
        }
        return this.windowManager;
    }

    public void a() {
        if (!this.f29062d) {
            this.windowManager.addView(this.f29059a, this.layoutParams);
            this.f29059a.getVideoLayout().a();
            this.f29062d = true;
        }
    }

    public void b() {
        boolean isAttachedToWindow = Build.VERSION.SDK_INT >= 19 ? this.f29059a.isAttachedToWindow() : true;
        if (this.f29062d && isAttachedToWindow) {
            WindowManager windowManager = this.windowManager;
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
