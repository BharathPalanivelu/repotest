package com.shopee.live.livestreaming.ui.anchor;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.shopee.live.livestreaming.a.c;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.data.entity.AnchorCoinEntity;
import com.shopee.live.livestreaming.data.entity.DanmaKuContentEntity;
import com.shopee.live.livestreaming.data.entity.DanmaKuEntity;
import com.shopee.live.livestreaming.data.entity.EtoeMessageItem;
import com.shopee.live.livestreaming.data.entity.LiveAdDataEntity;
import com.shopee.live.livestreaming.data.entity.LiveStreamingParam;
import com.shopee.live.livestreaming.data.entity.LiveStreamingSessionEntity;
import com.shopee.live.livestreaming.data.entity.PollingRoomInfoEntity;
import com.shopee.live.livestreaming.data.entity.SessionProductEntity;
import com.shopee.live.livestreaming.data.entity.VoucherEntity;
import com.shopee.live.livestreaming.network.executor.RetryTask;
import com.shopee.live.livestreaming.network.service.InjectorUtils;
import com.shopee.live.livestreaming.network.task.GetCoinGiveOutTask;
import com.shopee.live.livestreaming.network.task.JoinLiveTask;
import com.shopee.live.livestreaming.network.task.LiveAdTask;
import com.shopee.live.livestreaming.sztracking.SZTrackingReporter;
import com.shopee.live.livestreaming.ui.view.TXLiveNetStatusLayout;
import com.shopee.live.livestreaming.ui.view.c.f;
import com.shopee.live.livestreaming.util.a.e;
import com.shopee.live.livestreaming.util.d;
import com.shopee.live.livestreaming.util.i;
import com.shopee.live.livestreaming.util.l;
import com.shopee.live.livestreaming.util.m;
import com.shopee.live.livestreaming.util.o;
import com.shopee.live.livestreaming.util.p;
import com.shopee.live.livestreaming.util.t;
import com.shopee.live.livestreaming.util.u;
import com.shopee.live.livestreaming.util.x;
import com.shopee.live.livestreaming.util.z;
import com.shopee.sdk.b;
import com.shopee.sdk.modules.ui.a.a;
import java.io.File;
import java.lang.ref.WeakReference;

public class a extends c<LiveStreamingAnchorActivity> implements GetCoinGiveOutTask.Callback {

    /* renamed from: b  reason: collision with root package name */
    u f28817b;

    /* renamed from: c  reason: collision with root package name */
    private JoinLiveTask f28818c;

    /* renamed from: d  reason: collision with root package name */
    private GetCoinGiveOutTask f28819d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f28820e = false;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Context f28821f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public f f28822g;
    /* access modifiers changed from: private */
    public m h;
    /* access modifiers changed from: private */
    public LiveStreamingSessionEntity i;
    private int j = 17;
    /* access modifiers changed from: private */
    public l k;
    private LiveAdTask l;
    /* access modifiers changed from: private */
    public TXLiveNetStatusLayout m;
    private boolean n = true;
    /* access modifiers changed from: private */
    public com.shopee.live.livestreaming.util.a.a o;
    /* access modifiers changed from: private */
    public GetCoinGiveOutTask.Data p;
    private boolean q = false;
    private int r = 0;
    /* access modifiers changed from: private */
    public LiveAdDataEntity s;
    private C0440a t;

    public a(Context context, TXLiveNetStatusLayout tXLiveNetStatusLayout) {
        this.f28821f = context;
        this.m = tXLiveNetStatusLayout;
        this.f28817b = new u(this.f28821f);
        this.o = new com.shopee.live.livestreaming.util.a.a(this.f28821f);
        this.f28818c = InjectorUtils.provideJoinLiveTask();
        this.l = InjectorUtils.provideLiveAdTask();
        this.f28819d = InjectorUtils.provideGetCoinGiveOutTask();
        this.h = new m(this.f28821f);
        this.k = new l(this.f28821f);
        this.k.a((l.a) new l.a() {
            public void a() {
                o.a((Activity) a.this.f28821f, com.shopee.live.livestreaming.util.f.a().h(), com.shopee.live.livestreaming.util.f.a().f(), "KOL", a.this.i.getSession().getCover_pic());
            }

            public void a(int i) {
                o.a((Activity) a.this.f28821f);
            }
        });
        q();
        r();
        SZTrackingReporter.getInstance().updateUid(x.f());
    }

