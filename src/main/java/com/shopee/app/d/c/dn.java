package com.shopee.app.d.c;

import android.graphics.Bitmap;
import android.net.Uri;
import com.garena.android.appkit.b.a;
import com.path.android.jobqueue.JobManager;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.av;
import com.shopee.app.data.store.p;
import com.shopee.app.data.store.setting.ImageConfig;
import com.shopee.app.data.viewmodel.chat.ChatIntention;
import com.shopee.app.database.orm.bean.DBChatMessage;
import com.shopee.app.database.orm.bean.chatP2P.DBChat;
import com.shopee.app.h.l;
import com.shopee.app.network.d.b.g;
import com.shopee.app.util.g.b;
import com.shopee.app.util.g.d;
import com.shopee.app.util.n;
import com.shopee.protocol.shop.ChatImageInfo;
import java.util.List;

public class dn extends a {

    /* renamed from: c  reason: collision with root package name */
    private final p f16819c;

    /* renamed from: d  reason: collision with root package name */
    private final UserInfo f16820d;

    /* renamed from: e  reason: collision with root package name */
    private final JobManager f16821e;

    /* renamed from: f  reason: collision with root package name */
    private final av f16822f;

    /* renamed from: g  reason: collision with root package name */
    private List<String> f16823g;
    private long h;
    private int i;
    private int j;
    private long k;
    private long l;
    private SettingConfigStore m;

    /* access modifiers changed from: protected */
    public String d() {
        return "SendImageChatInteractor";
    }

    public dn(n nVar, p pVar, av avVar, UserInfo userInfo, JobManager jobManager, SettingConfigStore settingConfigStore) {
        super(nVar);
        this.f16819c = pVar;
        this.f16820d = userInfo;
        this.f16821e = jobManager;
        this.f16822f = avVar;
        this.m = settingConfigStore;
    }

    public void a(long j2, int i2, ChatIntention chatIntention, List<String> list) {
        this.f16823g = list;
        this.k = j2;
        this.h = chatIntention.getItemId();
        this.i = chatIntention.getShopId();
        this.l = chatIntention.getOrderId();
        this.j = i2;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        ImageConfig chatImageConfig = this.m.getChatImageConfig();
        for (String a2 : this.f16823g) {
            String a3 = a(chatImageConfig, a2);
            if (a3 == null) {
                this.f16402a.a("CHAT_LOCAL_IMAGE_SEND_FAIL", new a());
            } else {
                g gVar = new g();
                DBChatMessage dBChatMessage = new DBChatMessage();
                dBChatMessage.d(this.f16820d.getUserId());
                dBChatMessage.c(this.k);
                dBChatMessage.c(this.i);
                dBChatMessage.e(this.j);
                ChatImageInfo.Builder imageUrl = new ChatImageInfo.Builder().imageUrl(a3);
                dBChatMessage.a(imageUrl.thumbUrl(a3 + "_tn").thumbWidth(Integer.valueOf(chatImageConfig.getThumbImageWidth())).thumbHeight(Integer.valueOf(chatImageConfig.getThumbImageHeight())).build().toByteArray());
                dBChatMessage.b(this.h);
                dBChatMessage.b(1);
                dBChatMessage.a(com.garena.android.appkit.tools.a.a.a());
                dBChatMessage.a(gVar.i().a());
                dBChatMessage.f(1);
                dBChatMessage.d(this.l);
                this.f16819c.a(dBChatMessage);
                DBChat a4 = this.f16822f.a(this.j);
                if (a4 != null) {
                    a4.a(gVar.i().a());
                    a4.g(com.garena.android.appkit.tools.a.a.a());
                    this.f16822f.a(a4);
                }
                this.f16821e.addJobInBackground(new b(gVar.i().a()));
                this.f16402a.a("CHAT_LOCAL_SEND", new a(com.shopee.app.d.b.a.a(dBChatMessage, this.f16820d.isMyShop(this.i))));
            }
        }
    }

    private String a(ImageConfig imageConfig, String str) {
        Bitmap a2 = l.a().a(Uri.parse(str), imageConfig.getFullImageWidth(), imageConfig.getFullImageHeight());
        if (a2 == null) {
            return null;
        }
        String a3 = com.shopee.app.h.b.a.a().a(l.a().a(a2, imageConfig.getFullImageQuality()));
        com.shopee.app.h.b.a.a().a(a3, l.a().a(l.b(a2, imageConfig.getThumbImageWidth(), imageConfig.getThumbImageHeight()), imageConfig.getThumbImageQuality()));
        if (!a2.isRecycled()) {
            a2.recycle();
        }
        this.f16821e.addJobInBackground(new d(a3));
        JobManager jobManager = this.f16821e;
        jobManager.addJobInBackground(new d(a3 + "_tn"));
        return a3;
    }
}
