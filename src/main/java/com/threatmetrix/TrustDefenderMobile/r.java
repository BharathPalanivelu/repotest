package com.threatmetrix.TrustDefenderMobile;

import android.net.Proxy;
import java.lang.reflect.Method;

class r extends af {

    /* renamed from: a  reason: collision with root package name */
    private static final Method f32600a = a(Proxy.class, "getDefaultHost", new Class[0]);

    /* renamed from: b  reason: collision with root package name */
    private static final Method f32601b = a(Proxy.class, "getDefaultPort", new Class[0]);

    /* renamed from: c  reason: collision with root package name */
    private static final String f32602c = "com.threatmetrix.TrustDefenderMobile.r";

    /* renamed from: d  reason: collision with root package name */
    private String f32603d = null;

    /* renamed from: e  reason: collision with root package name */
    private int f32604e = 0;

    public r() {
        String property = System.getProperty("http.proxyHost");
        if (property != null && !property.isEmpty()) {
            this.f32603d = property;
        }
        String property2 = System.getProperty("http.proxyPort");
        if (property2 != null && !property2.isEmpty()) {
            try {
                this.f32604e = Integer.parseInt(property2);
            } catch (NumberFormatException unused) {
            }
        }
        if (this.f32603d == null || this.f32604e == 0) {
            Integer num = (Integer) a((Object) null, f32601b, new Object[0]);
            if (num != null) {
                this.f32604e = num.intValue();
            }
            String str = (String) a((Object) null, f32600a, new Object[0]);
            if (str != null) {
                this.f32603d = str;
            }
        }
    }

    public String a() {
        return this.f32603d;
    }

    public int b() {
        return this.f32604e;
    }
}
