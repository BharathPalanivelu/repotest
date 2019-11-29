package com.shopee.live.livestreaming.ui.audience.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.google.a.o;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.live.livestreaming.b;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.data.entity.LiveStreamingSessionEntity;
import com.shopee.live.livestreaming.data.entity.VoucherEntity;
import com.shopee.live.livestreaming.data.entity.param.AudiencePageParams;
import com.shopee.live.livestreaming.network.task.GetPlayUrlTask;
import com.shopee.live.livestreaming.sztracking.SZTrackingReporter;
import com.shopee.live.livestreaming.sztracking.proto.GeneralAction;
import com.shopee.live.livestreaming.ui.anchor.view.PublicScreenView;
import com.shopee.live.livestreaming.ui.anchor.view.VoucherStickerItemView;
import com.shopee.live.livestreaming.ui.audience.a;
import com.shopee.live.livestreaming.ui.audience.classA;
import com.shopee.live.livestreaming.ui.floatwindow.service.FloatVideoService;
import com.shopee.live.livestreaming.ui.view.TXLiveNetStatusLayout;
import com.shopee.live.livestreaming.ui.view.c.e;
import com.shopee.live.livestreaming.ui.view.c.i;
import com.shopee.live.livestreaming.util.a.c;
import com.shopee.live.livestreaming.util.d;
import com.shopee.live.livestreaming.util.f;
import com.shopee.sdk.modules.ui.navigator.NavigationPath;
import com.shopee.sdk.modules.ui.navigator.options.PushOption;
import com.tencent.rtmp.ITXLiveBaseListener;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLiveBase;

public class LiveStreamingAudienceActivity extends com.shopee.live.livestreaming.ui.audience.activity.BaseLiveStreamingActivity implements PublicScreenView.a {
    public static String N = "ShopeeLiveStreamingShow";
    c O;
    /* access modifiers changed from: private */
    public String P;
    private String Q;
    private String R;
    /* access modifiers changed from: private */
    public i S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    private int X;
    private boolean Y = true;
    /* access modifiers changed from: private */
    public boolean Z = false;
    private classA aa;

    public void z_() {
        AudiencePageParams audiencePageParams = (AudiencePageParams) a(AudiencePageParams.class);
        this.t = audiencePageParams.getSessionId();
        this.u = audiencePageParams.getShareUrl();
        this.Q = audiencePageParams.getEndPageUrl();
        this.R = audiencePageParams.getSource();
        int i = 0;
        this.w = false;
        com.shopee.live.livestreaming.ui.a aVar = new com.shopee.live.livestreaming.ui.a(this.f28744a);
        this.aa = new classA(this.audienceCoinView, this.audienceCoinView);
        this.audienceCoinView.setAudienceCheckInCoinPresenter(this.aa);
        this.audienceCoinView.setFragmentManager(getSupportFragmentManager());
        this.audienceCoinView.setApplication(getApplication());
        f.a().b(this.t);
        f.a().c(this.Q);
        f.a().b(audiencePageParams.getSource());
        f.a().e(this.u);
        this.adView.setClickable(true);
        super.z_();
        this.voucherStickerItemView.setVoucherCallback(new VoucherStickerItemView.a() {
            public void a() {
            }

            public void b() {
            }
        });
        this.publicScreenView.setVoucherStickerClickCallback(this);
        this.livePageShowProductView.d();
        this.l.setVisibility(8);
        this.cleanableLayout.a((Context) this);
        this.cleanableLayout.b(this.publicScreenView);
        this.cleanableLayout.b(this.flowLikeLayout);
        this.cleanableLayout.b(this.audienceBottomView);
        this.cleanableLayout.b(this.livePageShowProductView);
        this.cleanableLayout.b(this.adView);
        this.cleanableLayout.b(this.audienceCoinView);
        this.cleanableLayout.b(this.livePageAnchorInfoView);
        p();
        this.cleanableLayout.setPageSize((float) w.a(this));
        u();
        aVar.a();
        TXLiveNetStatusLayout tXLiveNetStatusLayout = this.txLiveNetStatusLayout;
        if (!b.b().a().ifTXLogEnable()) {
            i = 8;
        }
        tXLiveNetStatusLayout.setVisibility(i);
    }

