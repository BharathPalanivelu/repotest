package com.shopee.feeds.feedlibrary.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.Layout;
import android.util.AttributeSet;
import com.devspark.robototextview.widget.RobotoTextView;

public class CustomTextView extends RobotoTextView {

    /* renamed from: a  reason: collision with root package name */
    private Paint f28432a;

    /* renamed from: b  reason: collision with root package name */
    private int f28433b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f28434c = -65536;

    public CustomTextView(Context context) {
        super(context);
        a();
    }

    private void a() {
        this.f28432a = new Paint();
        this.f28432a.setColor(this.f28434c);
    }

    public CustomTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public CustomTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        RectF rectF;
        Layout layout = getLayout();
        float measureText = getPaint().measureText("\n");
        int i = 0;
        int i2 = 0;
        while (i < layout.getLineCount()) {
            int lineEnd = layout.getLineEnd(i);
            if (getText().toString().substring(i2, lineEnd).contains("\n")) {
                rectF = new RectF((float) (0 - getPaddingLeft()), (float) layout.getLineTop(i), (layout.getLineWidth(i) - measureText) + ((float) getPaddingRight()), (float) layout.getLineBottom(i));
            } else {
                rectF = new RectF((float) (0 - getPaddingLeft()), (float) layout.getLineTop(i), layout.getLineWidth(i) + ((float) getPaddingRight()), (float) layout.getLineBottom(i));
            }
            canvas.drawRect(rectF, this.f28432a);
            i++;
            i2 = lineEnd;
        }
        super.onDraw(canvas);
    }

    public int getTextBackgroundColor() {
        return this.f28434c;
    }

    public void setTextBackgroundColor(int i) {
        this.f28434c = i;
        this.f28432a.setColor(i);
        invalidate();
    }
}
