package com.garena.android.uikit.image.browser;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.garena.android.uikit.image.browser.BBTouchViewPager;

public class GImageBrowserView extends RelativeLayout implements BBTouchViewPager.f {

    /* renamed from: a  reason: collision with root package name */
    protected com.garena.android.uikit.image.a.a f7764a;

    /* renamed from: b  reason: collision with root package name */
    private int f7765b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f7766c;

    /* renamed from: d  reason: collision with root package name */
    private b f7767d;

    /* renamed from: e  reason: collision with root package name */
    private androidx.viewpager.widget.a f7768e = new androidx.viewpager.widget.a() {
        public int getCount() {
            if (GImageBrowserView.this.f7766c != null) {
                return GImageBrowserView.this.f7766c.b();
            }
            return 0;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            Context context = viewGroup.getContext();
            c cVar = new c(context);
            cVar.setTag(Integer.valueOf(i));
            View b2 = GImageBrowserView.this.f7766c.b(context, i);
            if (b2 != null) {
                cVar.setImageView(b2);
            }
            View a2 = GImageBrowserView.this.f7766c.a(context, i);
            if (a2 != null) {
                cVar.setOverlayView(a2);
            }
            viewGroup.addView(cVar);
            return cVar;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            c cVar = (c) obj;
            GImageBrowserView.this.f7766c.a(cVar.getImageView(), cVar.getOverlayView(), i);
            viewGroup.removeView((View) obj);
        }
    };

    public interface a {
        View a(Context context, int i);

        void a(View view, View view2, int i);

        int b();

        View b(Context context, int i);

        void b(View view, View view2, int i);

        void c();

        void c(View view, View view2, int i);
    }

    public interface b {
        void a(int i, int i2);
    }

    public void a(int i, float f2, int i2) {
    }

    public void b(int i) {
    }

    public GImageBrowserView(Context context) {
        super(context);
        a(context);
    }

    public GImageBrowserView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public GImageBrowserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        this.f7764a = new com.garena.android.uikit.image.a.a(context);
        this.f7764a.setAdapter(this.f7768e);
        this.f7764a.setOnPageChangeListener(this);
        addView(this.f7764a, new RelativeLayout.LayoutParams(-1, -1));
    }

    public void setAdapter(a aVar) {
        this.f7766c = aVar;
    }

    public void a() {
        a aVar = this.f7766c;
        if (aVar != null) {
            aVar.c();
            this.f7768e.notifyDataSetChanged();
            this.f7764a.a(this.f7765b, false);
        }
    }

    public void setSelectedIndex(int i) {
        if (i < this.f7766c.b() && i >= 0) {
            this.f7764a.a(i, false);
        }
    }

    public int getSelectedIndex() {
        return this.f7765b;
    }

    public void setPageChangeListener(b bVar) {
        this.f7767d = bVar;
    }

    public static class c extends FrameLayout {

        /* renamed from: a  reason: collision with root package name */
        private View f7770a;

        /* renamed from: b  reason: collision with root package name */
        private View f7771b;

        public c(Context context) {
            super(context);
            setBackgroundColor(0);
        }

        public void setImageView(View view) {
            this.f7770a = view;
            addView(view, new FrameLayout.LayoutParams(-1, -1));
        }

        public void setOverlayView(View view) {
            this.f7771b = view;
            addView(view, new FrameLayout.LayoutParams(-1, -1));
        }

        public View getImageView() {
            return this.f7770a;
        }

        public View getOverlayView() {
            return this.f7771b;
        }
    }

    public void a(int i) {
        int i2 = this.f7765b;
        this.f7765b = i;
        a(i2, this.f7765b);
    }

    private void a(int i, int i2) {
        if (i != i2 && this.f7766c != null) {
            c cVar = (c) this.f7764a.findViewWithTag(Integer.valueOf(i));
            if (cVar != null) {
                this.f7766c.b(cVar.getImageView(), cVar.getOverlayView(), i);
            }
            c cVar2 = (c) this.f7764a.findViewWithTag(Integer.valueOf(i2));
            if (cVar2 != null) {
                this.f7766c.c(cVar2.getImageView(), cVar2.getOverlayView(), i2);
            }
            b bVar = this.f7767d;
            if (bVar != null) {
                bVar.a(i, i2);
            }
        }
    }
}
