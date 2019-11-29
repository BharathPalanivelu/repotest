package com.shopee.feeds.feedlibrary.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.a.a;
import butterknife.a.b;
import com.devspark.robototextview.widget.RobotoTextView;
import com.google.android.material.tabs.TabLayout;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.view.StickyNavLayout;
import com.shopee.feeds.feedlibrary.view.easyviewpager.CustomScrollViewPager;
import com.shopee.feeds.feedlibrary.view.preview.ContainerLayout;

public class ChooseProductFragment_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private ChooseProductFragment f28119b;

    /* renamed from: c  reason: collision with root package name */
    private View f28120c;

    /* renamed from: d  reason: collision with root package name */
    private View f28121d;

    /* renamed from: e  reason: collision with root package name */
    private View f28122e;

    /* renamed from: f  reason: collision with root package name */
    private View f28123f;

    public ChooseProductFragment_ViewBinding(final ChooseProductFragment chooseProductFragment, View view) {
        this.f28119b = chooseProductFragment;
        View a2 = b.a(view, c.e.iv_multi, "field 'mIvMulti' and method 'onChangeMode'");
        chooseProductFragment.mIvMulti = (ImageView) b.b(a2, c.e.iv_multi, "field 'mIvMulti'", ImageView.class);
        this.f28120c = a2;
        a2.setOnClickListener(new a() {
            public void a(View view) {
                chooseProductFragment.onChangeMode();
            }
        });
        View a3 = b.a(view, c.e.iv_enlarge, "field 'mIvEnlarge' and method 'onEnlarge'");
        chooseProductFragment.mIvEnlarge = (ImageView) b.b(a3, c.e.iv_enlarge, "field 'mIvEnlarge'", ImageView.class);
        this.f28121d = a3;
        a3.setOnClickListener(new a() {
            public void a(View view) {
                chooseProductFragment.onEnlarge();
            }
        });
        chooseProductFragment.sticky_navlayout = (StickyNavLayout) b.a(view, c.e.sticky_navlayout, "field 'sticky_navlayout'", StickyNavLayout.class);
        View a4 = b.a(view, c.e.iv_left, "field 'ivLeft' and method 'onBackClick'");
        chooseProductFragment.ivLeft = (ImageView) b.b(a4, c.e.iv_left, "field 'ivLeft'", ImageView.class);
        this.f28122e = a4;
        a4.setOnClickListener(new a() {
            public void a(View view) {
                chooseProductFragment.onBackClick();
            }
        });
        chooseProductFragment.btnTopBack = (RobotoTextView) b.a(view, c.e.btn_top_back, "field 'btnTopBack'", RobotoTextView.class);
        chooseProductFragment.ivRight = (ImageView) b.a(view, c.e.iv_right, "field 'ivRight'", ImageView.class);
        View a5 = b.a(view, c.e.tv_right, "field 'tvRight' and method 'onNextClick'");
        chooseProductFragment.tvRight = (RobotoTextView) b.b(a5, c.e.tv_right, "field 'tvRight'", RobotoTextView.class);
        this.f28123f = a5;
        a5.setOnClickListener(new a() {
            public void a(View view) {
                chooseProductFragment.onNextClick();
            }
        });
        chooseProductFragment.llTitleLayout = (RelativeLayout) b.a(view, c.e.ll_title_layout, "field 'llTitleLayout'", RelativeLayout.class);
        chooseProductFragment.idStickynavlayoutTopview = (FrameLayout) b.a(view, c.e.id_stickynavlayout_topview, "field 'idStickynavlayoutTopview'", FrameLayout.class);
        chooseProductFragment.idStickynavlayoutIndicator = (TabLayout) b.a(view, c.e.id_stickynavlayout_indicator, "field 'idStickynavlayoutIndicator'", TabLayout.class);
        chooseProductFragment.idStickynavlayoutViewpager = (CustomScrollViewPager) b.a(view, c.e.id_stickynavlayout_viewpager, "field 'idStickynavlayoutViewpager'", CustomScrollViewPager.class);
        chooseProductFragment.llMainChoose = (LinearLayout) b.a(view, c.e.ll_main_choose, "field 'llMainChoose'", LinearLayout.class);
        chooseProductFragment.mContainer = (ContainerLayout) b.a(view, c.e.container, "field 'mContainer'", ContainerLayout.class);
        chooseProductFragment.mViewShelter = (ContainerLayout) b.a(view, c.e.view_shelter, "field 'mViewShelter'", ContainerLayout.class);
        chooseProductFragment.mViewBlank = b.a(view, c.e.view_blank, "field 'mViewBlank'");
    }
}
