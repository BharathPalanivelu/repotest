package com.shopee.feeds.feedlibrary.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.core.g.i;
import java.util.ArrayList;
import java.util.List;

public class b extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private List<View> f28516a;

    public b(Context context) {
        this(context, (AttributeSet) null);
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28516a = new ArrayList();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (i.a(motionEvent) == 0) {
            a(rawX, rawY, this);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private void a(int i, int i2, View view) {
        if (a(view)) {
            return;
        }
        if (view instanceof ViewGroup) {
            int[] iArr = new int[2];
            boolean z = false;
            int i3 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i3 >= viewGroup.getChildCount()) {
                    break;
                }
                View childAt = viewGroup.getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    childAt.getLocationOnScreen(iArr);
                    if (iArr[0] <= i && iArr[0] + childAt.getWidth() >= i && iArr[1] <= i2 && iArr[1] + childAt.getHeight() >= i2) {
                        if (!a(childAt)) {
                            if (childAt instanceof ViewGroup) {
                                a(i, i2, childAt);
                                return;
                            } else if (!(childAt instanceof EditText)) {
                                a();
                                return;
                            } else {
                                z = true;
                            }
                        } else {
                            return;
                        }
                    }
                }
                i3++;
            }
            if (!z) {
                a();
            }
        } else if (!(view instanceof EditText)) {
            a();
        }
    }

    private void a() {
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 2);
    }

    private boolean a(View view) {
        List<View> list = this.f28516a;
        if (!(list == null || view == null)) {
            for (View next : list) {
                if (next != null && next == view) {
                    return true;
                }
            }
        }
        return false;
    }
}