    public void c() {
        int f2 = com.shopee.live.livestreaming.util.f.a().f();
        com.shopee.sdk.modules.app.e.a a2 = b.a().d().a();
        final RetryTask retryTask = new RetryTask();
        retryTask.execute(new RetryTask.Data(this.f28818c, new JoinLiveTask.Data(f2, x.c(), p.a(a2.d())), new JoinLiveTask.Callback() {
            public void onSucceess(LiveStreamingSessionEntity liveStreamingSessionEntity) {
                if (liveStreamingSessionEntity == null || d.a(liveStreamingSessionEntity.getUsersig()) || liveStreamingSessionEntity.getSession() == null || d.a(liveStreamingSessionEntity.getSession().getPush_url())) {
                    retryTask.handleResult(false);
                } else if (retryTask.handleResult(true) && a.this.f28817b.c((Activity) a.this.f28821f) && a.this.f28817b.d((Activity) a.this.f28821f)) {
                    a.this.h.b(liveStreamingSessionEntity.getUsersig());
                    a.this.o.a(liveStreamingSessionEntity.getSession().getSession_id());
                    GetCoinGiveOutTask.Data unused = a.this.p = new GetCoinGiveOutTask.Data(liveStreamingSessionEntity.getSession().getSession_id());
                    int status = liveStreamingSessionEntity.getSession().getStatus();
                    if (status == 0) {
                        ((LiveStreamingAnchorActivity) a.this.b()).a(liveStreamingSessionEntity);
                    } else if (status == 1) {
                        ((LiveStreamingAnchorActivity) a.this.b()).b(liveStreamingSessionEntity);
                    } else if (status == 2) {
                        ((LiveStreamingAnchorActivity) a.this.b()).c(liveStreamingSessionEntity);
                    }
                }
            }

            public void onFailed(int i) {
                retryTask.handleResult(false);
            }
        }), new RetryTask.Callback() {
            public void onSuccess() {
            }

            public void onFailed() {
                z.a(a.this.f28821f, com.garena.android.appkit.tools.b.e(c.g.live_streaming_common_request_failed));
                ((Activity) a.this.f28821f).finish();
            }
        });
    }

    public void d() {
        this.f28819d.startGiveOutTask(this.p, this);
    }

    public void a(String str) {
        if (!d.a(str)) {
            this.h.c(str);
        }
    }

    public void onCoinSuccess(AnchorCoinEntity anchorCoinEntity) {
        if (b() != null && anchorCoinEntity != null) {
            ((LiveStreamingAnchorActivity) b()).a(anchorCoinEntity);
            this.q = true;
        }
    }

    public void onCoinError(int i2, String str) {
        if (!this.q && b() != null) {
            ((LiveStreamingAnchorActivity) b()).a((AnchorCoinEntity) null);
        }
    }

    public void e() {
        this.h.a((m.a) new m.a() {
            public void a(VoucherEntity voucherEntity, long j, int i) {
            }

            public void c(EtoeMessageItem etoeMessageItem) {
            }

            public void e(EtoeMessageItem etoeMessageItem) {
            }

            public void a(long j, DanmaKuContentEntity danmaKuContentEntity) {
                if (((long) x.f()) != j) {
                    ((LiveStreamingAnchorActivity) a.this.b()).a(danmaKuContentEntity);
                }
            }

            public void a(DanmaKuEntity danmaKuEntity) {
                ((LiveStreamingAnchorActivity) a.this.b()).a(danmaKuEntity);
            }

            public void a(PollingRoomInfoEntity pollingRoomInfoEntity, SessionProductEntity.ProductItem productItem) {
                ((LiveStreamingAnchorActivity) a.this.b()).a(pollingRoomInfoEntity);
            }

            public void a(PollingRoomInfoEntity pollingRoomInfoEntity) {
                o.a((Activity) a.this.f28821f, com.shopee.live.livestreaming.util.f.a().h(), com.shopee.live.livestreaming.util.f.a().f(), "KOL", a.this.i.getSession().getCover_pic());
            }

            public void a(EtoeMessageItem etoeMessageItem) {
                b.i();
                if (!d.a(etoeMessageItem.getContent())) {
                    if (a.this.f28822g == null) {
                        a aVar = a.this;
                        f unused = aVar.f28822g = new f((Activity) aVar.f28821f);
                    } else if (a.this.f28822g.b()) {
                        a.this.f28822g.c();
                    }
                    a.this.f28822g.a(false);
                    a.this.f28822g.a(etoeMessageItem.getContent());
                    a.this.f28822g.a();
                }
            }

            public void b(EtoeMessageItem etoeMessageItem) {
                b.j();
                o.a((Activity) a.this.f28821f, com.shopee.live.livestreaming.util.f.a().h(), com.shopee.live.livestreaming.util.f.a().f(), "KOL", a.this.i.getSession().getCover_pic());
            }

            public void d(EtoeMessageItem etoeMessageItem) {
                if (!d.a(etoeMessageItem.getContent())) {
                    z.a(a.this.f28821f, etoeMessageItem.getContent());
                }
            }
        });
    }

