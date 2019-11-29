package com.shopee.app.ui.common;

import android.content.Context;
import android.view.MotionEvent;
import androidx.drawerlayout.widget.DrawerLayout;

public class k extends DrawerLayout {
    public k(Context context) {
        super(context);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Throwable unused) {
            return false;
        }
    }
}
