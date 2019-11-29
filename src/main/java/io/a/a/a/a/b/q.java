package io.a.a.a.a.b;

import android.content.Context;
import io.a.a.a.a.a.b;
import io.a.a.a.a.a.d;
import io.a.a.a.c;

public class q {

    /* renamed from: a  reason: collision with root package name */
    private final d<String> f33090a = new d<String>() {
        /* renamed from: a */
        public String b(Context context) throws Exception {
            String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            return installerPackageName == null ? "" : installerPackageName;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final b<String> f33091b = new b<>();

    public String a(Context context) {
        try {
            String a2 = this.f33091b.a(context, this.f33090a);
            if ("".equals(a2)) {
                return null;
            }
            return a2;
        } catch (Exception e2) {
            c.h().e("Fabric", "Failed to determine installer package name", e2);
            return null;
        }
    }
}
