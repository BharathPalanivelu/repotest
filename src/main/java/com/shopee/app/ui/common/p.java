package com.shopee.app.ui.common;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import com.beetalk.sdk.f.d;
import com.shopee.id.R;
import com.squareup.a.w;

public class p implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    private final ListView f21302a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a f21303b;

    /* renamed from: c  reason: collision with root package name */
    private View f21304c;

    /* renamed from: d  reason: collision with root package name */
    private View f21305d;

    /* renamed from: e  reason: collision with root package name */
    private int f21306e;

    /* renamed from: f  reason: collision with root package name */
    private AbsListView.OnScrollListener f21307f;

    public interface a {
        void c(int i);
    }

    public p(ListView listView) {
        this.f21302a = listView;
        this.f21302a.setFooterDividersEnabled(false);
        this.f21302a.addFooterView(a(), (Object) null, false);
        this.f21302a.setOnScrollListener(this);
        b();
    }

    public void a(a aVar) {
        this.f21303b = aVar;
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.f21307f = onScrollListener;
    }

    public View a() {
        this.f21304c = View.inflate(this.f21302a.getContext(), R.layout.chat_load_more_layout, (ViewGroup) null);
        this.f21305d = this.f21304c.findViewById(R.id.loading);
        return this.f21304c;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        Context context = this.f21302a.getContext();
        w a2 = w.a(context);
        if (i == 0 || i == 1) {
            a2.b((Object) context);
        } else {
            a2.a((Object) context);
        }
        AbsListView.OnScrollListener onScrollListener = this.f21307f;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, final int i3) {
        int i4 = i + i2;
        if (!(i4 != i3 || i == 0 || this.f21306e == i4)) {
            this.f21306e = i4;
            this.f21304c.setVisibility(0);
            this.f21305d.setVisibility(0);
            d.a().a(new Runnable() {
                public void run() {
                    if (p.this.f21303b != null) {
                        p.this.f21303b.c(i3);
                    }
                }
            }, 200);
        }
        AbsListView.OnScrollListener onScrollListener = this.f21307f;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i, i2, i3);
        }
    }

    public void b() {
        this.f21304c.setVisibility(8);
    }

    public void c() {
        this.f21305d.setVisibility(4);
    }

    public void d() {
        this.f21306e = 0;
        this.f21302a.setSelection(0);
    }
}
