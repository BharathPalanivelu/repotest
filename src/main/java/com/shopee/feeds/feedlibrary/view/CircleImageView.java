package com.shopee.feeds.feedlibrary.view;

import android.annotation.SuppressLint;
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
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.feeds.feedlibrary.c;

@SuppressLint({"AppCompatCustomView"})
public class CircleImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private static final ImageView.ScaleType f28413a = ImageView.ScaleType.CENTER_CROP;

    /* renamed from: b  reason: collision with root package name */
    private static final Bitmap.Config f28414b = Bitmap.Config.ARGB_8888;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f28415c;

    /* renamed from: d  reason: collision with root package name */
    private final RectF f28416d;

    /* renamed from: e  reason: collision with root package name */
    private final Matrix f28417e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f28418f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f28419g;
    private final Paint h;
    private int i;
    private int j;
    private int k;
    private Bitmap l;
    private BitmapShader m;
    private int n;
    private int o;
    private float p;
    private float q;
    private ColorFilter r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;

    public CircleImageView(Context context) {
        super(context);
        this.f28415c = new RectF();
        this.f28416d = new RectF();
        this.f28417e = new Matrix();
        this.f28418f = new Paint();
        this.f28419g = new Paint();
        this.h = new Paint();
        this.i = -16777216;
        this.j = 0;
        this.k = 0;
        a();
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f28415c = new RectF();
        this.f28416d = new RectF();
        this.f28417e = new Matrix();
        this.f28418f = new Paint();
        this.f28419g = new Paint();
        this.h = new Paint();
        this.i = -16777216;
        this.j = 0;
        this.k = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.i.CircleImageView, i2, 0);
        this.j = obtainStyledAttributes.getDimensionPixelSize(c.i.CircleImageView_civ_border_width, 0);
        this.i = obtainStyledAttributes.getColor(c.i.CircleImageView_civ_border_color, -16777216);
        this.u = obtainStyledAttributes.getBoolean(c.i.CircleImageView_civ_border_overlay, false);
        this.k = obtainStyledAttributes.getColor(c.i.CircleImageView_civ_fill_color, 0);
        obtainStyledAttributes.recycle();
        a();
    }

    private void a() {
        super.setScaleType(f28413a);
        this.s = true;
        if (this.t) {
            d();
            this.t = false;
        }
    }

    public ImageView.ScaleType getScaleType() {
        return f28413a;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != f28413a) {
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
        if (this.v) {
            super.onDraw(canvas);
        } else if (this.l != null) {
            if (this.k != 0) {
                canvas.drawCircle(this.f28415c.centerX(), this.f28415c.centerY(), this.p, this.h);
            }
            canvas.drawCircle(this.f28415c.centerX(), this.f28415c.centerY(), this.p, this.f28418f);
            if (this.j > 0) {
                canvas.drawCircle(this.f28416d.centerX(), this.f28416d.centerY(), this.q, this.f28419g);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        d();
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(i2, i3, i4, i5);
        d();
    }

    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
        super.setPaddingRelative(i2, i3, i4, i5);
        d();
    }

    public int getBorderColor() {
        return this.i;
    }

    public void setBorderColor(int i2) {
        if (i2 != this.i) {
            this.i = i2;
            this.f28419g.setColor(this.i);
            invalidate();
        }
    }

    @Deprecated
    public void setBorderColorResource(int i2) {
        setBorderColor(getContext().getResources().getColor(i2));
    }

    @Deprecated
    public int getFillColor() {
        return this.k;
    }

    @Deprecated
    public void setFillColor(int i2) {
        if (i2 != this.k) {
            this.k = i2;
            this.h.setColor(i2);
            invalidate();
        }
    }

    @Deprecated
    public void setFillColorResource(int i2) {
        setFillColor(getContext().getResources().getColor(i2));
    }

    public int getBorderWidth() {
        return this.j;
    }

    public void setBorderWidth(int i2) {
        if (i2 != this.j) {
            this.j = i2;
            d();
        }
    }

    public void setBorderOverlay(boolean z) {
        if (z != this.u) {
            this.u = z;
            d();
        }
    }

    public void setDisableCircularTransformation(boolean z) {
        if (this.v != z) {
            this.v = z;
            c();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        c();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        c();
    }

    public void setImageResource(int i2) {
        super.setImageResource(i2);
        c();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        c();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.r) {
            this.r = colorFilter;
            b();
            invalidate();
        }
    }

    public ColorFilter getColorFilter() {
        return this.r;
    }

    private void b() {
        Paint paint = this.f28418f;
        if (paint != null) {
            paint.setColorFilter(this.r);
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
                bitmap = Bitmap.createBitmap(2, 2, f28414b);
            } else {
                bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), f28414b);
            }
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private void c() {
        if (this.v) {
            this.l = null;
        } else {
            this.l = a(getDrawable());
        }
        d();
    }

    private void d() {
        if (!this.s) {
            this.t = true;
        } else if (getWidth() != 0 || getHeight() != 0) {
            Bitmap bitmap = this.l;
            if (bitmap == null) {
                invalidate();
                return;
            }
            this.m = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            this.f28418f.setAntiAlias(true);
            this.f28418f.setShader(this.m);
            this.f28419g.setStyle(Paint.Style.STROKE);
            this.f28419g.setAntiAlias(true);
            this.f28419g.setColor(this.i);
            this.f28419g.setStrokeWidth((float) this.j);
            this.h.setStyle(Paint.Style.FILL);
            this.h.setAntiAlias(true);
            this.h.setColor(this.k);
            this.o = this.l.getHeight();
            this.n = this.l.getWidth();
            this.f28416d.set(e());
            this.q = Math.min((this.f28416d.height() - ((float) this.j)) / 2.0f, (this.f28416d.width() - ((float) this.j)) / 2.0f);
            this.f28415c.set(this.f28416d);
            if (!this.u) {
                int i2 = this.j;
                if (i2 > 0) {
                    this.f28415c.inset(((float) i2) - 1.0f, ((float) i2) - 1.0f);
                }
            }
            this.p = Math.min(this.f28415c.height() / 2.0f, this.f28415c.width() / 2.0f);
            b();
            f();
            invalidate();
        }
    }

    private RectF e() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int min = Math.min(width, height);
        float paddingLeft = ((float) getPaddingLeft()) + (((float) (width - min)) / 2.0f);
        float paddingTop = ((float) getPaddingTop()) + (((float) (height - min)) / 2.0f);
        float f2 = (float) min;
        return new RectF(paddingLeft, paddingTop, paddingLeft + f2, f2 + paddingTop);
    }

    private void f() {
        float f2;
        float f3;
        this.f28417e.set((Matrix) null);
        float height = ((float) this.n) * this.f28415c.height();
        float width = this.f28415c.width() * ((float) this.o);
        float f4 = BitmapDescriptorFactory.HUE_RED;
        if (height > width) {
            f3 = this.f28415c.height() / ((float) this.o);
            f2 = (this.f28415c.width() - (((float) this.n) * f3)) * 0.5f;
        } else {
            f3 = this.f28415c.width() / ((float) this.n);
            f4 = (this.f28415c.height() - (((float) this.o) * f3)) * 0.5f;
            f2 = BitmapDescriptorFactory.HUE_RED;
        }
        this.f28417e.setScale(f3, f3);
        this.f28417e.postTranslate(((float) ((int) (f2 + 0.5f))) + this.f28415c.left, ((float) ((int) (f4 + 0.5f))) + this.f28415c.top);
        this.m.setLocalMatrix(this.f28417e);
    }
}
