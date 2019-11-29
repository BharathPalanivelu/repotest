package com.shopee.feeds.feedlibrary.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.a.a;
import butterknife.a.b;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.view.CustomSwipeRefreshLayout;

public class MyFollowingActivity_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private MyFollowingActivity f27395b;

    /* renamed from: c  reason: collision with root package name */
    private View f27396c;

    /* renamed from: d  reason: collision with root package name */
    private View f27397d;

    public MyFollowingActivity_ViewBinding(final MyFollowingActivity myFollowingActivity, View view) {
        this.f27395b = myFollowingActivity;
        View a2 = b.a(view, c.e.iv_left, "field 'ivLeft' and method 'onClick'");
        myFollowingActivity.ivLeft = (ImageView) b.b(a2, c.e.iv_left, "field 'ivLeft'", ImageView.class);
        this.f27396c = a2;
        a2.setOnClickListener(new a() {
            public void a(View view) {
                myFollowingActivity.onClick(view);
            }
        });
        myFollowingActivity.btnTopBack = (TextView) b.a(view, c.e.btn_top_back, "field 'btnTopBack'", TextView.class);
        View a3 = b.a(view, c.e.iv_right, "field 'ivRight' and method 'onClick'");
        myFollowingActivity.ivRight = (ImageView) b.b(a3, c.e.iv_right, "field 'ivRight'", ImageView.class);
        this.f27397d = a3;
        a3.setOnClickListener(new a() {
            public void a(View view) {
                myFollowingActivity.onClick(view);
            }
        });
        myFollowingActivity.tvRight = (TextView) b.a(view, c.e.tv_right, "field 'tvRight'", TextView.class);
        myFollowingActivity.llTitleLayout = (RelativeLayout) b.a(view, c.e.ll_title_layout, "field 'llTitleLayout'", RelativeLayout.class);
        myFollowingActivity.recyclerView = (RecyclerView) b.a(view, c.e.recycler_view, "field 'recyclerView'", RecyclerView.class);
        myFollowingActivity.swipeRefreshLayout = (CustomSwipeRefreshLayout) b.a(view, c.e.swipe_refresh, "field 'swipeRefreshLayout'", CustomSwipeRefreshLayout.class);
        myFollowingActivity.mTvNoData = (TextView) b.a(view, c.e.tv_no_data, "field 'mTvNoData'", TextView.class);
    }
}
