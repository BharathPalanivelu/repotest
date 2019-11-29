package com.crashlytics.android.a;

final class ae {

    /* renamed from: a  reason: collision with root package name */
    public final String f6297a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6298b;

    /* renamed from: c  reason: collision with root package name */
    public final String f6299c;

    /* renamed from: d  reason: collision with root package name */
    public final String f6300d;

    /* renamed from: e  reason: collision with root package name */
    public final String f6301e;

    /* renamed from: f  reason: collision with root package name */
    public final Boolean f6302f;

    /* renamed from: g  reason: collision with root package name */
    public final String f6303g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    private String m;

    public ae(String str, String str2, String str3, String str4, String str5, Boolean bool, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f6297a = str;
        this.f6298b = str2;
        this.f6299c = str3;
        this.f6300d = str4;
        this.f6301e = str5;
        this.f6302f = bool;
        this.f6303g = str6;
        this.h = str7;
        this.i = str8;
        this.j = str9;
        this.k = str10;
        this.l = str11;
    }

    public String toString() {
        if (this.m == null) {
            this.m = "appBundleId=" + this.f6297a + ", executionId=" + this.f6298b + ", installationId=" + this.f6299c + ", androidId=" + this.f6300d + ", advertisingId=" + this.f6301e + ", limitAdTrackingEnabled=" + this.f6302f + ", betaDeviceToken=" + this.f6303g + ", buildId=" + this.h + ", osVersion=" + this.i + ", deviceModel=" + this.j + ", appVersionCode=" + this.k + ", appVersionName=" + this.l;
        }
        return this.m;
    }
}
