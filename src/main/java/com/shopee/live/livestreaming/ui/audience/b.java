package com.shopee.live.livestreaming.ui.audience;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.shopee.live.livestreaming.a.c;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.data.entity.DanmaKuContentEntity;
import com.shopee.live.livestreaming.data.entity.DanmaKuEntity;
import com.shopee.live.livestreaming.data.entity.EtoeMessageItem;
import com.shopee.live.livestreaming.data.entity.LiveAdDataEntity;
import com.shopee.live.livestreaming.data.entity.LiveStreamingSessionEntity;
import com.shopee.live.livestreaming.data.entity.PollingRoomInfoEntity;
import com.shopee.live.livestreaming.data.entity.SessionProductEntity;
import com.shopee.live.livestreaming.data.entity.VoucherEntity;
import com.shopee.live.livestreaming.data.entity.require.VoucherCodeEntity;
import com.shopee.live.livestreaming.network.executor.RetryTask;
import com.shopee.live.livestreaming.network.service.InjectorUtils;
import com.shopee.live.livestreaming.network.task.CommendBanCheckTask;
import com.shopee.live.livestreaming.network.task.ExitLiveTask;
import com.shopee.live.livestreaming.network.task.FollowingCheckTask;
import com.shopee.live.livestreaming.network.task.FollowingPostTask;
import com.shopee.live.livestreaming.network.task.GetLiveSessionTask;
import com.shopee.live.livestreaming.network.task.GetPlayUrlTask;
import com.shopee.live.livestreaming.network.task.JoinLiveTask;
import com.shopee.live.livestreaming.network.task.LiveAdTask;
import com.shopee.live.livestreaming.network.task.PostLikeTask;
import com.shopee.live.livestreaming.network.task.PostReportTask;
import com.shopee.live.livestreaming.sztracking.SZTrackingReporter;
import com.shopee.live.livestreaming.util.d;
import com.shopee.live.livestreaming.util.m;
import com.shopee.live.livestreaming.util.p;
import com.shopee.live.livestreaming.util.x;
import com.shopee.live.livestreaming.util.z;
import com.shopee.sdk.modules.app.e.a;

public class b extends c<interfaceD>  {

    /* renamed from: b  reason: collision with root package name */
    private JoinLiveTask f29000b = InjectorUtils.provideJoinLiveTask();

    /* renamed from: c  reason: collision with root package name */
    private ExitLiveTask f29001c = InjectorUtils.provideExitLiveTask();

    /* renamed from: d  reason: collision with root package name */
    private GetLiveSessionTask f29002d = InjectorUtils.provideGetLiveSessionTask();

    /* renamed from: e  reason: collision with root package name */
    private FollowingCheckTask f29003e = InjectorUtils.provideFollowingCheckTask();

    /* renamed from: f  reason: collision with root package name */
    private FollowingPostTask f29004f = InjectorUtils.provideFollowingPostTask();

    /* renamed from: g  reason: collision with root package name */
    private CommendBanCheckTask f29005g = InjectorUtils.provideDanmakuBanCheckTask();
    private PostLikeTask h = InjectorUtils.providePostLikeTask();
    private PostReportTask i = InjectorUtils.providePostReportTask();
    private GetPlayUrlTask j = InjectorUtils.provideGetPlayUrlTask();
    /* access modifiers changed from: private */
    public m k;
    /* access modifiers changed from: private */
    public Context l;
    /* access modifiers changed from: private */
    public LiveStreamingSessionEntity m;
    /* access modifiers changed from: private */
    public String n;
    private LiveAdTask o = InjectorUtils.provideLiveAdTask();
    private f p;
    /* access modifiers changed from: private */
    public LiveAdDataEntity q;

    public b(Context context) {
        this.k = new m(context);
        this.p = new f();
        this.l = context;
        SZTrackingReporter.getInstance().updateUid(x.f());
    }

    public void a(interfaceD dVar) {
        super.a(dVar);
    }

    public void a() {
        super.a();
        this.l = null;
    }

    /* renamed from: c */
    public interfaceD b() {
        return (interfaceD) super.b();
    }

