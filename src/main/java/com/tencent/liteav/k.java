package com.tencent.liteav;

import android.content.Context;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView;
import com.appsflyer.share.Constants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.ijk.media.player.IjkBitrateItem;
import com.tencent.ijk.media.player.MediaInfo;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.b;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView;
import com.tencent.liteav.txcvodplayer.TextureRenderView;
import com.tencent.liteav.txcvodplayer.d;
import com.tencent.liteav.txcvodplayer.e;
import com.tencent.rtmp.TXBitrateItem;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXVodPlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.ArrayList;
import java.util.Iterator;

public class k extends o {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f31661a;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public TXCVodVideoView f31662f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public d f31663g;
    /* access modifiers changed from: private */
    public j h = null;
    /* access modifiers changed from: private */
    public boolean i;
    private boolean j = true;
    private boolean k = true;
    private float l = 1.0f;
    private Surface m;
    private e n = new e() {
        public void a(int i, Bundle bundle) {
            Bundle bundle2 = new Bundle(bundle);
            int i2 = 2014;
            if (i == -2301) {
                i2 = -2301;
            } else if (i == 2011) {
                bundle2.putInt("EVT_PARAM1", k.this.f31662f.getMetaRotationDegree());
                i2 = 2011;
            } else if (i != 2103) {
                int i3 = 0;
                if (i == 2106) {
                    if (!k.this.i) {
                        k.this.f31663g.a(false);
                    }
                    i2 = 2106;
                } else if (i == 2013) {
                    k.this.h.d();
                    i2 = 2013;
                } else if (i != 2014) {
                    switch (i) {
                        case -2305:
                            i2 = -2305;
                            break;
                        case -2304:
                            i2 = -2304;
                            if (!k.this.i) {
                                k.this.f31663g.a(false);
                                break;
                            }
                            break;
                        case -2303:
                            i2 = -2303;
                            break;
                        default:
                            switch (i) {
                                case 2003:
                                    if (!k.this.i) {
                                        int i4 = 1;
                                        boolean unused = k.this.i = true;
                                        k.this.h.e();
                                        Bundle bundle3 = new Bundle();
                                        bundle3.putInt("EVT_ID", 2008);
                                        bundle3.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                                        MediaInfo mediaInfo = k.this.f31662f.getMediaInfo();
                                        if (!(mediaInfo == null || mediaInfo.mVideoDecoderImpl == null || !mediaInfo.mVideoDecoderImpl.contains("hevc"))) {
                                            i3 = 1;
                                        }
                                        String str = "启动硬解";
                                        if (k.this.f31662f.getPlayerType() == 0) {
                                            if (i3 == 0) {
                                                if (!k.this.f31663g.a()) {
                                                    str = "启动软解";
                                                }
                                                bundle3.putCharSequence("description", str);
                                            } else {
                                                bundle3.putCharSequence("description", k.this.f31663g.a() ? "启动硬解265" : "启动软解265");
                                            }
                                            if (!k.this.f31663g.a()) {
                                                i4 = 2;
                                            }
                                            bundle3.putInt("EVT_PARAM1", i4);
                                            bundle3.putInt("hevc", i3);
                                        } else {
                                            bundle3.putCharSequence("description", str);
                                            bundle3.putInt("EVT_PARAM1", 2);
                                        }
                                        a(2008, bundle3);
                                        i2 = 2003;
                                        break;
                                    } else {
                                        return;
                                    }
                                case 2004:
                                    i2 = 2004;
                                    k.this.h.d();
                                    break;
                                case 2005:
                                    i2 = 2005;
                                    k.this.h.a(bundle.getInt(TXLiveConstants.EVT_PLAY_DURATION, 0));
                                    break;
                                case 2006:
                                    k.this.h.c();
                                    if (!k.this.f31661a) {
                                        i2 = 2006;
                                        break;
                                    } else {
                                        k.this.f31662f.b();
                                        TXCLog.d(TXVodPlayer.TAG, "loop play");
                                        return;
                                    }
                                case 2007:
                                    i2 = 2007;
                                    k.this.h.i();
                                    break;
                                case 2008:
                                    i2 = 2008;
                                    break;
                                case 2009:
                                    i2 = 2009;
                                    break;
                                default:
                                    switch (i) {
                                        case TXLiteAVCode.EVT_VOD_PLAY_TCP_CONNECT_SUCC:
                                            k.this.h.f();
                                            return;
                                        case TXLiteAVCode.EVT_VOD_PLAY_FIRST_VIDEO_PACKET:
                                            k.this.h.h();
                                            return;
                                        case TXLiteAVCode.EVT_VOD_PLAY_DNS_RESOLVED:
                                            k.this.h.g();
                                            return;
                                        case TXLiteAVCode.EVT_VOD_PLAY_SEEK_COMPLETE:
                                            return;
                                        default:
                                            TXCLog.d(TXVodPlayer.TAG, "miss match event " + i);
                                            return;
                                    }
                            }
                    }
                }
            } else {
                i2 = 2103;
            }
            bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, bundle.getString("description", ""));
            if (k.this.f31853e != null) {
                a aVar = (a) k.this.f31853e.get();
                if (aVar != null) {
                    aVar.onNotifyEvent(i2, bundle2);
                }
            }
        }

