package com.tencent.liteav;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.TextureView;
import com.appsflyer.share.Constants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.imsdk.BaseConstants;
import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.b.a;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.b;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.liteav.network.h;
import com.tencent.liteav.renderer.a;
import com.tencent.liteav.renderer.g;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;
import java.lang.ref.WeakReference;

public class e extends o implements TXCRenderAndDec.a, a, h, a.C0490a, g {
    private float[] A;
    private String B;
    private int C;
    private TXLivePlayer.ITXAudioRawDataListener D;
    private String E;
    /* access modifiers changed from: private */
    public boolean F;
    private long G;
    private long H;
    /* access modifiers changed from: private */
    public boolean I;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public TXCRenderAndDec f31607a;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public com.tencent.liteav.renderer.a f31608f;

    /* renamed from: g  reason: collision with root package name */
    private TXCStreamDownloader f31609g;
    private Handler h;
    private TextureView i;
    private boolean j;
    private int k;
    private int l;
    private boolean m;
    private Surface n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private com.tencent.liteav.b.a s;
    /* access modifiers changed from: private */
    public TXRecordCommon.ITXVideoRecordListener t;
    private d u;
    private int v;
    private int w;
    private com.tencent.liteav.renderer.h x;
    private com.tencent.liteav.renderer.h y;
    private float[] z;

    public boolean f() {
        return true;
    }

    public e(Context context) {
        super(context);
        this.f31607a = null;
        this.f31608f = null;
        this.f31609g = null;
        this.j = false;
        this.k = 0;
        this.l = 0;
        this.m = false;
        this.o = 0;
        this.p = 0;
        this.q = 16;
        this.r = false;
        this.v = 0;
        this.w = 0;
        this.x = null;
        this.y = null;
        this.z = new float[]{1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, -1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED, 1.0f};
        this.A = new float[16];
        this.B = "";
        this.E = "";
        this.F = false;
        this.G = 0;
        this.H = 0;
        this.I = false;
        this.h = new Handler(Looper.getMainLooper());
        this.f31608f = new com.tencent.liteav.renderer.a();
        this.f31608f.a((com.tencent.liteav.basic.c.a) this);
    }

    public void a(TXCloudVideoView tXCloudVideoView) {
        if (!(this.f31852d == null || this.f31852d == tXCloudVideoView)) {
            TextureView videoView = this.f31852d.getVideoView();
            if (videoView != null) {
                this.f31852d.removeView(videoView);
            }
        }
        super.a(tXCloudVideoView);
        if (this.f31852d != null) {
            this.i = this.f31852d.getVideoView();
            if (this.i == null) {
                this.i = new TextureView(this.f31852d.getContext());
            }
            this.f31852d.addVideoView(this.i);
        }
        com.tencent.liteav.renderer.a aVar = this.f31608f;
        if (aVar != null) {
            aVar.a(this.i);
        }
    }

    public void a(Surface surface) {
        this.n = surface;
        com.tencent.liteav.renderer.a aVar = this.f31608f;
        if (aVar != null) {
            aVar.a(surface);
        }
    }

    public void a(int i2, int i3) {
        com.tencent.liteav.renderer.a aVar = this.f31608f;
        if (aVar != null) {
            aVar.c(i2, i3);
        }
    }

    public void a(g gVar) {
        super.a(gVar);
        TXCRenderAndDec tXCRenderAndDec = this.f31607a;
        if (tXCRenderAndDec != null) {
            tXCRenderAndDec.setConfig(gVar);
        }
    }

    public int a(String str, int i2) {
        if (c()) {
            TXCLog.w("TXCLivePlayer", "play: ignore start play when is playing");
            return -2;
        }
        this.B = str;
        this.C = i2;
        b(str);
        this.m = true;
        e(i2);
        int b2 = b(str, i2);
        if (b2 != 0) {
            this.m = false;
            l();
            k();
            TextureView textureView = this.i;
            if (textureView != null) {
                textureView.setVisibility(8);
            }
        } else {
            a(this.n);
            m();
            r();
            TXCDRApi.txReportDAU(this.f31851c, com.tencent.liteav.basic.datareport.a.bq);
            try {
                if (Class.forName("com.tencent.liteav.demo.play.SuperPlayerView") != null) {
                    TXCDRApi.txReportDAU(this.f31851c, com.tencent.liteav.basic.datareport.a.bB);
                }
            } catch (Exception unused) {
            }
        }
        return b2;
    }

