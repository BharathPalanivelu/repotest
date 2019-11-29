package com.shopee.app.ui.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class RecBannerView_ extends ac implements a, b {

    /* renamed from: d  reason: collision with root package name */
    private boolean f20992d = false;

    /* renamed from: e  reason: collision with root package name */
    private final c f20993e = new c();

    public RecBannerView_(Context context) {
        super(context);
        b();
    }

    public RecBannerView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public RecBannerView_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    public void onFinishInflate() {
        if (!this.f20992d) {
            this.f20992d = true;
            inflate(getContext(), R.layout.rec_banner_layout, this);
            this.f20993e.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f20993e);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21119a = (LinearLayout) aVar.internalFindViewById(R.id.banner_list);
        this.f21120b = (ImageView) aVar.internalFindViewById(R.id.item_view);
        a();
    }
}
