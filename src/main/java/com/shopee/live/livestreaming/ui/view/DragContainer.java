package com.shopee.live.livestreaming.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.g.c;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class DragContainer extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    protected float f29147a;

    /* renamed from: b  reason: collision with root package name */
    protected float f29148b;

    /* renamed from: c  reason: collision with root package name */
    protected float f29149c;

    /* renamed from: d  reason: collision with root package name */
    protected float f29150d;

    /* renamed from: e  reason: collision with root package name */
    protected c f29151e;

    public DragContainer(Context context) {
        super(context);
        a();
    }

    public DragContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public DragContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.f29151e = new c(getContext(), new GestureDetector.SimpleOnGestureListener() {
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return true;
            }

            public boolean onDown(MotionEvent motionEvent) {
                DragContainer.this.f29147a = motionEvent.getX();
                DragContainer.this.f29148b = motionEvent.getY();
                DragContainer.this.f29149c = (motionEvent.getRawX() - motionEvent.getX()) - DragContainer.this.getX();
                DragContainer.this.f29150d = (motionEvent.getRawY() - motionEvent.getY()) - DragContainer.this.getY();
                return true;
            }

            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                float rawX = (motionEvent2.getRawX() - DragContainer.this.f29147a) - DragContainer.this.f29149c;
                float rawY = (motionEvent2.getRawY() - DragContainer.this.f29148b) - DragContainer.this.f29150d;
                float width = (float) (((View) DragContainer.this.getParent()).getWidth() - DragContainer.this.getMeasuredWidth());
                float height = (float) (((View) DragContainer.this.getParent()).getHeight() - DragContainer.this.getMeasuredHeight());
                if (rawX < BitmapDescriptorFactory.HUE_RED) {
                    rawX = BitmapDescriptorFactory.HUE_RED;
                } else if (rawX > width) {
                    rawX = width;
                }
                if (rawY < BitmapDescriptorFactory.HUE_RED) {
                    rawY = BitmapDescriptorFactory.HUE_RED;
                } else if (rawY > height) {
                    rawY = height;
                }
                DragContainer.this.setX(rawX);
                DragContainer.this.setY(rawY);
                return true;
            }

            public void onLongPress(MotionEvent motionEvent) {
                super.onLongPress(motionEvent);
            }
        });
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f29151e.a(motionEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }
}
