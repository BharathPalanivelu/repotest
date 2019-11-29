package org.apache.commons.c;

public class e {
    public static void a(long j, long j2, long j3, String str) {
        if (j3 < j || j3 > j2) {
            throw new IllegalArgumentException(String.format(str, new Object[0]));
        }
    }
}
