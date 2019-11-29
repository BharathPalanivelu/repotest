package com.garena.android.uikit.a;

import android.content.Context;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class d extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private boolean f7726a = false;

    public d(Context context) {
        super(context);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            return !this.f7726a && super.onInterceptTouchEvent(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public void setScrollLock(boolean z) {
        this.f7726a = z;
    }
}
