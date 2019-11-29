package com.shopee.app.react.view.pager;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import java.util.ArrayList;
import java.util.List;

public class d extends ViewPager {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Runnable f19072a = new Runnable() {
        public void run() {
            d dVar = d.this;
            dVar.measure(View.MeasureSpec.makeMeasureSpec(dVar.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(d.this.getHeight(), 1073741824));
            d dVar2 = d.this;
            dVar2.layout(dVar2.getLeft(), d.this.getTop(), d.this.getRight(), d.this.getBottom());
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final EventDispatcher f19073b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f19074c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f19075d = true;

    private class a extends androidx.viewpager.widget.a {

        /* renamed from: b  reason: collision with root package name */
        private final List<View> f19078b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f19079c;

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        private a() {
            this.f19078b = new ArrayList();
            this.f19079c = false;
        }

        /* access modifiers changed from: package-private */
        public void a(View view, int i) {
            this.f19078b.add(i, view);
            notifyDataSetChanged();
        }

        /* access modifiers changed from: package-private */
        public void a(int i) {
            this.f19078b.remove(i);
            notifyDataSetChanged();
        }

        /* access modifiers changed from: package-private */
        public void a(List<View> list) {
            this.f19078b.clear();
            this.f19078b.addAll(list);
            notifyDataSetChanged();
            this.f19079c = false;
        }

        /* access modifiers changed from: package-private */
        public View b(int i) {
            return this.f19078b.get(i);
        }

        public int getCount() {
            return this.f19078b.size();
        }

        public int getItemPosition(Object obj) {
            if (this.f19079c || !this.f19078b.contains(obj)) {
                return -2;
            }
            return this.f19078b.indexOf(obj);
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.f19078b.get(i);
            viewGroup.addView(view, 0, d.this.generateDefaultLayoutParams());
            a(view, i, true);
            viewGroup.post(d.this.f19072a);
            return view;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            View view = (View) obj;
            viewGroup.removeView(view);
            a(view, i, false);
        }

        public void a(View view, int i, boolean z) {
            if (view instanceof e) {
                ((e) view).a(i, z);
            }
        }
    }

    private class b implements ViewPager.f {
        private b() {
        }

        public void onPageScrolled(int i, float f2, int i2) {
            d.this.f19073b.dispatchEvent(new a(d.this.getId(), i, f2));
        }

        public void onPageSelected(int i) {
            if (!d.this.f19074c) {
                d.this.f19073b.dispatchEvent(new c(d.this.getId(), i));
            }
        }

        public void onPageScrollStateChanged(int i) {
            String str;
            if (i == 0) {
                str = "idle";
            } else if (i == 1) {
                str = "dragging";
            } else if (i == 2) {
                str = "settling";
            } else {
                throw new IllegalStateException("Unsupported pageScrollState");
            }
            d.this.f19073b.dispatchEvent(new b(d.this.getId(), str));
        }
    }

    public d(ReactContext reactContext) {
        super(reactContext);
        this.f19073b = ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
        this.f19074c = false;
        setOnPageChangeListener(new b());
        setAdapter(new a());
    }

    public a getAdapter() {
        return (a) super.getAdapter();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f19075d || !super.onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        NativeGestureUtil.notifyNativeGestureStarted(this, motionEvent);
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f19075d) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void a(int i, boolean z) {
        this.f19074c = true;
        setCurrentItem(i, z);
        this.f19074c = false;
    }

    public void setScrollEnabled(boolean z) {
        this.f19075d = z;
    }

    /* access modifiers changed from: package-private */
    public void a(View view, int i) {
        getAdapter().a(view, i);
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        getAdapter().a(i);
    }

    /* access modifiers changed from: package-private */
    public int getViewCountInAdapter() {
        return getAdapter().getCount();
    }

    /* access modifiers changed from: package-private */
    public View b(int i) {
        return getAdapter().b(i);
    }

    public void setViews(List<View> list) {
        getAdapter().a(list);
    }
}
