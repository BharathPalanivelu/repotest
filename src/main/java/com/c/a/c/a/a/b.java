package com.c.a.c.a.a;

import android.net.Uri;
import com.facebook.common.util.UriUtil;

public final class b {
    public static boolean a(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= 384;
    }

    public static boolean a(Uri uri) {
        return uri != null && UriUtil.LOCAL_CONTENT_SCHEME.equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    private static boolean d(Uri uri) {
        return uri.getPathSegments().contains("video");
    }

    public static boolean b(Uri uri) {
        return a(uri) && d(uri);
    }

    public static boolean c(Uri uri) {
        return a(uri) && !d(uri);
    }
}
