package com.airpay.paysdk.base.ui.weidget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.airpay.paysdk.c;

public class h extends LayerDrawable {

    /* renamed from: a  reason: collision with root package name */
    private int f3942a;

    /* renamed from: b  reason: collision with root package name */
    private int f3943b;

    /* renamed from: c  reason: collision with root package name */
    private int f3944c;

    public boolean isStateful() {
        return true;
    }

    public h(Context context, int i) {
        this(context, context.getResources().getDrawable(i));
    }

    public h(Context context, Drawable drawable) {
        super(new Drawable[]{drawable});
        mutate();
        a(context, 0);
    }

    public void a(int i, int i2, int i3) {
        this.f3942a = i;
        this.f3943b = i2;
        this.f3944c = i3;
    }

    public h a(Context context, int i) {
        int i2;
        int i3;
        int i4;
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                i2 = resources.getColor(c.b.com_garena_beepay_bg_color_white);
                i4 = resources.getColor(c.b.com_garena_beepay_divider_grey);
                i3 = resources.getColor(c.b.com_garena_beepay_divider_grey);
                break;
            case 2:
                i2 = resources.getColor(c.b.transparent);
                i4 = resources.getColor(c.b.com_garena_beepay_bg_color_pressed_mask);
                break;
            case 3:
                i2 = resources.getColor(c.b.com_garena_beepay_action_bar_normal);
                i4 = resources.getColor(c.b.com_garena_beepay_action_bar_pressed_or_disabled);
                i3 = resources.getColor(c.b.com_garena_beepay_action_bar_pressed_or_disabled);
                break;
            case 4:
                i2 = resources.getColor(c.b.bg_color_white);
                i4 = resources.getColor(c.b.color_translucent_white);
                i3 = i4;
                break;
            case 5:
                i2 = resources.getColor(c.b.color_tab_item_off);
                i4 = resources.getColor(c.b.color_tab_item_on_blue);
                break;
            case 6:
                i2 = resources.getColor(c.b.bg_color_white);
                i4 = resources.getColor(c.b.color_translucent_white);
                i3 = resources.getColor(c.b.color_translucent_white);
                break;
            case 7:
                i2 = resources.getColor(c.b.color_tab_item_off);
                i4 = resources.getColor(c.b.color_tab_item_on_red);
                break;
            case 8:
                i2 = resources.getColor(c.b.com_garena_beepay_quantity_selector_normal);
                i4 = resources.getColor(c.b.com_garena_beepay_quantity_selector_normal);
                i3 = resources.getColor(c.b.com_garena_beepay_quantity_selector_disable);
                break;
            default:
                i2 = resources.getColor(c.b.com_garena_beepay_txt_clickable_blue_normal);
                i4 = resources.getColor(c.b.bg_color_blue_dark);
                i3 = resources.getColor(c.b.com_garena_beepay_button_default_disabled);
                break;
        }
        i3 = i2;
        a(i4, i2, i3);
        onStateChange(getState());
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i : iArr) {
            if (i == 16842910) {
                z = true;
            } else if (i == 16842919) {
                z2 = true;
            } else if (i == 16842913) {
                z3 = true;
            }
        }
        if (!z) {
            super.setColorFilter(this.f3944c, PorterDuff.Mode.MULTIPLY);
        } else if (z2 || z3) {
            super.setColorFilter(this.f3942a, PorterDuff.Mode.MULTIPLY);
        } else {
            super.setColorFilter(this.f3943b, PorterDuff.Mode.MULTIPLY);
        }
        return super.onStateChange(iArr);
    }
}
