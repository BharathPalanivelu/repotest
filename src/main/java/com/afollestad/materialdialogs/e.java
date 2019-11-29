package com.afollestad.materialdialogs;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;

public enum e {
    START,
    CENTER,
    END;
    

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f3146a = false;

    /* renamed from: com.afollestad.materialdialogs.e$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3147a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.afollestad.materialdialogs.e[] r0 = com.afollestad.materialdialogs.e.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3147a = r0
                int[] r0 = f3147a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.afollestad.materialdialogs.e r1 = com.afollestad.materialdialogs.e.START     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f3147a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.afollestad.materialdialogs.e r1 = com.afollestad.materialdialogs.e.CENTER     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f3147a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.afollestad.materialdialogs.e r1 = com.afollestad.materialdialogs.e.END     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.e.AnonymousClass1.<clinit>():void");
        }
    }

    @SuppressLint({"RtlHardcoded"})
    public int getGravityInt() {
        int i = AnonymousClass1.f3147a[ordinal()];
        if (i != 1) {
            if (i == 2) {
                return 1;
            }
            if (i == 3) {
                return f3146a ? 8388613 : 5;
            }
            throw new IllegalStateException("Invalid gravity constant");
        } else if (f3146a) {
            return 8388611;
        } else {
            return 3;
        }
    }

    @TargetApi(17)
    public int getTextAlignment() {
        int i = AnonymousClass1.f3147a[ordinal()];
        if (i != 2) {
            return i != 3 ? 5 : 6;
        }
        return 4;
    }
}
