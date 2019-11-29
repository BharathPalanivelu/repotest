package org.d.f;

import java.util.regex.Pattern;
import org.apache.commons.c.d;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f33978a = Pattern.compile("^[a-zA-Z][a-zA-Z0-9+.-]*://\\S+");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f33979b = Pattern.compile("(-)?[0-9]+(\\.)?[0-9]*");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f33980c = Pattern.compile("[0-9]+");

    public static void a(Object obj, String str) {
        a(obj != null, str);
    }

    public static void a(Object obj, Object obj2, String str) {
        a((obj == null && obj2 == null) ? false : true, str);
    }

    public static void a(String str, String str2) {
        a(d.c(str), str2);
    }

    private static void a(boolean z, String str) {
        if (d.b(str)) {
            str = "Received an invalid parameter";
        }
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }
}