    public void d() {
        this.k.a((m.a) new m.a() {
            public void a(EtoeMessageItem etoeMessageItem) {
            }

            public void b(EtoeMessageItem etoeMessageItem) {
            }

            public void a(long j, DanmaKuContentEntity danmaKuContentEntity) {
                b.this.b().a(danmaKuContentEntity);
            }

            public void a(DanmaKuEntity danmaKuEntity) {
                b.this.b().a(danmaKuEntity);
            }

            public void a(PollingRoomInfoEntity pollingRoomInfoEntity, SessionProductEntity.ProductItem productItem) {
                b.this.b().a(pollingRoomInfoEntity, productItem);
            }

            public void a(PollingRoomInfoEntity pollingRoomInfoEntity) {
                b.this.b().c();
            }

            public void c(EtoeMessageItem etoeMessageItem) {
                b.this.b().a(etoeMessageItem);
            }

            public void d(EtoeMessageItem etoeMessageItem) {
                if (!d.a(etoeMessageItem.getContent())) {
                    z.a(b.this.l, etoeMessageItem.getContent());
                }
            }

            public void a(VoucherEntity voucherEntity, long j, int i) {
                b.this.a(voucherEntity, j, i);
            }

            public void e(EtoeMessageItem etoeMessageItem) {
                b.this.a(etoeMessageItem);
            }
        });
    }

    public void e() {
        this.k.a();
    }

    public void a(int i2) {
        a a2 = com.shopee.sdk.b.a().d().a();
        final RetryTask retryTask = new RetryTask();
        retryTask.execute(new RetryTask.Data(this.f29000b, new JoinLiveTask.Data(i2, x.c(), p.a(a2.d())), new JoinLiveTask.Callback() {
            public void onSucceess(LiveStreamingSessionEntity liveStreamingSessionEntity) {
                if (liveStreamingSessionEntity == null || d.a(liveStreamingSessionEntity.getSession().getPlay_url())) {
                    retryTask.handleResult(false);
                    return;
                }
                LiveStreamingSessionEntity unused = b.this.m = liveStreamingSessionEntity;
                if (retryTask.handleResult(true)) {
                    b.this.b().a(liveStreamingSessionEntity);
                    String unused2 = b.this.n = liveStreamingSessionEntity.getUsersig();
                    b.this.k.b(b.this.n);
                }
            }

            public void onFailed(int i) {
                retryTask.handleResult(false);
            }
        }), new RetryTask.Callback() {
            public void onSuccess() {
            }

            public void onFailed() {
                z.a(b.this.l, com.garena.android.appkit.tools.b.e(c.g.live_streaming_common_request_failed));
                b.this.b().d();
            }
        });
    }

    public void b(int i2) {
        if (!d.a(this.n)) {
            final RetryTask retryTask = new RetryTask();
            retryTask.execute(new RetryTask.Data(this.f29001c, new ExitLiveTask.Data(i2, x.c(), this.n), new ExitLiveTask.Callback() {
                public void onSuccess() {
                    retryTask.handleResult(true);
                }

                public void onFailed() {
                    retryTask.handleResult(false);
                }
            }), null);
        }
    }

    public void c(int i2) {
        final RetryTask retryTask = new RetryTask();
        retryTask.execute(new RetryTask.Data(this.f29002d, new GetLiveSessionTask.Data(i2), new GetLiveSessionTask.Callback() {
            public void returnSessionInfo(LiveStreamingSessionEntity liveStreamingSessionEntity) {
                if (retryTask.handleResult(true) && liveStreamingSessionEntity != null) {
                    LiveStreamingSessionEntity unused = b.this.m = liveStreamingSessionEntity;
                    b.this.b().b(liveStreamingSessionEntity);
                }
            }

            public void onError(int i) {
                retryTask.handleResult(false);
            }
        }), new RetryTask.Callback() {
            public void onSuccess() {
            }

            public void onFailed() {
                z.a(b.this.l, com.garena.android.appkit.tools.b.e(c.g.live_streaming_common_request_failed));
                b.this.b().d();
            }
        });
    }

    public void d(int i2) {
        this.k.a(i2);
    }

    public void a(String str) {
        this.k.a(str);
    }

    public void a(long j2) {
        this.k.a(j2);
    }