    public int a(boolean z2) {
        if (!c()) {
            TXCLog.w("TXCLivePlayer", "play: ignore stop play when not started");
            return -2;
        }
        TXCLog.v("TXCLivePlayer", "play: stop");
        this.m = false;
        l();
        k();
        TextureView textureView = this.i;
        if (textureView != null && z2) {
            textureView.setVisibility(8);
        }
        com.tencent.liteav.renderer.a aVar = this.f31608f;
        if (aVar != null) {
            aVar.a((Surface) null);
        }
        n();
        s();
        o();
        return 0;
    }

    public int a(String str) {
        if (!c()) {
            return -1;
        }
        TXCStreamDownloader tXCStreamDownloader = this.f31609g;
        if (tXCStreamDownloader == null) {
            return -1;
        }
        boolean switchStream = tXCStreamDownloader.switchStream(str);
        if (this.f31607a != null) {
            TXCLog.w("TXCLivePlayer", " stream_switch video cache " + this.f31607a.getVideoCacheDuration() + " audio cache " + this.f31607a.getAudioCacheDuration());
        }
        if (!switchStream) {
            return -2;
        }
        this.B = str;
        return 0;
    }

    public void a() {
        a(false);
    }

    public void b() {
        a(this.B, this.C);
    }

    public boolean c() {
        return this.m;
    }

    public void a(int i2) {
        this.l = i2;
        TXCRenderAndDec tXCRenderAndDec = this.f31607a;
        if (tXCRenderAndDec != null) {
            tXCRenderAndDec.setRenderMode(i2);
        }
    }

    public void b(int i2) {
        this.k = i2;
        TXCRenderAndDec tXCRenderAndDec = this.f31607a;
        if (tXCRenderAndDec != null) {
            tXCRenderAndDec.setRenderRotation(i2);
        }
    }

    public void b(boolean z2) {
        this.j = z2;
        TXCRenderAndDec tXCRenderAndDec = this.f31607a;
        if (tXCRenderAndDec != null) {
            tXCRenderAndDec.setMute(this.j);
        }
    }

    public void a(Context context, int i2) {
        TXCRenderAndDec.setAudioMode(context, i2);
    }

    public void a(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        this.t = iTXVideoRecordListener;
    }

    public int c(int i2) {
        if (this.r) {
            TXCLog.e("TXCLivePlayer", "startRecord: there is existing uncompleted record task");
            return -1;
        }
        this.r = true;
        this.f31608f.a((g) this);
        this.f31608f.a((a.C0490a) this);
        TXCDRApi.txReportDAU(this.f31851c, com.tencent.liteav.basic.datareport.a.av);
        return 0;
    }

    public TextureView d() {
        return this.i;
    }

    public void a(TXLivePlayer.ITXAudioRawDataListener iTXAudioRawDataListener) {
        this.D = iTXAudioRawDataListener;
    }

    public int e() {
        if (!this.r) {
            TXCLog.w("TXCLivePlayer", "stopRecord: no recording task exist");
            return -1;
        }
        this.r = false;
        com.tencent.liteav.b.a aVar = this.s;
        if (aVar != null) {
            aVar.a();
            this.s = null;
        }
        return 0;
    }

    public void a(p pVar) {
        TXCRenderAndDec tXCRenderAndDec = this.f31607a;
        if (tXCRenderAndDec != null) {
            tXCRenderAndDec.setVideoFrameListener(pVar);
        } else {
            TXCLog.w("TXCLivePlayer", "setVideoFrameListener->enter with renderAndDec is empty");
        }
    }

