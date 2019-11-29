package com.shopee.feeds.feedlibrary.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.a.b;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.SearchUserEntity;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.util.h;
import com.shopee.feeds.feedlibrary.util.m;
import com.shopee.feeds.feedlibrary.util.v;
import com.shopee.feeds.feedlibrary.view.CircleImageView;
import com.squareup.a.e;
import com.squareup.a.w;

public class TagFollowingAdapter extends a<SearchUserEntity.User> {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f27548e = false;

    public class UserViewHolder_ViewBinding implements Unbinder {

        /* renamed from: b  reason: collision with root package name */
        private UserViewHolder f27556b;

        public UserViewHolder_ViewBinding(UserViewHolder userViewHolder, View view) {
            this.f27556b = userViewHolder;
            userViewHolder.rlFollowing = (RelativeLayout) b.a(view, c.e.rl_following, "field 'rlFollowing'", RelativeLayout.class);
            userViewHolder.civPortrait = (CircleImageView) b.a(view, c.e.civ_portrait, "field 'civPortrait'", CircleImageView.class);
            userViewHolder.tvFollowName = (TextView) b.a(view, c.e.tv_follow_name, "field 'tvFollowName'", TextView.class);
            userViewHolder.tvFollowerNum = (TextView) b.a(view, c.e.tv_follower_num, "field 'tvFollowerNum'", TextView.class);
            userViewHolder.view_bg = b.a(view, c.e.view_bg, "field 'view_bg'");
        }
    }

    public TagFollowingAdapter(Context context) {
        super(context);
    }

    public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new UserViewHolder(this.f27559c.inflate(c.f.feeds_layout_following, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.w wVar, final int i) {
        final UserViewHolder userViewHolder = (UserViewHolder) wVar;
        final SearchUserEntity.User user = (SearchUserEntity.User) this.f27558b.get(i);
        userViewHolder.tvFollowName.setText(user.getUsername());
        if (user.getFollower_count() > 1) {
            userViewHolder.tvFollowerNum.setText(String.format(com.garena.android.appkit.tools.b.e(c.g.feeds_txt_followers), new Object[]{v.b(String.valueOf(user.getFollower_count()), 1)}));
        } else {
            userViewHolder.tvFollowerNum.setText(String.format(com.garena.android.appkit.tools.b.e(c.g.feeds_txt_follower), new Object[]{String.valueOf(user.getFollower_count())}));
        }
        if (!d.a(user.getAvatar())) {
            w.a(this.f27557a).a(m.a(user.getAvatar(), true)).a(c.d.feeds_icn_default_avatar).b(c.d.feeds_icn_default_avatar).a((ImageView) userViewHolder.civPortrait, (e) new e() {
                public void c() {
                    h.b("%s", "tagdbmod sus" + m.a(user.getAvatar(), true));
                }

                public void d() {
                    h.b("%s", "tagdbmod err " + m.a(user.getAvatar(), false));
                    w.a(TagFollowingAdapter.this.f27557a).a(m.a(user.getAvatar(), false)).a(c.d.feeds_icn_default_avatar).b(c.d.feeds_icn_default_avatar).a((ImageView) userViewHolder.civPortrait);
                }
            });
        } else {
            h.b("%s", "tagdbmod no image");
            userViewHolder.civPortrait.setImageResource(c.d.feeds_icn_default_avatar);
        }
        if (this.f27548e || user.isTaggable()) {
            userViewHolder.view_bg.setVisibility(8);
            userViewHolder.rlFollowing.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (TagFollowingAdapter.this.f27560d != null) {
                        TagFollowingAdapter.this.f27560d.a(i, user, userViewHolder.rlFollowing);
                        if (!TagFollowingAdapter.this.f27548e) {
                            com.shopee.feeds.feedlibrary.util.b.e.f(user.getUser_id());
                        }
                    }
                }
            });
            return;
        }
        userViewHolder.rlFollowing.setEnabled(false);
        userViewHolder.view_bg.setVisibility(0);
    }

    public void a(boolean z) {
        this.f27548e = z;
    }

    static class UserViewHolder extends RecyclerView.w {
        @BindView
        CircleImageView civPortrait;
        @BindView
        RelativeLayout rlFollowing;
        @BindView
        TextView tvFollowName;
        @BindView
        TextView tvFollowerNum;
        @BindView
        View view_bg;

        public UserViewHolder(View view) {
            super(view);
            ButterKnife.a(this, view);
        }
    }
}
