package com.shopee.app.d.c;

import com.garena.android.appkit.tools.a.a;
import com.garena.sticker.e.b;
import com.path.android.jobqueue.JobManager;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.av;
import com.shopee.app.data.store.p;
import com.shopee.app.data.viewmodel.chat.ChatIntention;
import com.shopee.app.database.orm.bean.DBChatMessage;
import com.shopee.app.database.orm.bean.chatP2P.DBChat;
import com.shopee.app.network.d.b.g;
import com.shopee.app.util.n;
import com.shopee.protocol.shop.ChatStickerInfo;

public class dt extends a {

    /* renamed from: c  reason: collision with root package name */
    private final p f16848c;

    /* renamed from: d  reason: collision with root package name */
    private final UserInfo f16849d;

    /* renamed from: e  reason: collision with root package name */
    private final JobManager f16850e;

    /* renamed from: f  reason: collision with root package name */
    private final av f16851f;

    /* renamed from: g  reason: collision with root package name */
    private int f16852g;
    private long h;
    private long i;
    private long j;
    private int k;
    private b l;

    /* access modifiers changed from: protected */
    public String d() {
        return "SendStickerChatInteractor";
    }

    public dt(n nVar, p pVar, av avVar, UserInfo userInfo, JobManager jobManager) {
        super(nVar);
        this.f16848c = pVar;
        this.f16849d = userInfo;
        this.f16851f = avVar;
        this.f16850e = jobManager;
    }

    public void a(long j2, int i2, ChatIntention chatIntention, b bVar) {
        this.l = bVar;
        this.h = j2;
        this.j = chatIntention.getItemId();
        this.k = chatIntention.getShopId();
        this.i = chatIntention.getOrderId();
        this.f16852g = i2;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        g gVar = new g();
        DBChatMessage dBChatMessage = new DBChatMessage();
        dBChatMessage.d(this.f16849d.getUserId());
        dBChatMessage.c(this.h);
        dBChatMessage.c(this.k);
        dBChatMessage.e(this.f16852g);
        dBChatMessage.a(new ChatStickerInfo.Builder().stickerid(this.l.d()).packid(this.l.c()).format(this.l.f()).build().toByteArray());
        dBChatMessage.b(this.j);
        dBChatMessage.b(6);
        dBChatMessage.a(a.a());
        dBChatMessage.a(gVar.i().a());
        dBChatMessage.f(1);
        dBChatMessage.d(this.i);
        this.f16848c.a(dBChatMessage);
        DBChat a2 = this.f16851f.a(this.f16852g);
        if (a2 != null) {
            a2.a(gVar.i().a());
            a2.g(a.a());
            this.f16851f.a(a2);
        }
        this.f16850e.addJobInBackground(new com.shopee.app.util.g.b(gVar.i().a()));
        this.f16402a.a("CHAT_LOCAL_SEND", new com.garena.android.appkit.b.a(com.shopee.app.d.b.a.a(dBChatMessage, this.f16849d.isMyShop(this.k))));
    }
}
