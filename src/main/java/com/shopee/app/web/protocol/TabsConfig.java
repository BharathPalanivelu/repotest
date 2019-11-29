package com.shopee.app.web.protocol;

import android.graphics.Color;
import com.garena.android.appkit.tools.b;
import com.shopee.id.R;

public class TabsConfig {
    private String activeColor;
    private String barColor;
    private int tabIndex = 0;
    private String textColor;
    private float textSize;
    private float textSizeActive;

    public int getTextColor() {
        try {
            return Color.parseColor(this.textColor);
        } catch (Exception unused) {
            return b.a(R.color.secondary65);
        }
    }

    public int getActiveColor() {
        try {
            return Color.parseColor(this.activeColor);
        } catch (Exception unused) {
            return b.a(R.color.primary);
        }
    }

    public int getBarColor() {
        try {
            return Color.parseColor(this.barColor);
        } catch (Exception unused) {
            return b.a(R.color.white);
        }
    }

    public float getTextSize() {
        return this.textSize;
    }

    public float getTextSizeActive() {
        return this.textSizeActive;
    }

    public int getTabIndex() {
        return this.tabIndex;
    }
}
