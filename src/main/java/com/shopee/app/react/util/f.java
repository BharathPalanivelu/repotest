package com.shopee.app.react.util;

import com.google.a.l;
import com.google.a.o;

public class f {
    public static o a(String str, int i, int i2, int i3, boolean z) {
        o oVar = new o();
        oVar.a("user_input", str);
        if (i2 != -1) {
            o oVar2 = new o();
            oVar2.a("last_seen_location", (Number) Integer.valueOf(i));
            oVar2.a("click_location", (Number) Integer.valueOf(i2));
            oVar2.a("history", Boolean.valueOf(z));
            oVar2.a("catid", (Number) Integer.valueOf(i3));
            oVar.a("auto_complete", (l) oVar2);
        }
        return oVar;
    }

    public static o a(String str) {
        return a(str, -1, -1, -1, false);
    }
}
