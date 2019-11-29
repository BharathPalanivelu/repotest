package com.shopee.app.ui.home.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.a.a.f;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.tools.b;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.data.viewmodel.ActivityItemInfo;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.common.AvatarView;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.util.ak;
import com.shopee.app.util.bg;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.app.util.z;
import com.shopee.id.R;

public class e extends RelativeLayout implements n<ActivityItemInfo> {

    /* renamed from: a  reason: collision with root package name */
    AvatarView f22033a;

    /* renamed from: b  reason: collision with root package name */
    TextView f22034b;

    /* renamed from: c  reason: collision with root package name */
    TextView f22035c;

    /* renamed from: d  reason: collision with root package name */
    ImageView f22036d;

    /* renamed from: e  reason: collision with root package name */
    Button f22037e;

    /* renamed from: f  reason: collision with root package name */
    View f22038f;

    /* renamed from: g  reason: collision with root package name */
    int f22039g;
    int h;
    int i;
    ak j;
    bi k;
    private f l;
    /* access modifiers changed from: private */
    public ActivityItemInfo m;

    /* access modifiers changed from: package-private */
    public void a() {
    }

    public e(Context context) {
        super(context);
        ((com.shopee.app.ui.home.e) ((x) context).b()).a(this);
    }

    public void a(ActivityItemInfo activityItemInfo) {
        this.m = activityItemInfo;
        this.f22033a.a(activityItemInfo.getFromUserId(), activityItemInfo.getUserAvatar());
        this.f22037e.setVisibility(8);
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                e.this.k.a("ON_ACTIVITY_ITEM_CLICKED", new a(e.this.m));
            }
        });
        e(activityItemInfo);
        if (activityItemInfo.isUnread()) {
            setBackgroundResource(R.drawable.activity_item_unread_background);
        } else {
            setBackgroundResource(R.drawable.activity_item_background);
        }
        setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                com.shopee.app.ui.dialog.a.a(e.this.getContext(), new CharSequence[]{b.e(R.string.sp_view_delete)}, (a.c) new a.c() {
                    public void a(com.afollestad.materialdialogs.f fVar, View view, int i, CharSequence charSequence) {
                        e.this.k.a("ON_DELETE_ITEM", new com.garena.android.appkit.b.a(Integer.valueOf(e.this.m.getActivityId())));
                    }
                });
                return true;
            }
        });
    }

    public void b(ActivityItemInfo activityItemInfo) {
        String fromUserName = activityItemInfo.getFromUserName();
        this.l = f.a(getContext(), (int) R.string.sp_user_follow_you);
        this.l.a().a("user_name").a().b(this.h).d().c().a((Object) fromUserName).a((com.a.a.a) new bg(getContext(), activityItemInfo.getFromUserId())).b();
        this.l.a().a("time").a().b(this.f22039g).a(this.i).c().a((Object) "").b();
        this.l.a(this.f22034b);
        this.f22035c.setText(com.garena.android.appkit.tools.a.a.c(activityItemInfo.getCreateTime()));
        this.f22036d.setVisibility(8);
        setFollowBtn(activityItemInfo);
    }

    private void setFollowBtn(final ActivityItemInfo activityItemInfo) {
        if (!activityItemInfo.isUnknown()) {
            this.f22037e.setVisibility(0);
            if (activityItemInfo.isFollowed()) {
                this.f22037e.setText(R.string.sp_following);
                this.f22037e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.f22037e.setBackgroundResource(R.drawable.btn_follow_disabled);
                this.f22037e.setTextColor(b.a(R.color.white));
                this.f22037e.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        e.this.performClick();
                    }
                });
                return;
            }
            this.f22037e.setText(R.string.sp_follow);
            this.f22037e.setBackgroundResource(R.drawable.btn_follow);
            this.f22037e.setTextColor(b.a(R.color.black54));
            this.f22037e.setCompoundDrawablesWithIntrinsicBounds(R.drawable.com_garena_shopee_ic_btn_add_gray, 0, 0, 0);
            this.f22037e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    e.this.k.a("FOLLOW_SHOP_ACTIVITY_REQUEST", new com.garena.android.appkit.b.a(Integer.valueOf(activityItemInfo.getShopId())));
                }
            });
        }
    }

    public void c(ActivityItemInfo activityItemInfo) {
        String fromUserName = activityItemInfo.getFromUserName();
        String contactName = activityItemInfo.getContactName();
        if (activityItemInfo.getAccType() == 2) {
            this.l = f.a(getContext(), (int) R.string.sp_facebook_friend_join);
        } else {
            this.l = f.a(getContext(), (int) R.string.sp_contact_friend_join);
        }
        this.l.a().a("contact_name").a().b(this.h).d().c().a((Object) contactName).a((com.a.a.a) new bg(getContext(), activityItemInfo.getFromUserId())).b();
        this.l.a().a("user_name").a().b(this.h).d().c().a((Object) fromUserName).a((com.a.a.a) new bg(getContext(), activityItemInfo.getFromUserId())).b();
        this.l.a().a("time").a().b(this.f22039g).a(this.i).c().a((Object) "").b();
        this.l.a(this.f22034b);
        this.f22035c.setText(com.garena.android.appkit.tools.a.a.c(activityItemInfo.getCreateTime()));
        this.f22036d.setVisibility(8);
        setFollowBtn(activityItemInfo);
    }

    public void d(ActivityItemInfo activityItemInfo) {
        String fromUserName = activityItemInfo.getFromUserName();
        this.l = f.a(getContext(), (int) R.string.sp_user_like_your_item);
        this.l.a().a().b(this.h).d().c().a((Object) fromUserName).a((com.a.a.a) new bg(getContext(), activityItemInfo.getFromUserId())).b();
        this.l.a().a().b(this.h).d().c().a((Object) activityItemInfo.getItemName()).b();
        this.l.a().a().b(this.f22039g).a(this.i).c().a((Object) "").b();
        this.l.a(this.f22034b);
        this.f22035c.setText(com.garena.android.appkit.tools.a.a.c(activityItemInfo.getCreateTime()));
        this.f22036d.setVisibility(0);
        z.b(getContext()).a(activityItemInfo.getItemImage()).a(this.f22036d);
    }

    private void e(ActivityItemInfo activityItemInfo) {
        switch (activityItemInfo.getType()) {
            case 0:
                b(activityItemInfo);
                return;
            case 1:
                d(activityItemInfo);
                return;
            case 2:
                i(activityItemInfo);
                return;
            case 3:
                m(activityItemInfo);
                return;
            case 4:
                n(activityItemInfo);
                return;
            case 5:
                c(activityItemInfo);
                return;
            case 6:
                g(activityItemInfo);
                return;
            case 7:
                f(activityItemInfo);
                return;
            case 8:
                p(activityItemInfo);
                return;
            case 9:
                o(activityItemInfo);
                return;
            default:
                h(activityItemInfo);
                return;
        }
    }

    private void f(final ActivityItemInfo activityItemInfo) {
        this.f22034b.setText(activityItemInfo.getContent());
        this.f22035c.setText(com.garena.android.appkit.tools.a.a.c(activityItemInfo.getCreateTime()));
        this.f22033a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!TextUtils.isEmpty(activityItemInfo.getRedirectUrl())) {
                    e.this.j.n(activityItemInfo.getRedirectUrl());
                }
            }
        });
        this.f22036d.setVisibility(0);
        z.b(getContext()).a(activityItemInfo.getItemImage()).a(this.f22036d);
    }

    private void g(ActivityItemInfo activityItemInfo) {
        String fromUserName = activityItemInfo.getFromUserName();
        this.l = f.a(getContext(), (int) R.string.sp_user_rate_your_item);
        this.l.a().a().b(this.h).d().c().a((Object) fromUserName).a((com.a.a.a) new bg(getContext(), activityItemInfo.getFromUserId())).b();
        this.l.a().a((Object) activityItemInfo.getItemName()).b();
        this.l.a().a().b(this.f22039g).a(this.i).c().a((Object) "").b();
        this.l.a(this.f22034b);
        this.f22035c.setText(com.garena.android.appkit.tools.a.a.c(activityItemInfo.getCreateTime()));
        this.f22036d.setVisibility(0);
        z.b(getContext()).a(activityItemInfo.getItemImage()).a(this.f22036d);
    }

    private void h(ActivityItemInfo activityItemInfo) {
        this.f22036d.setVisibility(8);
        this.l = f.a(getContext());
        this.l.a((Object) b.e(R.string.sp_activity_item_unsupported)).b();
        this.l.a().a((Object) SQLBuilder.BLANK).b();
        this.l.a().a().b(this.f22039g).a(this.i).c().a((Object) "").b();
        this.l.a(this.f22034b);
        this.f22035c.setText(com.garena.android.appkit.tools.a.a.c(activityItemInfo.getCreateTime()));
    }

    private void i(ActivityItemInfo activityItemInfo) {
        this.f22036d.setVisibility(0);
        z.b(getContext()).a(activityItemInfo.getItemImage()).a(this.f22036d);
        int updateType = activityItemInfo.getUpdateType();
        if (updateType == 0) {
            k(activityItemInfo);
        } else if (updateType == 1) {
            l(activityItemInfo);
        } else if (updateType == 2) {
            j(activityItemInfo);
        }
    }

    private void j(ActivityItemInfo activityItemInfo) {
        this.l = f.a(getContext(), (int) R.string.sp_a_has_updated_b);
        this.l.a().a().b(this.h).d().c().a((Object) activityItemInfo.getFromUserName()).a((com.a.a.a) new bg(getContext(), activityItemInfo.getFromUserId())).b();
        this.l.a().a((Object) activityItemInfo.getItemName()).b();
        this.l.a().a().b(this.f22039g).a(this.i).c().a((Object) "").b();
        this.l.a(this.f22034b);
        this.f22035c.setText(com.garena.android.appkit.tools.a.a.c(activityItemInfo.getCreateTime()));
    }

    private void k(ActivityItemInfo activityItemInfo) {
        String fromUserName = activityItemInfo.getFromUserName();
        this.l = f.a(getContext(), (int) R.string.sp_a_has_deleted_b);
        this.l.a().a().b(this.h).d().c().a((Object) fromUserName).a((com.a.a.a) new bg(getContext(), activityItemInfo.getFromUserId())).b();
        this.l.a().a((Object) activityItemInfo.getItemName()).b();
        this.l.a().a().b(this.f22039g).a(this.i).c().a((Object) "").b();
        this.l.a(this.f22034b);
        this.f22035c.setText(com.garena.android.appkit.tools.a.a.c(activityItemInfo.getCreateTime()));
    }

    private void l(ActivityItemInfo activityItemInfo) {
        this.l = f.a(getContext(), (int) R.string.sp_out_of_stock);
        this.l.a().a().b(this.h).d().c().a((Object) activityItemInfo.getItemName()).b();
        this.l.a().a().b(this.f22039g).a(this.i).c().a((Object) "").b();
        this.l.a(this.f22034b);
        this.f22035c.setText(com.garena.android.appkit.tools.a.a.c(activityItemInfo.getCreateTime()));
    }

    private void m(ActivityItemInfo activityItemInfo) {
        String fromUserName = activityItemInfo.getFromUserName();
        this.l = f.a(getContext(), (int) R.string.sp_user_mention_you_in_comment);
        this.l.a().a().b(this.h).d().c().a((Object) fromUserName).a((com.a.a.a) new bg(getContext(), activityItemInfo.getFromUserId())).b();
        this.l.a().a((Object) activityItemInfo.getComment()).b();
        this.l.a().a().b(this.f22039g).a(this.i).c().a((Object) "").b();
        this.l.a(this.f22034b);
        this.f22035c.setText(com.garena.android.appkit.tools.a.a.c(activityItemInfo.getCreateTime()));
        this.f22036d.setVisibility(0);
        z.b(getContext()).a(activityItemInfo.getItemImage()).a(this.f22036d);
    }

    private void n(ActivityItemInfo activityItemInfo) {
        String fromUserName = activityItemInfo.getFromUserName();
        this.l = f.a(getContext(), (int) R.string.sp_user_comment_on_your_item);
        this.l.a().a().b(this.h).d().c().a((Object) fromUserName).a((com.a.a.a) new bg(getContext(), activityItemInfo.getFromUserId())).b();
        this.l.a().a((Object) activityItemInfo.getComment()).b();
        this.l.a().a().b(this.f22039g).a(this.i).c().a((Object) "").b();
        this.l.a(this.f22034b);
        this.f22035c.setText(com.garena.android.appkit.tools.a.a.c(activityItemInfo.getCreateTime()));
        this.f22036d.setVisibility(0);
        z.b(getContext()).a(activityItemInfo.getItemImage()).a(this.f22036d);
    }

    private void o(ActivityItemInfo activityItemInfo) {
        String fromUserName = activityItemInfo.getFromUserName();
        this.l = f.a(getContext(), (int) R.string.sp_user_comment_on_your_feed);
        this.l.a().a().b(this.h).d().c().a((Object) fromUserName).a((com.a.a.a) new bg(getContext(), activityItemInfo.getFromUserId())).b();
        this.l.a().a((Object) activityItemInfo.getComment()).b();
        this.l.a().a().b(this.f22039g).a(this.i).c().a((Object) "").b();
        this.l.a(this.f22034b);
        this.f22035c.setText(com.garena.android.appkit.tools.a.a.c(activityItemInfo.getCreateTime()));
        this.f22036d.setVisibility(8);
    }

    private void p(ActivityItemInfo activityItemInfo) {
        String fromUserName = activityItemInfo.getFromUserName();
        this.l = f.a(getContext(), (int) R.string.sp_user_mention_you_in_comment);
        this.l.a().a().b(this.h).d().c().a((Object) fromUserName).a((com.a.a.a) new bg(getContext(), activityItemInfo.getFromUserId())).b();
        this.l.a().a((Object) activityItemInfo.getComment()).b();
        this.l.a().a().b(this.f22039g).a(this.i).c().a((Object) "").b();
        this.l.a(this.f22034b);
        this.f22035c.setText(com.garena.android.appkit.tools.a.a.c(activityItemInfo.getCreateTime()));
        this.f22036d.setVisibility(8);
    }
}
