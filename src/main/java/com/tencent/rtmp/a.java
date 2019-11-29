package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.g;
import com.tencent.liteav.i;
import com.tencent.liteav.o;
import com.tencent.liteav.p;
import com.tencent.liteav.q;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;
import java.util.Vector;

public class a implements com.tencent.liteav.basic.c.a {
    private long A = 0;
    private TXLivePlayer.ITXAudioRawDataListener B;

    /* renamed from: a  reason: collision with root package name */
    private TXCloudVideoView f32333a;

    /* renamed from: b  reason: collision with root package name */
    private Surface f32334b;

    /* renamed from: c  reason: collision with root package name */
    private int f32335c;

    /* renamed from: d  reason: collision with root package name */
    private int f32336d;

    /* renamed from: e  reason: collision with root package name */
    private ITXLivePlayListener f32337e;

    /* renamed from: f  reason: collision with root package name */
    private TXLivePlayConfig f32338f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f32339g = false;
    private boolean h = true;
    private int i;
    private int j;
    private String k = "";
    private boolean l = false;
    /* access modifiers changed from: private */
    public TXLivePlayer.ITXVideoRawDataListener m = null;
    /* access modifiers changed from: private */
    public byte[] n = null;
    private Context o;
    /* access modifiers changed from: private */
    public o p;
    private boolean q = true;
    private float r = 1.0f;
    /* access modifiers changed from: private */
    public boolean s = false;
    private int t = 0;
    private i u;
    private boolean v;
    /* access modifiers changed from: private */
    public long w;
    private String x;
    private int y = -1;
    private Vector<String> z = new Vector<>();

    public a(Context context) {
        TXCLog.init();
        this.f32337e = null;
        this.o = context.getApplicationContext();
    }

    public void a(TXLivePlayConfig tXLivePlayConfig) {
        TXCLog.d(TXLivePlayer.TAG, "liteav_api setConfig " + this);
        this.f32338f = tXLivePlayConfig;
        if (this.f32338f == null) {
            this.f32338f = new TXLivePlayConfig();
        }
        o oVar = this.p;
        if (oVar != null) {
            g p2 = oVar.p();
            if (p2 == null) {
                p2 = new g();
            }
            p2.f31627a = this.f32338f.mCacheTime;
            p2.f31633g = this.f32338f.mAutoAdjustCacheTime;
            p2.f31629c = this.f32338f.mMinAutoAdjustCacheTime;
            p2.f31628b = this.f32338f.mMaxAutoAdjustCacheTime;
            p2.f31630d = this.f32338f.mVideoBlockThreshold;
            p2.f31631e = this.f32338f.mConnectRetryCount;
            p2.f31632f = this.f32338f.mConnectRetryInterval;
            p2.h = this.f32338f.mEnableAec;
            p2.j = this.f32338f.mEnableNearestIP;
            p2.l = this.f32338f.mRtmpChannelType;
            p2.i = this.f32339g;
            p2.m = this.f32338f.mCacheFolderPath;
            p2.n = this.f32338f.mMaxCacheItems;
            p2.k = this.f32338f.mEnableMessage;
            p2.p = this.f32338f.mHeaders;
            this.p.a(p2);
        }
    }

    public void a(ITXLivePlayListener iTXLivePlayListener) {
        TXCLog.d(TXLivePlayer.TAG, "liteav_api setPlayListener " + this);
        this.f32337e = iTXLivePlayListener;
    }

    public void a(TXCloudVideoView tXCloudVideoView) {
        TXCLog.d(TXLivePlayer.TAG, "liteav_api setPlayerView old view : " + this.f32333a + ", new view : " + tXCloudVideoView + ", " + this);
        this.f32333a = tXCloudVideoView;
        o oVar = this.p;
        if (oVar != null) {
            oVar.a(tXCloudVideoView);
        }
    }

