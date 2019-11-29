package com.shopee.live.livestreaming.b;

import android.content.Context;
import android.os.Bundle;
import com.shopee.live.livestreaming.b.b;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class d implements a {

    /* renamed from: a  reason: collision with root package name */
    private TXLivePlayer f28781a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public b.C0438b f28782b = new b.C0438b("", false, 0, 0, false);

    /* renamed from: c  reason: collision with root package name */
    private b.a f28783c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f28784d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f28785e;

    public void a(int i) {
    }

    public d(Context context) {
        this.f28781a = new TXLivePlayer(context);
    }

    public void a(TXCloudVideoView tXCloudVideoView) {
        this.f28781a.setPlayerView(tXCloudVideoView);
        d();
    }

    public void a(b.a aVar) {
        this.f28783c = aVar;
    }

    public void a(boolean z) {
        this.f28781a.setRenderMode(z ? 1 : 0);
    }

    public void a(boolean z, float f2, float f3, float f4) {
        TXLivePlayConfig tXLivePlayConfig = new TXLivePlayConfig();
        tXLivePlayConfig.setCacheTime(f4);
        tXLivePlayConfig.setAutoAdjustCacheTime(z);
        tXLivePlayConfig.setMinAutoAdjustCacheTime(f2);
        tXLivePlayConfig.setMaxAutoAdjustCacheTime(f3);
        this.f28781a.setConfig(tXLivePlayConfig);
    }

    public void a(String str, int i) {
        if (this.f28781a.startPlay(str, i) == 0) {
            this.f28782b.a("buffering");
            c(true);
        }
    }

    public void a() {
        if (this.f28781a.isPlaying()) {
            this.f28781a.pause();
            c(false);
        }
    }

    public void b() {
        this.f28781a.stopPlay(true);
        c(false);
    }

    public void b(boolean z) {
        this.f28781a.setMute(z);
        if (this.f28782b.e() != z) {
            this.f28782b.b(z);
            c().a(this.f28782b);
        }
    }

    private void c(boolean z) {
        if (z != this.f28782b.b()) {
            this.f28782b.a(z);
            c().a(this.f28782b);
        }
    }

    /* access modifiers changed from: private */
    public b.a c() {
        b.a aVar = this.f28783c;
        return aVar == null ? new b.a() {
            public void a(b.C0438b bVar) {
            }

            public void c(int i) {
            }
        } : aVar;
    }

    private void d() {
        this.f28781a.setRenderMode(0);
        this.f28781a.setRenderRotation(0);
        this.f28781a.setPlayListener(new ITXLivePlayListener() {
            public void onNetStatus(Bundle bundle) {
            }

            public void onPlayEvent(int i, Bundle bundle) {
                boolean z = false;
                if (i == -2301) {
                    d.this.f28782b.a("error");
                    d.this.f28782b.a(false);
                    d.this.c().a(d.this.f28782b);
                } else if (i == 2003) {
                    boolean unused = d.this.f28784d = true;
                    if (d.this.f28785e) {
                        d.this.f28782b.a("ready");
                        d.this.f28782b.a(true);
                        d.this.c().a(d.this.f28782b);
                    }
                } else if (i == 2006) {
                    d.this.f28782b.a("ended");
                    d.this.f28782b.a(false);
                    d.this.c().a(d.this.f28782b);
                } else if (i == 2009) {
                    int i2 = bundle.getInt("EVT_PARAM1", 0);
                    int i3 = bundle.getInt("EVT_PARAM2", 0);
                    if (!(i2 == d.this.f28782b.f() && i3 == d.this.f28782b.g())) {
                        z = true;
                    }
                    d.this.f28782b.c(i2);
                    d.this.f28782b.d(i3);
                    if (z) {
                        boolean unused2 = d.this.f28785e = true;
                        if (d.this.f28784d) {
                            d.this.f28782b.a("ready");
                            d.this.f28782b.a(true);
                            d.this.c().a(d.this.f28782b);
                        }
                    }
                }
            }
        });
    }
}
