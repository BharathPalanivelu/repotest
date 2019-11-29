package com.shopee.live.livestreaming.ui.audience.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.a.o;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.live.livestreaming.a.VeryBaseLiveStreamingActivity;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.data.entity.DanmaKuContentEntity;
import com.shopee.live.livestreaming.data.entity.DanmaKuEntity;
import com.shopee.live.livestreaming.data.entity.EtoeMessageItem;
import com.shopee.live.livestreaming.data.entity.LiveAdDataEntity;
import com.shopee.live.livestreaming.data.entity.LiveStreamingSessionEntity;
import com.shopee.live.livestreaming.data.entity.PollingRoomInfoEntity;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import com.shopee.live.livestreaming.data.entity.RNPopDataEntity;
import com.shopee.live.livestreaming.data.entity.SessionProductEntity;
import com.shopee.live.livestreaming.data.entity.param.RNAnchorPageParams;
import com.shopee.live.livestreaming.data.entity.param.RNCartPanelParams;
import com.shopee.live.livestreaming.data.entity.param.RNProductPageParams;
import com.shopee.live.livestreaming.network.executor.ThreadExecutor;
import com.shopee.live.livestreaming.network.task.FloatWindowModeTask;
import com.shopee.live.livestreaming.ui.anchor.view.LivePageAnchorInfoView;
import com.shopee.live.livestreaming.ui.anchor.view.LivePageShowProductView;
import com.shopee.live.livestreaming.ui.anchor.view.LivePageTitleView;
import com.shopee.live.livestreaming.ui.anchor.view.PublicScreenView;
import com.shopee.live.livestreaming.ui.anchor.view.VoucherStickerItemView;
import com.shopee.live.livestreaming.ui.anchor.view.WrapLoadingView;
import com.shopee.live.livestreaming.ui.audience.d;
import com.shopee.live.livestreaming.ui.audience.interfaceD;
import com.shopee.live.livestreaming.ui.audience.view.AudienceBottomView;
import com.shopee.live.livestreaming.ui.audience.view.FlowLikeLayout;
import com.shopee.live.livestreaming.ui.audience.view.VideoPlayProgressBar;
import com.shopee.live.livestreaming.ui.floatwindow.service.FloatVideoService;
import com.shopee.live.livestreaming.ui.view.AdView;
import com.shopee.live.livestreaming.ui.view.AudienceCoinView;
import com.shopee.live.livestreaming.ui.view.CleanableLayout;
import com.shopee.live.livestreaming.ui.view.DotsLoadingView;
import com.shopee.live.livestreaming.ui.view.TXLiveNetStatusLayout;
import com.shopee.live.livestreaming.ui.view.TXVideoLayout;
import com.shopee.live.livestreaming.util.NetworkStateReceiver;
import com.shopee.live.livestreaming.util.a.b;
import com.shopee.live.livestreaming.util.a.e;
import com.shopee.live.livestreaming.util.ab;
import com.shopee.live.livestreaming.util.ac;
import com.shopee.live.livestreaming.util.classX;
import com.shopee.live.livestreaming.util.f;
import com.shopee.live.livestreaming.util.h;
import com.shopee.live.livestreaming.util.i;
import com.shopee.live.livestreaming.util.p;
import com.shopee.live.livestreaming.util.t;
import com.shopee.live.livestreaming.util.w;
import com.shopee.live.livestreaming.util.x;
import com.shopee.live.livestreaming.util.z;
import com.shopee.sdk.c.c;
import com.shopee.sdk.modules.ui.a.a;
import com.shopee.sdk.modules.ui.navigator.NavigationPath;
import com.shopee.sdk.modules.ui.navigator.options.PopOption;
import java.io.File;

public abstract class BaseLiveStreamingActivity extends VeryBaseLiveStreamingActivity implements interfaceD, AudienceCoinView.a, c {
    /* access modifiers changed from: private */
    public static int N = 1;
    protected FloatVideoService.a A;
    protected ServiceConnection B;
    protected b C;
    protected boolean D = false;
    int E;
    int F;
    int G;
    int H;
    int I;
    int J;
    int K;
    int L;
    int M;
    /* access modifiers changed from: private */
    public FloatWindowModeTask O;
    /* access modifiers changed from: private */
    public FloatWindowModeTask.Callback P;
    private NetworkStateReceiver Q;
    private boolean R = false;
    private ConstraintLayout S;
    private androidx.constraintlayout.widget.ConstraintSet T;
    private androidx.constraintlayout.widget.ConstraintSet U;
    /* access modifiers changed from: private */
    public volatile float V;
    private Runnable W = new Runnable() {
        public void run() {
            BaseLiveStreamingActivity.this.k.setChildMaxHeight(BaseLiveStreamingActivity.this.B());
        }
    };

    /* renamed from: b  reason: collision with root package name */
    protected CleanableLayout f28963b;

    /* renamed from: c  reason: collision with root package name */
    protected View f28964c;

    /* renamed from: d  reason: collision with root package name */
    protected TXVideoLayout f28965d;

    /* renamed from: e  reason: collision with root package name */
    protected DotsLoadingView f28966e;

    /* renamed from: f  reason: collision with root package name */
    protected LivePageTitleView f28967f;

