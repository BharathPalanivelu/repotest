package com.garena.pay.android.f;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import com.garena.pay.android.c.f;

public class b {

    /* renamed from: a  reason: collision with root package name */
    protected PopupWindow f8261a;

    /* renamed from: b  reason: collision with root package name */
    private PopupWindow.OnDismissListener f8262b = new PopupWindow.OnDismissListener() {
        public void onDismiss() {
            b.this.f8261a.setBackgroundDrawable((Drawable) null);
            b bVar = b.this;
            bVar.f8261a = null;
            bVar.c();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private a f8263c;

    public interface a {
        void a();
    }

    public b(View view, boolean z, boolean z2) {
        this.f8261a = new PopupWindow(view, -1, -1, true);
        this.f8261a.setBackgroundDrawable(new ColorDrawable(0));
        this.f8261a.setInputMethodMode(1);
        this.f8261a.setFocusable(true);
        this.f8261a.update();
        if (z2) {
            this.f8261a.setTouchInterceptor(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 0) {
                        return true;
                    }
                    b.this.a();
                    return true;
                }
            });
        }
        this.f8261a.setOnDismissListener(this.f8262b);
    }

    /* access modifiers changed from: private */
    public void c() {
        a aVar = this.f8263c;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void a(View view) {
        if (view != null && f.a(view.getContext())) {
            this.f8261a.showAtLocation(view, 17, 0, 0);
        }
    }

    public void a() {
        PopupWindow popupWindow = this.f8261a;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public void b() {
        PopupWindow popupWindow = this.f8261a;
        if (popupWindow != null) {
            popupWindow.setOnDismissListener((PopupWindow.OnDismissListener) null);
            this.f8261a.dismiss();
        }
    }

    public void a(a aVar) {
        this.f8263c = aVar;
    }
}
