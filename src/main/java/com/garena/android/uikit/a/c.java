package com.garena.android.uikit.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.garena.android.uikit.a;

public class c extends LinearLayout implements ViewPager.f {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f7713a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f7714b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f7715c;

    /* renamed from: d  reason: collision with root package name */
    private HorizontalScrollView f7716d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public d f7717e;

    /* renamed from: f  reason: collision with root package name */
    private int f7718f;

    /* renamed from: g  reason: collision with root package name */
    private b f7719g;
    private C0127c h;
    /* access modifiers changed from: private */
    public b i;
    /* access modifiers changed from: private */
    public View j;
    private boolean k = false;
    private boolean l = false;
    private boolean m = true;
    private boolean n = false;
    private androidx.viewpager.widget.a o = new androidx.viewpager.widget.a() {
        public int getCount() {
            if (c.this.f7713a != null) {
                return c.this.f7713a.b();
            }
            return 0;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            int a2 = c.this.b(i);
            com.garena.android.uikit.a.a.a c2 = c.this.f7713a.c(viewGroup.getContext(), a2);
            c2.setTag(c.this.a(a2));
            viewGroup.addView(c2);
            if (a2 == c.this.f7717e.getCurrentItem()) {
                c.this.a(-1, a2);
            }
            return c2;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (obj instanceof com.garena.android.uikit.a.a.a) {
                ((com.garena.android.uikit.a.a.a) obj).c();
            }
            viewGroup.removeView((View) obj);
        }
    };
    private View.OnClickListener p = new View.OnClickListener() {
        public void onClick(View view) {
            c.this.f7717e.setCurrentItem(((Integer) view.getTag()).intValue());
        }
    };

    public interface a {
        View a(Context context);

        com.garena.android.uikit.a.a.b a(Context context, int i);

        void a();

        void a(int i, int i2, View view, View view2, View view3, View view4, boolean z);

        int b();

        LinearLayout.LayoutParams b(Context context, int i);

        com.garena.android.uikit.a.a.a c(Context context, int i);
    }

    public interface b {
        void a(int i);

        void a(int i, int i2);
    }

    /* renamed from: com.garena.android.uikit.a.c$c  reason: collision with other inner class name */
    public interface C0127c {
        void a(HorizontalScrollView horizontalScrollView, FrameLayout frameLayout, int i, float f2);
    }

    public c(Context context) {
        super(context);
        a(context);
    }

    public c(Context context, boolean z) {
        super(context);
        this.k = z;
        a(context);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = context.obtainStyledAttributes(attributeSet, a.b.GTabView).getBoolean(0, false);
        a(context);
    }

    @TargetApi(11)
    public c(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = context.obtainStyledAttributes(attributeSet, a.b.GTabView).getBoolean(0, false);
        a(context);
    }

    private void a(Context context) {
        setOrientation(1);
        this.n = getResources().getBoolean(a.C0126a.is_right_to_left);
        this.f7714b = new FrameLayout(context);
        this.f7715c = new LinearLayout(context);
        this.f7715c.setOrientation(0);
        if (Build.VERSION.SDK_INT >= 17) {
            this.f7715c.setLayoutDirection(0);
        }
        this.f7714b.addView(this.f7715c);
        this.f7717e = new d(context);
        this.f7717e.setAdapter(this.o);
        this.f7717e.setOnPageChangeListener(this);
        this.f7717e.setOffscreenPageLimit(3);
        if (this.k) {
            this.f7716d = new HorizontalScrollView(context);
            this.f7716d.setHorizontalScrollBarEnabled(false);
            this.f7716d.addView(this.f7714b);
            addView(this.f7716d);
        } else {
            addView(this.f7714b);
        }
        addView(this.f7717e);
    }

    public void setAdapter(a aVar) {
        this.f7713a = aVar;
        setSelectedIndex(0);
    }

