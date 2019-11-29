package com.crashlytics.android.a;

import android.app.Activity;
import java.util.Collections;
import java.util.Map;

final class ad {

    /* renamed from: a  reason: collision with root package name */
    public final ae f6283a;

    /* renamed from: b  reason: collision with root package name */
    public final long f6284b;

    /* renamed from: c  reason: collision with root package name */
    public final b f6285c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, String> f6286d;

    /* renamed from: e  reason: collision with root package name */
    public final String f6287e;

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, Object> f6288f;

    /* renamed from: g  reason: collision with root package name */
    public final String f6289g;
    public final Map<String, Object> h;
    private String i;

    enum b {
        START,
        RESUME,
        PAUSE,
        STOP,
        CRASH,
        INSTALL,
        CUSTOM,
        PREDEFINED
    }

    public static a a(b bVar, Activity activity) {
        return new a(bVar).a((Map<String, String>) Collections.singletonMap("activity", activity.getClass().getName()));
    }

    public static a a(long j) {
        return new a(b.INSTALL).a((Map<String, String>) Collections.singletonMap("installedAt", String.valueOf(j)));
    }

    public static a a(String str) {
        return new a(b.CRASH).a((Map<String, String>) Collections.singletonMap("sessionId", str));
    }

    public static a a(String str, String str2) {
        return a(str).b(Collections.singletonMap("exceptionName", str2));
    }

    public static a a(m mVar) {
        return new a(b.CUSTOM).a(mVar.a()).b(mVar.b());
    }

    private ad(ae aeVar, long j, b bVar, Map<String, String> map, String str, Map<String, Object> map2, String str2, Map<String, Object> map3) {
        this.f6283a = aeVar;
        this.f6284b = j;
        this.f6285c = bVar;
        this.f6286d = map;
        this.f6287e = str;
        this.f6288f = map2;
        this.f6289g = str2;
        this.h = map3;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final b f6290a;

        /* renamed from: b  reason: collision with root package name */
        final long f6291b = System.currentTimeMillis();

        /* renamed from: c  reason: collision with root package name */
        Map<String, String> f6292c = null;

        /* renamed from: d  reason: collision with root package name */
        String f6293d = null;

        /* renamed from: e  reason: collision with root package name */
        Map<String, Object> f6294e = null;

        /* renamed from: f  reason: collision with root package name */
        String f6295f = null;

        /* renamed from: g  reason: collision with root package name */
        Map<String, Object> f6296g = null;

        public a(b bVar) {
            this.f6290a = bVar;
        }

        public a a(Map<String, String> map) {
            this.f6292c = map;
            return this;
        }

        public a a(String str) {
            this.f6293d = str;
            return this;
        }

        public a b(Map<String, Object> map) {
            this.f6294e = map;
            return this;
        }

        public ad a(ae aeVar) {
            return new ad(aeVar, this.f6291b, this.f6290a, this.f6292c, this.f6293d, this.f6294e, this.f6295f, this.f6296g);
        }
    }

    public String toString() {
        if (this.i == null) {
            this.i = "[" + getClass().getSimpleName() + ": " + "timestamp=" + this.f6284b + ", type=" + this.f6285c + ", details=" + this.f6286d + ", customType=" + this.f6287e + ", customAttributes=" + this.f6288f + ", predefinedType=" + this.f6289g + ", predefinedAttributes=" + this.h + ", metadata=[" + this.f6283a + "]]";
        }
        return this.i;
    }
}
