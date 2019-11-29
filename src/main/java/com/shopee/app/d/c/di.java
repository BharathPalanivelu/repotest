package com.shopee.app.d.c;

import android.text.TextUtils;
import com.path.android.jobqueue.JobManager;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.a.a;
import com.shopee.app.data.store.av;
import com.shopee.app.data.store.p;
import com.shopee.app.database.orm.bean.DBChatMessage;
import com.shopee.app.database.orm.bean.chatP2P.DBChat;
import com.shopee.app.util.g.b;
import com.shopee.app.util.n;

public class di extends com.shopee.app.d.c.a.a<a> {

    /* renamed from: d  reason: collision with root package name */
    private final p f16808d;

    /* renamed from: e  reason: collision with root package name */
    private final JobManager f16809e;

    /* renamed from: f  reason: collision with root package name */
    private final UserInfo f16810f;

    /* renamed from: g  reason: collision with root package name */
    private final av f16811g;

    public di(n nVar, p pVar, av avVar, UserInfo userInfo, JobManager jobManager) {
        super(nVar);
        this.f16808d = pVar;
        this.f16811g = avVar;
        this.f16809e = jobManager;
        this.f16810f = userInfo;
    }

    public void a(String str) {
        b(new a(str));
    }

    /* access modifiers changed from: protected */
    public void a(a aVar) {
        String a2 = aVar.f16812a;
        if (!TextUtils.isEmpty(a2)) {
            DBChatMessage a3 = this.f16808d.a(a2);
            if (a3 != null) {
                a3.a(com.garena.android.appkit.tools.a.a.a());
                a3.f(1);
                this.f16808d.a(a3);
                DBChat a4 = this.f16811g.a(a3.e());
                if (a4 != null) {
                    a4.a(a3.l());
                    a4.g(com.garena.android.appkit.tools.a.a.a());
                    this.f16811g.a(a4);
                }
                this.f16809e.addJobInBackground(new b(a2));
                this.f16405a.a("CHAT_SEND_SUCCESS", new com.garena.android.appkit.b.a(com.shopee.app.d.b.a.a(a3, this.f16810f.isMyShop(a3.h()))));
            }
        }
    }

    public static class a extends a.C0253a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f16812a;

        public a(String str) {
            super("ResendChatInteractor" + str, "use_case", 0, false);
            this.f16812a = str;
        }
    }
}
