package com.shopee.feeds.feedlibrary.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.a.a;
import butterknife.a.b;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.view.SearchLoadingView;
import com.shopee.feeds.feedlibrary.view.edittext.CustomSearchEditText;

public class BaseSearchActivity_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private BaseSearchActivity f27367b;

    /* renamed from: c  reason: collision with root package name */
    private View f27368c;

    /* renamed from: d  reason: collision with root package name */
    private View f27369d;

    public BaseSearchActivity_ViewBinding(final BaseSearchActivity baseSearchActivity, View view) {
        this.f27367b = baseSearchActivity;
        baseSearchActivity.searchEtBg = b.a(view, c.e.search_et_bg, "field 'searchEtBg'");
        baseSearchActivity.etSearch = (CustomSearchEditText) b.a(view, c.e.et_search, "field 'etSearch'", CustomSearchEditText.class);
        View a2 = b.a(view, c.e.iv_search_cancel, "field 'ivSearchCancel' and method 'onClick'");
        baseSearchActivity.ivSearchCancel = (ImageView) b.b(a2, c.e.iv_search_cancel, "field 'ivSearchCancel'", ImageView.class);
        this.f27368c = a2;
        a2.setOnClickListener(new a() {
            public void a(View view) {
                baseSearchActivity.onClick(view);
            }
        });
        View a3 = b.a(view, c.e.tv_cancel, "field 'tvCancel' and method 'onClick'");
        baseSearchActivity.tvCancel = (TextView) b.b(a3, c.e.tv_cancel, "field 'tvCancel'", TextView.class);
        this.f27369d = a3;
        a3.setOnClickListener(new a() {
            public void a(View view) {
                baseSearchActivity.onClick(view);
            }
        });
        baseSearchActivity.recyclerView = (RecyclerView) b.a(view, c.e.recycler_view, "field 'recyclerView'", RecyclerView.class);
        baseSearchActivity.mSearchLoadingView = (SearchLoadingView) b.a(view, c.e.search_loading_view, "field 'mSearchLoadingView'", SearchLoadingView.class);
        baseSearchActivity.tvNoResult = (TextView) b.a(view, c.e.tv_no_result, "field 'tvNoResult'", TextView.class);
    }
}
