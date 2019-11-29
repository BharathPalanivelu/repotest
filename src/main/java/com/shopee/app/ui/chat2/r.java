package com.shopee.app.ui.chat2;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.garena.android.appkit.tools.a.b;
import com.shopee.app.util.l;
import com.shopee.id.R;

public class r extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    private static int f20844e = (b.a.f7696g * 30);

    /* renamed from: a  reason: collision with root package name */
    View f20845a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f20846b;

    /* renamed from: c  reason: collision with root package name */
    private a f20847c;

    /* renamed from: d  reason: collision with root package name */
    private PopupWindow f20848d;

    /* renamed from: f  reason: collision with root package name */
    private FrameLayout f20849f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f20850g;
    private int h;

    public interface a {
        void a(int i);

        void t();
    }

    public r(Context context) {
        super(context);
    }

    public r(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public r(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public r(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f20849f = new FrameLayout(getContext());
        this.f20849f.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.background));
    }

    public void setKeyboardCallback(a aVar) {
        this.f20847c = aVar;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f20850g = true;
        int i5 = i4 - i2;
        if (i5 >= l.p) {
            a(i5);
        } else if (i5 <= (-l.p) && i4 != 0) {
            b();
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i) {
        this.f20846b = true;
        f20844e = i;
        if (i()) {
            this.f20850g = false;
            post(new Runnable() {
                public void run() {
                    r.this.setMargin(0);
                    r.this.e();
                }
            });
        }
        a aVar = this.f20847c;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!this.f20850g) {
            this.f20850g = true;
        } else {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.f20846b = false;
        e();
        a aVar = this.f20847c;
        if (aVar != null) {
            aVar.t();
        }
    }

    public void c() {
        if (!i()) {
            this.f20848d = new PopupWindow(this.f20849f, -1, f20844e + this.h, false);
            this.f20848d.showAtLocation((View) getParent(), 80, 0, 0);
        }
        if (!this.f20846b) {
            setMargin(f20844e);
        }
    }

    public void d() {
        if (this.f20846b && i()) {
            this.f20848d.dismiss();
        }
    }

    public void e() {
        if (i()) {
            this.f20848d.dismiss();
        }
        if (!this.f20846b) {
            setMargin(0);
        }
    }

    public void f() {
        if (i()) {
            this.f20848d.dismiss();
        }
        if (this.f20846b) {
            com.shopee.app.c.a.a(getContext());
        } else {
            setMargin(0);
        }
    }

    public boolean g() {
        return this.f20846b;
    }

    public void a(View view, int i) {
        this.h = i;
        this.f20849f.removeAllViews();
        this.f20849f.addView(view, -1, -1);
    }

    public void h() {
        if (!i()) {
            c();
        } else {
            e();
        }
    }

    /* access modifiers changed from: private */
    public void setMargin(int i) {
        this.f20845a.setLayoutParams(new LinearLayout.LayoutParams(-1, i));
        requestLayout();
        a aVar = this.f20847c;
        if (aVar == null) {
            return;
        }
        if (i == 0) {
            aVar.t();
        } else {
            aVar.a(i);
        }
    }

    public boolean i() {
        PopupWindow popupWindow = this.f20848d;
        return popupWindow != null && popupWindow.isShowing();
    }
}
