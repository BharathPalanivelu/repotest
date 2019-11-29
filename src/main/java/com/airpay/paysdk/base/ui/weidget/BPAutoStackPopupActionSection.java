package com.airpay.paysdk.base.ui.weidget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.airpay.paysdk.c;
import java.util.ArrayList;
import java.util.List;

public class BPAutoStackPopupActionSection extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private final List<a> f3865a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final List<a> f3866b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private boolean f3867c = true;

    public BPAutoStackPopupActionSection(Context context) {
        super(context);
    }

    public BPAutoStackPopupActionSection(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @TargetApi(11)
    public BPAutoStackPopupActionSection(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        super.onMeasure(i, i2);
        if (getOrientation() == 0 && childCount > 1 && this.f3867c) {
            int i3 = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                measureChild(childAt, View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                i3 = i3 + childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            }
            if (i3 > (getMeasuredWidth() - getPaddingRight()) - getPaddingLeft()) {
                setOrientation(1);
                a();
            }
            super.onMeasure(i, i2);
            this.f3867c = false;
        }
    }

    public void a(CharSequence charSequence, boolean z, View.OnClickListener onClickListener) {
        if (z) {
            this.f3865a.add(new a(charSequence, onClickListener));
        } else {
            this.f3866b.add(new a(charSequence, onClickListener));
        }
        this.f3867c = true;
    }

    public void a() {
        removeAllViews();
        if (getOrientation() == 1) {
            a(this.f3865a);
            a(this.f3866b);
            return;
        }
        a(this.f3866b);
        a(this.f3865a);
    }

    private void a(List<a> list) {
        if (list != null && !list.isEmpty()) {
            LayoutInflater from = LayoutInflater.from(getContext());
            for (a next : list) {
                View inflate = from.inflate(c.h.com_garena_beepay_popup_action, this, false);
                Button button = (Button) inflate.findViewById(c.f.com_garena_beepay_btn_action);
                button.setText(next.f3868a);
                button.setOnClickListener(next.f3869b);
                addView(inflate);
            }
        }
    }

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public CharSequence f3868a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public View.OnClickListener f3869b;

        public a(CharSequence charSequence, View.OnClickListener onClickListener) {
            this.f3868a = charSequence;
            this.f3869b = onClickListener;
        }
    }
}
