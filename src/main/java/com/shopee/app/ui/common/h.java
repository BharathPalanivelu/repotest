package com.shopee.app.ui.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.appkit.ui.view.BBCirclePageIndicator;
import com.shopee.app.data.viewmodel.BannerData;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class h extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    ViewPager f21268a;

    /* renamed from: b  reason: collision with root package name */
    private b f21269b;

    /* renamed from: c  reason: collision with root package name */
    private BBCirclePageIndicator f21270c;

    /* renamed from: d  reason: collision with root package name */
    private Timer f21271d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f21272e = false;

    public h(Context context) {
        super(context);
    }

    public h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f21269b = new b();
        this.f21268a.setAdapter(this.f21269b);
        this.f21268a.setLayoutParams(new FrameLayout.LayoutParams(com.garena.android.appkit.tools.b.b(), (int) (((float) com.garena.android.appkit.tools.b.b()) / 3.3333f)));
        b();
    }

    private void b() {
        this.f21270c = new BBCirclePageIndicator(getContext(), (AttributeSet) null, R.style.circle_pager_indicator);
        this.f21270c.a(this.f21268a, 0);
        this.f21270c.setRadius((float) b.a.f7693d);
        this.f21270c.setFillColor(com.garena.android.appkit.tools.b.a(R.color.primary));
        this.f21270c.setPageColor(-3355444);
        this.f21270c.setStrokeColor(0);
        this.f21270c.setCentered(true);
        this.f21270c.setSnap(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = b.a.f7694e;
        addView(this.f21270c, layoutParams);
    }

    public void setBannerData(List<BannerData> list) {
        List unused = this.f21269b.f21276a = list;
        this.f21269b.notifyDataSetChanged();
        if (list.size() <= 1) {
            this.f21270c.setVisibility(4);
        } else {
            this.f21270c.setVisibility(0);
        }
        this.f21270c.setPageCount(list.size());
    }

    public void setAutoRotate(boolean z) {
        this.f21272e = z;
        if (this.f21272e) {
            this.f21271d = new Timer();
            this.f21271d.schedule(new a(), 1500, 5000);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Timer timer = this.f21271d;
        if (timer != null) {
            timer.cancel();
        }
        if (this.f21272e) {
            this.f21271d = new Timer();
            this.f21271d.schedule(new a(), 1500, 5000);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Timer timer = this.f21271d;
        if (timer != null) {
            timer.cancel();
            this.f21271d = null;
        }
    }

    private static class b extends androidx.viewpager.widget.a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public List<BannerData> f21276a;

        public int getItemPosition(Object obj) {
            return -2;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        private b() {
            this.f21276a = new ArrayList();
        }

        public int getCount() {
            if (this.f21276a.size() > 1) {
                return Integer.MAX_VALUE;
            }
            return this.f21276a.size();
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            int size = i % this.f21276a.size();
            g gVar = new g(viewGroup.getContext());
            gVar.a(this.f21276a.get(size));
            viewGroup.addView(gVar);
            return gVar;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }
    }

    private class a extends TimerTask {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f21274b;

        private a() {
            this.f21274b = 0;
        }

        static /* synthetic */ int b(a aVar) {
            int i = aVar.f21274b;
            aVar.f21274b = i + 1;
            return i;
        }

        public void run() {
            h.this.f21268a.post(new Runnable() {
                public void run() {
                    int currentItem = h.this.f21268a.getCurrentItem();
                    if (currentItem == a.this.f21274b) {
                        a.b(a.this);
                        h.this.f21268a.setCurrentItem(a.this.f21274b);
                        return;
                    }
                    int unused = a.this.f21274b = currentItem;
                }
            });
        }
    }
}
