package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.appcompat.a;

public class r extends RatingBar {

    /* renamed from: a  reason: collision with root package name */
    private final p f1238a;

    public r(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0012a.ratingBarStyle);
    }

    public r(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1238a = new p(this);
        this.f1238a.a(attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap a2 = this.f1238a.a();
        if (a2 != null) {
            setMeasuredDimension(View.resolveSizeAndState(a2.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
