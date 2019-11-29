package com.shopee.app.ui.home;

import com.shopee.app.a.a;
import com.shopee.app.g.h;
import com.shopee.app.ui.actionbox.ActionBoxActivity;
import com.shopee.app.ui.actionbox.actionrequired.c;
import com.shopee.app.ui.actionbox2.f;
import com.shopee.app.ui.activity.d;
import com.shopee.app.ui.chat2.g;
import com.shopee.app.ui.common.aa;
import com.shopee.app.ui.common.ai;
import com.shopee.app.ui.error.a;
import com.shopee.app.ui.home.a.m;
import com.shopee.app.ui.home.chat.ChatTab;
import com.shopee.app.ui.home.follow.FollowTab;
import com.shopee.app.ui.home.me.control.MeControlView;
import com.shopee.app.ui.home.me.v3.MeTabView3;
import com.shopee.app.ui.home.me.v3.feature.b;
import com.shopee.app.ui.home.me.v3.feature.k;
import com.shopee.app.ui.home.me.v3.j;
import com.shopee.app.ui.home.react.ReactTabView;

public interface e extends a, h.a, com.shopee.app.react.modules.base.a, c.a, g.c, aa.a, ai.a, a.C0319a, MeControlView.a, com.shopee.app.ui.webview.e {
    void a(ActionBoxActivity actionBoxActivity);

    void a(com.shopee.app.ui.actionbox.actionrequired.a aVar);

    void a(com.shopee.app.ui.actionbox2.a aVar);

    void a(f fVar);

    void a(com.shopee.app.ui.activity.a aVar);

    void a(com.shopee.app.ui.activity.c cVar);

    void a(d dVar);

    void a(com.shopee.app.ui.home.a.e eVar);

    void a(m mVar);

    void a(com.shopee.app.ui.home.b.a aVar);

    void a(c cVar);

    void a(ChatTab chatTab);

    void a(FollowTab followTab);

    void a(m mVar);

    void a(MeTabView3 meTabView3);

    void a(com.shopee.app.ui.home.me.v3.a aVar);

    void a(com.shopee.app.ui.home.me.v3.f fVar);

    void a(b.a aVar);

    void a(b bVar);

    void a(k.a aVar);

    void a(k kVar);

    void a(j jVar);

    void a(ReactTabView reactTabView);
}
