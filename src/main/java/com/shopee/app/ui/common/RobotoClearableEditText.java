package com.shopee.app.ui.common;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.content.b;
import com.devspark.robototextview.widget.RobotoEditText;
import com.shopee.id.R;

public final class RobotoClearableEditText extends RobotoEditText {

    /* renamed from: a  reason: collision with root package name */
    public static final a f20994a = new a((g) null);

    /* renamed from: b  reason: collision with root package name */
    private boolean f20995b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f20996c;

    public RobotoClearableEditText(Context context) {
        super(context);
    }

    public RobotoClearableEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RobotoClearableEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public final void setClearButtonEnabled(boolean z) {
        this.f20995b = z;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0014, code lost:
        if (r0.f20995b != false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onTextChanged(java.lang.CharSequence r1, int r2, int r3, int r4) {
        /*
            r0 = this;
            super.onTextChanged(r1, r2, r3, r4)
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0017
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x000f
            r1 = 1
            goto L_0x0010
        L_0x000f:
            r1 = 0
        L_0x0010:
            if (r1 == 0) goto L_0x0017
            boolean r1 = r0.f20995b
            if (r1 == 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r2 = 0
        L_0x0018:
            r0.a((boolean) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.common.RobotoClearableEditText.onTextChanged(java.lang.CharSequence, int, int, int):void");
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() == 0) {
            this.f20996c = a(motionEvent);
        } else if (motionEvent != null && motionEvent.getAction() == 1 && this.f20996c && a(motionEvent)) {
            b();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private final void a(boolean z) {
        if (a() != z) {
            Drawable a2 = z ? b.a(getContext(), (int) R.drawable.com_garena_shopee_ic_clear) : null;
            if (a2 != null) {
                int min = Math.min(a2.getIntrinsicHeight(), (getHeight() - getPaddingBottom()) - getPaddingTop());
                a2.setBounds(0, 0, min, min);
            }
            setCompoundDrawables((Drawable) null, (Drawable) null, a2, (Drawable) null);
        }
    }

    private final boolean a(MotionEvent motionEvent) {
        if (motionEvent != null && a() && motionEvent.getX() >= ((float) (getWidth() - getTotalPaddingRight()))) {
            return true;
        }
        return false;
    }

    private final boolean a() {
        return getCompoundDrawables()[2] != null;
    }

    private final void b() {
        setText("");
    }
}
