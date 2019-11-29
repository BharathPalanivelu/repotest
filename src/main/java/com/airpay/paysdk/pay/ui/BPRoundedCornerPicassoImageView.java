package com.airpay.paysdk.pay.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.airpay.paysdk.base.ui.weidget.g;
import com.airpay.paysdk.c;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class BPRoundedCornerPicassoImageView extends g {

    /* renamed from: c  reason: collision with root package name */
    private static final Bitmap.Config f4263c = Bitmap.Config.ARGB_8888;

    /* renamed from: a  reason: collision with root package name */
    private int f4264a = 0;

    /* renamed from: b  reason: collision with root package name */
    private RectF f4265b;

    /* renamed from: d  reason: collision with root package name */
    private final RectF f4266d = new RectF();

    /* renamed from: e  reason: collision with root package name */
    private final Matrix f4267e = new Matrix();

    /* renamed from: f  reason: collision with root package name */
    private final Paint f4268f = new Paint();

    /* renamed from: g  reason: collision with root package name */
    private int f4269g = -1;
    private BitmapShader h;

    public BPRoundedCornerPicassoImageView(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public BPRoundedCornerPicassoImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.k.BPRoundedCornerPicassoImageView);
            this.f4264a = obtainStyledAttributes.getDimensionPixelSize(c.k.BPRoundedCornerPicassoImageView_corner_radius, 0);
            obtainStyledAttributes.recycle();
        }
        this.f4265b = new RectF();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            int hashCode = drawable.hashCode();
            if (this.f4269g != hashCode) {
                this.f4269g = hashCode;
                setup(a(getDrawable()));
            }
            a(canvas, this.f4268f);
        }
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, Paint paint) {
        RectF rectF = this.f4265b;
        rectF.left = BitmapDescriptorFactory.HUE_RED;
        rectF.top = BitmapDescriptorFactory.HUE_RED;
        rectF.right = (float) canvas.getWidth();
        this.f4265b.bottom = (float) canvas.getHeight();
        RectF rectF2 = this.f4265b;
        int i = this.f4264a;
        canvas.drawRoundRect(rectF2, (float) i, (float) i, paint);
    }

    /* access modifiers changed from: protected */
    public void setup(Bitmap bitmap) {
        if (bitmap != null) {
            this.h = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            this.f4268f.setAntiAlias(true);
            this.f4268f.setShader(this.h);
            this.f4266d.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) getWidth(), (float) getHeight());
            a(bitmap.getWidth(), bitmap.getHeight());
        }
    }

    private void a(int i, int i2) {
        float f2;
        float f3;
        this.f4267e.set((Matrix) null);
        float f4 = (float) i;
        float f5 = (float) i2;
        float f6 = BitmapDescriptorFactory.HUE_RED;
        if (this.f4266d.height() * f4 > this.f4266d.width() * f5) {
            f3 = this.f4266d.height() / f5;
            f2 = (this.f4266d.width() - (f4 * f3)) * 0.5f;
        } else {
            f3 = this.f4266d.width() / f4;
            f6 = (this.f4266d.height() - (f5 * f3)) * 0.5f;
            f2 = BitmapDescriptorFactory.HUE_RED;
        }
        this.f4267e.setScale(f3, f3);
        this.f4267e.postTranslate(((float) ((int) (f2 + 0.5f))) + this.f4266d.left, ((float) ((int) (f6 + 0.5f))) + this.f4266d.top);
        this.h.setLocalMatrix(this.f4267e);
    }

    public void setRadius(int i) {
        this.f4264a = i;
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
                bitmap = Bitmap.createBitmap(2, 2, f4263c);
            } else {
                bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), f4263c);
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
}
