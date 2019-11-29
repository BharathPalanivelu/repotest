package com.rengwuxian.materialedittext;

import android.graphics.Color;

public class a {
    public static boolean a(int i) {
        double red = (double) (Color.red(i) * Color.red(i));
        Double.isNaN(red);
        double green = (double) (Color.green(i) * Color.green(i));
        Double.isNaN(green);
        double d2 = (red * 0.241d) + (green * 0.691d);
        double blue = (double) (Color.blue(i) * Color.blue(i));
        Double.isNaN(blue);
        return Math.sqrt(d2 + (blue * 0.068d)) > 130.0d;
    }
}
