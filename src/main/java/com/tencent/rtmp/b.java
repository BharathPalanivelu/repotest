package com.tencent.rtmp;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaFormat;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.appsflyer.share.Constants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.liteav.audio.TXCAudioUGCRecorder;
import com.tencent.liteav.audio.e;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.c;
import com.tencent.liteav.d;
import com.tencent.liteav.f;
import com.tencent.liteav.n;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.liteav.network.l;
import com.tencent.liteav.qos.TXCQoS;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;
import java.io.File;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.tls.platform.TLSErrInfo;

public class b implements com.tencent.liteav.basic.c.a, c.a, n, com.tencent.liteav.qos.a {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final String f32363b = "b";
    private HashSet<String> A = new HashSet<>();
    private HashMap<Integer, Long> B = new HashMap<>();
    private ArrayList<a> C = new ArrayList<>();
    private e D = new e() {
        public void a() {
            if (b.this.f32364a != null) {
                b.this.f32364a.onBGMStart();
            }
        }

        public void a(int i) {
            if (b.this.f32364a != null) {
                b.this.f32364a.onBGMComplete(i);
            }
        }

        public void a(long j, long j2) {
            if (b.this.f32364a != null) {
                b.this.f32364a.onBGMProgress(j, j2);
            }
        }
    };
    /* access modifiers changed from: private */
    public Runnable E = new Runnable() {
        public void run() {
            boolean unused = b.this.r = false;
        }
    };
    private com.tencent.liteav.muxer.c F = null;
    private boolean G = false;
    private String H = "";
    private long I = 0;
    private boolean J = false;
    /* access modifiers changed from: private */
    public TXRecordCommon.ITXVideoRecordListener K;
    /* access modifiers changed from: private */
    public boolean L = false;

    /* renamed from: a  reason: collision with root package name */
    TXLivePusher.OnBGMNotify f32364a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public TXCloudVideoView f32365c;

    /* renamed from: d  reason: collision with root package name */
    private TXLivePushConfig f32366d = null;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ITXLivePushListener f32367e = null;

    /* renamed from: f  reason: collision with root package name */
    private int f32368f = -1;

    /* renamed from: g  reason: collision with root package name */
    private TXLivePusher.VideoCustomProcessListener f32369g;
    private TXLivePusher.AudioCustomProcessListener h;
    private f i = null;
    private c j = null;
    private TXCStreamUploader k = null;
    private Context l = null;
    /* access modifiers changed from: private */
    public Handler m = null;
    private TXCQoS n = null;
    private d o = null;
    private String p = "";
    private String q = "";
    /* access modifiers changed from: private */
    public boolean r = false;
    private int s = -1;
    private int t = -1;
    private float u = BitmapDescriptorFactory.HUE_RED;
    private TXCEventRecorderProxy v = null;
    private int w = -1;
    private int x = -1;
    private boolean y = false;
    private Vector<String> z = new Vector<>();

    private int b(boolean z2, boolean z3) {
        if (z2) {
            return z3 ? 1 : 0;
        }
        return -1;
    }

    public int e() {
        return 5;
    }

    private class a {

        /* renamed from: a  reason: collision with root package name */
        long f32393a;

        /* renamed from: b  reason: collision with root package name */
        byte[] f32394b;

        private a() {
        }
    }

    public b(Context context) {
        TXCLog.init();
        this.i = new f();
        this.l = context.getApplicationContext();
        this.m = new Handler(Looper.getMainLooper());
        this.j = new c(this.l);
        this.j.a((com.tencent.liteav.basic.c.a) this);
        com.tencent.liteav.basic.b.e.a().a((com.tencent.liteav.basic.b.f) null, this.l);
        TXCTimeUtil.initAppStartTime();
        this.B.put(-1303, 0L);
        this.B.put(1101, 0L);
        this.B.put(1006, 0L);
    }

    public void a(TXLivePushConfig tXLivePushConfig) {
        TXCLog.d(f32363b, "liteav_api setConfig " + tXLivePushConfig + ", " + this);
        if (tXLivePushConfig == null) {
            tXLivePushConfig = new TXLivePushConfig();
        }
        this.f32366d = tXLivePushConfig;
        b(tXLivePushConfig);
        I();
        String str = "setConfig:" + this.i.h + ":" + this.i.f31618a + "*" + this.i.f31619b + ":" + this.i.f31620c + ":" + this.i.f31622e + ":" + this.i.f31621d;
        String str2 = this.p;
        if (str2 == null || str2.length() <= 0) {
            this.z.add(str);
        } else {
            TXCEventRecorderProxy.a(this.p, 91007, -1, -1, str, 0);
        }
    }

    public TXLivePushConfig h() {
        return this.f32366d;
    }

    public void a(ITXLivePushListener iTXLivePushListener) {
        String str = f32363b;
        TXCLog.d(str, "liteav_api setPushListener " + iTXLivePushListener);
        this.f32367e = iTXLivePushListener;
    }

    public void a(TXCloudVideoView tXCloudVideoView) {
        String str = f32363b;
        TXCLog.d(str, "liteav_api startCameraPreview " + tXCloudVideoView + ", " + this);
        String str2 = this.p;
        if (str2 == null || str2.length() <= 0) {
            this.z.add("startPreview");
        } else {
            TXCEventRecorderProxy.a(this.p, 91007, -1, -1, "startPreview", 0);
        }
        a(this.f32366d);
        if (this.i.G) {
            TXCLog.e(f32363b, "enable pure audio push , so can not start preview!");
            return;
        }
        TXCloudVideoView tXCloudVideoView2 = this.f32365c;
        if (!(tXCloudVideoView2 == tXCloudVideoView || tXCloudVideoView2 == null)) {
            tXCloudVideoView2.removeVideoView();
        }
        this.f32365c = tXCloudVideoView;
        if (this.j == null) {
            this.j = new c(this.l);
        }
        this.j.a((com.tencent.liteav.basic.c.a) this);
        this.j.a((c.a) this);
        this.j.a(tXCloudVideoView);
        this.j.b(this.f32366d.mBeautyLevel, this.f32366d.mWhiteningLevel, this.f32366d.mRuddyLevel);
        com.tencent.liteav.basic.b.e.a().a((com.tencent.liteav.basic.b.f) null, this.l);
    }

    public void b(boolean z2) {
        String str = f32363b;
        TXCLog.d(str, "liteav_api stopCameraPreview " + z2 + ", " + this);
        String str2 = this.p;
        if (str2 == null || str2.length() <= 0) {
            this.z.add("stopPreview");
        } else {
            TXCEventRecorderProxy.a(this.p, 91007, -1, -1, "stopPreview", 0);
        }
        c cVar = this.j;
        if (cVar != null) {
            cVar.a(z2);
        }
    }

    public int a(String str) {
        String str2 = f32363b;
        TXCLog.d(str2, "liteav_api startPusher " + this);
        if (!this.y) {
            this.y = com.tencent.liteav.basic.b.e.a().a((com.tencent.liteav.basic.b.f) null, this.l) == 0;
        }
        if (!this.y) {
            return -5;
        }
        if (TextUtils.isEmpty(str)) {
            String str3 = f32363b;
            TXCLog.e(str3, "start push error when url is empty " + this);
            return -1;
        }
        if (!TextUtils.isEmpty(this.p) && l()) {
            if (this.p.equalsIgnoreCase(str)) {
                String str4 = f32363b;
                TXCLog.w(str4, "ignore start push when new url is the same with old url  " + this);
                return -1;
            }
            String str5 = f32363b;
            TXCLog.w(str5, " stop old push when new url is not the same with old url  " + this);
            i();
        }
        TXCLog.d(f32363b, "================================================================================================================================================");
        TXCLog.d(f32363b, "================================================================================================================================================");
        String str6 = f32363b;
        TXCLog.d(str6, "============= startPush pushUrl = " + str + " SDKVersion = " + TXCCommonUtil.getSDKID() + " , " + TXCCommonUtil.getSDKVersionStr() + "=============");
        TXCLog.d(f32363b, "================================================================================================================================================");
        TXCLog.d(f32363b, "================================================================================================================================================");
        this.p = str;
        h(this.p);
        A();
        G();
        C();
        E();
        Iterator<String> it = this.z.iterator();
        while (it.hasNext()) {
            TXCEventRecorderProxy.a(this.p, 91007, -1, -1, it.next(), 0);
        }
        this.z.clear();
        TXCEventRecorderProxy.a(this.p, 91007, -1, -1, "startPush", 0);
        x();
        TXCloudVideoView tXCloudVideoView = this.f32365c;
        if (tXCloudVideoView != null) {
            tXCloudVideoView.clearLog();
        }
        return 0;
    }

