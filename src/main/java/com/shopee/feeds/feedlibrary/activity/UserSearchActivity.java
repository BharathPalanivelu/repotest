package com.shopee.feeds.feedlibrary.activity;

import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.feeds.feedlibrary.adapter.TagFollowingAdapter;
import com.shopee.feeds.feedlibrary.adapter.a;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.FinishPdListEntity;
import com.shopee.feeds.feedlibrary.data.entity.FollowingPosEntity;
import com.shopee.feeds.feedlibrary.data.entity.SearchUserEntity;

public class UserSearchActivity extends BaseSearchActivity<SearchUserEntity.User> {

    /* renamed from: e  reason: collision with root package name */
    TagFollowingAdapter f27451e;

    public boolean e() {
        return false;
    }

    public String i() {
        return b.e(c.g.feeds_search_bar_placehoder_for_shop);
    }

    public void a(Object obj) {
        SearchUserEntity searchUserEntity = (SearchUserEntity) obj;
        this.f7064d.clear();
        if (searchUserEntity.getUsers().size() > 0) {
            this.recyclerView.setVisibility(0);
            this.tvNoResult.setVisibility(8);
            this.f7064d.addAll(searchUserEntity.getUsers());
        } else {
            this.recyclerView.setVisibility(8);
            this.tvNoResult.setVisibility(0);
        }
        this.f27451e.a(this.f7064d);
    }

    public a j() {
        this.f27451e = new TagFollowingAdapter(this.f7086a);
        this.f27451e.a(true);
        this.f27451e.a((a.C0422a) new a.C0422a() {
            public void a(int i, Object obj, View view) {
                if (obj != null) {
                    SearchUserEntity.User user = (SearchUserEntity.User) obj;
                    FollowingPosEntity followingPosEntity = new FollowingPosEntity();
                    followingPosEntity.setName(user.getUsername());
                    followingPosEntity.setUser_id(user.getUser_id());
                    org.greenrobot.eventbus.c.a().c(followingPosEntity);
                    org.greenrobot.eventbus.c.a().c(new FinishPdListEntity());
                    UserSearchActivity.this.finish();
                }
            }
        });
        return this.f27451e;
    }

    public void c(String str) {
        this.f7063c.a(str, 1, 0, 20);
    }
}
