package com.tencent.liteav.txcvodplayer;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.exoplayer2.d.d;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.ijk.media.exo.IjkExoMediaPlayer;
import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.IjkBitrateItem;
import com.tencent.ijk.media.player.IjkMediaMeta;
import com.tencent.ijk.media.player.IjkMediaPlayer;
import com.tencent.ijk.media.player.IjkTimedText;
import com.tencent.ijk.media.player.MediaInfo;
import com.tencent.ijk.media.player.TextureMediaPlayer;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.txcvodplayer.a;
import com.tencent.liteav.txcvodplayer.a.b;
import com.tencent.rtmp.TXLiveConstants;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Locale;
import tencent.tls.platform.TLSErrInfo;

public class TXCVodVideoView extends FrameLayout {
    /* access modifiers changed from: private */
    public String A;
    /* access modifiers changed from: private */
    public float B = 1.0f;
    private com.tencent.liteav.txcvodplayer.a.a C;
    private b D = b.a();
    /* access modifiers changed from: private */
    public int E;
    /* access modifiers changed from: private */
    public long F;
    /* access modifiers changed from: private */
    public int G;
    private int H;
    /* access modifiers changed from: private */
    public long I;
    /* access modifiers changed from: private */
    public boolean J = false;
    /* access modifiers changed from: private */
    public int K = -1;
    private float L = 1.0f;
    private float M = 1.0f;
    private boolean N = false;
    private int O;
    /* access modifiers changed from: private */
    public boolean P;
    private b Q;
    private IMediaPlayer.OnCompletionListener R = new IMediaPlayer.OnCompletionListener() {
        public void onCompletion(IMediaPlayer iMediaPlayer) {
            if (TXCVodVideoView.this.f32018c != 1 || TXCVodVideoView.this.j != -1) {
                int unused = TXCVodVideoView.this.i = 5;
                int unused2 = TXCVodVideoView.this.j = 5;
                TXCVodVideoView.this.a(2006, "播放完成", "play end");
            }
        }
    };
    private IMediaPlayer.OnInfoListener S = new IMediaPlayer.OnInfoListener() {
        public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
            if (i == 3) {
                TXCLog.d(TXCVodVideoView.this.f32022g, "MEDIA_INFO_VIDEO_RENDERING_START:");
                if (!TXCVodVideoView.this.P) {
                    TXCVodVideoView.this.a(2003, "点播显示首帧画面", "render start");
                    if (TXCVodVideoView.this.f32018c == 1) {
                        new Thread(new Runnable() {
                            public void run() {
                                try {
                                    String unused = TXCVodVideoView.this.A = InetAddress.getByName(TXCVodVideoView.this.h.getHost()).getHostAddress();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }).start();
                    }
                }
                TXCVodVideoView tXCVodVideoView = TXCVodVideoView.this;
                tXCVodVideoView.setRate(tXCVodVideoView.B);
                if (TXCVodVideoView.this.f32018c == 1) {
                    TXCVodVideoView.this.a(2014, "缓冲结束", "loading end");
                    if (TXCVodVideoView.this.j == 3 && TXCVodVideoView.this.P) {
                        TXCVodVideoView.this.a(2004, "播放开始", "playing");
                    }
                }
                boolean unused = TXCVodVideoView.this.P = true;
            } else if (i == 10011) {
                TXCVodVideoView.this.a((int) TXLiteAVCode.EVT_VOD_PLAY_FIRST_VIDEO_PACKET, "收到视频数据", "first video packet");
            } else if (i == 901) {
                TXCLog.d(TXCVodVideoView.this.f32022g, "MEDIA_INFO_UNSUPPORTED_SUBTITLE:");
            } else if (i == 902) {
                TXCLog.d(TXCVodVideoView.this.f32022g, "MEDIA_INFO_SUBTITLE_TIMED_OUT:");
            } else if (i == 10001) {
                TXCLog.d(TXCVodVideoView.this.f32022g, "MEDIA_INFO_VIDEO_ROTATION_CHANGED: " + i2);
                int unused2 = TXCVodVideoView.this.r = i2;
                if (TXCVodVideoView.this.f32016a && TXCVodVideoView.this.r > 0) {
                    TXCVodVideoView tXCVodVideoView2 = TXCVodVideoView.this;
                    int unused3 = tXCVodVideoView2.q = tXCVodVideoView2.r;
                    if (TXCVodVideoView.this.x != null) {
                        TXCVodVideoView.this.x.setVideoRotation(TXCVodVideoView.this.q);
                    }
                }
                TXCVodVideoView.this.a(2011, "视频角度 " + TXCVodVideoView.this.r, "rotation " + TXCVodVideoView.this.r);
            } else if (i != 10002) {
                switch (i) {
                    case 700:
                        TXCLog.d(TXCVodVideoView.this.f32022g, "MEDIA_INFO_VIDEO_TRACK_LAGGING:");
                        break;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_START:
                        TXCLog.d(TXCVodVideoView.this.f32022g, "MEDIA_INFO_BUFFERING_START:");
                        TXCVodVideoView.this.a(2007, "缓冲开始", "loading start");
                        break;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_END:
                        TXCLog.d(TXCVodVideoView.this.f32022g, "MEDIA_INFO_BUFFERING_END: eof " + i2);
                        if (i2 == 0 || TXCVodVideoView.this.h == null || TXCVodVideoView.this.h.getPath() == null || !TXCVodVideoView.this.h.getPath().endsWith(IjkMediaMeta.IJKM_KEY_M3U8)) {
                            TXCVodVideoView.this.a(2014, "缓冲结束", "loading end");
                            if (TXCVodVideoView.this.j == 3) {
                                TXCVodVideoView.this.a(2004, "播放开始", "playing");
                                break;
                            }
                        }
                        break;
                    case IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH:
                        TXCLog.d(TXCVodVideoView.this.f32022g, "MEDIA_INFO_NETWORK_BANDWIDTH: " + i2);
                        break;
                    default:
                        switch (i) {
                            case 800:
                                TXCLog.d(TXCVodVideoView.this.f32022g, "MEDIA_INFO_BAD_INTERLEAVING:");
                                break;
                            case IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE:
                                TXCLog.d(TXCVodVideoView.this.f32022g, "MEDIA_INFO_NOT_SEEKABLE:");
                                break;
                            case IMediaPlayer.MEDIA_INFO_METADATA_UPDATE:
                                TXCLog.d(TXCVodVideoView.this.f32022g, "MEDIA_INFO_METADATA_UPDATE:");
                                break;
                        }
                }
            } else {
                TXCLog.d(TXCVodVideoView.this.f32022g, "MEDIA_INFO_AUDIO_RENDERING_START:");
            }
            return true;
        }
    };
    /* access modifiers changed from: private */
    public int T;
    private IMediaPlayer.OnErrorListener U = new IMediaPlayer.OnErrorListener() {
        public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
            String k = TXCVodVideoView.this.f32022g;
            TXCLog.e(k, "onError: " + i + "," + i2);
            int unused = TXCVodVideoView.this.i = -1;
            int unused2 = TXCVodVideoView.this.j = -1;
            if (i == -1004 && i2 == -2303) {
                TXCVodVideoView.this.a(i2, "文件不存在", "file not exist");
                TXCVodVideoView.this.c();
                return true;
            }
            if (TXCVodVideoView.this.I != ((long) TXCVodVideoView.this.getCurrentPosition())) {
                int unused3 = TXCVodVideoView.this.T = 0;
            }
            TXCVodVideoView tXCVodVideoView = TXCVodVideoView.this;
            long unused4 = tXCVodVideoView.I = (long) tXCVodVideoView.getCurrentPosition();
            if (((float) TXCVodVideoView.r(TXCVodVideoView.this)) >= TXCVodVideoView.this.w.f32073a) {
                TXCVodVideoView.this.a(-2301, "网络断开，播放错误", "disconnect");
                TXCVodVideoView.this.c();
            } else if (TXCVodVideoView.this.ah != null) {
                TXCVodVideoView.this.ah.sendEmptyMessageDelayed(102, (long) (TXCVodVideoView.this.w.f32074b * 1000.0f));
            }
            return true;
        }
    };
    private IMediaPlayer.OnHevcVideoDecoderErrorListener V = new IMediaPlayer.OnHevcVideoDecoderErrorListener() {
        public void onHevcVideoDecoderError(IMediaPlayer iMediaPlayer) {
            Log.d(TXCVodVideoView.this.f32022g, "onHevcVideoDecoderError");
            TXCVodVideoView.this.a(-2304, "点播H265解码失败", "hevc decode fail");
        }
    };
    private IMediaPlayer.OnVideoDecoderErrorListener W = new IMediaPlayer.OnVideoDecoderErrorListener() {
        public void onVideoDecoderError(IMediaPlayer iMediaPlayer) {
            Log.d(TXCVodVideoView.this.f32022g, "onVideoDecoderError");
            if (TXCVodVideoView.this.i != 4) {
                TXCVodVideoView.this.a(2106, "点播解码失败", "decode fail");
            }
            if (!TXCVodVideoView.this.P && TXCVodVideoView.this.w.f32076d && Math.min(TXCVodVideoView.this.n, TXCVodVideoView.this.m) < 1080) {
                TXCVodVideoView.this.w.f32076d = false;
                TXCVodVideoView.this.g();
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    protected boolean f32016a = true;
    private IMediaPlayer.OnBufferingUpdateListener aa = new IMediaPlayer.OnBufferingUpdateListener() {
        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
            int unused = TXCVodVideoView.this.s = i;
        }
    };
    private IMediaPlayer.OnSeekCompleteListener ab = new IMediaPlayer.OnSeekCompleteListener() {
        public void onSeekComplete(IMediaPlayer iMediaPlayer) {
            TXCLog.v(TXCVodVideoView.this.f32022g, "seek complete");
            boolean unused = TXCVodVideoView.this.J = false;
            if (TXCVodVideoView.this.K >= 0) {
                TXCVodVideoView tXCVodVideoView = TXCVodVideoView.this;
                tXCVodVideoView.a(tXCVodVideoView.K);
            }
        }
    };
    private IMediaPlayer.OnTimedTextListener ac = new IMediaPlayer.OnTimedTextListener() {
        public void onTimedText(IMediaPlayer iMediaPlayer, IjkTimedText ijkTimedText) {
        }
    };
    private IjkMediaPlayer.OnNativeInvokeListener ad = new IjkMediaPlayer.OnNativeInvokeListener() {
        public boolean onNativeInvoke(int i, Bundle bundle) {
            if (i == 131074) {
                String unused = TXCVodVideoView.this.A = bundle.getString(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP);
                TXCVodVideoView.this.a((int) TXLiteAVCode.EVT_VOD_PLAY_TCP_CONNECT_SUCC, "CTRL_DID_TCP_OPEN", "tcp open");
                return true;
            } else if (i != 131106) {
                return false;
            } else {
                TXCVodVideoView.this.a((int) TXLiteAVCode.EVT_VOD_PLAY_DNS_RESOLVED, "PLAYER_EVENT_DNS_RESOLVED", "dns resolved");
                return true;
            }
        }
    };
    private IMediaPlayer.OnHLSKeyErrorListener ae = new IMediaPlayer.OnHLSKeyErrorListener() {
        public void onHLSKeyError(IMediaPlayer iMediaPlayer) {
            Log.e(TXCVodVideoView.this.f32022g, "onHLSKeyError");
            TXCVodVideoView.this.a(-2305, "HLS解密key获取失败", "hls key error");
            if (TXCVodVideoView.this.l != null) {
                TXCVodVideoView.this.l.stop();
                TXCVodVideoView.this.l.release();
                IMediaPlayer unused = TXCVodVideoView.this.l = null;
            }
            int unused2 = TXCVodVideoView.this.i = -1;
            int unused3 = TXCVodVideoView.this.j = -1;
        }
    };
    private int af = 0;
    /* access modifiers changed from: private */
    public e ag;
    /* access modifiers changed from: private */
    public Handler ah;
    private boolean ai = false;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f32017b = true;

    /* renamed from: c  reason: collision with root package name */
    protected int f32018c = 1;

    /* renamed from: d  reason: collision with root package name */
    IMediaPlayer.OnVideoSizeChangedListener f32019d = new IMediaPlayer.OnVideoSizeChangedListener() {
        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
            boolean z = (TXCVodVideoView.this.n != i2 && Math.abs(TXCVodVideoView.this.n - i2) > 16) || (TXCVodVideoView.this.m != i && Math.abs(TXCVodVideoView.this.m - i) > 16);
            int unused = TXCVodVideoView.this.m = iMediaPlayer.getVideoWidth();
            int unused2 = TXCVodVideoView.this.n = iMediaPlayer.getVideoHeight();
            int unused3 = TXCVodVideoView.this.y = iMediaPlayer.getVideoSarNum();
            int unused4 = TXCVodVideoView.this.z = iMediaPlayer.getVideoSarDen();
            if (!(TXCVodVideoView.this.m == 0 || TXCVodVideoView.this.n == 0)) {
                if (TXCVodVideoView.this.x != null) {
                    TXCVodVideoView.this.x.setVideoSize(TXCVodVideoView.this.m, TXCVodVideoView.this.n);
                    TXCVodVideoView.this.x.setVideoSampleAspectRatio(TXCVodVideoView.this.y, TXCVodVideoView.this.z);
                }
                TXCVodVideoView.this.requestLayout();
            }
            if (z) {
                Message message = new Message();
                message.what = 101;
                message.arg1 = 2009;
                Bundle bundle = new Bundle();
                bundle.putString("description", "分辨率改变:" + TXCVodVideoView.this.m + "*" + TXCVodVideoView.this.n);
                bundle.putInt("EVT_PARAM1", TXCVodVideoView.this.m);
                bundle.putInt("EVT_PARAM2", TXCVodVideoView.this.n);
                message.setData(bundle);
                if (TXCVodVideoView.this.ah != null) {
                    TXCVodVideoView.this.ah.sendMessage(message);
                }
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    IMediaPlayer.OnPreparedListener f32020e = new IMediaPlayer.OnPreparedListener() {
        public void onPrepared(IMediaPlayer iMediaPlayer) {
            if (TXCVodVideoView.this.i == 1) {
                TXCVodVideoView.this.a(2013, "点播准备完成", "prepared");
                if (!TXCVodVideoView.this.f32017b) {
                    int unused = TXCVodVideoView.this.j = 4;
                    TXCVodVideoView.this.f32017b = true;
                }
                int unused2 = TXCVodVideoView.this.i = 2;
            }
            int unused3 = TXCVodVideoView.this.t = 0;
            if (TXCVodVideoView.this.i == -1) {
                int unused4 = TXCVodVideoView.this.i = 3;
                int unused5 = TXCVodVideoView.this.j = 3;
            }
            if (TXCVodVideoView.this.ah != null) {
                TXCVodVideoView.this.ah.sendEmptyMessage(100);
                TXCVodVideoView.this.ah.sendEmptyMessage(103);
            }
            int unused6 = TXCVodVideoView.this.m = iMediaPlayer.getVideoWidth();
            int unused7 = TXCVodVideoView.this.n = iMediaPlayer.getVideoHeight();
            if (TXCVodVideoView.this.m == 0 || TXCVodVideoView.this.n == 0) {
                if (TXCVodVideoView.this.j == 3) {
                    TXCVodVideoView.this.b();
                }
            } else if (TXCVodVideoView.this.x != null) {
                TXCVodVideoView.this.x.setVideoSize(TXCVodVideoView.this.m, TXCVodVideoView.this.n);
                TXCVodVideoView.this.x.setVideoSampleAspectRatio(TXCVodVideoView.this.y, TXCVodVideoView.this.z);
                if ((!TXCVodVideoView.this.x.shouldWaitForResize() || (TXCVodVideoView.this.o == TXCVodVideoView.this.m && TXCVodVideoView.this.p == TXCVodVideoView.this.n)) && TXCVodVideoView.this.j == 3) {
                    TXCVodVideoView.this.b();
                }
            }
        }
    };

    /* renamed from: f  reason: collision with root package name */
    a.C0493a f32021f = new a.C0493a() {
        public void a(a.b bVar, int i, int i2, int i3) {
            if (bVar.a() != TXCVodVideoView.this.x) {
                TXCLog.e(TXCVodVideoView.this.f32022g, "onSurfaceChanged: unmatched render callback\n");
                return;
            }
            TXCLog.d(TXCVodVideoView.this.f32022g, "onSurfaceChanged");
            int unused = TXCVodVideoView.this.o = i2;
            int unused2 = TXCVodVideoView.this.p = i3;
            boolean z = true;
            boolean z2 = TXCVodVideoView.this.j == 3;
            if (TXCVodVideoView.this.x.shouldWaitForResize() && !(TXCVodVideoView.this.m == i2 && TXCVodVideoView.this.n == i3)) {
                z = false;
            }
            if (TXCVodVideoView.this.l != null && z2 && z && TXCVodVideoView.this.j == 3) {
                TXCVodVideoView.this.b();
            }
        }

        public void a(a.b bVar, int i, int i2) {
            if (bVar.a() != TXCVodVideoView.this.x) {
                TXCLog.e(TXCVodVideoView.this.f32022g, "onSurfaceCreated: unmatched render callback\n");
                return;
            }
            TXCLog.d(TXCVodVideoView.this.f32022g, "onSurfaceCreated");
            a.b unused = TXCVodVideoView.this.k = bVar;
            if (TXCVodVideoView.this.l != null) {
                TXCVodVideoView tXCVodVideoView = TXCVodVideoView.this;
                tXCVodVideoView.a(tXCVodVideoView.l, bVar);
                return;
            }
            boolean unused2 = TXCVodVideoView.this.f();
        }

        public void a(a.b bVar) {
            if (bVar.a() != TXCVodVideoView.this.x) {
                TXCLog.e(TXCVodVideoView.this.f32022g, "onSurfaceDestroyed: unmatched render callback\n");
                return;
            }
            TXCLog.d(TXCVodVideoView.this.f32022g, "onSurfaceDestroyed");
            a.b unused = TXCVodVideoView.this.k = null;
            if (TXCVodVideoView.this.l != null) {
                TXCVodVideoView.this.l.setSurface((Surface) null);
            }
            TXCVodVideoView.this.a();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f32022g = "TXCVodVideoView";
    /* access modifiers changed from: private */
    public Uri h;
    /* access modifiers changed from: private */
    public int i = 0;
    /* access modifiers changed from: private */
    public int j = 0;
    /* access modifiers changed from: private */
    public a.b k = null;
    /* access modifiers changed from: private */
    public IMediaPlayer l = null;
    /* access modifiers changed from: private */
    public int m;
    /* access modifiers changed from: private */
    public int n;
    /* access modifiers changed from: private */
    public int o;
    /* access modifiers changed from: private */
    public int p;
    /* access modifiers changed from: private */
    public int q;
    /* access modifiers changed from: private */
    public int r;
    /* access modifiers changed from: private */
    public int s;
    /* access modifiers changed from: private */
    public int t;
    private int u;
    private Context v;
    /* access modifiers changed from: private */
    public d w;
    /* access modifiers changed from: private */
    public a x;
    /* access modifiers changed from: private */
    public int y;
    /* access modifiers changed from: private */
    public int z;

    static /* synthetic */ int r(TXCVodVideoView tXCVodVideoView) {
        int i2 = tXCVodVideoView.T;
        tXCVodVideoView.T = i2 + 1;
        return i2;
    }

    public int getMetaRotationDegree() {
        return this.r;
    }

    public TXCVodVideoView(Context context) {
        super(context);
        a(context);
    }

    public TXCVodVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public TXCVodVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        this.v = context.getApplicationContext();
        this.w = new d();
        i();
        this.m = 0;
        this.n = 0;
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.i = 0;
        this.j = 0;
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            this.ah = new a(this, mainLooper);
        } else {
            this.ah = null;
        }
        this.Q = new b();
    }

    public void setRenderView(a aVar) {
        String str = this.f32022g;
        TXCLog.d(str, "setRenderView " + aVar);
        if (this.x != null) {
            IMediaPlayer iMediaPlayer = this.l;
            if (iMediaPlayer != null) {
                iMediaPlayer.setDisplay((SurfaceHolder) null);
            }
            View view = this.x.getView();
            this.x.removeRenderCallback(this.f32021f);
            this.x = null;
            if (view.getParent() == this) {
                removeView(view);
            }
        }
        if (aVar != null) {
            this.x = aVar;
            aVar.setAspectRatio(this.af);
            int i2 = this.m;
            if (i2 > 0) {
                int i3 = this.n;
                if (i3 > 0) {
                    aVar.setVideoSize(i2, i3);
                }
            }
            int i4 = this.y;
            if (i4 > 0) {
                int i5 = this.z;
                if (i5 > 0) {
                    aVar.setVideoSampleAspectRatio(i4, i5);
                }
            }
            View view2 = this.x.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            if (view2.getParent() == null) {
                addView(view2);
            }
            this.x.addRenderCallback(this.f32021f);
            this.x.setVideoRotation(this.q);
        }
    }

    public void setRender(int i2) {
        if (i2 == 0) {
            setRenderView((a) null);
        } else if (i2 == 1) {
            setRenderView(new SurfaceRenderView(this.v));
        } else if (i2 != 2) {
            TXCLog.e(this.f32022g, String.format(Locale.getDefault(), "invalid render %d\n", new Object[]{Integer.valueOf(i2)}));
        } else {
            TextureRenderView textureRenderView = new TextureRenderView(this.v);
            if (this.l != null) {
                textureRenderView.getSurfaceHolder().a(this.l);
                textureRenderView.setVideoSize(this.l.getVideoWidth(), this.l.getVideoHeight());
                textureRenderView.setVideoSampleAspectRatio(this.l.getVideoSarNum(), this.l.getVideoSarDen());
                textureRenderView.setAspectRatio(this.af);
            }
            setRenderView(textureRenderView);
        }
    }

    public void setTextureRenderView(TextureRenderView textureRenderView) {
        String str = this.f32022g;
        TXCLog.d(str, "setTextureRenderView " + textureRenderView);
        if (this.l != null) {
            textureRenderView.getSurfaceHolder().a(this.l);
            textureRenderView.setVideoSize(this.l.getVideoWidth(), this.l.getVideoHeight());
            textureRenderView.setVideoSampleAspectRatio(this.l.getVideoSarNum(), this.l.getVideoSarDen());
            textureRenderView.setAspectRatio(this.af);
        }
        setRenderView(textureRenderView);
    }

    public void setRenderSurface(final Surface surface) {
        this.k = new a.b() {
            public void a(IMediaPlayer iMediaPlayer) {
                iMediaPlayer.setSurface(surface);
            }

            public a a() {
                return TXCVodVideoView.this.x;
            }
        };
        IMediaPlayer iMediaPlayer = this.l;
        if (iMediaPlayer != null) {
            a(iMediaPlayer, this.k);
        }
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        this.h = uri;
        this.u = 0;
        this.H = 0;
        this.T = 0;
        this.A = null;
        String str = this.f32022g;
        TXCLog.d(str, "setVideoURI " + uri);
        f();
        requestLayout();
        invalidate();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x010f A[Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0111 A[Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x011d A[Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0132 A[Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0158 A[Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0186 A[Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01f1 A[Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }] */
    @android.annotation.TargetApi(23)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean f() {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r0 = r1.f32022g
            java.lang.String r2 = "openVideo"
            com.tencent.liteav.basic.log.TXCLog.d(r0, r2)
            android.net.Uri r0 = r1.h
            r2 = 0
            if (r0 != 0) goto L_0x000f
            return r2
        L_0x000f:
            com.tencent.liteav.txcvodplayer.a$b r0 = r1.k
            if (r0 != 0) goto L_0x0018
            boolean r0 = r1.f32017b
            if (r0 == 0) goto L_0x0018
            return r2
        L_0x0018:
            r1.a((boolean) r2)
            android.content.Context r0 = r1.v
            java.lang.String r3 = "audio"
            java.lang.Object r0 = r0.getSystemService(r3)
            android.media.AudioManager r0 = (android.media.AudioManager) r0
            r3 = 3
            r4 = 0
            r5 = 1
            r0.requestAudioFocus(r4, r3, r5)
            r6 = -1
            android.net.Uri r0 = r1.h     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r0 = r0.toString()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r7 = "/"
            boolean r7 = r0.startsWith(r7)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            if (r7 == 0) goto L_0x004c
            java.io.File r7 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r7.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            boolean r7 = r7.exists()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            if (r7 == 0) goto L_0x0046
            goto L_0x004c
        L_0x0046:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r0.<init>()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            throw r0     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
        L_0x004c:
            int r7 = r1.f32018c     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            if (r7 == r5) goto L_0x02a1
            r8 = 2
            if (r7 == r8) goto L_0x0285
            android.net.Uri r7 = r1.h     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            if (r7 == 0) goto L_0x026d
            com.tencent.ijk.media.player.IjkMediaPlayer r7 = new com.tencent.ijk.media.player.IjkMediaPlayer     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.liteav.txcvodplayer.TXCVodVideoView$8 r9 = new com.tencent.liteav.txcvodplayer.TXCVodVideoView$8     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r9.<init>()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r7.<init>(r9)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.ijk.media.player.IjkMediaPlayer.native_setLogLevel(r3)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.ijk.media.player.IjkMediaPlayer$OnNativeInvokeListener r9 = r1.ad     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r7.setOnNativeInvokeListener(r9)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.liteav.txcvodplayer.d r9 = r1.w     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            boolean r9 = r9.f32076d     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r10 = "mediacodec"
            r11 = 1
            r13 = 0
            r15 = 4
            if (r9 == 0) goto L_0x007f
            r7.setOption((int) r15, (java.lang.String) r10, (long) r11)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r9 = "mediacodec-hevc"
            r7.setOption((int) r15, (java.lang.String) r9, (long) r11)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            goto L_0x0082
        L_0x007f:
            r7.setOption((int) r15, (java.lang.String) r10, (long) r13)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
        L_0x0082:
            java.lang.String r9 = r1.f32022g     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r10.<init>()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = "ijk mediacodec "
            r10.append(r4)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.liteav.txcvodplayer.d r4 = r1.w     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            boolean r4 = r4.f32076d     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r10.append(r4)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = r10.toString()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.liteav.basic.log.TXCLog.d(r9, r4)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = "mediacodec-auto-rotate"
            r7.setOption((int) r15, (java.lang.String) r4, (long) r13)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = "mediacodec-handle-resolution-change"
            r7.setOption((int) r15, (java.lang.String) r4, (long) r13)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = "opensles"
            r7.setOption((int) r15, (java.lang.String) r4, (long) r13)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = "overlay-format"
            r9 = 842225234(0x32335652, double:4.16114554E-315)
            r7.setOption((int) r15, (java.lang.String) r4, (long) r9)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = "framedrop"
            r7.setOption((int) r15, (java.lang.String) r4, (long) r11)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = "soundtouch"
            r7.setOption((int) r15, (java.lang.String) r4, (long) r11)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = "max-fps"
            r9 = 30
            r7.setOption((int) r15, (java.lang.String) r4, (long) r9)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            boolean r4 = r1.f32017b     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r9 = "start-on-prepared"
            if (r4 == 0) goto L_0x00d2
            int r4 = r1.j     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            if (r4 == r15) goto L_0x00d2
            r7.setOption((int) r15, (java.lang.String) r9, (long) r11)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            goto L_0x00d5
        L_0x00d2:
            r7.setOption((int) r15, (java.lang.String) r9, (long) r13)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
        L_0x00d5:
            java.lang.String r4 = "load-on-prepared"
            r7.setOption((int) r15, (java.lang.String) r4, (long) r11)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = "http-detect-range-support"
            r7.setOption((int) r5, (java.lang.String) r4, (long) r13)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = "skip_loop_filter"
            r7.setOption((int) r8, (java.lang.String) r4, (long) r13)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = "skip_frame"
            r7.setOption((int) r8, (java.lang.String) r4, (long) r13)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = "timeout"
            com.tencent.liteav.txcvodplayer.d r9 = r1.w     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            float r9 = r9.f32075c     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r10 = 1148846080(0x447a0000, float:1000.0)
            float r9 = r9 * r10
            float r9 = r9 * r10
            int r9 = (int) r9     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            long r9 = (long) r9     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r7.setOption((int) r5, (java.lang.String) r4, (long) r9)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = "reconnect"
            r7.setOption((int) r5, (java.lang.String) r4, (long) r11)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = "analyzeduration"
            r9 = 90000000(0x55d4a80, double:4.4465908E-316)
            r7.setOption((int) r5, (java.lang.String) r4, (long) r9)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = "enable-accurate-seek"
            com.tencent.liteav.txcvodplayer.d r9 = r1.w     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            boolean r9 = r9.i     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            if (r9 == 0) goto L_0x0111
            r9 = r11
            goto L_0x0112
        L_0x0111:
            r9 = r13
        L_0x0112:
            r7.setOption((int) r15, (java.lang.String) r4, (long) r9)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = "disable-bitrate-sync"
            com.tencent.liteav.txcvodplayer.d r9 = r1.w     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            boolean r9 = r9.j     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            if (r9 == 0) goto L_0x011e
            r11 = r13
        L_0x011e:
            r7.setOption((int) r15, (java.lang.String) r4, (long) r11)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = "dns_cache_timeout"
            r7.setOption((int) r5, (java.lang.String) r4, (long) r13)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = "cache_max_capacity"
            r9 = 2147483647(0x7fffffff, double:1.060997895E-314)
            r7.setOption((int) r5, (java.lang.String) r4, (long) r9)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            int r4 = r1.t     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            if (r4 <= 0) goto L_0x0152
            java.lang.String r4 = "seek-at-start"
            int r9 = r1.t     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            long r9 = (long) r9     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r7.setOption((int) r15, (java.lang.String) r4, (long) r9)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = r1.f32022g     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r9.<init>()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r10 = "ijk start time "
            r9.append(r10)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            int r10 = r1.t     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r9.append(r10)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r9 = r9.toString()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.liteav.basic.log.TXCLog.d(r4, r9)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
        L_0x0152:
            com.tencent.liteav.txcvodplayer.d r4 = r1.w     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            int r4 = r4.m     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            if (r4 <= 0) goto L_0x0180
            java.lang.String r4 = "max-buffer-size"
            com.tencent.liteav.txcvodplayer.d r9 = r1.w     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            int r9 = r9.m     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            int r9 = r9 * 1024
            int r9 = r9 * 1024
            long r9 = (long) r9     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r7.setOption((int) r15, (java.lang.String) r4, (long) r9)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = r1.f32022g     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r9.<init>()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r10 = "ijk max buffer size "
            r9.append(r10)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.liteav.txcvodplayer.d r10 = r1.w     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            int r10 = r10.m     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r9.append(r10)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r9 = r9.toString()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.liteav.basic.log.TXCLog.d(r4, r9)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
        L_0x0180:
            com.tencent.liteav.txcvodplayer.d r4 = r1.w     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.util.Map<java.lang.String, java.lang.String> r4 = r4.h     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            if (r4 == 0) goto L_0x01e2
            com.tencent.liteav.txcvodplayer.d r4 = r1.w     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.util.Map<java.lang.String, java.lang.String> r4 = r4.h     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.util.Set r4 = r4.keySet()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r9 = 0
        L_0x0193:
            boolean r10 = r4.hasNext()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            if (r10 == 0) goto L_0x01dd
            java.lang.Object r10 = r4.next()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r11 = "%s: %s"
            if (r9 != 0) goto L_0x01b6
            java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r9[r2] = r10     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.liteav.txcvodplayer.d r12 = r1.w     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.util.Map<java.lang.String, java.lang.String> r12 = r12.h     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.Object r10 = r12.get(r10)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r9[r5] = r10     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r9 = java.lang.String.format(r11, r9)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            goto L_0x0193
        L_0x01b6:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r12.<init>()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r12.append(r9)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r9 = "\r\n"
            r12.append(r9)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r9[r2] = r10     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.liteav.txcvodplayer.d r13 = r1.w     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.util.Map<java.lang.String, java.lang.String> r13 = r13.h     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.Object r10 = r13.get(r10)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r9[r5] = r10     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r9 = java.lang.String.format(r11, r9)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r12.append(r9)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r9 = r12.toString()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            goto L_0x0193
        L_0x01dd:
            java.lang.String r4 = "headers"
            r7.setOption((int) r5, (java.lang.String) r4, (java.lang.String) r9)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
        L_0x01e2:
            int r4 = r1.O     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r7.setBitrateIndex(r4)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r4 = 5
            com.tencent.ijk.media.player.IjkMediaPlayer.native_setLogLevel(r4)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.liteav.txcvodplayer.d r4 = r1.w     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = r4.f32077e     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            if (r4 == 0) goto L_0x026e
            com.tencent.liteav.txcvodplayer.a.b r4 = r1.D     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            boolean r4 = r4.d(r0)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            if (r4 == 0) goto L_0x026e
            com.tencent.liteav.txcvodplayer.a.b r4 = r1.D     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.liteav.txcvodplayer.d r8 = r1.w     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r8 = r8.f32077e     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r4.b((java.lang.String) r8)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.liteav.txcvodplayer.a.b r4 = r1.D     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.liteav.txcvodplayer.d r8 = r1.w     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            int r8 = r8.f32078f     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r4.a((int) r8)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.liteav.txcvodplayer.a.b r4 = r1.D     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.liteav.txcvodplayer.a.a r4 = r4.c(r0)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r1.C = r4     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.liteav.txcvodplayer.a.a r4 = r1.C     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            if (r4 == 0) goto L_0x026e
            com.tencent.liteav.txcvodplayer.a.a r4 = r1.C     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = r4.a()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            if (r4 == 0) goto L_0x0242
            java.lang.String r0 = "cache_file_path"
            com.tencent.liteav.txcvodplayer.a.a r4 = r1.C     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = r4.a()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r7.setOption((int) r5, (java.lang.String) r0, (java.lang.String) r4)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r0.<init>()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = "ijkio:cache:ffio:"
            r0.append(r4)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            android.net.Uri r4 = r1.h     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = r4.toString()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r0.append(r4)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r0 = r0.toString()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            goto L_0x026e
        L_0x0242:
            com.tencent.liteav.txcvodplayer.a.a r4 = r1.C     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = r4.b()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            if (r4 == 0) goto L_0x026e
            java.lang.String r0 = "cache_db_path"
            com.tencent.liteav.txcvodplayer.a.a r4 = r1.C     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = r4.b()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r7.setOption((int) r5, (java.lang.String) r0, (java.lang.String) r4)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r0.<init>()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = "ijkhlscache:"
            r0.append(r4)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            android.net.Uri r4 = r1.h     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = r4.toString()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r0.append(r4)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r0 = r0.toString()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            goto L_0x026e
        L_0x026d:
            r7 = 0
        L_0x026e:
            java.lang.String r4 = r1.f32022g     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r8.<init>()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r9 = "ijk media player "
            r8.append(r9)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r8.append(r7)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r8 = r8.toString()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.liteav.basic.log.TXCLog.i(r4, r8)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            goto L_0x02be
        L_0x0285:
            com.tencent.ijk.media.player.AndroidMediaPlayer r7 = new com.tencent.ijk.media.player.AndroidMediaPlayer     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r7.<init>()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = r1.f32022g     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r8.<init>()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r9 = "android media player "
            r8.append(r9)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r8.append(r7)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r8 = r8.toString()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.liteav.basic.log.TXCLog.i(r4, r8)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            goto L_0x02be
        L_0x02a1:
            com.tencent.ijk.media.exo.IjkExoMediaPlayer r7 = new com.tencent.ijk.media.exo.IjkExoMediaPlayer     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            android.content.Context r4 = r1.v     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r7.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r4 = r1.f32022g     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r8.<init>()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r9 = "exo media player "
            r8.append(r9)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r8.append(r7)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            java.lang.String r8 = r8.toString()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.liteav.basic.log.TXCLog.i(r4, r8)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
        L_0x02be:
            com.tencent.ijk.media.player.TextureMediaPlayer r4 = new com.tencent.ijk.media.player.TextureMediaPlayer     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r4.<init>(r7)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r1.l = r4     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.ijk.media.player.IMediaPlayer r4 = r1.l     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r4.setDataSource((java.lang.String) r0)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.ijk.media.player.IMediaPlayer r0 = r1.l     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.ijk.media.player.IMediaPlayer$OnPreparedListener r4 = r1.f32020e     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r0.setOnPreparedListener(r4)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.ijk.media.player.IMediaPlayer r0 = r1.l     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.ijk.media.player.IMediaPlayer$OnVideoSizeChangedListener r4 = r1.f32019d     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r0.setOnVideoSizeChangedListener(r4)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.ijk.media.player.IMediaPlayer r0 = r1.l     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.ijk.media.player.IMediaPlayer$OnCompletionListener r4 = r1.R     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r0.setOnCompletionListener(r4)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.ijk.media.player.IMediaPlayer r0 = r1.l     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.ijk.media.player.IMediaPlayer$OnErrorListener r4 = r1.U     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r0.setOnErrorListener(r4)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.ijk.media.player.IMediaPlayer r0 = r1.l     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.ijk.media.player.IMediaPlayer$OnInfoListener r4 = r1.S     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r0.setOnInfoListener(r4)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.ijk.media.player.IMediaPlayer r0 = r1.l     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.ijk.media.player.IMediaPlayer$OnBufferingUpdateListener r4 = r1.aa     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r0.setOnBufferingUpdateListener(r4)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.ijk.media.player.IMediaPlayer r0 = r1.l     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.ijk.media.player.IMediaPlayer$OnSeekCompleteListener r4 = r1.ab     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r0.setOnSeekCompleteListener(r4)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.ijk.media.player.IMediaPlayer r0 = r1.l     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.ijk.media.player.IMediaPlayer$OnTimedTextListener r4 = r1.ac     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r0.setOnTimedTextListener(r4)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.ijk.media.player.IMediaPlayer r0 = r1.l     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.ijk.media.player.IMediaPlayer$OnHLSKeyErrorListener r4 = r1.ae     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r0.setOnHLSKeyErrorListener(r4)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.ijk.media.player.IMediaPlayer r0 = r1.l     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.ijk.media.player.IMediaPlayer$OnHevcVideoDecoderErrorListener r4 = r1.V     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r0.setOnHevcVideoDecoderErrorListener(r4)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.ijk.media.player.IMediaPlayer r0 = r1.l     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.ijk.media.player.IMediaPlayer$OnVideoDecoderErrorListener r4 = r1.W     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r0.setOnVideoDecoderErrorListener(r4)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r1.s = r2     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.ijk.media.player.IMediaPlayer r0 = r1.l     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.liteav.txcvodplayer.a$b r4 = r1.k     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r1.a((com.tencent.ijk.media.player.IMediaPlayer) r0, (com.tencent.liteav.txcvodplayer.a.b) r4)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.ijk.media.player.IMediaPlayer r0 = r1.l     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r0.setAudioStreamType(r3)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.ijk.media.player.IMediaPlayer r0 = r1.l     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r0.setScreenOnWhilePlaying(r5)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.ijk.media.player.IMediaPlayer r0 = r1.l     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r0.prepareAsync()     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            boolean r0 = r1.N     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r1.setMute(r0)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.liteav.txcvodplayer.b r0 = r1.Q     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            if (r0 == 0) goto L_0x033f
            com.tencent.liteav.txcvodplayer.b r0 = r1.Q     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            com.tencent.ijk.media.player.IMediaPlayer r3 = r1.l     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            r0.a((com.tencent.ijk.media.player.IMediaPlayer) r3)     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
        L_0x033f:
            r1.i = r5     // Catch:{ FileNotFoundException -> 0x0358, Exception -> 0x0342 }
            goto L_0x0367
        L_0x0342:
            r0 = move-exception
            java.lang.String r3 = r1.f32022g
            java.lang.String r0 = r0.toString()
            com.tencent.liteav.basic.log.TXCLog.w(r3, r0)
            r1.i = r6
            r1.j = r6
            com.tencent.ijk.media.player.IMediaPlayer$OnErrorListener r0 = r1.U
            com.tencent.ijk.media.player.IMediaPlayer r3 = r1.l
            r0.onError(r3, r5, r2)
            goto L_0x0367
        L_0x0358:
            r1.i = r6
            r1.j = r6
            com.tencent.ijk.media.player.IMediaPlayer$OnErrorListener r0 = r1.U
            com.tencent.ijk.media.player.IMediaPlayer r2 = r1.l
            r3 = -1004(0xfffffffffffffc14, float:NaN)
            r4 = -2303(0xfffffffffffff701, float:NaN)
            r0.onError(r2, r3, r4)
        L_0x0367:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.txcvodplayer.TXCVodVideoView.f():boolean");
    }

    /* access modifiers changed from: private */
    public void a(IMediaPlayer iMediaPlayer, a.b bVar) {
        if (iMediaPlayer != null) {
            if (bVar == null) {
                iMediaPlayer.setDisplay((SurfaceHolder) null);
                return;
            }
            TXCLog.d(this.f32022g, "bindSurfaceHolder");
            bVar.a(iMediaPlayer);
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        IMediaPlayer iMediaPlayer = this.l;
        if (iMediaPlayer != null) {
            iMediaPlayer.setDisplay((SurfaceHolder) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        if (this.l != null) {
            String str = this.f32022g;
            TXCLog.d(str, "release player " + this.l);
            this.l.reset();
            this.l.release();
            this.l = null;
            this.i = 0;
            if (z2) {
                this.j = 0;
                this.m = 0;
                this.n = 0;
            }
            ((AudioManager) this.v.getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
        }
    }

    public void b() {
        TXCLog.i(this.f32022g, ViewProps.START);
        if (h()) {
            if (this.f32018c == 1 && this.i == 5) {
                this.H = 0;
                this.l.seekTo(0);
            }
            this.l.start();
            if (this.i != 3 && !this.J) {
                this.i = 3;
                a(2004, "播放开始", "playing");
            }
        }
        this.j = 3;
    }

    /* access modifiers changed from: private */
    public void g() {
        TXCLog.d(this.f32022g, "replay");
        int i2 = this.f32018c;
        if (i2 == 0) {
            if (this.t == 0) {
                IMediaPlayer iMediaPlayer = this.l;
                if (iMediaPlayer != null && this.u > 0) {
                    this.t = (int) iMediaPlayer.getCurrentPosition();
                }
            }
            if (!f()) {
                a(false);
            }
        } else if (i2 == 1) {
            j();
        }
    }

    public void c() {
        if (this.l != null) {
            if (this.C != null) {
                if (getDuration() <= 0) {
                    this.D.a(this.C.d(), true);
                } else {
                    this.D.a(this.C.d(), false);
                }
                this.C = null;
            }
            this.l.stop();
            this.l.release();
            this.l = null;
            this.h = null;
            this.m = 0;
            this.n = 0;
            this.B = 1.0f;
            this.J = false;
            this.K = -1;
            this.i = 0;
            this.j = 0;
            this.P = false;
            this.O = 0;
            b bVar = this.Q;
            if (bVar != null) {
                bVar.a((IMediaPlayer) null);
            }
            ((AudioManager) this.v.getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
        }
        Handler handler = this.ah;
        if (handler != null) {
            handler.removeMessages(102);
        }
        TXCLog.i(this.f32022g, "stop");
    }

    public void d() {
        this.j = 4;
        TXCLog.i(this.f32022g, "pause");
        if (h() && this.l.isPlaying()) {
            this.l.pause();
            this.i = 4;
        }
    }

    public int getDuration() {
        IMediaPlayer iMediaPlayer = this.l;
        if (iMediaPlayer != null && this.u < 1) {
            this.u = (int) iMediaPlayer.getDuration();
        }
        return this.u;
    }

    public int getCurrentPosition() {
        if (this.f32018c == 0) {
            if (this.J) {
                int i2 = this.K;
                if (i2 >= 0) {
                    return i2;
                }
            }
            int i3 = this.t;
            if (i3 > 0) {
                return i3;
            }
        }
        IMediaPlayer iMediaPlayer = this.l;
        if (iMediaPlayer == null) {
            return 0;
        }
        int currentPosition = (int) iMediaPlayer.getCurrentPosition();
        if (currentPosition <= 1) {
            return Math.max(currentPosition, this.H);
        }
        this.H = currentPosition;
        return currentPosition;
    }

    public void a(int i2) {
        String str = this.f32022g;
        TXCLog.d(str, "seek to " + i2);
        if (getUrlPathExtention().equals(IjkMediaMeta.IJKM_KEY_M3U8)) {
            i2 = Math.min(i2, getDuration() + TLSErrInfo.TIMEOUT);
        }
        if (i2 >= 0 && h()) {
            if (i2 > getDuration()) {
                i2 = getDuration();
            }
            if (this.J) {
                this.K = i2;
            } else {
                this.K = -1;
                this.l.seekTo((long) i2);
            }
            if (this.f32018c == 0) {
                this.J = true;
            }
        }
    }

    public void setMute(boolean z2) {
        this.N = z2;
        IMediaPlayer iMediaPlayer = this.l;
        if (iMediaPlayer != null) {
            if (z2) {
                iMediaPlayer.setVolume(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
            } else {
                iMediaPlayer.setVolume(this.L, this.M);
            }
        }
    }

    public boolean e() {
        return h() && this.l.isPlaying() && this.i != 4;
    }

    public int getBufferDuration() {
        if (this.l == null) {
            return 0;
        }
        IMediaPlayer unwrappedMediaPlayer = getUnwrappedMediaPlayer();
        try {
            if (1 == this.f32018c && (unwrappedMediaPlayer instanceof IjkExoMediaPlayer)) {
                this.s = ((IjkExoMediaPlayer) unwrappedMediaPlayer).getBufferedPercentage();
            }
        } catch (NoClassDefFoundError unused) {
        }
        int duration = (this.s * getDuration()) / 100;
        if (duration < getCurrentPosition()) {
            duration = getCurrentPosition();
        }
        return Math.abs(getDuration() - duration) < 1000 ? getDuration() : duration;
    }

    private boolean h() {
        if (this.l != null) {
            int i2 = this.i;
            return (i2 == -1 || i2 == 0 || i2 == 1) ? false : true;
        }
    }

    public void setConfig(d dVar) {
        if (dVar != null) {
            this.w = dVar;
            this.D.a(this.w.k);
        }
    }

    public void setRenderMode(int i2) {
        this.af = i2;
        a aVar = this.x;
        if (aVar != null) {
            aVar.setAspectRatio(this.af);
        }
        a aVar2 = this.x;
        if (aVar2 != null) {
            aVar2.setVideoRotation(this.q);
        }
    }

    public void setVideoRotationDegree(int i2) {
        if (!(i2 == 0 || i2 == 90 || i2 == 180 || i2 == 270)) {
            if (i2 != 360) {
                String str = this.f32022g;
                TXCLog.e(str, "not support degree " + i2);
                return;
            }
            i2 = 0;
        }
        this.q = i2;
        a aVar = this.x;
        if (aVar != null) {
            aVar.setVideoRotation(this.q);
        }
        a aVar2 = this.x;
        if (aVar2 != null) {
            aVar2.setAspectRatio(this.af);
        }
    }

    public int getVideoRotationDegree() {
        return this.q;
    }

    private void i() {
        setRender(0);
    }

    public void setAutoPlay(boolean z2) {
        this.f32017b = z2;
    }

    public void setRate(float f2) {
        String str = this.f32022g;
        TXCLog.d(str, "setRate " + f2);
        IMediaPlayer iMediaPlayer = this.l;
        if (iMediaPlayer != null) {
            iMediaPlayer.setRate(f2);
        }
        this.B = f2;
    }

    public void setStartTime(float f2) {
        this.t = (int) (f2 * 1000.0f);
    }

    public void setAutoRotate(boolean z2) {
        this.f32016a = z2;
    }

    private static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<TXCVodVideoView> f32040a;

        /* renamed from: b  reason: collision with root package name */
        private final int f32041b = 500;

        public a(TXCVodVideoView tXCVodVideoView, Looper looper) {
            super(looper);
            this.f32040a = new WeakReference<>(tXCVodVideoView);
        }

        public void handleMessage(Message message) {
            long j;
            long j2;
            float f2;
            TXCVodVideoView tXCVodVideoView = (TXCVodVideoView) this.f32040a.get();
            if (tXCVodVideoView != null && tXCVodVideoView.ag != null) {
                switch (message.what) {
                    case 100:
                        IMediaPlayer unwrappedMediaPlayer = tXCVodVideoView.getUnwrappedMediaPlayer();
                        if (unwrappedMediaPlayer != null) {
                            boolean z = unwrappedMediaPlayer instanceof IjkMediaPlayer;
                            float f3 = BitmapDescriptorFactory.HUE_RED;
                            long j3 = 0;
                            if (z) {
                                IjkMediaPlayer ijkMediaPlayer = (IjkMediaPlayer) unwrappedMediaPlayer;
                                f3 = ijkMediaPlayer.getVideoOutputFramesPerSecond();
                                f2 = ijkMediaPlayer.getVideoDecodeFramesPerSecond();
                                j3 = ijkMediaPlayer.getVideoCachedBytes() + ijkMediaPlayer.getAudioCachedBytes();
                                j2 = ijkMediaPlayer.getBitRate();
                                j = ijkMediaPlayer.getTcpSpeed();
                            } else {
                                if (unwrappedMediaPlayer instanceof IjkExoMediaPlayer) {
                                    IjkExoMediaPlayer ijkExoMediaPlayer = (IjkExoMediaPlayer) unwrappedMediaPlayer;
                                    d videoDecoderCounters = ijkExoMediaPlayer.getVideoDecoderCounters();
                                    if (videoDecoderCounters != null) {
                                        long currentTimeMillis = System.currentTimeMillis() - tXCVodVideoView.F;
                                        int z2 = videoDecoderCounters.f9275d - tXCVodVideoView.E;
                                        long unused = tXCVodVideoView.F = System.currentTimeMillis();
                                        int unused2 = tXCVodVideoView.E = videoDecoderCounters.f9275d;
                                        if (currentTimeMillis < 3000 && currentTimeMillis > 0 && z2 < 120 && z2 > 0) {
                                            double d2 = (double) currentTimeMillis;
                                            Double.isNaN(d2);
                                            double d3 = 1000.0d / d2;
                                            double d4 = (double) z2;
                                            Double.isNaN(d4);
                                            int unused3 = tXCVodVideoView.G = (int) Math.ceil(d3 * d4);
                                        }
                                    }
                                    j2 = (long) ijkExoMediaPlayer.getObservedBitrate();
                                    j = j2 / 8;
                                    f3 = (float) tXCVodVideoView.G;
                                } else {
                                    j2 = 0;
                                    j = 0;
                                }
                                f2 = BitmapDescriptorFactory.HUE_RED;
                            }
                            Bundle bundle = new Bundle();
                            bundle.putFloat("fps", f3);
                            bundle.putFloat("dps", f2);
                            bundle.putLong("cachedBytes", j3);
                            bundle.putLong("bitRate", j2);
                            bundle.putLong("tcpSpeed", j);
                            tXCVodVideoView.ag.a(bundle);
                            removeMessages(100);
                            sendEmptyMessageDelayed(100, 500);
                            return;
                        }
                        return;
                    case 101:
                        tXCVodVideoView.ag.a(message.arg1, message.getData());
                        return;
                    case 102:
                        tXCVodVideoView.g();
                        tXCVodVideoView.a(2103, "点播网络重连", "reconnect");
                        return;
                    case 103:
                        long currentPosition = (long) tXCVodVideoView.getCurrentPosition();
                        Bundle bundle2 = new Bundle();
                        long bufferDuration = (long) tXCVodVideoView.getBufferDuration();
                        long duration = (long) tXCVodVideoView.getDuration();
                        bundle2.putInt(TXLiveConstants.EVT_PLAY_PROGRESS, (int) (currentPosition / 1000));
                        bundle2.putInt(TXLiveConstants.EVT_PLAY_DURATION, (int) (duration / 1000));
                        bundle2.putInt("EVT_PLAYABLE_DURATION", (int) (bufferDuration / 1000));
                        bundle2.putInt(TXLiveConstants.EVT_PLAY_PROGRESS_MS, (int) currentPosition);
                        bundle2.putInt(TXLiveConstants.EVT_PLAY_DURATION_MS, (int) duration);
                        bundle2.putInt(TXLiveConstants.EVT_PLAYABLE_DURATION_MS, (int) bufferDuration);
                        tXCVodVideoView.ag.a(2005, bundle2);
                        if (tXCVodVideoView.l != null) {
                            removeMessages(103);
                            if (tXCVodVideoView.w.l <= 0) {
                                tXCVodVideoView.w.l = 500;
                            }
                            sendEmptyMessageDelayed(103, (long) tXCVodVideoView.w.l);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private void j() {
        IjkExoMediaPlayer ijkExoMediaPlayer = (IjkExoMediaPlayer) getUnwrappedMediaPlayer();
        if (1 == this.f32018c && (ijkExoMediaPlayer instanceof IjkExoMediaPlayer)) {
            ijkExoMediaPlayer.getPlayer().a(ijkExoMediaPlayer.buildMediaSource(this.h, (String) null), false, false);
            if (this.A == null) {
                ijkExoMediaPlayer.getPlayer().a(this.f32017b);
            } else {
                ijkExoMediaPlayer.getPlayer().a(true);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str, String str2) {
        if ((i2 != -2304 && i2 != 2106) || !this.ai) {
            Message message = new Message();
            message.what = 101;
            Bundle bundle = new Bundle();
            message.arg1 = i2;
            bundle.putString("description", str);
            message.setData(bundle);
            Handler handler = this.ah;
            if (handler != null) {
                handler.sendMessage(message);
            }
            if (!(i2 == 2018 || i2 == 2016)) {
                String str3 = this.f32022g;
                TXCLog.d(str3, "sendSimpleEvent " + i2 + SQLBuilder.BLANK + str2);
            }
            this.ai = i2 == -2304 || i2 == 2106;
        }
    }

    public void setListener(e eVar) {
        this.ag = eVar;
    }

    public int getVideoWidth() {
        return this.m;
    }

    public int getVideoHeight() {
        return this.n;
    }

    public String getServerIp() {
        return this.A;
    }

    public int getPlayerType() {
        return this.f32018c;
    }

    public void setPlayerType(int i2) {
        this.f32018c = i2;
        if (this.f32018c == 0) {
            this.f32018c = 1;
        }
    }

    /* access modifiers changed from: package-private */
    public String getUrlPathExtention() {
        Uri uri = this.h;
        if (uri == null || uri.getPath() == null) {
            return "";
        }
        String path = this.h.getPath();
        return path.substring(path.lastIndexOf(".") + 1, path.length());
    }

    public IMediaPlayer getUnwrappedMediaPlayer() {
        IMediaPlayer iMediaPlayer = this.l;
        return iMediaPlayer instanceof TextureMediaPlayer ? ((TextureMediaPlayer) iMediaPlayer).getBackEndMediaPlayer() : iMediaPlayer;
    }

    public int getBitrateIndex() {
        IMediaPlayer iMediaPlayer = this.l;
        if (iMediaPlayer != null) {
            return iMediaPlayer.getBitrateIndex();
        }
        return this.O;
    }

    public void setBitrateIndex(int i2) {
        String str = this.f32022g;
        TXCLog.d(str, "setBitrateIndex " + i2);
        if (this.O != i2) {
            this.O = i2;
            if (this.l == null) {
                return;
            }
            if (this.w.j) {
                this.l.setBitrateIndex(i2);
            } else {
                g();
            }
        }
    }

    public ArrayList<IjkBitrateItem> getSupportedBitrates() {
        IMediaPlayer iMediaPlayer = this.l;
        if (iMediaPlayer != null) {
            return iMediaPlayer.getSupportedBitrates();
        }
        return new ArrayList<>();
    }

    public MediaInfo getMediaInfo() {
        IMediaPlayer iMediaPlayer = this.l;
        if (iMediaPlayer == null) {
            return null;
        }
        return iMediaPlayer.getMediaInfo();
    }
}
