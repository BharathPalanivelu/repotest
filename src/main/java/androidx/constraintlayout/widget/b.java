package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.a.a.j;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.f;
import java.util.Arrays;

public abstract class b extends View {

    /* renamed from: a  reason: collision with root package name */
    protected int[] f1469a = new int[32];

    /* renamed from: b  reason: collision with root package name */
    protected int f1470b;

    /* renamed from: c  reason: collision with root package name */
    protected Context f1471c;

    /* renamed from: d  reason: collision with root package name */
    protected j f1472d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f1473e = false;

    /* renamed from: f  reason: collision with root package name */
    private String f1474f;

    public void b(ConstraintLayout constraintLayout) {
    }

    public void c(ConstraintLayout constraintLayout) {
    }

    public void onDraw(Canvas canvas) {
    }

    public b(Context context) {
        super(context);
        this.f1471c = context;
        a((AttributeSet) null);
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1471c = context;
        a(attributeSet);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1471c = context;
        a(attributeSet);
    }

    /* access modifiers changed from: protected */
    public void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, f.b.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == f.b.ConstraintLayout_Layout_constraint_referenced_ids) {
                    this.f1474f = obtainStyledAttributes.getString(index);
                    setIds(this.f1474f);
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f1469a, this.f1470b);
    }

    public void setReferencedIds(int[] iArr) {
        this.f1470b = 0;
        for (int tag : iArr) {
            setTag(tag, (Object) null);
        }
    }

    public void setTag(int i, Object obj) {
        int i2 = this.f1470b + 1;
        int[] iArr = this.f1469a;
        if (i2 > iArr.length) {
            this.f1469a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f1469a;
        int i3 = this.f1470b;
        iArr2[i3] = i;
        this.f1470b = i3 + 1;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f1473e) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void b() {
        if (this.f1472d != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.a) {
                ((ConstraintLayout.a) layoutParams).al = this.f1472d;
            }
        }
    }

    private void a(String str) {
        int i;
        if (str != null && this.f1471c != null) {
            String trim = str.trim();
            try {
                i = f.a.class.getField(trim).getInt((Object) null);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0) {
                i = this.f1471c.getResources().getIdentifier(trim, "id", this.f1471c.getPackageName());
            }
            if (i == 0 && isInEditMode() && (getParent() instanceof ConstraintLayout)) {
                Object a2 = ((ConstraintLayout) getParent()).a(0, (Object) trim);
                if (a2 != null && (a2 instanceof Integer)) {
                    i = ((Integer) a2).intValue();
                }
            }
            if (i != 0) {
                setTag(i, (Object) null);
                return;
            }
            Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
        }
    }

    private void setIds(String str) {
        if (str != null) {
            int i = 0;
            while (true) {
                int indexOf = str.indexOf(44, i);
                if (indexOf == -1) {
                    a(str.substring(i));
                    return;
                } else {
                    a(str.substring(i, indexOf));
                    i = indexOf + 1;
                }
            }
        }
    }

    public void a(ConstraintLayout constraintLayout) {
        if (isInEditMode()) {
            setIds(this.f1474f);
        }
        j jVar = this.f1472d;
        if (jVar != null) {
            jVar.K();
            for (int i = 0; i < this.f1470b; i++) {
                View a2 = constraintLayout.a(this.f1469a[i]);
                if (a2 != null) {
                    this.f1472d.b(constraintLayout.a(a2));
                }
            }
        }
    }
}
