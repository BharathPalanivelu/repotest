package com.shopee.feeds.feedlibrary.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.facebook.appevents.AppEventsConstants;
import com.garena.android.appkit.tools.b;
import com.shopee.feeds.feedlibrary.adapter.TagFollowingAdapter;
import com.shopee.feeds.feedlibrary.adapter.a;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.FinishPdListEntity;
import com.shopee.feeds.feedlibrary.data.entity.FollowingEntity;
import com.shopee.feeds.feedlibrary.data.entity.FollowingPosEntity;
import com.shopee.feeds.feedlibrary.data.entity.SearchUserEntity;
import com.shopee.feeds.feedlibrary.util.b.e;
import com.shopee.feeds.feedlibrary.util.u;
import com.shopee.feeds.feedlibrary.view.CustomSwipeRefreshLayout;
import com.shopee.feeds.feedlibrary.view.a.d;
import java.util.ArrayList;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;

public class MyFollowingActivity extends a implements SwipeRefreshLayout.b, CustomSwipeRefreshLayout.a, d {
    @BindView
    TextView btnTopBack;

    /* renamed from: c  reason: collision with root package name */
    TagFollowingAdapter f7072c;

    /* renamed from: d  reason: collision with root package name */
    com.shopee.feeds.feedlibrary.b.d f7073d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<SearchUserEntity.User> f7074e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private String f7075f = AppEventsConstants.EVENT_PARAM_VALUE_NO;

    /* renamed from: g  reason: collision with root package name */
    private boolean f7076g = false;
    @BindView
    ImageView ivLeft;
    @BindView
    ImageView ivRight;
    @BindView
    RelativeLayout llTitleLayout;
    @BindView
    TextView mTvNoData;
    @BindView
    RecyclerView recyclerView;
    @BindView
    CustomSwipeRefreshLayout swipeRefreshLayout;
    @BindView
    TextView tvRight;

    public boolean e() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        c();
        super.onCreate(bundle);
        setContentView(c.f.feeds_activity_following);
        ButterKnife.a((Activity) this);
        org.greenrobot.eventbus.c.a().a((Object) this);
        this.f7073d = new com.shopee.feeds.feedlibrary.b.d(this.f7086a);
        this.f7073d.a(this);
    }

    public void h() {
        j();
        this.swipeRefreshLayout.setSize(0);
        this.swipeRefreshLayout.setColorSchemeResources(c.b.colorPrimary, c.b.colorAccent, c.b.colorPrimaryDark);
        this.swipeRefreshLayout.setScrollUpChild(this.recyclerView);
        this.swipeRefreshLayout.setEnabled(true);
        this.swipeRefreshLayout.setOnLoadListener(this);
        this.swipeRefreshLayout.setOnRefreshListener(this);
        this.f7072c = new TagFollowingAdapter(this.f7086a);
        this.f7072c.a(false);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this.f7086a));
        this.recyclerView.setAdapter(this.f7072c);
        this.f7072c.a((a.C0422a) new a.C0422a() {
            public void a(int i, Object obj, View view) {
                SearchUserEntity.User user = (SearchUserEntity.User) obj;
                FollowingPosEntity followingPosEntity = new FollowingPosEntity();
                followingPosEntity.setName(user.getUsername());
                followingPosEntity.setUser_id(user.getUser_id());
                org.greenrobot.eventbus.c.a().c(followingPosEntity);
                MyFollowingActivity.this.finish();
            }
        });
        this.f7073d.a(this.f7075f, 12);
    }

    private void j() {
        this.btnTopBack.setText(b.e(c.g.feeds_nav_bar_title_my_following));
        this.ivLeft.setImageResource(c.d.feeds_ic_left_arrow);
        this.tvRight.setVisibility(8);
        this.ivRight.setVisibility(0);
        this.ivRight.setImageResource(c.d.feeds_ic_search);
    }

    @OnClick
    public void onClick(View view) {
        int id = view.getId();
        if (id == c.e.iv_left) {
            finish();
        } else if (id == c.e.iv_right) {
            startActivity(new Intent(this, UserSearchActivity.class));
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    public void onRefresh() {
        this.f7075f = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        this.f7073d.a(this.f7075f, 12);
    }

    public void i() {
        if (this.f7076g) {
            this.f7073d.a(this.f7075f, 12);
        } else {
            u.a(this, b.e(c.g.feeds_no_more_data));
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.a().b(this);
        this.f7072c.a((a.C0422a) null);
    }

    public void f() {
        e.f(this.f7087b);
    }

    @m(a = ThreadMode.MAIN)
    public void onMessageEvent(FollowingPosEntity followingPosEntity) {
        boolean z = followingPosEntity instanceof FollowingPosEntity;
    }

    @m(a = ThreadMode.MAIN)
    public void onMessageEvent(FinishPdListEntity finishPdListEntity) {
        if (finishPdListEntity instanceof FinishPdListEntity) {
            finish();
        }
    }

    public void a(String str, FollowingEntity followingEntity) {
        this.swipeRefreshLayout.setRefreshing(false);
        this.swipeRefreshLayout.setLoading(false);
        if (followingEntity.getUsers().size() > 0 || !str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            this.mTvNoData.setVisibility(8);
            this.recyclerView.setVisibility(0);
            if (followingEntity.getUsers().size() > 0) {
                if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    this.f7074e.clear();
                }
                this.f7074e.addAll(followingEntity.getUsers());
                this.f7072c.a(this.f7074e);
                this.f7075f = followingEntity.getNext_id();
                this.f7076g = followingEntity.isHas_more();
                return;
            }
            return;
        }
        this.mTvNoData.setVisibility(0);
        this.mTvNoData.setText(b.e(c.g.feeds_following_no_data_tips));
        this.recyclerView.setVisibility(8);
    }
}
