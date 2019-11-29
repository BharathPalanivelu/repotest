package com.shopee.live.livestreaming.ui.anchor;

import a.k;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.facebook.appevents.AppEventsConstants;
import com.google.a.o;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.data.entity.LiveStreamingSessionEntity;
import com.shopee.live.livestreaming.sztracking.SZTrackingReporter;
import com.shopee.live.livestreaming.sztracking.proto.GeneralAction;
import com.shopee.live.livestreaming.ui.anchor.view.WrapLoadingView;
import com.shopee.live.livestreaming.ui.view.TXLiveNetStatusLayout;
import com.shopee.live.livestreaming.ui.view.c.c;
import com.shopee.live.livestreaming.ui.view.c.i;
import com.shopee.live.livestreaming.ui.view.c.j;
import com.shopee.live.livestreaming.util.f;
import com.shopee.live.livestreaming.util.l;
import com.shopee.live.livestreaming.util.n;
import com.shopee.live.livestreaming.util.z;
import com.shopee.sdk.modules.ui.navigator.options.PopOption;
import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.rtmp.ITXLiveBaseListener;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class d {
    /* access modifiers changed from: private */
    public int A;
    /* access modifiers changed from: private */
    public int B;
    /* access modifiers changed from: private */
    public int C;
    private int D;
    private int E;
    private int F;
    private int G;
    /* access modifiers changed from: private */
    public int H;
    private boolean I = false;
    /* access modifiers changed from: private */
    public boolean J = true;
    private boolean K = true;
    /* access modifiers changed from: private */
    public int L;
    private ArrayList<String> M = new ArrayList<>();
    private ArrayList<Integer> N = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    TXCloudVideoView f28845a;

    /* renamed from: b  reason: collision with root package name */
    TXLivePushConfig f28846b;

    /* renamed from: c  reason: collision with root package name */
    l f28847c;

    /* renamed from: d  reason: collision with root package name */
    b f28848d;

    /* renamed from: e  reason: collision with root package name */
    ArrayList<LiveStreamingSessionEntity.DefaultPushConfig> f28849e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public a f28850f;

    /* renamed from: g  reason: collision with root package name */
    private j f28851g;
    /* access modifiers changed from: private */
    public i h;
    private c i;
    private c j;
    private WrapLoadingView k;
    /* access modifiers changed from: private */
    public TXLiveNetStatusLayout l;
    /* access modifiers changed from: private */
    public Context m;
    /* access modifiers changed from: private */
    public TXLivePusher n;
    private int o;
    private boolean p = false;
    private boolean q = true;
    private boolean r;
    private boolean s = true;
    /* access modifiers changed from: private */
    public boolean t = true;
    /* access modifiers changed from: private */
    public boolean u = false;
    private String v = "";
    /* access modifiers changed from: private */
    public boolean w = true;
    /* access modifiers changed from: private */
    public long x;
    /* access modifiers changed from: private */
    public LiveStreamingSessionEntity y;
    /* access modifiers changed from: private */
    public int z = -1;

    public interface a {
        void a();

        void a(int i, String str, String str2);

        void a(Bundle bundle);
    }

    static /* synthetic */ int c(d dVar) {
        int i2 = dVar.L;
        dVar.L = i2 + 1;
        return i2;
    }

    class b extends Handler {
        b() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 15) {
                d.this.i();
            } else if (i == 18) {
                boolean unused = d.this.w = true;
            } else if (i == 21) {
                d.this.C();
            } else if (i != 23) {
                if (i == 25 && !d.this.t) {
                    boolean unused2 = d.this.t = true;
                }
            } else if (d.this.L < 120) {
                d.c(d.this);
                sendEmptyMessageDelayed(23, 1000);
            } else {
                d.c(d.this);
                int unused3 = d.this.L = 0;
                boolean unused4 = d.this.J = true;
            }
        }
    }

    public d(Context context, TXCloudVideoView tXCloudVideoView, WrapLoadingView wrapLoadingView) {
        n();
        this.m = context;
        this.f28845a = tXCloudVideoView;
        this.k = wrapLoadingView;
        this.n = new TXLivePusher(this.m);
        this.f28846b = new TXLivePushConfig();
        this.f28847c = new l(this.m);
        this.f28847c.a((l.a) new l.a() {
            public void a() {
                com.shopee.sdk.b.a().e().a((Activity) d.this.m, (o) null, PopOption.b(2));
            }

            public void a(int i) {
                com.shopee.live.livestreaming.util.o.a((Activity) d.this.m);
            }
        });
        this.f28848d = new b();
    }

    private void n() {
        try {
            TXLiveBase.setListener(new ITXLiveBaseListener() {
                public void OnLog(int i, String str, String str2) {
                    if (d.this.f28850f != null) {
                        d.this.f28850f.a(i, str, str2);
                    }
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(LiveStreamingSessionEntity liveStreamingSessionEntity) {
        this.y = liveStreamingSessionEntity;
        if (liveStreamingSessionEntity != null) {
            TXLiveNetStatusLayout tXLiveNetStatusLayout = this.l;
            if (tXLiveNetStatusLayout != null) {
                tXLiveNetStatusLayout.a(liveStreamingSessionEntity.getDefault_push_config());
            }
            s();
            v();
            a();
            this.n.startCameraPreview(this.f28845a);
            this.n.setPushListener(new ITXLivePushListener() {
                public void onPushEvent(int i, Bundle bundle) {
                    d.this.a(i, bundle);
                }

                public void onNetStatus(Bundle bundle) {
                    if (d.this.x == 0) {
                        long unused = d.this.x = System.currentTimeMillis();
                        d.this.a(bundle);
                    } else if (((float) (System.currentTimeMillis() - d.this.x)) / 1000.0f > 1.5f) {
                        long unused2 = d.this.x = System.currentTimeMillis();
                        d.this.a(bundle);
                    }
                }
            });
            a(50);
            p();
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, Bundle bundle) {
        int i3 = this.o;
        if (i3 != 17) {
            if (i3 == 18) {
                c(i2, bundle);
            }
        } else if (this.p) {
            b(i2, bundle);
        }
        SZTrackingReporter.getInstance().reportPushEvent(i2);
    }

    /* access modifiers changed from: private */
    public void a(Bundle bundle) {
        this.l.b(bundle);
        this.l.a(bundle);
        d(bundle);
        int i2 = this.o;
        if (i2 != 17) {
            if (i2 == 18) {
                c(bundle);
                if (this.p && this.J) {
                    b(bundle);
                }
            }
        } else if (this.p) {
            b(bundle);
        }
        SZTrackingReporter.getInstance().reportPushActionLiveDetails(bundle);
    }

    private void b(Bundle bundle) {
        if (this.r && this.t && !this.u && this.s) {
            int i2 = bundle.getInt(TXLiveConstants.NET_STATUS_NET_SPEED);
            this.N.add(Integer.valueOf(i2));
            if (((float) i2) < ((float) this.A) * 0.4f) {
                c(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            } else {
                c("1");
            }
            o();
        }
    }

    private void c(Bundle bundle) {
        a aVar = this.f28850f;
        if (aVar != null) {
            aVar.a(bundle);
        }
        b.a(this.m, bundle);
    }

    private void b(int i2, Bundle bundle) {
        if (i2 == 1101) {
            d(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            o();
        }
    }

    private void c(int i2, Bundle bundle) {
        try {
            b.a(i2, com.shopee.live.livestreaming.b.b().b().d(String.valueOf(i2)));
        } catch (Exception unused) {
        }
        if (i2 == -1307) {
            SZTrackingReporter.getInstance().reportGeneralEvent(GeneralAction.ACTION_DISCONNECTED_PASSIVE.getValue(), true);
            F();
        } else if (i2 == 1001) {
            B();
        } else if (i2 == 1002) {
            SZTrackingReporter.getInstance().reportGeneralEvent(GeneralAction.ACTION_CONNECTED_STREAM.getValue(), true);
            B();
        } else if (i2 == 1101) {
            z();
            if (this.p && this.J) {
                d(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                o();
            }
        } else if (i2 != 1102) {
            switch (i2) {
            }
        } else {
            A();
        }
    }

    private void c(String str) {
        if (this.M == null) {
            this.M = new ArrayList<>();
        }
        int i2 = this.o;
        int i3 = (i2 == 17 || i2 != 18) ? 5 : 10;
        if (this.M.size() >= i3) {
            for (int i4 = 0; i4 <= this.M.size() - i3; i4++) {
                this.M.remove(i4);
            }
        }
        this.M.add(str);
        if (this.M.size() < 5) {
        }
    }

    private void d(String str) {
        if (this.M == null) {
            this.M = new ArrayList<>();
        }
        if (this.M.size() > 0) {
            ArrayList<String> arrayList = this.M;
            arrayList.set(arrayList.size() - 1, str);
            return;
        }
        this.M.add(0, str);
    }

    private void o() {
        if (this.r && this.t && !this.u && this.s && u()) {
            int i2 = this.o;
            if (i2 == 17) {
                p();
            } else if (i2 == 18 && this.J) {
                this.J = false;
                if (this.K) {
                    this.K = false;
                    r();
                    return;
                }
                q();
            }
        }
    }

    private void p() {
        if (this.p) {
            LiveStreamingSessionEntity liveStreamingSessionEntity = this.y;
            if (liveStreamingSessionEntity != null) {
                this.f28849e = liveStreamingSessionEntity.getDefault_push_config();
                ArrayList<LiveStreamingSessionEntity.DefaultPushConfig> arrayList = this.f28849e;
                if (arrayList != null && arrayList.size() > 0) {
                    this.z = this.f28849e.get(0).getBitrate();
                    this.B = this.f28849e.get(0).getVideo_resolution();
                    if (this.H < this.f28849e.size()) {
                        LiveStreamingSessionEntity.DefaultPushConfig defaultPushConfig = this.f28849e.get(this.H);
                        this.A = defaultPushConfig.getBitrate();
                        this.l.a(this.A);
                        this.C = defaultPushConfig.getVideo_resolution();
                        a(this.y.getPush_stream_config().getCustom());
                        this.H++;
                    } else {
                        this.u = true;
                        int i2 = this.o;
                        if (i2 == 17) {
                            this.q = false;
                        } else if (i2 == 18 && !this.I) {
                            this.I = true;
                            this.J = false;
                            z.b(this.m, "Bad network, please check");
                        }
                    }
                    g();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void q() {
        p();
        this.J = false;
        this.f28848d.sendEmptyMessageDelayed(23, 1000);
    }

    private void r() {
        if (this.j == null) {
            this.j = new c((Activity) this.m);
        }
        this.j.k();
        this.j.a(com.garena.android.appkit.tools.b.e(c.g.live_streaming_host_too_bad_network_switch_config_in_live_permission), new c.a() {
            public void a(com.shopee.live.livestreaming.ui.view.c.c cVar) {
                cVar.c();
                boolean unused = d.this.J = false;
                boolean unused2 = d.this.u = true;
                d.this.g();
            }

            public void b(com.shopee.live.livestreaming.ui.view.c.c cVar) {
                cVar.c();
                d.this.q();
            }
        });
        f.a().c(true);
        this.j.a();
    }

    private void s() {
        this.f28846b.setPauseImg(300, 10);
        Bitmap a2 = n.a(this.m);
        if (a2 != null) {
            this.f28846b.setPauseImg(a2);
        }
        t();
        this.f28846b.setPauseFlag(3);
        this.n.setConfig(this.f28846b);
    }

    private void t() {
        LiveStreamingSessionEntity.PushConfig push_stream_config = this.y.getPush_stream_config();
        if (push_stream_config != null && push_stream_config.getType() == 1) {
            LiveStreamingSessionEntity.Custom custom = this.y.getPush_stream_config().getCustom();
            this.A = custom.getVideo_bitrate_pin();
            this.l.a(this.A);
            this.C = custom.getVideo_resolution();
            a(custom);
        } else if (push_stream_config.getType() == 2) {
            LiveStreamingSessionEntity.Preset preset = this.y.getPush_stream_config().getPreset();
            this.n.setVideoQuality(preset.getQuality(), preset.isAdjustBitrate(), preset.isAdjustResolution());
        }
    }

    /* access modifiers changed from: private */
    public void a(LiveStreamingSessionEntity.Custom custom) {
        if (custom != null) {
            this.f28846b.setAudioSampleRate(custom.getAudio_sample_rate());
            this.f28846b.setVideoResolution(this.C);
            this.f28846b.setVideoEncodeGop(custom.getVideo_encode_gop());
            this.f28846b.setAutoAdjustStrategy(custom.getAuto_adjust_strategy());
            this.f28846b.setAutoAdjustBitrate(custom.isEnable_auto_bitrate());
            this.f28846b.setVideoBitrate(this.A);
            this.f28846b.setMinVideoBitrate(custom.getVideo_bitrate_min());
            this.f28846b.setMaxVideoBitrate(custom.getVideo_bitrate_max());
            return;
        }
        this.f28846b.setAudioSampleRate(4);
        this.f28846b.setVideoResolution(0);
        this.f28846b.setVideoEncodeGop(1);
        this.f28846b.setAutoAdjustStrategy(-1);
        this.f28846b.setAutoAdjustBitrate(true);
        this.f28846b.setVideoBitrate(custom.getVideo_bitrate_pin());
        this.f28846b.setMinVideoBitrate(300);
        this.f28846b.setMaxVideoBitrate(IMediaPlayer.MEDIA_INFO_TIMED_TEXT_ERROR);
    }

    private boolean u() {
        int size = this.M.size();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < this.M.size()) {
            if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(this.M.get(i2))) {
                i3++;
                i4++;
            } else {
                i4 = 0;
            }
            if (this.M.size() < this.G || (i3 < this.E && i4 < this.F)) {
                i2++;
            } else {
                this.l.a(size, i3, i4);
                return true;
            }
        }
        this.l.a(size, i3, i4);
        return false;
    }

    private void v() {
        LiveStreamingSessionEntity liveStreamingSessionEntity = this.y;
        if (liveStreamingSessionEntity != null) {
            LiveStreamingSessionEntity.SpeedTestConfig speed_test_config = liveStreamingSessionEntity.getSpeed_test_config();
            if (speed_test_config == null) {
                return;
            }
            if (speed_test_config.getDuration() <= 0) {
                this.p = false;
            } else {
                this.p = true;
            }
        }
    }

    public void a() {
        if (this.p) {
            int i2 = this.o;
            if (i2 == 17) {
                this.D = 10;
                this.E = 3;
                this.F = 2;
                this.G = 5;
            } else if (i2 == 18) {
                this.D = 20;
                this.E = 5;
                this.F = 3;
                this.G = 10;
            }
        }
    }

    public boolean a(String str) {
        TXLivePusher tXLivePusher = this.n;
        if (tXLivePusher != null) {
            return tXLivePusher.sendMessageEx(str.getBytes());
        }
        return false;
    }

    public void b() {
        this.o = 17;
        a();
        e();
    }

    public void c() {
        this.o = 18;
        a();
        e();
    }

    public void d() {
        if (!this.p) {
            w();
        } else if (!this.q) {
            z.a(this.m, com.garena.android.appkit.tools.b.e(c.g.live_streaming_host_too_bad_network_notice));
        } else if (this.A != this.z) {
            if (this.i == null) {
                this.i = new com.shopee.live.livestreaming.ui.view.c.c((Activity) this.m);
            }
            this.i.k();
            this.i.a(com.garena.android.appkit.tools.b.e(c.g.live_streaming_host_bad_network_switch_config_permission), new c.a() {
                public void a(com.shopee.live.livestreaming.ui.view.c.c cVar) {
                    d dVar = d.this;
                    int unused = dVar.A = dVar.z;
                    int unused2 = d.this.H = 1;
                    d.this.l.a(d.this.A);
                    d dVar2 = d.this;
                    int unused3 = dVar2.C = dVar2.B;
                    d dVar3 = d.this;
                    dVar3.a(dVar3.y.getPush_stream_config().getCustom());
                    cVar.c();
                    d.this.w();
                }

                public void b(com.shopee.live.livestreaming.ui.view.c.c cVar) {
                    if (d.this.x() != -1) {
                        d dVar = d.this;
                        int unused = dVar.A = dVar.x();
                        int unused2 = d.this.H = 2;
                        d.this.l.a(d.this.A);
                        d dVar2 = d.this;
                        int unused3 = dVar2.C = dVar2.y();
                    }
                    d dVar3 = d.this;
                    dVar3.a(dVar3.y.getPush_stream_config().getCustom());
                    cVar.c();
                    d.this.w();
                }
            });
            f.a().c(true);
            this.i.a();
        } else {
            w();
        }
    }

    /* access modifiers changed from: private */
    public void w() {
        a aVar = this.f28850f;
        if (aVar != null) {
            aVar.a();
        }
    }

    private void d(Bundle bundle) {
        if (!com.shopee.live.livestreaming.util.d.a(bundle.getString(TXLiveConstants.NET_STATUS_SERVER_IP))) {
            this.r = true;
        }
    }

    public void e() {
        this.s = true;
    }

    public void f() {
        this.s = false;
    }

    public void g() {
        this.M.clear();
        this.l.a(0, 0, 0);
    }

    /* access modifiers changed from: private */
    public int x() {
        ArrayList<LiveStreamingSessionEntity.DefaultPushConfig> arrayList = this.f28849e;
        if (arrayList == null || arrayList.size() <= 2) {
            return -1;
        }
        return this.f28849e.get(1).getBitrate();
    }

    /* access modifiers changed from: private */
    public int y() {
        ArrayList<LiveStreamingSessionEntity.DefaultPushConfig> arrayList = this.f28849e;
        if (arrayList == null || arrayList.size() <= 2) {
            return -1;
        }
        return this.f28849e.get(1).getVideo_resolution();
    }

    public void h() {
        this.n.stopPusher();
    }

    public void i() {
        h();
        this.r = false;
        this.l.a();
        int i2 = this.o;
        if (i2 != 17) {
            if (i2 == 18) {
                LiveStreamingSessionEntity liveStreamingSessionEntity = this.y;
                if (liveStreamingSessionEntity == null) {
                    com.shopee.e.a.a.b("session entity is null, join failed or you doesn't call init.", new Object[0]);
                    this.v = "";
                } else {
                    this.v = liveStreamingSessionEntity.getSession().getPush_url();
                }
                SZTrackingReporter.getInstance().reportGeneralEvent(GeneralAction.ACTION_START_STREAM.getValue(), true);
            }
        } else if (this.p) {
            LiveStreamingSessionEntity liveStreamingSessionEntity2 = this.y;
            if (liveStreamingSessionEntity2 == null) {
                com.shopee.e.a.a.b("session entity is null, join failed or you doesn't call init.", new Object[0]);
                this.v = "";
            } else {
                this.v = liveStreamingSessionEntity2.getSpeed_test_config().getUrl();
            }
        } else {
            return;
        }
        if (!com.shopee.live.livestreaming.util.d.a(this.v)) {
            this.l.a(this.v);
            this.n.startPusher(this.v);
        }
    }

    public void j() {
        this.f28845a.onResume();
        this.n.resumePusher();
        if (!this.t) {
            this.f28848d.sendEmptyMessageDelayed(25, 2000);
        }
    }

    public void k() {
        this.f28845a.onPause();
        this.n.pausePusher();
        this.f28848d.removeMessages(25);
        this.t = false;
    }

    public void l() {
        this.n.stopCameraPreview(true);
        this.n.stopPusher();
        this.n.setPushListener((ITXLivePushListener) null);
        this.f28848d.removeCallbacksAndMessages((Object) null);
    }

    public void a(final int i2) {
        if (this.n != null && i2 >= 0) {
            k.a(new Callable<Object>() {
                public Object call() throws Exception {
                    int i = i2 / 10;
                    d.this.n.setBeautyFilter(0, i, i, i);
                    d.this.n.setEyeScaleLevel(i);
                    d.this.n.setFaceSlimLevel(i);
                    d.this.n.setFaceVLevel(i);
                    return null;
                }
            });
        }
    }

    public void m() {
        TXLivePusher tXLivePusher = this.n;
        if (tXLivePusher != null) {
            tXLivePusher.switchCamera();
        }
    }

    public void b(String str) {
        this.v = str;
    }

    public void b(LiveStreamingSessionEntity liveStreamingSessionEntity) {
        if (liveStreamingSessionEntity != null) {
            this.f28847c.a(liveStreamingSessionEntity);
            b(liveStreamingSessionEntity.getSession().getPush_url());
            SZTrackingReporter.getInstance().setVideoUrl(this.v);
        }
    }

    public void a(a aVar) {
        this.f28850f = aVar;
    }

    private void z() {
        if (this.w) {
            E();
            D();
            if (this.f28851g == null) {
                this.f28851g = new j((Activity) this.m);
            }
            if (!this.f28851g.b()) {
                this.f28851g.a(0, com.garena.android.appkit.tools.b.e(c.g.live_streaming_host_bad_network_tips));
                this.f28851g.a();
            }
            this.w = false;
            this.f28848d.sendEmptyMessageDelayed(21, 5000);
            this.f28848d.sendEmptyMessageDelayed(18, 10000);
            b.f();
        }
    }

    /* access modifiers changed from: private */
    public void A() {
        E();
        C();
        D();
        WrapLoadingView wrapLoadingView = this.k;
        if (wrapLoadingView != null) {
            wrapLoadingView.setVisibility(0);
            this.k.a();
            this.k.setLoadingText(com.garena.android.appkit.tools.b.e(c.g.live_streaming_network_reconnect_tip));
        }
    }

    private void B() {
        E();
        D();
        C();
    }

    /* access modifiers changed from: private */
    public void C() {
        j jVar = this.f28851g;
        if (jVar != null && jVar.b()) {
            this.f28851g.c();
        }
    }

    private void D() {
        WrapLoadingView wrapLoadingView = this.k;
        if (wrapLoadingView != null) {
            wrapLoadingView.b();
            this.k.setVisibility(8);
        }
    }

    private void E() {
        i iVar = this.h;
        if (iVar != null && iVar.b()) {
            this.h.c();
        }
    }

    private void F() {
        if (!((Activity) this.m).isFinishing()) {
            Context context = this.m;
            if (context instanceof LiveStreamingAnchorActivity) {
                ((LiveStreamingAnchorActivity) context).j.b();
            }
            C();
            this.k.b();
            E();
            if (this.h == null) {
                this.h = new i((Activity) this.m);
            }
            this.h.a(com.garena.android.appkit.tools.b.e(c.g.live_streaming_host_no_internet_alert_view_btn_try_again));
            this.h.a(com.garena.android.appkit.tools.b.a(c.b.main_color));
            this.h.b(true);
            this.h.a(false);
            this.h.a(com.garena.android.appkit.tools.b.e(c.g.live_streaming_host_no_internet_alert_view_title), new i.a() {
                public void a(i iVar) {
                    d.this.f28847c.a(0);
                    d.this.h.c();
                    b.d();
                }

                public void b(i iVar) {
                    d.this.h.c();
                    d.this.A();
                    d.this.f28848d.sendEmptyMessageDelayed(15, 1000);
                    b.e();
                }
            });
            this.h.a();
            b.c();
        }
    }

    public void a(TXLiveNetStatusLayout tXLiveNetStatusLayout) {
        this.l = tXLiveNetStatusLayout;
    }
}