    public void f() {
        this.h.a();
    }

    public void a(LiveStreamingSessionEntity.Session session) {
        this.l.startAdTask(new LiveAdTask.Data(session.getRoom_id(), session.getSession_id()), new LiveAdTask.Callback() {
            public void onPrepare() {
                a aVar = a.this;
                aVar.a(aVar.s);
            }

            public void getAdInfoSucceed(LiveAdDataEntity liveAdDataEntity) {
                a.this.a(liveAdDataEntity);
            }

            public void onError(int i, String str) {
                a aVar = a.this;
                aVar.a(aVar.s);
                com.shopee.e.a.a.b("getAdError", "code:" + i + ", msg:" + str);
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(LiveAdDataEntity liveAdDataEntity) {
        if (liveAdDataEntity == null || !liveAdDataEntity.isCurrentAvailable()) {
            liveAdDataEntity = null;
        }
        this.s = liveAdDataEntity;
        ((LiveStreamingAnchorActivity) b()).a(this.s);
    }

    public void g() {
        this.l.shutDownAdTask();
    }

    public void h() {
        this.f28819d.shutGiveOutTask();
    }

    public void a(LiveStreamingAnchorActivity liveStreamingAnchorActivity) {
        super.a(liveStreamingAnchorActivity);
    }

    public void a() {
        super.a();
    }

    public void a(Activity activity) {
        if (!this.f28820e) {
            if (Build.VERSION.SDK_INT >= 23) {
                u uVar = this.f28817b;
                if (uVar != null) {
                    uVar.a(activity, (u.a) new u.a() {
                        public void a() {
                            if (a.this.b() != null) {
                                ((LiveStreamingAnchorActivity) a.this.b()).g();
                            }
                            boolean unused = a.this.f28820e = true;
                        }
                    });
                }
            } else if (b() != null) {
                ((LiveStreamingAnchorActivity) b()).g();
                this.f28820e = true;
            }
        }
    }

    public boolean i() {
        return this.f28820e;
    }

    public void a(LiveStreamingSessionEntity liveStreamingSessionEntity) {
        this.i = liveStreamingSessionEntity;
        this.k.a(liveStreamingSessionEntity);
        LiveStreamingSessionEntity.Session session = liveStreamingSessionEntity.getSession();
        if (session != null) {
            this.h.a(session.getChatroom_id());
            this.h.a(session.getSession_id());
            this.h.a(session.getCreate_time() / 1000);
            a(liveStreamingSessionEntity.getSession());
            com.shopee.live.livestreaming.util.f.a().c(session.getRoom_id());
        }
    }

    public boolean j() {
        int i2 = this.j;
        if (i2 == 17 || i2 != 18) {
            return false;
        }
        b.a().c().a((Activity) this.f28821f, new a.C0472a().c(com.garena.android.appkit.tools.b.e(c.g.live_streaming_btn_confirm)).d(com.garena.android.appkit.tools.b.e(c.g.live_streaming_btn_cancel)).b(com.garena.android.appkit.tools.b.e(c.g.live_streaming_host_terminate_the_streaming_tip)).a(), new com.shopee.sdk.f.b<Integer>() {
            public void a(int i, String str) {
            }

            public void a(Integer num) {
                int intValue = num.intValue();
                if (intValue == 0) {
                    return;
                }
                if (intValue == 1) {
                    a.this.k.a(0);
                }
            }
        });
        return true;
    }

    public long a(long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis > j2) {
            return currentTimeMillis - j2;
        }
        return 0;
    }

    public void a(LiveStreamingParam liveStreamingParam) {
        if (liveStreamingParam != null) {
            com.shopee.live.livestreaming.util.f.a().b(liveStreamingParam.getSessionId());
            com.shopee.live.livestreaming.util.f.a().c(liveStreamingParam.getEndPageUrl());
            com.shopee.live.livestreaming.util.f.a().e(liveStreamingParam.getShareUrl());
            com.shopee.live.livestreaming.util.f.a().d(liveStreamingParam.getProductSelectUrl());
        }
    }

    public void k() {
        this.j = 17;
    }

    public void l() {
        this.j = 18;
    }

    public void b(String str) {
        if ("debug-open".equals(str)) {
            p();
            this.n = true;
        } else if ("debug-close".equals(str)) {
            this.n = false;
            com.shopee.live.livestreaming.b.b().a().setTXLogEnable(false);
            this.m.setVisibility(8);
        }
    }

    private void p() {
        if (androidx.core.app.a.b(this.f28821f, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            com.shopee.live.livestreaming.b.b().a().setTXLogEnable(true);
            this.m.setVisibility(0);
            return;
        }
        t.a().a((Activity) this.f28821f, new t.b() {
            public void a(String str, boolean z) {
            }

            public void a(String str) {
                com.shopee.live.livestreaming.b.b().a().setTXLogEnable(true);
                a.this.m.setVisibility(0);
            }
        });
    }

    public void a(Bundle bundle) {
        String str;
        if (this.m.getVisibility() != 8 && bundle != null) {
            int i2 = 0;
            LiveStreamingSessionEntity liveStreamingSessionEntity = this.i;
            if (liveStreamingSessionEntity != null) {
                String push_url = liveStreamingSessionEntity.getSession().getPush_url();
                str = push_url;
                i2 = this.i.getSession().getSession_id();
            } else {
                str = "";
            }
            this.m.a(bundle, i2, str);
        }
    }

    public void b(Bundle bundle) {
        if (this.n && bundle != null) {
            this.o.a(e.a(bundle));
        }
    }

    public void a(int i2, String str, String str2) {
        if (this.n) {
            this.o.b(i2 + "   " + str + "   " + str2 + "   " + i.a() + "\n");
        }
    }

    private void q() {
        if (this.o != null) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            this.o.a(new File(externalStorageDirectory.getAbsolutePath() + File.separator + "ShopeeLiveStreamingLogs"));
        }
    }

    public void a(d dVar) {
        if (dVar != null) {
            if (this.r != SZTrackingReporter.getInstance().getConfigEntity().getSei_timestamp_send_interval_base_on_netstatus_count()) {
                int i2 = this.r;
                if (i2 != -1) {
                    this.r = i2 + 1;
                    return;
                }
            }
            dVar.a(String.valueOf(System.currentTimeMillis()));
            this.r = 0;
        }
    }

    private void r() {
        this.n = com.shopee.live.livestreaming.b.b().a().ifTXLogEnable();
    }

    public void m() {
        this.o.a();
        o();
    }

    public void n() {
        if (this.t == null) {
            this.t = new C0440a(this);
        }
        this.t.sendEmptyMessageDelayed(1, 180000);
    }

    public void o() {
        C0440a aVar = this.t;
        if (aVar != null) {
            aVar.removeCallbacksAndMessages((Object) null);
        }
    }

    /* renamed from: com.shopee.live.livestreaming.ui.anchor.a$a  reason: collision with other inner class name */
    static class C0440a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<a> f28832a;

        C0440a(a aVar) {
            this.f28832a = new WeakReference<>(aVar);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                WeakReference<a> weakReference = this.f28832a;
                if (weakReference != null && weakReference.get() != null) {
                    z.b(com.shopee.live.livestreaming.b.b().f28742b, "end-live....");
                    ((a) this.f28832a.get()).k.a(1);
                }
            }
        }
    }
}