    public void a() {
        a aVar = this.f7713a;
        if (aVar != null) {
            aVar.a();
            this.f7715c.removeAllViews();
            int b2 = this.f7713a.b();
            Context context = getContext();
            for (int i2 = 0; i2 < b2; i2++) {
                int b3 = b(i2);
                com.garena.android.uikit.a.a.b a2 = this.f7713a.a(context, b3);
                if (a2 != null) {
                    a2.setTag(a(i2));
                    a2.setOnClickListener(this.p);
                    this.f7715c.addView(a2, this.f7713a.b(context, b3));
                    if (i2 < b2 - 1) {
                        View a3 = this.f7713a.a(context);
                        this.l = a3 != null;
                        if (this.l) {
                            this.f7715c.addView(a3);
                        }
                    }
                }
            }
            this.o.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: protected */
    public Object a(int i2) {
        return Integer.valueOf(i2);
    }

    public void setScrollLock(boolean z) {
        this.f7717e.setScrollLock(z);
    }

    public void b() {
        this.m = true;
        View findViewWithTag = this.f7717e.findViewWithTag(a(getSelectedIndex()));
        if (findViewWithTag != null) {
            ((com.garena.android.uikit.a.a.a) findViewWithTag).a();
        }
    }

    public void c() {
        this.m = false;
        View findViewWithTag = this.f7717e.findViewWithTag(a(getSelectedIndex()));
        if (findViewWithTag != null) {
            ((com.garena.android.uikit.a.a.a) findViewWithTag).b();
        }
    }

    public void d() {
        for (int i2 = 0; i2 < this.f7713a.b(); i2++) {
            View findViewWithTag = this.f7717e.findViewWithTag(a(i2));
            if (findViewWithTag != null) {
                ((com.garena.android.uikit.a.a.a) findViewWithTag).c();
            }
        }
    }

    public void setSelectedIndex(int i2) {
        a(i2, true);
    }

    public void a(int i2, boolean z) {
        int b2 = b(i2);
        if (b2 < this.f7713a.b() && b2 >= 0 && this.f7713a.b() != 0) {
            this.f7717e.setCurrentItem(b2, z);
            post(new Runnable() {
                public void run() {
                    if (c.this.i != null && c.this.f7714b != null && c.this.f7717e != null) {
                        c.this.i.a(c.this.f7717e.getCurrentItem(), c.this.j, c.this.f7714b, -1);
                    }
                }
            });
            FrameLayout frameLayout = this.f7714b;
            if (frameLayout != null) {
                frameLayout.postDelayed(new Runnable() {
                    public void run() {
                        if (c.this.i != null && c.this.f7714b != null && c.this.f7717e != null) {
                            c.this.i.a(c.this.f7717e.getCurrentItem(), c.this.j, c.this.f7714b, -1);
                        }
                    }
                }, 400);
            }
        }
    }

    public int getSelectedIndex() {
        return this.f7717e.getCurrentItem();
    }

    public void setTabChangeListener(b bVar) {
        this.f7719g = bVar;
    }

    public void setHeaderScrollListener(C0127c cVar) {
        this.h = cVar;
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3) {
        if (i2 != i3 && this.f7713a != null) {
            int i4 = this.l ? 2 : 1;
            View view = null;
            if (i2 != -1) {
                view = this.f7715c.getChildAt(i4 * i2);
            }
            View view2 = view;
            View childAt = this.f7715c.getChildAt(i4 * i3);
            b bVar = this.f7719g;
            if (bVar != null) {
                bVar.a(i2, i3);
            }
            if (this.f7717e.findViewWithTag(a(i3)) != null && childAt != null) {
                this.f7714b.postDelayed(new Runnable() {
                    public void run() {
                        if (c.this.f7717e != null && c.this.i != null && c.this.j != null) {
                            c.this.i.a(c.this.f7717e.getCurrentItem(), c.this.j, c.this.f7714b, -1);
                        }
                    }
                }, 400);
                this.f7713a.a(i2, i3, view2, childAt, this.f7717e.findViewWithTag(a(i2)), this.f7717e.findViewWithTag(a(i3)), this.m);
            }
        }
    }

    public void setHeaderBackgroundColor(int i2) {
        this.f7714b.setBackgroundColor(i2);
    }

    public void setHeaderBackgroundResource(int i2) {
        this.f7714b.setBackgroundResource(i2);
    }

    public void onPageScrolled(int i2, float f2, int i3) {
        if (!(this.j == null || this.f7713a == null || (i3 == 0 && !this.k))) {
            this.i.a(i2, this.j, this.f7714b, i3);
        }
        HorizontalScrollView horizontalScrollView = this.f7716d;
        if (horizontalScrollView != null && this.f7713a != null && this.k) {
            C0127c cVar = this.h;
            if (cVar != null) {
                cVar.a(horizontalScrollView, this.f7714b, i2, f2);
            }
        }
    }

    public void onPageSelected(int i2) {
        int i3 = this.f7718f;
        this.f7718f = i2;
        a(i3, this.f7718f);
    }

    public void onPageScrollStateChanged(int i2) {
        b bVar = this.f7719g;
        if (bVar != null) {
            bVar.a(i2);
        }
    }

    public void setTabIndicator(b bVar) {
        this.i = bVar;
        b bVar2 = this.i;
        if (bVar2 == null) {
            this.j = null;
            return;
        }
        this.j = bVar2.a(this.f7714b);
        this.f7714b.post(new Runnable() {
            public void run() {
                if (c.this.i != null && c.this.f7714b != null) {
                    if (c.this.f7714b.getWidth() <= 0) {
                        c.this.f7714b.post(this);
                    } else if (c.this.j != null && c.this.f7713a != null) {
                        c.this.i.a(c.this.f7717e.getCurrentItem(), c.this.j, c.this.f7714b, 0);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public int b(int i2) {
        return this.n ? (this.f7713a.b() - i2) - 1 : i2;
    }

    public ViewPager getViewPager() {
        return this.f7717e;
    }
}
