package com.shopee.live.livestreaming.b;

import android.content.Context;
import android.os.Bundle;
import com.shopee.live.livestreaming.b.b;
import com.tencent.rtmp.ITXVodPlayListener;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXVodPlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private TXVodPlayer f28788a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public b.C0438b f28789b = new b.C0438b("", false, 0, 0, false);

    /* renamed from: c  reason: collision with root package name */
    private b.a f28790c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f28791d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f28792e;

    public e(Context context) {
        this.f28788a = new TXVodPlayer(context);
    }

    public void a(TXCloudVideoView tXCloudVideoView) {
        this.f28788a.setPlayerView(tXCloudVideoView);
        d();
    }

    public void a(b.a aVar) {
        this.f28790c = aVar;
    }

    public void a(boolean z) {
        this.f28788a.setRenderMode(z ? 1 : 0);
    }

    public void a(String str, int i) {
        if (this.f28788a.startPlay(str) == 0) {
            this.f28789b.a("buffering");
            c(true);
        }
    }

    public void a() {
        if (this.f28788a.isPlaying()) {
            this.f28788a.pause();
            c(false);
        }
    }

    public void b() {
        this.f28788a.stopPlay(true);
        c(false);
    }

    public void a(int i) {
        this.f28788a.seek(i);
    }

    public void b(boolean z) {
        this.f28788a.setMute(z);
        if (this.f28789b.e() != z) {
            this.f28789b.b(z);
            c().a(this.f28789b);
        }
    }

    private void c(boolean z) {
        if (z != this.f28789b.b()) {
            this.f28789b.a(z);
            c().a(this.f28789b);
        }
    }

    /* access modifiers changed from: private */
    public b.a c() {
        b.a aVar = this.f28790c;
        return aVar == null ? new b.a() {
            public void a(b.C0438b bVar) {
            }

            public void c(int i) {
            }
        } : aVar;
    }

    private void d() {
        this.f28788a.setRenderMode(0);
        this.f28788a.setRenderRotation(0);
        this.f28788a.setVodListener(new ITXVodPlayListener() {
            public void onNetStatus(TXVodPlayer tXVodPlayer, Bundle bundle) {
            }

            public void onPlayEvent(TXVodPlayer tXVodPlayer, int i, Bundle bundle) {
                boolean z = false;
                if (i == -2301) {
                    e.this.f28789b.a("error");
                    e.this.f28789b.a(false);
                    e.this.c().a(e.this.f28789b);
                } else if (i == 2003) {
                    boolean unused = e.this.f28791d = true;
                    if (e.this.f28792e) {
                        e.this.f28789b.a("ready");
                        e.this.f28789b.a(true);
                        e.this.c().a(e.this.f28789b);
                    }
                } else if (i == 2009) {
                    int i2 = bundle.getInt("EVT_PARAM1", 0);
                    int i3 = bundle.getInt("EVT_PARAM2", 0);
                    if (!(i2 == e.this.f28789b.f() && i3 == e.this.f28789b.g())) {
                        z = true;
                    }
                    e.this.f28789b.c(i2);
                    e.this.f28789b.d(i3);
                    if (z) {
                        boolean unused2 = e.this.f28792e = true;
                        if (e.this.f28791d) {
                            e.this.f28789b.a("ready");
                            e.this.f28789b.a(true);
                            e.this.c().a(e.this.f28789b);
                        }
                    }
                } else if (i != 2014) {
                    switch (i) {
                        case 2005:
                            int i4 = bundle.getInt(TXLiveConstants.EVT_PLAY_DURATION);
                            e.this.f28789b.a(i4);
                            int i5 = bundle.getInt(TXLiveConstants.EVT_PLAY_PROGRESS);
                            if (i5 <= i4) {
                                i4 = i5;
                            }
                            e.this.f28789b.b(i4);
                            e.this.c().c(i4);
                            return;
                        case 2006:
                            e.this.f28789b.a("ended");
                            e.this.f28789b.a(false);
                            e.this.c().a(e.this.f28789b);
                            return;
                        case 2007:
                            e.this.f28789b.a("buffering");
                            e.this.f28789b.a(true);
                            e.this.c().a(e.this.f28789b);
                            return;
                        default:
                            return;
                    }
                } else {
                    e.this.f28789b.a("ready");
                    e.this.f28789b.a(true);
                    e.this.c().a(e.this.f28789b);
                }
            }
        });
    }
}
