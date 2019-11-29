package com.shopee.feeds.feedlibrary.editor.multitouch;

import android.graphics.PointF;

public class Vector2D extends PointF {
    public static float a(Vector2D vector2D, Vector2D vector2D2) {
        vector2D.a();
        vector2D2.a();
        return (float) ((Math.atan2((double) vector2D2.y, (double) vector2D2.x) - Math.atan2((double) vector2D.y, (double) vector2D.x)) * 57.29577951308232d);
    }

    public void a() {
        float sqrt = (float) Math.sqrt((double) ((this.x * this.x) + (this.y * this.y)));
        this.x /= sqrt;
        this.y /= sqrt;
    }
}
