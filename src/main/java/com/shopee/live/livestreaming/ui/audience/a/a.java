package com.shopee.live.livestreaming.ui.audience.a;

import android.content.Context;
import android.view.View;

import com.garena.android.appkit.f.f;
import com.shopee.live.livestreaming.b;
import com.shopee.live.livestreaming.sztracking.SZTrackingReporter;
import com.shopee.live.livestreaming.sztracking.proto.GeneralAction;
import com.shopee.live.livestreaming.util.z;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f28930a;

    /* renamed from: b  reason: collision with root package name */
    private TXLivePlayer txLivePlayer;

    /* renamed from: c  reason: collision with root package name */
    private final com.shopee.live.livestreaming.ui.audience.a.b f28932c = new com.shopee.live.livestreaming.ui.audience.a.b();

    /* renamed from: d  reason: collision with root package name */
    private TXLivePlayConfig txLivePlayConfig;

    /* renamed from: e  reason: collision with root package name */
    private TXCloudVideoView txCloudVideoView;

    /* renamed from: f  reason: collision with root package name */
    private ITXLivePlayListener livePlayListener;

    /* renamed from: g  reason: collision with root package name */
    private com.shopee.live.livestreaming.util.a onAudioFocusListener;
    private String h;
    private float i;
    private boolean j;

    public static a a() {
        if (f28930a == null) {
            synchronized (a.class) {
                if (f28930a == null) {
                    f28930a = new a(b.b().c());
                }
            }
        }
        return f28930a;
    }

    public static boolean b() {
        return f28930a != null;
    }

    private static void n() {
        boolean ifTXLogEnable = b.b().a().ifTXLogEnable();
        try {
            String sDKVersionStr = TXLiveBase.getSDKVersionStr();
            com.shopee.e.a.a.a((Object) "Liteav sdk version: " + sDKVersionStr);
            TXLiveBase.setConsoleEnabled(ifTXLogEnable);
            TXLiveBase.setLogLevel(ifTXLogEnable ? 1 : 6);
            if (ifTXLogEnable) {
                z.a(b.b().f28742b, "liteav sdk log enable.");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private a(Context context) {
        n();// init log
        this.txLivePlayer = new TXLivePlayer(context);
        this.txLivePlayConfig = new TXLivePlayConfig();
        this.txLivePlayConfig.setEnableMessage(true);
        this.onAudioFocusListener = new com.shopee.live.livestreaming.util.a(context);
        this.f28932c.a(0).b(0).a(this.txLivePlayConfig);
        a(this.f28932c);
    }

    public a a(TXCloudVideoView tXCloudVideoView) {
        i();
        this.txCloudVideoView = tXCloudVideoView;
        this.txLivePlayer.setPlayerView(tXCloudVideoView);
        return this;
    }

    public a a(ITXLivePlayListener iTXLivePlayListener) {
        this.livePlayListener = iTXLivePlayListener;
        this.txLivePlayer.setPlayListener(this.livePlayListener);
        return this;
    }

    public void a(boolean z, double d2, double d3) {
        this.f28932c.a(0).b(0).a(this.txLivePlayConfig).a(z, d2, d3);
        a(this.f28932c);
    }

    public String c() {
        return this.h;
    }

    public void a(String str) {
        if (this.txCloudVideoView != null) {
            int i2 = 1;
            if (str != null && str.contains("rtmp")) {
                i2 = 0;
            }
            try {
                if (this.txLivePlayer.startPlay(str, i2) == 0) {
                    this.txCloudVideoView.setVisibility(View.VISIBLE);
                } else {
                    this.txCloudVideoView.setVisibility(View.GONE);
                }
                SZTrackingReporter.getInstance().reportGeneralEvent(GeneralAction.ACTION_START_STREAM.getValue(), false);
            } catch (Exception unused) {
                this.txCloudVideoView.setVisibility(View.GONE);
            }
            this.h = str;
            this.f28932c.a(0).b(0).a(this.txLivePlayConfig);
            a(this.f28932c);
            com.shopee.live.livestreaming.util.a aVar = this.onAudioFocusListener;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void d() {
        TXLivePlayer tXLivePlayer = this.txLivePlayer;
        if (tXLivePlayer != null && tXLivePlayer.isPlaying()) {
            this.txLivePlayer.pause();
            com.shopee.live.livestreaming.util.a aVar = this.onAudioFocusListener;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    public void e() {
        TXLivePlayer tXLivePlayer = this.txLivePlayer;
        if (tXLivePlayer != null && !tXLivePlayer.isPlaying()) {
            this.txLivePlayer.resume();
            this.f28932c.a(0).b(0).a(this.txLivePlayConfig);
            a(this.f28932c);
            com.shopee.live.livestreaming.util.a aVar = this.onAudioFocusListener;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void f() {
        Runnable r0 = new Runnable() {
            public void run() {
                a.this.e();
            }
        };
        f.a().a(r0, 0);
        f.a().a(r0, 100);
        f.a().a(r0, 500);
        f.a().a(r0, 1000);
    }

    public void g() {
        this.txLivePlayer.stopPlay(true);
        com.shopee.live.livestreaming.util.a aVar = this.onAudioFocusListener;
        if (aVar != null) {
            aVar.b();
        }
    }

    public boolean h() {
        return this.txLivePlayer.isPlaying();
    }

    public void i() {
        TXCloudVideoView tXCloudVideoView = this.txCloudVideoView;
        if (tXCloudVideoView != null) {
            tXCloudVideoView.onDestroy();
            this.txCloudVideoView = null;
        }
    }

    public static void j() {
        a aVar = f28930a;
        if (aVar != null) {
            aVar.txLivePlayer.setPlayListener((ITXLivePlayListener) null);
            a aVar2 = f28930a;
            aVar2.livePlayListener = null;
            aVar2.i();
            f28930a = null;
        }
    }

    // com.tencent.rtmp.TXLivePlayer, init txliveplayer
    public void a(com.shopee.live.livestreaming.ui.audience.a.b bVar) {
        bVar.a(this.txLivePlayer);
    }

    // com.tencent.rtmp.TXLivePlayer, init txliveplayer (tanpa parameter)
    public void k() {
        // passing txLivePlayConfig
        a(new com.shopee.live.livestreaming.ui.audience.a.b().a(0).b(0).a(this.txLivePlayConfig));
    }

    public float l() {
        return this.i;
    }

    public void a(float f2) {
        this.i = f2;
    }

    public boolean m() {
        return this.j;
    }

    public void a(boolean z) {
        this.j = z;
    }
}
