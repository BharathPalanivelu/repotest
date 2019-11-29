package com.tencent.liteav.audio;

import android.content.Context;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.liteav.audio.impl.Record.TXCAudioSysRecordController;
import com.tencent.liteav.audio.impl.Record.c;
import com.tencent.liteav.audio.impl.Record.f;
import com.tencent.liteav.audio.impl.Record.g;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.audio.impl.e;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.a;
import java.lang.ref.WeakReference;

public class b implements e {

    /* renamed from: a  reason: collision with root package name */
    static b f31123a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static final String f31124b = ("AudioCenter:" + b.class.getSimpleName());

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<d> f31125c;

    /* renamed from: d  reason: collision with root package name */
    private int f31126d;

    /* renamed from: e  reason: collision with root package name */
    private int f31127e;

    /* renamed from: f  reason: collision with root package name */
    private int f31128f;

    /* renamed from: g  reason: collision with root package name */
    private int f31129g;
    private boolean h;
    private int i;
    private boolean j;
    private boolean k;
    private Context l;
    private float m;
    private int n;
    private int o;
    private int p;
    private int q;
    private float r;
    private a s;
    private String t;
    private boolean u;
    private c v;

    public void b(boolean z) {
    }

    private b() {
        this.f31126d = 48000;
        this.f31127e = 1;
        this.f31128f = 16;
        this.f31129g = 0;
        this.h = false;
        this.i = 0;
        this.j = false;
        this.k = false;
        this.m = 1.0f;
        this.n = -1;
        this.o = -1;
        this.p = 10;
        this.q = 21;
        this.r = BitmapDescriptorFactory.HUE_RED;
        this.s = null;
        this.u = false;
        this.v = null;
        this.s = new a();
    }

    public void a(String str) {
        this.t = str;
        this.s.setID(str);
        c cVar = this.v;
        if (cVar != null) {
            cVar.SetID(this.t);
        }
    }

    public static b a() {
        return f31123a;
    }

    public int a(Context context) {
        if (context == null) {
            TXCLog.e(f31124b, "invalid param, start record failed!");
            return TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
        }
        this.l = context.getApplicationContext();
        com.tencent.liteav.audio.impl.a.a().a(this.l);
        com.tencent.liteav.audio.impl.c.a().a(this.l);
        com.tencent.liteav.audio.impl.c.a().a((e) this);
        if (com.tencent.liteav.audio.impl.b.b(this.i) != 0) {
            String str = f31124b;
            TXCLog.w(str, "start recorder failed, with aec type " + this.i + ", invalid aec player has started!");
        }
        c cVar = this.v;
        if (cVar == null || !cVar.isRecording()) {
            if (this.v == null) {
                if (this.i == 2) {
                    this.v = new g();
                } else {
                    this.v = new TXCAudioSysRecordController();
                }
                this.v.SetID(this.t);
            }
            com.tencent.liteav.audio.impl.a.a().a(true);
            if (this.v != null) {
                g();
                return this.v.startRecord(this.l);
            }
            TXCLog.e(f31124b, "start Record failed! controller is null!");
            return TXEAudioDef.TXE_AUDIO_COMMON_ERR_INVALID_PARAMS;
        }
        TXCLog.e(f31124b, "record has started, can not start again!");
        return -2;
    }

    public int b() {
        int i2;
        c cVar = this.v;
        if (cVar != null) {
            i2 = cVar.stopRecord();
            this.v = null;
        } else {
            i2 = 0;
        }
        this.f31125c = null;
        this.f31126d = 48000;
        this.f31127e = 1;
        this.f31128f = 16;
        this.f31129g = 0;
        this.h = false;
        this.i = 0;
        this.j = false;
        this.k = false;
        this.l = null;
        this.m = 1.0f;
        this.n = -1;
        this.o = -1;
        this.p = 10;
        this.q = 21;
        this.u = false;
        g();
        com.tencent.liteav.audio.impl.c.a().b((e) this);
        com.tencent.liteav.audio.impl.a.a().a(false);
        return i2;
    }

    public boolean c() {
        c cVar = this.v;
        if (cVar != null) {
            return cVar.isRecording();
        }
        return false;
    }

    public void a(boolean z) {
        this.k = z;
        c cVar = this.v;
        if (cVar != null) {
            cVar.setIsCustomRecord(z);
        }
    }

    public void a(d dVar) {
        this.f31125c = new WeakReference<>(dVar);
        c cVar = this.v;
        if (cVar != null) {
            cVar.setListener(dVar);
        }
    }

    public int d() {
        return this.f31127e;
    }

    public int e() {
        return this.f31126d;
    }

    public void a(int i2) {
        String str = f31124b;
        TXCLog.i(str, "setSampleRate: " + i2);
        this.f31126d = i2;
        this.s.setStatusValue(14003, Integer.valueOf(this.f31126d));
        c cVar = this.v;
        if (cVar != null) {
            cVar.setSamplerate(i2);
        }
    }

    public void b(int i2) {
        String str = f31124b;
        TXCLog.i(str, "setChannels: " + i2);
        this.f31127e = i2;
        c cVar = this.v;
        if (cVar != null) {
            cVar.setChannels(i2);
        }
    }

