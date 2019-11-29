package com.shopee.app.ui.follow.following.recommend;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.devspark.robototextview.widget.RobotoButton;
import com.garena.android.appkit.tools.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.database.orm.bean.DBContactInfo;
import com.shopee.app.ui.a.n;
import com.shopee.app.util.ak;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.app.util.z;
import com.shopee.id.R;

public class a extends FrameLayout implements n<DBContactInfo> {

    /* renamed from: a  reason: collision with root package name */
    ImageView f21670a;

    /* renamed from: b  reason: collision with root package name */
    TextView f21671b;

    /* renamed from: c  reason: collision with root package name */
    TextView f21672c;

    /* renamed from: d  reason: collision with root package name */
    RobotoButton f21673d;

    /* renamed from: e  reason: collision with root package name */
    bi f21674e;

    /* renamed from: f  reason: collision with root package name */
    UserInfo f21675f;

    /* renamed from: g  reason: collision with root package name */
    ak f21676g;
    private DBContactInfo h;
    private int i;

    public a(Context context) {
        super(context);
        ((i) ((x) context).b()).a(this);
    }

    public void a(DBContactInfo dBContactInfo) {
        this.h = dBContactInfo;
        z.a(getContext()).a(dBContactInfo.b()).a(this.f21670a);
        this.i = dBContactInfo.d();
        this.f21671b.setText(dBContactInfo.a());
        this.f21672c.setText(dBContactInfo.c());
        if (!dBContactInfo.a().equals(this.f21675f.getUsername())) {
            this.f21673d.setVisibility(0);
            if (dBContactInfo.f()) {
                this.f21673d.setText(R.string.sp_following);
                this.f21673d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.f21673d.setBackgroundResource(R.drawable.btn_follow_disabled2);
                this.f21673d.setTextColor(b.a(R.color.white));
                return;
            }
            this.f21673d.setText(R.string.sp_follow);
            this.f21673d.setBackgroundResource(R.drawable.btn_primary);
            this.f21673d.setTextColor(b.a(R.color.white));
            this.f21673d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.com_garena_shopee_ic_btn_add, 0, 0, 0);
            return;
        }
        this.f21673d.setVisibility(8);
    }

    public void a() {
        if (!this.h.f()) {
            this.f21674e.a("FOLLOW_SHOP_REQUEST_CONTACT", new com.garena.android.appkit.b.a(Integer.valueOf(this.i)));
        } else {
            this.f21676g.b(this.i);
        }
    }
}
