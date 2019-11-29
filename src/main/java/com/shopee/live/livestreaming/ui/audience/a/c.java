package com.shopee.live.livestreaming.ui.audience.a;

import android.content.Context;
import com.shopee.live.livestreaming.b;
import com.shopee.live.livestreaming.util.a;
import com.tencent.rtmp.ITXVodPlayListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXVodPlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f28945a;

    /* renamed from: g  reason: collision with root package name */
    private static float f28946g;
    private static boolean h;

    /* renamed from: b  reason: collision with root package name */
    private TXVodPlayer f28947b;

    /* renamed from: c  reason: collision with root package name */
    private TXCloudVideoView f28948c;

    /* renamed from: d  reason: collision with root package name */
    private a f28949d;

    /* renamed from: e  reason: collision with root package name */
    private String f28950e;

    /* renamed from: f  reason: collision with root package name */
    private int f28951f;

    public static void a() {
        try {
            String sDKVersionStr = TXLiveBase.getSDKVersionStr();
            com.shopee.e.a.a.a((Object) "TXLive sdk version: " + sDKVersionStr);
            TXLiveBase.setConsoleEnabled(true);
            TXLiveBase.setLogLevel(1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static c b() {
        if (f28945a == null) {
            synchronized (c.class) {
                if (f28945a == null) {
                    f28945a = new c(b.b().c());
                }
            }
        }
        return f28945a;
    }

    public static boolean c() {
        return f28945a != null;
    }

    private c(Context context) {
        this.f28947b = new TXVodPlayer(context);
        this.f28947b.setRenderMode(0);
        this.f28947b.setRenderRotation(0);
        this.f28949d = new a(context);
    }

    public c a(TXCloudVideoView tXCloudVideoView) {
        i();
        this.f28948c = tXCloudVideoView;
        this.f28947b.setPlayerView(tXCloudVideoView);
        return this;
    }

    public String d() {
        return this.f28950e;
    }

    public void a(String str) {
        this.f28950e = str;
        this.f28947b.startPlay(str);
        a aVar = this.f28949d;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void e() {
        TXVodPlayer tXVodPlayer = this.f28947b;
        if (tXVodPlayer != null && tXVodPlayer.isPlaying()) {
            this.f28947b.pause();
            a aVar = this.f28949d;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    public void f() {
        TXVodPlayer tXVodPlayer = this.f28947b;
        if (tXVodPlayer != null && !tXVodPlayer.isPlaying()) {
            this.f28947b.resume();
            a aVar = this.f28949d;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void g() {
        TXVodPlayer tXVodPlayer = this.f28947b;
        if (tXVodPlayer != null) {
            tXVodPlayer.stopPlay(true);
            a((ITXVodPlayListener) null);
            a aVar = this.f28949d;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    public boolean h() {
        return this.f28947b.isPlaying();
    }

    public void i() {
        TXCloudVideoView tXCloudVideoView = this.f28948c;
        if (tXCloudVideoView != null) {
            tXCloudVideoView.onDestroy();
            this.f28948c = null;
        }
    }

    public static void j() {
        c cVar = f28945a;
        if (cVar != null) {
            cVar.i();
            f28945a.g();
            f28945a = null;
        }
    }

    public void a(int i) {
        this.f28947b.seek(i);
        b(i);
    }

    public void b(int i) {
        this.f28951f = i;
    }

    public void a(ITXVodPlayListener iTXVodPlayListener) {
        TXVodPlayer tXVodPlayer = this.f28947b;
        if (tXVodPlayer != null) {
            tXVodPlayer.setVodListener(iTXVodPlayListener);
        }
    }

    public static float k() {
        return f28946g;
    }

    public static void a(float f2) {
        f28946g = f2;
    }

    public static boolean l() {
        return h;
    }

    public static void a(boolean z) {
        h = z;
    }
}
