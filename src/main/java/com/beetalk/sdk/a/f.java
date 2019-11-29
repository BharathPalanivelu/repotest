package com.beetalk.sdk.a;

import com.beetalk.sdk.data.a;
import com.beetalk.sdk.l;
import java.util.HashMap;
import java.util.Map;

public abstract class f {
    public abstract void a(String str);

    public abstract void a(Map<String, String> map);

    public abstract Map b();

    public void c() {
        a("com.garena.msdk.token");
        a("com.garena.msdk.guest_token");
        a("com.garena.msdk.guest_token_sandbox");
    }

    public void a(a aVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("com.garena.msdk.token", a.a(aVar));
        a((Map<String, String>) hashMap);
    }

    private String a() {
        if (l.a() == l.a.TEST) {
            return "com.garena.msdk.guest_token_sandbox";
        }
        if (l.a() == l.a.PRODUCTION) {
        }
        return "com.garena.msdk.guest_token";
    }

    private String f() {
        if (l.a() == l.a.TEST) {
            return "com.garena.msdk.guest_uid_sandbox";
        }
        if (l.a() == l.a.PRODUCTION) {
        }
        return "com.garena.msdk.guest_uid";
    }

    private String g() {
        if (l.a() == l.a.TEST) {
            return "com.garena.msdk.guest_password_sandbox";
        }
        if (l.a() == l.a.PRODUCTION) {
        }
        return "com.garena.msdk.guest_password";
    }

    public void b(a aVar) {
        HashMap hashMap = new HashMap();
        hashMap.put(a(), a.a(aVar));
        a((Map<String, String>) hashMap);
    }

    public String d() {
        return (String) b().get(f());
    }

    public String e() {
        return (String) b().get(g());
    }

    public void a(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put(f(), String.valueOf(j));
        a((Map<String, String>) hashMap);
    }

    public void b(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(g(), str);
        a((Map<String, String>) hashMap);
    }
}
