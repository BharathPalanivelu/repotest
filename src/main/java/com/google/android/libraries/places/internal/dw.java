package com.google.android.libraries.places.internal;

import android.content.Context;

public abstract class dw {

    public static abstract class a {
        /* access modifiers changed from: package-private */
        public abstract a a(int i);

        public abstract a a(b bVar);

        /* access modifiers changed from: package-private */
        public abstract a a(String str);

        /* access modifiers changed from: package-private */
        public abstract dw a();

        public final dw b() {
            dw a2 = a();
            go.b(!a2.a().isEmpty(), (Object) "Package name must not be empty.");
            return a2;
        }
    }

    public enum b {
        PROGRAMMATIC_API,
        AUTOCOMPLETE_WIDGET
    }

    public abstract String a();

    public abstract int b();

    public abstract b c();

    public static a a(Context context) {
        fg fgVar = new fg(context);
        return new du().a(fgVar.c()).a(fgVar.d()).a(b.PROGRAMMATIC_API);
    }
}
