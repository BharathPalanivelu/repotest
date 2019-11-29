package com.shopee.app.ui.actionbar;

import android.app.Activity;
import android.content.Intent;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.chat2.ChatListActivity_;
import com.shopee.id.R;

public class d extends a.b {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f19296a;

    public d(Activity activity) {
        super("ACTION_BAR_ACTION_BOX", (int) R.drawable.ic_chat_andriod);
        this.f19296a = activity;
    }

    public void a() {
        Activity activity = this.f19296a;
        activity.startActivity(new Intent(activity, ChatListActivity_.class));
    }
}
