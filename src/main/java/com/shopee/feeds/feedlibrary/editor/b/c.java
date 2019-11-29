package com.shopee.feeds.feedlibrary.editor.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.UUID;

public class c extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    protected float f27917a;

    /* renamed from: b  reason: collision with root package name */
    protected float f27918b;

    /* renamed from: c  reason: collision with root package name */
    protected float f27919c;

    /* renamed from: d  reason: collision with root package name */
    protected float f27920d;

    /* renamed from: e  reason: collision with root package name */
    protected androidx.core.g.c f27921e;

    /* renamed from: f  reason: collision with root package name */
    protected a f27922f;

    /* renamed from: g  reason: collision with root package name */
    protected b f27923g;
    protected boolean h;
    private String i;

    public interface a {
        void a();

        void a(b bVar);

        void a(String str, float f2, float f3);

        void b();

        void c();

        void d();
    }

    public c(Context context) {
        super(context);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public c(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.i = UUID.randomUUID().toString();
        this.f27921e = new androidx.core.g.c(context, new GestureDetector.SimpleOnGestureListener() {
            public boolean onDown(MotionEvent motionEvent) {
                c.this.getGestureListener().a();
                c.this.f27917a = motionEvent.getX();
                c.this.f27918b = motionEvent.getY();
                c.this.f27919c = (motionEvent.getRawX() - motionEvent.getX()) - c.this.getX();
                c.this.f27920d = (motionEvent.getRawY() - motionEvent.getY()) - c.this.getY();
                return true;
            }

            public boolean onSingleTapUp(MotionEvent motionEvent) {
                c.this.getGestureListener().c();
                c.this.a();
                return true;
            }

            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                float rawX = (motionEvent2.getRawX() - c.this.f27917a) - c.this.f27919c;
                float rawY = (motionEvent2.getRawY() - c.this.f27918b) - c.this.f27920d;
                float e2 = c.this.f27923g.e() - ((float) c.this.getMeasuredWidth());
                float f4 = c.this.f27923g.f() - ((float) c.this.getMeasuredHeight());
                if (rawX < BitmapDescriptorFactory.HUE_RED) {
                    rawX = BitmapDescriptorFactory.HUE_RED;
                } else if (rawX > e2) {
                    rawX = e2;
                }
                if (rawY < BitmapDescriptorFactory.HUE_RED) {
                    rawY = BitmapDescriptorFactory.HUE_RED;
                } else if (rawY > f4) {
                    rawX = f4;
                }
                c.this.setX(rawX);
                c.this.setY(rawY);
                c.this.getGestureListener().d();
                c.this.a();
                return true;
            }

            public void onLongPress(MotionEvent motionEvent) {
                super.onLongPress(motionEvent);
            }
        });
    }

    public String getViewId() {
        return this.i;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.h) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 1) {
            getGestureListener().b();
        }
        return this.f27921e.a(motionEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setInfo(b bVar) {
        this.f27923g = bVar;
    }

    public b getmInfo() {
        return this.f27923g;
    }

    public String getViewTag() {
        b bVar = this.f27923g;
        if (bVar == null) {
            return null;
        }
        return bVar.g();
    }

    public void a() {
        getGestureListener().a(getViewTag(), getX() + (((float) getMeasuredWidth()) / 2.0f), getY() + (((float) getMeasuredHeight()) / 2.0f));
    }

    public void setGestureListener(a aVar) {
        this.f27922f = aVar;
    }

    /* access modifiers changed from: protected */
    public a getGestureListener() {
        a aVar = this.f27922f;
        return aVar == null ? new a() {
            public void a() {
            }

            public void a(b bVar) {
            }

            public void a(String str, float f2, float f3) {
            }

            public void b() {
            }

            public void c() {
            }

            public void d() {
            }
        } : aVar;
    }
}
