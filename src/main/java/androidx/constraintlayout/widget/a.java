package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import androidx.constraintlayout.a.a.b;
import androidx.constraintlayout.widget.f;

public class a extends b {

    /* renamed from: f  reason: collision with root package name */
    private int f1467f;

    /* renamed from: g  reason: collision with root package name */
    private int f1468g;
    private b h;

    public a(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public int getType() {
        return this.f1467f;
    }

    public void setType(int i) {
        this.f1467f = i;
        this.f1468g = i;
        if (Build.VERSION.SDK_INT < 17) {
            int i2 = this.f1467f;
            if (i2 == 5) {
                this.f1468g = 0;
            } else if (i2 == 6) {
                this.f1468g = 1;
            }
        } else {
            if (1 == getResources().getConfiguration().getLayoutDirection()) {
                int i3 = this.f1467f;
                if (i3 == 5) {
                    this.f1468g = 1;
                } else if (i3 == 6) {
                    this.f1468g = 0;
                }
            } else {
                int i4 = this.f1467f;
                if (i4 == 5) {
                    this.f1468g = 0;
                } else if (i4 == 6) {
                    this.f1468g = 1;
                }
            }
        }
        this.h.a(this.f1468g);
    }

    /* access modifiers changed from: protected */
    public void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        this.h = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, f.b.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == f.b.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == f.b.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.h.a(obtainStyledAttributes.getBoolean(index, true));
                }
            }
        }
        this.f1472d = this.h;
        b();
    }

    public void setAllowsGoneWidget(boolean z) {
        this.h.a(z);
    }

    public boolean a() {
        return this.h.b();
    }
}