    public void i() {
        String str = f32363b;
        TXCLog.d(str, "liteav_api stopPusher " + this);
        String str2 = this.p;
        if (str2 != null && str2.length() > 0) {
            TXCEventRecorderProxy.a(this.p, 91007, -1, -1, "stopPush", 0);
        }
        t();
        y();
        F();
        D();
        H();
        this.i.J = false;
        B();
        this.p = "";
        this.A.clear();
    }

    public void j() {
        String str = f32363b;
        TXCLog.d(str, "liteav_api pausePusher " + this);
        c cVar = this.j;
        if (cVar != null) {
            cVar.j();
        }
        String str2 = this.p;
        if (str2 == null || str2.length() <= 0) {
            this.z.add("pausePusher");
        } else {
            TXCEventRecorderProxy.a(this.p, 91007, -1, -1, "pausePusher", 0);
        }
    }

    public void k() {
        String str = f32363b;
        TXCLog.d(str, "liteav_api resumePusher " + this);
        c cVar = this.j;
        if (cVar != null) {
            cVar.k();
        }
        String str2 = this.p;
        if (str2 == null || str2.length() <= 0) {
            this.z.add("resumePusher");
        } else {
            TXCEventRecorderProxy.a(this.p, 91007, -1, -1, "resumePusher", 0);
        }
    }

    public boolean l() {
        c cVar = this.j;
        if (cVar != null) {
            return cVar.l();
        }
        return false;
    }

    public void a(Surface surface) {
        String str = f32363b;
        TXCLog.d(str, "liteav_api setSurface " + surface);
        c cVar = this.j;
        if (cVar != null) {
            cVar.a(surface);
        }
    }

    public void a(int i2, int i3) {
        String str = f32363b;
        TXCLog.d(str, "liteav_api setSurfaceSize " + i2 + "," + i3);
        c cVar = this.j;
        if (cVar != null) {
            cVar.a(i2, i3);
        }
    }

    public void a(float f2, float f3) {
        c cVar = this.j;
        if (cVar != null) {
            cVar.a(f2, f3);
        }
    }

    public void m() {
        TXCLog.d(f32363b, "liteav_api startScreenCapture ");
        c cVar = this.j;
        if (cVar != null) {
            cVar.n();
        }
    }