    public int a(String str, int i2) {
        TXCLog.d(TXLivePlayer.TAG, "liteav_api startPlay " + this);
        if (TextUtils.isEmpty(str)) {
            TXCLog.e(TXLivePlayer.TAG, "start play error when url is empty " + this);
            return -1;
        }
        if (!TextUtils.isEmpty(this.k) && a()) {
            if (this.k.equalsIgnoreCase(str)) {
                TXCLog.e(TXLivePlayer.TAG, "start play error when new url is the same with old url  " + this);
                return -1;
            }
            TXCLog.w(TXLivePlayer.TAG, " stop old play when new url is not the same with old url  " + this);
            o oVar = this.p;
            if (oVar != null) {
                oVar.a(false);
            }
            this.k = "";
        }
        TXCDRApi.initCrashReport(this.o);
        TXCLog.d(TXLivePlayer.TAG, "===========================================================================================================================================================");
        TXCLog.d(TXLivePlayer.TAG, "===========================================================================================================================================================");
        TXCLog.d(TXLivePlayer.TAG, "=====  StartPlay url = " + str + " playType = " + i2 + " SDKVersion = " + TXCCommonUtil.getSDKID() + " , " + TXCCommonUtil.getSDKVersionStr() + "    ======");
        TXCLog.d(TXLivePlayer.TAG, "===========================================================================================================================================================");
        TXCLog.d(TXLivePlayer.TAG, "===========================================================================================================================================================");
        int i3 = this.y;
        if (i3 == -1 || i3 != i2) {
            this.p = q.a(this.o, i2);
        }
        this.y = i2;
        if (this.p == null) {
            return -2;
        }
        this.k = c(str, i2);
        a(this.f32338f);
        TXCloudVideoView tXCloudVideoView = this.f32333a;
        if (tXCloudVideoView != null) {
            tXCloudVideoView.clearLog();
            this.f32333a.setVisibility(0);
        }
        this.p.a(this.f32333a);
        this.p.a((com.tencent.liteav.basic.c.a) this);
        this.p.c(this.q);
        Surface surface = this.f32334b;
        if (surface != null) {
            this.p.a(surface);
            this.p.a(this.f32335c, this.f32336d);
        }
        this.p.a(this.k, i2);
        this.p.b(this.l);
        this.p.b(this.r);
        this.p.b(this.j);
        this.p.a(this.i);
        c(this.t);
        this.p.a(this.B);
        a(this.m);
        if (this.p.f()) {
            this.x = this.k;
            i iVar = this.u;
            this.w = iVar != null ? iVar.a() : 0;
            if (this.w > 0) {
                this.p.g();
            }
        }
        return 0;
    }

    public int a(boolean z2) {
        TXCLog.d(TXLivePlayer.TAG, "liteav_api stopPlay " + z2 + ", " + this);
        if (z2) {
            TXCloudVideoView tXCloudVideoView = this.f32333a;
            if (tXCloudVideoView != null) {
                tXCloudVideoView.setVisibility(8);
            }
        }
        o oVar = this.p;
        if (oVar != null) {
            oVar.a((p) null);
            this.p.a(z2);
        }
        this.k = "";
        this.w = 0;
        this.u = null;
        this.v = false;
        return 0;
    }

    public boolean a() {
        o oVar = this.p;
        if (oVar != null) {
            return oVar.c();
        }
        return false;
    }

    public void b() {
        TXCLog.d(TXLivePlayer.TAG, "liteav_api pause " + this);
        if (this.p != null) {
            TXCLog.w(TXLivePlayer.TAG, "pause play");
            this.p.a();
        }
    }

    public void c() {
        TXCLog.d(TXLivePlayer.TAG, "liteav_api resume " + this);
        if (this.p != null) {
            TXCLog.w(TXLivePlayer.TAG, "resume play");
            this.p.b();
            c(this.t);
        }
    }

    public void a(Surface surface) {
        TXCLog.d(TXLivePlayer.TAG, "liteav_api setSurface old : " + this.f32334b + ", new : " + surface + ", " + this);
        this.f32334b = surface;
        o oVar = this.p;
        if (oVar != null) {
            oVar.a(this.f32334b);
        }
    }

