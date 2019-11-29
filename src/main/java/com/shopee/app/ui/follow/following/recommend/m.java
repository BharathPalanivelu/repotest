package com.shopee.app.ui.follow.following.recommend;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.shopee.app.database.orm.bean.DBContactInfo;
import com.shopee.app.ui.a.n;
import com.shopee.id.R;

public class m extends LinearLayout implements n<DBContactInfo> {

    /* renamed from: a  reason: collision with root package name */
    TextView f21723a;

    /* renamed from: b  reason: collision with root package name */
    TextView f21724b;

    /* access modifiers changed from: package-private */
    public void a() {
    }

    public m(Context context) {
        super(context);
    }

    public void a(DBContactInfo dBContactInfo) {
        if (dBContactInfo.e() == 2) {
            this.f21723a.setText(b.e(R.string.sp_label_facebook_friends));
            this.f21724b.setText(b.e(R.string.sp_facebook_friends_hint));
        } else if (dBContactInfo.e() == 4) {
            this.f21723a.setText(b.e(R.string.sp_contact_friends_title));
            this.f21724b.setText(b.e(R.string.sp_contact_friends_hint));
        } else if (dBContactInfo.e() == 5) {
            this.f21723a.setText(b.e(R.string.sp_beetalk_friends_title));
            this.f21724b.setText(b.e(R.string.sp_contact_friends_hint));
        }
    }
}
