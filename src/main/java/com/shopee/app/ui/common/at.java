package com.shopee.app.ui.common;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.shopee.id.R;

public class at implements AbsListView.OnScrollListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ListView f21185a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final BaseAdapter f21186b;

    /* renamed from: c  reason: collision with root package name */
    private View f21187c;

    /* renamed from: d  reason: collision with root package name */
    private a f21188d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f21189e = true;

    /* renamed from: f  reason: collision with root package name */
    private boolean f21190f = false;

    public interface a {
        void b(int i);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public at(ListView listView, BaseAdapter baseAdapter) {
        this.f21185a = listView;
        this.f21186b = baseAdapter;
        a(listView.getContext());
    }

    private void a(Context context) {
        this.f21187c = View.inflate(context, R.layout.chat_load_more_layout, (ViewGroup) null);
        this.f21185a.addHeaderView(this.f21187c);
        this.f21185a.setHeaderDividersEnabled(false);
        this.f21185a.setOnScrollListener(this);
        this.f21187c = this.f21187c.findViewById(R.id.loading);
    }

    public void a(boolean z) {
        this.f21189e = z;
    }

    public void a(a aVar) {
        this.f21188d = aVar;
    }

    public void a() {
        this.f21186b.notifyDataSetChanged();
        if (this.f21189e) {
            b();
        }
    }

    public void b() {
        this.f21185a.post(new Runnable() {
            public void run() {
                at.this.f21185a.smoothScrollToPosition(at.this.f21186b.getCount());
            }
        });
        this.f21185a.postDelayed(new Runnable() {
            public void run() {
                at.this.f21185a.setSelection(at.this.f21186b.getCount());
            }
        }, 600);
    }

    public void c() {
        this.f21185a.post(new Runnable() {
            public void run() {
                at.this.f21185a.setSelection(at.this.f21186b.getCount());
            }
        });
        this.f21185a.postDelayed(new Runnable() {
            public void run() {
                at.this.f21185a.setSelection(at.this.f21186b.getCount());
            }
        }, 400);
    }

    public void a(int i) {
        int i2;
        int firstVisiblePosition = this.f21185a.getFirstVisiblePosition() + i;
        int headerViewsCount = this.f21185a.getHeaderViewsCount();
        View childAt = this.f21185a.getChildAt(headerViewsCount);
        if (childAt == null) {
            i2 = 0;
        } else {
            i2 = childAt.getTop();
        }
        a();
        this.f21185a.setSelectionFromTop(firstVisiblePosition + headerViewsCount, i2);
        this.f21187c.setVisibility(8);
        this.f21190f = false;
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && this.f21185a.getFirstVisiblePosition() <= 5 && !this.f21190f && this.f21188d != null) {
            this.f21187c.setVisibility(0);
            this.f21188d.b(0);
        }
    }
}
