package com.modiface.mfemakeupkit.utils;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static volatile int f15362a;

    public static synchronized int a() {
        int i;
        synchronized (f.class) {
            if (f15362a >= 2147483646) {
                f15362a = 0;
            }
            f15362a++;
            i = f15362a;
        }
        return i;
    }
}
