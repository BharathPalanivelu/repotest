package com.c.a.c.c;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.appsflyer.share.Constants;
import com.c.a.c.c.n;
import com.c.a.c.j;
import java.io.File;
import java.io.InputStream;

public class u<Data> implements n<String, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final n<Uri, Data> f5979a;

    public boolean a(String str) {
        return true;
    }

    public u(n<Uri, Data> nVar) {
        this.f5979a = nVar;
    }

    public n.a<Data> a(String str, int i, int i2, j jVar) {
        Uri b2 = b(str);
        if (b2 == null) {
            return null;
        }
        return this.f5979a.a(b2, i, i2, jVar);
    }

    private static Uri b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(Constants.URL_PATH_DELIMITER)) {
            return c(str);
        }
        Uri parse = Uri.parse(str);
        return parse.getScheme() == null ? c(str) : parse;
    }

    private static Uri c(String str) {
        return Uri.fromFile(new File(str));
    }

    public static class b implements o<String, InputStream> {
        public n<String, InputStream> a(r rVar) {
            return new u(rVar.a(Uri.class, InputStream.class));
        }
    }

    public static class a implements o<String, ParcelFileDescriptor> {
        public n<String, ParcelFileDescriptor> a(r rVar) {
            return new u(rVar.a(Uri.class, ParcelFileDescriptor.class));
        }
    }
}
