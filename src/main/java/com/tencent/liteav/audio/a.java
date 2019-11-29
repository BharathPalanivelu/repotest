package com.tencent.liteav.audio;

import android.content.Context;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.liteav.audio.impl.Play.TXAudioJitterBufferReportInfo;
import com.tencent.liteav.audio.impl.Play.TXCAudioBasePlayController;
import com.tencent.liteav.audio.impl.Play.d;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.audio.impl.b;
import com.tencent.liteav.audio.impl.c;
import com.tencent.liteav.audio.impl.e;
import com.tencent.liteav.basic.log.TXCLog;

public class a implements e {

    /* renamed from: a  reason: collision with root package name */
    public static float f31116a = 5.0f;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f31117b = true;

    /* renamed from: c  reason: collision with root package name */
    public static float f31118c = 5.0f;

    /* renamed from: d  reason: collision with root package name */
    public static float f31119d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f31120e = false;

    /* renamed from: f  reason: collision with root package name */
    private static final String f31121f = ("AudioCenter:" + a.class.getSimpleName());

    /* renamed from: g  reason: collision with root package name */
    private TXCAudioBasePlayController f31122g;
    private c h;
    private int i;
    private float j;
    private boolean k;
    private float l;
    private float m;
    private boolean n;
    private boolean o;
    private boolean p;
    private int q;
    private Context r;
    private String s;
    private int t;
    private com.tencent.liteav.basic.module.a u;
    private boolean v;

    public int e() {
        return 48000;
    }

    public int f() {
        return 2;
    }

    public static void a(c cVar) {
        TXCAudioBasePlayController.setAudioCorePlayListener(cVar);
    }

    public a() {
        this.f31122g = null;
        this.i = 0;
        this.j = f31116a;
        this.k = f31117b;
        this.l = f31118c;
        this.m = f31119d;
        this.n = false;
        this.o = false;
        this.p = f31120e;
        this.q = 0;
        this.t = 0;
        this.u = null;
        this.v = false;
        this.u = new com.tencent.liteav.basic.module.a();
        this.u.setID("18446744073709551615");
    }

    public synchronized int a(Context context) {
        if (context == null) {
            TXCLog.e(f31121f, "invalid param, start play failed!");
            return TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
        }
        if (b.c(this.i) != 0) {
            String str = f31121f;
            TXCLog.w(str, "start player failed, with aec type " + this.i + ", invalid aec recorder has started!");
        }
        if (this.f31122g == null || !this.f31122g.isPlaying()) {
            this.r = context;
            com.tencent.liteav.audio.impl.a.a().a(context);
            c.a().a(this.r);
            c.a().a((e) this);
            if (this.f31122g == null) {
                if (this.i == 2) {
                    this.f31122g = new com.tencent.liteav.audio.impl.Play.c(context.getApplicationContext());
                } else {
                    this.f31122g = new com.tencent.liteav.audio.impl.Play.b(context.getApplicationContext());
                }
            }
            if (this.f31122g != null) {
                a(this.i, this.r);
                b(this.h);
                a(this.j);
                a(this.k);
                b(this.l);
                c(this.m);
                d(this.n);
                c(this.o);
                b(this.q);
                e(this.p);
                a(this.s);
                b(this.v);
                a(this.t);
                return this.f31122g.startPlay();
            }
            TXCLog.e(f31121f, "start play failed! controller is null!");
            return TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
        }
        TXCLog.e(f31121f, "play has started, can not start again!");
        return TXEAudioDef.TXE_AUDIO_PLAY_ERR_REPEAT_OPTION;
    }

    public synchronized int a() {
        int i2;
        this.h = null;
        this.j = f31116a;
        this.k = f31117b;
        this.l = f31118c;
        this.m = f31119d;
        i2 = 0;
        this.n = false;
        this.o = false;
        this.p = f31120e;
        this.q = 0;
        this.r = null;
        this.s = null;
        this.t = 0;
        if (this.f31122g != null) {
            i2 = this.f31122g.stopPlay();
            this.f31122g = null;
        }
        c.a().b((e) this);
        return i2;
    }

    public void a(boolean z, Context context) {
        if (!z) {
            a(0, context);
            this.u.setStatusValue(18005, 0);
        } else if (com.tencent.liteav.basic.e.b.a().g()) {
            a(1, context);
            this.u.setStatusValue(18005, 1);
        } else {
            com.tencent.liteav.audio.impl.a.a(com.tencent.liteav.basic.e.b.a().b());
            this.u.setStatusValue(18005, 2);
            a(2, context);
        }
    }

    public synchronized void a(String str) {
        this.s = str;
        if (this.f31122g != null) {
            this.f31122g.setUserID(this.s);
        }
    }

    private void a(int i2, Context context) {
        if (i2 != 2 || TXCTraeJNI.nativeCheckTraeEngine(context)) {
            String str = f31121f;
            TXCLog.i(str, "set aec type to " + i2 + ", cur type " + this.i);
            this.i = i2;
            return;
        }
        TXCLog.e(f31121f, "set aec type failed, check trae library failed!!");
    }

