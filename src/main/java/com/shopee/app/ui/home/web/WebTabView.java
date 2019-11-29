package com.shopee.app.ui.home.web;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.shopee.a.b.b;
import com.shopee.app.a;
import com.shopee.app.data.viewmodel.WebPageModel;
import com.shopee.app.tracking.b.e;
import com.shopee.app.ui.webview.WebPageView_;
import com.shopee.app.ui.webview.f;
import com.shopee.id.R;
import d.d.b.j;
import java.util.HashMap;

public final class WebTabView extends com.shopee.app.ui.a.a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final int f22715a = 30;

    /* renamed from: b  reason: collision with root package name */
    private int f22716b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f22717c;

    /* renamed from: d  reason: collision with root package name */
    private e f22718d;

    /* renamed from: e  reason: collision with root package name */
    private final String f22719e;

    /* renamed from: f  reason: collision with root package name */
    private final int f22720f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f22721g;

    public View a(int i) {
        if (this.f22721g == null) {
            this.f22721g = new HashMap();
        }
        View view = (View) this.f22721g.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f22721g.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebTabView(Context context, String str, int i) {
        super(context);
        j.b(context, "context");
        j.b(str, "url");
        this.f22719e = str;
        this.f22720f = i;
        e();
    }

    public void a() {
        super.a();
        f();
        if (this.f22717c) {
            WebPageView_ webPageView_ = (WebPageView_) a(a.C0250a.webPageView);
            if (webPageView_ != null) {
                f presenter = webPageView_.getPresenter();
                if (presenter != null) {
                    presenter.c();
                }
            }
        }
    }

    public void b() {
        super.b();
        if (this.f22717c) {
            WebPageView_ webPageView_ = (WebPageView_) a(a.C0250a.webPageView);
            if (webPageView_ != null) {
                f presenter = webPageView_.getPresenter();
                if (presenter != null) {
                    presenter.d();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void e() {
        if (!this.f22717c) {
            if (this.f22716b >= this.f22715a) {
                f();
            } else {
                postDelayed(new a(this), 1000);
            }
            this.f22716b++;
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WebTabView f22722a;

        a(WebTabView webTabView) {
            this.f22722a = webTabView;
        }

        public final void run() {
            this.f22722a.e();
        }
    }

    private final void f() {
        if (!this.f22717c) {
            this.f22717c = true;
            try {
                View.inflate(getContext(), R.layout.sp_web_tab_view, this);
                ((WebPageView_) a(a.C0250a.webPageView)).setTag(R.id.home_web_tag, Integer.valueOf(this.f22720f));
                ((WebPageView_) a(a.C0250a.webPageView)).b(new WebPageModel(this.f22719e));
            } catch (Exception unused) {
                com.shopee.app.ui.home.c.a a2 = com.shopee.app.ui.home.c.b.a(getContext());
                a2.setTag(R.id.home_web_tag, Integer.valueOf(this.f22720f));
                addView(a2, new ViewGroup.LayoutParams(-1, -1));
            }
            this.f22718d = new e(this.f22719e);
        }
    }

    /* renamed from: d */
    public e r() {
        return this.f22718d;
    }
}
