package com.beetalk.sdk;

public class l {

    /* renamed from: a  reason: collision with root package name */
    public static String f5463a = "com.beetalk";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f5464b = true;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f5465c = false;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f5466d = false;

    /* renamed from: e  reason: collision with root package name */
    public static Integer f5467e = 56221;

    /* renamed from: f  reason: collision with root package name */
    public static Integer f5468f = 56300;

    /* renamed from: g  reason: collision with root package name */
    public static int f5469g = 181;
    public static int h = 19;
    public static String i = "gop";
    public static int j = 4353;
    public static boolean k = false;
    public static String l = (m == a.TEST ? "https://testconnect.garena.com" : "https://connect.garena.com");
    private static a m = a.TEST;
    private static String n = "http://testbeepost.beetalkmobile.com";
    private static String o = "http://beepost.beetalkmobile.com";
    private static String p = (m == a.TEST ? n : o);

    public enum a {
        PRODUCTION,
        TEST
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final Integer f5470a = 201069;
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final Integer f5471a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final Integer f5472b = 2;
    }

    public static a a() {
        return m;
    }

    public static String b() {
        return l + "/oauth/guest/register";
    }

    public static String c() {
        return l + "/oauth/guest/token/grant";
    }

    public static String d() {
        return l + "/oauth/token/exchange";
    }

    public static String e() {
        return l + "/oauth/token";
    }

    public static String f() {
        return l + "/oauth/login?";
    }

    public static String g() {
        return l + "/oauth/garena?";
    }

    public static String h() {
        return l;
    }

    public static String i() {
        return l + "/pay";
    }

    public static String j() {
        return i() + "/options/get";
    }

    public static String k() {
        return i() + "/google/init";
    }

    public static String l() {
        return i() + "/google/commit";
    }
}
