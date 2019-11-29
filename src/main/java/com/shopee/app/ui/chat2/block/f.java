package com.shopee.app.ui.chat2.block;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.devspark.robototextview.widget.RobotoButton;
import com.garena.android.appkit.tools.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import com.shopee.app.ui.a.n;
import com.shopee.app.util.ak;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.app.util.z;
import com.shopee.id.R;

public class f extends FrameLayout implements n<UserBriefInfo> {

    /* renamed from: a  reason: collision with root package name */
    TextView f20314a;

    /* renamed from: b  reason: collision with root package name */
    TextView f20315b;

    /* renamed from: c  reason: collision with root package name */
    ImageView f20316c;

    /* renamed from: d  reason: collision with root package name */
    RobotoButton f20317d;

    /* renamed from: e  reason: collision with root package name */
    View f20318e;

    /* renamed from: f  reason: collision with root package name */
    bi f20319f;

    /* renamed from: g  reason: collision with root package name */
    UserInfo f20320g;
    ak h;
    /* access modifiers changed from: private */
    public UserBriefInfo i;

    public interface a {
        void a(f fVar);
    }

    public f(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        ((a) ((x) context).b()).a(this);
    }

    public void a(UserBriefInfo userBriefInfo) {
        this.i = userBriefInfo;
        z.a(getContext()).a(userBriefInfo.getPortrait()).a(this.f20316c);
        if (userBriefInfo.isUserBanned()) {
            this.f20314a.setText(b.e(R.string.sp_banned_user));
            this.f20314a.setTextColor(b.a(R.color.black87));
            this.f20315b.setTextColor(b.a(R.color.primary));
            this.f20315b.setText(b.e(R.string.sp_label_banned));
            this.f20316c.setOnClickListener((View.OnClickListener) null);
            this.f20314a.setOnClickListener((View.OnClickListener) null);
            this.f20318e.setVisibility(0);
        } else if (userBriefInfo.isUserDeleted()) {
            this.f20314a.setText(b.e(R.string.sp_label_deleted_user));
            this.f20314a.setTextColor(b.a(R.color.black87));
            this.f20315b.setTextColor(b.a(R.color.primary));
            this.f20315b.setText(b.e(R.string.sp_label_deleted));
            this.f20316c.setOnClickListener((View.OnClickListener) null);
            this.f20314a.setOnClickListener((View.OnClickListener) null);
            this.f20318e.setVisibility(0);
        } else {
            this.f20314a.setTextColor(b.a(R.color.black87));
            this.f20314a.setText(userBriefInfo.getUserName());
            this.f20315b.setTextColor(b.a(R.color.black54));
            this.f20315b.setText(userBriefInfo.getNickName());
            this.f20318e.setVisibility(8);
            this.f20316c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    f.this.h.b(f.this.i.getShopId());
                }
            });
            this.f20314a.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    f.this.h.b(f.this.i.getShopId());
                }
            });
        }
        if (userBriefInfo.hideFollow() || userBriefInfo.getUserName().equals(this.f20320g.getUsername())) {
            this.f20317d.setVisibility(8);
            return;
        }
        this.f20317d.setVisibility(0);
        if (userBriefInfo.isChatBlocked()) {
            this.f20317d.setText(R.string.sp_unblock);
            this.f20317d.setBackgroundResource(R.drawable.btn_primary_reversed);
            this.f20317d.setTextColor(b.a(R.color.primary));
            return;
        }
        this.f20317d.setText(R.string.sp_block);
        this.f20317d.setBackgroundResource(R.drawable.btn_primary);
        this.f20317d.setTextColor(b.a(R.color.white));
    }

    public void a() {
        this.f20319f.a("BLOCK_USER_CHAT", new com.garena.android.appkit.b.a(this.i));
    }
}
