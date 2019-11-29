package com.airbnb.lottie.c.c;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.f;
import com.airbnb.lottie.g.c;
import com.airbnb.lottie.j;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class g extends a {

    /* renamed from: e  reason: collision with root package name */
    private final RectF f3631e = new RectF();

    /* renamed from: f  reason: collision with root package name */
    private final Paint f3632f = new Paint();

    /* renamed from: g  reason: collision with root package name */
    private final float[] f3633g = new float[8];
    private final Path h = new Path();
    private final d i;
    private a<ColorFilter, ColorFilter> j;

    g(f fVar, d dVar) {
        super(fVar, dVar);
        this.i = dVar;
        this.f3632f.setAlpha(0);
        this.f3632f.setStyle(Paint.Style.FILL);
        this.f3632f.setColor(dVar.p());
    }

    public void b(Canvas canvas, Matrix matrix, int i2) {
        int alpha = Color.alpha(this.i.p());
        if (alpha != 0) {
            int intValue = (int) ((((float) i2) / 255.0f) * (((((float) alpha) / 255.0f) * ((float) this.f3608d.a().e().intValue())) / 100.0f) * 255.0f);
            this.f3632f.setAlpha(intValue);
            a<ColorFilter, ColorFilter> aVar = this.j;
            if (aVar != null) {
                this.f3632f.setColorFilter(aVar.e());
            }
            if (intValue > 0) {
                float[] fArr = this.f3633g;
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[2] = (float) this.i.r();
                float[] fArr2 = this.f3633g;
                fArr2[3] = 0.0f;
                fArr2[4] = (float) this.i.r();
                this.f3633g[5] = (float) this.i.q();
                float[] fArr3 = this.f3633g;
                fArr3[6] = 0.0f;
                fArr3[7] = (float) this.i.q();
                matrix.mapPoints(this.f3633g);
                this.h.reset();
                Path path = this.h;
                float[] fArr4 = this.f3633g;
                path.moveTo(fArr4[0], fArr4[1]);
                Path path2 = this.h;
                float[] fArr5 = this.f3633g;
                path2.lineTo(fArr5[2], fArr5[3]);
                Path path3 = this.h;
                float[] fArr6 = this.f3633g;
                path3.lineTo(fArr6[4], fArr6[5]);
                Path path4 = this.h;
                float[] fArr7 = this.f3633g;
                path4.lineTo(fArr7[6], fArr7[7]);
                Path path5 = this.h;
                float[] fArr8 = this.f3633g;
                path5.lineTo(fArr8[0], fArr8[1]);
                this.h.close();
                canvas.drawPath(this.h, this.f3632f);
            }
        }
    }

    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.f3631e.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) this.i.r(), (float) this.i.q());
        this.f3605a.mapRect(this.f3631e);
        rectF.set(this.f3631e);
    }

    public <T> void a(T t, c<T> cVar) {
        super.a(t, cVar);
        if (t != j.x) {
            return;
        }
        if (cVar == null) {
            this.j = null;
        } else {
            this.j = new p(cVar);
        }
    }
}
