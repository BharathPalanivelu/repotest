package com.shopee.app.util.r;

import android.net.Uri;
import d.d.b.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f26498a = new a();

    private a() {
    }

    public static final int a(String str) {
        j.b(str, "url");
        String queryParameter = Uri.parse(str).getQueryParameter("type");
        if (queryParameter != null) {
            int hashCode = queryParameter.hashCode();
            if (hashCode != 3680) {
                if (hashCode != 103407) {
                    if (hashCode != 108273) {
                    }
                    return 3;
                } else if (queryParameter.equals("hls")) {
                    return 2;
                }
            } else if (queryParameter.equals("ss")) {
                return 1;
            }
        }
        return 0;
    }
}
