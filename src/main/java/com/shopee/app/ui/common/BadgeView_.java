package com.shopee.app.ui.common;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class BadgeView_ extends f implements a, b {
    private boolean i = false;
    private final c j = new c();

    public BadgeView_(Context context) {
        super(context);
        g();
    }

    public BadgeView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    public BadgeView_(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        g();
    }

    public static f a(Context context) {
        BadgeView_ badgeView_ = new BadgeView_(context);
        badgeView_.onFinishInflate();
        return badgeView_;
    }

    public void onFinishInflate() {
        if (!this.i) {
            this.i = true;
            this.j.a((a) this);
        }
        super.onFinishInflate();
    }

    private void g() {
        c a2 = c.a(this.j);
        Resources resources = getContext().getResources();
        this.f21260a = resources.getDimensionPixelSize(R.dimen.dp5);
        this.f21261b = resources.getDimensionPixelSize(R.dimen.dp6);
        this.f21262c = resources.getDimensionPixelSize(R.dimen.dp8);
        this.f21263e = resources.getDimensionPixelSize(R.dimen.dp1);
        this.f21264f = androidx.core.content.b.c(getContext(), R.color.primary);
        this.f21265g = androidx.core.content.b.c(getContext(), R.color.red_official_shop);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public void onViewChanged(a aVar) {
        a();
    }
}