    public void e(int i2) {
        this.f29003e.execute(new FollowingCheckTask.Data(i2), new FollowingCheckTask.Callback() {
            public void onFailed() {
            }

            public void onSuccess(boolean z) {
                b.this.b().a(z);
            }
        });
    }

    public void b(String str) {
        this.k.d(str);
    }

    public void f(int i2) {
        this.f29004f.execute(new FollowingPostTask.Data(i2), null);
    }

    public void g(int i2) {
        this.f29005g.execute(new CommendBanCheckTask.Data(i2), new CommendBanCheckTask.Callback() {
            public void onGeBanStatus(boolean z) {
                EtoeMessageItem etoeMessageItem = new EtoeMessageItem();
                etoeMessageItem.setType(z ? 0 : -1);
                b.this.b().a(etoeMessageItem);
            }
        });
    }

    public void a(int i2, int i3) {
        this.h.execute(new PostLikeTask.Data(i2, i3), new PostLikeTask.Callback() {
            public void onSucceess() {
                b.this.b().h().e();
            }

            public void onFailed(int i) {
                b.this.b().h().d(i);
            }
        });
    }

    public LiveStreamingSessionEntity f() {
        return this.m;
    }

    public void a(LiveStreamingSessionEntity.Session session) {
        this.o.startAdTask(new LiveAdTask.Data(session.getRoom_id(), session.getSession_id()), new LiveAdTask.Callback() {
            public void onPrepare() {
                b bVar = b.this;
                bVar.a(bVar.q);
            }

            public void getAdInfoSucceed(LiveAdDataEntity liveAdDataEntity) {
                b.this.a(liveAdDataEntity);
            }

            public void onError(int i, String str) {
                b bVar = b.this;
                bVar.a(bVar.q);
                com.shopee.e.a.a.b("getAdError", "code:" + i + ", msg:" + str);
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(LiveAdDataEntity liveAdDataEntity) {
        if (liveAdDataEntity == null || !liveAdDataEntity.isCurrentAvailable()) {
            liveAdDataEntity = null;
        }
        this.q = liveAdDataEntity;
        b().a(this.q);
    }

    public void g() {
        this.o.shutDownAdTask();
    }

    public String h() {
        LiveAdDataEntity liveAdDataEntity = this.q;
        if (liveAdDataEntity == null || liveAdDataEntity.getAd_spot() == null || this.q.getAd_spot().getLink_url() == null) {
            return null;
        }
        return this.q.getAd_spot().getLink_url();
    }

    public long i() {
        LiveAdDataEntity liveAdDataEntity = this.q;
        if (liveAdDataEntity == null || liveAdDataEntity.getAd_spot() == null) {
            return -1;
        }
        return this.q.getAd_spot().getAd_spot_id();
    }

    public boolean j() {
        LiveStreamingSessionEntity liveStreamingSessionEntity = this.m;
        return (liveStreamingSessionEntity == null || liveStreamingSessionEntity.getSession() == null || !this.m.getSession().isIs_dynamic_play_url()) ? false : true;
    }

    public void a(int i2, GetPlayUrlTask.Callback callback) {
        this.j.execute(new GetPlayUrlTask.Data(i2), callback);
    }

    /* access modifiers changed from: private */
    public void a(VoucherEntity voucherEntity, long j2, int i2) {
        if (b() != null) {
            b().a(voucherEntity, j2, i2);
        }
    }

    /* access modifiers changed from: private */
    public void a(EtoeMessageItem etoeMessageItem) {
        String content = etoeMessageItem.getContent();
        if (!d.a(etoeMessageItem.getContent())) {
            org.greenrobot.eventbus.c.a().c((VoucherCodeEntity) new Gson().fromJson(content, VoucherCodeEntity.class));
        }
    }

    public void k() {
        this.p.a(SZTrackingReporter.getInstance().getConfigEntity().getSg_viewer_heartbeat_interval());
        this.p.a();
    }

    public void l() {
        SZTrackingReporter.getInstance().reportHeaderBeatEvent();
    }

    public void m() {
        SZTrackingReporter.getInstance().stopLoop();
    }

    public void n() {
        this.p.b();
    }
}
