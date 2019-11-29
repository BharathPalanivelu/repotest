package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.a;
import androidx.core.g.w;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

class s extends p {

    /* renamed from: a  reason: collision with root package name */
    private final SeekBar f1239a;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f1240b;

    /* renamed from: c  reason: collision with root package name */
    private ColorStateList f1241c = null;

    /* renamed from: d  reason: collision with root package name */
    private PorterDuff.Mode f1242d = null;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1243e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1244f = false;

    s(SeekBar seekBar) {
        super(seekBar);
        this.f1239a = seekBar;
    }

    /* access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        ar a2 = ar.a(this.f1239a.getContext(), attributeSet, a.j.AppCompatSeekBar, i, 0);
        Drawable b2 = a2.b(a.j.AppCompatSeekBar_android_thumb);
        if (b2 != null) {
            this.f1239a.setThumb(b2);
        }
        a(a2.a(a.j.AppCompatSeekBar_tickMark));
        if (a2.g(a.j.AppCompatSeekBar_tickMarkTintMode)) {
            this.f1242d = z.a(a2.a(a.j.AppCompatSeekBar_tickMarkTintMode, -1), this.f1242d);
            this.f1244f = true;
        }
        if (a2.g(a.j.AppCompatSeekBar_tickMarkTint)) {
            this.f1241c = a2.e(a.j.AppCompatSeekBar_tickMarkTint);
            this.f1243e = true;
        }
        a2.a();
        d();
    }

    /* access modifiers changed from: package-private */
    public void a(Drawable drawable) {
        Drawable drawable2 = this.f1240b;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f1240b = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1239a);
            androidx.core.graphics.drawable.a.b(drawable, w.g(this.f1239a));
            if (drawable.isStateful()) {
                drawable.setState(this.f1239a.getDrawableState());
            }
            d();
        }
        this.f1239a.invalidate();
    }

    private void d() {
        if (this.f1240b == null) {
            return;
        }
        if (this.f1243e || this.f1244f) {
            this.f1240b = androidx.core.graphics.drawable.a.g(this.f1240b.mutate());
            if (this.f1243e) {
                androidx.core.graphics.drawable.a.a(this.f1240b, this.f1241c);
            }
            if (this.f1244f) {
                androidx.core.graphics.drawable.a.a(this.f1240b, this.f1242d);
            }
            if (this.f1240b.isStateful()) {
                this.f1240b.setState(this.f1239a.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        Drawable drawable = this.f1240b;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        Drawable drawable = this.f1240b;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1239a.getDrawableState())) {
            this.f1239a.invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Canvas canvas) {
        if (this.f1240b != null) {
            int max = this.f1239a.getMax();
            int i = 1;
            if (max > 1) {
                int intrinsicWidth = this.f1240b.getIntrinsicWidth();
                int intrinsicHeight = this.f1240b.getIntrinsicHeight();
                int i2 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i = intrinsicHeight / 2;
                }
                this.f1240b.setBounds(-i2, -i, i2, i);
                float width = ((float) ((this.f1239a.getWidth() - this.f1239a.getPaddingLeft()) - this.f1239a.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.f1239a.getPaddingLeft(), (float) (this.f1239a.getHeight() / 2));
                for (int i3 = 0; i3 <= max; i3++) {
                    this.f1240b.draw(canvas);
                    canvas.translate(width, BitmapDescriptorFactory.HUE_RED);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
