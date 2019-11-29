package com.shopee.feeds.feedlibrary.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.a.a;
import butterknife.a.b;
import com.google.android.material.tabs.TabLayout;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.view.easyviewpager.CustomScrollViewPager;

public class SelectProductActivity_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private SelectProductActivity f27430b;

    /* renamed from: c  reason: collision with root package name */
    private View f27431c;

    /* renamed from: d  reason: collision with root package name */
    private View f27432d;

    public SelectProductActivity_ViewBinding(final SelectProductActivity selectProductActivity, View view) {
        this.f27430b = selectProductActivity;
        View a2 = b.a(view, c.e.iv_left, "field 'ivLeft' and method 'onClick'");
        selectProductActivity.ivLeft = (ImageView) b.b(a2, c.e.iv_left, "field 'ivLeft'", ImageView.class);
        this.f27431c = a2;
        a2.setOnClickListener(new a() {
            public void a(View view) {
                selectProductActivity.onClick(view);
            }
        });
        selectProductActivity.btnTopBack = (TextView) b.a(view, c.e.btn_top_back, "field 'btnTopBack'", TextView.class);
        View a3 = b.a(view, c.e.iv_right, "field 'ivRight' and method 'onClick'");
        selectProductActivity.ivRight = (ImageView) b.b(a3, c.e.iv_right, "field 'ivRight'", ImageView.class);
        this.f27432d = a3;
        a3.setOnClickListener(new a() {
            public void a(View view) {
                selectProductActivity.onClick(view);
            }
        });
        selectProductActivity.tvRight = (TextView) b.a(view, c.e.tv_right, "field 'tvRight'", TextView.class);
        selectProductActivity.llTitleLayout = (RelativeLayout) b.a(view, c.e.ll_title_layout, "field 'llTitleLayout'", RelativeLayout.class);
        selectProductActivity.tabLayout = (TabLayout) b.a(view, c.e.tab_layout, "field 'tabLayout'", TabLayout.class);
        selectProductActivity.viewPager = (CustomScrollViewPager) b.a(view, c.e.viewPager, "field 'viewPager'", CustomScrollViewPager.class);
    }
}
