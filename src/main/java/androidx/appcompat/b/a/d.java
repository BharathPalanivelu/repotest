package androidx.appcompat.b.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class d extends Drawable {

    /* renamed from: b  reason: collision with root package name */
    private static final float f727b = ((float) Math.toRadians(45.0d));

    /* renamed from: a  reason: collision with root package name */
    private final Paint f728a;

    /* renamed from: c  reason: collision with root package name */
    private float f729c;

    /* renamed from: d  reason: collision with root package name */
    private float f730d;

    /* renamed from: e  reason: collision with root package name */
    private float f731e;

    /* renamed from: f  reason: collision with root package name */
    private float f732f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f733g;
    private final Path h;
    private final int i;
    private boolean j;
    private float k;
    private float l;
    private int m;

    private static float a(float f2, float f3, float f4) {
        return f2 + ((f3 - f2) * f4);
    }

    public int getOpacity() {
        return -3;
    }

    public void a(boolean z) {
        if (this.j != z) {
            this.j = z;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        Canvas canvas2 = canvas;
        Rect bounds = getBounds();
        int i2 = this.m;
        boolean z = false;
        if (i2 != 0 && (i2 == 1 || (i2 == 3 ? a.i(this) == 0 : a.i(this) == 1))) {
            z = true;
        }
        float f2 = this.f729c;
        float a2 = a(this.f730d, (float) Math.sqrt((double) (f2 * f2 * 2.0f)), this.k);
        float a3 = a(this.f730d, this.f731e, this.k);
        float round = (float) Math.round(a(BitmapDescriptorFactory.HUE_RED, this.l, this.k));
        float a4 = a(BitmapDescriptorFactory.HUE_RED, f727b, this.k);
        double d2 = (double) a2;
        float a5 = a(z ? BitmapDescriptorFactory.HUE_RED : -180.0f, z ? 180.0f : BitmapDescriptorFactory.HUE_RED, this.k);
        double d3 = (double) a4;
        double cos = Math.cos(d3);
        Double.isNaN(d2);
        boolean z2 = z;
        float round2 = (float) Math.round(cos * d2);
        double sin = Math.sin(d3);
        Double.isNaN(d2);
        float round3 = (float) Math.round(d2 * sin);
        this.h.rewind();
        float a6 = a(this.f732f + this.f728a.getStrokeWidth(), -this.l, this.k);
        float f3 = (-a3) / 2.0f;
        this.h.moveTo(f3 + round, BitmapDescriptorFactory.HUE_RED);
        this.h.rLineTo(a3 - (round * 2.0f), BitmapDescriptorFactory.HUE_RED);
        this.h.moveTo(f3, a6);
        this.h.rLineTo(round2, round3);
        this.h.moveTo(f3, -a6);
        this.h.rLineTo(round2, -round3);
        this.h.close();
        canvas.save();
        float strokeWidth = this.f728a.getStrokeWidth();
        float height = ((float) bounds.height()) - (3.0f * strokeWidth);
        float f4 = this.f732f;
        canvas2.translate((float) bounds.centerX(), ((float) ((((int) (height - (2.0f * f4))) / 4) * 2)) + (strokeWidth * 1.5f) + f4);
        if (this.f733g) {
            canvas2.rotate(a5 * ((float) (this.j ^ z2 ? -1 : 1)));
        } else if (z2) {
            canvas2.rotate(180.0f);
        }
        canvas2.drawPath(this.h, this.f728a);
        canvas.restore();
    }

    public void setAlpha(int i2) {
        if (i2 != this.f728a.getAlpha()) {
            this.f728a.setAlpha(i2);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f728a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getIntrinsicHeight() {
        return this.i;
    }

    public int getIntrinsicWidth() {
        return this.i;
    }

    public void a(float f2) {
        if (this.k != f2) {
            this.k = f2;
            invalidateSelf();
        }
    }
}
