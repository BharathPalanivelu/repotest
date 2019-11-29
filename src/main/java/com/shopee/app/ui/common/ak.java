package com.shopee.app.ui.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.garena.android.appkit.tools.a.b;
import com.garena.android.appkit.tools.b;
import com.garena.android.appkit.ui.view.BBCirclePageIndicator;
import com.shopee.id.R;
import com.shopee.protocol.shop.ShopCover;
import java.util.ArrayList;
import java.util.List;

public class ak extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    ViewPager f21145a;

    /* renamed from: b  reason: collision with root package name */
    int f21146b;

    /* renamed from: c  reason: collision with root package name */
    private a f21147c;

    /* renamed from: d  reason: collision with root package name */
    private BBCirclePageIndicator f21148d;

    public ak(Context context) {
        super(context);
    }

    public ak(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ak(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (!isInEditMode()) {
            this.f21147c = new a();
            this.f21145a.setAdapter(this.f21147c);
            this.f21145a.setLayoutParams(new FrameLayout.LayoutParams(b.b() - (this.f21146b * 2), (int) (((float) b.b()) / 2.0f)));
            b();
        }
    }

    private void b() {
        this.f21148d = new BBCirclePageIndicator(getContext(), (AttributeSet) null, R.style.circle_pager_indicator);
        this.f21148d.a(this.f21145a, 0);
        this.f21148d.setRadius((float) b.a.f7693d);
        this.f21148d.setFillColor(com.garena.android.appkit.tools.b.a(R.color.primary));
        this.f21148d.setPageColor(-3355444);
        this.f21148d.setStrokeColor(0);
        this.f21148d.setCentered(true);
        this.f21148d.setSnap(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = b.a.k;
        addView(this.f21148d, layoutParams);
    }

    public void setShopCovers(List<ShopCover> list) {
        List unused = this.f21147c.f21149a = list;
        this.f21147c.notifyDataSetChanged();
        if (list.size() <= 1) {
            this.f21148d.setVisibility(4);
        } else {
            this.f21148d.setVisibility(0);
        }
        this.f21148d.setPageCount(list.size());
    }

    private static class a extends androidx.viewpager.widget.a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public List<ShopCover> f21149a;

        public int getItemPosition(Object obj) {
            return -2;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        private a() {
            this.f21149a = new ArrayList();
        }

        public int getCount() {
            if (this.f21149a.size() > 1) {
                return Integer.MAX_VALUE;
            }
            return this.f21149a.size();
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            int size = i % this.f21149a.size();
            ai aiVar = new ai(viewGroup.getContext());
            aiVar.a(this.f21149a.get(size));
            viewGroup.addView(aiVar);
            return aiVar;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }
    }
}
