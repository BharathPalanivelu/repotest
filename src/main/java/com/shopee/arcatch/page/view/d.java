package com.shopee.arcatch.page.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.arcatch.a;
import com.shopee.arcatch.b.c.b;
import com.squareup.a.w;
import java.util.ArrayList;
import java.util.List;

public class d extends androidx.viewpager.widget.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f27067a;

    /* renamed from: b  reason: collision with root package name */
    private ViewPager f27068b;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f27069c = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public a f27070d;

    /* renamed from: e  reason: collision with root package name */
    private int f27071e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f27072f = 0;

    public interface a {
        void a(int i);
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public d(Context context, List<String> list, ViewPager viewPager) {
        this.f27067a = context;
        this.f27069c = list;
        this.f27068b = viewPager;
        this.f27071e = b.a(this.f27067a, 22.5f);
        float a2 = a();
        if (a2 > BitmapDescriptorFactory.HUE_RED) {
            this.f27072f = b.a(this.f27067a, (a2 / 2.0f) + 22.5f);
        } else {
            this.f27072f = this.f27071e;
        }
    }

    public int getCount() {
        return this.f27069c.size();
    }

    public Object instantiateItem(ViewGroup viewGroup, final int i) {
        View inflate = LayoutInflater.from(this.f27067a).inflate(a.d.arcatch_view_guide_pager, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(a.c.arcatch_guide_guide_background);
        int i2 = this.f27072f;
        ((LinearLayout.LayoutParams) imageView.getLayoutParams()).setMargins(i2, this.f27071e, i2, 0);
        ((ArCatchGuideIndicator) inflate.findViewById(a.c.arcatch_guide_indicator)).a(i, (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                if (d.this.f27070d != null) {
                    d.this.f27070d.a(i);
                }
            }
        });
        w.a(this.f27067a).a(this.f27069c.get(i)).a(imageView);
        viewGroup.addView(inflate);
        inflate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (d.this.f27070d != null) {
                    d.this.f27070d.a(i);
                }
            }
        });
        return inflate;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public void a(a aVar) {
        this.f27070d = aVar;
    }

    private float a() {
        return 134.0f - ((float) b.b(this.f27067a, (float) ((b.c(this.f27067a) - b.d(this.f27067a)) - ((int) ((((float) (b.b(this.f27067a) - (b.a(this.f27067a, 22.5f) * 2))) * 960.0f) / 660.0f)))));
    }
}