    private void h() {
        if (this.s == null) {
            this.v = this.f31608f.m();
            this.w = this.f31608f.n();
            a.C0486a j2 = j();
            this.s = new com.tencent.liteav.b.a(this.f31851c);
            this.s.a(j2);
            this.s.a((a.b) new a.b() {
                public void a(int i, String str, String str2, String str3) {
                    if (e.this.t != null) {
                        TXRecordCommon.TXRecordResult tXRecordResult = new TXRecordCommon.TXRecordResult();
                        if (i == 0) {
                            tXRecordResult.retCode = 0;
                        } else {
                            tXRecordResult.retCode = -1;
                        }
                        tXRecordResult.descMsg = str;
                        tXRecordResult.videoPath = str2;
                        tXRecordResult.coverPath = str3;
                        e.this.t.onRecordComplete(tXRecordResult);
                    }
                    e.this.f31608f.a((g) null);
                    e.this.f31608f.a((a.C0490a) null);
                }

                public void a(long j) {
                    if (e.this.t != null) {
                        e.this.t.onRecordProgress(j);
                    }
                }
            });
        }
        if (this.x == null) {
            this.x = new com.tencent.liteav.renderer.h(true);
            this.x.b();
            this.x.b(this.v, this.w);
            this.x.a(this.v, this.w);
        }
        if (this.y == null) {
            this.y = new com.tencent.liteav.renderer.h(false);
            this.y.b();
            this.y.b(this.f31608f.k(), this.f31608f.l());
            this.y.a(this.f31608f.k(), this.f31608f.l());
            Matrix.setIdentityM(this.A, 0);
        }
    }

