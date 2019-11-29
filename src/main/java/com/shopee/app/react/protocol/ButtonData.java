package com.shopee.app.react.protocol;

import android.graphics.Color;
import com.garena.android.appkit.tools.a.b;
import com.shopee.id.R;

public class ButtonData {
    private String color = "#ff009688";
    private String eventID;
    private float fontSize = ((float) b.a.h);
    private String title;

    public String getTitle() {
        return this.title;
    }

    public int getColor() {
        try {
            return Color.parseColor(this.color);
        } catch (Exception unused) {
            return com.garena.android.appkit.tools.b.a(R.color.link_text_material_light);
        }
    }

    public float getFontSize() {
        return this.fontSize;
    }

    public String getEventID() {
        return this.eventID;
    }
}
