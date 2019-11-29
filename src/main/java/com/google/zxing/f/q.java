package com.google.zxing.f;

import com.google.zxing.w;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public abstract class q {

    /* renamed from: a  reason: collision with root package name */
    private static final q[] f14737a = {new c(), new b(), new v(), new r(), new t(), new h(), new ac(), new aa(), new z(), new j(), new n(), new f()};

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f14738b = Pattern.compile("\\d+");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f14739c = Pattern.compile("&");

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f14740d = Pattern.compile(SimpleComparison.EQUAL_TO_OPERATION);

    public abstract k b(w wVar);

    protected static String c(w wVar) {
        String a2 = wVar.a();
        return a2.startsWith("﻿") ? a2.substring(1) : a2;
    }

    public static k d(w wVar) {
        for (q b2 : f14737a) {
            k b3 = b2.b(wVar);
            if (b3 != null) {
                return b3;
            }
        }
        return new w(wVar.a(), (String) null);
    }

    protected static String[] a(String str) {
        if (str == null) {
            return null;
        }
        return new String[]{str};
    }

    protected static String b(String str) {
        int indexOf = str.indexOf(92);
        if (indexOf < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length - 1);
        sb.append(str.toCharArray(), 0, indexOf);
        boolean z = false;
        while (indexOf < length) {
            char charAt = str.charAt(indexOf);
            if (z || charAt != '\\') {
                sb.append(charAt);
                z = false;
            } else {
                z = true;
            }
            indexOf++;
        }
        return sb.toString();
    }

    protected static boolean a(CharSequence charSequence, int i) {
        return charSequence != null && i > 0 && i == charSequence.length() && f14738b.matcher(charSequence).matches();
    }

    protected static boolean a(CharSequence charSequence, int i, int i2) {
        if (charSequence == null || i2 <= 0) {
            return false;
        }
        int i3 = i2 + i;
        return charSequence.length() >= i3 && f14738b.matcher(charSequence.subSequence(i, i3)).matches();
    }

    static Map<String, String> c(String str) {
        int indexOf = str.indexOf(63);
        if (indexOf < 0) {
            return null;
        }
        HashMap hashMap = new HashMap(3);
        for (String a2 : f14739c.split(str.substring(indexOf + 1))) {
            a((CharSequence) a2, (Map<String, String>) hashMap);
        }
        return hashMap;
    }

    private static void a(CharSequence charSequence, Map<String, String> map) {
        String[] split = f14740d.split(charSequence, 2);
        if (split.length == 2) {
            try {
                map.put(split[0], d(split[1]));
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    static String d(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalStateException(e2);
        }
    }

    static String[] a(String str, String str2, char c2, boolean z) {
        int i;
        int length = str2.length();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < length; i2 = i) {
            int indexOf = str2.indexOf(str, i2);
            if (indexOf < 0) {
                break;
            }
            int length2 = indexOf + str.length();
            boolean z2 = true;
            i = length2;
            while (z2) {
                int indexOf2 = str2.indexOf(c2, i);
                if (indexOf2 < 0) {
                    i = str2.length();
                } else if (b(str2, indexOf2) % 2 != 0) {
                    i = indexOf2 + 1;
                } else {
                    if (arrayList == null) {
                        arrayList = new ArrayList(3);
                    }
                    String b2 = b(str2.substring(length2, indexOf2));
                    if (z) {
                        b2 = b2.trim();
                    }
                    if (!b2.isEmpty()) {
                        arrayList.add(b2);
                    }
                    i = indexOf2 + 1;
                }
                z2 = false;
            }
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static int b(CharSequence charSequence, int i) {
        int i2 = i - 1;
        int i3 = 0;
        while (i2 >= 0 && charSequence.charAt(i2) == '\\') {
            i3++;
            i2--;
        }
        return i3;
    }

    static String b(String str, String str2, char c2, boolean z) {
        String[] a2 = a(str, str2, c2, z);
        if (a2 == null) {
            return null;
        }
        return a2[0];
    }
}