    public void n() {
        TXCLog.d(f32363b, "liteav_api stopScreenCapture ");
        c cVar = this.j;
        if (cVar != null) {
            cVar.o();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0100, code lost:
        r14 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0101, code lost:
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0230, code lost:
        r14 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0231, code lost:
        r12.f32368f = r13;
        r12.f32366d.enableVideoHardEncoderMainProfile(!r10);
        r13 = r12.f32366d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x023c, code lost:
        if (r10 == false) goto L_0x023f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x023e, code lost:
        r1 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x023f, code lost:
        r13.setVideoEncodeGop(r1);
        r13 = r12.i;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0244, code lost:
        if (r13 == null) goto L_0x024a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0246, code lost:
        r13.J = r10;
        r13.K = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x024a, code lost:
        a(r12.f32366d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x024f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r13, boolean r14, boolean r15) {
        /*
            r12 = this;
            java.lang.String r0 = f32363b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "liteav_api setVideoQuality "
            r1.append(r2)
            r1.append(r13)
            java.lang.String r2 = ", "
            r1.append(r2)
            r1.append(r14)
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            com.tencent.liteav.basic.log.TXCLog.d(r0, r1)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 3
            r2 = 18
            r3 = 2
            r4 = 1
            if (r0 >= r2) goto L_0x0032
            if (r13 == r3) goto L_0x0031
            if (r13 != r1) goto L_0x0032
        L_0x0031:
            r13 = 1
        L_0x0032:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "setVideoQuality:"
            r0.append(r5)
            r0.append(r13)
            java.lang.String r5 = ":"
            r0.append(r5)
            r0.append(r14)
            r0.append(r5)
            r0.append(r15)
            java.lang.String r10 = r0.toString()
            java.lang.String r0 = r12.p
            if (r0 == 0) goto L_0x0067
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0067
            java.lang.String r6 = r12.p
            r7 = 91007(0x1637f, float:1.27528E-40)
            r8 = -1
            r9 = -1
            r11 = 0
            com.tencent.liteav.basic.module.TXCEventRecorderProxy.a(r6, r7, r8, r9, r10, r11)
            goto L_0x006c
        L_0x0067:
            java.util.Vector<java.lang.String> r0 = r12.z
            r0.add(r10)
        L_0x006c:
            com.tencent.rtmp.TXLivePushConfig r0 = r12.f32366d
            if (r0 != 0) goto L_0x0077
            com.tencent.rtmp.TXLivePushConfig r0 = new com.tencent.rtmp.TXLivePushConfig
            r0.<init>()
            r12.f32366d = r0
        L_0x0077:
            com.tencent.rtmp.TXLivePushConfig r0 = r12.f32366d
            r0.setVideoFPS(r2)
            r0 = 1200(0x4b0, float:1.682E-42)
            r5 = 301(0x12d, float:4.22E-43)
            r6 = 1800(0x708, float:2.522E-42)
            r7 = 600(0x258, float:8.41E-43)
            r8 = 800(0x320, float:1.121E-42)
            r9 = 48000(0xbb80, float:6.7262E-41)
            r10 = 0
            switch(r13) {
                case 1: goto L_0x020a;
                case 2: goto L_0x01e1;
                case 3: goto L_0x01ba;
                case 4: goto L_0x0104;
                case 5: goto L_0x00df;
                case 6: goto L_0x00a9;
                default: goto L_0x008d;
            }
        L_0x008d:
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setHardwareAcceleration(r3)
            java.lang.String r14 = f32363b
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r0 = "setVideoPushQuality: invalid quality "
            r15.append(r0)
            r15.append(r13)
            java.lang.String r13 = r15.toString()
            com.tencent.liteav.basic.log.TXCLog.e(r14, r13)
            return
        L_0x00a9:
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.enableAEC(r4)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setHardwareAcceleration(r4)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setVideoResolution(r10)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setAudioSampleRate(r9)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setAutoAdjustBitrate(r4)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r15 = 5
            r14.setAutoAdjustStrategy(r15)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r15 = 190(0xbe, float:2.66E-43)
            r14.setMinVideoBitrate(r15)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r15 = 400(0x190, float:5.6E-43)
            r14.setVideoBitrate(r15)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r15 = 810(0x32a, float:1.135E-42)
            r14.setMaxVideoBitrate(r15)
            r14 = 1
            goto L_0x0101
        L_0x00df:
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.enableAEC(r4)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setHardwareAcceleration(r4)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r15 = 6
            r14.setVideoResolution(r15)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setAutoAdjustBitrate(r10)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r15 = 350(0x15e, float:4.9E-43)
            r14.setVideoBitrate(r15)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setAudioSampleRate(r9)
        L_0x0100:
            r14 = 0
        L_0x0101:
            r10 = 1
            goto L_0x0231
        L_0x0104:
            int r14 = android.os.Build.VERSION.SDK_INT
            r15 = 4
            if (r14 >= r2) goto L_0x0133
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.enableAEC(r4)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setHardwareAcceleration(r10)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setVideoResolution(r10)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setAutoAdjustBitrate(r4)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setAutoAdjustStrategy(r15)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setMinVideoBitrate(r5)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setVideoBitrate(r8)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setMaxVideoBitrate(r8)
            goto L_0x01b3
        L_0x0133:
            int r14 = r12.f32368f
            if (r14 != r4) goto L_0x0160
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.enableAEC(r4)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setHardwareAcceleration(r4)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setVideoResolution(r10)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setAutoAdjustBitrate(r4)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setAutoAdjustStrategy(r15)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setMinVideoBitrate(r5)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setVideoBitrate(r8)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setMaxVideoBitrate(r8)
            goto L_0x01b3
        L_0x0160:
            if (r14 != r1) goto L_0x018b
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.enableAEC(r4)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setHardwareAcceleration(r4)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setVideoResolution(r3)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setAutoAdjustBitrate(r4)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setAutoAdjustStrategy(r15)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setMinVideoBitrate(r7)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setVideoBitrate(r6)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setMaxVideoBitrate(r6)
            goto L_0x01b3
        L_0x018b:
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.enableAEC(r4)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setHardwareAcceleration(r4)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setVideoResolution(r4)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setAutoAdjustBitrate(r4)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setAutoAdjustStrategy(r15)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setMinVideoBitrate(r7)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setVideoBitrate(r0)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setMaxVideoBitrate(r0)
        L_0x01b3:
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setAudioSampleRate(r9)
            goto L_0x0100
        L_0x01ba:
            com.tencent.rtmp.TXLivePushConfig r0 = r12.f32366d
            r0.enableAEC(r10)
            com.tencent.rtmp.TXLivePushConfig r0 = r12.f32366d
            r0.setHardwareAcceleration(r4)
            com.tencent.rtmp.TXLivePushConfig r0 = r12.f32366d
            r0.setVideoResolution(r3)
            com.tencent.rtmp.TXLivePushConfig r0 = r12.f32366d
            r0.setAudioSampleRate(r9)
            r12.a((boolean) r14, (boolean) r15)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setMinVideoBitrate(r7)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setVideoBitrate(r6)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setMaxVideoBitrate(r6)
            goto L_0x0230
        L_0x01e1:
            com.tencent.rtmp.TXLivePushConfig r2 = r12.f32366d
            r2.enableAEC(r10)
            com.tencent.rtmp.TXLivePushConfig r2 = r12.f32366d
            r2.setHardwareAcceleration(r3)
            com.tencent.rtmp.TXLivePushConfig r2 = r12.f32366d
            r2.setVideoResolution(r4)
            com.tencent.rtmp.TXLivePushConfig r2 = r12.f32366d
            r2.setAudioSampleRate(r9)
            r12.a((boolean) r14, (boolean) r15)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setMinVideoBitrate(r7)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setVideoBitrate(r0)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r15 = 1500(0x5dc, float:2.102E-42)
            r14.setMaxVideoBitrate(r15)
            goto L_0x0230
        L_0x020a:
            com.tencent.rtmp.TXLivePushConfig r0 = r12.f32366d
            r0.enableAEC(r10)
            com.tencent.rtmp.TXLivePushConfig r0 = r12.f32366d
            r0.setHardwareAcceleration(r3)
            com.tencent.rtmp.TXLivePushConfig r0 = r12.f32366d
            r0.setVideoResolution(r10)
            com.tencent.rtmp.TXLivePushConfig r0 = r12.f32366d
            r0.setAudioSampleRate(r9)
            r12.a((boolean) r14, (boolean) r15)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setMinVideoBitrate(r5)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setVideoBitrate(r8)
            com.tencent.rtmp.TXLivePushConfig r14 = r12.f32366d
            r14.setMaxVideoBitrate(r8)
        L_0x0230:
            r14 = 0
        L_0x0231:
            r12.f32368f = r13
            com.tencent.rtmp.TXLivePushConfig r13 = r12.f32366d
            r15 = r10 ^ 1
            r13.enableVideoHardEncoderMainProfile(r15)
            com.tencent.rtmp.TXLivePushConfig r13 = r12.f32366d
            if (r10 == 0) goto L_0x023f
            r1 = 1
        L_0x023f:
            r13.setVideoEncodeGop(r1)
            com.tencent.liteav.f r13 = r12.i
            if (r13 == 0) goto L_0x024a
            r13.J = r10
            r13.K = r14
        L_0x024a:
            com.tencent.rtmp.TXLivePushConfig r13 = r12.f32366d
            r12.a((com.tencent.rtmp.TXLivePushConfig) r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.b.a(int, boolean, boolean):void");
    }

    public void o() {
        TXCLog.d(f32363b, "liteav_api switchCamera ");
        c cVar = this.j;
        if (cVar != null) {
            cVar.m();
        }
    }

    public boolean c(boolean z2) {
        String str = f32363b;
        TXCLog.d(str, "liteav_api setMirror " + z2);
        TXLivePushConfig tXLivePushConfig = this.f32366d;
        if (tXLivePushConfig != null) {
            tXLivePushConfig.setVideoEncoderXMirror(z2);
        }
        c cVar = this.j;
        if (cVar == null) {
            return false;
        }
        cVar.e(z2);
        return true;
    }

    public void a(int i2) {
        TXCLog.d(f32363b, "liteav_api setRenderRotation ");
        c cVar = this.j;
        if (cVar != null) {
            cVar.a(i2);
        }
    }

    public boolean d(boolean z2) {
        String str = f32363b;
        TXCLog.d(str, "liteav_api turnOnFlashLight " + z2);
        c cVar = this.j;
        if (cVar == null) {
            return false;
        }
        return cVar.b(z2);
    }

    public int p() {
        c cVar = this.j;
        if (cVar == null) {
            return 0;
        }
        return cVar.q();
    }

    public boolean b(int i2) {
        String str = f32363b;
        TXCLog.d(str, "liteav_api setZoom " + i2);
        c cVar = this.j;
        if (cVar == null) {
            return false;
        }
        return cVar.i(i2);
    }

    public void a(float f2) {
        String str = f32363b;
        TXCLog.d(str, "liteav_api setExposureCompensation " + f2);
        c cVar = this.j;
        if (cVar != null) {
            cVar.c(f2);
        }
    }

    public boolean a(int i2, int i3, int i4, int i5) {
        String str = f32363b;
        TXCLog.d(str, "liteav_api setBeautyFilter " + i2 + ", " + i3 + ", " + i4 + ", " + i5);
        c cVar = this.j;
        if (cVar != null) {
            cVar.b(i2);
            this.j.b(i3, i4, i5);
        }
        TXLivePushConfig tXLivePushConfig = this.f32366d;
        if (tXLivePushConfig == null) {
            return true;
        }
        tXLivePushConfig.mBeautyLevel = i3;
        tXLivePushConfig.mWhiteningLevel = i4;
        tXLivePushConfig.mRuddyLevel = i5;
        return true;
    }

    public void a(Bitmap bitmap) {
        String str = f32363b;
        TXCLog.d(str, "liteav_api setFilter " + bitmap);
        c cVar = this.j;
        if (cVar != null) {
            cVar.a(bitmap);
        }
    }

    public void b(float f2) {
        String str = f32363b;
        TXCLog.d(str, "liteav_api setSpecialRatio " + f2);
        com.tencent.liteav.basic.b.e.a().a((com.tencent.liteav.basic.b.f) null, this.l);
        c cVar = this.j;
        if (cVar != null) {
            cVar.a(f2);
        }
    }

    public void c(int i2) {
        String str = f32363b;
        TXCLog.d(str, "liteav_api setEyeScaleLevel " + i2);
        com.tencent.liteav.basic.b.e.a().a((com.tencent.liteav.basic.b.f) null, this.l);
        TXLivePushConfig tXLivePushConfig = this.f32366d;
        if (tXLivePushConfig != null) {
            tXLivePushConfig.setEyeScaleLevel(i2);
        }
        c cVar = this.j;
        if (cVar != null) {
            cVar.c(i2);
        }
    }

    public void d(int i2) {
        String str = f32363b;
        TXCLog.d(str, "liteav_api setFaceSlimLevel " + i2);
        com.tencent.liteav.basic.b.e.a().a((com.tencent.liteav.basic.b.f) null, this.l);
        TXLivePushConfig tXLivePushConfig = this.f32366d;
        if (tXLivePushConfig != null) {
            tXLivePushConfig.setFaceSlimLevel(i2);
        }
        c cVar = this.j;
        if (cVar != null) {
            cVar.d(i2);
        }
    }

    public void e(int i2) {
        String str = f32363b;
        TXCLog.d(str, "liteav_api setFaceVLevel " + i2);
        com.tencent.liteav.basic.b.e.a().a((com.tencent.liteav.basic.b.f) null, this.l);
        c cVar = this.j;
        if (cVar != null) {
            cVar.e(i2);
        }
    }

    public void f(int i2) {
        String str = f32363b;
        TXCLog.d(str, "liteav_api setChinLevel " + i2);
        com.tencent.liteav.basic.b.e.a().a((com.tencent.liteav.basic.b.f) null, this.l);
        c cVar = this.j;
        if (cVar != null) {
            cVar.g(i2);
        }
    }

    public void g(int i2) {
        String str = f32363b;
        TXCLog.d(str, "liteav_api setFaceShortLevel " + i2);
        com.tencent.liteav.basic.b.e.a().a((com.tencent.liteav.basic.b.f) null, this.l);
        c cVar = this.j;
        if (cVar != null) {
            cVar.f(i2);
        }
    }

    public void h(int i2) {
        String str = f32363b;
        TXCLog.d(str, "liteav_api setNoseSlimLevel " + i2);
        com.tencent.liteav.basic.b.e.a().a((com.tencent.liteav.basic.b.f) null, this.l);
        c cVar = this.j;
        if (cVar != null) {
            cVar.h(i2);
        }
    }

    @TargetApi(18)
    public boolean b(String str) {
        String str2 = f32363b;
        TXCLog.d(str2, "liteav_api setGreenScreenFile " + str);
        com.tencent.liteav.basic.b.e.a().a((com.tencent.liteav.basic.b.f) null, this.l);
        c cVar = this.j;
        if (cVar != null) {
            return cVar.b(str);
        }
        return false;
    }

    public void c(String str) {
        String str2 = f32363b;
        TXCLog.d(str2, "liteav_api motionPath " + str);
        com.tencent.liteav.basic.b.e.a().a((com.tencent.liteav.basic.b.f) null, this.l);
        c cVar = this.j;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    public void e(boolean z2) {
        String str = f32363b;
        TXCLog.d(str, "liteav_api setMotionMute " + z2);
        com.tencent.liteav.basic.b.e.a().a((com.tencent.liteav.basic.b.f) null, this.l);
        c cVar = this.j;
        if (cVar != null) {
            cVar.c(z2);
        }
    }

    public void f(boolean z2) {
        String str = f32363b;
        TXCLog.d(str, "liteav_api setMute " + z2);
        String str2 = this.p;
        if (str2 == null || str2.length() <= 0) {
            Vector<String> vector = this.z;
            vector.add("setMute:" + z2);
        } else {
            String str3 = this.p;
            TXCEventRecorderProxy.a(str3, 91007, -1, -1, "setMute:" + z2, 0);
        }
        c cVar = this.j;
        if (cVar != null) {
            cVar.d(z2);
        }
        if (this.f32366d.mEnablePureAudioPush) {
            TXCStreamUploader tXCStreamUploader = this.k;
            if (tXCStreamUploader != null) {
                tXCStreamUploader.setAudioMute(z2);
            }
        }
    }

    public void a(TXLivePusher.OnBGMNotify onBGMNotify) {
        String str = f32363b;
        TXCLog.d(str, "liteav_api setBGMNofify " + onBGMNotify);
        this.f32364a = onBGMNotify;
        if (this.f32364a != null) {
            this.j.a(this.D);
        } else {
            this.j.a((e) null);
        }
    }

    public boolean d(String str) {
        String str2 = f32363b;
        TXCLog.d(str2, "liteav_api playBGM " + str);
        return this.j.c(str);
    }

    public boolean q() {
        TXCLog.d(f32363b, "liteav_api stopBGM ");
        return this.j.r();
    }

    public boolean r() {
        TXCLog.d(f32363b, "liteav_api pauseBGM ");
        return this.j.s();
    }

    public boolean s() {
        TXCLog.d(f32363b, "liteav_api resumeBGM ");
        return this.j.t();
    }

    public int e(String str) {
        return this.j.d(str);
    }

    public boolean c(float f2) {
        String str = f32363b;
        TXCLog.d(str, "liteav_api setBGMVolume " + f2);
        return this.j.e(f2);
    }

    public boolean d(float f2) {
        String str = f32363b;
        TXCLog.d(str, "liteav_api setMicVolume " + f2);
        return this.j.d(f2);
    }

    public void e(float f2) {
        this.u = f2;
        c cVar = this.j;
        if (cVar != null) {
            cVar.b(f2);
        }
    }

    public void i(int i2) {
        String str = f32363b;
        TXCLog.d(str, "liteav_api setReverb " + i2);
        c cVar = this.j;
        if (cVar != null) {
            cVar.j(i2);
        }
    }

    public void j(int i2) {
        switch (i2) {
            case 1:
                this.s = 6;
                this.t = -1;
                break;
            case 2:
                this.s = 4;
                this.t = -1;
                break;
            case 3:
                this.s = 5;
                this.t = -1;
                break;
            case 4:
                this.s = -1;
                this.t = 9;
                break;
            case 5:
                this.s = 536936433;
                this.t = 50;
                break;
            case 6:
                this.s = -1;
                this.t = 5;
                break;
            case 7:
                this.s = 13;
                this.t = 1;
                break;
            case 8:
                this.s = 13;
                this.t = -1;
                break;
            case 9:
                this.s = 10;
                this.t = 4;
                break;
            case 10:
                this.s = 10;
                this.t = 20;
                break;
            case 11:
                this.s = -1;
                this.t = 2;
                break;
            default:
                this.s = -1;
                this.t = -1;
                break;
        }
        c cVar = this.j;
        if (cVar != null) {
            cVar.b(this.s, this.t);
        }
    }

    public void a(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        String str = f32363b;
        TXCLog.d(str, "liteav_api setVideoRecordListener " + iTXVideoRecordListener);
        this.K = iTXVideoRecordListener;
    }

    public int f(String str) {
        String str2 = f32363b;
        TXCLog.d(str2, "liteav_api startRecord " + str);
        if (Build.VERSION.SDK_INT < 18) {
            String str3 = f32363b;
            TXCLog.e(str3, "API levl is too low (record need 18, current is" + Build.VERSION.SDK_INT + SQLBuilder.PARENTHESES_RIGHT);
            return -3;
        } else if (this.J) {
            TXCLog.w(f32363b, "ignore start record when recording");
            return -1;
        } else {
            c cVar = this.j;
            if (cVar == null || !cVar.l()) {
                TXCLog.w(f32363b, "ignore start record when not pushing");
                return -2;
            }
            TXCLog.w(f32363b, "start record ");
            this.J = true;
            this.H = str;
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            this.F = new com.tencent.liteav.muxer.c(this.l, 1);
            this.G = false;
            this.F.a(this.H);
            w();
            TXCDRApi.txReportDAU(this.l.getApplicationContext(), com.tencent.liteav.basic.datareport.a.aH);
            c cVar2 = this.j;
            if (cVar2 != null) {
                cVar2.v();
            }
            return 0;
        }
    }

    public void t() {
        TXCLog.d(f32363b, "liteav_api stopRecord ");
        if (this.J) {
            com.tencent.liteav.muxer.c cVar = this.F;
            if (cVar != null) {
                int b2 = cVar.b();
                TXCLog.w(f32363b, "start record ");
                this.J = false;
                if (b2 == 0) {
                    final String str = this.H;
                    AsyncTask.execute(new Runnable() {
                        public void run() {
                            File parentFile = new File(str).getParentFile();
                            String format = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date(System.currentTimeMillis()));
                            String str = parentFile + File.separator + String.format("TXUGCCover_%s.jpg", new Object[]{format});
                            com.tencent.liteav.basic.util.b.a(str, str);
                            b.this.a(str, str);
                        }
                    });
                    return;
                }
                v();
            }
        }
    }

    public void a(final TXLivePusher.ITXSnapshotListener iTXSnapshotListener) {
        String str = f32363b;
        TXCLog.d(str, "liteav_api snapshot " + iTXSnapshotListener);
        if (!this.r && iTXSnapshotListener != null) {
            c cVar = this.j;
            if (cVar != null) {
                if (cVar != null) {
                    this.r = true;
                    cVar.a((com.tencent.liteav.basic.d.n) new com.tencent.liteav.basic.d.n() {
                        public void a(Bitmap bitmap) {
                            b.this.a(iTXSnapshotListener, bitmap);
                            boolean unused = b.this.r = false;
                            b.this.m.removeCallbacks(b.this.E);
                        }
                    });
                    this.m.postDelayed(this.E, 2000);
                    return;
                }
                this.r = false;
            }
        }
    }

    public int c(int i2, int i3, int i4) {
        c cVar = this.j;
        return cVar != null ? cVar.c(i2, i3, i4) : TLSErrInfo.TIMEOUT;
    }

    public int a(byte[] bArr, int i2, int i3, int i4) {
        int i5;
        if (this.j == null) {
            return TLSErrInfo.TIMEOUT;
        }
        if (i2 == 3) {
            i5 = 1;
        } else if (i2 != 5) {
            return TLSErrInfo.TIMEOUT;
        } else {
            i5 = 2;
        }
        return this.j.a(bArr, i5, i3, i4, 0);
    }

    public void a(byte[] bArr) {
        this.j.a(bArr);
    }

    public void a(TXLivePusher.VideoCustomProcessListener videoCustomProcessListener) {
        String str = f32363b;
        TXCLog.d(str, "liteav_api setVideoProcessListener " + videoCustomProcessListener);
        this.f32369g = videoCustomProcessListener;
        if (this.f32369g == null) {
            c cVar = this.j;
            if (cVar != null) {
                cVar.a((n) null);
                return;
            }
            return;
        }
        c cVar2 = this.j;
        if (cVar2 != null) {
            cVar2.a((n) this);
        }
    }

    public void a(TXLivePusher.AudioCustomProcessListener audioCustomProcessListener) {
        String str = f32363b;
        TXCLog.d(str, "liteav_api setAudioProcessListener " + audioCustomProcessListener);
        this.h = audioCustomProcessListener;
    }

    public boolean b(byte[] bArr) {
        if (bArr.length <= 0 || bArr.length > 2048) {
            return false;
        }
        synchronized (this) {
            if (this.C != null) {
                a aVar = new a();
                aVar.f32393a = TXCTimeUtil.getTimeTick();
                aVar.f32394b = a(bArr.length, e(bArr));
                this.C.add(aVar);
            }
        }
        return true;
    }

    @Deprecated
    public void c(byte[] bArr) {
        synchronized (this) {
            if (this.C != null) {
                a aVar = new a();
                aVar.f32393a = TXCTimeUtil.getTimeTick();
                aVar.f32394b = e(bArr);
                this.C.add(aVar);
            }
        }
    }

    public void g(String str) {
        TXCLog.d("User", str);
    }

    public void onNotifyEvent(final int i2, final Bundle bundle) {
        Handler handler = this.m;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    if (b.this.f32365c != null) {
                        b.this.f32365c.setLogText((Bundle) null, bundle, i2);
                    }
                }
            });
        }
        a(i2, bundle);
        String str = this.p;
        if (str != null && str.length() > 0) {
            if (i2 == 1018 || i2 == 1019 || i2 == 1021 || i2 == 1020) {
                switch (i2) {
                    case 1018:
                        TXCEventRecorderProxy.a(str, 91009, -1, -1, "enter", 0);
                        return;
                    case 1019:
                        TXCEventRecorderProxy.a(str, 91009, -1, -1, "exit", 0);
                        return;
                    case 1020:
                        try {
                            JSONArray jSONArray = new JSONObject(bundle.getString(TXLiveConstants.EVT_DESCRIPTION)).getJSONArray("userlist");
                            HashSet hashSet = new HashSet();
                            StringBuilder sb = new StringBuilder();
                            boolean z2 = true;
                            if ((jSONArray != null && jSONArray.length() != 0) || this.A.size() <= 0) {
                                if (jSONArray != null) {
                                    boolean z3 = false;
                                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                        String string = jSONArray.getJSONObject(i3).getString("userid");
                                        hashSet.add(string);
                                        if (i3 == 0) {
                                            sb.append(string);
                                        } else {
                                            sb.append(":" + string);
                                        }
                                        if (this.A == null || this.A.size() <= 0 || !this.A.contains(string)) {
                                            z3 = true;
                                        }
                                    }
                                    if (this.A == null || jSONArray.length() == this.A.size()) {
                                        z2 = z3;
                                    }
                                } else {
                                    z2 = false;
                                }
                            }
                            if (!z2) {
                                return;
                            }
                            if (hashSet.size() == 0) {
                                this.A.clear();
                                TXCEventRecorderProxy.a(str, 91009, -1, -1, "userlist:", 0);
                                return;
                            }
                            this.A.clear();
                            this.A.addAll(hashSet);
                            TXCEventRecorderProxy.a(str, 91009, -1, -1, "userlist:" + sb.toString(), 0);
                            return;
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            return;
                        }
                    case 1021:
                        TXCEventRecorderProxy.a(str, 91009, -1, -1, "reenter", 0);
                        return;
                    default:
                        return;
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                if (i2 == -1303 || i2 == 1101 || i2 == 1006) {
                    if (currentTimeMillis - this.B.get(Integer.valueOf(i2)).longValue() >= 5000) {
                        this.B.put(Integer.valueOf(i2), Long.valueOf(currentTimeMillis));
                    } else {
                        return;
                    }
                }
                if (i2 != 1018 && i2 != 1019 && i2 != 1021 && i2 != 1020) {
                    TXCEventRecorderProxy.a(str, 91008, -1, -1, bundle != null ? bundle.getString(TXLiveConstants.EVT_DESCRIPTION) : "", 0);
                }
            }
        }
    }

    public int a(int i2, int i3, int i4) {
        TXLivePusher.VideoCustomProcessListener videoCustomProcessListener = this.f32369g;
        if (videoCustomProcessListener != null) {
            return videoCustomProcessListener.onTextureCustomProcess(i2, i3, i4);
        }
        return 0;
    }

    public void a() {
        TXLivePusher.VideoCustomProcessListener videoCustomProcessListener = this.f32369g;
        if (videoCustomProcessListener != null) {
            videoCustomProcessListener.onTextureDestoryed();
        }
    }

    public int b() {
        return TXCStatus.c(this.q, 4002);
    }

    public int c() {
        int i2;
        int c2 = TXCStatus.c(this.q, 7002);
        if (this.i.J) {
            i2 = TXCStatus.c(this.q, 7001);
        } else {
            i2 = TXCStatus.c(this.q, 4002);
        }
        return c2 + i2;
    }

    public int d() {
        if (this.k == null) {
            return 0;
        }
        return TXCStatus.c(this.q, 7004) + TXCStatus.c(this.q, 7003);
    }

    public int f() {
        return TXCStatus.c(this.q, 7005);
    }

    public int g() {
        return TXCStatus.c(this.q, 7007);
    }

    public void b(int i2, int i3, int i4) {
        c cVar = this.j;
        if (cVar != null) {
            cVar.a(i2, i3, i4);
        }
        if (!(i3 == 0 || i4 == 0)) {
            f fVar = this.i;
            fVar.f31618a = i3;
            fVar.f31619b = i4;
        }
        if (i2 != 0) {
            this.i.f31620c = i2;
            String str = this.p;
            TXCEventRecorderProxy.a(str, 91006, -1, -1, "Qos Change(mode:" + this.i.f31623f + " bitrate:" + i2 + " videosize:" + this.i.f31618a + " * " + this.i.f31619b + SQLBuilder.PARENTHESES_RIGHT, 0);
        }
    }

    public void a(boolean z2) {
        TXCStreamUploader tXCStreamUploader = this.k;
        if (tXCStreamUploader != null) {
            tXCStreamUploader.setDropEanble(z2);
        }
    }

    public void a(byte[] bArr, long j2, int i2, int i3) {
        TXCStreamUploader tXCStreamUploader = this.k;
        if (!(tXCStreamUploader == null || bArr == null)) {
            tXCStreamUploader.pushAAC(bArr, j2);
        }
        if (this.J) {
            com.tencent.liteav.muxer.c cVar = this.F;
            if (cVar != null && this.G && bArr != null) {
                cVar.a(bArr, 0, bArr.length, j2 * 1000, 0);
            }
        }
    }

    public void a(TXSNALPacket tXSNALPacket) {
        TXCQoS tXCQoS = this.n;
        if (tXCQoS != null) {
            tXCQoS.setHasVideo(true);
        }
        if (!(this.k == null || tXSNALPacket == null || tXSNALPacket.nalData == null)) {
            synchronized (this) {
                if (this.C != null && !this.C.isEmpty()) {
                    Iterator<a> it = this.C.iterator();
                    int i2 = 0;
                    while (true) {
                        int i3 = 10240;
                        if (!it.hasNext()) {
                            break;
                        }
                        a next = it.next();
                        if (next.f32393a > tXSNALPacket.pts) {
                            break;
                        }
                        if (next.f32394b.length <= 10240) {
                            i3 = next.f32394b.length;
                        }
                        i2 += i3 + 5;
                    }
                    if (i2 != 0) {
                        byte[] bArr = new byte[(i2 + tXSNALPacket.nalData.length)];
                        byte[] bArr2 = new byte[5];
                        Iterator<a> it2 = this.C.iterator();
                        int i4 = 0;
                        int i5 = 0;
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            a next2 = it2.next();
                            if (next2.f32393a > tXSNALPacket.pts) {
                                break;
                            }
                            i4++;
                            int length = next2.f32394b.length <= 10240 ? next2.f32394b.length : 10240;
                            int i6 = length + 1;
                            bArr2[0] = (byte) ((i6 >> 24) & 255);
                            bArr2[1] = (byte) ((i6 >> 16) & 255);
                            bArr2[2] = (byte) ((i6 >> 8) & 255);
                            bArr2[3] = (byte) (i6 & 255);
                            bArr2[4] = 6;
                            System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
                            int length2 = i5 + bArr2.length;
                            System.arraycopy(next2.f32394b, 0, bArr, length2, length);
                            i5 = length2 + length;
                        }
                        long j2 = tXSNALPacket.pts;
                        for (int i7 = 0; i7 < i4; i7++) {
                            this.C.remove(0);
                        }
                        System.arraycopy(tXSNALPacket.nalData, 0, bArr, i5, tXSNALPacket.nalData.length);
                        tXSNALPacket.nalData = bArr;
                    }
                }
            }
            this.k.pushNAL(tXSNALPacket);
        }
        if (this.J && this.F != null && tXSNALPacket != null && tXSNALPacket.nalData != null) {
            byte[] d2 = d(tXSNALPacket.nalData);
            if (this.G) {
                a(tXSNALPacket, d2);
            } else if (tXSNALPacket.nalType == 0) {
                MediaFormat a2 = com.tencent.liteav.basic.util.b.a(d2, this.j.b(), this.j.c());
                if (a2 != null) {
                    this.F.a(a2);
                    this.F.a();
                    this.G = true;
                    this.I = 0;
                }
                a(tXSNALPacket, d2);
            }
        }
    }

    public void a(byte[] bArr, long j2, int i2, int i3, int i4, boolean z2) {
        TXLivePusher.AudioCustomProcessListener audioCustomProcessListener = this.h;
        if (audioCustomProcessListener != null) {
            audioCustomProcessListener.onRecordRawPcmData(bArr, j2, i2, i3, i4, z2);
        }
    }

    public void a(byte[] bArr, long j2, int i2, int i3, int i4) {
        TXLivePusher.AudioCustomProcessListener audioCustomProcessListener = this.h;
        if (audioCustomProcessListener != null) {
            audioCustomProcessListener.onRecordPcmData(bArr, j2, i2, i3, i4);
        }
    }

    public void a(MediaFormat mediaFormat) {
        if (this.J) {
            com.tencent.liteav.muxer.c cVar = this.F;
            if (cVar != null) {
                cVar.a(mediaFormat);
                if (!this.G) {
                    this.F.a();
                    this.G = true;
                    this.I = 0;
                }
            }
        }
    }

    private void v() {
        this.m.post(new Runnable() {
            public void run() {
                TXRecordCommon.TXRecordResult tXRecordResult = new TXRecordCommon.TXRecordResult();
                tXRecordResult.retCode = -1;
                tXRecordResult.descMsg = "record video failed";
                if (b.this.K != null) {
                    b.this.K.onRecordComplete(tXRecordResult);
                }
                TXCLog.w(b.f32363b, "record complete fail");
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(final String str, final String str2) {
        this.m.post(new Runnable() {
            public void run() {
                TXRecordCommon.TXRecordResult tXRecordResult = new TXRecordCommon.TXRecordResult();
                tXRecordResult.retCode = 0;
                tXRecordResult.descMsg = "record success";
                tXRecordResult.videoPath = str;
                tXRecordResult.coverPath = str2;
                if (b.this.K != null) {
                    b.this.K.onRecordComplete(tXRecordResult);
                }
                TXCLog.w(b.f32363b, "record complete success");
            }
        });
    }

    @TargetApi(16)
    private void w() {
        MediaFormat a2 = com.tencent.liteav.basic.util.b.a(TXCAudioUGCRecorder.getInstance().getSampleRate(), TXCAudioUGCRecorder.getInstance().getChannels(), 2);
        com.tencent.liteav.muxer.c cVar = this.F;
        if (cVar != null) {
            cVar.b(a2);
        }
    }

    private void a(TXSNALPacket tXSNALPacket, byte[] bArr) {
        int i2;
        if (this.I == 0) {
            this.I = tXSNALPacket.pts;
        }
        final long j2 = tXSNALPacket.pts - this.I;
        if (tXSNALPacket.info == null) {
            i2 = tXSNALPacket.nalType == 0 ? 1 : 0;
        } else {
            i2 = tXSNALPacket.info.flags;
        }
        this.F.b(bArr, 0, bArr.length, tXSNALPacket.pts * 1000, i2);
        this.m.post(new Runnable() {
            public void run() {
                if (b.this.K != null) {
                    b.this.K.onRecordProgress(j2);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(final TXLivePusher.ITXSnapshotListener iTXSnapshotListener, final Bitmap bitmap) {
        if (iTXSnapshotListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    TXLivePusher.ITXSnapshotListener iTXSnapshotListener = iTXSnapshotListener;
                    if (iTXSnapshotListener != null) {
                        iTXSnapshotListener.onSnapshot(bitmap);
                    }
                }
            });
        }
    }

    private void a(boolean z2, boolean z3) {
        int b2 = b(z2, z3);
        if (b2 == -1) {
            this.f32366d.setAutoAdjustBitrate(false);
            this.f32366d.setAutoAdjustStrategy(-1);
            return;
        }
        this.f32366d.setAutoAdjustBitrate(true);
        this.f32366d.setAutoAdjustStrategy(b2);
    }

    private void h(String str) {
        TXCStreamUploader tXCStreamUploader = this.k;
        if (tXCStreamUploader != null) {
            tXCStreamUploader.setID(str);
        }
        c cVar = this.j;
        if (cVar != null) {
            cVar.setID(str);
        }
        d dVar = this.o;
        if (dVar != null) {
            dVar.d(str);
        }
        if (this.v == null) {
            this.v = new TXCEventRecorderProxy();
        }
        this.v.a(str, com.tencent.liteav.basic.util.b.e(this.l));
        this.v.a("18446744073709551615", com.tencent.liteav.basic.util.b.e(this.l));
        this.q = str;
    }

    private void x() {
        this.L = true;
        Handler handler = this.m;
        if (handler != null) {
            handler.postDelayed(new Runnable() {
                public void run() {
                    if (b.this.L) {
                        b.this.z();
                    }
                }
            }, 2000);
        }
    }

    private void y() {
        this.L = false;
    }

    /* access modifiers changed from: private */
    public void z() {
        int[] a2 = com.tencent.liteav.basic.util.b.a();
        String str = (a2[0] / 10) + Constants.URL_PATH_DELIMITER + (a2[1] / 10) + "%";
        int c2 = TXCStatus.c(this.q, 7004);
        int c3 = TXCStatus.c(this.q, 7003);
        int c4 = TXCStatus.c(this.q, 7002);
        int c5 = TXCStatus.c(this.q, 7001);
        int c6 = TXCStatus.c(this.q, 7007);
        int c7 = TXCStatus.c(this.q, 7005);
        int c8 = TXCStatus.c(this.q, 7006);
        String b2 = TXCStatus.b(this.q, 7012);
        double d2 = TXCStatus.d(this.q, 4001);
        int c9 = TXCStatus.c(this.q, 4006);
        Bundle bundle = new Bundle();
        bundle.putInt(TXLiveConstants.NET_STATUS_NET_SPEED, c3 + c2);
        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_FPS, (int) d2);
        if (d2 < 1.0d) {
            d2 = 15.0d;
        }
        double d3 = (double) (((float) ((c9 * 10) / ((int) d2))) / 10.0f);
        Double.isNaN(d3);
        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_GOP, (int) (d3 + 0.5d));
        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_DROP, c6);
        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE, c5);
        bundle.putInt(TXLiveConstants.NET_STATUS_AUDIO_BITRATE, c4);
        bundle.putInt(TXLiveConstants.NET_STATUS_AUDIO_CACHE, c8);
        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_CACHE, c7);
        bundle.putCharSequence(TXLiveConstants.NET_STATUS_SERVER_IP, b2);
        bundle.putCharSequence(TXLiveConstants.NET_STATUS_CPU_USAGE, str);
        c cVar = this.j;
        if (cVar != null) {
            bundle.putString(TXLiveConstants.NET_STATUS_AUDIO_INFO, cVar.d());
            bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_WIDTH, this.j.b());
            bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_HEIGHT, this.j.c());
        }
        TXCloudVideoView tXCloudVideoView = this.f32365c;
        if (tXCloudVideoView != null) {
            tXCloudVideoView.setLogText(bundle, (Bundle) null, 0);
        }
        ITXLivePushListener iTXLivePushListener = this.f32367e;
        if (iTXLivePushListener != null) {
            iTXLivePushListener.onNetStatus(bundle);
        }
        d dVar = this.o;
        if (dVar != null) {
            dVar.e();
        }
        int d4 = com.tencent.liteav.basic.util.b.d(this.l);
        boolean a3 = com.tencent.liteav.basic.util.b.a(this.l);
        if (this.w != d4) {
            TXCEventRecorderProxy.a(this.p, 1003, d4, -1, "", 0);
            this.w = d4;
        }
        if (this.x != a3) {
            TXCEventRecorderProxy.a(this.p, 2001, a3 ? 1 : 0, -1, "", 0);
            this.x = a3 ? 1 : 0;
        }
        Handler handler = this.m;
        if (handler != null && this.L) {
            handler.postDelayed(new Runnable() {
                public void run() {
                    if (b.this.L) {
                        b.this.z();
                    }
                }
            }, 2000);
        }
    }

    private void A() {
        l lVar = new l();
        lVar.f31830d = com.tencent.liteav.audio.b.a().d();
        lVar.f31831e = com.tencent.liteav.audio.b.a().e();
        lVar.f31827a = 0;
        lVar.f31829c = 20;
        lVar.f31828b = 0;
        lVar.f31832f = 3;
        int i2 = 1;
        lVar.j = true;
        lVar.l = true;
        lVar.k = false;
        lVar.h = 40;
        lVar.i = 5000;
        lVar.m = this.i.J;
        lVar.n = this.i.K;
        lVar.o = l(this.f32368f);
        this.k = new TXCStreamUploader(this.l, lVar);
        this.k.setID(this.q);
        if ((this.i.L & 1) != 0) {
            TXCStreamUploader tXCStreamUploader = this.k;
            if (tXCStreamUploader != null) {
                tXCStreamUploader.setAudioInfo(this.i.q, this.i.r);
            }
        } else {
            TXCStreamUploader tXCStreamUploader2 = this.k;
            if (tXCStreamUploader2 != null) {
                tXCStreamUploader2.setAudioInfo(this.i.q, 1);
            }
        }
        this.k.setNotifyListener(this);
        if (this.f32366d.mEnablePureAudioPush) {
            c cVar = this.j;
            if (cVar != null) {
                this.k.setAudioMute(cVar.p());
            }
        }
        this.p = this.k.start(this.p, this.i.H, this.i.I);
        if (this.i.G) {
            this.k.setMode(1);
        }
        if (this.i.J) {
            int i3 = this.i.o;
            int i4 = this.i.p;
            if (i3 < 5) {
                i3 = 5;
            }
            if (i4 <= 1) {
                i2 = i4;
            }
            this.k.setRetryInterval(i2);
            this.k.setRetryTimes(i3);
            this.k.setVideoDropParams(false, this.i.h, 1000);
        } else {
            this.k.setRetryInterval(this.i.p);
            this.k.setRetryTimes(this.i.o);
            this.k.setVideoDropParams(true, 40, cn.tongdun.android.shell.settings.Constants.DEFAULT_WAIT_TIME);
        }
        this.k.setSendStrategy(this.i.J, this.i.K);
    }

    private void B() {
        TXCStreamUploader tXCStreamUploader = this.k;
        if (tXCStreamUploader != null) {
            tXCStreamUploader.stop();
            this.k.setNotifyListener((com.tencent.liteav.basic.c.a) null);
            this.k = null;
        }
    }

    private void C() {
        this.n = new TXCQoS(true);
        this.n.setListener(this);
        this.n.setNotifyListener(this);
        this.n.setAutoAdjustBitrate(this.i.f31624g);
        this.n.setAutoAdjustStrategy(this.i.f31623f);
        this.n.setDefaultVideoResolution(this.i.k);
        this.n.setVideoEncBitrate(this.i.f31622e, this.i.f31621d, this.i.f31620c);
        if (this.i.f31624g) {
            this.n.start(2000);
        }
    }

    private void D() {
        TXCQoS tXCQoS = this.n;
        if (tXCQoS != null) {
            tXCQoS.stop();
            this.n.setListener((com.tencent.liteav.qos.a) null);
            this.n.setNotifyListener((com.tencent.liteav.basic.c.a) null);
            this.n = null;
        }
    }

    private void E() {
        this.o = new d(this.l);
        this.o.d(this.q);
        this.o.a(this.i.f31620c);
        this.o.b(this.i.q);
        this.o.a(this.i.f31618a, this.i.f31619b);
        this.o.a(this.p);
        this.o.a();
    }

    private void F() {
        d dVar = this.o;
        if (dVar != null) {
            dVar.b();
            this.o = null;
        }
    }

    private void G() {
        c cVar = this.j;
        if (cVar != null) {
            cVar.setID(this.q);
            this.j.a((c.a) this);
            this.j.b(this.s, this.t);
            this.j.b(this.u);
            this.j.e();
        }
    }

    private void H() {
        c cVar = this.j;
        if (cVar != null) {
            cVar.a((c.a) null);
            this.j.g();
            this.j.a((c.a) null);
        }
    }

    private void b(TXLivePushConfig tXLivePushConfig) {
        f fVar = this.i;
        fVar.f31620c = tXLivePushConfig.mVideoBitrate;
        fVar.f31622e = tXLivePushConfig.mMinVideoBitrate;
        fVar.f31621d = tXLivePushConfig.mMaxVideoBitrate;
        fVar.f31623f = tXLivePushConfig.mAutoAdjustStrategy;
        fVar.f31624g = tXLivePushConfig.mAutoAdjustBitrate;
        fVar.h = tXLivePushConfig.mVideoFPS;
        fVar.i = tXLivePushConfig.mVideoEncodeGop;
        fVar.j = tXLivePushConfig.mHardwareAccel;
        fVar.k = tXLivePushConfig.mVideoResolution;
        fVar.n = tXLivePushConfig.mEnableVideoHardEncoderMainProfile;
        fVar.q = tXLivePushConfig.mAudioSample;
        fVar.r = tXLivePushConfig.mAudioChannels;
        fVar.s = tXLivePushConfig.mEnableAec;
        fVar.x = tXLivePushConfig.mPauseFlag;
        fVar.w = tXLivePushConfig.mPauseFps;
        fVar.u = tXLivePushConfig.mPauseImg;
        fVar.v = tXLivePushConfig.mPauseTime;
        fVar.G = tXLivePushConfig.mEnablePureAudioPush;
        fVar.E = tXLivePushConfig.mTouchFocus;
        fVar.F = tXLivePushConfig.mEnableZoom;
        fVar.y = tXLivePushConfig.mWatermark;
        fVar.z = tXLivePushConfig.mWatermarkX;
        fVar.A = tXLivePushConfig.mWatermarkY;
        fVar.B = tXLivePushConfig.mWatermarkXF;
        fVar.C = tXLivePushConfig.mWatermarkYF;
        fVar.D = tXLivePushConfig.mWatermarkWidth;
        fVar.l = tXLivePushConfig.mHomeOrientation;
        fVar.H = tXLivePushConfig.mEnableNearestIP;
        fVar.I = tXLivePushConfig.mRtmpChannelType;
        fVar.o = tXLivePushConfig.mConnectRetryCount;
        fVar.p = tXLivePushConfig.mConnectRetryInterval;
        fVar.m = tXLivePushConfig.mFrontCamera;
        fVar.L = tXLivePushConfig.mCustomModeType;
        fVar.M = tXLivePushConfig.mVideoEncoderXMirror;
        fVar.N = tXLivePushConfig.mEnableHighResolutionCapture;
        fVar.O = tXLivePushConfig.mEnableScreenCaptureAutoRotate;
        fVar.P = true;
        fVar.a();
    }

    private void I() {
        c cVar = this.j;
        if (cVar != null) {
            cVar.a(this.i);
            int i2 = 1;
            if (this.j.l()) {
                if (this.k != null) {
                    if (this.i.J) {
                        int i3 = this.i.o;
                        int i4 = this.i.p;
                        if (i3 < 5) {
                            i3 = 5;
                        }
                        if (i4 <= 1) {
                            i2 = i4;
                        }
                        this.k.setRetryInterval(i2);
                        this.k.setRetryTimes(i3);
                        this.k.setVideoDropParams(false, this.i.h, 1000);
                    } else {
                        this.k.setRetryInterval(this.i.p);
                        this.k.setRetryTimes(this.i.o);
                        this.k.setVideoDropParams(true, 40, cn.tongdun.android.shell.settings.Constants.DEFAULT_WAIT_TIME);
                    }
                    this.k.setSendStrategy(this.i.J, this.i.K);
                }
                TXCQoS tXCQoS = this.n;
                if (tXCQoS != null) {
                    tXCQoS.stop();
                    this.n.setAutoAdjustBitrate(this.i.f31624g);
                    this.n.setAutoAdjustStrategy(this.i.f31623f);
                    this.n.setDefaultVideoResolution(this.i.k);
                    this.n.setVideoEncBitrate(this.i.f31622e, this.i.f31621d, this.i.f31620c);
                    if (this.i.f31624g) {
                        this.n.start(2000);
                    }
                }
            } else if ((this.i.L & 1) != 0) {
                TXCStreamUploader tXCStreamUploader = this.k;
                if (tXCStreamUploader != null) {
                    tXCStreamUploader.setAudioInfo(this.i.q, this.i.r);
                }
            } else {
                TXCStreamUploader tXCStreamUploader2 = this.k;
                if (tXCStreamUploader2 != null) {
                    tXCStreamUploader2.setAudioInfo(this.i.q, 1);
                }
            }
        }
    }

    private void a(final int i2, final Bundle bundle) {
        switch (i2) {
            case TXLiteAVCode.ERR_RTMP_PUSH_SERVER_REFUSE:
                i2 = 3004;
                break;
            case TXLiteAVCode.ERR_RTMP_PUSH_NO_NETWORK:
            case TXLiteAVCode.ERR_RTMP_PUSH_NET_ALLADDRESS_FAIL:
            case -1307:
            case TXLiteAVCode.WARNING_RTMP_NO_DATA:
                i2 = -1307;
                break;
            case TXLiteAVCode.ERR_MIC_NOT_AUTHORIZED:
            case -1302:
                i2 = -1302;
                break;
            case TXLiteAVCode.ERR_CAMERA_SET_PARAM_FAIL:
            case TXLiteAVCode.ERR_CAMERA_NOT_AUTHORIZED:
            case -1301:
                i2 = -1301;
                break;
            case -1313:
                i2 = -1313;
                break;
            case -1303:
                i2 = -1303;
                break;
            case 0:
                return;
            case 1001:
                i2 = 1001;
                break;
            case 1002:
                i2 = 1002;
                break;
            case 1003:
            case 1005:
            case 1006:
            case 1007:
            case 3001:
                break;
            case 1008:
            case 1027:
            case 1028:
                i2 = 1008;
                break;
            case 1018:
                i2 = 1018;
                break;
            case 1019:
                i2 = 1019;
                break;
            case 1020:
                i2 = 1020;
                break;
            case 1021:
                i2 = 1021;
                break;
            case 1101:
                i2 = 1101;
                break;
            case 1102:
                i2 = 1102;
                break;
            case 1103:
                i2 = 1103;
                break;
            case TXLiteAVCode.WARNING_SW_ENCODER_START_FAIL:
            case 2003:
            case 2009:
                return;
            case 3002:
                i2 = 3002;
                break;
            case 3003:
                i2 = 3003;
                break;
            case TXLiteAVCode.WARNING_RTMP_WRITE_FAIL:
            case TXLiteAVCode.WARNING_RTMP_READ_FAIL:
                i2 = 3005;
                break;
            default:
                return;
        }
        Handler handler = this.m;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    if (b.this.f32367e != null) {
                        b.this.f32367e.onPushEvent(i2, bundle);
                    }
                }
            });
        }
    }

    private byte[] d(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        int i2 = 0;
        while (true) {
            int i3 = i2 + 4;
            if (i3 >= length) {
                return bArr2;
            }
            int i4 = ByteBuffer.wrap(bArr, i2, 4).getInt();
            if (i3 + i4 <= length) {
                bArr2[i2] = 0;
                bArr2[i2 + 1] = 0;
                bArr2[i2 + 2] = 0;
                bArr2[i2 + 3] = 1;
            }
            i2 = i2 + i4 + 4;
        }
    }

    private byte[] e(byte[] bArr) {
        int length = ((bArr.length * 4) / 3) + 2;
        byte[] bArr2 = new byte[length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr.length && i3 < length) {
            if (i2 + 3 < bArr.length && bArr[i2] == 0) {
                int i4 = i2 + 1;
                if (bArr[i4] == 0) {
                    int i5 = i2 + 2;
                    if (bArr[i5] >= 0 && bArr[i5] <= 3) {
                        int i6 = i3 + 1;
                        bArr2[i3] = bArr[i2];
                        int i7 = i6 + 1;
                        int i8 = i4 + 1;
                        bArr2[i6] = bArr[i4];
                        int i9 = i7 + 1;
                        bArr2[i7] = 3;
                        i2 = i8;
                        i3 = i9;
                    }
                }
            }
            bArr2[i3] = bArr[i2];
            i2++;
            i3++;
        }
        byte[] bArr3 = new byte[i3];
        System.arraycopy(bArr2, 0, bArr3, 0, i3);
        return bArr3;
    }

    private byte[] a(int i2, byte[] bArr) {
        byte[] k2 = k(i2);
        byte[] bArr2 = new byte[(k2.length + 1 + bArr.length + 1)];
        bArr2[0] = -14;
        System.arraycopy(k2, 0, bArr2, 1, k2.length);
        int length = 1 + k2.length;
        System.arraycopy(bArr, 0, bArr2, length, bArr.length);
        bArr2[length + bArr.length] = Byte.MIN_VALUE;
        return bArr2;
    }

    private byte[] k(int i2) {
        int i3 = (i2 / 255) + 1;
        byte[] bArr = new byte[i3];
        int i4 = 0;
        while (true) {
            int i5 = i3 - 1;
            if (i4 < i5) {
                bArr[i4] = -1;
                i4++;
            } else {
                bArr[i5] = (byte) ((i2 % 255) & 255);
                return bArr;
            }
        }
    }

    private int l(int i2) {
        long j2;
        switch (i2) {
            case 1:
                j2 = com.tencent.liteav.basic.e.b.a().a("QUICMode", "Live");
                break;
            case 2:
                j2 = com.tencent.liteav.basic.e.b.a().a("QUICMode", "Live");
                break;
            case 3:
                j2 = com.tencent.liteav.basic.e.b.a().a("QUICMode", "Live");
                break;
            case 4:
                j2 = com.tencent.liteav.basic.e.b.a().a("QUICMode", "LinkMain");
                break;
            case 5:
                j2 = com.tencent.liteav.basic.e.b.a().a("QUICMode", "LinkSub");
                break;
            case 6:
                j2 = com.tencent.liteav.basic.e.b.a().a("QUICMode", "RTC");
                break;
            default:
                return 0;
        }
        return (int) j2;
    }
}
