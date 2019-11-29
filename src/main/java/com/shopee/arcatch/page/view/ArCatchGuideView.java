package com.shopee.arcatch.page.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.shopee.arcatch.a;
import com.shopee.arcatch.c.a.b;
import com.shopee.arcatch.data.config_bean.ConfigBean;
import com.shopee.arcatch.data.config_bean.ImageConfigBean;
import com.shopee.arcatch.page.view.d;
import java.util.ArrayList;
import java.util.List;

public class ArCatchGuideView extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ViewPager f27026a;

    /* renamed from: b  reason: collision with root package name */
    private d f27027b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f27028c;

    /* renamed from: d  reason: collision with root package name */
    private ConfigBean f27029d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public List<String> f27030e;

    public interface a {
        void a();
    }

    public ArCatchGuideView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ArCatchGuideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArCatchGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27030e = new ArrayList();
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(a.d.arcatch_view_guide, this, true);
        setOrientation(1);
        setBackgroundColor(Color.parseColor("#301105"));
        this.f27026a = (ViewPager) findViewById(a.c.arcatch_guide_viewpager);
        this.f27029d = b.a().b();
        ConfigBean configBean = this.f27029d;
        ImageConfigBean imageConfigBean = configBean != null ? configBean.imageConfigBean : null;
        if (!(imageConfigBean == null || imageConfigBean.guideImageForNewUsers == null)) {
            this.f27030e = imageConfigBean.guideImageForNewUsers;
        }
        this.f27027b = new d(getContext(), this.f27030e, this.f27026a);
        a(0);
        this.f27026a.setAdapter(this.f27027b);
        this.f27026a.addOnPageChangeListener(new ViewPager.f() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f2, int i2) {
            }

            public void onPageSelected(int i) {
                if (i == ArCatchGuideView.this.f27030e.size() - 1) {
                    ArCatchGuideView.this.b(i);
                } else {
                    ArCatchGuideView.this.a(i);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(int i) {
        this.f27027b.a((d.a) new d.a() {
            public void a(int i) {
                ArCatchGuideView.this.f27026a.setCurrentItem(ArCatchGuideView.this.f27026a.getCurrentItem() + 1);
            }
        });
    }

    /* access modifiers changed from: private */
    public void b(int i) {
        this.f27027b.a((d.a) new d.a() {
            public void a(int i) {
                if (ArCatchGuideView.this.f27028c != null) {
                    ArCatchGuideView.this.f27028c.a();
                }
            }
        });
    }

    public void setOnPageFinishListener(a aVar) {
        this.f27028c = aVar;
    }
}
