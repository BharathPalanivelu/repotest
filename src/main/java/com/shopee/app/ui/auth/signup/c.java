package com.shopee.app.ui.auth.signup;

import android.graphics.Bitmap;
import android.net.Uri;
import com.shopee.app.data.store.setting.ImageConfig;
import com.shopee.app.h.b.a;
import com.shopee.app.h.l;

public class c {
    public static boolean a(String str) {
        if (str.length() < 5 || str.length() > 30 || str.matches("[0-9]+") || !str.matches("[a-zA-Z0-9._]*$")) {
            return false;
        }
        return true;
    }

    public static String a(Uri uri, ImageConfig imageConfig) {
        Bitmap a2 = l.a().a(uri, imageConfig.getFullImageWidth(), imageConfig.getFullImageHeight());
        if (a2 == null) {
            return null;
        }
        String a3 = a.a().a(l.a().a(a2, imageConfig.getFullImageQuality()));
        a.a().a(a3, l.a().a(l.b(a2, imageConfig.getThumbImageWidth(), imageConfig.getThumbImageHeight()), imageConfig.getThumbImageQuality()));
        if (!a2.isRecycled()) {
            a2.recycle();
        }
        return a3;
    }
}
