package com.shopee.live.livestreaming.ui.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class e extends Animation {

    /* renamed from: a  reason: collision with root package name */
    private int f29313a;

    /* renamed from: b  reason: collision with root package name */
    private int f29314b;

    /* renamed from: c  reason: collision with root package name */
    private int f29315c;

    /* renamed from: d  reason: collision with root package name */
    private int f29316d;

    /* renamed from: e  reason: collision with root package name */
    private View f29317e;

    /* renamed from: f  reason: collision with root package name */
    private a f29318f;

    public interface a {
        void a(float f2);
    }

    public boolean willChangeBounds() {
        return true;
    }

    public e(View view, int i, int i2, int i3, int i4) {
        this.f29317e = view;
        this.f29313a = i;
        this.f29314b = i2;
        this.f29315c = i3;
        this.f29316d = i4;
    }

    public e a(long j) {
        setDuration(j);
        return this;
    }

    public e a(a aVar) {
        this.f29318f = aVar;
        return this;
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float f2, Transformation transformation) {
        if (this.f29313a >= 0 && this.f29314b >= 0) {
            ViewGroup.LayoutParams layoutParams = this.f29317e.getLayoutParams();
            int i = this.f29313a;
            layoutParams.width = (int) (((float) i) + (((float) (this.f29314b - i)) * f2));
        }
        if (this.f29315c >= 0 && this.f29316d >= 0) {
            ViewGroup.LayoutParams layoutParams2 = this.f29317e.getLayoutParams();
            int i2 = this.f29315c;
            layoutParams2.height = (int) (((float) i2) + (((float) (this.f29316d - i2)) * f2));
        }
        a aVar = this.f29318f;
        if (aVar != null) {
            aVar.a(f2);
        }
        this.f29317e.requestLayout();
    }

    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
    }
}
