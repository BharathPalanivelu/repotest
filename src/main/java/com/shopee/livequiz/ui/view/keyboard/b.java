package com.shopee.livequiz.ui.view.keyboard;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import com.shopee.livequiz.c;
import com.shopee.livequiz.g.m;

public class b extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    private a f30055a;

    /* renamed from: b  reason: collision with root package name */
    private View f30056b;

    /* renamed from: c  reason: collision with root package name */
    private View f30057c;

    /* renamed from: d  reason: collision with root package name */
    private Activity f30058d;

    /* renamed from: e  reason: collision with root package name */
    private int f30059e = m.d();

    @SuppressLint({"InflateParams"})
    b(Activity activity) {
        super(activity);
        this.f30058d = activity;
        this.f30056b = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(c.f.livesdk_shopee_layout_keyboard_height_provider_pop, (ViewGroup) null, false);
        setContentView(this.f30056b);
        this.f30056b.setFitsSystemWindows(false);
        setSoftInputMode(21);
        setInputMethodMode(1);
        this.f30057c = activity.findViewById(16908290);
        setWidth(0);
        setHeight(-1);
        this.f30056b.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                b.this.e();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e() {
        if (this.f30056b != null) {
            d();
        }
    }

    public void a() {
        if (!isShowing() && this.f30057c.getWindowToken() != null) {
            setBackgroundDrawable(new ColorDrawable(0));
            showAtLocation(this.f30057c, 0, 0, 0);
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f30055a = null;
        dismiss();
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        this.f30055a = aVar;
    }

    private int c() {
        return this.f30058d.getResources().getConfiguration().orientation;
    }

    private void d() {
        this.f30058d.getWindowManager().getDefaultDisplay().getSize(new Point());
        Rect rect = new Rect();
        this.f30056b.getWindowVisibleDisplayFrame(rect);
        int c2 = c();
        if (((float) Math.abs(rect.bottom - m.d())) <= ((float) m.e()) * 1.5f) {
            this.f30059e = rect.bottom;
            a(false, 0);
            return;
        }
        a(true, this.f30059e - rect.bottom);
    }

    private void a(boolean z, int i) {
        a aVar = this.f30055a;
        if (aVar != null) {
            aVar.onKeyboardHeightChanged(z, i);
        }
    }
}
