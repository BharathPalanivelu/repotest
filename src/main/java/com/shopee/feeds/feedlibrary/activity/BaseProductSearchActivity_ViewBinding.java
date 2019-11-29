package com.shopee.feeds.feedlibrary.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.a.a;
import butterknife.a.b;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.view.SearchLoadMoreRecycyleView;
import com.shopee.feeds.feedlibrary.view.SearchLoadingView;
import com.shopee.feeds.feedlibrary.view.edittext.CustomSearchEditText;

public class BaseProductSearchActivity_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private BaseProductSearchActivity f27338b;

    /* renamed from: c  reason: collision with root package name */
    private View f27339c;

    /* renamed from: d  reason: collision with root package name */
    private View f27340d;

    /* renamed from: e  reason: collision with root package name */
    private View f27341e;

    /* renamed from: f  reason: collision with root package name */
    private View f27342f;

    /* renamed from: g  reason: collision with root package name */
    private View f27343g;
    private View h;
    private View i;
    private View j;
    private View k;
    private View l;

    public BaseProductSearchActivity_ViewBinding(final BaseProductSearchActivity baseProductSearchActivity, View view) {
        this.f27338b = baseProductSearchActivity;
        baseProductSearchActivity.searchEtBg = b.a(view, c.e.search_et_bg, "field 'searchEtBg'");
        baseProductSearchActivity.etSearch = (CustomSearchEditText) b.a(view, c.e.et_search, "field 'etSearch'", CustomSearchEditText.class);
        View a2 = b.a(view, c.e.iv_search_cancel, "field 'ivSearchCancel' and method 'onClick'");
        baseProductSearchActivity.ivSearchCancel = (ImageView) b.b(a2, c.e.iv_search_cancel, "field 'ivSearchCancel'", ImageView.class);
        this.f27339c = a2;
        a2.setOnClickListener(new a() {
            public void a(View view) {
                baseProductSearchActivity.onClick(view);
            }
        });
        View a3 = b.a(view, c.e.tv_cancel, "field 'tvCancel' and method 'onClick'");
        baseProductSearchActivity.tvCancel = (TextView) b.b(a3, c.e.tv_cancel, "field 'tvCancel'", TextView.class);
        this.f27340d = a3;
        a3.setOnClickListener(new a() {
            public void a(View view) {
                baseProductSearchActivity.onClick(view);
            }
        });
        baseProductSearchActivity.recyclerView = (SearchLoadMoreRecycyleView) b.a(view, c.e.recycler_view, "field 'recyclerView'", SearchLoadMoreRecycyleView.class);
        baseProductSearchActivity.mSearchLoadingView = (SearchLoadingView) b.a(view, c.e.search_loading_view, "field 'mSearchLoadingView'", SearchLoadingView.class);
        baseProductSearchActivity.tvNoResult = (TextView) b.a(view, c.e.tv_no_result, "field 'tvNoResult'", TextView.class);
        View a4 = b.a(view, c.e.rel_click, "method 'onClick'");
        this.f27341e = a4;
        a4.setOnClickListener(new a() {
            public void a(View view) {
                baseProductSearchActivity.onClick(view);
            }
        });
        View a5 = b.a(view, c.e.latest_tv, "method 'onClick'");
        this.f27342f = a5;
        a5.setOnClickListener(new a() {
            public void a(View view) {
                baseProductSearchActivity.onClick(view);
            }
        });
        View a6 = b.a(view, c.e.sales_tv, "method 'onClick'");
        this.f27343g = a6;
        a6.setOnClickListener(new a() {
            public void a(View view) {
                baseProductSearchActivity.onClick(view);
            }
        });
        View a7 = b.a(view, c.e.price_click, "method 'onClick'");
        this.h = a7;
        a7.setOnClickListener(new a() {
            public void a(View view) {
                baseProductSearchActivity.onClick(view);
            }
        });
        View a8 = b.a(view, c.e.sub_first_layout, "method 'onClick'");
        this.i = a8;
        a8.setOnClickListener(new a() {
            public void a(View view) {
                baseProductSearchActivity.onClick(view);
            }
        });
        View a9 = b.a(view, c.e.sub_second_layout, "method 'onClick'");
        this.j = a9;
        a9.setOnClickListener(new a() {
            public void a(View view) {
                baseProductSearchActivity.onClick(view);
            }
        });
        View a10 = b.a(view, c.e.shadow_view, "method 'onClick'");
        this.k = a10;
        a10.setOnClickListener(new a() {
            public void a(View view) {
                baseProductSearchActivity.onClick(view);
            }
        });
        View a11 = b.a(view, c.e.try_again, "method 'onClick'");
        this.l = a11;
        a11.setOnClickListener(new a() {
            public void a(View view) {
                baseProductSearchActivity.onClick(view);
            }
        });
    }
}
