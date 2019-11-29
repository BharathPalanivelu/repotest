package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

public abstract class b extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    final Bitmap f1839a;

    /* renamed from: b  reason: collision with root package name */
    final Rect f1840b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    private int f1841c = 160;

    /* renamed from: d  reason: collision with root package name */
    private int f1842d = 119;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f1843e = new Paint(3);

    /* renamed from: f  reason: collision with root package name */
    private final BitmapShader f1844f;

    /* renamed from: g  reason: collision with root package name */
    private final Matrix f1845g = new Matrix();
    private float h;
    private final RectF i = new RectF();
    private boolean j = true;
    private boolean k;
    private int l;
    private int m;

    private static boolean b(float f2) {
        return f2 > 0.05f;
    }

    private void c() {
        this.l = this.f1839a.getScaledWidth(this.f1841c);
        this.m = this.f1839a.getScaledHeight(this.f1841c);
    }

    public void setFilterBitmap(boolean z) {
        this.f1843e.setFilterBitmap(z);
        invalidateSelf();
    }

    public void setDither(boolean z) {
        this.f1843e.setDither(z);
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, int i4, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (this.j) {
            if (this.k) {
                int min = Math.min(this.l, this.m);
                a(this.f1842d, min, min, getBounds(), this.f1840b);
                int min2 = Math.min(this.f1840b.width(), this.f1840b.height());
                this.f1840b.inset(Math.max(0, (this.f1840b.width() - min2) / 2), Math.max(0, (this.f1840b.height() - min2) / 2));
                this.h = ((float) min2) * 0.5f;
            } else {
                a(this.f1842d, this.l, this.m, getBounds(), this.f1840b);
            }
            this.i.set(this.f1840b);
            if (this.f1844f != null) {
                this.f1845g.setTranslate(this.i.left, this.i.top);
                this.f1845g.preScale(this.i.width() / ((float) this.f1839a.getWidth()), this.i.height() / ((float) this.f1839a.getHeight()));
                this.f1844f.setLocalMatrix(this.f1845g);
                this.f1843e.setShader(this.f1844f);
            }
            this.j = false;
        }
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f1839a;
        if (bitmap != null) {
            a();
            if (this.f1843e.getShader() == null) {
                canvas.drawBitmap(bitmap, (Rect) null, this.f1840b, this.f1843e);
                return;
            }
            RectF rectF = this.i;
            float f2 = this.h;
            canvas.drawRoundRect(rectF, f2, f2, this.f1843e);
        }
    }

    public void setAlpha(int i2) {
        if (i2 != this.f1843e.getAlpha()) {
            this.f1843e.setAlpha(i2);
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.f1843e.getAlpha();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1843e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public ColorFilter getColorFilter() {
        return this.f1843e.getColorFilter();
    }

    private void d() {
        this.h = (float) (Math.min(this.m, this.l) / 2);
    }

    public void a(float f2) {
        if (this.h != f2) {
            this.k = false;
            if (b(f2)) {
                this.f1843e.setShader(this.f1844f);
            } else {
                this.f1843e.setShader((Shader) null);
            }
            this.h = f2;
            invalidateSelf();
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.k) {
            d();
        }
        this.j = true;
    }

    public float b() {
        return this.h;
    }

    public int getIntrinsicWidth() {
        return this.l;
    }

    public int getIntrinsicHeight() {
        return this.m;
    }

    public int getOpacity() {
        if (this.f1842d != 119 || this.k) {
            return -3;
        }
        Bitmap bitmap = this.f1839a;
        if (bitmap == null || bitmap.hasAlpha() || this.f1843e.getAlpha() < 255 || b(this.h)) {
            return -3;
        }
        return -1;
    }

    b(Resources resources, Bitmap bitmap) {
        if (resources != null) {
            this.f1841c = resources.getDisplayMetrics().densityDpi;
        }
        this.f1839a = bitmap;
        if (this.f1839a != null) {
            c();
            this.f1844f = new BitmapShader(this.f1839a, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            return;
        }
        this.m = -1;
        this.l = -1;
        this.f1844f = null;
    }
}
