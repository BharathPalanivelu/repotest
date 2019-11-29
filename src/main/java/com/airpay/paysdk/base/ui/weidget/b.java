package com.airpay.paysdk.base.ui.weidget;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.airpay.paysdk.c;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public PopupWindow f3911a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f3912b;

    public b(View view) {
        this(view, false);
    }

    public b(View view, boolean z) {
        this(view, z, -1, -1);
    }

    private b(View view, boolean z, int i, int i2) {
        this.f3912b = c.j.com_garena_beepay_popup_anim;
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        this.f3911a = new PopupWindow(view, i, i2, true);
        this.f3911a.setBackgroundDrawable(new ColorDrawable(view.getResources().getColor(c.b.com_garena_beepay_bg_color_transparent)));
        this.f3911a.setFocusable(true);
        this.f3911a.update();
        if (z) {
            this.f3911a.setTouchInterceptor(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 0) {
                        return true;
                    }
                    b.this.a();
                    return true;
                }
            });
        }
        this.f3911a.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                b.this.f3911a.setBackgroundDrawable((Drawable) null);
                b.this.f3911a = null;
            }
        });
    }

    public void a(View view) {
        a(view, true);
    }

    public void a(final View view, final boolean z) {
        if (view != null) {
            view.post(new Runnable() {
                public void run() {
                    if (view.getWindowToken() != null) {
                        if (z) {
                            b.this.f3911a.setAnimationStyle(b.this.f3912b);
                        }
                        b.this.f3911a.showAtLocation(view, 17, 0, 0);
                        d.a(view);
                    }
                }
            });
        }
    }

    public void a() {
        PopupWindow popupWindow = this.f3911a;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public void b() {
        this.f3911a.setBackgroundDrawable((Drawable) null);
    }
}
