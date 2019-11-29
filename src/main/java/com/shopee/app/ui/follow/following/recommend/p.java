package com.shopee.app.ui.follow.following.recommend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.shopee.app.database.orm.bean.DBContactInfo;
import com.shopee.app.ui.a.s;
import com.shopee.id.R;

public class p implements s<DBContactInfo> {
    public int a() {
        return 3;
    }

    public int a(DBContactInfo dBContactInfo, int i) {
        return dBContactInfo.g();
    }

    public View a(Context context, int i) {
        if (i == 0) {
            return n.a(context);
        }
        if (i == 1) {
            return ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.invite_fb_friend_layout, (ViewGroup) null);
        }
        if (i != 2) {
            return null;
        }
        return b.a(context);
    }
}