    private void p() {
        ViewGroup viewGroup = (ViewGroup) this.livePageTitleView.findViewById(c.e.title_layout);
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getId() != c.e.iv_page_close) {
                this.cleanableLayout.b(childAt);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.U) {
            c();
            return;
        }
        this.V = false;
        if (this.W) {
            this.txVideoLayout.a();
            com.shopee.live.livestreaming.ui.audience.a.a.a().e();
            com.shopee.live.livestreaming.ui.audience.c.r();
        }
        if (this.W && !this.Y) {
            com.shopee.live.livestreaming.ui.audience.c.a(true, false);
        }
        this.W = true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.V = true;
        if (!this.y) {
            if (!this.z) {
                com.shopee.live.livestreaming.ui.audience.a.a.a().d();
                this.imageView.setVisibility(8);
            }
            if (!isFinishing()) {
                com.shopee.live.livestreaming.ui.audience.c.q();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void e() {
        if (this.z) {
            com.shopee.live.livestreaming.ui.audience.a.a.a().d();
            this.imageView.setVisibility(8);
        }
    }

    public void b() {
        super.b();
        if (com.shopee.live.livestreaming.ui.audience.a.a.b()) {
            if (this.floatVideoServiceBinder != null) {
                this.floatVideoServiceBinder.a();
            }
            com.shopee.live.livestreaming.ui.audience.a.a.a().g();
            stopService(new Intent(this, FloatVideoService.class));
            com.shopee.live.livestreaming.ui.audience.a.a.j();
            SZTrackingReporter.getInstance().reportGeneralEvent(GeneralAction.ACTION_DISCONNECTED_ACTIVE.getValue(), false);
        }
        this.s.e();
        if (this.s.f() != null && !this.s.f().isCcu_limit()) {
            this.s.b(this.s.f().getSession().getSession_id());
        }
        this.audienceCoinView.b();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.T = true;
        if (!this.Y) {
            com.shopee.live.livestreaming.ui.audience.c.s();
        }
        this.dotsLoadingView.b();
        this.wrapLoadingView.b();
        this.C.a();
        this.voucherStickerItemView.c();
        com.shopee.live.livestreaming.util.a.c cVar = this.O;
        if (cVar != null) {
            unregisterReceiver(cVar);
        }
        this.s.n();
        this.s.m();
        SZTrackingReporter.getInstance().reportLagEvent();
        SZTrackingReporter.getInstance().saveCacheToDB();
        SZTrackingReporter.getInstance().reportGeneralEvent(GeneralAction.ACTION_LEAVE_ROOM.getValue(), false);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null && intent.getBooleanExtra("cart_panel_showing", false)) {
            q();
        }
    }

    public void l() {
        super.l();
        if (!this.y) {
            if (this.z) {
                Intent intent = new Intent(this, LiveStreamingAudienceActivity.class);
                intent.addFlags(335544320);
                intent.putExtra("cart_panel_showing", true);
                startActivity(intent);
                return;
            }
            q();
        }
    }

    private void q() {
        LiveStreamingSessionEntity f2 = this.s.f();
        boolean z = true;
        if (f2 == null || f2.getSession() == null) {
            com.shopee.sdk.b.a().e().a((Activity) this.f28744a, NavigationPath.a(this.Q), (o) null, PushOption.a(1));
            return;
        }
        LiveStreamingSessionEntity.Session session = f2.getSession();
        long maximum_can_show_items = f2.getMaximum_can_show_items();
        long memberCount = this.livePageAnchorInfoView.getMemberCount();
        String nickname = session.getNickname();
        if (d.a(nickname)) {
            nickname = session.getUsername();
        }
        o.a.C0448a d2 = new o.a.C0448a().a("guest").b(session.getCover_pic()).a(session.getSession_id()).b(session.getShop_id()).c(session.getAvatar()).d(nickname).c(session.getItems_cnt()).e(session.getTitle()).d(session.getUid());
        if (memberCount > maximum_can_show_items) {
            z = false;
        }
        com.shopee.live.livestreaming.util.o.a(this, this.Q, d2.a(z).f(this.R).a());
    }

    public void c() {
        super.c();
        if (this.V) {
            this.U = true;
        }
        l();
    }

    public void a(VoucherEntity voucherEntity, long j, int i) {
        if (!this.voucherStickerItemView.e()) {
            if (voucherEntity == null || voucherEntity.getPromotion_id() == 0) {
                this.voucherStickerItemView.a();
                this.voucherStickerItemView.b();
                return;
            }
            long currentTimeMillis = (System.currentTimeMillis() / 1000) - j;
            if (currentTimeMillis <= 0) {
                currentTimeMillis = 0;
            }
            int i2 = (int) (((long) i) - currentTimeMillis);
            if (i2 <= 0) {
                this.voucherStickerItemView.a();
                this.voucherStickerItemView.b();
            } else if (!this.voucherStickerItemView.b(voucherEntity)) {
                this.voucherStickerItemView.a(i2, voucherEntity, j, i);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void c(LiveStreamingSessionEntity liveStreamingSessionEntity) {
        if (liveStreamingSessionEntity.isCcu_limit()) {
            e eVar = new e(this);
            eVar.a(com.garena.android.appkit.tools.b.e(c.g.live_streaming_viewer_viewerlimit_popup), com.garena.android.appkit.tools.b.e(c.g.live_streaming_viewer_viewerlimit_btn_ok), new e.a() {
                public void a(e eVar) {
                    LiveStreamingAudienceActivity.this.d();
                }
            });
            eVar.k();
            eVar.a();
            return;
        }
        this.livePageTitleView.setVisibility(0);
        this.livePageAnchorInfoView.setVisibility(0);
        this.livePageShowProductView.setVisibility(0);
        this.publicScreenView.setVisibility(0);
        this.audienceBottomView.setVisibility(0);
        if (liveStreamingSessionEntity.getSession() != null) {
            this.s.a(liveStreamingSessionEntity.getSession());
            f.a().c(liveStreamingSessionEntity.getSession().getRoom_id());
        }
        super.c(liveStreamingSessionEntity);
        int status = liveStreamingSessionEntity.getSession().getStatus();
        if (status == 0) {
            d();
        } else if (status == 1) {
            a(liveStreamingSessionEntity.getSession().getPlay_url());
            this.s.g(liveStreamingSessionEntity.getSession().getSession_id());
            this.s.a(liveStreamingSessionEntity.getSession().getChatroom_id());
            this.s.a(liveStreamingSessionEntity.getSession().getCreate_time() / 1000);
            this.s.d();
            this.aa.a(liveStreamingSessionEntity.getSession());
            boolean z = this.Y;
            com.shopee.live.livestreaming.ui.audience.c.a(!z, z);
            this.Y = false;
            f.a().h(liveStreamingSessionEntity.getSession().getPlay_url());
            this.s.k();
            this.s.l();
        } else if (status == 2) {
            l();
        }
    }

    /* access modifiers changed from: protected */
    public void a(String str) {
        this.P = str;
        com.shopee.live.livestreaming.util.z.a();
        ITXLivePlayListener r0 = new ITXLivePlayListener() {
            public void onPlayEvent(int i, Bundle bundle) {
                if (i == -2301) {
                    if (LiveStreamingAudienceActivity.this.s.j()) {
                        LiveStreamingAudienceActivity.this.s.a(LiveStreamingAudienceActivity.this.t, (GetPlayUrlTask.Callback) new GetPlayUrlTask.Callback() {
                            public void onResolve(String str) {
                                String unused = LiveStreamingAudienceActivity.this.P = str;
                                f.a().h(LiveStreamingAudienceActivity.this.P);
                                LiveStreamingAudienceActivity.this.r();
                                com.shopee.e.a.a.a((Object) "LiveStreamingAudienceActivity: get new play url-" + LiveStreamingAudienceActivity.this.P);
                            }

                            public void onReject(int i, String str) {
                                LiveStreamingAudienceActivity.this.r();
                            }
                        });
                    } else {
                        LiveStreamingAudienceActivity.this.r();
                    }
                    SZTrackingReporter.getInstance().checkWeakNetwork();
                    SZTrackingReporter.getInstance().reportGeneralEvent(GeneralAction.ACTION_DISCONNECTED_PASSIVE.getValue(), false);
                } else if (i == 2001) {
                    SZTrackingReporter.getInstance().reportGeneralEvent(GeneralAction.ACTION_CONNECTED_STREAM.getValue(), false);
                } else if (i == 2009) {
                    float f2 = (float) bundle.getInt("EVT_PARAM1", 0);
                    float f3 = (float) bundle.getInt("EVT_PARAM2", 0);
                    LiveStreamingAudienceActivity.this.a(f2, f3);
                    if (f3 > BitmapDescriptorFactory.HUE_RED) {
                        com.shopee.live.livestreaming.ui.audience.a.a.a().a(f2 / f3);
                    }
                } else if (i == 2012) {
                    SZTrackingReporter.getInstance().dealContentDelayEvent(bundle);
                } else if (i != 2101) {
                    if (i == 2103) {
                        LiveStreamingAudienceActivity.this.s();
                    } else if (i != 2105) {
                        if (i == 2003) {
                            SZTrackingReporter.getInstance().notifyConnectSucceed();
                            SZTrackingReporter.getInstance().reportFirstFrameEvent();
                        } else if (i == 2004) {
                            if (com.shopee.live.livestreaming.util.y.a()) {
                                com.shopee.live.livestreaming.util.z.a((Context) LiveStreamingAudienceActivity.this, c.g.live_streaming_viewer_cellular_network_warm_tip);
                            }
                            if (LiveStreamingAudienceActivity.this.S != null && LiveStreamingAudienceActivity.this.S.b()) {
                                LiveStreamingAudienceActivity.this.S.c();
                            }
                            LiveStreamingAudienceActivity.this.dotsLoadingView.b();
                            LiveStreamingAudienceActivity.this.t();
                        } else if (i != 2006) {
                        }
                    }
                } else if (!LiveStreamingAudienceActivity.this.Z) {
                    boolean unused = LiveStreamingAudienceActivity.this.Z = true;
                    com.shopee.live.livestreaming.ui.audience.a.a.a().d();
                    com.garena.android.appkit.f.f.a().a(new Runnable() {
                        public void run() {
                            com.shopee.live.livestreaming.ui.audience.a.a.a().e();
                            boolean unused = LiveStreamingAudienceActivity.this.Z = false;
                        }
                    }, 200);
                }
                if (i != 2005) {
                    com.shopee.live.livestreaming.ui.audience.c.a(i, b.b().b().d(String.valueOf(i)));
                    SZTrackingReporter.getInstance().reportPlayExceptionEvent(i);
                }
            }

            public void onNetStatus(Bundle bundle) {
                if (LiveStreamingAudienceActivity.this.txLiveNetStatusLayout.getVisibility() != 8) {
                    LiveStreamingSessionEntity f2 = LiveStreamingAudienceActivity.this.s.f();
                    String str = "";
                    if (!(f2 == null || f2.getSession() == null)) {
                        str = f2.getSession().getPlay_url();
                    }
                    LiveStreamingAudienceActivity.this.txLiveNetStatusLayout.a(bundle, LiveStreamingAudienceActivity.this.t, str);
                }
                com.shopee.live.livestreaming.ui.audience.c.a(LiveStreamingAudienceActivity.this.f28744a, bundle);
                LiveStreamingAudienceActivity.this.a(bundle);
                SZTrackingReporter.getInstance().onNetStatus(bundle);
            }
        };
        SZTrackingReporter.getInstance().ifMultiCdn(this.s.j());
        SZTrackingReporter.getInstance().setVideoUrl(this.P);
        SZTrackingReporter.getInstance().reportGeneralEvent(GeneralAction.ACTION_ENTER_ROOM.getValue(), false);
        com.shopee.live.livestreaming.ui.audience.a.a.a().a(this.txVideoLayout.get()).a((ITXLivePlayListener) r0).a(str);
        TXLiveBase.setListener(new ITXLiveBaseListener() {
            public final void OnLog(int i, String str, String str2) {
                LiveStreamingAudienceActivity.this.b(i, str, str2);
            }
        });
        this.txLiveNetStatusLayout.a(this.t, str);
        SZTrackingReporter.getInstance().notifyFirstConnectStart();
        SZTrackingReporter.getInstance().reportStartPlayEvent();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(int i, String str, String str2) {
        a(i, str, str2);
    }

    /* access modifiers changed from: package-private */
    public void c(int i) {
        if (i == 2 && com.shopee.live.livestreaming.ui.audience.a.a.a().h()) {
            com.shopee.live.livestreaming.util.z.a((Context) this, c.g.live_streaming_viewer_cellular_network_warm_tip);
        }
        this.X = i;
    }

    public void o() {
        this.aa.c();
    }

    /* access modifiers changed from: private */
    public void r() {
        this.wrapLoadingView.b();
        this.audienceBottomView.c();
        if (this.S == null) {
            this.S = new i((Activity) this.f28744a);
        }
        final boolean z = this.X == -1;
        this.S.a(com.garena.android.appkit.tools.b.e(c.g.live_streaming_viewer_video_stream_interrupt_alert_view_btn_try_again));
        this.S.a(com.garena.android.appkit.tools.b.a(c.b.main_color));
        this.S.b(true);
        this.S.a(false);
        this.S.a(com.garena.android.appkit.tools.b.e(z ? c.g.live_streaming_host_no_internet_alert_view_title : c.g.live_streaming_viewer_video_stream_interrupt_alert_view_title), new i.a() {
            public void a(i iVar) {
                if (LiveStreamingAudienceActivity.this.S != null && LiveStreamingAudienceActivity.this.S.b()) {
                    LiveStreamingAudienceActivity.this.S.c();
                    LiveStreamingAudienceActivity.this.d();
                }
                if (z) {
                    com.shopee.live.livestreaming.ui.audience.c.w();
                } else {
                    com.shopee.live.livestreaming.ui.audience.c.A();
                }
            }

            public void b(i iVar) {
                if (LiveStreamingAudienceActivity.this.S != null) {
                    LiveStreamingAudienceActivity.this.S.c();
                    LiveStreamingAudienceActivity.this.s();
                    com.shopee.live.livestreaming.ui.audience.a.a.a().g();
                    com.shopee.live.livestreaming.ui.audience.a.a.a().a(LiveStreamingAudienceActivity.this.P);
                    SZTrackingReporter.getInstance().setVideoUrl(LiveStreamingAudienceActivity.this.P);
                    SZTrackingReporter.getInstance().notifyReconnectStart();
                    SZTrackingReporter.getInstance().reportStartPlayEvent();
                }
                if (z) {
                    com.shopee.live.livestreaming.ui.audience.c.x();
                } else {
                    com.shopee.live.livestreaming.ui.audience.c.z();
                }
            }
        });
        if (!this.T) {
            i iVar = this.S;
            if (iVar != null && !iVar.b()) {
                this.S.a();
            }
        }
        if (z) {
            com.shopee.live.livestreaming.ui.audience.c.v();
        } else {
            com.shopee.live.livestreaming.ui.audience.c.y();
        }
    }

    /* access modifiers changed from: private */
    public void s() {
        this.wrapLoadingView.setVisibility(0);
        this.wrapLoadingView.a();
        this.wrapLoadingView.setLoadingText(com.garena.android.appkit.tools.b.e(c.g.live_streaming_network_reconnect_tip));
    }

    /* access modifiers changed from: private */
    public void t() {
        this.wrapLoadingView.b();
        this.wrapLoadingView.setVisibility(8);
    }

    private void u() {
        this.O = new com.shopee.live.livestreaming.util.a.c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        registerReceiver(this.O, intentFilter);
    }

    public void j() {
        if (this.voucherStickerItemView != null) {
            this.voucherStickerItemView.a(true, false);
        }
    }
}
