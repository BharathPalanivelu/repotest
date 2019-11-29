package org.apache.commons.b;

import com.tencent.qcloud.core.util.IOUtils;
import java.io.File;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f33832a = Character.toString('.');

    /* renamed from: b  reason: collision with root package name */
    private static final char f33833b = File.separatorChar;

    /* renamed from: c  reason: collision with root package name */
    private static final char f33834c;

    static {
        if (a()) {
            f33834c = IOUtils.DIR_SEPARATOR_UNIX;
        } else {
            f33834c = IOUtils.DIR_SEPARATOR_WINDOWS;
        }
    }

    static boolean a() {
        return f33833b == '\\';
    }

    public static int a(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static int b(String str) {
        if (str == null) {
            return -1;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (a(str) > lastIndexOf) {
            return -1;
        }
        return lastIndexOf;
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        int b2 = b(str);
        if (b2 == -1) {
            return "";
        }
        return str.substring(b2 + 1);
    }
}
