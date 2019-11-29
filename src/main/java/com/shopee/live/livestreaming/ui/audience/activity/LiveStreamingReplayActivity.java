package com.shopee.live.livestreaming.ui.audience.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.live.livestreaming.b;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.data.entity.LiveStreamingSessionEntity;
import com.shopee.live.livestreaming.data.entity.ReplayRecordEntity;
import com.shopee.live.livestreaming.data.entity.VoucherEntity;
import com.shopee.live.livestreaming.data.entity.param.AudienceReplayPageParams;
import com.shopee.live.livestreaming.network.service.InjectorUtils;
import com.shopee.live.livestreaming.network.task.GetReplayRecordTask;
import com.shopee.live.livestreaming.network.task.PostReplayCountTask;
import com.shopee.live.livestreaming.ui.audience.a.c;
import com.shopee.live.livestreaming.ui.audience.view.VideoPlayProgressBar;
import com.shopee.live.livestreaming.ui.floatwindow.service.FloatVideoService;
import com.shopee.live.livestreaming.ui.view.c.i;
import com.shopee.live.livestreaming.util.f;
import com.shopee.live.livestreaming.util.y;
import com.shopee.live.livestreaming.util.z;
import com.tencent.rtmp.ITXVodPlayListener;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXVodPlayer;

public class LiveStreamingReplayActivity extends a {
    public static String N = "ShopeeLiveStreamingReplay";
    GetReplayRecordTask O;
    PostReplayCountTask P;
    /* access modifiers changed from: private */
    public boolean Q;
    /* access modifiers changed from: private */
    public boolean R;
    /* access modifiers changed from: private */
    public String S;
    /* access modifiers changed from: private */
    public i T;
    private boolean U;
    private boolean V;
    private int W;
    private boolean X = true;
    /* access modifiers changed from: private */
    public boolean Y;

    public void a(VoucherEntity voucherEntity, long j, int i) {
    }

