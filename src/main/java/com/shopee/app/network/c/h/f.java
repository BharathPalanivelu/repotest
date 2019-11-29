package com.shopee.app.network.c.h;

import android.util.Pair;
import com.path.android.jobqueue.JobManager;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserExtraInfo;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.aa;
import com.shopee.app.data.store.al;
import com.shopee.app.data.store.be;
import com.shopee.app.data.viewmodel.MeCounter;
import com.shopee.app.g.r;
import com.shopee.app.h.m;
import com.shopee.app.h.o;
import com.shopee.app.network.c.c;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.bg;
import com.shopee.app.network.d.bk;
import com.shopee.app.network.d.f.h;
import com.shopee.app.network.d.w;
import com.shopee.app.pushnotification.d;
import com.shopee.app.react.g;
import com.shopee.app.ui.follow.following.i;
import com.shopee.app.util.am;
import com.shopee.app.util.n;
import com.shopee.app.web.WebRegister;
import com.shopee.protocol.action.ResponseCommon;
import java.io.IOException;

public class f extends c implements com.shopee.app.network.a.a<ResponseCommon> {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f17922a = false;

    public int a() {
        return 13;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) com.shopee.app.network.f.f18486a.parseFrom(bArr, 0, i, ResponseCommon.class);
        c(responseCommon.requestid);
        c().a(responseCommon, 1);
    }

    private a c() {
        return ar.f().e().newLoginProcessor();
    }

    public void a(String str) {
        ResponseCommon.Builder builder = new ResponseCommon.Builder();
        builder.errcode = -100;
        c().a(builder.build());
    }

    public Pair<String, ResponseCommon> a(byte[] bArr) throws IOException {
        ResponseCommon responseCommon = (ResponseCommon) com.shopee.app.network.f.f18486a.parseFrom(bArr, 0, bArr.length, ResponseCommon.class);
        return new Pair<>(responseCommon.requestid, responseCommon);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final n f17923a;

        /* renamed from: b  reason: collision with root package name */
        private final al f17924b;

        /* renamed from: c  reason: collision with root package name */
        private final am f17925c;

        /* renamed from: d  reason: collision with root package name */
        private final JobManager f17926d;

        /* renamed from: e  reason: collision with root package name */
        private final ar f17927e;

        /* renamed from: f  reason: collision with root package name */
        private final UserInfo f17928f;

        public a(n nVar, al alVar, UserInfo userInfo, JobManager jobManager, am amVar, ar arVar) {
            this.f17923a = nVar;
            this.f17924b = alVar;
            this.f17928f = userInfo;
            this.f17926d = jobManager;
            this.f17925c = amVar;
            this.f17927e = arVar;
        }

        public void a(ResponseCommon responseCommon, int i) {
            if (b(responseCommon)) {
                this.f17926d.start();
                this.f17925c.a();
                r.a(responseCommon, i);
                UserInfo a2 = this.f17924b.a();
                com.shopee.app.d.b.b.a(responseCommon, this.f17928f, i);
                this.f17928f.setLoginMethod(i);
                this.f17928f.setFbLogin(i);
                this.f17924b.a(this.f17928f);
                if (responseCommon.phone_auto_converted != null && responseCommon.phone_auto_converted.booleanValue()) {
                    this.f17924b.e(true);
                }
                if (a2.getUserId() != this.f17928f.getUserId()) {
                    com.shopee.app.database.b.f().e();
                    com.shopee.app.database.b.f().A();
                    this.f17927e.a(this.f17928f);
                    this.f17927e.f6920a = null;
                    g.a().j();
                    com.garena.reactpush.c.g.f8359a.clear();
                    com.shopee.app.i.a.a().c();
                    this.f17927e.e().settingConfigStore().fetchEditConfig();
                    this.f17923a.a("NEW_LOGIN", (com.garena.android.appkit.b.a) new com.shopee.app.ui.auth.b.c(responseCommon.requestid));
                } else {
                    this.f17923a.a("LOGIN_SUCCESS", new com.garena.android.appkit.b.a());
                }
                if (i == 0) {
                    this.f17923a.a("FACEBOOK_LOGIN_SUCCESS", new com.garena.android.appkit.b.a(responseCommon));
                } else if (i == 3) {
                    this.f17923a.a("LINE_LOGIN_SUCCESS", new com.garena.android.appkit.b.a(responseCommon));
                }
                ar.f().e().newLoginSubProcessor().a(responseCommon, i);
                WebRegister.notifyRNAppEvent("Login", "");
                com.shopee.app.network.http.b.a.c();
            }
        }

        public void a(ResponseCommon responseCommon) {
            int intValue = responseCommon.errcode.intValue();
            if (intValue == 11 || intValue == 36) {
                m.a(true);
            }
            this.f17923a.a("LOGIN_FAIL", new com.garena.android.appkit.b.a(new com.shopee.app.network.c.d.a(responseCommon.errcode.intValue(), responseCommon.err_message, responseCommon)));
        }

        private boolean b(ResponseCommon responseCommon) {
            boolean z = responseCommon.errcode.intValue() == 0;
            if (!z) {
                a(responseCommon);
            }
            return z;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final UserInfo f17929a;

        /* renamed from: b  reason: collision with root package name */
        private final aa f17930b;

        /* renamed from: c  reason: collision with root package name */
        private final com.shopee.app.d.c.am f17931c;

        /* renamed from: d  reason: collision with root package name */
        private final i f17932d;

        /* renamed from: e  reason: collision with root package name */
        private final ChatBadgeStore f17933e;

        /* renamed from: f  reason: collision with root package name */
        private final com.shopee.app.d.c.f.m f17934f;

        /* renamed from: g  reason: collision with root package name */
        private final al f17935g;
        private SettingConfigStore h;
        private MeCounter i;

        public b(UserInfo userInfo, aa aaVar, al alVar, com.shopee.app.d.c.am amVar, i iVar, SettingConfigStore settingConfigStore, com.shopee.app.d.c.f.m mVar, ChatBadgeStore chatBadgeStore, MeCounter meCounter, n nVar) {
            this.f17930b = aaVar;
            this.f17929a = userInfo;
            this.f17935g = alVar;
            this.f17931c = amVar;
            this.f17932d = iVar;
            this.h = settingConfigStore;
            this.f17934f = mVar;
            this.f17933e = chatBadgeStore;
            this.i = meCounter;
        }

        public void a(ResponseCommon responseCommon, int i2) {
            UserExtraInfo userExtraInfo = new UserExtraInfo();
            com.shopee.app.d.b.b.a(responseCommon, userExtraInfo);
            new bk().a(this.f17930b.d(), this.f17930b.e(), com.shopee.app.util.c.a().c(), this.f17930b.h(), this.f17930b.f(), this.f17930b.b());
            be uiStatusStore = ar.f().e().uiStatusStore();
            if (uiStatusStore.w() == 0) {
                uiStatusStore.d(com.shopee.app.d.b.b.a(responseCommon.timestamp, com.garena.android.appkit.tools.a.a.a()));
            }
            f.f17922a = true;
            this.f17931c.a();
            this.f17932d.a();
            az f2 = o.a().f(responseCommon.requestid);
            if (i2 == 0) {
                if ((f2 instanceof com.shopee.app.network.d.f.f) && ((com.shopee.app.network.d.f.f) f2).b()) {
                    this.f17930b.b("");
                }
            } else if (f2 instanceof h) {
                h hVar = (h) f2;
                if (hVar.b()) {
                    this.f17930b.b(hVar.c());
                }
            }
            d.a(this.h.getAllowGCM(), this.f17929a, this.f17930b);
            this.i.setCartCount(userExtraInfo.getCartItemCount());
            new w().g();
            for (Pair next : this.f17933e.getChatsNeedClear()) {
                new bg().a(((Integer) next.first).intValue(), ((Long) next.second).longValue());
            }
            for (Integer intValue : this.f17933e.getUnreadNotSynced()) {
                new bg().a(intValue.intValue(), -1);
            }
            this.f17934f.a();
            ar.f().e().stickerManager().a().b();
            if (f2 instanceof com.shopee.app.network.d.f.b) {
                return;
            }
            if (com.shopee.app.util.p.a.f26481a.a()) {
                new com.shopee.app.network.d.d.b.a().a(this.f17929a.getUserId());
            } else {
                com.garena.android.appkit.d.a.e("Skip SyncLoginInfo since TongdunSDK is not enabled", new Object[0]);
            }
        }
    }
}
