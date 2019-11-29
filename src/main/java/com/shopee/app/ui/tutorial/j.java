package com.shopee.app.ui.tutorial;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.appkit.ui.view.BBCirclePageIndicator;
import com.shopee.app.data.store.RegionConfig;
import com.shopee.app.util.av;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class j extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    RegionConfig f25721a;

    /* renamed from: b  reason: collision with root package name */
    ViewPager f25722b;

    /* renamed from: c  reason: collision with root package name */
    private a f25723c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public BBCirclePageIndicator f25724d;

    public j(Context context, boolean z) {
        super(context);
        ((g) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f25723c = new a();
        List<b> b2 = b();
        this.f25723c.a(b2);
        this.f25722b.setAdapter(this.f25723c);
        c();
        if (av.f26170a) {
            Collections.reverse(b2);
            this.f25723c.a(b2);
            this.f25722b.setCurrentItem(b2.size() - 1);
        }
    }

    private List<b> b() {
        ArrayList arrayList = new ArrayList();
        TypedArray obtainTypedArray = getResources().obtainTypedArray(R.array.slide_intro_images);
        for (int i = 0; i < obtainTypedArray.length(); i++) {
            int resourceId = obtainTypedArray.getResourceId(i, 0);
            if (resourceId != 0) {
                b bVar = new b();
                bVar.f25727a = resourceId;
                arrayList.add(bVar);
            }
        }
        obtainTypedArray.recycle();
        return arrayList;
    }

    private void c() {
        this.f25724d = new BBCirclePageIndicator(getContext(), (AttributeSet) null, R.style.circle_pager_indicator);
        this.f25724d.a(this.f25722b, 0);
        this.f25724d.setRadius((float) b.a.f7693d);
        this.f25724d.setFillColor(com.garena.android.appkit.tools.b.a(R.color.primary));
        this.f25724d.setPageColor(-3355444);
        this.f25724d.setStrokeColor(0);
        this.f25724d.setCentered(true);
        this.f25724d.setOnPageChangeListener(this.f25723c);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = b.a.m;
        addView(this.f25724d, layoutParams);
    }

    private class a extends androidx.viewpager.widget.a implements ViewPager.f {

        /* renamed from: b  reason: collision with root package name */
        private List<b> f25726b;

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f2, int i2) {
        }

        private a() {
            this.f25726b = new ArrayList();
        }

        public void a(List<b> list) {
            this.f25726b = list;
        }

        public int getCount() {
            return this.f25726b.size();
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            h a2 = i.a(viewGroup.getContext());
            a2.setImage(this.f25726b.get(i).f25727a);
            if (a(i)) {
                a2.b();
            }
            a2.setBackgroundColor(-1);
            viewGroup.addView(a2);
            return a2;
        }

        private boolean a(int i) {
            if (av.f26170a) {
                if (i == 0) {
                    return true;
                }
                return false;
            } else if (i == this.f25726b.size() - 1) {
                return true;
            } else {
                return false;
            }
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public void onPageSelected(int i) {
            if (a(i)) {
                j.this.f25724d.setVisibility(4);
            } else {
                j.this.f25724d.setVisibility(0);
            }
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f25727a;

        private b() {
        }
    }
}