    public void a(int i2, int i3) {
        TXCLog.d(TXLivePlayer.TAG, "liteav_api setSurfaceSize " + i2 + "x" + i3 + ", " + this);
        this.f32335c = i2;
        this.f32336d = i3;
        o oVar = this.p;
        if (oVar != null) {
            oVar.a(i2, i3);
        }
    }

    public void a(int i2) {
        TXCLog.d(TXLivePlayer.TAG, "liteav_api setRenderMode " + i2);
        this.i = i2;
        o oVar = this.p;
        if (oVar != null) {
            oVar.a(i2);
        }
    }

    public void b(int i2) {
        TXCLog.d(TXLivePlayer.TAG, "liteav_api setRenderRotation " + i2);
        this.j = i2;
        o oVar = this.p;
        if (oVar != null) {
            oVar.b(i2);
        }
    }

    public boolean b(boolean z2) {
        TXCLog.d(TXLivePlayer.TAG, "liteav_api enableHardwareDecode " + z2);
        if (z2) {
            if (Build.VERSION.SDK_INT < 18) {
                TXCLog.e("HardwareDecode", "enableHardwareDecode failed, android system build.version = " + Build.VERSION.SDK_INT + ", the minimum build.version should be 18(android 4.3 or later)");
                return false;
            } else if (f()) {
                TXCLog.e("HardwareDecode", "enableHardwareDecode failed, MANUFACTURER = " + Build.MANUFACTURER + ", MODEL" + Build.MODEL);
                return false;
            }
        }
        this.f32339g = z2;
        o oVar = this.p;
        if (oVar == null) {
            return true;
        }
        g p2 = oVar.p();
        if (p2 == null) {
            p2 = new g();
        }
        p2.i = this.f32339g;
        this.p.a(p2);
        return true;
    }

    public void c(boolean z2) {
        TXCLog.d(TXLivePlayer.TAG, "liteav_api setMute " + z2);
        this.l = z2;
        o oVar = this.p;
        if (oVar != null) {
            oVar.b(z2);
        }
    }

    public void c(int i2) {
        TXCLog.d(TXLivePlayer.TAG, "liteav_api setAudioRoute " + i2);
        this.t = i2;
        o oVar = this.p;
        if (oVar != null) {
            oVar.a(this.o, this.t);
        }
    }

    public int a(String str) {
        o oVar = this.p;
        if (oVar != null) {
            return oVar.a(str);
        }
        return -1;
    }

    public void a(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        TXCLog.d(TXLivePlayer.TAG, "liteav_api setVideoRecordListener");
        o oVar = this.p;
        if (oVar != null) {
            oVar.a(iTXVideoRecordListener);
        }
    }

    public int d(int i2) {
        TXCLog.d(TXLivePlayer.TAG, "liteav_api startRecord " + this);
        if (Build.VERSION.SDK_INT < 18) {
            TXCLog.e(TXLivePlayer.TAG, "API levl is too low (record need 18, current is" + Build.VERSION.SDK_INT + SQLBuilder.PARENTHESES_RIGHT);
            return -3;
        } else if (!a()) {
            TXCLog.e(TXLivePlayer.TAG, "startRecord: there is no playing stream");
            return -1;
        } else {
            o oVar = this.p;
            if (oVar != null) {
                return oVar.c(i2);
            }
            return -1;
        }
    }

    public int d() {
        TXCLog.d(TXLivePlayer.TAG, "liteav_api stopRecord " + this);
        o oVar = this.p;
        if (oVar != null) {
            return oVar.e();
        }
        return -1;
    }

