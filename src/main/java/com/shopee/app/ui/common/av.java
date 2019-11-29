package com.shopee.app.ui.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.garena.android.uikit.a.a.a;
import com.shopee.app.data.viewmodel.WebPageModel;
import com.shopee.app.ui.webview.g;

public class av extends a {

    /* renamed from: a  reason: collision with root package name */
    g f21195a;

    /* renamed from: b  reason: collision with root package name */
    ay f21196b;

    /* renamed from: c  reason: collision with root package name */
    private final int f21197c;

    /* renamed from: d  reason: collision with root package name */
    private String f21198d;

    /* renamed from: e  reason: collision with root package name */
    private View.OnTouchListener f21199e;

    public av(Context context, int i, String str, ay ayVar) {
        super(context);
        this.f21197c = i;
        this.f21198d = str;
        this.f21196b = ayVar;
    }

    public int getWebviewId() {
        return this.f21195a.hashCode();
    }

    public g getWebPageView() {
        return this.f21195a;
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    public void d() {
        this.f21195a.a(new WebPageModel(this.f21198d));
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener = this.f21199e;
        if (onTouchListener != null) {
            onTouchListener.onTouch(this, motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setOnInterceptTouchListener(View.OnTouchListener onTouchListener) {
        this.f21199e = onTouchListener;
    }

    public void a() {
        this.f21195a.l();
        this.f21195a.getPresenter().c();
        this.f21195a.c(this.f21197c);
    }

    public void b() {
        this.f21195a.getPresenter().d();
        this.f21195a.d(this.f21197c);
    }

    public void c() {
        this.f21195a.getPresenter().h();
        this.f21196b.a(this);
    }
}