    /* renamed from: g  reason: collision with root package name */
    protected LivePageAnchorInfoView f28968g;
    protected LivePageShowProductView h;
    protected FlowLikeLayout i;
    protected AudienceBottomView j;
    protected PublicScreenView k;
    protected VideoPlayProgressBar l;
    protected TXLiveNetStatusLayout m;
    protected VoucherStickerItemView n;
    protected WrapLoadingView o;
    protected AdView p;
    protected ImageView q;
    protected AudienceCoinView r;

    // ini mirip dengan presenter
    protected com.shopee.live.livestreaming.ui.audience.b s;

    protected int t;
    protected String u;
    protected String v;
    protected boolean w;
    protected boolean x;
    protected boolean y;
    protected boolean z;

    /* access modifiers changed from: package-private */
    public abstract void a(String str);

    public void c() {
    }

    /* access modifiers changed from: package-private */
    public abstract void c(int i2);

    public void l() {
    }

    private void j() {
        this.f28963b = (CleanableLayout) a(c.e.container_audience);
        this.f28964c = a(c.e.gradient_cover);
        this.f28965d = (TXVideoLayout) a(c.e.video_view);
        this.f28966e = (DotsLoadingView) a(c.e.loading_view);
        this.f28967f = (LivePageTitleView) a(c.e.live_page_title_audience_view);
        this.f28968g = (LivePageAnchorInfoView) a(c.e.live_page_anchor_info_view);
        this.h = (LivePageShowProductView) a(c.e.live_page_show_product_view);
        this.i = (FlowLikeLayout) a(c.e.live_audience_flow_like);
        this.j = (AudienceBottomView) a(c.e.live_page_audience_bottom_view);
        this.k = (PublicScreenView) a(c.e.public_screen_view);
        this.l = (VideoPlayProgressBar) a(c.e.live_replay_video_progress);
        this.m = (TXLiveNetStatusLayout) a(c.e.tx_status_layout);
        this.n = (VoucherStickerItemView) a(c.e.voucher_view);
        this.o = (WrapLoadingView) a(c.e.wrap_loading);
        this.p = (AdView) a(c.e.iv_adview_audience);
        this.q = (ImageView) a(c.e.portrait_to_landscape_icon);
        this.r = (AudienceCoinView) a(c.e.ac_coin);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(c.f.live_streaming_activity_audience);
        j();
        this.f28965d.a();
        // init presenter
        this.s = new com.shopee.live.livestreaming.ui.audience.b(this);
        this.O = new FloatWindowModeTask(ThreadExecutor.getInstance(), this);
        this.s.a((interfaceD) this);// presenter attachView
        classX.g();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        // login untuk dapatin  LiveStreamingSessionEntity
        LiveStreamingSessionEntity f2 = this.s.f();
        if (!(f2 == null || f2.getSession() == null)) {
            this.s.e(f2.getSession().getShop_id());
        }

        // UI stuff dibawah
        try {
            this.T = new androidx.constraintlayout.widget.ConstraintSet();
            this.U = new androidx.constraintlayout.widget.ConstraintSet();
            this.S = (ConstraintLayout) findViewById(c.e.container_audience);
            this.T.clone((Context) this, c.f.live_streaming_activity_audience);
            this.U.clone((Context) this, c.f.live_streaming_activity_audience_landscape);
        } catch (Exception e2) {
            e2.printStackTrace();
        }

        if (com.shopee.live.livestreaming.util.d.a(getApplicationContext()) == 1 && this.V != BitmapDescriptorFactory.HUE_RED) {
            w(); // init view juga
        }
        if (this.y) {
            FloatVideoService.a aVar = this.A;
            if (aVar != null) {
                aVar.a();
                this.y = false;
                this.f28965d.a();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        if (isFinishing()) {
            this.s.a();
            this.h.setClickListener((LivePageShowProductView.a) null);
            this.f28967f.setSizeChangeListener((LivePageTitleView.a) null);
            this.f28968g.setClickListener((LivePageAnchorInfoView.a) null);
            this.j.setBottomViewCallback((AudienceBottomView.b) null);
            this.f28966e.b();
            com.shopee.sdk.b.c().b("NotificationShopeeLiveHideMiniWindow", this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        com.shopee.live.livestreaming.ui.audience.b bVar = this.s;
        if (bVar != null) {
            bVar.g();
        }
        AdView adView = this.p;
        if (adView != null) {
            adView.a();
        }
        WrapLoadingView wrapLoadingView = this.o;
        if (wrapLoadingView != null) {
            wrapLoadingView.c();
        }
    }

    public void z_() {
        ac.b(getApplicationContext());
        this.f28966e.a();
        this.q.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (BaseLiveStreamingActivity.this.w) {
                    com.shopee.live.livestreaming.ui.audience.c.I();
                } else {
                    com.shopee.live.livestreaming.ui.audience.c.C();
                }
                BaseLiveStreamingActivity.this.x();
            }
        });
        this.o.setLoadingListener(new WrapLoadingView.a() {
            public void a() {
                BaseLiveStreamingActivity.this.q.setVisibility(8);
            }

            public void b() {
                if (BaseLiveStreamingActivity.this.V != BitmapDescriptorFactory.HUE_RED && com.shopee.live.livestreaming.util.d.a(BaseLiveStreamingActivity.this.getApplicationContext()) == 0) {
                    if (BaseLiveStreamingActivity.this.q.getVisibility() != 0) {
                        if (BaseLiveStreamingActivity.this.w) {
                            com.shopee.live.livestreaming.ui.audience.c.H();
                        } else {
                            com.shopee.live.livestreaming.ui.audience.c.B();
                        }
                    }
                    BaseLiveStreamingActivity.this.q.setVisibility(0);
                }
            }
        });
        this.r.setOnViewVisibleListener(this);
        this.C = new b(this.f28744a);
        if (!com.shopee.sdk.b.a().d().b()) {
            this.f28968g.g();
        }
        if (this.w) {
            this.f28967f.e();
            this.f28968g.e();
        } else {
            this.f28967f.d();
            this.f28968g.d();
        }
        if (this.t == 0) {
            d();
        }
        if (this.w) {
            this.s.c(this.t);
        } else {
            this.s.a(this.t);
            this.s.d(this.t);
        }
        this.j.c(this.t);
        this.j.setAudienceView(this);
        this.j.setFlowLikeLayout(this.i);
        this.j.setPlayMode(this.w ? 21 : 20);
        this.h.setClickListener(new LivePageShowProductView.a() {
            public void a() {
            }

            public void a(int i, long j) {
                com.shopee.live.livestreaming.ui.audience.c.b(j, i);
                BaseLiveStreamingActivity.this.a(i, j);
            }
        });
        this.k.setLiveMode(20);
        this.k.b(com.garena.android.appkit.tools.b.e(c.g.live_streaming_viewer_msg_welcome));
        this.k.c(h.a());
        this.f28967f.setSizeChangeListener(new LivePageTitleView.a() {
            public void a(int i, int i2, int i3, int i4) {
                if (com.shopee.live.livestreaming.util.d.a(BaseLiveStreamingActivity.this.getApplicationContext()) != 0) {
                    androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
                    cVar.a((ConstraintLayout) BaseLiveStreamingActivity.this.f28963b);
                    cVar.a(BaseLiveStreamingActivity.this.f28968g.getId(), 3, 0, 3, (int) ab.a(12.0f));
                    cVar.b((ConstraintLayout) BaseLiveStreamingActivity.this.f28963b);
                    com.shopee.live.livestreaming.ui.view.d.b(BaseLiveStreamingActivity.this.f28967f.getBottom());
                } else if (i2 < 500) {
                    androidx.constraintlayout.widget.c cVar2 = new androidx.constraintlayout.widget.c();
                    cVar2.a((ConstraintLayout) BaseLiveStreamingActivity.this.f28963b);
                    cVar2.a(BaseLiveStreamingActivity.this.f28968g.getId(), 3, 0, 3, BaseLiveStreamingActivity.this.f28967f.getTop() + BaseLiveStreamingActivity.this.f28967f.getHeight() + ((int) ab.a(12.0f)));
                    cVar2.b((ConstraintLayout) BaseLiveStreamingActivity.this.f28963b);
                }
            }

            public void a() {
                BaseLiveStreamingActivity.this.y();
            }
        });
        this.Q = new NetworkStateReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.Q.a(new NetworkStateReceiver.a() {
            public void a(int i) {
                BaseLiveStreamingActivity.this.c(i);
            }
        });
        registerReceiver(this.Q, intentFilter);
        this.R = true;
        this.p.setAdViewClickListener(new AdView.a() {
            public void a() {
                long i = BaseLiveStreamingActivity.this.s.i();
                if (i != -1) {
                    com.shopee.live.livestreaming.ui.audience.c.b(i);
                    final String h = BaseLiveStreamingActivity.this.s.h();
                    if (!TextUtils.isEmpty(h)) {
                        if ("1".equals(Uri.parse(h).getQueryParameter("hideMiniWindow"))) {
                            BaseLiveStreamingActivity.this.b(h);
                        } else {
                            BaseLiveStreamingActivity.this.a((FloatWindowModeTask.Promise) new FloatWindowModeTask.Promise() {
                                public void onResolve() {
                                    BaseLiveStreamingActivity.this.b(h);
                                }
                            });
                        }
                    }
                }
            }
        });
        this.f28963b.setTouchListener(new CleanableLayout.b() {
            public void a() {
                BaseLiveStreamingActivity.this.n.a(true, false);
            }
        });
        this.C.a(this.t);
        t();
        u();
        com.shopee.sdk.b.c().a("NotificationShopeeLiveHideMiniWindow", (com.shopee.sdk.c.c) this);
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        com.shopee.sdk.b.a().e().a(this, NavigationPath.a(str));
    }

    public void a(com.shopee.sdk.c.a aVar) {
        FloatVideoService.a aVar2 = this.A;
        if (aVar2 != null) {
            aVar2.a();
        }
    }

    public void i() {
        if (getResources().getConfiguration().orientation == 2) {
            q();
        } else {
            p();
        }
    }

    public void k() {
        o();
    }

    /* access modifiers changed from: private */
    public void o() {
        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
        cVar.a((ConstraintLayout) this.f28963b);
        cVar.a(this.p.getId(), 3, this.r.getId(), 4, (int) com.shopee.live.livestreaming.util.w.a(this, 10.0f));
        cVar.b((ConstraintLayout) this.f28963b);
    }

    public void b() {
        if (this.R) {
            this.Q.a((NetworkStateReceiver.a) null);
            unregisterReceiver(this.Q);
            this.R = false;
        }
        m();
    }

    public void a(LiveStreamingSessionEntity liveStreamingSessionEntity) {
        c(liveStreamingSessionEntity);
    }

    public void b(LiveStreamingSessionEntity liveStreamingSessionEntity) {
        d(liveStreamingSessionEntity);
    }

    public void a(boolean z2) {
        this.f28968g.g();
        this.f28968g.setFollowingStatus(z2);
        this.f28968g.setFollowButtonClickable(!z2);
    }

    public void a(final int i2, final long j2) {
        a((FloatWindowModeTask.Promise) new FloatWindowModeTask.Promise() {
            public void onResolve() {
                com.shopee.sdk.b.a().e().a((Activity) BaseLiveStreamingActivity.this, NavigationPath.b("PRODUCT_PAGE"), new RNProductPageParams(i2, j2).toJsonObject());
            }
        });
    }

    public void b(int i2, long j2) {
        NavigationPath b2 = NavigationPath.b("CART_PANEL_PAGE");
        com.shopee.e.a.a.a((Object) "cart_panel: shopid= " + i2 + ", itemid= " + j2);
        com.shopee.sdk.b.a().e().a((Activity) this, b2, new RNCartPanelParams(i2, j2, "#0000007F", 3).toJsonObject());
        this.z = true;
    }

    public void b(final int i2) {
        a((FloatWindowModeTask.Promise) new FloatWindowModeTask.Promise() {
            public void onResolve() {
                com.shopee.sdk.b.a().e().a((Activity) BaseLiveStreamingActivity.this, NavigationPath.b("SHOP_PAGE"), new RNAnchorPageParams(i2).toJsonObject());
            }
        });
    }

    public void d() {
        com.shopee.sdk.b.a().e().a((Activity) this, (o) null, PopOption.b(1));
    }

    public void a(DanmaKuContentEntity danmaKuContentEntity) {
        this.k.a(danmaKuContentEntity);
    }

    public void a(DanmaKuEntity danmaKuEntity) {
        this.k.a(danmaKuEntity);
    }

    public void a(PollingRoomInfoEntity pollingRoomInfoEntity, SessionProductEntity.ProductItem productItem) {
        this.f28968g.a(pollingRoomInfoEntity);
        this.j.b(this.f28968g.getMemberCount());
        this.j.a((long) pollingRoomInfoEntity.session_like_cnt);
        if (pollingRoomInfoEntity.getProducts_cnt() > 0) {
            this.j.setProductItemCount(pollingRoomInfoEntity.getProducts_cnt());
        }
        this.h.a(productItem);
        this.k.post(this.W);
    }

    public void a(EtoeMessageItem etoeMessageItem) {
        this.j.a(etoeMessageItem.type == 0);
    }

    public int B_() {
        return this.t;
    }

    public String g() {
        return this.v;
    }

    public AudienceBottomView h() {
        return this.j;
    }

    /* access modifiers changed from: protected */
    public void b(boolean z2) {
        this.j.setLikeClickForbidden(z2);
    }

    /* access modifiers changed from: protected */
    public void c(LiveStreamingSessionEntity liveStreamingSessionEntity) {
        d(liveStreamingSessionEntity);
    }

    private void p() {
        this.f28968g.getAnchorPortrait().post(new Runnable() {
            public void run() {
                int top = BaseLiveStreamingActivity.this.f28968g.getAnchorPortrait().getTop() + BaseLiveStreamingActivity.this.f28968g.getPaddingTop();
                androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
                cVar.a((ConstraintLayout) BaseLiveStreamingActivity.this.f28963b);
                cVar.a(BaseLiveStreamingActivity.this.p.getId(), 3, BaseLiveStreamingActivity.this.f28968g.getId(), 3, top);
                cVar.b((ConstraintLayout) BaseLiveStreamingActivity.this.f28963b);
            }
        });
    }

    private void q() {
        this.p.post(new Runnable() {
            public void run() {
                int top = BaseLiveStreamingActivity.this.f28967f.getTop() + BaseLiveStreamingActivity.this.f28968g.getPaddingTop() + BaseLiveStreamingActivity.this.f28967f.getHeight() + BaseLiveStreamingActivity.this.f28967f.getPaddingBottom() + ((int) ab.a(7.0f));
                androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
                cVar.a((ConstraintLayout) BaseLiveStreamingActivity.this.f28963b);
                cVar.a(BaseLiveStreamingActivity.this.p.getId(), 3, 0, 3, top);
                cVar.b((ConstraintLayout) BaseLiveStreamingActivity.this.f28963b);
                BaseLiveStreamingActivity.this.r();
                BaseLiveStreamingActivity.this.p.setVisibilityListener(new AdView.b() {
                    public void a(int i) {
                        BaseLiveStreamingActivity.this.r();
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public void r() {
        int i2;
        int i3;
        if (getRequestedOrientation() == 0) {
            boolean z2 = this.p.getVisibility() == 8;
            androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
            cVar.a((ConstraintLayout) this.f28963b);
            int id = this.n.getId();
            if (z2) {
                i2 = 0;
            } else {
                i2 = this.p.getId();
            }
            int i4 = z2 ? 3 : 4;
            if (z2) {
                i3 = c.C0439c.live_streaming_land_voucher_gone_top_margin;
            } else {
                i3 = c.C0439c.live_streaming_land_voucher_top_margin;
            }
            cVar.a(id, 3, i2, i4, com.garena.android.appkit.tools.b.d(i3));
            cVar.b((ConstraintLayout) this.f28963b);
        }
    }

    /* access modifiers changed from: protected */
    public void d(final LiveStreamingSessionEntity liveStreamingSessionEntity) {
        if (liveStreamingSessionEntity != null && liveStreamingSessionEntity.getSession() != null) {
            LiveStreamingSessionEntity.PlayConfig play_config = liveStreamingSessionEntity.getPlay_config();
            if (play_config != null) {
                com.shopee.live.livestreaming.ui.audience.a.a.a().a(play_config.isAuto_adjust_cache_time(), play_config.getMin_auto_adjust_cache_time(), play_config.getMax_auto_adjust_cache_time());
            }
            final int shop_id = liveStreamingSessionEntity.getSession().getShop_id();
            this.s.e(shop_id);
            this.t = liveStreamingSessionEntity.getSession().getSession_id();
            f.a().b(this.t);
            this.v = liveStreamingSessionEntity.getSession().getCover_pic();
            this.f28963b.setLandBackground(this.v);
            this.f28967f.setData(liveStreamingSessionEntity);
            this.f28968g.setData(liveStreamingSessionEntity.getSession());
            this.k.setLiveStreamingSessionEntity(liveStreamingSessionEntity);
            this.j.b(this.f28968g.getMemberCount());
            if (this.w) {
                this.j.setLikeNumber((long) liveStreamingSessionEntity.getSession().getLike_cnt());
            } else {
                this.j.setLikeNumber(0);
            }
            this.j.setTitleName(liveStreamingSessionEntity.getSession().getTitle());
            String nickname = liveStreamingSessionEntity.getSession().getNickname();
            if (com.shopee.live.livestreaming.util.d.a(nickname)) {
                nickname = liveStreamingSessionEntity.getSession().getUsername();
            }
            this.j.setAnchorName(nickname);
            f.a().d(liveStreamingSessionEntity.getSession().getUid());
            f.a().a(liveStreamingSessionEntity.getSession().getStart_time());
            this.f28968g.setClickListener(new LivePageAnchorInfoView.a() {
                public void a(boolean z) {
                    BaseLiveStreamingActivity.this.f28968g.setFollowButtonClickable(false);
                    if (z) {
                        BaseLiveStreamingActivity.this.s.f(shop_id);
                    }
                    if (BaseLiveStreamingActivity.this.w) {
                        com.shopee.live.livestreaming.ui.audience.c.l();
                    } else {
                        com.shopee.live.livestreaming.ui.audience.c.e();
                    }
                }

                public void a(int i) {
                    if (i > 0) {
                        BaseLiveStreamingActivity.this.b(i);
                        if (BaseLiveStreamingActivity.this.w) {
                            com.shopee.live.livestreaming.ui.audience.c.k();
                        } else {
                            com.shopee.live.livestreaming.ui.audience.c.b();
                        }
                    }
                }
            });
            this.j.setBottomViewCallback(new AudienceBottomView.b() {
                public void a(String str) {
                    if ("live--v".equals(str)) {
                        BaseLiveStreamingActivity.this.a((FloatWindowModeTask.Promise) new FloatWindowModeTask.Promise() {
                            public void onResolve() {
                                com.shopee.live.livestreaming.util.o.b(BaseLiveStreamingActivity.this);
                            }
                        });
                        return;
                    }
                    BaseLiveStreamingActivity.this.s.b(str);
                    com.shopee.sdk.modules.app.e.a e2 = x.e();
                    if (e2 != null) {
                        BaseLiveStreamingActivity.this.k.b((long) e2.a(), p.a(e2.d()), h.a(), str);
                    }
                    com.shopee.live.livestreaming.ui.audience.c.g();
                    if ("debug-open".equals(str)) {
                        BaseLiveStreamingActivity.this.s();
                    } else if ("debug-close".equals(str)) {
                        com.shopee.live.livestreaming.b.b().a().setTXLogEnable(false);
                        BaseLiveStreamingActivity.this.m.setVisibility(8);
                    }
                }

                public void a() {
                    com.shopee.live.livestreaming.ui.audience.c.h();
                    com.shopee.sdk.b.a().e().a((Activity) BaseLiveStreamingActivity.this, NavigationPath.a(p.b() + "p/report?session=" + liveStreamingSessionEntity.getSession().getSession_id()), (o) null);
                }

                public void a(int i) {
                    BaseLiveStreamingActivity.this.s.a(liveStreamingSessionEntity.getSession().getSession_id(), i);
                }

                public void b() {
                    BaseLiveStreamingActivity.this.f28963b.c();
                }
            });
        }
    }

    public void a(final FloatWindowModeTask.Promise promise) {
        if (this.x || isFinishing()) {
            promise.onResolve();
            return;
        }
        this.P = new FloatWindowModeTask.Callback() {
            public void onCheckedPermissionStep1(boolean z) {
                if (z) {
                    BaseLiveStreamingActivity.this.O.execute(new FloatWindowModeTask.Data(3), BaseLiveStreamingActivity.this.P);
                    promise.onResolve();
                    return;
                }
                com.shopee.sdk.b.a().c().a(BaseLiveStreamingActivity.this, new a.C0472a().a("").b(com.garena.android.appkit.tools.b.e(c.g.live_streaming_floating_window_permission_tip)).c(com.garena.android.appkit.tools.b.e(c.g.live_streaming_floating_window_permission_btn_yes)).d(com.garena.android.appkit.tools.b.e(c.g.live_streaming_floating_window_permission_btn_no)).a(), new com.shopee.sdk.f.b<Integer>() {
                    public void a(Integer num) {
                        if (num.intValue() != 1 || Build.VERSION.SDK_INT < 23) {
                            promise.onResolve();
                            return;
                        }
                        BaseLiveStreamingActivity.this.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + BaseLiveStreamingActivity.this.getPackageName())), a.N);
                    }

                    public void a(int i, String str) {
                        promise.onResolve();
                    }
                });
            }

            public void onCheckedPermissionStep2(boolean z) {
                if (z) {
                    BaseLiveStreamingActivity.this.O.execute(new FloatWindowModeTask.Data(3), BaseLiveStreamingActivity.this.P);
                }
                promise.onResolve();
            }

            public void onGotPermission() {
                final com.shopee.live.livestreaming.ui.floatwindow.service.interfaceA aVar;
                if (!BaseLiveStreamingActivity.this.isFinishing()) {
                    if (BaseLiveStreamingActivity.this.w) {
                        aVar = new com.shopee.live.livestreaming.ui.floatwindow.service.interfaceA(2, com.shopee.live.livestreaming.ui.audience.a.c.b().d(), BaseLiveStreamingActivity.this.v, com.shopee.live.livestreaming.ui.audience.a.c.l(), com.shopee.live.livestreaming.ui.audience.a.c.k());
                    } else {
                        aVar = new com.shopee.live.livestreaming.ui.floatwindow.service.interfaceA(1, com.shopee.live.livestreaming.ui.audience.a.a.a().c(), BaseLiveStreamingActivity.this.v, com.shopee.live.livestreaming.ui.audience.a.a.a().m(), com.shopee.live.livestreaming.ui.audience.a.a.a().l());
                    }
                    BaseLiveStreamingActivity aVar2 = BaseLiveStreamingActivity.this;
                    aVar2.y = true;
                    if (aVar2.A == null) {
                        BaseLiveStreamingActivity.this.B = new ServiceConnection() {
                            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                                BaseLiveStreamingActivity.this.A = (FloatVideoService.a) iBinder;
                                BaseLiveStreamingActivity.this.A.a(aVar);
                            }

                            public void onServiceDisconnected(ComponentName componentName) {
                                BaseLiveStreamingActivity.this.A = null;
                            }
                        };
                        BaseLiveStreamingActivity.this.f28744a.bindService(new Intent(BaseLiveStreamingActivity.this.f28744a, FloatVideoService.class), BaseLiveStreamingActivity.this.B, 1);
                        return;
                    }
                    BaseLiveStreamingActivity.this.A.a(aVar);
                }
            }
        };
        if ((this.w && com.shopee.live.livestreaming.ui.audience.a.c.b().d() != null) || (!this.w && com.shopee.live.livestreaming.ui.audience.a.a.a().c() != null)) {
            this.O.execute(new FloatWindowModeTask.Data(1), this.P);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == N) {
            this.O.execute(new FloatWindowModeTask.Data(2), this.P);
        }
        if (i2 == 9281 && this.z) {
            this.z = false;
            if (intent != null) {
                c(intent.getStringExtra("popData"));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void m() {
        ServiceConnection serviceConnection = this.B;
        if (serviceConnection != null) {
            unbindService(serviceConnection);
        }
    }

    /* access modifiers changed from: private */
    public void s() {
        if (androidx.core.app.a.b((Context) this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            com.shopee.live.livestreaming.b.b().a().setTXLogEnable(true);
            this.m.setVisibility(0);
            return;
        }
        t.a().a(this, new t.b() {
            public void a(String str, boolean z) {
            }

            public void a(String str) {
                com.shopee.live.livestreaming.b.b().a().setTXLogEnable(true);
                BaseLiveStreamingActivity.this.m.setVisibility(0);
            }
        });
    }

    public void a(LiveAdDataEntity liveAdDataEntity) {
        if (liveAdDataEntity == null) {
            this.p.a((String) null, false);
            return;
        }
        String pic = liveAdDataEntity.getAd_spot().getPic();
        if (!TextUtils.isEmpty(pic) && this.p.a(pic, true)) {
            com.shopee.live.livestreaming.ui.audience.c.a(liveAdDataEntity.getAd_spot().getAd_spot_id());
        }
    }

    private void t() {
        if (this.C != null) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            this.C.a(new File(externalStorageDirectory.getAbsolutePath() + File.separator + "ShopeeLiveStreamingLogs"));
        }
    }

    private void u() {
        this.D = com.shopee.live.livestreaming.b.b().a().ifTXLogEnable();
    }

    public void a(Bundle bundle) {
        if (this.D && bundle != null) {
            this.C.a(e.a(bundle));
        }
    }

    public void a(int i2, String str, String str2) {
        if (this.D) {
            this.C.b(i2 + "   " + str + "   " + str2 + "   " + i.a() + "\n");
        }
    }

    public void a(float f2, float f3) {
        if (f3 > f2) {
            this.q.setVisibility(8);
        } else if (f2 == BitmapDescriptorFactory.HUE_RED || f3 == BitmapDescriptorFactory.HUE_RED || getResources().getConfiguration().orientation != 1) {
            this.q.setVisibility(8);
        } else {
            this.V = f3 / f2;
            v();
        }
    }

    private void v() {
        int a2 = com.shopee.live.livestreaming.util.w.a(getApplicationContext());
        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
        cVar.a((ConstraintLayout) this.f28963b);
        cVar.d(this.f28965d.getId(), a2);
        cVar.c(this.f28965d.getId(), (int) (((float) a2) * this.V));
        androidx.constraintlayout.widget.c cVar2 = cVar;
        cVar2.a(this.f28965d.getId(), 3, 0, 3, (int) ab.a(212.0f));
        cVar2.a(this.f28965d.getId(), 4, 0, 4, (int) ab.a(245.0f));
        cVar.b((ConstraintLayout) this.f28963b);
        if (this.q.getVisibility() != 0) {
            if (this.w) {
                com.shopee.live.livestreaming.ui.audience.c.H();
            } else {
                com.shopee.live.livestreaming.ui.audience.c.B();
            }
        }
        this.q.setVisibility(0);
        com.shopee.live.livestreaming.ui.audience.a.a.a().k();
        this.f28963b.setNeedBackground(true);
        this.f28963b.d();
    }

    /**
     * init view juga
     */
    private void w() {
        int a2 = com.shopee.live.livestreaming.util.w.a(getApplicationContext()); // ambil height
        int b2 = com.shopee.live.livestreaming.util.w.b(getApplicationContext()); // ambil width

        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
        cVar.a((ConstraintLayout) this.f28963b);
        cVar.d(this.f28965d.getId(), a2);
        cVar.c(this.f28965d.getId(), b2);
        cVar.a(this.f28965d.getId(), 3, 0, 3, 0);
        cVar.a(this.f28965d.getId(), 4, 0, 4, 0);
        cVar.a(this.f28965d.getId(), 1, 0, 1, 0);
        cVar.a(this.f28965d.getId(), 2, 0, 2, 0);
        cVar.d(this.f28964c.getId(), a2);
        cVar.c(this.f28964c.getId(), b2);
        androidx.constraintlayout.widget.c cVar2 = cVar;
        cVar2.a(this.f28964c.getId(), 3, this.f28965d.getId(), 3, 0);
        cVar2.a(this.f28964c.getId(), 4, this.f28965d.getId(), 4, 0);
        cVar2.a(this.f28964c.getId(), 1, this.f28965d.getId(), 1, 0);
        cVar2.a(this.f28964c.getId(), 2, this.f28965d.getId(), 2, 0);
        cVar.b((ConstraintLayout) this.f28963b);
        this.q.setVisibility(8);// 8 == Visibility.GONE

        com.shopee.live.livestreaming.ui.audience.a.a.a().k();
    }

    /* access modifiers changed from: private */
    public void x() {
        this.k.b();
        setRequestedOrientation(0);
    }

    /* access modifiers changed from: private */
    public void y() {
        this.k.b();
        setRequestedOrientation(1);
    }

    // kalau onConfigurationChanged
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        // ambil visibility
        C();
        if (configuration.orientation == 1) {
            this.T.b(this.S);
            if (this.M == 8) { // kalau view gone
                p();
            } else {
                z();
            }
            // ini buat apa ya?
            if (this.V != BitmapDescriptorFactory.HUE_RED) {
                v();
            }
            if (this.w) {
                com.shopee.live.livestreaming.ui.audience.a.c.a(false);
                com.shopee.live.livestreaming.ui.audience.c.K();
            } else {
                com.shopee.live.livestreaming.ui.audience.a.a.a().a(false);
                com.shopee.live.livestreaming.ui.audience.c.E();
            }
        } else {
            this.U.b(this.S);
            if (this.M == 8) {
                q();
            } else {
                A();
            }
            if (this.V != BitmapDescriptorFactory.HUE_RED) {
                w();
                if (this.w) {
                    com.shopee.live.livestreaming.ui.audience.a.c.a(true);
                    com.shopee.live.livestreaming.ui.audience.c.J();
                } else {
                    com.shopee.live.livestreaming.ui.audience.a.a.a().a(true);
                    com.shopee.live.livestreaming.ui.audience.c.D();
                }
            }
        }
        D();
        this.k.post(this.W);
    }

    private void z() {
        this.r.post(new Runnable() {
            public void run() {
                androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
                cVar.a((ConstraintLayout) BaseLiveStreamingActivity.this.f28963b);
                cVar.a(BaseLiveStreamingActivity.this.r.getId(), 3, BaseLiveStreamingActivity.this.f28968g.getId(), 3);
                cVar.a(BaseLiveStreamingActivity.this.r.getId(), 4, BaseLiveStreamingActivity.this.f28968g.getId(), 4);
                cVar.b((ConstraintLayout) BaseLiveStreamingActivity.this.f28963b);
                BaseLiveStreamingActivity.this.o();
            }
        });
    }

    private void A() {
        this.r.post(new Runnable() {
            public void run() {
                androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
                cVar.a((ConstraintLayout) BaseLiveStreamingActivity.this.f28963b);
                cVar.a(BaseLiveStreamingActivity.this.r.getId(), 3, BaseLiveStreamingActivity.this.f28968g.getId(), 4, (int) w.a(BaseLiveStreamingActivity.this, 10.0f));
                cVar.b((ConstraintLayout) BaseLiveStreamingActivity.this.f28963b);
            }
        });
    }

    /* access modifiers changed from: private */
    public int B() {
        return this.j.getTop() - this.h.getBottom();
    }

    private void C() {
        this.E = this.p.getVisibility();
        this.F = this.h.getVisibility();
        this.G = this.j.getVisibility();
        this.H = this.k.getVisibility();
        this.I = this.l.getVisibility();
        this.J = this.n.getVisibility();
        this.K = this.f28968g.getVisibility();
        this.L = this.f28967f.getVisibility();
        this.M = this.r.getVisibility();
    }

    private void D() {
        this.p.setVisibility(this.E);
        this.h.setVisibility(this.F);
        this.j.setVisibility(this.G);
        this.k.setVisibility(this.H);
        this.l.setVisibility(this.I);
        this.n.setVisibility(this.J);
        this.f28968g.setVisibility(this.K);
        this.f28967f.setVisibility(this.L);
        this.r.setVisibility(this.M);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005a A[Catch:{ Exception -> 0x00c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0060 A[Catch:{ Exception -> 0x00c8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            d(g.live_streaming_viewer_shopping_sku_pop_up_fail_unknown);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("cart_panel: ");
        sb.append(str);
        C16629a.m52424a((Object) sb.toString());
        C6893f fVar = new C6893f();
        try {
            RNPopDataEntity rNPopDataEntity = (RNPopDataEntity) fVar.mo35446a(str, RNPopDataEntity.class);
            if (TextUtils.isEmpty(rNPopDataEntity.getData())) {
                m55621d(C17348g.live_streaming_viewer_shopping_sku_pop_up_fail_unknown);
                return;
            }
            RNCartPanelDataEntity rNCartPanelDataEntity = (RNCartPanelDataEntity) fVar.mo35446a(rNPopDataEntity.getData(), RNCartPanelDataEntity.class);
            if (rNCartPanelDataEntity != null) {
                if (rNCartPanelDataEntity.getStatus() != Integer.MIN_VALUE) {
                    z = false;
                    if (!z) {
                        m55621d(C17348g.live_streaming_viewer_shopping_sku_pop_up_fail_unknown);
                        return;
                    } else if (rNCartPanelDataEntity.getStatus() == 0) {
                        m55621d(C17348g.live_streaming_viewer_shopping_added_to_cart);
                        return;
                    } else if (rNCartPanelDataEntity.getStatus() != 2) {
                        int error = rNCartPanelDataEntity.getData().getError();
                        if (error != -999) {
                            if (error != 3) {
                                if (error != 6) {
                                    switch (error) {
                                        case -101:
                                        case RNCartPanelDataEntity.ERROR_TRAFFIC_JAM /*-100*/:
                                        case RNCartPanelDataEntity.ERROR_REQUEST_TIMEOUT /*-99*/:
                                            break;
                                    }
                                } else if (rNCartPanelDataEntity.getData().getType() == 3) {
                                    m55621d(C17348g.live_streaming_viewer_shopping_added_cart_fail_sold_out);
                                    return;
                                }
                            } else if (rNCartPanelDataEntity.getData().getType() == 2) {
                                m55621d(C17348g.live_streaming_viewer_shopping_added_cart_fail_sold_out);
                                return;
                            }
                            String error_msg = rNCartPanelDataEntity.getData().getError_msg();
                            if (TextUtils.isEmpty(error_msg)) {
                                m55621d(C17348g.live_streaming_viewer_shopping_sku_pop_up_fail_unknown);
                            } else {
                                C17804z.m56683a((Context) this, error_msg);
                            }
                            return;
                        }
                        m55621d(C17348g.live_streaming_viewer_shopping_add_cart_fail_network);
                        return;
                    } else {
                        return;
                    }
                }
            }
            z = true;
            if (!z) {
            }
        } catch (Exception e) {
            C16629a.m52426a(e, "handleCarPanelResponse error.", new Object[0]);
            m55621d(C17348g.live_streaming_viewer_shopping_sku_pop_up_fail_unknown);
        }
    }

    private void d(int i2) {
        z.a((Context) this, com.garena.android.appkit.tools.b.e(i2));
    }
}
