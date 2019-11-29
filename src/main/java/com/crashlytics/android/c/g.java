package com.crashlytics.android.c;

import com.crashlytics.android.c.am;

class g implements s {

    /* renamed from: a  reason: collision with root package name */
    private final t f6471a;

    /* renamed from: b  reason: collision with root package name */
    private final ad f6472b;

    public g(t tVar, ad adVar) {
        this.f6471a = tVar;
        this.f6472b = adVar;
    }

    /* renamed from: com.crashlytics.android.c.g$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f6473a = new int[am.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.crashlytics.android.c.am$a[] r0 = com.crashlytics.android.c.am.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6473a = r0
                int[] r0 = f6473a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.crashlytics.android.c.am$a r1 = com.crashlytics.android.c.am.a.JAVA     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f6473a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.crashlytics.android.c.am$a r1 = com.crashlytics.android.c.am.a.NATIVE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.c.g.AnonymousClass1.<clinit>():void");
        }
    }

    public boolean a(r rVar) {
        int i = AnonymousClass1.f6473a[rVar.f6591b.g().ordinal()];
        if (i == 1) {
            this.f6471a.a(rVar);
            return true;
        } else if (i != 2) {
            return false;
        } else {
            this.f6472b.a(rVar);
            return true;
        }
    }
}
