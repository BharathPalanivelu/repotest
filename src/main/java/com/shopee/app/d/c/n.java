package com.shopee.app.d.c;

import android.text.TextUtils;
import com.path.android.jobqueue.JobManager;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.a.a;
import com.shopee.app.data.store.av;
import com.shopee.app.data.store.p;
import com.shopee.app.database.orm.bean.DBChatMessage;
import com.shopee.app.database.orm.bean.chatP2P.DBChat;
import com.shopee.app.util.af;
import java.util.List;

public class n extends com.shopee.app.d.c.a.a<a> {

    /* renamed from: d  reason: collision with root package name */
    private final p f17100d;

    /* renamed from: e  reason: collision with root package name */
    private final JobManager f17101e;

    /* renamed from: f  reason: collision with root package name */
    private final UserInfo f17102f;

    /* renamed from: g  reason: collision with root package name */
    private final av f17103g;

    public n(com.shopee.app.util.n nVar, p pVar, av avVar, UserInfo userInfo, JobManager jobManager) {
        super(nVar);
        this.f17100d = pVar;
        this.f17103g = avVar;
        this.f17101e = jobManager;
        this.f17102f = userInfo;
    }

    public void a(String str) {
        b(new a(str));
    }

    /* access modifiers changed from: protected */
    public void a(a aVar) {
        String a2 = aVar.f17104a;
        if (!TextUtils.isEmpty(a2)) {
            DBChatMessage a3 = this.f17100d.a(a2);
            if (a3 != null) {
                this.f17100d.b(a3);
                DBChat a4 = this.f17103g.a(a3.e());
                List<DBChatMessage> a5 = this.f17100d.a(a3.e(), 20);
                if (!af.a(a5) && a4 != null) {
                    DBChatMessage dBChatMessage = a5.get(0);
                    if (dBChatMessage.b() != 0) {
                        a4.d(dBChatMessage.b());
                        a4.e(dBChatMessage.f());
                        a4.a("");
                        a4.g(0);
                        this.f17103g.a(a4);
                    } else {
                        a4.a(dBChatMessage.l());
                        a4.e(dBChatMessage.f());
                        this.f17103g.a(a4);
                    }
                }
                this.f16405a.a("CHAT_DELETE_SUCCESS", new com.garena.android.appkit.b.a(com.shopee.app.d.b.a.a(a3, this.f17102f.isMyShop(a3.h()))));
            }
        }
    }

    public static class a extends a.C0253a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f17104a;

        public a(String str) {
            super("DeleteChatInteractor" + str, "use_case", 0, false);
            this.f17104a = str;
        }
    }
}
