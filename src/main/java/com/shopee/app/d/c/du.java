package com.shopee.app.d.c;

import com.garena.android.appkit.tools.a.a;
import com.path.android.jobqueue.JobManager;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.av;
import com.shopee.app.data.store.p;
import com.shopee.app.data.viewmodel.chat.ChatIntention;
import com.shopee.app.database.orm.bean.DBChatMessage;
import com.shopee.app.database.orm.bean.chatP2P.DBChat;
import com.shopee.app.network.g;
import com.shopee.app.util.g.b;
import com.shopee.app.util.n;
import com.shopee.protocol.shop.ChatTextInfo;

public class du extends a {

    /* renamed from: c  reason: collision with root package name */
    private final p f16853c;

    /* renamed from: d  reason: collision with root package name */
    private final UserInfo f16854d;

    /* renamed from: e  reason: collision with root package name */
    private final JobManager f16855e;

    /* renamed from: f  reason: collision with root package name */
    private final av f16856f;

    /* renamed from: g  reason: collision with root package name */
    private String f16857g;
    private long h;
    private int i;
    private int j;
    private long k;
    private long l;

    /* access modifiers changed from: protected */
    public String d() {
        return "SendTextChatInteractor";
    }

    public du(n nVar, p pVar, av avVar, UserInfo userInfo, JobManager jobManager) {
        super(nVar);
        this.f16853c = pVar;
        this.f16854d = userInfo;
        this.f16856f = avVar;
        this.f16855e = jobManager;
    }

    public void a(long j2, int i2, ChatIntention chatIntention, String str) {
        this.f16857g = str;
        this.k = j2;
        this.h = chatIntention.getItemId();
        this.i = chatIntention.getShopId();
        this.l = chatIntention.getOrderId();
        this.j = i2;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        g gVar = new g();
        DBChatMessage dBChatMessage = new DBChatMessage();
        dBChatMessage.d(this.f16854d.getUserId());
        dBChatMessage.c(this.k);
        dBChatMessage.c(this.i);
        dBChatMessage.e(this.j);
        dBChatMessage.a(new ChatTextInfo.Builder().text(this.f16857g).build().toByteArray());
        dBChatMessage.b(this.h);
        dBChatMessage.b(0);
        dBChatMessage.a(a.a());
        dBChatMessage.a(gVar.a());
        dBChatMessage.f(1);
        dBChatMessage.d(this.l);
        this.f16853c.a(dBChatMessage);
        DBChat a2 = this.f16856f.a(this.j);
        if (a2 != null) {
            a2.a(gVar.a());
            a2.g(a.a());
            this.f16856f.a(a2);
        }
        this.f16855e.addJobInBackground(new b(gVar.a()));
        this.f16402a.a("CHAT_LOCAL_SEND", new com.garena.android.appkit.b.a(com.shopee.app.d.b.a.a(dBChatMessage, this.f16854d.isMyShop(this.i))));
    }
}
