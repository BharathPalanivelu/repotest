package org.d.d;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.slf4j.Marker;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33969a = String.format("Cannot find specified encoding: %s", new Object[]{"UTF-8"});

    /* renamed from: b  reason: collision with root package name */
    private static final Set<a> f33970b;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add(new a("*", "%2A"));
        hashSet.add(new a(Marker.ANY_NON_NULL_MARKER, "%20"));
        hashSet.add(new a("%7E", "~"));
        f33970b = Collections.unmodifiableSet(hashSet);
    }

    public static String a(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    public static String a(Map<String, String> map) {
        org.d.f.e.a((Object) map, "Cannot url-encode a null object");
        return map.size() <= 0 ? "" : b(map);
    }

    private static String b(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer(map.size() * 20);
        for (Map.Entry next : map.entrySet()) {
            stringBuffer.append("&");
            stringBuffer.append(b((String) next.getKey()));
            if (next.getValue() != null) {
                stringBuffer.append(SimpleComparison.EQUAL_TO_OPERATION);
                stringBuffer.append(b((String) next.getValue()));
            }
        }
        return stringBuffer.toString().substring(1);
    }

    public static String b(String str) {
        org.d.f.e.a((Object) str, "Cannot encode null string");
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalStateException(f33969a, e2);
        }
    }

    public static String c(String str) {
        org.d.f.e.a((Object) str, "Cannot decode null string");
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalStateException(f33969a, e2);
        }
    }

    public static String a(String str, Map<String, String> map) {
        org.d.f.e.a((Object) str, "Cannot append to null URL");
        String a2 = a(map);
        if (a2.equals("")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str.indexOf(63) != -1 ? "&" : '?');
        String sb2 = sb.toString();
        return sb2 + a2;
    }

    public static Map<String, String> d(String str) {
        HashMap hashMap = new HashMap();
        if (str != null && str.length() > 0) {
            for (String split : str.split("&")) {
                String[] split2 = split.split(SimpleComparison.EQUAL_TO_OPERATION);
                hashMap.put(c(split2[0]), split2.length > 1 ? c(split2[1]) : "");
            }
        }
        return hashMap;
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f33971a;

        /* renamed from: b  reason: collision with root package name */
        private final String f33972b;

        a(String str, String str2) {
            this.f33971a = str;
            this.f33972b = str2;
        }
    }
}
