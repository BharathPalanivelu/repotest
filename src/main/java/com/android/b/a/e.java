package com.android.b.a;

import com.android.b.b;
import com.android.b.i;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.qcloud.core.http.HttpConstants;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

public class e {
    public static b.a a(i iVar) {
        long j;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = iVar.f4614c;
        String str = map.get(HttpConstants.Header.DATE);
        long j2 = 0;
        long a2 = str != null ? a(str) : 0;
        String str2 = map.get(COSRequestHeaderKey.CACHE_CONTROL);
        int i = 0;
        if (str2 != null) {
            String[] split = str2.split(",");
            j = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    j = 0;
                }
                i++;
            }
            i = 1;
        } else {
            j = 0;
        }
        String str3 = map.get(COSRequestHeaderKey.EXPIRES);
        long a3 = str3 != null ? a(str3) : 0;
        String str4 = map.get("ETag");
        if (i != 0) {
            j2 = currentTimeMillis + (j * 1000);
        } else if (a2 > 0 && a3 >= a2) {
            j2 = currentTimeMillis + (a3 - a2);
        }
        b.a aVar = new b.a();
        aVar.f4582a = iVar.f4613b;
        aVar.f4583b = str4;
        aVar.f4586e = j2;
        aVar.f4585d = aVar.f4586e;
        aVar.f4584c = a2;
        aVar.f4587f = map;
        return aVar;
    }

    public static long a(String str) {
        try {
            return DateUtils.parseDate(str).getTime();
        } catch (DateParseException unused) {
            return 0;
        }
    }

    public static String a(Map<String, String> map) {
        String str = map.get(HttpConstants.Header.CONTENT_TYPE);
        if (str == null) {
            return "ISO-8859-1";
        }
        String[] split = str.split(";");
        for (int i = 1; i < split.length; i++) {
            String[] split2 = split[i].trim().split(SimpleComparison.EQUAL_TO_OPERATION);
            if (split2.length == 2 && split2[0].equals("charset")) {
                return split2[1];
            }
        }
        return "ISO-8859-1";
    }
}
