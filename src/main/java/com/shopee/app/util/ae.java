package com.shopee.app.util;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import com.shopee.id.R;

public class ae implements View.OnTouchListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ListView f26132a;

    /* renamed from: b  reason: collision with root package name */
    private final GestureDetector f26133b = new GestureDetector(this.f26132a.getContext(), new a());
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public long f26134c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f26135d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f26136e;

    public interface b {
        boolean a(long j);

        long getIdentifier();
    }

    public ae(ListView listView) {
        this.f26132a = listView;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!(view instanceof b)) {
            return false;
        }
        this.f26134c = ((b) view).getIdentifier();
        this.f26135d = Integer.valueOf(((String) view.getTag()).split("_")[1]).intValue();
        boolean onTouchEvent = this.f26133b.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 3 && this.f26136e) {
            b(this.f26134c);
        }
        return onTouchEvent;
    }

    /* access modifiers changed from: private */
    public void a(long j) {
        this.f26136e = true;
        int childCount = this.f26132a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f26132a.getChildAt(i);
            if (childAt != null && (childAt instanceof b) && ((b) childAt).a(j)) {
                a(childAt, (int) R.color.black06);
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(long j) {
        this.f26136e = false;
        int childCount = this.f26132a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f26132a.getChildAt(i);
            if (childAt != null && (childAt instanceof b) && ((b) childAt).a(j)) {
                Integer num = (Integer) childAt.getTag(R.id.button);
                if (num != null) {
                    a(childAt, num.intValue());
                }
            }
        }
    }

    private void a(View view, int i) {
        int paddingLeft = view.getPaddingLeft();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingBottom = view.getPaddingBottom();
        view.setBackgroundColor(com.garena.android.appkit.tools.b.a(i));
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    private final class a extends GestureDetector.SimpleOnGestureListener {
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public a() {
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (!ae.this.f26136e) {
                ae aeVar = ae.this;
                aeVar.a(aeVar.f26134c);
            }
            return super.onSingleTapUp(motionEvent);
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (ae.this.f26136e) {
                ae aeVar = ae.this;
                aeVar.b(aeVar.f26134c);
            }
            ae.this.f26132a.getOnItemClickListener().onItemClick(ae.this.f26132a, (View) null, ae.this.f26135d, (long) ae.this.f26135d);
            return super.onSingleTapConfirmed(motionEvent);
        }

        public void onShowPress(MotionEvent motionEvent) {
            if (!ae.this.f26136e) {
                ae aeVar = ae.this;
                aeVar.a(aeVar.f26134c);
            }
        }

        public void onLongPress(MotionEvent motionEvent) {
            if (ae.this.f26136e) {
                ae aeVar = ae.this;
                aeVar.b(aeVar.f26134c);
            }
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!ae.this.f26136e) {
                return false;
            }
            ae aeVar = ae.this;
            aeVar.b(aeVar.f26134c);
            return false;
        }
    }
}
