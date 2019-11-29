package com.garena.sticker.d;

import com.appsflyer.share.Constants;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f8680a;

    /* renamed from: b  reason: collision with root package name */
    private static float[] f8681b = {1.0f, 1.5f, 2.0f, 3.0f};

    public static void a(String str) {
        f8680a = str;
    }

    private static float b(float f2) {
        for (float f3 : f8681b) {
            if (f3 >= f2) {
                return f2;
            }
        }
        float[] fArr = f8681b;
        return fArr[fArr.length - 1];
    }

    public static String a(float f2) {
        float b2 = b(f2);
        if (b2 == 1.0f) {
            return "@1x";
        }
        if (b2 == 1.5f) {
            return "@1.5x";
        }
        if (b2 == 2.0f) {
            return "@2x";
        }
        if (b2 == 3.0f) {
        }
        return "@3x";
    }

    public static String a(String str, String str2, String str3, String str4) {
        return f8680a + "packs/" + str + Constants.URL_PATH_DELIMITER + str2 + str3 + "." + str4;
    }

    public static String a(String str, String str2) {
        return f8680a + "packs/" + str + "/icon" + str2 + ".png";
    }

    public static String b(String str, String str2) {
        return f8680a + "packs/" + str + "/download" + str2 + ".png";
    }
}
