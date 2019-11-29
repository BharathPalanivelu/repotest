package com.shopee.live.livestreaming.ui.anchor;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.garena.android.appkit.tools.b;
import com.shopee.live.livestreaming.a.a;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.data.entity.AnchorCoinEntity;
import com.shopee.live.livestreaming.data.entity.DanmaKuContentEntity;
import com.shopee.live.livestreaming.data.entity.DanmaKuEntity;
import com.shopee.live.livestreaming.data.entity.LiveAdDataEntity;
import com.shopee.live.livestreaming.data.entity.LiveStreamingParam;
import com.shopee.live.livestreaming.data.entity.LiveStreamingSessionEntity;
import com.shopee.live.livestreaming.data.entity.PollingRoomInfoEntity;
import com.shopee.live.livestreaming.data.entity.SessionProductEntity;
import com.shopee.live.livestreaming.data.entity.VoucherEntity;
import com.shopee.live.livestreaming.sztracking.SZTrackingReporter;
import com.shopee.live.livestreaming.sztracking.proto.GeneralAction;
import com.shopee.live.livestreaming.ui.TouchableConstraintLayout;
import com.shopee.live.livestreaming.ui.anchor.d;
import com.shopee.live.livestreaming.ui.anchor.view.LivePageAnchorInfoView;
import com.shopee.live.livestreaming.ui.anchor.view.LivePageBottomView;
import com.shopee.live.livestreaming.ui.anchor.view.LivePageNavigationView;
import com.shopee.live.livestreaming.ui.anchor.view.LivePageShowProductView;
import com.shopee.live.livestreaming.ui.anchor.view.LivePageTitleView;
import com.shopee.live.livestreaming.ui.anchor.view.PublicScreenView;
import com.shopee.live.livestreaming.ui.anchor.view.VoucherStickerItemView;
import com.shopee.live.livestreaming.ui.anchor.view.WrapLoadingView;
import com.shopee.live.livestreaming.ui.view.AdView;
import com.shopee.live.livestreaming.ui.view.AnchorCoinView;
import com.shopee.live.livestreaming.ui.view.CountdownView;
import com.shopee.live.livestreaming.ui.view.TXLiveNetStatusLayout;
import com.shopee.live.livestreaming.util.a.c;
import com.shopee.live.livestreaming.util.ab;
import com.shopee.live.livestreaming.util.ac;
import com.shopee.live.livestreaming.util.f;
import com.shopee.live.livestreaming.util.o;
import com.shopee.live.livestreaming.util.w;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class LiveStreamingAnchorActivity extends a implements PublicScreenView.a, com.shopee.live.livestreaming.ui.anchor.view.a, AnchorCoinView.a {

    /* renamed from: b  reason: collision with root package name */
    public static String f28802b = "ShopeeLiveStreamingPush";

    /* renamed from: c  reason: collision with root package name */
    TouchableConstraintLayout f28803c;

    /* renamed from: d  reason: collision with root package name */
    TXCloudVideoView f28804d;

    /* renamed from: e  reason: collision with root package name */
    CountdownView f28805e;

    /* renamed from: f  reason: collision with root package name */
    ConstraintLayout f28806f;

    /* renamed from: g  reason: collision with root package name */
    LivePageTitleView f28807g;
    LivePageAnchorInfoView h;
    LivePageShowProductView i;
    LivePageBottomView j;
    LivePageNavigationView k;
    PublicScreenView l;
    TXLiveNetStatusLayout m;
    VoucherStickerItemView n;
    WrapLoadingView o;
    AdView p;
    AnchorCoinView q;
    LiveStreamingParam r;
    c s;
    /* access modifiers changed from: private */
    public a t;
    /* access modifiers changed from: private */
    public d u;
    private boolean v = true;
    private int w;
    private LiveStreamingSessionEntity x;

    public void b() {
    }

    private void k() {
        this.f28803c = (TouchableConstraintLayout) a(c.e.rl_root_view);
        this.f28804d = (TXCloudVideoView) a(c.e.video_view);
        this.f28805e = (CountdownView) a(c.e.count_down_view);
        this.f28806f = (ConstraintLayout) a(c.e.cl_main_layout);
        this.f28807g = (LivePageTitleView) a(c.e.live_page_title_view);
        this.h = (LivePageAnchorInfoView) a(c.e.live_page_anchor_info_view);
        this.i = (LivePageShowProductView) a(c.e.live_page_show_product_view);
        this.j = (LivePageBottomView) a(c.e.live_page_bottom_view);
        this.k = (LivePageNavigationView) a(c.e.live_page_navigation_view);
        this.l = (PublicScreenView) a(c.e.public_screen_view);
        this.m = (TXLiveNetStatusLayout) a(c.e.tx_status_layout);
        this.n = (VoucherStickerItemView) a(c.e.voucher_view);
        this.o = (WrapLoadingView) a(c.e.wrap_loading);
        this.p = (AdView) a(c.e.iv_banner_anchor);
        this.q = (AnchorCoinView) a(c.e.ac_coin);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(c.f.live_streaming_activity_live_streaming);
        k();
        this.t = new a(this.f28744a, this.m);
        this.t.a(this);
    }

    public void z_() {
        ac.b(getApplicationContext());
        this.r = (LiveStreamingParam) a(LiveStreamingParam.class);
        this.t.a(this.r);
        this.j.setOnLiveBottomViewCallback(new LivePageBottomView.a() {
            public void a(int i) {
                if (LiveStreamingAnchorActivity.this.u != null) {
                    LiveStreamingAnchorActivity.this.u.a(i);
                }
            }

            public void a() {
                if (LiveStreamingAnchorActivity.this.u != null) {
                    LiveStreamingAnchorActivity.this.u.m();
                }
            }

            public void a(long j, String str, String str2, String str3) {
                LiveStreamingAnchorActivity.this.l.a(j, str, str2, str3);
                LiveStreamingAnchorActivity.this.t.a(str3);
                LiveStreamingAnchorActivity.this.t.b(str3);
            }

            public void a(SessionProductEntity.ProductItem productItem) {
                LiveStreamingAnchorActivity.this.i.b(productItem);
            }

            public void a(VoucherEntity voucherEntity) {
                LiveStreamingAnchorActivity.this.n.a(voucherEntity);
            }

            public void b() {
                LiveStreamingAnchorActivity.this.n.b();
            }
        });
        this.k.setOnNavigationCallback(new LivePageNavigationView.a() {
            public void a() {
                if (!LiveStreamingAnchorActivity.this.t.i() || LiveStreamingAnchorActivity.this.u == null) {
                    LiveStreamingAnchorActivity.this.t.a((Activity) LiveStreamingAnchorActivity.this);
                    return;
                }
                LiveStreamingAnchorActivity.this.u.f();
                LiveStreamingAnchorActivity.this.u.g();
                LiveStreamingAnchorActivity.this.u.d();
            }

            public void b() {
                if (LiveStreamingAnchorActivity.this.u != null) {
                    LiveStreamingAnchorActivity.this.u.c();
                    LiveStreamingAnchorActivity.this.n();
                    LiveStreamingAnchorActivity.this.u.i();
                    LiveStreamingAnchorActivity.this.h.a(0);
                    LiveStreamingAnchorActivity.this.l.b(b.e(c.g.live_streaming_host_msg_notice));
                    LiveStreamingAnchorActivity.this.t.e();
                }
            }

            public void c() {
                LiveStreamingAnchorActivity.this.l();
            }
        });
        this.i.setClickListener(new LivePageShowProductView.a() {
            public void a(int i, long j) {
            }

            public void a() {
                LiveStreamingAnchorActivity.this.j.setmShowId("");
            }
        });
        this.f28805e.setOnFinishAction(new CountdownView.a() {
            public void a() {
                LiveStreamingAnchorActivity.this.f28805e.setVisibility(8);
                LiveStreamingAnchorActivity.this.k.a(LiveStreamingAnchorActivity.this.j.e());
            }
        });
        this.l.setVoucherStickerClickCallback(this);
        this.j.setmLivePageNavigationView(this.k);
        this.j.setPublicScreenView(this.l);
        this.f28807g.setSizeChangeListener(new LivePageTitleView.a() {
            public void a() {
            }

            public void a(int i, int i2, int i3, int i4) {
                if (i2 < 500) {
                    androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
                    cVar.a(LiveStreamingAnchorActivity.this.f28806f);
                    LiveStreamingAnchorActivity.this.f28807g.getTop();
                    ab.a(12.0f);
                    cVar.a(LiveStreamingAnchorActivity.this.h.getId(), 3, LiveStreamingAnchorActivity.this.f28806f.getId(), 3, LiveStreamingAnchorActivity.this.f28807g.getTop() + i2 + ((int) ab.a(12.0f)));
                    cVar.b(LiveStreamingAnchorActivity.this.f28806f);
                }
            }
        });
        int i2 = 0;
        this.p.setClickable(false);
        this.n.setVoucherCallback(new VoucherStickerItemView.a() {
            public void a() {
            }

            public void b() {
                LiveStreamingAnchorActivity.this.j.setmShowVoucherId("-1");
            }
        });
        this.f28803c.setTouchListener(new TouchableConstraintLayout.a() {
            public void a() {
                LiveStreamingAnchorActivity.this.n.a(true, false);
            }
        });
        this.q.setViewVisibilityCallback(this);
        TXLiveNetStatusLayout tXLiveNetStatusLayout = this.m;
        if (!com.shopee.live.livestreaming.b.b().a().ifTXLogEnable()) {
            i2 = 8;
        }
        tXLiveNetStatusLayout.setVisibility(i2);
        this.t.c();
    }

    /* access modifiers changed from: protected */
    public void e() {
        d dVar = this.u;
        if (dVar != null) {
            dVar.k();
        }
        this.h.i();
        this.t.n();
    }

    /* access modifiers changed from: protected */
    public void f() {
        d dVar = this.u;
        if (dVar != null) {
            dVar.j();
        }
        this.h.h();
        this.t.o();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!this.v) {
            this.t.a((Activity) this);
        }
        this.v = false;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        d dVar = this.u;
        if (dVar != null) {
            dVar.l();
            SZTrackingReporter.getInstance().reportGeneralEvent(GeneralAction.ACTION_DISCONNECTED_ACTIVE.getValue(), true);
        }
        this.h.j();
        this.t.f();
        this.f28805e.c();
        this.l.d();
        this.o.b();
        this.t.g();
        this.t.h();
        this.t.m();
        this.n.c();
        com.shopee.live.livestreaming.util.a.c cVar = this.s;
        if (cVar != null) {
            unregisterReceiver(cVar);
        }
        SZTrackingReporter.getInstance().reportGeneralEvent(GeneralAction.ACTION_LEAVE_ROOM.getValue(), true);
        SZTrackingReporter.getInstance().saveCacheToDB();
    }

    /* access modifiers changed from: private */
    public void l() {
        this.f28806f.setVisibility(0);
        this.k.setVisibility(0);
        this.j.setVisibility(0);
        this.t.k();
        this.j.c();
        this.f28807g.b();
        this.h.b();
        this.i.b();
    }

    /* access modifiers changed from: private */
    public void m() {
        this.f28806f.setVisibility(8);
        this.f28805e.setVisibility(0);
        this.f28805e.a();
        this.f28805e.b();
    }

    /* access modifiers changed from: private */
    public void n() {
        this.t.l();
        this.f28806f.setVisibility(0);
        this.f28805e.setVisibility(8);
        this.k.setVisibility(8);
        this.j.setVisibility(0);
        this.i.c();
        this.h.c();
        this.f28807g.c();
        this.j.d();
        this.l.setVisibility(0);
        b.b();
        SZTrackingReporter.getInstance().reportGeneralEvent(GeneralAction.ACTION_ENTER_ROOM.getValue(), true);
        this.t.d();
    }

    public void g() {
        q();
        int i2 = this.w;
        if (i2 == 17) {
            p();
        } else if (i2 == 18) {
            o();
        }
    }

    public void a(LiveStreamingSessionEntity liveStreamingSessionEntity) {
        this.w = 17;
        this.x = liveStreamingSessionEntity;
        l();
        d(liveStreamingSessionEntity);
        this.t.a((Activity) this);
    }

    public void b(LiveStreamingSessionEntity liveStreamingSessionEntity) {
        this.w = 18;
        this.x = liveStreamingSessionEntity;
        n();
        d(liveStreamingSessionEntity);
        this.t.a((Activity) this);
    }

    public void c(LiveStreamingSessionEntity liveStreamingSessionEntity) {
        o.a((Activity) this.f28744a, this.r.getEndPageUrl(), liveStreamingSessionEntity.getSession().getSession_id(), "KOL", liveStreamingSessionEntity.getSession().getCover_pic());
    }

    public void a(PollingRoomInfoEntity pollingRoomInfoEntity) {
        this.h.a(pollingRoomInfoEntity);
        this.j.a(this.h.getMemberCount());
    }

    public void a(AnchorCoinEntity anchorCoinEntity) {
        this.q.a(anchorCoinEntity);
        b(anchorCoinEntity);
    }

    private void b(AnchorCoinEntity anchorCoinEntity) {
        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
        cVar.a(this.f28806f);
        if (anchorCoinEntity == null || anchorCoinEntity.getShown_coins() == 0 || anchorCoinEntity.getCoin_status() == 1) {
            cVar.a(this.p.getId(), 3, this.f28807g.getId(), 4);
        } else {
            cVar.a(this.p.getId(), 3, this.q.getId(), 4);
        }
        cVar.b(this.f28806f);
    }

    public void a(DanmaKuEntity danmaKuEntity) {
        this.l.a(danmaKuEntity);
    }

    public void a(DanmaKuContentEntity danmaKuContentEntity) {
        this.l.a(danmaKuContentEntity);
    }

    /* access modifiers changed from: protected */
    public boolean D_() {
        if (f.a().o()) {
            return true;
        }
        return this.t.j();
    }

    private void o() {
        s();
        d dVar = this.u;
        if (dVar != null) {
            dVar.i();
        }
        this.h.a(this.t.a(this.x.getSession().getStart_time()));
        this.l.b(b.e(c.g.live_streaming_host_msg_notice));
        this.t.e();
    }

    private void p() {
        this.i.e();
        s();
        d dVar = this.u;
        if (dVar != null) {
            dVar.i();
        }
        b.a();
    }

    private void d(LiveStreamingSessionEntity liveStreamingSessionEntity) {
        this.f28807g.setData(liveStreamingSessionEntity);
        this.h.setData(liveStreamingSessionEntity.getSession());
        this.j.a(this.h.getMemberCount());
        this.j.a(liveStreamingSessionEntity.getSession().getCover_pic());
        this.j.setSessionData(liveStreamingSessionEntity);
        this.l.setLiveStreamingSessionEntity(liveStreamingSessionEntity);
        this.t.a(liveStreamingSessionEntity);
        f.a().a(liveStreamingSessionEntity.getSession().getCover_pic());
        f.a().a(liveStreamingSessionEntity.getSession().getStart_time());
        r();
        this.m.a(liveStreamingSessionEntity.getSession().getSession_id(), liveStreamingSessionEntity.getSession().getPush_url());
    }

    private void q() {
        this.u = new d(this.f28744a, this.f28804d, this.o);
        this.u.b(this.x);
        this.u.a(this.m);
        int i2 = this.w;
        if (i2 == 17) {
            this.u.b();
        } else if (i2 == 18) {
            this.u.c();
        }
        this.u.a(this.x);
        this.u.a((d.a) new d.a() {
            public void a(Bundle bundle) {
                LiveStreamingAnchorActivity.this.t.a(bundle);
                LiveStreamingAnchorActivity.this.t.b(bundle);
                LiveStreamingAnchorActivity.this.t.a(LiveStreamingAnchorActivity.this.u);
            }

            public void a(int i, String str, String str2) {
                LiveStreamingAnchorActivity.this.t.a(i, str, str2);
            }

            public void a() {
                LiveStreamingAnchorActivity.this.m();
            }
        });
    }

    private void r() {
        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
        cVar.a(this.f28806f);
        cVar.a(this.h.getId(), 3, c.e.cl_main_layout, 3, this.f28807g.getTop() + this.f28807g.getHeight() + ((int) ab.a(12.0f)));
        cVar.b(this.f28806f);
    }

    private void s() {
        this.s = new com.shopee.live.livestreaming.util.a.c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        registerReceiver(this.s, intentFilter);
    }

    public void a(LiveAdDataEntity liveAdDataEntity) {
        if (liveAdDataEntity == null) {
            this.p.a((String) null, false);
            return;
        }
        this.p.a(liveAdDataEntity.getAd_spot().getPic(), true);
    }

    private void t() {
        this.h.getAnchorPortrait().post(new Runnable() {
            public void run() {
                int top = LiveStreamingAnchorActivity.this.h.getAnchorPortrait().getTop() + LiveStreamingAnchorActivity.this.h.getPaddingTop();
                androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
                cVar.a(LiveStreamingAnchorActivity.this.f28806f);
                cVar.a(LiveStreamingAnchorActivity.this.p.getId(), 3, LiveStreamingAnchorActivity.this.h.getId(), 3, top);
                cVar.b(LiveStreamingAnchorActivity.this.f28806f);
            }
        });
    }

    public void h() {
        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
        cVar.a(this.f28806f);
        cVar.a(this.p.getId(), 3, this.q.getId(), 4, (int) w.a(this, 10.0f));
        cVar.b(this.f28806f);
    }

    public void i() {
        t();
    }

    public void j() {
        VoucherStickerItemView voucherStickerItemView = this.n;
        if (voucherStickerItemView != null) {
            voucherStickerItemView.a(true, false);
        }
    }
}