    private void i() {
        com.tencent.liteav.renderer.h hVar = this.x;
        if (hVar != null) {
            hVar.c();
            this.x = null;
        }
        com.tencent.liteav.renderer.h hVar2 = this.y;
        if (hVar2 != null) {
            hVar2.c();
            this.y = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        if (r1 > 0) goto L_0x000d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.tencent.liteav.b.a.C0486a j() {
        /*
            r7 = this;
            int r0 = r7.v
            if (r0 <= 0) goto L_0x0009
            int r1 = r7.w
            if (r1 <= 0) goto L_0x0009
            goto L_0x000d
        L_0x0009:
            r0 = 480(0x1e0, float:6.73E-43)
            r1 = 640(0x280, float:8.97E-43)
        L_0x000d:
            com.tencent.liteav.b.a$a r2 = new com.tencent.liteav.b.a$a
            r2.<init>()
            r2.f31220a = r0
            r2.f31221b = r1
            r3 = 20
            r2.f31222c = r3
            int r0 = r0 * r0
            double r3 = (double) r0
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            java.lang.Double.isNaN(r3)
            double r3 = r3 * r5
            int r1 = r1 * r1
            double r0 = (double) r1
            java.lang.Double.isNaN(r0)
            double r3 = r3 + r0
            double r0 = java.lang.Math.sqrt(r3)
            r3 = 4608083138725491507(0x3ff3333333333333, double:1.2)
            double r0 = r0 * r3
            int r0 = (int) r0
            r2.f31223d = r0
            int r0 = r7.o
            r2.h = r0
            int r0 = r7.p
            r2.i = r0
            int r0 = r7.q
            r2.j = r0
            android.content.Context r0 = r7.f31851c
            java.lang.String r1 = ".mp4"
            java.lang.String r0 = com.tencent.liteav.b.a.a((android.content.Context) r0, (java.lang.String) r1)
            r2.f31225f = r0
            android.content.Context r0 = r7.f31851c
            java.lang.String r1 = ".jpg"
            java.lang.String r0 = com.tencent.liteav.b.a.a((android.content.Context) r0, (java.lang.String) r1)
            r2.f31226g = r0
            com.tencent.liteav.renderer.a r0 = r7.f31608f
            javax.microedition.khronos.egl.EGLContext r0 = r0.b()
            r2.f31224e = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "record config: "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "TXCLivePlayer"
            com.tencent.liteav.basic.log.TXCLog.d(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.e.j():com.tencent.liteav.b.a$a");
    }

    private void e(int i2) {
        TextureView textureView = this.i;
        if (textureView != null) {
            textureView.setVisibility(0);
        }
        this.f31607a = new TXCRenderAndDec(this.f31851c);
        this.f31607a.setNotifyListener(this);
        this.f31607a.setVideoRender(this.f31608f);
        this.f31607a.setDecListener(this);
        this.f31607a.setConfig(this.f31850b);
        this.f31607a.setID(this.E);
        boolean z2 = true;
        if (i2 == 0) {
            this.f31607a.setStreamFormat(2);
        } else if (i2 == 5) {
            this.f31607a.setStreamFormat(5);
        } else {
            this.f31607a.setStreamFormat(1);
        }
        TXCRenderAndDec tXCRenderAndDec = this.f31607a;
        if (i2 != 5) {
            z2 = false;
        }
        tXCRenderAndDec.start(z2);
        this.f31607a.setMute(this.j);
        this.f31607a.setRenderMode(this.l);
        this.f31607a.setRenderRotation(this.k);
    }

    private void k() {
        TXCRenderAndDec tXCRenderAndDec = this.f31607a;
        if (tXCRenderAndDec != null) {
            tXCRenderAndDec.stop();
            this.f31607a.setVideoRender((com.tencent.liteav.renderer.e) null);
            this.f31607a.setDecListener((TXCRenderAndDec.a) null);
            this.f31607a.setNotifyListener((com.tencent.liteav.basic.c.a) null);
            this.f31607a = null;
        }
    }

    private int b(String str, int i2) {
        boolean z2 = false;
        if (i2 == 0) {
            this.f31609g = new TXCStreamDownloader(this.f31851c, 1);
        } else if (i2 == 5) {
            this.f31609g = new TXCStreamDownloader(this.f31851c, 4);
        } else {
            this.f31609g = new TXCStreamDownloader(this.f31851c, 0);
        }
        this.f31609g.setID(this.E);
        this.f31609g.setListener(this);
        this.f31609g.setNotifyListener(this);
        this.f31609g.setHeaders(this.f31850b.p);
        if (i2 == 5) {
            z2 = true;
        }
        if (z2) {
            this.f31609g.setRetryTimes(5);
            this.f31609g.setRetryInterval(1);
        } else {
            this.f31609g.setRetryTimes(this.f31850b.f31631e);
            this.f31609g.setRetryInterval(this.f31850b.f31632f);
        }
        return this.f31609g.start(str, this.f31850b.j, this.f31850b.l, this.f31850b.k);
    }

    private void l() {
        TXCStreamDownloader tXCStreamDownloader = this.f31609g;
        if (tXCStreamDownloader != null) {
            tXCStreamDownloader.setListener((h) null);
            this.f31609g.setNotifyListener((com.tencent.liteav.basic.c.a) null);
            this.f31609g.stop();
            this.f31609g = null;
        }
    }

    private void m() {
        this.u = new d(this.f31851c);
        this.u.a(this.B);
        this.u.a(this.C == 5);
        this.u.d(this.E);
        this.u.a();
    }

    private void n() {
        d dVar = this.u;
        if (dVar != null) {
            dVar.c();
            this.u = null;
        }
    }

    private void b(String str) {
        this.E = String.format("%s-%d", new Object[]{str, Long.valueOf(TXCTimeUtil.getTimeTick() % 10000)});
        TXCRenderAndDec tXCRenderAndDec = this.f31607a;
        if (tXCRenderAndDec != null) {
            tXCRenderAndDec.setID(this.E);
        }
        com.tencent.liteav.renderer.a aVar = this.f31608f;
        if (aVar != null) {
            aVar.setID(this.E);
        }
        TXCStreamDownloader tXCStreamDownloader = this.f31609g;
        if (tXCStreamDownloader != null) {
            tXCStreamDownloader.setID(this.E);
        }
        d dVar = this.u;
        if (dVar != null) {
            dVar.d(this.E);
        }
    }

    public void g() {
        this.H = 0;
        if (!this.F) {
            this.F = true;
            Handler handler = this.h;
            if (handler != null) {
                handler.postDelayed(new Runnable() {
                    public void run() {
                        if (e.this.F) {
                            e.this.q();
                        }
                    }
                }, 1000);
            }
        }
    }

    private void o() {
        this.F = false;
    }

    /* access modifiers changed from: private */
    public void q() {
        if (this.G > 0) {
            Bundle bundle = new Bundle();
            bundle.putInt(TXLiveConstants.EVT_PLAY_PROGRESS, (int) (this.G / 1000));
            bundle.putInt(TXLiveConstants.EVT_PLAY_PROGRESS_MS, (int) this.G);
            onNotifyEvent(2005, bundle);
        }
        Handler handler = this.h;
        if (handler != null && this.F) {
            handler.postDelayed(new Runnable() {
                public void run() {
                    if (e.this.F) {
                        e.this.q();
                    }
                }
            }, 1000);
        }
    }

    private void r() {
        this.I = true;
        Handler handler = this.h;
        if (handler != null) {
            handler.postDelayed(new Runnable() {
                public void run() {
                    if (e.this.I) {
                        e.this.t();
                    }
                }
            }, 2000);
        }
    }

    private void s() {
        this.I = false;
    }

    /* access modifiers changed from: private */
    public void t() {
        int[] a2 = b.a();
        String str = (a2[0] / 10) + Constants.URL_PATH_DELIMITER + (a2[1] / 10) + "%";
        int c2 = TXCStatus.c(this.E, 7102);
        int c3 = TXCStatus.c(this.E, 7101);
        String b2 = TXCStatus.b(this.E, 7110);
        int d2 = (int) TXCStatus.d(this.E, BaseConstants.ERR_SERIALIZE_REQ_FAILED);
        Bundle bundle = new Bundle();
        com.tencent.liteav.renderer.a aVar = this.f31608f;
        if (aVar != null) {
            bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_WIDTH, aVar.m());
            bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_HEIGHT, this.f31608f.n());
        }
        TXCRenderAndDec tXCRenderAndDec = this.f31607a;
        if (tXCRenderAndDec != null) {
            bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_CACHE, (int) tXCRenderAndDec.getVideoCacheDuration());
            bundle.putInt(TXLiveConstants.NET_STATUS_AUDIO_CACHE, (int) this.f31607a.getAudioCacheDuration());
            bundle.putInt(TXLiveConstants.NET_STATUS_V_SUM_CACHE_SIZE, (int) this.f31607a.getVideoCacheFrameCount());
            bundle.putInt(TXLiveConstants.NET_STATUS_V_DEC_CACHE_SIZE, this.f31607a.getVideoDecCacheFrameCount());
            bundle.putInt(TXLiveConstants.NET_STATUS_AV_PLAY_INTERVAL, (int) this.f31607a.getAVPlayInterval());
            bundle.putString(TXLiveConstants.NET_STATUS_AUDIO_INFO, this.f31607a.getAudioInfo());
            bundle.putInt(TXLiveConstants.NET_STATUS_NET_JITTER, this.f31607a.getAudioJitter());
            bundle.putInt(TXLiveConstants.NET_STATUS_AV_RECV_INTERVAL, (int) this.f31607a.getAVNetRecvInterval());
            bundle.putFloat(TXLiveConstants.NET_STATUS_AUDIO_CACHE_THRESHOLD, this.f31607a.getAudioCacheThreshold());
            double c4 = (double) (((float) ((TXCStatus.c(this.E, 7120) * 10) / (d2 == 0 ? 15 : d2))) / 10.0f);
            Double.isNaN(c4);
            bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_GOP, (int) (c4 + 0.5d));
        }
        bundle.putInt(TXLiveConstants.NET_STATUS_NET_SPEED, c3 + c2);
        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_FPS, d2);
        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE, c3);
        bundle.putInt(TXLiveConstants.NET_STATUS_AUDIO_BITRATE, c2);
        bundle.putCharSequence(TXLiveConstants.NET_STATUS_SERVER_IP, b2);
        bundle.putCharSequence(TXLiveConstants.NET_STATUS_CPU_USAGE, str);
        b.a((WeakReference<com.tencent.liteav.basic.c.a>) this.f31853e, 15001, bundle);
        TXCRenderAndDec tXCRenderAndDec2 = this.f31607a;
        if (tXCRenderAndDec2 != null) {
            tXCRenderAndDec2.updateLoadInfo();
        }
        d dVar = this.u;
        if (dVar != null) {
            dVar.f();
        }
        Handler handler = this.h;
        if (handler != null && this.I) {
            handler.postDelayed(new Runnable() {
                public void run() {
                    if (e.this.I) {
                        e.this.t();
                    }
                }
            }, 2000);
        }
    }

    public void onPullAudio(com.tencent.liteav.basic.structs.a aVar) {
        if (this.m) {
            TXCRenderAndDec tXCRenderAndDec = this.f31607a;
            if (tXCRenderAndDec != null) {
                tXCRenderAndDec.decAudio(aVar);
            }
        }
    }

    public void onPullNAL(TXSNALPacket tXSNALPacket) {
        if (this.m) {
            try {
                if (this.f31607a != null) {
                    this.f31607a.decVideo(tXSNALPacket);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void onNotifyEvent(final int i2, final Bundle bundle) {
        if (-2302 == i2) {
            TXCRenderAndDec tXCRenderAndDec = this.f31607a;
            if (tXCRenderAndDec != null) {
                tXCRenderAndDec.setSmoothMode((int) com.tencent.liteav.basic.e.b.a().a("Audio", "SmoothModeAdjust"));
            }
        }
        Handler handler = this.h;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    b.a((WeakReference<com.tencent.liteav.basic.c.a>) e.this.f31853e, i2, bundle);
                    if (i2 == 2103 && e.this.f31607a != null) {
                        e.this.f31607a.restartDecoder();
                    }
                }
            });
        }
    }

    public int a(int i2, float[] fArr) {
        com.tencent.liteav.b.a aVar = this.s;
        if (this.r && aVar != null) {
            com.tencent.liteav.renderer.h hVar = this.x;
            if (hVar != null) {
                int d2 = hVar.d(i2);
                aVar.a(d2, TXCTimeUtil.getTimeTick());
                this.f31608f.a(d2, this.v, this.w, false, 0);
            }
        }
        if (this.r) {
            h();
        } else {
            i();
        }
        return i2;
    }

    public void onTextureProcess(int i2, int i3, int i4) {
        com.tencent.liteav.b.a aVar = this.s;
        if (this.r && aVar != null) {
            com.tencent.liteav.renderer.h hVar = this.y;
            if (hVar != null) {
                hVar.a(this.z);
                aVar.a(this.y.d(i2), TXCTimeUtil.getTimeTick());
                this.y.a(this.A);
                this.y.c(i2);
            }
        }
        if (this.r) {
            h();
        } else {
            i();
        }
    }

    public void a(SurfaceTexture surfaceTexture) {
        i();
        e();
    }

    public void a(byte[] bArr, long j2, int i2, int i3) {
        if (this.s != null) {
            if (j2 <= 0) {
                j2 = TXCTimeUtil.getTimeTick();
            }
            this.s.a(bArr, j2);
        }
        TXLivePlayer.ITXAudioRawDataListener iTXAudioRawDataListener = this.D;
        if (iTXAudioRawDataListener != null) {
            iTXAudioRawDataListener.onPcmDataAvailable(bArr, j2);
        }
        long j3 = this.H;
        if (j3 <= 0) {
            this.H = j2;
            com.tencent.liteav.basic.structs.a aVar = new com.tencent.liteav.basic.structs.a();
            aVar.f31397a = i2;
            aVar.f31398b = i3;
            aVar.f31399c = 16;
            a(aVar);
            return;
        }
        this.G = j2 - j3;
    }

    public void a(com.tencent.liteav.basic.structs.a aVar) {
        TXCLog.d("TXCLivePlayer", "onPlayAudioInfoChanged, samplerate=" + aVar.f31397a + ", channels=" + aVar.f31398b + ", bits=" + aVar.f31399c);
        this.o = aVar.f31398b;
        this.p = aVar.f31397a;
        if (aVar.f31399c > 1) {
            this.q = aVar.f31399c;
        }
        TXLivePlayer.ITXAudioRawDataListener iTXAudioRawDataListener = this.D;
        if (iTXAudioRawDataListener != null) {
            iTXAudioRawDataListener.onAudioInfoChanged(aVar.f31397a, aVar.f31398b, aVar.f31399c);
        }
    }
}