    public void a(TXLivePlayer.ITXSnapshotListener iTXSnapshotListener) {
        Bitmap bitmap;
        Bitmap bitmap2;
        TXCLog.d(TXLivePlayer.TAG, "liteav_api snapshot " + iTXSnapshotListener);
        if (!this.s && iTXSnapshotListener != null) {
            this.s = true;
            o oVar = this.p;
            TextureView d2 = oVar != null ? oVar.d() : null;
            if (d2 != null) {
                try {
                    bitmap = d2.getBitmap();
                } catch (OutOfMemoryError unused) {
                    bitmap = null;
                }
                if (bitmap != null) {
                    bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), d2.getTransform((Matrix) null), true);
                    bitmap.recycle();
                } else {
                    bitmap2 = bitmap;
                }
                a(iTXSnapshotListener, bitmap2);
                return;
            }
            this.s = false;
        }
    }

    public boolean a(byte[] bArr) {
        String str = this.k;
        if (str == null || str.isEmpty()) {
            return false;
        }
        if (this.f32339g) {
            TXLog.e(TXLivePlayer.TAG, "can not addVideoRawData because of hw decode has set!");
            return false;
        } else if (this.p == null) {
            TXCLog.e(TXLivePlayer.TAG, "player hasn't created or not instanceof live player");
            return false;
        } else {
            this.n = bArr;
            return true;
        }
    }

    public void a(TXLivePlayer.ITXVideoRawDataListener iTXVideoRawDataListener) {
        TXCLog.d(TXLivePlayer.TAG, "liteav_api setVideoRawDataListener " + iTXVideoRawDataListener);
        this.m = iTXVideoRawDataListener;
        o oVar = this.p;
        if (oVar != null) {
            if (iTXVideoRawDataListener != null) {
                oVar.a((p) new p() {
                    public void a(String str, int i, TXSVideoFrame tXSVideoFrame) {
                        if (tXSVideoFrame != null && tXSVideoFrame.width > 0 && tXSVideoFrame.height > 0) {
                            byte[] a2 = a.this.n;
                            byte[] unused = a.this.n = null;
                            TXLivePlayer.ITXVideoRawDataListener b2 = a.this.m;
                            if (b2 != null && a2 != null) {
                                if (a2.length >= ((tXSVideoFrame.width * tXSVideoFrame.height) * 3) / 2) {
                                    tXSVideoFrame.loadI420Array(a2);
                                    b2.onVideoRawDataAvailable(a2, tXSVideoFrame.width, tXSVideoFrame.height, (int) tXSVideoFrame.pts);
                                    tXSVideoFrame.release();
                                    return;
                                }
                                TXCLog.e(TXLivePlayer.TAG, "raw data buffer length is too large");
                            }
                        }
                    }
                });
            } else {
                oVar.a((p) null);
            }
        }
    }

    public void a(TXLivePlayer.ITXAudioRawDataListener iTXAudioRawDataListener) {
        TXCLog.d(TXLivePlayer.TAG, "liteav_api setAudioRawDataListener " + iTXAudioRawDataListener);
        this.B = iTXAudioRawDataListener;
        o oVar = this.p;
        if (oVar != null) {
            oVar.a(iTXAudioRawDataListener);
        }
    }

    public int b(String str, int i2) {
        TXCLog.d(TXLivePlayer.TAG, "liteav_api prepareLiveSeek " + this);
        if (this.u == null) {
            this.u = new i(this.o);
        }
        i iVar = this.u;
        if (iVar != null) {
            return iVar.a(this.k, str, i2, new i.a() {
                public void a(long j) {
                    long unused = a.this.w = j;
                    if (a.this.p != null) {
                        a.this.p.g();
                    }
                }
            });
        }
        return -1;
    }

    public void e(int i2) {
        TXCLog.d(TXLivePlayer.TAG, "liteav_api ");
        o oVar = this.p;
        if (oVar == null) {
            return;
        }
        if (oVar.f() || this.v) {
            i iVar = this.u;
            String a2 = iVar != null ? iVar.a((long) i2) : "";
            if (!TextUtils.isEmpty(a2)) {
                this.v = a(a2, 3) == 0;
                if (this.v) {
                    this.w = (long) (i2 * 1000);
                    return;
                }
                return;
            }
            ITXLivePlayListener iTXLivePlayListener = this.f32337e;
            if (iTXLivePlayListener != null) {
                iTXLivePlayListener.onPlayEvent(-2301, new Bundle());
                return;
            }
            return;
        }
        this.p.d(i2);
    }

    public int e() {
        TXCLog.d(TXLivePlayer.TAG, "liteav_api resumeLive " + this);
        if (!this.v) {
            return -1;
        }
        this.v = false;
        return a(this.x, 1);
    }

    @Deprecated
    public void d(boolean z2) {
        TXCLog.d(TXLivePlayer.TAG, "liteav_api setAutoPlay " + z2);
        this.q = z2;
    }

    @Deprecated
    public void a(float f2) {
        TXCLog.d(TXLivePlayer.TAG, "liteav_api setRate " + f2);
        this.r = f2;
        o oVar = this.p;
        if (oVar != null) {
            oVar.b(f2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:70:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onNotifyEvent(int r17, android.os.Bundle r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = 0
            r4 = 15001(0x3a99, float:2.1021E-41)
            if (r1 != r4) goto L_0x001c
            com.tencent.rtmp.ui.TXCloudVideoView r1 = r0.f32333a
            if (r1 == 0) goto L_0x0013
            r4 = 0
            r1.setLogText(r2, r3, r4)
        L_0x0013:
            com.tencent.rtmp.ITXLivePlayListener r1 = r0.f32337e
            if (r1 == 0) goto L_0x00e9
            r1.onNetStatus(r2)
            goto L_0x00e9
        L_0x001c:
            r4 = 2005(0x7d5, float:2.81E-42)
            if (r1 != r4) goto L_0x0047
            java.lang.String r3 = "EVT_PLAY_PROGRESS_MS"
            int r4 = r2.getInt(r3)
            long r4 = (long) r4
            long r6 = r0.w
            long r4 = r4 + r6
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x00e9
            r6 = 1000(0x3e8, double:4.94E-321)
            long r6 = r4 / r6
            int r7 = (int) r6
            java.lang.String r6 = "EVT_PLAY_PROGRESS"
            r2.putInt(r6, r7)
            int r5 = (int) r4
            r2.putInt(r3, r5)
            com.tencent.rtmp.ITXLivePlayListener r3 = r0.f32337e
            if (r3 == 0) goto L_0x00e9
            r3.onPlayEvent(r1, r2)
            goto L_0x00e9
        L_0x0047:
            r5 = 2026(0x7ea, float:2.839E-42)
            if (r1 != r5) goto L_0x004d
            goto L_0x00e9
        L_0x004d:
            r5 = -2309(0xfffffffffffff6fb, float:NaN)
            r6 = 3002(0xbba, float:4.207E-42)
            r7 = 2106(0x83a, float:2.951E-42)
            r8 = -2302(0xfffffffffffff702, float:NaN)
            r9 = 3003(0xbbb, float:4.208E-42)
            r10 = 2103(0x837, float:2.947E-42)
            r11 = 2101(0x835, float:2.944E-42)
            r12 = 2015(0x7df, float:2.824E-42)
            r13 = 2012(0x7dc, float:2.82E-42)
            r14 = -2304(0xfffffffffffff700, float:NaN)
            r15 = -2307(0xfffffffffffff6fd, float:NaN)
            r4 = -2301(0xfffffffffffff703, float:NaN)
            if (r1 == r5) goto L_0x00d9
            if (r1 == r15) goto L_0x00d6
            if (r1 == r14) goto L_0x00d3
            if (r1 == r13) goto L_0x00d0
            if (r1 == r12) goto L_0x00cd
            if (r1 == r11) goto L_0x00ca
            if (r1 == r10) goto L_0x00c7
            r5 = 2109(0x83d, float:2.955E-42)
            if (r1 == r5) goto L_0x00c6
            if (r1 == r9) goto L_0x00c3
            if (r1 == r8) goto L_0x00c0
            if (r1 == r4) goto L_0x00d9
            r4 = 2021(0x7e5, float:2.832E-42)
            if (r1 == r4) goto L_0x00bd
            r4 = 2022(0x7e6, float:2.833E-42)
            if (r1 == r4) goto L_0x00bd
            r4 = 2105(0x839, float:2.95E-42)
            if (r1 == r4) goto L_0x00db
            if (r1 == r7) goto L_0x00ba
            r4 = 3006(0xbbe, float:4.212E-42)
            if (r1 == r4) goto L_0x00b7
            r4 = 3007(0xbbf, float:4.214E-42)
            if (r1 == r4) goto L_0x00b7
            r4 = 3009(0xbc1, float:4.217E-42)
            if (r1 == r4) goto L_0x00b4
            r4 = 3010(0xbc2, float:4.218E-42)
            if (r1 == r4) goto L_0x00b4
            switch(r1) {
                case 2001: goto L_0x00b1;
                case 2002: goto L_0x00ae;
                case 2003: goto L_0x00db;
                case 2004: goto L_0x00ab;
                case 2005: goto L_0x00a8;
                default: goto L_0x009e;
            }
        L_0x009e:
            switch(r1) {
                case 2007: goto L_0x00a5;
                case 2008: goto L_0x00bd;
                case 2009: goto L_0x00a2;
                default: goto L_0x00a1;
            }
        L_0x00a1:
            return
        L_0x00a2:
            r1 = 2009(0x7d9, float:2.815E-42)
            goto L_0x00db
        L_0x00a5:
            r1 = 2007(0x7d7, float:2.812E-42)
            goto L_0x00db
        L_0x00a8:
            r1 = 2005(0x7d5, float:2.81E-42)
            goto L_0x00db
        L_0x00ab:
            r1 = 2004(0x7d4, float:2.808E-42)
            goto L_0x00db
        L_0x00ae:
            r1 = 2002(0x7d2, float:2.805E-42)
            goto L_0x00db
        L_0x00b1:
            r1 = 2001(0x7d1, float:2.804E-42)
            goto L_0x00db
        L_0x00b4:
            r1 = 3002(0xbba, float:4.207E-42)
            goto L_0x00db
        L_0x00b7:
            r1 = 3005(0xbbd, float:4.211E-42)
            goto L_0x00db
        L_0x00ba:
            r1 = 2106(0x83a, float:2.951E-42)
            goto L_0x00db
        L_0x00bd:
            r1 = 2008(0x7d8, float:2.814E-42)
            goto L_0x00db
        L_0x00c0:
            r1 = -2302(0xfffffffffffff702, float:NaN)
            goto L_0x00db
        L_0x00c3:
            r1 = 3003(0xbbb, float:4.208E-42)
            goto L_0x00db
        L_0x00c6:
            return
        L_0x00c7:
            r1 = 2103(0x837, float:2.947E-42)
            goto L_0x00db
        L_0x00ca:
            r1 = 2101(0x835, float:2.944E-42)
            goto L_0x00db
        L_0x00cd:
            r1 = 2015(0x7df, float:2.824E-42)
            goto L_0x00db
        L_0x00d0:
            r1 = 2012(0x7dc, float:2.82E-42)
            goto L_0x00db
        L_0x00d3:
            r1 = -2304(0xfffffffffffff700, float:NaN)
            goto L_0x00db
        L_0x00d6:
            r1 = -2307(0xfffffffffffff6fd, float:NaN)
            goto L_0x00db
        L_0x00d9:
            r1 = -2301(0xfffffffffffff703, float:NaN)
        L_0x00db:
            com.tencent.rtmp.ui.TXCloudVideoView r4 = r0.f32333a
            if (r4 == 0) goto L_0x00e2
            r4.setLogText(r3, r2, r1)
        L_0x00e2:
            com.tencent.rtmp.ITXLivePlayListener r3 = r0.f32337e
            if (r3 == 0) goto L_0x00e9
            r3.onPlayEvent(r1, r2)
        L_0x00e9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.a.onNotifyEvent(int, android.os.Bundle):void");
    }

    private boolean f() {
        return Build.MANUFACTURER.equalsIgnoreCase("HUAWEI") && Build.MODEL.equalsIgnoreCase("Che2-TL00");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String c(java.lang.String r7, int r8) {
        /*
            r6 = this;
            r0 = 6
            if (r8 == r0) goto L_0x007b
            java.lang.String r8 = "UTF-8"
            byte[] r8 = r7.getBytes(r8)     // Catch:{ Exception -> 0x0077 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0077 }
            int r1 = r8.length     // Catch:{ Exception -> 0x0077 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0077 }
            r1 = 0
            r2 = 0
        L_0x0011:
            int r3 = r8.length     // Catch:{ Exception -> 0x0077 }
            if (r2 >= r3) goto L_0x0072
            byte r3 = r8[r2]     // Catch:{ Exception -> 0x0077 }
            if (r3 >= 0) goto L_0x001d
            byte r3 = r8[r2]     // Catch:{ Exception -> 0x0077 }
            int r3 = r3 + 256
            goto L_0x001f
        L_0x001d:
            byte r3 = r8[r2]     // Catch:{ Exception -> 0x0077 }
        L_0x001f:
            r4 = 32
            if (r3 <= r4) goto L_0x005d
            r4 = 127(0x7f, float:1.78E-43)
            if (r3 >= r4) goto L_0x005d
            r4 = 34
            if (r3 == r4) goto L_0x005d
            r4 = 37
            if (r3 == r4) goto L_0x005d
            r4 = 60
            if (r3 == r4) goto L_0x005d
            r4 = 62
            if (r3 == r4) goto L_0x005d
            r4 = 91
            if (r3 == r4) goto L_0x005d
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L_0x005d
            r4 = 92
            if (r3 == r4) goto L_0x005d
            r4 = 93
            if (r3 == r4) goto L_0x005d
            r4 = 94
            if (r3 == r4) goto L_0x005d
            r4 = 96
            if (r3 == r4) goto L_0x005d
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L_0x005d
            r4 = 124(0x7c, float:1.74E-43)
            if (r3 != r4) goto L_0x0058
            goto L_0x005d
        L_0x0058:
            char r3 = (char) r3     // Catch:{ Exception -> 0x0077 }
            r0.append(r3)     // Catch:{ Exception -> 0x0077 }
            goto L_0x006f
        L_0x005d:
            java.lang.String r4 = "%%%02X"
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0077 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0077 }
            r5[r1] = r3     // Catch:{ Exception -> 0x0077 }
            java.lang.String r3 = java.lang.String.format(r4, r5)     // Catch:{ Exception -> 0x0077 }
            r0.append(r3)     // Catch:{ Exception -> 0x0077 }
        L_0x006f:
            int r2 = r2 + 1
            goto L_0x0011
        L_0x0072:
            java.lang.String r7 = r0.toString()     // Catch:{ Exception -> 0x0077 }
            goto L_0x007b
        L_0x0077:
            r8 = move-exception
            r8.printStackTrace()
        L_0x007b:
            java.lang.String r7 = r7.trim()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.a.c(java.lang.String, int):java.lang.String");
    }

    private void a(final TXLivePlayer.ITXSnapshotListener iTXSnapshotListener, final Bitmap bitmap) {
        if (iTXSnapshotListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    TXLivePlayer.ITXSnapshotListener iTXSnapshotListener = iTXSnapshotListener;
                    if (iTXSnapshotListener != null) {
                        iTXSnapshotListener.onSnapshot(bitmap);
                    }
                    boolean unused = a.this.s = false;
                }
            });
        }
    }
}
