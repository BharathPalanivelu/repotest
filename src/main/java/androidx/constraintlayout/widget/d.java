package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.f;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class d extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    c f1485a;

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    /* renamed from: a */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    public static class a extends ConstraintLayout.a {
        public float an;
        public boolean ao;
        public float ap;
        public float aq;
        public float ar;
        public float as;
        public float at;
        public float au;
        public float av;
        public float aw;
        public float ax;
        public float ay;
        public float az;

        public a(int i, int i2) {
            super(i, i2);
            this.an = 1.0f;
            this.ao = false;
            this.ap = BitmapDescriptorFactory.HUE_RED;
            this.aq = BitmapDescriptorFactory.HUE_RED;
            this.ar = BitmapDescriptorFactory.HUE_RED;
            this.as = BitmapDescriptorFactory.HUE_RED;
            this.at = 1.0f;
            this.au = 1.0f;
            this.av = BitmapDescriptorFactory.HUE_RED;
            this.aw = BitmapDescriptorFactory.HUE_RED;
            this.ax = BitmapDescriptorFactory.HUE_RED;
            this.ay = BitmapDescriptorFactory.HUE_RED;
            this.az = BitmapDescriptorFactory.HUE_RED;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.an = 1.0f;
            this.ao = false;
            this.ap = BitmapDescriptorFactory.HUE_RED;
            this.aq = BitmapDescriptorFactory.HUE_RED;
            this.ar = BitmapDescriptorFactory.HUE_RED;
            this.as = BitmapDescriptorFactory.HUE_RED;
            this.at = 1.0f;
            this.au = 1.0f;
            this.av = BitmapDescriptorFactory.HUE_RED;
            this.aw = BitmapDescriptorFactory.HUE_RED;
            this.ax = BitmapDescriptorFactory.HUE_RED;
            this.ay = BitmapDescriptorFactory.HUE_RED;
            this.az = BitmapDescriptorFactory.HUE_RED;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.b.ConstraintSet);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == f.b.ConstraintSet_android_alpha) {
                    this.an = obtainStyledAttributes.getFloat(index, this.an);
                } else if (index == f.b.ConstraintSet_android_elevation) {
                    this.ap = obtainStyledAttributes.getFloat(index, this.ap);
                    this.ao = true;
                } else if (index == f.b.ConstraintSet_android_rotationX) {
                    this.ar = obtainStyledAttributes.getFloat(index, this.ar);
                } else if (index == f.b.ConstraintSet_android_rotationY) {
                    this.as = obtainStyledAttributes.getFloat(index, this.as);
                } else if (index == f.b.ConstraintSet_android_rotation) {
                    this.aq = obtainStyledAttributes.getFloat(index, this.aq);
                } else if (index == f.b.ConstraintSet_android_scaleX) {
                    this.at = obtainStyledAttributes.getFloat(index, this.at);
                } else if (index == f.b.ConstraintSet_android_scaleY) {
                    this.au = obtainStyledAttributes.getFloat(index, this.au);
                } else if (index == f.b.ConstraintSet_android_transformPivotX) {
                    this.av = obtainStyledAttributes.getFloat(index, this.av);
                } else if (index == f.b.ConstraintSet_android_transformPivotY) {
                    this.aw = obtainStyledAttributes.getFloat(index, this.aw);
                } else if (index == f.b.ConstraintSet_android_translationX) {
                    this.ax = obtainStyledAttributes.getFloat(index, this.ax);
                } else if (index == f.b.ConstraintSet_android_translationY) {
                    this.ay = obtainStyledAttributes.getFloat(index, this.ay);
                } else if (index == f.b.ConstraintSet_android_translationZ) {
                    this.ax = obtainStyledAttributes.getFloat(index, this.az);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.a(layoutParams);
    }

    public c getConstraintSet() {
        if (this.f1485a == null) {
            this.f1485a = new c();
        }
        this.f1485a.a(this);
        return this.f1485a;
    }
}
