package com.shopee.feeds.feedlibrary.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MyTwoScrollView extends com.e.a.a.a {

    /* renamed from: a  reason: collision with root package name */
    a f28468a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f28469b = false;

    public interface a {
        void a();
    }

    public MyTwoScrollView(Context context) {
        super(context);
    }

    public MyTwoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MyTwoScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f28469b = true;
        } else if (action != 1) {
            if (action == 2) {
                this.f28469b = false;
            }
        } else if (this.f28469b) {
            a aVar = this.f28468a;
            if (aVar != null) {
                aVar.a();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void setOnDownUpCallBack(a aVar) {
        this.f28468a = aVar;
    }
}
