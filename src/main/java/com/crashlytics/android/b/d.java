package com.crashlytics.android.b;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f6386a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6387b;

    /* renamed from: c  reason: collision with root package name */
    public final String f6388c;

    /* renamed from: d  reason: collision with root package name */
    public final String f6389d;

    d(String str, String str2, String str3, String str4) {
        this.f6386a = str;
        this.f6387b = str2;
        this.f6388c = str3;
        this.f6389d = str4;
    }

    public static d a(Properties properties) {
        return new d(properties.getProperty("version_code"), properties.getProperty("version_name"), properties.getProperty("build_id"), properties.getProperty("package_name"));
    }

    public static d a(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(inputStream);
        return a(properties);
    }
}