    public void z_() {
        c.a();
        AudienceReplayPageParams audienceReplayPageParams = (AudienceReplayPageParams) a(AudienceReplayPageParams.class);
        this.t = audienceReplayPageParams.getSessionId();
        this.u = audienceReplayPageParams.getShareUrl();
        int recordId = audienceReplayPageParams.getRecordId();
        d(recordId);
        e(recordId);
        this.w = true;
        f.a().b(this.t);
        f.a().b(audienceReplayPageParams.getSource());
        f.a().e(this.u);
        this.p.setVisibility(8);
        this.p.setClickable(false);
        super.z_();
        this.j.setVisibility(0);
        this.j.d();
        this.h.setVisibility(8);
        this.k.setVisibility(8);
        this.f28967f.setVisibility(0);
        this.f28968g.setVisibility(0);
        this.l.setVisibility(0);
        b(true);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.V) {
            if (!this.Y && !this.z) {
                this.f28965d.a();
                c.b().f();
            }
            boolean z = this.X;
            com.shopee.live.livestreaming.ui.audience.c.b(!z, z);
            this.X = false;
            return;
        }
        this.V = true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (!this.y && !this.z && !this.Y) {
            c.b().e();
        }
    }

    /* access modifiers changed from: protected */
    public void e() {
        if (this.z) {
            c.b().e();
        }
    }

    public void b() {
        super.b();
        if (c.c()) {
            if (this.A != null) {
                this.A.a();
            }
            c.b().g();
            stopService(new Intent(this, FloatVideoService.class));
            c.j();
        }
        this.l.setPlayControlCallback((VideoPlayProgressBar.a) null);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.U = true;
    }

    /* access modifiers changed from: protected */
    public void d(LiveStreamingSessionEntity liveStreamingSessionEntity) {
        super.d(liveStreamingSessionEntity);
        boolean z = this.X;
        com.shopee.live.livestreaming.ui.audience.c.b(!z, z);
        this.X = false;
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        if (!isFinishing()) {
            c.b().a(this.f28965d.get());
            c.b().a((ITXVodPlayListener) new ITXVodPlayListener() {
                public void onNetStatus(TXVodPlayer tXVodPlayer, Bundle bundle) {
                }

                public void onPlayEvent(TXVodPlayer tXVodPlayer, int i, Bundle bundle) {
                    if (i != 2005) {
                        com.shopee.live.livestreaming.ui.audience.c.b(i, b.b().b().d(String.valueOf(i)));
                    }
                    if (i == 2005) {
                        int i2 = bundle.getInt(TXLiveConstants.EVT_PLAY_DURATION);
                        if (i2 != 0) {
                            LiveStreamingReplayActivity.this.l.setEndTime(i2);
                            LiveStreamingReplayActivity.this.l.setCanSeek(false);
                        }
                        int i3 = bundle.getInt(TXLiveConstants.EVT_PLAY_PROGRESS);
                        if (i3 <= i2) {
                            i2 = i3;
                        }
                        if (!LiveStreamingReplayActivity.this.R) {
                            if (LiveStreamingReplayActivity.this.l.getSeekProgress() != i2) {
                                LiveStreamingReplayActivity.this.f28966e.b();
                            }
                            LiveStreamingReplayActivity.this.l.a(i2);
                            c.b().b(i2);
                            LiveStreamingReplayActivity.this.x = false;
                        }
                    } else if (i == 2006) {
                        if (!LiveStreamingReplayActivity.this.R) {
                            LiveStreamingReplayActivity.this.l.setPlayStatus(false);
                            LiveStreamingReplayActivity liveStreamingReplayActivity = LiveStreamingReplayActivity.this;
                            liveStreamingReplayActivity.x = true;
                            boolean unused = liveStreamingReplayActivity.Q = true;
                        }
                    } else if (i == 2004) {
                        if (y.a()) {
                            z.a((Context) LiveStreamingReplayActivity.this, c.g.live_streaming_viewer_cellular_network_warm_tip);
                        }
                        LiveStreamingReplayActivity.this.f28966e.b();
                        boolean unused2 = LiveStreamingReplayActivity.this.R = false;
                    } else if (i == 2103) {
                        LiveStreamingReplayActivity.this.f28966e.a();
                    } else if (i == -2301) {
                        LiveStreamingReplayActivity.this.f28966e.b();
                        boolean unused3 = LiveStreamingReplayActivity.this.R = true;
                        LiveStreamingReplayActivity.this.l.setPlayStatus(false);
                        LiveStreamingReplayActivity liveStreamingReplayActivity2 = LiveStreamingReplayActivity.this;
                        liveStreamingReplayActivity2.x = true;
                        boolean unused4 = liveStreamingReplayActivity2.Q = true;
                        LiveStreamingReplayActivity.this.j();
                    } else if (i == 2009) {
                        float f2 = (float) bundle.getInt("EVT_PARAM1", 0);
                        float f3 = (float) bundle.getInt("EVT_PARAM2", 0);
                        LiveStreamingReplayActivity.this.a(f2, f3);
                        if (f3 > BitmapDescriptorFactory.HUE_RED) {
                            com.shopee.live.livestreaming.ui.audience.a.c.a(f2 / f3);
                        }
                    }
                }
            });
            com.shopee.live.livestreaming.ui.audience.a.c.b().a(str);
            this.R = false;
            this.x = false;
            this.l.setPlayStatus(true);
            this.f28966e.a();
            this.l.setPlayControlCallback(new VideoPlayProgressBar.a() {
                public void a() {
                    if (LiveStreamingReplayActivity.this.Q && LiveStreamingReplayActivity.this.S != null) {
                        com.shopee.live.livestreaming.ui.audience.a.c.b().a(LiveStreamingReplayActivity.this.S);
                        boolean unused = LiveStreamingReplayActivity.this.R = false;
                        boolean unused2 = LiveStreamingReplayActivity.this.Q = false;
                    }
                    com.shopee.live.livestreaming.ui.audience.a.c.b().f();
                    boolean unused3 = LiveStreamingReplayActivity.this.Y = false;
                    LiveStreamingReplayActivity.this.x = true;
                }

                public void b() {
                    com.shopee.live.livestreaming.ui.audience.a.c.b().e();
                    boolean unused = LiveStreamingReplayActivity.this.Y = true;
                    LiveStreamingReplayActivity.this.x = true;
                }

                public void a(int i) {
                    com.shopee.live.livestreaming.ui.audience.a.c.b().a(i);
                    com.shopee.live.livestreaming.ui.audience.a.c.b().f();
                    LiveStreamingReplayActivity.this.x = false;
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void c(int i) {
        if (i == 2 && com.shopee.live.livestreaming.ui.audience.a.c.b().h()) {
            z.a((Context) this, c.g.live_streaming_viewer_cellular_network_warm_tip);
        }
        this.W = i;
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null && intent.getBooleanExtra("cart_panel_showing", false)) {
            com.shopee.sdk.b.a().e().a(this);
        }
    }

    public void l() {
        super.l();
        if (this.z) {
            Intent intent = new Intent(this, LiveStreamingReplayActivity.class);
            intent.addFlags(335544320);
            intent.putExtra("cart_panel_showing", true);
            startActivity(intent);
            return;
        }
        com.shopee.sdk.b.a().e().a(this);
    }

    private void d(int i) {
        this.O = InjectorUtils.provideGetReplayRecordTask();
        this.O.execute(new GetReplayRecordTask.Data(i), new GetReplayRecordTask.Callback() {
            public void onFailed() {
            }

            public void onSuccess(ReplayRecordEntity replayRecordEntity) {
                if (replayRecordEntity == null) {
                    LiveStreamingReplayActivity.this.d();
                    return;
                }
                String unused = LiveStreamingReplayActivity.this.S = replayRecordEntity.getReplay_info().getRecord_url();
                LiveStreamingReplayActivity liveStreamingReplayActivity = LiveStreamingReplayActivity.this;
                liveStreamingReplayActivity.a(liveStreamingReplayActivity.S);
                LiveStreamingReplayActivity.this.f28968g.setViewerCount(replayRecordEntity.getReplay_info().getView_count());
            }
        });
    }

    private void e(int i) {
        this.P = InjectorUtils.providePostReplayCountTask();
        this.P.execute(new PostReplayCountTask.Data(i), null);
    }

    /* access modifiers changed from: private */
    public void j() {
        if (this.T == null) {
            this.T = new i((Activity) this.f28744a);
        }
        this.T.a(com.garena.android.appkit.tools.b.e(c.g.live_streaming_host_no_internet_alert_view_btn_try_again));
        this.T.a(this.f28744a.getResources().getColor(c.b.main_color));
        this.T.b(true);
        this.T.a(true);
        this.T.a(false);
        this.T.a(com.garena.android.appkit.tools.b.e(this.W == -1 ? c.g.live_streaming_host_no_internet_alert_view_title : c.g.live_streaming_viewer_video_stream_interrupt_alert_view_title), new i.a() {
            public void a(i iVar) {
                LiveStreamingReplayActivity.this.C_().a(LiveStreamingReplayActivity.this);
                if (LiveStreamingReplayActivity.this.T != null && LiveStreamingReplayActivity.this.T.b()) {
                    LiveStreamingReplayActivity.this.T.c();
                }
            }

            public void b(i iVar) {
                if (LiveStreamingReplayActivity.this.T != null) {
                    LiveStreamingReplayActivity.this.T.c();
                    LiveStreamingReplayActivity.this.f28966e.a();
                    com.shopee.live.livestreaming.ui.audience.a.c.b().g();
                    com.shopee.live.livestreaming.ui.audience.a.c.b().a(LiveStreamingReplayActivity.this.S);
                    LiveStreamingReplayActivity.this.l.setPlayStatus(true);
                }
            }
        });
        if (!this.U) {
            i iVar = this.T;
            if (iVar != null && !iVar.b()) {
                this.T.a();
            }
        }
    }
}
