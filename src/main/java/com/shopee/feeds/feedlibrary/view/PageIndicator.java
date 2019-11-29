package com.shopee.feeds.feedlibrary.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.feeds.feedlibrary.c;
import java.util.ArrayList;

public class PageIndicator extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Integer> f28470a;

    /* renamed from: b  reason: collision with root package name */
    private final int f28471b;

    /* renamed from: c  reason: collision with root package name */
    private final int f28472c;

    /* renamed from: d  reason: collision with root package name */
    private final int f28473d;

    /* renamed from: e  reason: collision with root package name */
    private int f28474e;

    /* renamed from: f  reason: collision with root package name */
    private Context f28475f;

    public PageIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public PageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28470a = new ArrayList<>();
        this.f28474e = -1;
        this.f28475f = context;
        this.f28471b = context.getResources().getDimensionPixelSize(c.C0424c.page_indicator_width);
        this.f28472c = context.getResources().getDimensionPixelSize(c.C0424c.page_indicator_height);
        this.f28473d = this.f28472c;
    }

    public void setNumPages(int i) {
        setVisibility(i > 1 ? 0 : 8);
        while (i < getChildCount()) {
            removeViewAt(getChildCount() - 1);
        }
        while (i > getChildCount()) {
            ImageView imageView = new ImageView(this.f28475f);
            imageView.setImageResource(c.d.feeds_minor_a_b);
            addView(imageView, new ViewGroup.LayoutParams(this.f28471b, this.f28472c));
        }
        setIndex(this.f28474e >> 1);
    }

    public void setLocation(float f2) {
        int i = (int) f2;
        int i2 = (f2 != ((float) i) ? 1 : 0) | (i << 1);
        int i3 = this.f28474e;
        if (this.f28470a.size() != 0) {
            ArrayList<Integer> arrayList = this.f28470a;
            i3 = arrayList.get(arrayList.size() - 1).intValue();
        }
        if (i2 != i3) {
            setPosition(i2);
        }
    }

    private void setPosition(int i) {
        setIndex(i >> 1);
        this.f28474e = i;
    }

    private void setIndex(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ImageView imageView = (ImageView) getChildAt(i2);
            imageView.setTranslationX(BitmapDescriptorFactory.HUE_RED);
            if (i2 == i) {
                imageView.setImageResource(c.d.feeds_major_a_b);
            } else {
                imageView.setImageResource(c.d.feeds_minor_a_b);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            super.onMeasure(i, i2);
            return;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f28471b, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.f28472c, 1073741824);
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).measure(makeMeasureSpec, makeMeasureSpec2);
        }
        int i4 = this.f28471b;
        int i5 = this.f28473d;
        setMeasuredDimension(((i4 - i5) * (childCount - 1)) + i5, this.f28472c);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        if (childCount != 0) {
            for (int i5 = 0; i5 < childCount; i5++) {
                int i6 = (this.f28471b - this.f28473d) * i5;
                getChildAt(i5).layout(i6, 0, this.f28471b + i6, this.f28472c);
            }
        }
    }
}
