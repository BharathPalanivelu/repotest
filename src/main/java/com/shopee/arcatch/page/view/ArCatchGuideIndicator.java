package com.shopee.arcatch.page.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.shopee.arcatch.a;
import com.shopee.arcatch.c.a.b;
import com.shopee.arcatch.data.config_bean.ConfigBean;
import java.util.ArrayList;
import java.util.List;

public class ArCatchGuideIndicator extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewGroup f27019a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f27020b;

    /* renamed from: c  reason: collision with root package name */
    private List<ImageView> f27021c;

    /* renamed from: d  reason: collision with root package name */
    private ConfigBean f27022d;

    /* renamed from: e  reason: collision with root package name */
    private int f27023e;

    /* renamed from: f  reason: collision with root package name */
    private String f27024f;

    /* renamed from: g  reason: collision with root package name */
    private String f27025g;
    private int h;
    private int i;

    public ArCatchGuideIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public ArCatchGuideIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArCatchGuideIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f27021c = new ArrayList();
        a();
    }

    private void a() {
        int i2;
        LayoutInflater.from(getContext()).inflate(a.d.arcatch_view_guide_indicator, this, true);
        setOrientation(1);
        setGravity(1);
        this.f27019a = (ViewGroup) findViewById(a.c.arcatch_guide_indicator_group);
        this.f27020b = (TextView) findViewById(a.c.arcatch_guide_hint);
        Typeface createFromAsset = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-BoldItalic.ttf");
        if (createFromAsset != null) {
            this.f27020b.setTypeface(createFromAsset);
        }
        this.f27022d = b.a().b();
        ConfigBean configBean = this.f27022d;
        if (configBean == null || configBean.imageConfigBean == null || this.f27022d.textConfigBean == null) {
            com.shopee.e.a.a.b("mConfigBean == null!", new Object[0]);
        } else {
            List<String> list = this.f27022d.imageConfigBean.guideImageForNewUsers;
            this.f27024f = this.f27022d.textConfigBean.tabToContinue;
            this.f27025g = this.f27022d.textConfigBean.tabToStart;
            this.h = this.f27022d.textConfigBean.tabToContinueColor;
            this.i = this.f27022d.textConfigBean.tabToStartColor;
            if (list == null) {
                i2 = 0;
            } else {
                i2 = list.size();
            }
            this.f27023e = i2;
        }
        for (int i3 = 0; i3 < this.f27023e; i3++) {
            ImageView imageView = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.shopee.arcatch.b.c.b.a(getContext(), 27.0f), com.shopee.arcatch.b.c.b.a(getContext(), 27.0f));
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            if (i3 != 0) {
                layoutParams.leftMargin = com.shopee.arcatch.b.c.b.a(getContext(), 9.5f);
            }
            imageView.setLayoutParams(layoutParams);
            this.f27021c.add(imageView);
            this.f27019a.addView(imageView);
        }
    }

    public void a(int i2, View.OnClickListener onClickListener) {
        if (i2 == this.f27023e - 1) {
            this.f27020b.setText(this.f27025g);
            this.f27020b.setTextColor(this.i);
        } else {
            this.f27020b.setText(this.f27024f);
            this.f27020b.setTextColor(this.h);
        }
        this.f27020b.setOnClickListener(onClickListener);
        int i3 = 0;
        while (i3 < this.f27023e) {
            a(this.f27021c.get(i3), i3 == i2);
            i3++;
        }
    }

    private void a(ImageView imageView, boolean z) {
        imageView.setImageResource(z ? a.b.arcatch_newbiew_guide_indicator1 : a.b.arcatch_newbiew_guide_indicator2);
    }
}
