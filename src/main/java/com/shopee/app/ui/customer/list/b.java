package com.shopee.app.ui.customer.list;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.common.AvatarView;

public class b extends FrameLayout implements n<UserBriefInfo> {

    /* renamed from: a  reason: collision with root package name */
    TextView f21396a;

    /* renamed from: b  reason: collision with root package name */
    TextView f21397b;

    /* renamed from: c  reason: collision with root package name */
    AvatarView f21398c;

    public b(Context context) {
        super(context);
    }

    public void a(UserBriefInfo userBriefInfo) {
        String matchKeyword = userBriefInfo.getMatchKeyword();
        if (TextUtils.isEmpty(matchKeyword)) {
            this.f21396a.setText(userBriefInfo.getUserName());
        } else {
            String userName = userBriefInfo.getUserName();
            this.f21396a.setText(Html.fromHtml(userName.replaceFirst(matchKeyword, "<font color=#00BFA5>" + matchKeyword + "</font>")));
        }
        this.f21397b.setText(userBriefInfo.getNickName());
        this.f21398c.a(userBriefInfo.getUserId(), userBriefInfo.getPortrait());
    }
}
