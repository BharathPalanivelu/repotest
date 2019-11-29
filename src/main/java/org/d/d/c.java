package org.d.d;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f33964a;

    /* renamed from: b  reason: collision with root package name */
    private int f33965b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f33966c;

    /* renamed from: d  reason: collision with root package name */
    private InputStream f33967d;

    /* renamed from: e  reason: collision with root package name */
    private String f33968e;

    c(HttpURLConnection httpURLConnection) throws IOException {
        try {
            httpURLConnection.connect();
            this.f33968e = httpURLConnection.getURL().toString();
            this.f33965b = httpURLConnection.getResponseCode();
            this.f33966c = a(httpURLConnection);
            this.f33967d = g() ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream();
        } catch (UnknownHostException unused) {
            this.f33965b = a.NOT_FOUND.value();
            this.f33964a = "";
        }
    }

    public String a() {
        return this.f33968e;
    }

    private String f() {
        return d.a(c());
    }

    private Map<String, String> a(HttpURLConnection httpURLConnection) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry entry : httpURLConnection.getHeaderFields().entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (!(str == null || list == null || list.size() <= 0)) {
                String str2 = (String) list.get(0);
                if (str2 != null) {
                    treeMap.put(str, str2);
                }
            }
        }
        return treeMap;
    }

    private boolean g() {
        return d() >= 200 && d() < 400;
    }

    public String b() {
        if (this.f33964a == null) {
            this.f33964a = f();
        }
        return this.f33964a;
    }

    public InputStream c() {
        return this.f33967d;
    }

    public int d() {
        return this.f33965b;
    }

    public Map<String, String> e() {
        return this.f33966c;
    }
}
