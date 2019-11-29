package com.shopee.app.util.m;

import android.content.Context;
import android.hardware.SensorManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.shopee.app.web.protocol.StartShakeDetectionMessage;
import com.squareup.b.a;
import d.d.b.j;
import d.d.b.k;
import d.d.b.m;
import d.d.b.n;
import d.d.b.p;
import d.f;
import d.f.e;

public final class a implements a.C0478a {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ e[] f26445a = {p.a((m) new n(p.a(a.class), "sensorManager", "getSensorManager()Landroid/hardware/SensorManager;")), p.a((m) new n(p.a(a.class), "shakeDetector", "getShakeDetector()Lcom/squareup/seismic/ShakeDetector;"))};

    /* renamed from: b  reason: collision with root package name */
    private final d.e f26446b = f.a(new b(this));

    /* renamed from: c  reason: collision with root package name */
    private final d.e f26447c = f.a(new c(this));

    /* renamed from: d  reason: collision with root package name */
    private C0407a f26448d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f26449e;

    /* renamed from: com.shopee.app.util.m.a$a  reason: collision with other inner class name */
    public interface C0407a {
        void shakeDetected();
    }

    private final SensorManager d() {
        d.e eVar = this.f26446b;
        e eVar2 = f26445a[0];
        return (SensorManager) eVar.a();
    }

    private final com.squareup.b.a e() {
        d.e eVar = this.f26447c;
        e eVar2 = f26445a[1];
        return (com.squareup.b.a) eVar.a();
    }

    public a(Context context) {
        j.b(context, "context");
        this.f26449e = context;
    }

    public final Context c() {
        return this.f26449e;
    }

    static final class b extends k implements d.d.a.a<SensorManager> {
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar) {
            super(0);
            this.this$0 = aVar;
        }

        /* renamed from: a */
        public final SensorManager invoke() {
            Object systemService = this.this$0.c().getSystemService("sensor");
            if (systemService != null) {
                return (SensorManager) systemService;
            }
            throw new d.m("null cannot be cast to non-null type android.hardware.SensorManager");
        }
    }

    static final class c extends k implements d.d.a.a<com.squareup.b.a> {
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar) {
            super(0);
            this.this$0 = aVar;
        }

        /* renamed from: a */
        public final com.squareup.b.a invoke() {
            return new com.squareup.b.a(this.this$0);
        }
    }

    public final boolean a(StartShakeDetectionMessage startShakeDetectionMessage, C0407a aVar) {
        j.b(startShakeDetectionMessage, "data");
        j.b(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        try {
            e().a();
            int i = 11;
            if (startShakeDetectionMessage.getSensitivity() != null && startShakeDetectionMessage.getSensitivity().intValue() > 0) {
                i = startShakeDetectionMessage.getSensitivity().intValue();
            }
            this.f26448d = aVar;
            e().a(i);
            return e().a(d());
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean a() {
        try {
            e().a();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void b() {
        C0407a aVar = this.f26448d;
        if (aVar != null) {
            aVar.shakeDetected();
        }
    }
}
