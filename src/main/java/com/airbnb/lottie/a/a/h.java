package com.airbnb.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.b.d;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.c.b.c;
import com.airbnb.lottie.c.b.e;
import com.airbnb.lottie.c.b.f;

public class h extends a {

    /* renamed from: b  reason: collision with root package name */
    private final String f3412b;

    /* renamed from: c  reason: collision with root package name */
    private final d<LinearGradient> f3413c = new d<>();

    /* renamed from: d  reason: collision with root package name */
    private final d<RadialGradient> f3414d = new d<>();

    /* renamed from: e  reason: collision with root package name */
    private final RectF f3415e = new RectF();

    /* renamed from: f  reason: collision with root package name */
    private final f f3416f;

    /* renamed from: g  reason: collision with root package name */
    private final int f3417g;
    private final a<c, c> h;
    private final a<PointF, PointF> i;
    private final a<PointF, PointF> j;

    public h(com.airbnb.lottie.f fVar, com.airbnb.lottie.c.c.a aVar, e eVar) {
        super(fVar, aVar, eVar.h().toPaintCap(), eVar.i().toPaintJoin(), eVar.l(), eVar.d(), eVar.g(), eVar.j(), eVar.k());
        this.f3412b = eVar.a();
        this.f3416f = eVar.b();
        this.f3417g = (int) (fVar.r().c() / 32.0f);
        this.h = eVar.c().a();
        this.h.a((a.C0069a) this);
        aVar.a((a<?, ?>) this.h);
        this.i = eVar.e().a();
        this.i.a((a.C0069a) this);
        aVar.a((a<?, ?>) this.i);
        this.j = eVar.f().a();
        this.j.a((a.C0069a) this);
        aVar.a((a<?, ?>) this.j);
    }

    public void a(Canvas canvas, Matrix matrix, int i2) {
        a(this.f3415e, matrix);
        if (this.f3416f == f.Linear) {
            this.f3375a.setShader(c());
        } else {
            this.f3375a.setShader(d());
        }
        super.a(canvas, matrix, i2);
    }

    public String b() {
        return this.f3412b;
    }

    private LinearGradient c() {
        long e2 = (long) e();
        LinearGradient a2 = this.f3413c.a(e2);
        if (a2 != null) {
            return a2;
        }
        PointF e3 = this.i.e();
        PointF e4 = this.j.e();
        c e5 = this.h.e();
        LinearGradient linearGradient = new LinearGradient((float) ((int) (this.f3415e.left + (this.f3415e.width() / 2.0f) + e3.x)), (float) ((int) (this.f3415e.top + (this.f3415e.height() / 2.0f) + e3.y)), (float) ((int) (this.f3415e.left + (this.f3415e.width() / 2.0f) + e4.x)), (float) ((int) (this.f3415e.top + (this.f3415e.height() / 2.0f) + e4.y)), e5.b(), e5.a(), Shader.TileMode.CLAMP);
        this.f3413c.b(e2, linearGradient);
        return linearGradient;
    }

    private RadialGradient d() {
        long e2 = (long) e();
        RadialGradient a2 = this.f3414d.a(e2);
        if (a2 != null) {
            return a2;
        }
        PointF e3 = this.i.e();
        PointF e4 = this.j.e();
        c e5 = this.h.e();
        int[] b2 = e5.b();
        float[] a3 = e5.a();
        int width = (int) (this.f3415e.left + (this.f3415e.width() / 2.0f) + e3.x);
        int height = (int) (this.f3415e.top + (this.f3415e.height() / 2.0f) + e3.y);
        RadialGradient radialGradient = new RadialGradient((float) width, (float) height, (float) Math.hypot((double) (((int) ((this.f3415e.left + (this.f3415e.width() / 2.0f)) + e4.x)) - width), (double) (((int) ((this.f3415e.top + (this.f3415e.height() / 2.0f)) + e4.y)) - height)), b2, a3, Shader.TileMode.CLAMP);
        this.f3414d.b(e2, radialGradient);
        return radialGradient;
    }

    private int e() {
        int round = Math.round(this.i.f() * ((float) this.f3417g));
        int round2 = Math.round(this.j.f() * ((float) this.f3417g));
        int round3 = Math.round(this.h.f() * ((float) this.f3417g));
        int i2 = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i2 = i2 * 31 * round2;
        }
        return round3 != 0 ? i2 * 31 * round3 : i2;
    }
}
