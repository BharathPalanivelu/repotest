package com.google.zxing.f;

import com.google.zxing.w;
import com.tencent.qcloud.core.util.IOUtils;
import java.util.ArrayList;

public final class b extends q {
    /* renamed from: a */
    public d b(w wVar) {
        String c2 = c(wVar);
        String[] strArr = null;
        if (!c2.contains("MEMORY") || !c2.contains(IOUtils.LINE_SEPARATOR_WINDOWS)) {
            return null;
        }
        String b2 = b("NAME1:", c2, 13, true);
        String b3 = b("NAME2:", c2, 13, true);
        String[] a2 = a("TEL", 3, c2, true);
        String[] a3 = a("MAIL", 3, c2, true);
        String b4 = b("MEMORY:", c2, 13, false);
        String b5 = b("ADD:", c2, 13, true);
        if (b5 != null) {
            strArr = new String[]{b5};
        }
        return new d(a(b2), (String[]) null, b3, a2, (String[]) null, a3, (String[]) null, (String) null, b4, strArr, (String[]) null, (String) null, (String) null, (String) null, (String[]) null, (String[]) null);
    }

    private static String[] a(String str, int i, String str2, boolean z) {
        ArrayList arrayList = null;
        for (int i2 = 1; i2 <= i; i2++) {
            String b2 = b(str + i2 + ':', str2, 13, z);
            if (b2 == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList(i);
            }
            arrayList.add(b2);
        }
        if (arrayList == null) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
