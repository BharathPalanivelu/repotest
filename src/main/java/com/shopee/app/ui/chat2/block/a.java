package com.shopee.app.ui.chat2.block;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.garena.android.appkit.tools.a.b;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import com.shopee.app.ui.a.n;
import com.shopee.id.R;

public class a extends FrameLayout implements n<UserBriefInfo> {

    /* renamed from: a  reason: collision with root package name */
    TextView f20303a;

    public a(Context context) {
        super(context);
        setLayoutParams(new RecyclerView.j(-1, -2));
        setPadding(b.a.k, b.a.f7695f, b.a.k, b.a.f7695f);
    }

    public void a(UserBriefInfo userBriefInfo) {
        this.f20303a.setText(com.garena.android.appkit.tools.b.e(R.string.sp_blocked_user_hint));
    }
}