        public void a(Bundle bundle) {
            Bundle bundle2 = new Bundle();
            int[] a2 = b.a();
            bundle2.putCharSequence(TXLiveConstants.NET_STATUS_CPU_USAGE, (Integer.valueOf(a2[0]).intValue() / 10) + Constants.URL_PATH_DELIMITER + (Integer.valueOf(a2[1]).intValue() / 10) + "%");
            bundle2.putInt(TXLiveConstants.NET_STATUS_VIDEO_FPS, (int) bundle.getFloat("fps"));
            bundle2.putInt(TXLiveConstants.NET_STATUS_VIDEO_DPS, (int) bundle.getFloat("dps"));
            bundle2.putInt(TXLiveConstants.NET_STATUS_NET_SPEED, ((int) bundle.getLong("tcpSpeed")) / 1000);
            bundle2.putInt(TXLiveConstants.NET_STATUS_AUDIO_CACHE, ((int) bundle.getLong("cachedBytes")) / 1000);
            bundle2.putInt(TXLiveConstants.NET_STATUS_VIDEO_WIDTH, k.this.f31662f.getVideoWidth());
            bundle2.putInt(TXLiveConstants.NET_STATUS_VIDEO_HEIGHT, k.this.f31662f.getVideoHeight());
            bundle2.putString(TXLiveConstants.NET_STATUS_SERVER_IP, k.this.f31662f.getServerIp());
            k.this.h.b(k.this.f31662f.getServerIp());
            if (k.this.f31853e != null) {
                a aVar = (a) k.this.f31853e.get();
                if (aVar != null) {
                    aVar.onNotifyEvent(15001, bundle2);
                }
            }
        }
    };

    public int c(int i2) {
        return 0;
    }

    public int e() {
        return 0;
    }

    public k(Context context) {
        super(context);
        this.f31662f = new TXCVodVideoView(context);
        this.f31662f.setListener(this.n);
        com.tencent.liteav.audio.impl.a.a().a(context);
    }

    public void a(g gVar) {
        super.a(gVar);
        if (this.f31663g == null) {
            this.f31663g = new d();
        }
        this.f31663g.a((float) this.f31850b.f31631e);
        this.f31663g.b((float) this.f31850b.f31632f);
        this.f31663g.c((float) this.f31850b.q);
        this.f31663g.a(this.f31850b.i);
        this.f31663g.a(this.f31850b.m);
        this.f31663g.a(this.f31850b.n);
        this.f31663g.b(this.f31850b.o);
        this.f31663g.a(this.f31850b.p);
        this.f31663g.b(this.f31850b.r);
        this.f31663g.c(this.f31850b.t);
        this.f31663g.b(this.f31850b.u);
        this.f31663g.c(this.f31850b.v);
        this.f31663g.d(this.f31850b.w);
        this.f31662f.setConfig(this.f31663g);
        this.k = gVar.s;
    }

    public int a(String str, int i2) {
        if (this.f31852d != null) {
            this.f31852d.setVisibility(0);
            if (this.f31852d.getVideoView() == null) {
                TextureRenderView textureRenderView = new TextureRenderView(this.f31852d.getContext());
                this.f31852d.addVideoView((TextureView) textureRenderView);
                this.f31662f.setTextureRenderView(textureRenderView);
            }
            this.f31852d.getVideoView().setVisibility(0);
        } else {
            Surface surface = this.m;
            if (surface != null) {
                this.f31662f.setRenderSurface(surface);
            }
        }
        this.h = new j(this.f31851c);
        this.h.a(str);
        this.h.b();
        this.i = false;
        this.f31662f.setPlayerType(this.f31663g.b());
        this.f31662f.setVideoPath(str);
        this.f31662f.setAutoPlay(this.j);
        this.f31662f.setRate(this.l);
        this.f31662f.setAutoRotate(this.k);
        if (this.f31663g != null) {
            this.f31662f.b();
            if (this.f31663g.b() == 1) {
                this.h.b(3);
            } else {
                this.h.b(1);
            }
        } else {
            this.f31662f.b();
            this.h.b(1);
        }
        TXCLog.d(TXVodPlayer.TAG, "startPlay " + str);
        TXCDRApi.txReportDAU(this.f31851c, com.tencent.liteav.basic.datareport.a.bp);
        try {
            if (Class.forName("com.tencent.liteav.demo.play.SuperPlayerView") != null) {
                TXCDRApi.txReportDAU(this.f31851c, com.tencent.liteav.basic.datareport.a.bA);
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public int a(boolean z) {
        this.f31662f.c();
        if (!(this.f31852d == null || this.f31852d.getVideoView() == null || !z)) {
            this.f31852d.getVideoView().setVisibility(8);
        }
        j jVar = this.h;
        if (jVar == null) {
            return 0;
        }
        jVar.c();
        return 0;
    }

    public void a(Surface surface) {
        this.m = surface;
        TXCVodVideoView tXCVodVideoView = this.f31662f;
        if (tXCVodVideoView != null) {
            tXCVodVideoView.setRenderSurface(this.m);
        }
    }

    public void a() {
        this.f31662f.d();
    }

    public void b() {
        this.f31662f.b();
    }

    public void d(int i2) {
        this.f31662f.a(i2 * 1000);
        if (this.i) {
            j jVar = this.h;
            if (jVar != null) {
                jVar.j();
            }
        }
    }

    public void a(float f2) {
        this.f31662f.a((int) (f2 * 1000.0f));
        if (this.i) {
            j jVar = this.h;
            if (jVar != null) {
                jVar.j();
            }
        }
    }

    public float h() {
        TXCVodVideoView tXCVodVideoView = this.f31662f;
        return tXCVodVideoView != null ? ((float) tXCVodVideoView.getCurrentPosition()) / 1000.0f : BitmapDescriptorFactory.HUE_RED;
    }

    public float i() {
        TXCVodVideoView tXCVodVideoView = this.f31662f;
        return tXCVodVideoView != null ? ((float) tXCVodVideoView.getBufferDuration()) / 1000.0f : BitmapDescriptorFactory.HUE_RED;
    }

    public float j() {
        TXCVodVideoView tXCVodVideoView = this.f31662f;
        return tXCVodVideoView != null ? ((float) tXCVodVideoView.getDuration()) / 1000.0f : BitmapDescriptorFactory.HUE_RED;
    }

    public float k() {
        TXCVodVideoView tXCVodVideoView = this.f31662f;
        return tXCVodVideoView != null ? ((float) tXCVodVideoView.getBufferDuration()) / 1000.0f : BitmapDescriptorFactory.HUE_RED;
    }

    public int l() {
        TXCVodVideoView tXCVodVideoView = this.f31662f;
        if (tXCVodVideoView != null) {
            return tXCVodVideoView.getVideoWidth();
        }
        return 0;
    }

    public int m() {
        TXCVodVideoView tXCVodVideoView = this.f31662f;
        if (tXCVodVideoView != null) {
            return tXCVodVideoView.getVideoHeight();
        }
        return 0;
    }

    public void b(boolean z) {
        this.f31662f.setMute(z);
    }

    public void a(int i2) {
        if (i2 == 1) {
            this.f31662f.setRenderMode(0);
        } else {
            this.f31662f.setRenderMode(1);
        }
    }

    public void b(int i2) {
        this.f31662f.setVideoRotationDegree(360 - i2);
    }

    public void a(TXCloudVideoView tXCloudVideoView) {
        if (tXCloudVideoView != this.f31852d) {
            if (this.f31852d != null) {
                this.f31852d.removeVideoView();
            }
            if (tXCloudVideoView != null) {
                tXCloudVideoView.removeVideoView();
            }
        }
        if (tXCloudVideoView != null) {
            tXCloudVideoView.setVisibility(0);
            if (tXCloudVideoView.getVideoView() == null) {
                TextureRenderView textureRenderView = new TextureRenderView(tXCloudVideoView.getContext());
                tXCloudVideoView.addVideoView((TextureView) textureRenderView);
                this.f31662f.setTextureRenderView(textureRenderView);
            }
            tXCloudVideoView.getVideoView().setVisibility(0);
        }
        super.a(tXCloudVideoView);
    }

    public void a(TextureRenderView textureRenderView) {
        TXCVodVideoView tXCVodVideoView = this.f31662f;
        if (tXCVodVideoView != null) {
            tXCVodVideoView.setRenderView(textureRenderView);
        }
    }

    public TextureView d() {
        if (this.f31852d != null) {
            return this.f31852d.getVideoView();
        }
        return null;
    }

    public boolean c() {
        return this.f31662f.e();
    }

    public void c(boolean z) {
        this.j = z;
        TXCVodVideoView tXCVodVideoView = this.f31662f;
        if (tXCVodVideoView != null) {
            tXCVodVideoView.setAutoPlay(z);
        }
    }

    public void b(float f2) {
        this.l = f2;
        TXCVodVideoView tXCVodVideoView = this.f31662f;
        if (tXCVodVideoView != null) {
            tXCVodVideoView.setRate(f2);
        }
        if (this.i) {
            j jVar = this.h;
            if (jVar != null) {
                jVar.l();
            }
        }
    }

    public void c(float f2) {
        TXCVodVideoView tXCVodVideoView = this.f31662f;
        if (tXCVodVideoView != null) {
            tXCVodVideoView.setStartTime(f2);
        }
    }

    public int n() {
        TXCVodVideoView tXCVodVideoView = this.f31662f;
        if (tXCVodVideoView != null) {
            return tXCVodVideoView.getBitrateIndex();
        }
        return 0;
    }

    public void e(int i2) {
        TXCVodVideoView tXCVodVideoView = this.f31662f;
        if (tXCVodVideoView != null) {
            tXCVodVideoView.setBitrateIndex(i2);
        }
        if (this.i) {
            j jVar = this.h;
            if (jVar != null) {
                jVar.k();
            }
        }
    }

    public ArrayList<TXBitrateItem> o() {
        ArrayList<TXBitrateItem> arrayList = new ArrayList<>();
        TXCVodVideoView tXCVodVideoView = this.f31662f;
        if (tXCVodVideoView != null) {
            ArrayList<IjkBitrateItem> supportedBitrates = tXCVodVideoView.getSupportedBitrates();
            if (supportedBitrates != null) {
                Iterator<IjkBitrateItem> it = supportedBitrates.iterator();
                while (it.hasNext()) {
                    IjkBitrateItem next = it.next();
                    TXBitrateItem tXBitrateItem = new TXBitrateItem();
                    tXBitrateItem.index = next.index;
                    tXBitrateItem.width = next.width;
                    tXBitrateItem.height = next.height;
                    tXBitrateItem.bitrate = next.bitrate;
                    arrayList.add(tXBitrateItem);
                }
            }
        }
        return arrayList;
    }

    public void d(boolean z) {
        this.f31661a = z;
    }

    public void e(boolean z) {
        TextureView d2 = d();
        if (d2 != null) {
            float f2 = -1.0f;
            if (!this.f31850b.s || !(this.f31662f.getMetaRotationDegree() == 90 || this.f31662f.getMetaRotationDegree() == 270)) {
                if (!z) {
                    f2 = 1.0f;
                }
                d2.setScaleX(f2);
            } else {
                if (!z) {
                    f2 = 1.0f;
                }
                d2.setScaleY(f2);
            }
        }
        j jVar = this.h;
        if (jVar != null) {
            jVar.a(z);
        }
    }
}
