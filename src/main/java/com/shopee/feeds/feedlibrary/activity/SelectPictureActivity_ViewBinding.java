package com.shopee.feeds.feedlibrary.activity;

import android.view.View;
import butterknife.Unbinder;
import butterknife.a.b;
import com.google.android.material.tabs.TabLayout;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.view.easyviewpager.CustomScrollViewPager;

public class SelectPictureActivity_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private SelectPictureActivity f27425b;

    public SelectPictureActivity_ViewBinding(SelectPictureActivity selectPictureActivity, View view) {
        this.f27425b = selectPictureActivity;
        selectPictureActivity.viewpagerContainer = (CustomScrollViewPager) b.a(view, c.e.viewpager_container, "field 'viewpagerContainer'", CustomScrollViewPager.class);
        selectPictureActivity.tabPost = (TabLayout) b.a(view, c.e.tab_post, "field 'tabPost'", TabLayout.class);
        selectPictureActivity.viewStatus = b.a(view, c.e.view_status, "field 'viewStatus'");
    }
}