    public synchronized int a(int i2) {
        this.t = i2;
        if (this.f31122g == null) {
            return -101;
        }
        return this.f31122g.setStreamFormat(this.t);
    }

    public void b(c cVar) {
        this.h = cVar;
        TXCAudioBasePlayController tXCAudioBasePlayController = this.f31122g;
        if (tXCAudioBasePlayController != null) {
            tXCAudioBasePlayController.setListener(cVar);
        }
    }

    public void a(float f2) {
        this.j = f2;
        TXCAudioBasePlayController tXCAudioBasePlayController = this.f31122g;
        if (tXCAudioBasePlayController != null) {
            tXCAudioBasePlayController.setCacheTime(f2);
        }
    }

    public void a(boolean z) {
        this.k = z;
        TXCAudioBasePlayController tXCAudioBasePlayController = this.f31122g;
        if (tXCAudioBasePlayController != null) {
            tXCAudioBasePlayController.enableAutojustCache(z);
        }
    }

    public void b(float f2) {
        this.l = f2;
        TXCAudioBasePlayController tXCAudioBasePlayController = this.f31122g;
        if (tXCAudioBasePlayController != null) {
            tXCAudioBasePlayController.setAutoAdjustMaxCache(f2);
        }
    }

    public void c(float f2) {
        this.m = f2;
        TXCAudioBasePlayController tXCAudioBasePlayController = this.f31122g;
        if (tXCAudioBasePlayController != null) {
            tXCAudioBasePlayController.setAutoAdjustMinCache(f2);
        }
    }

    public void b(boolean z) {
        this.v = z;
        TXCAudioBasePlayController tXCAudioBasePlayController = this.f31122g;
        if (tXCAudioBasePlayController != null) {
            tXCAudioBasePlayController.setEnableVolumeLevelCal(z);
        }
    }

    public int b() {
        TXCAudioBasePlayController tXCAudioBasePlayController = this.f31122g;
        if (tXCAudioBasePlayController != null) {
            return tXCAudioBasePlayController.getVolumeLevel();
        }
        return 0;
    }

    public synchronized float c() {
        if (this.f31122g == null) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        return this.f31122g.getCacheThreshold();
    }

    public void c(boolean z) {
        this.o = z;
        TXCAudioBasePlayController tXCAudioBasePlayController = this.f31122g;
        if (tXCAudioBasePlayController != null) {
            tXCAudioBasePlayController.enableHWAcceleration(z);
        }
    }

    public void d(boolean z) {
        this.n = z;
        TXCAudioBasePlayController tXCAudioBasePlayController = this.f31122g;
        if (tXCAudioBasePlayController != null) {
            tXCAudioBasePlayController.enableRealTimePlay(z);
        }
    }

    public void e(boolean z) {
        this.p = z;
        TXCAudioBasePlayController tXCAudioBasePlayController = this.f31122g;
        if (tXCAudioBasePlayController != null) {
            tXCAudioBasePlayController.setMute(z);
        }
    }

    public static void a(Context context, int i2) {
        TXCAudioBasePlayController.setAudioMode(context, i2);
    }

    public void b(int i2) {
        this.q = i2;
        TXCAudioBasePlayController tXCAudioBasePlayController = this.f31122g;
        if (tXCAudioBasePlayController != null) {
            tXCAudioBasePlayController.setSmootheMode(this.q);
        }
    }

    public int d() {
        if (d.a().d()) {
            int i2 = this.i;
            if (i2 != 2) {
                return i2;
            }
            String str = f31121f;
            TXCLog.e(str, "audio track has start, but aec type is trae!!" + this.i);
            return 0;
        } else if (!TXCTraeJNI.nativeTraeIsPlaying()) {
            return 0;
        } else {
            int i3 = this.i;
            if (i3 == 2) {
                return i3;
            }
            String str2 = f31121f;
            TXCLog.e(str2, "trae engine has start, but aec type is not trae!!" + this.i);
            return 2;
        }
    }

    public TXAudioJitterBufferReportInfo g() {
        TXCAudioBasePlayController tXCAudioBasePlayController = this.f31122g;
        if (tXCAudioBasePlayController != null) {
            return tXCAudioBasePlayController.getReportInfo();
        }
        return null;
    }

    public void c(int i2) {
        if (i2 == 0) {
            TXCAudioBasePlayController tXCAudioBasePlayController = this.f31122g;
            if (tXCAudioBasePlayController != null) {
                tXCAudioBasePlayController.setMute(this.p);
            }
        } else if (i2 == 1) {
            TXCAudioBasePlayController tXCAudioBasePlayController2 = this.f31122g;
            if (tXCAudioBasePlayController2 != null) {
                tXCAudioBasePlayController2.setMute(true);
            }
        } else if (i2 == 2) {
            TXCAudioBasePlayController tXCAudioBasePlayController3 = this.f31122g;
            if (tXCAudioBasePlayController3 != null) {
                tXCAudioBasePlayController3.setMute(true);
            }
        }
    }

    public static void f(boolean z) {
        TXCAudioBasePlayController.nativeEnableCoreplayVolumeLevelCal(z);
    }

    public static int h() {
        return TXCAudioBasePlayController.nativeGetCorePlayVolumeLevel();
    }
}
