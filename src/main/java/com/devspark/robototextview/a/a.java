package com.devspark.robototextview.a;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.devspark.robototextview.b;

public class a extends MetricAffectingSpan {

    /* renamed from: a  reason: collision with root package name */
    private final Typeface f6630a;

    public a(Context context, int i) {
        this.f6630a = b.a(context, i);
    }

    public void updateDrawState(TextPaint textPaint) {
        updateMeasureState(textPaint);
    }

    public void updateMeasureState(TextPaint textPaint) {
        b.a((Paint) textPaint, this.f6630a);
    }
}
