package com.shopee.livequiz.ui.b;

import com.appsflyer.share.Constants;
import com.shopee.liveimsdk.custom.a.a;
import com.shopee.livequiz.a.b;
import com.shopee.livequiz.b.e;
import com.shopee.livequiz.c.d;
import com.shopee.livequiz.d.c.a;
import com.shopee.livequiz.d.c.g;
import com.shopee.livequiz.d.c.h;
import com.shopee.livequiz.data.bean.GameData;
import com.shopee.livequiz.data.bean.LiveParams;
import com.shopee.livequiz.g.j;
import com.shopee.livequiz.g.k;
import java.util.Random;

public class a extends b<com.shopee.livequiz.ui.activity.a> {

    /* renamed from: b  reason: collision with root package name */
    private com.shopee.liveimsdk.custom.a f29913b = new com.shopee.liveimsdk.custom.a(this.k);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public com.shopee.liveimsdk.a.a f29914c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public g f29915d = com.shopee.livequiz.d.b.a.c();

    /* renamed from: e  reason: collision with root package name */
    private h f29916e = com.shopee.livequiz.d.b.a.d();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public com.shopee.livequiz.d.c.a f29917f = com.shopee.livequiz.d.b.a.i();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f29918g;
    private k h;
    /* access modifiers changed from: private */
    public long i;
    private com.shopee.liveimsdk.a.b j = new com.shopee.liveimsdk.a.b() {
        public void a(String str) {
        }

        public void b(String str, String str2) {
        }

        public void c(String str) {
        }

        public void a() {
            e.g();
        }

        public void b() {
            a.this.b().a(com.shopee.livequiz.g.e.a().a("t_neg_general_msg"));
            e.a("tencent_im_login_failed");
        }

        public void b(String str) {
            a.this.b().a(com.shopee.livequiz.g.e.a().a("t_neg_general_msg"));
            if (com.shopee.livequiz.data.b.a().b().chatGroup.equals(str)) {
                e.a("tencent_im_join_chatgroup_failed");
            } else if (com.shopee.livequiz.data.b.a().b().issueGroup.equals(str)) {
                e.a("tencent_im_join_issuegroup_failed");
            }
        }

        public void c() {
            a.this.b().a(com.shopee.livequiz.g.e.a().a("t_neg_general_msg"));
            e.a("im_force_offline");
        }

        public void d() {
            a.this.b().a(com.shopee.livequiz.g.e.a().a("t_neg_general_msg"));
            e.a("im_usersig_expired");
        }

        public void a(String str, String str2) {
            com.garena.android.appkit.d.a.b("Danmaku send success: " + str + ", " + str2, new Object[0]);
            a.this.f29917f.b(new a.C0456a("chat_send", com.shopee.livequiz.data.b.a().b().eventId, com.shopee.livequiz.data.b.a().b().sessionId), null);
        }

        public void a(String str, String str2, String str3) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - a.this.i >= 200) {
                long unused = a.this.i = currentTimeMillis;
                a.this.b().a(str, str2, str3);
            }
        }

        public void d(String str) {
            GameData gameData;
            try {
                gameData = (GameData) GameData.fromJson(str, GameData.class);
            } catch (Exception unused) {
                com.garena.android.appkit.d.a.a("onQAReceive fromJson error, " + str, new Object[0]);
                gameData = null;
            }
            if (gameData != null) {
                a.this.b().a(gameData);
            }
        }
    };
    private com.shopee.liveimsdk.custom.b k = new com.shopee.liveimsdk.custom.b() {
        public void onJoinGroupSucceed(String str) {
        }

        public void onLoginSucceed() {
        }

        public void onReceivePublicScreenMessage(com.shopee.liveimsdk.custom.a.a aVar) {
        }

        public void onSendError(String str, String str2) {
        }

        public void onSendSucess(String str, String str2) {
            com.garena.android.appkit.d.a.b("Danmaku send success: " + str + ", " + str2, new Object[0]);
            a.this.f29917f.b(new a.C0456a("chat_send", com.shopee.livequiz.data.b.a().b().eventId, com.shopee.livequiz.data.b.a().b().sessionId), null);
        }

        public void onDanmaKuReceive(a.d dVar) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - a.this.i >= 200) {
                long unused = a.this.i = currentTimeMillis;
                a.this.b().a(dVar.f29595c, dVar.f29596d, dVar.f29597e);
            }
        }

        public void onLoginFailed() {
            a.this.b().a(com.shopee.livequiz.g.e.a().a("t_neg_general_msg"));
        }

        public void onJoinGroupFailed(String str) {
            a.this.b().a(com.shopee.livequiz.g.e.a().a("t_neg_general_msg"));
            e.a("custom_im_join_failed");
        }
    };

    public a() {
        if (h()) {
            this.f29913b.a(com.shopee.livequiz.b.a().c(), com.shopee.livequiz.data.b.a().b().appId);
        }
        if (j()) {
            this.f29914c = new com.shopee.liveimsdk.a.a(this.j);
            this.f29914c.a(com.shopee.livequiz.b.a().c(), com.shopee.livequiz.data.b.a().b().appId);
            this.f29914c.b(!h());
            this.f29914c.a(!i());
        }
    }

    public void a(com.shopee.livequiz.ui.activity.a aVar) {
        super.a(aVar);
        f();
        e();
    }

    public void a() {
        super.a();
        g();
        if (j()) {
            this.f29914c.e();
        }
        if (h()) {
            this.f29913b.e();
        }
    }

    /* renamed from: c */
    public com.shopee.livequiz.ui.activity.a b() {
        return com.shopee.livequiz.g.a.a((com.shopee.livequiz.ui.activity.a) super.b());
    }

    private void e() {
        com.shopee.liveimsdk.b i2 = new com.shopee.liveimsdk.b().a(false).a(com.shopee.sdk.b.a().a().a().c()).b(com.shopee.sdk.b.a().a().a().d()).a(com.shopee.livequiz.g.g.f()).d(com.shopee.livequiz.g.g.e()).f(com.shopee.livequiz.g.g.e()).g(b(com.shopee.livequiz.g.g.g())).e(com.shopee.livequiz.data.b.a().b().userSig).c(com.shopee.livequiz.data.b.a().b().deviceId).h(com.shopee.livequiz.data.b.a().b().chatGroup).i(com.shopee.livequiz.data.b.a().b().issueGroup);
        if (j()) {
            this.f29914c.a(i2);
            this.f29914c.c();
        }
        if (h()) {
            this.f29913b.a(i2);
        }
        this.i = System.currentTimeMillis();
    }

    public void d() {
        if (j()) {
            this.f29914c.a();
        }
        if (h()) {
            this.f29913b.a();
        }
    }

    public void a(String str) {
        final String str2;
        if (!j.a(str)) {
            if (h()) {
                str2 = str;
            } else {
                str2 = j.b(str);
            }
            b().a(com.shopee.livequiz.g.g.e(), b(com.shopee.livequiz.g.g.g()), str);
            if (h()) {
                this.f29913b.a(str2);
            } else {
                this.f29916e.b(new h.a(new com.shopee.livequiz.d.a.b.b(com.shopee.livequiz.data.b.a().b().deviceId, str2)), new d<com.shopee.livequiz.d.a.a.e>() {
                    public void a(com.shopee.livequiz.d.a.a.e eVar) {
                        if (eVar == null || j.a(eVar.f29724a)) {
                            a.this.f29914c.a(str2);
                        } else {
                            a.this.f29914c.a(eVar.f29724a);
                        }
                    }

                    public void a(int i, String str) {
                        a.this.b().a(com.shopee.livequiz.g.g.e(), a.this.b(com.shopee.livequiz.g.g.g()), str2);
                    }
                });
            }
        }
    }

    private void f() {
        if (this.h == null) {
            this.h = new k(new k.a() {
                public void a() {
                    a.this.f29915d.b(new g.a(com.shopee.livequiz.data.b.a().b().chatGroup), new d<com.shopee.livequiz.d.a.a.d>() {
                        public void a(int i, String str) {
                        }

                        public void a(com.shopee.livequiz.d.a.a.d dVar) {
                            String str;
                            boolean z = false;
                            com.garena.android.appkit.d.a.b("LiveQuiz, get member num: " + dVar.f29723a, new Object[0]);
                            try {
                                int parseInt = Integer.parseInt(dVar.f29723a);
                                int i = (int) (((float) com.shopee.livequiz.data.b.a().b().ccuLock) * 0.8f);
                                if (i != 0 && parseInt >= i) {
                                    boolean unused = a.this.f29918g = true;
                                }
                                if (parseInt > com.shopee.livequiz.data.b.a().b().ccuLock) {
                                    z = true;
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            if (a.this.f29918g) {
                                if (z) {
                                    str = com.shopee.livequiz.data.b.a().b().ccuLock + "";
                                } else {
                                    str = dVar.f29723a;
                                }
                                StringBuilder sb = new StringBuilder();
                                sb.append(j.c(str));
                                sb.append(Constants.URL_PATH_DELIMITER);
                                sb.append(j.c(com.shopee.livequiz.data.b.a().b().ccuLock + ""));
                                a.this.b().b(sb.toString());
                                return;
                            }
                            a.this.b().b(j.c(dVar.f29723a));
                        }
                    });
                }
            }, 10000, (long) ((new Random().nextInt(11) + 10) * 1000));
        }
        this.h.a();
    }

    private void g() {
        k kVar = this.h;
        if (kVar != null) {
            kVar.d();
            this.h = null;
        }
    }

    private boolean h() {
        return LiveParams.CHATROOM_SPIM.equals(com.shopee.livequiz.data.b.a().b().chatroomType);
    }

    private boolean i() {
        return !com.shopee.livequiz.data.b.a().b().ifTXCIM;
    }

    private boolean j() {
        return !h() || !i();
    }

    /* access modifiers changed from: private */
    public String b(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        return com.shopee.livequiz.data.a.b.a() + str + "_tn";
    }
}
