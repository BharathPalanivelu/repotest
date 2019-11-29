package com.shopee.app.react.modules.ui.tab;

import com.facebook.react.bridge.Promise;
import com.google.a.o;
import com.shopee.app.react.modules.base.b;

public class a extends b {
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.app.Activity r6, int r7, java.lang.String r8, com.facebook.react.bridge.Promise r9) {
        /*
            r5 = this;
            java.lang.String r0 = "#"
            com.google.a.f r1 = com.shopee.app.web.WebRegister.GSON
            java.lang.Class<com.shopee.app.web.protocol.DimActionBarMessage> r2 = com.shopee.app.web.protocol.DimActionBarMessage.class
            java.lang.Object r8 = r1.a((java.lang.String) r8, r2)
            com.shopee.app.web.protocol.DimActionBarMessage r8 = (com.shopee.app.web.protocol.DimActionBarMessage) r8
            if (r6 == 0) goto L_0x0066
            boolean r1 = r6 instanceof com.shopee.app.util.y
            if (r1 == 0) goto L_0x0066
            com.shopee.app.util.y r6 = (com.shopee.app.util.y) r6
            boolean r1 = r8.isDim
            r2 = 0
            if (r1 == 0) goto L_0x0052
            java.lang.String r1 = r8.color     // Catch:{ NumberFormatException -> 0x0052 }
            boolean r1 = r1.startsWith(r0)     // Catch:{ NumberFormatException -> 0x0052 }
            if (r1 != 0) goto L_0x0034
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0052 }
            r1.<init>()     // Catch:{ NumberFormatException -> 0x0052 }
            r1.append(r0)     // Catch:{ NumberFormatException -> 0x0052 }
            java.lang.String r0 = r8.color     // Catch:{ NumberFormatException -> 0x0052 }
            r1.append(r0)     // Catch:{ NumberFormatException -> 0x0052 }
            java.lang.String r0 = r1.toString()     // Catch:{ NumberFormatException -> 0x0052 }
            r8.color = r0     // Catch:{ NumberFormatException -> 0x0052 }
        L_0x0034:
            java.lang.String r0 = r8.color     // Catch:{ NumberFormatException -> 0x0052 }
            int r0 = android.graphics.Color.parseColor(r0)     // Catch:{ NumberFormatException -> 0x0052 }
            float r1 = r8.alpha     // Catch:{ NumberFormatException -> 0x0052 }
            r3 = 1132396544(0x437f0000, float:255.0)
            float r1 = r1 * r3
            int r1 = (int) r1     // Catch:{ NumberFormatException -> 0x0052 }
            int r3 = android.graphics.Color.red(r0)     // Catch:{ NumberFormatException -> 0x0052 }
            int r4 = android.graphics.Color.green(r0)     // Catch:{ NumberFormatException -> 0x0052 }
            int r0 = android.graphics.Color.blue(r0)     // Catch:{ NumberFormatException -> 0x0052 }
            int r0 = android.graphics.Color.argb(r1, r3, r4, r0)     // Catch:{ NumberFormatException -> 0x0052 }
            goto L_0x0053
        L_0x0052:
            r0 = 0
        L_0x0053:
            boolean r7 = r6.b(r7)
            if (r7 == 0) goto L_0x0062
            boolean r7 = r8.isDim
            r6.a(r7, r0)
            r5.a(r9, r2)
            goto L_0x0066
        L_0x0062:
            r6 = 1
            r5.a(r9, r6)
        L_0x0066:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.react.modules.ui.tab.a.a(android.app.Activity, int, java.lang.String, com.facebook.react.bridge.Promise):void");
    }

    private void a(Promise promise, int i) {
        o oVar = new o();
        oVar.a("status", (Number) Integer.valueOf(i));
        promise.resolve(oVar.toString());
    }
}
