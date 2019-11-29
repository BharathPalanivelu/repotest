package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.g.w;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.a;

public class SnackbarContentLayout extends LinearLayout implements a {

    /* renamed from: a  reason: collision with root package name */
    private TextView f13458a;

    /* renamed from: b  reason: collision with root package name */
    private Button f13459b;

    /* renamed from: c  reason: collision with root package name */
    private int f13460c;

    /* renamed from: d  reason: collision with root package name */
    private int f13461d;

    public SnackbarContentLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.SnackbarLayout);
        this.f13460c = obtainStyledAttributes.getDimensionPixelSize(a.k.SnackbarLayout_android_maxWidth, -1);
        this.f13461d = obtainStyledAttributes.getDimensionPixelSize(a.k.SnackbarLayout_maxActionInlineWidth, -1);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f13458a = (TextView) findViewById(a.f.snackbar_text);
        this.f13459b = (Button) findViewById(a.f.snackbar_action);
    }

    public TextView getMessageView() {
        return this.f13458a;
    }

    public Button getActionView() {
        return this.f13459b;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0053, code lost:
        if (a(1, r0, r0 - r1) != false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005e, code lost:
        if (a(0, r0, r0) != false) goto L_0x0062;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            super.onMeasure(r8, r9)
            int r0 = r7.f13460c
            if (r0 <= 0) goto L_0x0018
            int r0 = r7.getMeasuredWidth()
            int r1 = r7.f13460c
            if (r0 <= r1) goto L_0x0018
            r8 = 1073741824(0x40000000, float:2.0)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            super.onMeasure(r8, r9)
        L_0x0018:
            android.content.res.Resources r0 = r7.getResources()
            int r1 = com.google.android.material.a.d.design_snackbar_padding_vertical_2lines
            int r0 = r0.getDimensionPixelSize(r1)
            android.content.res.Resources r1 = r7.getResources()
            int r2 = com.google.android.material.a.d.design_snackbar_padding_vertical
            int r1 = r1.getDimensionPixelSize(r2)
            android.widget.TextView r2 = r7.f13458a
            android.text.Layout r2 = r2.getLayout()
            int r2 = r2.getLineCount()
            r3 = 0
            r4 = 1
            if (r2 <= r4) goto L_0x003c
            r2 = 1
            goto L_0x003d
        L_0x003c:
            r2 = 0
        L_0x003d:
            if (r2 == 0) goto L_0x0056
            int r5 = r7.f13461d
            if (r5 <= 0) goto L_0x0056
            android.widget.Button r5 = r7.f13459b
            int r5 = r5.getMeasuredWidth()
            int r6 = r7.f13461d
            if (r5 <= r6) goto L_0x0056
            int r1 = r0 - r1
            boolean r0 = r7.a((int) r4, (int) r0, (int) r1)
            if (r0 == 0) goto L_0x0061
            goto L_0x0062
        L_0x0056:
            if (r2 == 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            r0 = r1
        L_0x005a:
            boolean r0 = r7.a((int) r3, (int) r0, (int) r0)
            if (r0 == 0) goto L_0x0061
            goto L_0x0062
        L_0x0061:
            r4 = 0
        L_0x0062:
            if (r4 == 0) goto L_0x0067
            super.onMeasure(r8, r9)
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.SnackbarContentLayout.onMeasure(int, int):void");
    }

    private boolean a(int i, int i2, int i3) {
        boolean z;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        } else {
            z = false;
        }
        if (this.f13458a.getPaddingTop() == i2 && this.f13458a.getPaddingBottom() == i3) {
            return z;
        }
        a((View) this.f13458a, i2, i3);
        return true;
    }

    private static void a(View view, int i, int i2) {
        if (w.v(view)) {
            w.b(view, w.j(view), i, w.k(view), i2);
        } else {
            view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
        }
    }

    public void a(int i, int i2) {
        this.f13458a.setAlpha(BitmapDescriptorFactory.HUE_RED);
        long j = (long) i2;
        long j2 = (long) i;
        this.f13458a.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
        if (this.f13459b.getVisibility() == 0) {
            this.f13459b.setAlpha(BitmapDescriptorFactory.HUE_RED);
            this.f13459b.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
        }
    }

    public void b(int i, int i2) {
        this.f13458a.setAlpha(1.0f);
        long j = (long) i2;
        long j2 = (long) i;
        this.f13458a.animate().alpha(BitmapDescriptorFactory.HUE_RED).setDuration(j).setStartDelay(j2).start();
        if (this.f13459b.getVisibility() == 0) {
            this.f13459b.setAlpha(1.0f);
            this.f13459b.animate().alpha(BitmapDescriptorFactory.HUE_RED).setDuration(j).setStartDelay(j2).start();
        }
    }
}
