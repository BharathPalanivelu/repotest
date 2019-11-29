package com.shopee.arcatch.c.h;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.Landmark;
import com.shopee.arcatch.c.d.a;
import com.shopee.arcatch.c.g.c;
import com.shopee.arcatch.page.cameraview.common.GraphicOverlay;

public class b extends GraphicOverlay.a {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f26917a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f26918b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Face f26919c;

    /* renamed from: d  reason: collision with root package name */
    private long f26920d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f26921e = false;

    /* renamed from: f  reason: collision with root package name */
    private final float f26922f = 0.2f;

    /* renamed from: g  reason: collision with root package name */
    private final float f26923g = 0.13f;
    private int h;
    private int i;

    public String b() {
        return "CryEye";
    }

    public b(GraphicOverlay graphicOverlay, Face face) {
        super(graphicOverlay);
        this.f26919c = face;
        this.f26920d = System.currentTimeMillis() + 1000;
        this.f26921e = true;
    }

    public boolean a() {
        return this.f26921e;
    }

    public void a(Face face) {
        this.f26919c = face;
        this.f26920d += 1000;
        this.f26921e = true;
    }

    public void a(String str) {
        this.f26917a = a.a().a(str, true);
        this.f26918b = a.a().a(str, false);
        Bitmap bitmap = this.f26917a;
        if (bitmap != null && this.f26918b != null) {
            this.h = bitmap.getWidth();
            this.i = this.f26917a.getHeight();
        }
    }

    public void b(Face face) {
        this.f26919c = face;
    }

    public void a(Canvas canvas) {
        this.f26921e = System.currentTimeMillis() <= this.f26920d;
        if (this.f26919c != null) {
            PointF pointF = null;
            if (c.f26878a) {
                PointF pointF2 = null;
                for (Landmark next : this.f26919c.getLandmarks()) {
                    if (next.getType() == 4) {
                        pointF = next.getPosition();
                    } else if (next.getType() == 10) {
                        pointF2 = next.getPosition();
                    }
                    if (!(pointF == null || pointF2 == null)) {
                        a(canvas, pointF, pointF2);
                    }
                }
                return;
            }
            float f2 = a.a().n;
            int i2 = a.a().k;
            int i3 = a.a().l;
            PointF position = this.f26919c.getPosition();
            float c2 = c(position.x + (this.f26919c.getWidth() / 2.0f));
            float d2 = d(position.y + (this.f26919c.getHeight() / 2.0f)) * f2;
            float a2 = a(this.f26919c.getWidth() * 0.2f);
            float b2 = d2 - (b(this.f26919c.getHeight() * 0.13f) * f2);
            int i4 = this.h;
            int i5 = (int) ((c2 - a2) - ((float) (i4 / 2)));
            int i6 = this.i;
            int i7 = (int) (b2 - ((float) (i6 / 2)));
            int i8 = i4 + i5;
            int i9 = i6 + i7;
            Bitmap bitmap = this.f26917a;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, (Rect) null, new Rect(i5, i7 + i2 + i3, i8, i9 + i2 + i3), (Paint) null);
            }
            int i10 = this.h;
            int i11 = (int) ((c2 + a2) - ((float) (i10 / 2)));
            int i12 = this.i;
            int i13 = (int) (b2 - ((float) (i12 / 2)));
            int i14 = i10 + i11;
            int i15 = i12 + i13;
            Bitmap bitmap2 = this.f26918b;
            if (bitmap2 != null) {
                canvas.drawBitmap(bitmap2, (Rect) null, new Rect(i11, i13 + i2 + i3, i14, i15 + i2 + i3), (Paint) null);
            }
        }
    }

    private void a(Canvas canvas, PointF pointF, PointF pointF2) {
        if (this.f26917a != null && this.f26918b != null) {
            float f2 = a.a().n;
            int i2 = a.a().k;
            int i3 = a.a().l;
            float c2 = c(pointF.x);
            float d2 = d(pointF.y) * f2;
            float c3 = c(pointF2.x);
            float d3 = d(pointF2.y) * f2;
            if (c2 > c3) {
                float f3 = d3;
                d3 = d2;
                d2 = f3;
                float f4 = c3;
                c3 = c2;
                c2 = f4;
            }
            int i4 = this.h;
            int i5 = (int) (c2 - ((float) (i4 / 2)));
            int i6 = this.i;
            int i7 = (int) (d2 - ((float) (i6 / 2)));
            int i8 = i6 + i7;
            canvas.drawBitmap(this.f26917a, (Rect) null, new Rect(i5, i7 + i2 + i3, i4 + i5, i8 + i2 + i3), (Paint) null);
            int i9 = this.h;
            int i10 = (int) (c3 - ((float) (i9 / 2)));
            int i11 = this.i;
            int i12 = (int) (d3 - ((float) (i11 / 2)));
            int i13 = i11 + i12;
            canvas.drawBitmap(this.f26918b, (Rect) null, new Rect(i10, i12 + i2 + i3, i9 + i10, i13 + i2 + i3), (Paint) null);
        }
    }
}
