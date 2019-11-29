package com.google.zxing.f;

import com.google.zxing.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class r extends q {
    /* renamed from: a */
    public s b(w wVar) {
        String str;
        String str2;
        String c2 = c(wVar);
        String str3 = null;
        if (!c2.startsWith("sms:") && !c2.startsWith("SMS:") && !c2.startsWith("mms:") && !c2.startsWith("MMS:")) {
            return null;
        }
        Map<String, String> c3 = c(c2);
        boolean z = false;
        if (c3 == null || c3.isEmpty()) {
            str = null;
        } else {
            str3 = c3.get("subject");
            str = c3.get("body");
            z = true;
        }
        int indexOf = c2.indexOf(63, 4);
        if (indexOf < 0 || !z) {
            str2 = c2.substring(4);
        } else {
            str2 = c2.substring(4, indexOf);
        }
        int i = -1;
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        while (true) {
            int i2 = i + 1;
            int indexOf2 = str2.indexOf(44, i2);
            if (indexOf2 > i) {
                a(arrayList, arrayList2, str2.substring(i2, indexOf2));
                i = indexOf2;
            } else {
                a(arrayList, arrayList2, str2.substring(i2));
                return new s((String[]) arrayList.toArray(new String[arrayList.size()]), (String[]) arrayList2.toArray(new String[arrayList2.size()]), str3, str);
            }
        }
    }

    private static void a(Collection<String> collection, Collection<String> collection2, String str) {
        int indexOf = str.indexOf(59);
        String str2 = null;
        if (indexOf < 0) {
            collection.add(str);
            collection2.add((Object) null);
            return;
        }
        collection.add(str.substring(0, indexOf));
        String substring = str.substring(indexOf + 1);
        if (substring.startsWith("via=")) {
            str2 = substring.substring(4);
        }
        collection2.add(str2);
    }
}
