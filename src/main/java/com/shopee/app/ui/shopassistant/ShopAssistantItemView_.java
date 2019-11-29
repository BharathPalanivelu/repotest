package com.shopee.app.ui.shopassistant;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.app.ui.common.f;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class ShopAssistantItemView_ extends d implements a, b {
    private boolean l = false;
    private final c m = new c();

    public ShopAssistantItemView_(Context context) {
        super(context);
        c();
    }

    public ShopAssistantItemView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public ShopAssistantItemView_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c();
    }

    public static d a(Context context) {
        ShopAssistantItemView_ shopAssistantItemView_ = new ShopAssistantItemView_(context);
        shopAssistantItemView_.onFinishInflate();
        return shopAssistantItemView_;
    }

    public void onFinishInflate() {
        if (!this.l) {
            this.l = true;
            inflate(getContext(), R.layout.shop_assistant_item, this);
            this.m.a((a) this);
        }
        super.onFinishInflate();
    }

    private void c() {
        c a2 = c.a(this.m);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.h = resources.getDimensionPixelSize(R.dimen.dp16);
        this.i = resources.getDimensionPixelSize(R.dimen.dp8);
        a();
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f25438a = (ImageView) aVar.internalFindViewById(R.id.icon);
        this.f25439b = (TextView) aVar.internalFindViewById(R.id.title);
        this.f25440c = aVar.internalFindViewById(R.id.sub_title_section);
        this.f25441d = (TextView) aVar.internalFindViewById(R.id.sub_title);
        this.f25442e = (TextView) aVar.internalFindViewById(R.id.sub_title_end);
        this.f25443f = (f) aVar.internalFindViewById(R.id.badge);
        this.f25444g = (TextView) aVar.internalFindViewById(R.id.left_button);
        b();
    }
}
