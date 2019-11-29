package com.c.a.c.d.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.c.a.c.b.s;
import com.c.a.c.j;
import com.c.a.c.k;
import com.facebook.common.util.UriUtil;
import java.io.IOException;
import java.util.List;

public class d implements k<Uri, Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6059a;

    public d(Context context) {
        this.f6059a = context.getApplicationContext();
    }

    public boolean a(Uri uri, j jVar) throws IOException {
        return uri.getScheme().equals(UriUtil.QUALIFIED_RESOURCE_SCHEME);
    }

    public s<Drawable> a(Uri uri, int i, int i2, j jVar) throws IOException {
        Context context;
        int a2 = a(uri);
        String authority = uri.getAuthority();
        if (authority.equals(this.f6059a.getPackageName())) {
            context = this.f6059a;
        } else {
            context = a(uri, authority);
        }
        return c.a(a.a(context, a2));
    }

    private Context a(Uri uri, String str) {
        try {
            return this.f6059a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e2);
        }
    }

    private int a(Uri uri) {
        Integer num;
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            String authority = uri.getAuthority();
            String str = pathSegments.get(1);
            num = Integer.valueOf(this.f6059a.getResources().getIdentifier(str, pathSegments.get(0), authority));
        } else {
            if (pathSegments.size() == 1) {
                try {
                    num = Integer.valueOf(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                }
            }
            num = null;
        }
        if (num == null) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
        } else if (num.intValue() != 0) {
            return num.intValue();
        } else {
            throw new IllegalArgumentException("Failed to obtain resource id for: " + uri);
        }
    }
}
