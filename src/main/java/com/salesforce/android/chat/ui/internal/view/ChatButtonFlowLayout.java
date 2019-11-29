package com.salesforce.android.chat.ui.internal.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ChatButtonFlowLayout extends ViewGroup {
    public ChatButtonFlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        boolean z;
        int i3 = i;
        int i4 = i2;
        int size = View.MeasureSpec.getSize(i) - getPaddingRight();
        boolean z2 = View.MeasureSpec.getMode(i) != 0;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i5 = 0;
        boolean z3 = false;
        int i6 = 0;
        int i7 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            measureChild(childAt, i3, i4);
            ChatButtonLayoutParams chatButtonLayoutParams = (ChatButtonLayoutParams) childAt.getLayoutParams();
            if (!z2 || childAt.getMeasuredWidth() + paddingLeft <= size) {
                z = false;
            } else {
                paddingTop += i7;
                i6 = Math.max(i6, paddingLeft);
                paddingLeft = getPaddingLeft();
                i7 = 0;
                z = true;
            }
            i7 = Math.max(i7, childAt.getMeasuredHeight());
            int unused = chatButtonLayoutParams.x = paddingLeft;
            int unused2 = chatButtonLayoutParams.y = paddingTop;
            paddingLeft += childAt.getMeasuredWidth();
            i5++;
            z3 = z;
        }
        if (!z3) {
            i6 = Math.max(i6, paddingLeft);
        }
        setMeasuredDimension(resolveSize(i6 + getPaddingRight(), i3), resolveSize(paddingTop + i7 + getPaddingBottom(), i4));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            ChatButtonLayoutParams chatButtonLayoutParams = (ChatButtonLayoutParams) childAt.getLayoutParams();
            childAt.layout(chatButtonLayoutParams.x, chatButtonLayoutParams.y, chatButtonLayoutParams.x + childAt.getMeasuredWidth(), chatButtonLayoutParams.y + childAt.getMeasuredHeight());
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ChatButtonLayoutParams;
    }

    /* access modifiers changed from: protected */
    public ChatButtonLayoutParams generateDefaultLayoutParams() {
        return new ChatButtonLayoutParams(-2, -2);
    }

    public ChatButtonLayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ChatButtonLayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ChatButtonLayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ChatButtonLayoutParams(layoutParams.width, layoutParams.height);
    }

    private static class ChatButtonLayoutParams extends ViewGroup.LayoutParams {
        /* access modifiers changed from: private */
        public int x;
        /* access modifiers changed from: private */
        public int y;

        ChatButtonLayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        ChatButtonLayoutParams(int i, int i2) {
            super(i, i2);
        }
    }
}
