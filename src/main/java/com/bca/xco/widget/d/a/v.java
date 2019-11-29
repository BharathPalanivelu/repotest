package com.bca.xco.widget.d.a;

import java.io.IOException;

public enum v {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");
    

    /* renamed from: e  reason: collision with root package name */
    private final String f5167e;

    private v(String str) {
        this.f5167e = str;
    }

    public static v a(String str) {
        if (str.equals(HTTP_1_0.f5167e)) {
            return HTTP_1_0;
        }
        if (str.equals(HTTP_1_1.f5167e)) {
            return HTTP_1_1;
        }
        if (str.equals(HTTP_2.f5167e)) {
            return HTTP_2;
        }
        if (str.equals(SPDY_3.f5167e)) {
            return SPDY_3;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    public String toString() {
        return this.f5167e;
    }
}
