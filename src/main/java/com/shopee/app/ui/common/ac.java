package com.shopee.app.ui.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.viewmodel.RecommendBannerData;
import com.shopee.app.util.ak;
import com.shopee.app.util.x;
import com.squareup.a.w;

public class ac extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    LinearLayout f21119a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f21120b;

    /* renamed from: c  reason: collision with root package name */
    ak f21121c;

    public interface a {
        void a(ac acVar);
    }

    public ac(Context context) {
        super(context);
        a(context);
    }

    public ac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ac(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        if (!isInEditMode()) {
            ((a) ((x) context).b()).a(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f21120b.setLayoutParams(new LinearLayout.LayoutParams(b.b(), (int) (((float) b.b()) / 3.3333f)));
    }

    public void setBannerData(final RecommendBannerData recommendBannerData) {
        w a2 = w.a(getContext());
        a2.a("http://cf.shopee.co.id/file/" + recommendBannerData.getImage()).a().d().a(this.f21120b);
        this.f21120b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ac.this.f21121c.a(recommendBannerData.getId());
            }
        });
    }
}
