package com.shopee.app.util.o;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import d.d.b.j;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private ViewTreeObserver f26463a;

    /* renamed from: b  reason: collision with root package name */
    private final ViewTreeObserver.OnGlobalLayoutListener f26464b = new a(this);

    /* renamed from: c  reason: collision with root package name */
    private final Rect f26465c = new Rect();

    /* renamed from: d  reason: collision with root package name */
    private int f26466d;

    /* renamed from: e  reason: collision with root package name */
    private int f26467e = -1;

    /* renamed from: f  reason: collision with root package name */
    private final Context f26468f;

    /* renamed from: g  reason: collision with root package name */
    private final View f26469g;
    private final View h;

    public b(Context context, View view, View view2) {
        j.b(context, "context");
        j.b(view, "rootLayout");
        j.b(view2, "rootChild");
        this.f26468f = context;
        this.f26469g = view;
        this.h = view2;
    }

    static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f26470a;

        a(b bVar) {
            this.f26470a = bVar;
        }

        public final void onGlobalLayout() {
            this.f26470a.d();
        }
    }

    /* access modifiers changed from: private */
    public final void d() {
        this.f26469g.getWindowVisibleDisplayFrame(this.f26465c);
        int height = this.f26465c.height() + d.a().a(this.f26468f);
        int measuredHeight = this.f26469g.getMeasuredHeight();
        if (this.f26467e == -1) {
            this.f26467e = height > measuredHeight ? 1 : 0;
        }
        if (this.f26467e == 1) {
            height = this.f26465c.height();
        }
        if (height != this.f26466d) {
            this.h.getLayoutParams().height = height;
            this.h.layout(this.f26465c.left, this.f26465c.top - d.a().a(this.f26468f), this.f26465c.right, this.f26465c.bottom);
            this.h.requestLayout();
            this.f26466d = height;
        }
    }

    public final void a() {
        ViewTreeObserver viewTreeObserver = this.f26463a;
        if (viewTreeObserver == null || viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            this.f26463a = this.f26469g.getViewTreeObserver();
        }
        ViewTreeObserver viewTreeObserver2 = this.f26463a;
        if (viewTreeObserver2 != null) {
            viewTreeObserver2.addOnGlobalLayoutListener(this.f26464b);
        }
    }

    public final void b() {
        ViewTreeObserver viewTreeObserver = this.f26463a;
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            ViewTreeObserver viewTreeObserver2 = this.f26463a;
            if (viewTreeObserver2 != null) {
                viewTreeObserver2.removeOnGlobalLayoutListener(this.f26464b);
            }
        }
    }

    public final void c() {
        this.f26463a = null;
    }
}
