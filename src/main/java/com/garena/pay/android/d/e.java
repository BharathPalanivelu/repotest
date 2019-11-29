package com.garena.pay.android.d;

import org.json.JSONException;
import org.json.JSONObject;

public class e {

    /* renamed from: a  reason: collision with root package name */
    String f8213a;

    /* renamed from: b  reason: collision with root package name */
    String f8214b;

    /* renamed from: c  reason: collision with root package name */
    String f8215c;

    /* renamed from: d  reason: collision with root package name */
    String f8216d;

    /* renamed from: e  reason: collision with root package name */
    long f8217e;

    /* renamed from: f  reason: collision with root package name */
    int f8218f;

    /* renamed from: g  reason: collision with root package name */
    String f8219g;
    String h;
    String i;
    String j;

    public e(String str, String str2, String str3) throws JSONException {
        this.f8213a = str;
        this.i = str2;
        JSONObject jSONObject = new JSONObject(this.i);
        this.f8214b = jSONObject.optString("orderId");
        this.f8215c = jSONObject.optString("packageName");
        this.f8216d = jSONObject.optString("productId");
        this.f8217e = jSONObject.optLong("purchaseTime");
        this.f8218f = jSONObject.optInt("purchaseState");
        this.f8219g = jSONObject.optString("developerPayload");
        this.h = jSONObject.optString("token", jSONObject.optString("purchaseToken"));
        this.j = str3;
    }

    public String a() {
        return this.f8213a;
    }

    public String b() {
        return this.f8214b;
    }

    public String c() {
        return this.f8216d;
    }

    public String d() {
        return this.f8219g;
    }

    public String e() {
        return this.h;
    }

    public String f() {
        return this.i;
    }

    public String g() {
        return this.j;
    }

    public String toString() {
        return "PurchaseInfo(type:" + this.f8213a + "):" + this.i;
    }
}
