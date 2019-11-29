package com.shopee.live.livestreaming.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.live.livestreaming.c;

public class CircleImageView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private static final ImageView.ScaleType f29112a = ImageView.ScaleType.CENTER_CROP;

    /* renamed from: b  reason: collision with root package name */
    private static final Bitmap.Config f29113b = Bitmap.Config.ARGB_8888;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f29114c;

    /* renamed from: d  reason: collision with root package name */
    private final RectF f29115d;

    /* renamed from: e  reason: collision with root package name */
    private final Matrix f29116e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f29117f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f29118g;
    private int h;
    private int i;
    private Bitmap j;
    private BitmapShader k;
    private int l;
    private int m;
    private float n;
    private float o;
    private ColorFilter p;
    private boolean q;
    private boolean r;
    private boolean s;

    public CircleImageView(Context context) {
        super(context);
        this.f29114c = new RectF();
        this.f29115d = new RectF();
        this.f29116e = new Matrix();
        this.f29117f = new Paint();
        this.f29118g = new Paint();
        this.h = -16777216;
        this.i = 0;
        a();
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f29114c = new RectF();
        this.f29115d = new RectF();
        this.f29116e = new Matrix();
        this.f29117f = new Paint();
        this.f29118g = new Paint();
        this.h = -16777216;
        this.i = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.i.CircleImageView, i2, 0);
        this.i = obtainStyledAttributes.getDimensionPixelSize(c.i.CircleImageView_border_width, 0);
        this.h = obtainStyledAttributes.getColor(c.i.CircleImageView_border_color, -16777216);
        this.s = obtainStyledAttributes.getBoolean(c.i.CircleImageView_border_overlay, false);
        obtainStyledAttributes.recycle();
        a();
    }

    private void a() {
        super.setScaleType(f29112a);
        this.q = true;
        if (this.r) {
            b();
            this.r = false;
        }
    }

    public ImageView.ScaleType getScaleType() {
        return f29112a;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != f29112a) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
        }
    }

    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (getDrawable() != null) {
            canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.n, this.f29117f);
            if (this.i != 0) {
                canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.o, this.f29118g);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        b();
    }

    public int getBorderColor() {
        return this.h;
    }

    public void setBorderColor(int i2) {
        if (i2 != this.h) {
            this.h = i2;
            this.f29118g.setColor(this.h);
            invalidate();
        }
    }

    public void setBorderColorResource(int i2) {
        setBorderColor(getContext().getResources().getColor(i2));
    }

    public int getBorderWidth() {
        return this.i;
    }

    public void setBorderWidth(int i2) {
        if (i2 != this.i) {
            this.i = i2;
            b();
        }
    }

    public void setBorderOverlay(boolean z) {
        if (z != this.s) {
            this.s = z;
            b();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.j = bitmap;
        b();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.j = a(drawable);
        b();
    }

    public void setImageResource(int i2) {
        super.setImageResource(i2);
        this.j = a(getDrawable());
        b();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.j = a(getDrawable());
        b();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.p) {
            this.p = colorFilter;
            this.f29117f.setColorFilter(this.p);
            invalidate();
        }
    }

    private Bitmap a(Drawable drawable) {
        Bitmap bitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                bitmap = Bitmap.createBitmap(2, 2, f29113b);
            } else {
                bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), f29113b);
            }
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    private void b() {
        if (!this.q) {
            this.r = true;
            return;
        }
        Bitmap bitmap = this.j;
        if (bitmap != null) {
            this.k = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            this.f29117f.setAntiAlias(true);
            this.f29117f.setShader(this.k);
            this.f29118g.setStyle(Paint.Style.STROKE);
            this.f29118g.setAntiAlias(true);
            this.f29118g.setColor(this.h);
            this.f29118g.setStrokeWidth((float) this.i);
            this.m = this.j.getHeight();
            this.l = this.j.getWidth();
            this.f29115d.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) getWidth(), (float) getHeight());
            this.o = Math.min((this.f29115d.height() - ((float) this.i)) / 2.0f, (this.f29115d.width() - ((float) this.i)) / 2.0f);
            this.f29114c.set(this.f29115d);
            if (!this.s) {
                RectF rectF = this.f29114c;
                int i2 = this.i;
                rectF.inset((float) i2, (float) i2);
            }
            this.n = Math.min(this.f29114c.height() / 2.0f, this.f29114c.width() / 2.0f);
            c();
            invalidate();
        }
    }

    private void c() {
        float f2;
        float f3;
        this.f29116e.set((Matrix) null);
        float height = ((float) this.l) * this.f29114c.height();
        float width = this.f29114c.width() * ((float) this.m);
        float f4 = BitmapDescriptorFactory.HUE_RED;
        if (height > width) {
            f3 = this.f29114c.height() / ((float) this.m);
            f2 = (this.f29114c.width() - (((float) this.l) * f3)) * 0.5f;
        } else {
            f3 = this.f29114c.width() / ((float) this.l);
            f4 = (this.f29114c.height() - (((float) this.m) * f3)) * 0.5f;
            f2 = BitmapDescriptorFactory.HUE_RED;
        }
        this.f29116e.setScale(f3, f3);
        this.f29116e.postTranslate(((float) ((int) (f2 + 0.5f))) + this.f29114c.left, ((float) ((int) (f4 + 0.5f))) + this.f29114c.top);
        this.k.setLocalMatrix(this.f29116e);
    }
}
