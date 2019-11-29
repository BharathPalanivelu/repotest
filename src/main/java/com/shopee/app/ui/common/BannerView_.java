package com.shopee.app.ui.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class BannerView_ extends h implements a, b {

    /* renamed from: b  reason: collision with root package name */
    private boolean f20979b = false;

    /* renamed from: c  reason: collision with root package name */
    private final c f20980c = new c();

    public BannerView_(Context context) {
        super(context);
        b();
    }

    public BannerView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public BannerView_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    public void onFinishInflate() {
        if (!this.f20979b) {
            this.f20979b = true;
            inflate(getContext(), R.layout.banner_layout, this);
            this.f20980c.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f20980c);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21268a = (ViewPager) aVar.internalFindViewById(R.id.banner_list);
        a();
    }
}
