package io.a.a.a.a.g;

import android.content.Context;
import android.graphics.BitmapFactory;
import io.a.a.a.a.b.i;
import io.a.a.a.c;
import io.a.a.a.l;

public class n {

    /* renamed from: a  reason: collision with root package name */
    public final String f33239a;

    /* renamed from: b  reason: collision with root package name */
    public final int f33240b;

    /* renamed from: c  reason: collision with root package name */
    public final int f33241c;

    /* renamed from: d  reason: collision with root package name */
    public final int f33242d;

    public n(String str, int i, int i2, int i3) {
        this.f33239a = str;
        this.f33240b = i;
        this.f33241c = i2;
        this.f33242d = i3;
    }

    public static n a(Context context, String str) {
        if (str != null) {
            try {
                int l = i.l(context);
                l h = c.h();
                h.a("Fabric", "App icon resource ID is " + l);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(context.getResources(), l, options);
                return new n(str, l, options.outWidth, options.outHeight);
            } catch (Exception e2) {
                c.h().e("Fabric", "Failed to load icon", e2);
            }
        }
        return null;
    }
}
