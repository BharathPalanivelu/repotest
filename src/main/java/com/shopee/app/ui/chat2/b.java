package com.shopee.app.ui.chat2;

import android.os.Bundle;
import android.view.View;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.chat.c;
import com.shopee.app.ui.chat2.search.ChatSearchActivity_;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class b extends com.shopee.app.ui.a.b implements x<com.shopee.app.ui.chat.b> {

    /* renamed from: a  reason: collision with root package name */
    private com.shopee.app.ui.chat.b f20280a;

    public String j() {
        return BaseEvent.SDK_CHAT;
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) new m(this));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).b((int) R.string.sp_label_chats).e(0).a((a.b) new a.b("SEARCH", R.drawable.com_garena_shopee_ic_search) {
            public void a() {
                ChatSearchActivity_.a(b.this).a();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f20280a = c.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f20280a.a(this);
    }

    /* renamed from: c */
    public com.shopee.app.ui.chat.b b() {
        return this.f20280a;
    }
}
