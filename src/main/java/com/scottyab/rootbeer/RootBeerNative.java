package com.scottyab.rootbeer;

import com.scottyab.rootbeer.a.a;

public class RootBeerNative {

    /* renamed from: a  reason: collision with root package name */
    static boolean f15724a = true;

    public native int checkForRoot(Object[] objArr);

    public native int setLogDebugMessages(boolean z);

    static {
        try {
            System.loadLibrary("tool-checker");
        } catch (UnsatisfiedLinkError e2) {
            a.a(e2);
        }
    }

    public boolean a() {
        return f15724a;
    }
}
