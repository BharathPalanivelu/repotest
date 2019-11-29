package com.shopee.livequiz.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import com.garena.android.appkit.d.a;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private Context f29836a;

    /* renamed from: b  reason: collision with root package name */
    private TXLivePlayer f29837b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public TXCloudVideoView f29838c;

    /* renamed from: d  reason: collision with root package name */
    private ITXLivePlayListener f29839d = new ITXLivePlayListener() {
        public void onPlayEvent(int i, Bundle bundle) {
            a.b("get play event: " + i, new Object[0]);
            if (i == -2301) {
                a.b("play failed", new Object[0]);
                if (c.this.f29840e != null) {
                    c.this.f29840e.a();
                }
            } else if (i == 2006) {
                a.b("play end", new Object[0]);
                c.this.f29838c.setVisibility(8);
                if (c.this.f29840e != null) {
                    c.this.f29840e.b();
                }
            } else if (i == 2004) {
                a.b("play begin", new Object[0]);
                boolean unused = c.this.h = true;
                c.this.f29838c.setVisibility(0);
                if (c.this.f29840e != null) {
                    c.this.f29840e.c();
                }
            } else if (i == 2007) {
                if (c.this.i <= 3) {
                    c.d(c.this);
                }
                if (c.this.i == 3 && c.this.f29840e != null && c.this.e()) {
                    c.this.f29840e.d();
                }
            } else if (i == 2012) {
                a.b("get message", new Object[0]);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.f29842g > 1000) {
                    byte[] byteArray = bundle.getByteArray(TXLiveConstants.EVT_GET_MSG);
                    if (byteArray != null) {
                        c cVar = c.this;
                        long unused2 = cVar.f29841f = cVar.a(byteArray);
                        if (c.this.f29840e != null) {
                            c.this.f29840e.a(c.this.f29841f);
                        }
                    }
                    long unused3 = c.this.f29842g = currentTimeMillis;
                }
            }
        }

        public void onNetStatus(Bundle bundle) {
            String string = bundle.getString(TXLiveConstants.NET_STATUS_SERVER_IP);
            if (!"null".equals(string)) {
                String unused = c.this.j = string;
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public com.shopee.c.a f29840e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public long f29841f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public long f29842g;
    /* access modifiers changed from: private */
    public boolean h;
    /* access modifiers changed from: private */
    public int i = 0;
    /* access modifiers changed from: private */
    public String j;

    static /* synthetic */ int d(c cVar) {
        int i2 = cVar.i;
        cVar.i = i2 + 1;
        return i2;
    }

    public c(Context context, TXCloudVideoView tXCloudVideoView) {
        this.f29838c = tXCloudVideoView;
        this.f29836a = context;
        this.f29837b = new TXLivePlayer(context);
        TXLivePlayConfig tXLivePlayConfig = new TXLivePlayConfig();
        this.f29837b.setRenderMode(0);
        this.f29837b.setRenderRotation(0);
        tXLivePlayConfig.setEnableMessage(true);
        tXLivePlayConfig.setAutoAdjustCacheTime(true);
        tXLivePlayConfig.setMinAutoAdjustCacheTime(1.0f);
        tXLivePlayConfig.setMaxAutoAdjustCacheTime(1.0f);
        this.f29837b.setConfig(tXLivePlayConfig);
        this.f29837b.setPlayerView(this.f29838c);
        this.f29838c.setVisibility(0);
    }

    public void a(String str, int i2) {
        a.b("startPlay: " + str + ", type" + i2, new Object[0]);
        this.f29842g = 0;
        this.f29837b.setPlayListener(this.f29839d);
        try {
            if (this.f29837b.startPlay(str, i2) == 0) {
                this.f29838c.setVisibility(0);
            } else {
                this.f29838c.setVisibility(8);
            }
        } catch (Exception unused) {
            this.f29838c.setVisibility(8);
        }
    }

    public void a() {
        TXLivePlayer tXLivePlayer = this.f29837b;
        if (tXLivePlayer != null && tXLivePlayer.isPlaying()) {
            a.b("pause", new Object[0]);
            this.f29837b.pause();
        }
    }

    public void b() {
        TXLivePlayer tXLivePlayer = this.f29837b;
        if (tXLivePlayer != null && !tXLivePlayer.isPlaying()) {
            a.b("resume", new Object[0]);
            this.f29837b.resume();
        }
    }

    public void c() {
        this.f29837b.stopPlay(true);
        this.f29838c.onDestroy();
        this.f29837b = null;
        this.f29840e = null;
    }

    public void a(com.shopee.c.a aVar) {
        this.f29840e = aVar;
    }

    public String d() {
        String str = this.j;
        return str == null ? "" : str;
    }

    /* access modifiers changed from: private */
    public boolean e() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f29836a.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 0;
    }

    /* access modifiers changed from: private */
    public long a(byte[] bArr) {
        byte[] bArr2 = bArr;
        byte[] bArr3 = new byte[8];
        int length = bArr3.length - 1;
        int length2 = bArr2.length - 1;
        while (length >= 0) {
            if (length2 >= 0) {
                bArr3[length] = bArr2[length2];
            } else {
                bArr3[length] = 0;
            }
            length--;
            length2--;
        }
        return (((long) (bArr3[0] & 255)) << 56) + (((long) (bArr3[1] & 255)) << 48) + (((long) (bArr3[2] & 255)) << 40) + (((long) (bArr3[3] & 255)) << 32) + (((long) (bArr3[4] & 255)) << 24) + (((long) (bArr3[5] & 255)) << 16) + (((long) (bArr3[6] & 255)) << 8) + ((long) (bArr3[7] & 255));
    }
}
