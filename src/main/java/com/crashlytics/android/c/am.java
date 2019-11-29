package com.crashlytics.android.c;

import java.io.File;
import java.util.Map;

interface am {

    public enum a {
        JAVA,
        NATIVE
    }

    String a();

    String b();

    File c();

    File[] d();

    Map<String, String> e();

    void f();

    a g();
}