    public void d(int i2) {
        String str = f31124b;
        TXCLog.i(str, "setReverbType: " + i2);
        this.f31129g = i2;
        c cVar = this.v;
        if (cVar != null) {
            cVar.setReverbType(i2);
        }
    }

    public void a(boolean z, Context context) {
        if (!z) {
            a(0, context);
            this.s.setStatusValue(14005, 0);
        } else if (com.tencent.liteav.basic.e.b.a().g()) {
            a(1, context);
            this.s.setStatusValue(14005, 1);
        } else {
            com.tencent.liteav.audio.impl.a.a(com.tencent.liteav.basic.e.b.a().b());
            a(2, context);
            this.s.setStatusValue(14005, 2);
        }
    }

    public void e(int i2) {
        this.q = i2;
        c cVar = this.v;
        if (cVar != null) {
            cVar.setEncFrameLenMs(this.q);
        }
    }

    private void a(int i2, Context context) {
        if (i2 != 2 || TXCTraeJNI.nativeCheckTraeEngine(context)) {
            if (this.i != i2) {
                c cVar = this.v;
                if (cVar != null && cVar.isRecording()) {
                    this.v.stopRecord();
                    this.v = null;
                    this.i = i2;
                    a(this.l);
                }
                this.i = i2;
            }
            c cVar2 = this.v;
            if (cVar2 != null) {
                cVar2.setAECType(i2);
                return;
            }
            return;
        }
        TXCLog.e(f31124b, "set aec type failed, check trae library failed!!");
    }

    public void c(boolean z) {
        String str = f31124b;
        TXCLog.i(str, "setMute: " + z);
        if (this.h != z) {
            TXCEventRecorderProxy.a(this.t, 3001, z ? 1 : 0, -1, "", 0);
        }
        this.h = z;
        this.s.setStatusValue(14014, Integer.valueOf(z ? 1 : 0));
        c cVar = this.v;
        if (cVar != null) {
            cVar.setMute(z);
        }
    }

    public void a(float f2) {
        String str = f31124b;
        TXCLog.i(str, "setVolume: " + f2);
        this.m = f2;
        c cVar = this.v;
        if (cVar != null) {
            cVar.setVolume(f2);
        }
    }

    public void a(int i2, int i3) {
        String str = f31124b;
        TXCLog.i(str, "setChangerType: " + i2 + SQLBuilder.BLANK + i3);
        this.n = i2;
        this.o = i3;
        c cVar = this.v;
        if (cVar != null) {
            cVar.setChangerType(i2, i3);
        }
    }

    public void f(int i2) {
        String str = f31124b;
        TXCLog.i(str, "setAudioFormat: " + i2);
        this.p = i2;
        int i3 = this.p;
        if (i3 == 11) {
            if (this.q == 21) {
                this.q = 20;
            }
        } else if (i3 == 10) {
            this.q = 21;
        }
        this.s.setStatusValue(14004, Integer.valueOf(this.p));
        c cVar = this.v;
        if (cVar != null) {
            cVar.setAudioFormat(i2);
        }
    }

    public void b(float f2) {
        String str = f31124b;
        TXCLog.i(str, "setFecRatio : " + f2);
        this.r = f2;
        c cVar = this.v;
        if (cVar != null) {
            cVar.setFecRatio(f2);
        }
    }

    public void d(boolean z) {
        this.u = z;
        c cVar = this.v;
        if (cVar != null) {
            cVar.setEnableVolumeLevel(z);
        }
    }

    public void a(byte[] bArr) {
        c cVar = this.v;
        if (cVar != null) {
            cVar.sendCustomPCMData(bArr);
        }
    }

    public int f() {
        if (f.a().c()) {
            int i2 = this.i;
            if (i2 != 2) {
                return i2;
            }
            String str = f31124b;
            TXCLog.e(str, "audio mic has start, but aec type is trae!!" + this.i);
            return 0;
        } else if (!TXCTraeJNI.nativeTraeIsRecording()) {
            return 0;
        } else {
            int i3 = this.i;
            if (i3 == 2) {
                return i3;
            }
            String str2 = f31124b;
            TXCLog.e(str2, "trae engine has start, but aec type is not trae!!" + this.i);
            return 2;
        }
    }

    private void g() {
        WeakReference<d> weakReference = this.f31125c;
        if (weakReference != null) {
            a((d) weakReference.get());
        }
        a(this.k);
        a(this.f31126d);
        b(this.f31127e);
        d(this.f31129g);
        a(this.i, this.l);
        b(this.j);
        c(this.h);
        a(this.m);
        a(this.n, this.o);
        f(this.p);
        e(this.q);
        b(this.r);
        d(this.u);
    }

    public void c(int i2) {
        if (i2 == 0) {
            c cVar = this.v;
            if (cVar != null) {
                cVar.setMute(this.h);
            }
        } else if (i2 == 1) {
            c cVar2 = this.v;
            if (cVar2 != null) {
                cVar2.setMute(true);
            }
        } else if (i2 == 2) {
            c cVar3 = this.v;
            if (cVar3 != null) {
                cVar3.setMute(true);
            }
        }
    }
}
