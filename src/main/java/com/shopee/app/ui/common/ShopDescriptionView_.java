package com.shopee.app.ui.common;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class ShopDescriptionView_ extends ak implements a, b {

    /* renamed from: c  reason: collision with root package name */
    private boolean f21001c = false;

    /* renamed from: d  reason: collision with root package name */
    private final c f21002d = new c();

    public ShopDescriptionView_(Context context) {
        super(context);
        b();
    }

    public ShopDescriptionView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public ShopDescriptionView_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    public void onFinishInflate() {
        if (!this.f21001c) {
            this.f21001c = true;
            inflate(getContext(), R.layout.banner_layout, this);
            this.f21002d.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f21002d);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.f21146b = resources.getDimensionPixelSize(R.dimen.dp16);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21145a = (ViewPager) aVar.internalFindViewById(R.id.banner_list);
        a();
    }
}
